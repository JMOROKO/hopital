<h1>Spring MVC</h1>
<h2>Configution de devTools</h2>
1- Ouvrir fichier
<img src="assets/dev-tools/1-init-config-dev-tools.png" alt="">
2- Cliquer sur paramètre avancé
<img src="assets/dev-tools/2-parametre-avance.png" alt="">
3- Cocher allow auto-*make to start
<img src="assets/dev-tools/3-cocher-allow-auto-make-to-start.png" alt="">
4- Dérouler sur build, Execute, deploy
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
<b>4- Mise en place de la pagination</b>
<b>4.1- Modification de patientContoller</b>
<img src="assets/app/4-patient-controller-avec-pagination.png" alt="">
<p>Ici il est demandé à spring d'afficher la première page mais il faut qu'il affiche les 4 premières données de la base de données</p>
<b>4.2- Affichage de la page avec la pagination</b>
<img src="assets/app/4.2-affichage-page-avec-pagination.png" alt="">
<i>Pourtant nous avons 12 lignes dans la base de données</i>
<img src="assets/app/4.2.1-lignes-bdd.png" alt="">
<b>5- Affichage de la page en utilisant des paramètres</b>
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