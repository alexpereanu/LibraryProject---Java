**1. Descrierea problemei**
	
Scopul aplicatiei este de a implementa managementul unei biblioteci. Acest lucru inseamna ca biblioteca noastra va avea 3 useri: adminul, bibliotecarul si clientul. Adminul va fi acel user care poate creea carti noi, poate creea noi posturi de bibliotecar si ii va asigna fiecarui bibliotecar o lista de carti de care bibliotecarul va trebui sa se ocupe. Clientul este userul care isi va dori sa imprumute o carte. Prima data se va verifica de catre bibliotecar daca numele cartii dorite se afla in biblioteca, iar daca se afla pe baza numarului de copii disponibile va putea sa imprumute respectiva carte.

Pentru moment am implementat modulul Book cu toate functionalitatile ei. In acest fel m-am obisnuit cu mediul de lucru si va urma sa implementez Adminul, Userul si Clientul. Daca imi permite timpul imi doresc sa fac un Login decent.

**2.API si FRAMEWORKURI folosite**

Ca si mediul de lucru folosesc InteliiJ, Java SpringBoot. SpringBoot simplifica creearea de aplicatii de productie fiind foarte rapid, mult mai general si foarte specific. Pe langa SpringBoot am folosit Java Persistance API care este specificatia unei interfete care descrie managementul datelor relationale. CU JP API am reusit foarte rapid sa fac conexiunile intre aplicatia mea si baza de date folosind metodele CRUD (CREATE READ UPDATE DELETE). Pe langa acestea am mai folosit si Framework-ul Hiberante care este un framework folositor pentru maparea relationala obiect cu obiect si ofera un cadru pentru maparea unui model de domeniu orientat pe obiecte intr-o baza de date relationala. Pentru 
baza de date s-a folosit MySqlWorkbench.


**2.1 Solutia aplicatiei **
Solutia oferita pentru realizarea aplicatiei este a avea o baza de date prin care sa stocam administratorii, clientii si biblioteca. In partea de front-end putem sa executam interogarile pe tabele, interogari care sunt realizate
in partea de back-end. Pentru partea de front-end se va folosi React si Vue iar pentru partea de back-end se va folosi Java + Spring.

**3. Implementare**
Proiectul este structurat in 6 pachete, fiecare pachet continand clasele care indeplinesc aceeasi functionalitate. Proiectul este creat de tip Maven, iar pentru a putea face legatura cu baza de date s-au creat doua fisiere:
un fisier pom.xml care contine toate dependintele necesare functionarii proiectului si un fisier numit application.properties care contine proprietatile serverului care tine baza de date.
Pachetul model contine clasele entitate care stau la baza creeari proiectului, pachetul repository contine repository-ul fiecarei entitati necesare aplicatiei noastre, mai exact JPA Repository, pachetul util contine clasele
care implementeaza cele 2 design pattern-uri cerute, Observer si FactoryPattern, pachetul validity contine clase care se ocupa de validarea datelor unor metode iar pachetul controller contine controller-ele entitatilor 
necesare in realizarea proiectului, pachetul fiind si cel mai stufos din partea de backend.


#BookController, ClientController, LibraryController
Aceste clase contin implementarile metodelor din interfetele din pachetul repository si manipuleaza datele din tabele. Ele contin metode care cauta obiectele din baza de date dupa un anume Id, Nume ori titlu, fac inserari in baza de
date, delete-uri, update-uri. Adnotarile sunt foarte importante, in special @RestController care ne indica faptul ca acea clasa are comportamentul unui controller. Legaturile dintre aplicatie si codul Java se fac prin intermediul acestor adnotari.



#BookRepository, ClientRepository, LibraryRepository
Aceste interfete extind clasa JpaRepository si inseamna ca ele au cateva metode implementate by default. Aceste clase fac parte din pachetul repository

#Book, Client, Library
Aceste clase se afla in pachetul model si sunt reprezentarea entitatilor folosite in cadrul controller-elor. Ele au adnotarile specifice @Table, @Entity si mai au variabile, constructori, get-ere si set-ere.

#Observer, User, UserFactory
Aceste clase fac parte din pachetul util si reprezinta implementarea design pattern-urilor cerute, repsectiv Observ si FactoryPattern.
**
**4. Interfata grafica**

Interfata grafica am ales s-o fac in WEB folosind tool-urile aferente. Nu este o aplicatie foarte
complexa, este ceva simplut dar am indeplineste task-ul principal al temei, adica acela de a
consuma toate serviciile create in partea de backend.
Pentru inceput s-a creat folderul frontendPS care contine toate fisierele HTML, JS si CSS
aferente implementarii proiectului. Cu HTML se face partea de design a paginii iar in interiorul
codului HTML se pune un link, o redirectare catre un fisier JavaScript care implementeaza
anumite functionalitati folosind tool-ul JQuery si AJAX. CSS este folosit foarte putin, el fiind
pentru style, acesta fiind folosit doar la design-ul paginii de login si la design-ul tuturor
butoanelor existente in aplicatia mea. 

Am creat mai multe fisiere HTML si JS, respectiv carti.html, clienti.html, library.html, login.html
Fiecare pagina corespunde unor actiuni. Spre exemplu, pagina carti.html este destinata
afisarii cartilor existente si pentru creearea unei noi carti. Pagina clienti este pagini aferenta
clientului, library, etc.

**4.1 Cum functioneaza interfata grafica**
In primul rand se ruleaza aplicatia de backend. Dupa ce aceasta ruleaza cu succes, se intra
pe pagina login.html si de acolo incepe rularea propriu-zisa a aplicatie. In cazul in care dorim
sa ne logam ca admin trebuie sa introducem datele "admin" si parola "admin" si vom fi redirectionati
catre pagina library.html acolo unde vom vedea lista de carti imprumutate si de catre cine au fost
acestea imprumutate. De aici, in calitate de admin, avem acces sa adaugam noi carti in biblioteca,
sa stergem carti existente, sa adaugam noi clienti, sa stergem clienti, sa cream inchirieri, 
sa stergem inchirieri de carti, etc. 

In schimb, daca dorim sa ne logam ca un client, trebuie sa introducem doar username-ul in 
cadrul logarii. Fiecare client se logeaza doar cu numele sau, nu este nevoie sa introduca
o parola. Desigur, acest lucru nu este foarte sigur si aplicatia trebuie foarte mult imbunatatita
pe partea de securitate. 

**5. Concluzie

Scopul acestei aplicatii este de a automatiza librariile. Nu este o aplicatie complexa, dar
detine o baza de date in spate ce poate fi folosita pentru a stoca carti, clienti, imprumuturi
de carti, etc.


