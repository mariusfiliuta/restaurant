##	Documentatie FoameNBot

  Aplicatia este destinata staffului unui restaurant. Aceasta inglobeaza majoritatea functionalitatilor unui software ce este utilizat de angajatii unui restaurant(chelneri, manager).
	Aplicatia este bazata pe exitenta userilor de 2 tipuri: useri cu acces normal(ptr chelneri) si admini(manageri) cu acces complet asupra tuturor optiunilor oferite de software.
  
#	Accesul conturilor de user
  
  -	Posibilitatea de a vizualiza meniul de categorii si meniul produselor
  -	Posibilitatea de a crea un nou entry in pagina de booking pentru rezervari
  -	Posibilitatea de a crea o noua comanda si de a vizualiza toate comenzile active existente dar fara a avea acces la alte comenzi exceptand cele ale lui
  -	Posibilitatea de a vizualiza istoricul de comenzi

#	Accesul conturilor de admin
  - Accesul tuturor optiunilor userului
  -	Posibilitatea de a adauga produse si de a gestiona ingredientele necesare produselor
  -	Posibilitatea de a adauga atat conturi de user cat si de admin
  -	Posibilitatea de a adauga ingrediente in stockul restaurantului
  -	Posibilitatea de a modifica orice comanda existenta indiferent de cine este creata

#	Tehnologiile folosite 
Limbajul principal folosit este java. Aplicatia este facuta cu ajutorul frameworkului Spring ce a ajutat in crearea automata a dependintelor intre componentele aplicatiei si realizarea legaturilor dintre Model View si Controller. Software-ul este creat sub forma unei aplicatii web si sunt folosite metodele GET/POST pentru a face transferul informatiilor intre paginile de acces. Pentru a aduce toate tehnologiile folosite in realizarea software-ului au fost aduse cu ajutorul tool-ului maven ce poate fi folosit in crearea oricarei aplicatii bazate pe java cu ajutorul caruia se pot introduce toate informatiile in fisierul pom.xml iar acesta realizeaza toate migrarile direct in aplicatie.

#	View
Crearea view-ului a fost realizata folosind XHTML, CSS, Bootstrap si JavaScript(JQuery). Preluarea informatiilor din Backend spre Frontend si viceversa a fost realizata cu ajutorul template-ului Thymeleaf ce poate fi integrat in XHTML.

#	Baza de date
Baza de date a fost facuta cu ajutorul mysql-ului. Vizualizarea efectiva a bazei de date este facuta prin intermediul programului mysql workbench, program ce a fost folosit doar in realizarea bazei de date si vizualizarea ei si nu are efect asupra clientului. Aplicatia isi creaza singur baza de date la prima rulare a acesteia cu ajutorul API-ului Flyway ce preia informatiile oferite in fisiere de .sql create in aplicatie si realizarea migrari asupra bazei de date iterand fisierele dupa formatul prestabilit.	

#	Model
Pentru modelarea entitatilor din baza de date in Backend a fost folosit API-ul JPA hybernate ce realizarea query-uri pe baza de date si mapeaza resultatele acestora pe obiecte create dupa Model-ul fiecarei tabele. Pentru aplicarea operatiilor pe baza de date sunt create Servicii ce sunt mapate pe Modelele create si folosesc actiunile definite in Repository-urile Modelelor ce mapeaza query-uri prestabilite de fiecare functie in parte.

#	Integritatea Codului
Aplicatia a fost legata de un repository de GitHub. Programul folosit pentru realizarea actiunilor pe acest repository este SourceTree ce ajuta la realizarea de Push/Pull pe aplicatie si rezolvarea eventualelor conflicte de cod astfel incat a permis impartirea taskurilor fara a strica integritatea aplicatiei pe timpul modificarilor si adaugarilor in cod.
  
#	Securitate
Aplicatia a necesitat o securitate pentru diverse functionalitati ale acesteia. Cu ajutorul Spring Security a fost realizata diferenta dintre accesibilitatile conturilor de user de cele de admin, encriptarea parolelor astfel incat parolele pot fi doar criptate dar nu si decriptate astfel incat nu este posibila aflarea parolelor unui cont. Cu ajutorul template-ului Thymeleaf s-a obtinut o securitate pe view asupra input-urilor scrise de catre client pentru a nu se putea folosi decat de cele prestabilite.

#	Aspectul Bazei de date
![alt tag](http://puu.sh/s46Dz/9ee6a0eb50.png)
