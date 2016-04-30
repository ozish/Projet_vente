
var Categorie = ["Toutes Categories","Vente immobiliere","Location Immobiliere","Informatique","Jeux video","Image et Son","Bricolage"];
var Lieu = ["Ain","Ardeche","Drome","Isere","Loire","Rhone","Savoie","Haute Savoie"];
var tblNom = ["camera","hélicoptere"]


function RemplirListe()
{ 
	var lstCategorie = document.getElementById("ListeCategories");
	var lstLieu = document.getElementById("ListeLieu");
	
	
	function fillCategories(item,index)
	{
		var option = document.createElement("option");
		var val = document.createTextNode(item);
		option.appendChild(val);
		lstCategorie.appendChild(option);
	}
	Categorie.forEach(fillCategories);
	
	function fillLieu(item,index)
	{
		var option = document.createElement("option");
		var val = document.createTextNode(item);
		option.appendChild(val);
		lstLieu.appendChild(option);
	}
	
	Lieu.forEach(fillLieu);
	
	
	//si coté servlet getParam("RetrieveAllObjet"=="true") alors faire un retrieveAll() sur les objets
	function remplirTable(){
		$.get("Servlet_create_objet", {"RetrieveAllObjet":"true"}, function(data, status) {
		
			var objets = JSON.parse(data);//Tranforme une chaine de caracteres au format JSON en un objet javascript (2éme étape)
			
			$.each(objets, function(key, value){
				$("#listeAffichage").prepend("<tr><td>"+value.Designation+"</td><td>"+value.Prix+"</td><td>"+value.Categorie+"</td><td>"+value.Lieu+"</td></tr>");//value.attribut attribut = nom attribut objet java categorie  sans "s" de l'objet Objet
			})
	})};
	remplirTable();
	
}	

function AjoutArticle()
{
	var nom = document.getElementById("txtNom").value ;
	var prenom = document.getElementById("ListeCategories").value ;
	var classe = document.getElementById("txtlieu").value ;
	
	E = new Etudiant(nom,prenom,classe);
	
}

function AjoutNote()
{
   var nom = document.getElementById("txtNom").value ;	
   var prix = parseInt(document.getElementById("txtPrix").value) ;
   var lieu = document.getElementById("lstLieu").value ; 

   E.AjoutNote(nom,prix,lieu) ;
	
AjoutLigneTableau(document.getElementById("tblNom") , valeur , coef , matiere)
	
}

function AjoutLigneTableau(tableau , val , coef , mat)
{
    var ligne = document.createElement("tr");  //crée la balise tr (ligne) mais n'est rattaché nul part
	var cellule = document.createElement("td"); //crée la balise td (colonne) mais n'est rattaché nul part
	var contenu = document.createTextNode(val); //crée le noeud option mais n'est rattaché nul part
	cellule.appendChild(contenu); // on dit a option d'associer item à option en tant qu'enfant
	ligne.appendChild(cellule); // on dit qu'à option est associé la liste
	
    cellule = document.createElement("td");
	contenu = document.createTextNode(coef);
	cellule.appendChild(contenu);
	ligne.appendChild(cellule);
	
	cellule = document.createElement("td");
	contenu = document.createTextNode(mat);
	cellule.appendChild(contenu);
	ligne.appendChild(cellule);



   tableau.appendChild(ligne) ;	
	
}




