<h1>Spring MVC</h1>
<h2>Configution de devTools</h2>
1- Ouvrir fichier
<img src="assets/dev-tools/1-init-config-dev-tools.png" alt="">
2- Cliquer sur paramètre avancé
<img src="assets/dev-tools/2-parametre-avance.png" alt="">
3- Cocher allow auto-make to start
<img src="assets/dev-tools/3-cocher-allow-auto-make-to-start.png" alt="">
4- Dérouler sur build, Execute, deploy <br>
5- Cliquer sur compiler
<img src="assets/dev-tools/4-build-compiler.png" alt="">
5- Cocher build project automatically
<img src="assets/dev-tools/5-cocher-build-project-automatically.png" alt="">
<h2>Installation de bootstrap</h2>
1- Recherche de la dépendance et aller sur le site
<img src="assets/bootstrap/1-recherche-dependence.png" alt="">
2- Sélectionner la dernière version 
<img src="assets/bootstrap/2-selection-derniere-version-dependence.png" alt="">
3- Copier la dépendance
<img src="assets/bootstrap/3-copy-de-dependence.png" alt="">
4- Ajouter dans le pom.xml
<img src="assets/bootstrap/4-ajout-pom-xml.png" alt="">
5- Utiliser dans la page html
<img src="assets/bootstrap/5-utilisation-de-bootstrap.png" alt="">
<h2>Utilisation de MySQL</h2>
1- Installation de la dépendance
<img src="assets/mysql/1-installation-dependance.png" alt="">
2- Configuration de mysql
<img src="assets/mysql/2-configuration-mysql.png" alt="">
<h2>Controller patient</h2>
<b>1- Création du controller patient</b>
<img src="assets/app/1-PatientController.png" alt="">
<p>Le controller patient permet de récupérer la liste des patients à partir du repository et la transmet à la page html via l'objet Model de springframework.ui?
grace à l'annotation model.addAttribut </p>
<b>2- Mise en place de la page HTML</b>
<img src="assets/app/2-affichage-liste-patients.png" alt="">
<p>Utilisation des données transmises à la page html depuis le controller via l'attribut "patientList" qui est utilisé pour afficher les donner en faisant une boucle.</p>
<b>3- Affichage de la page</b>
<p>Puisque le port 8084 a été précisé dans le fichier application.properties alors pour voir la page il faut aller sur cet url : http://localhost:8084/index</p>
<img src="assets/app/3-page-sans-pagnation.png" alt="">
<b>4- Mise en place de la pagination</b> <br>
<b>4.1- Modification de patientContoller</b>
<img src="assets/app/4-patient-controller-avec-pagination.png" alt="">
<p>Ici il est demandé à spring d'afficher la première page mais il faut qu'il affiche les 4 premières données de la base de données</p>
<b>4.2- Affichage de la page avec la pagination</b>
<img src="assets/app/4.2-affichage-page-avec-pagination.png" alt="">
<i>Pourtant nous avons 12 lignes dans la base de données</i>
<img src="assets/app/4.2.1-lignes-bdd.png" alt="">
<b>5- Affichage de la page en utilisant des paramètres</b> <br>
<b>5.1- Modification du controller</b>
<img src="assets/app/5.1-modification-controller.png" alt="">
<p>Ici le controller est modifié de tel sorte à permettre à l'utilisateur, via le navigateur de décider le nombre de ligne et la page a afficher</p>
<b>5.2- Demonstration</b>
<i>Affichage de la page 0 avec 5 données</i>
<img src="assets/app/5.2-affichage-page-0-avec-5-data.png" alt="">
<i>Affichage de la page 2 avec 5 données</i>
<img src="assets/app/5.3-affichage-page-2-avec-5-data.png" alt="">
5.3- Initialisation de valeurs de page et size
<p>Grace à @RequestParam nous allons demander a spring d'aller chercher le paramètre page et size dans l'url si on ne trouve rien alors,
nous allons transmettre les valeurs par défaut 0 et 5</p>
6. Pagination <br>
6.1- Html
<img src="assets/app/6.1-pagination.png" alt="">
6.2- Controller
<img src="assets/app/6.2-pagination-controller.png" alt="">
7. Recherche
<img src="assets/app/7.recherche.png" alt="">
8. Suppression 
<img src="assets/app/8.suppression.png" alt="">
9. Rendu
<img src="assets/app/10.rendu.png" alt="">
<h2>Mise en place d'une page template avec thymeleaf</h2>
1- Recherche de la dépendance thymelead layout dialect maven (11)
<img src="assets/app/11-thymeleaf-layout-dialect.png" alt="">
2- Choix de la dernière version
<img src="assets/app/12-choix-derniere-version.png" alt="">
3- Ajout dans le fichier POM.xml
<img src="assets/app/13-ajout-pom-et-regeneration-maven.png" alt="">
4- Création de la page template HTML <br>
<img src="assets/app/template.png" alt="">
5- Ajout des dialect thymeleaf et layout <br>
<img src="assets/app/14-thymeleaf-layout.png" alt="">
6- Ajout de la section ou afficher les autres pages dans le template
<img src="assets/app/15-ajout-section.png" alt="">
7- Utilisation du template dans une autre page
<img src="assets/app/16-utilisation-page-template-autre-page.png" alt="">
<i>Il faut noter que dans layout:decorate="template1", <b>template1</b> fait référence au nom de la page template </i>
8- Determination du contenu à insérer dans la section content1 du template1
<h2>Validation</h2>
1. Installer spring boot validation maven <br>
<img src="assets/app/17-validation.png" alt="">
2. Ajout des annotations de validation <br>
<img src="assets/app/17.1-utilisation-validation.png" alt="">
3. Effectuer la validation avant l'enregistrement <br>
<img src="assets/app/17.2-effectuer-validation-avant-save.png" alt=""> <br>
<i>Ici @Valid permet d'effectuer la validation de l'objet avant l'enregistrement et bindingResult permet de vérifier les erreurs de validation</i>
4. Afficher les erreurs de validation <br>
<img src="assets/app/17.3-affichage-erreur-validation.png" alt="">
<h2>Spring security (In Memory)</h2>
1. Ajout de la dépendance dans le pom.xml
<img src="assets/security/1-ajout-dependence.png" alt="">
2. Utilisation du mot de passe par défaut généré par spring security
<p>Après avoir ajouté la dépendance de sécurité et redémarré l'application.
Un user par défaut et un mot de passe sont généré par spring security puis un formulaire de connection est mis en place.
</p>
3. Première connection 
<p>Pour se connecter, il faut accéder à l'application, nous serons redirigé vers le formulaire d'authentification qui va demander le nom d'utilisateur et un mot de passe</p>
<p>Login: <b>User</b> </p>
<p>Password: <i>Consulter la console à chaque redémarrage</i></p>
<img src="assets/security/2-redemarrer-app.png" alt="">
<img src="assets/security/3-login.png" alt=""> <br>
4. Personnaliser la configuration de spring security <br>
    4.1- Creation du package et de la class de configuration <br>
<img src="assets/security/4-creation-package-et-class-config.png" alt="">
    4.2- Demander à spring security de vérifier l'authenfication avant d'accéder à n'importe quelle page <br>
<img src="assets/security/5-demander-etre-authentifie.png" alt="">
    4.3- Création des utilisateurs dans la mémoire de l'application <br>
<img src="assets/security/6-authentification-inMemory.png" alt="">
<i>{noop} permet de demander à spring de ne pas encoder le password</i>
    4.4- Utilisation du password encoder <br>
<img src="assets/security/7-creation-bean-password-encoder.png" alt="">
<i>Ce bean sera injecté quand on en aura besoin afin de asher les mots de passe</i>
    4.5- Utilisation du password encder
<img src="assets/security/8-encoder-password.png" alt="">
5. Afficher l'utilisateur connecté (Minute 37)