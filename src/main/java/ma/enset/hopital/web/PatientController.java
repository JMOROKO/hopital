package ma.enset.hopital.web;

import lombok.AllArgsConstructor;
import ma.enset.hopital.entities.Patient;
import ma.enset.hopital.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/index")
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

    @GetMapping("/delete")
    public String delete(@RequestParam(name="id") Long id, @RequestParam(name="keywords") String keywords, @RequestParam(name="page") int page){
        // @TODO  est ce que @RequestParam est la méthode appelé par défaut ?
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keywords="+keywords;
    }

}
