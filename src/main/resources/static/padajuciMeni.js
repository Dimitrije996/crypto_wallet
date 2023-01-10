const pomeriMeni = ()=>{
    const padajuciMeni = document.querySelector('.padajuciMeni');
    const nav = document.querySelector('.navUl');
    const fraza = document.querySelector('.fraza');
    const table = document.querySelector('.table');
    const novcic = document.querySelector('.coin');
    const novcanik = document.querySelector('.novcanik');
    const  naslov = document.querySelector('.h1');
    const  naslov1 = document.querySelector('.tabeleGrupacija');
    const logo = document.querySelector('.pozadina');

    const upravljanjeSredstvima = document.querySelector('.container')
    const forma = document.querySelector('.forms');

    const obavestenjaH1 = document.querySelector('.obavestenjeH1');


    const obavestenja = document.querySelector('.obavestenja');


    padajuciMeni.addEventListener('click', ()=>{
        nav.classList.toggle('navY');

        //Ovaj deo koda ce se izvrsiti samo u slucaju kada otvorimo stranicu sa datim url-om
        //jer bez if petlje javaskript izbacuje gresku ako na nekoj stranici nema odredjenih elemenata koje smo definisali
        if (document.URL == 'http://localhost:8080/adminHome' || document.URL == 'http://localhost:8080/editorHome' || document.URL == 'http://localhost:8080/korisnikHome'){
                table.classList.toggle('sakrijElemente');
                naslov.classList.toggle('sakrijElemente');
                naslov1.classList.toggle('sakrijElemente');
                novcanik.classList.toggle('sakrijElemente');
                upravljanjeSredstvima.classList.toggle('sakrijElemente');
                obavestenja.classList.toggle('sakrijElemente');
                obavestenjaH1.classList.toggle('sakrijElemente');

        }

        if (document.URL == 'http://localhost:8080') {
            logo.classList.toggle('.preurediPozadinu')
        }
    })
}
pomeriMeni();
