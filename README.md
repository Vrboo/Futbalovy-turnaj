# Futbalový turnaj app
### Desktopová aplikácia s jednoduchým responzívnym GUI (grafickým rozhraním) 

<sub>&nbsp;&nbsp;&nbsp;&nbsp;Pozn.: Spustiteľný súbor aplikácie - classes/artifacts/EsportTurnaj_jar/run-app.bat </sub>  



## Úvod
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Futbalový turnaj je aplikácia, ktorá simuluje futbalový turnaj a jeho priebeh.
Aplikácia počas celého priebehu turnaja informuje používateľa o aktuálnej tabuľke, výsledkoch, programe zápasov, súpiskách tímov a aktuálnom stave odmien.
Turnaj sa hrá na určitý počet kôl a hrá sa formou každý s každým. Výsledky jednotlivých zápasov generuje náhodne aplikácia. 
Na konci turnaja je odmenený každý zúčastnený tím a brankár, a to podľa určených pravidiel (viď nižšie v sekcií Pravidlá turnaja).


## Sprievodca aplikáciou
- Na začiatku aplikácie používateľ vytvorí turnaj - určí názov turnaja a vytvorí tímy, ktoré sa na turnaji zúčastnia.
- Po vytvorení turnaja sa otvorí používateľské prostredie, ktoré bude sprevádzať používateľa počas celého turnaja a informovať ho o 
aktuálnej tabuľka, výsledkoch odohraných zápasov, programe neodohraných zápasov, súpiskách tímov a o priebežnom stave odmien.
  - Tlačítko **Odohrať kolo** - simuluje odohratie nasledujúceho kola (vygenerujú sa výsledky všetkých zápasov nasledujúceho kolo)
  - Tlačítko **Export** - zápíše do súboru "export.txt" aktuálny výpis v textovom poli 
- Po odohratí všetkých kôl je turnaj na konci a určí sa víťaz turnaja.


## Pravidlá turnaja 
### Tímy
- Na turnaji sa môže zúčastniť iba párny počet tímov
- Názvy jednotlivých tímov musia byť rozdielne
- Min. počet tímov na turnaji je 2 (aby sa zaistilo, že v každom kole bude mať každý tím zápas)

### Zápasy
- Turnaj sa hrá formou každý s každým
- Zapasy sa vylosujú do kôl a to tak, aby v každom kole mal každý tím práve jeden zápas

### Tabuľka
- v prípade rovnosti bodov, rozhoduje skóre

### Odmeny
- Brankár - 11.5€ / čisté konto
- Tím - 25€ / bod


## Štruktúry aplikácie

### Tím
Každý tím má:
- názov (max. 5 písmen, kvôli formátovaniu textu)
- členov tímu:
  - **trénera**
  - hráčov:
    - **brankára**
    - **dvoch hráčov v poli (útočník a obranca)**
- štatistiky (počet bodov, výher, remíz, prehier, strelených gólov, inkasovaných gólov)
- sumu (odmenu), ktorú dostane na konci turnaja za počet získaných bodov

<br>

### Tréner
Každý tréner má:
- meno
- trénerskú licenciu (Licencia A, Licencia B, Licencia C) 
 
### Brankár
Každý brankár má:
- meno
- číslo dresu
- počet čistých kont, ktoré sa mu podarilo dosiahnuť
- sumu (odmenu), ktorú dostane na konci turnaja za počet čistých kont

### Hráč v poli
Každý hráč v poli má:
- meno
- číslo dresu
- pozíciu, na ktorej hrá (útočník alebo obranca)
  
 
