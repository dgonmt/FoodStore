# FOODSTORE

En enkel web-shop som säljer livsmedel.
***    
#### BESKRIVNING  
  
Projektet består av två delar. En kundsida och en adminsida. Börjar med att göra ett  
val av profil, kund eller admin. Därefter derigeras hen om till en inloggningssida som  
för den valda profilen.
***
**Klientsidan:**  
- Klienten använder ett inloggningsformulär som kontrollerar om angivna användarnamn  
och lösenord finns i databasen. Om det är så att användarnamnet och lösenrodet redan finns,  
då kopplas orden till den påloggade användaren. Är det så att användarnamnet eller lösenordet  
inte finns i databasen, då skapas en ny användare.
- Kunden kan filtrera fram 4 olika kategorier av livsmedel eller söka på specifika produkter  
för att lägga till de i varukorgen.
- Varukorgen redovisar alla inlagda produkter, deras antal och pris. Längs ned i varukorgen redovisas   
totalsumman för hela varujorgen.
- Kunden kan justera antal för varje produkt och ta bort produkter ur varukorgen.  
- En knapp längs ned i varukorgen checkar ut order vilket betyder att den skapar en order  
i databasen.
- Ordern representeras av 2 st. tabeller. Orders och OrderLine. Varje order har ett order id,  
kund id och status. Defaultvärdet på status är <code>false</code>.  

**Adminsidan:**  
- Admin loggar in, om admin redan finns dirigeras hen vidare till admin-sidan med 3 alternativ, om hen inte finns med dirigeras hen tillbaka till logg in sidan.
- På admin-sidan får admin tre alternativ: "New product", "Unhandled orders", "Handled orders".
- På sidan "New product" kan admin lägga in eller uppdatera befintliga produkter.
- På sidan "Unhandled orders" kan admin markera en obehandlad order som behandlad.
- På sidan "Handled orders" kan admin få se hanterade ordrar.

***  
#### INSTRUKTIONER
1. Kör <code>git clone [URL till detta repo] </code> i en valfri mapp
2. Kör <code>docker-compose up</code> (Förutsätter att du har docker-compose installerad)
3. Öppna projektet och kör projektet med valfri editerare
4. Surfa in på http://localhost:8080
***

