package ma.enset.hopital.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/user/index")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page
            , @RequestParam(name = "size", defaultValue = "5") int size
            , @RequestParam(name="keywords", defaultValue = "") String keywords){
        Page<Patient> patientList;
        patientList = patientRepository.findByNomContains(keywords, PageRequest.of(page, size));
        model.addAttribute("pages", new int[patientList.getTotalPages()]);
        model.addAttribute("patientList", patientList.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("keywords", keywords);
        return "patients";
    }

    @GetMapping("/admin/delete")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String delete(@RequestParam(name="id") Long id, @RequestParam(name="keywords") String keywords, @RequestParam(name="page") int page){
        // @TODO  est ce que @RequestParam est la méthode appelé par défaut ?
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keywords="+keywords;
    }

    @GetMapping("/admin/formPatients")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String formPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }

    @PostMapping("/admin/save") //@Valid demande à spring MVC d'effectuer la validation, demander à spring mvc de stocker les erreurs dans bindingResult
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String save(@Valid Patient patient, BindingResult bindingResult
            , @RequestParam(name="page", defaultValue = "0") int page
            , @RequestParam(name="keywords", defaultValue = "") String keywords){
        if(bindingResult.hasErrors()) return "formPatients";
        patientRepository.save(patient);
        return "redirect:/user/index?page="+page+"&keywords="+keywords;
    }
    @GetMapping("/admin/editPatient")
    public String edit(Model model, @RequestParam(name="id") Long id, @RequestParam(name="keywords") String keywords, @RequestParam(name="page") int page) {
        Optional<Patient> patientToEdit = patientRepository.findById(id);
        if(!patientToEdit.isPresent()){
            throw new RuntimeException("Aucun patient retrouvé");
        }
        model.addAttribute("patient", patientToEdit.get());

        model.addAttribute("page", page);
        model.addAttribute("keywords", keywords);
        return "editPatient";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/user/index";
    }

}
