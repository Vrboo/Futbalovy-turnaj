# Futbalový turnaj app
### Desktopová aplikácia s jednoduchým responzívnym GUI (grafickým rozhraním) 

<sub>&nbsp;&nbsp;&nbsp;&nbsp;Pozn.: Spustiteľný súbor aplikácie umiestnený - </sub>  

---

## Úvod
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Futbalový turnaj je aplikácia, ktorá simuluje futbalový turnaj a jeho priebeh.
Aplikácia počas celého priebehu turnaja informuje používateľa o aktualnej tabuľke, výsledkoch, programe zápasov, súpiskách tímov a aktuálnom stave odmien.
Turnaj sa hrá na určitý počet kôl a hrá sa formou každý s každým. Výsledky jednotlivých zápasov generuje náhodne aplikácia. 
Na konci turnaja je odmenený každý zúčastnený tím a brankár, a to podľa určených pravidiel (viď nižšie v sekcii Pravidlá turnaja).

---

## Pravidlá turnaja 
### Tímy
- Na turnaji sa môže zúčastniť iba párny počet tímov
- Názvy jednotlivých tímov musia byť rozdielne
- Min. počet tímov na turnaji je 2 (Aby sa zaistilo, že v každom kole bude mať každý tím zápas)

### Zápasy
- Turnaj sa hrá formou každý s každým
- Zapasy sa vylosujú do kôl a to tak, aby v každom kole mal každý tím práve jeden zápas

### Tabuľka
- v prípade rovnosti bodov, rozhoduje skóre

### Odmeny
- Brankár - 11.5€/čisté konto
- Tím - 25€/bod

---

## Sprievodca aplikáciou
Na začiatku aplikácie používateľ vytvorí turnaj - určí názov turnaja a vytvorí tímy, ktoré sa na turnaji zúčastnia.
Po vytvorení turnaja sa otvori používateľské prostredie, ktoré bude sprevádzať používateľa počas celého turnaja a informovať ho o 
aktuálnej tabuľka, výsledkoch odohraných zápasov, programe ešte neodohraných zápasov, súpiskách tímov a o priebežnom stave odmien.
Tlačítko Odohrať kolo - simuluje odohratie nasledujúceho kola (vygenerujú sa výsledky všetkých zápasov nasledujuceho kolo)
Tlačítko Export - zápíše do súboru "export.txt" aktuálny výpis v textovom poli 
Po odohratí všetkých kôl je turnaj na konci a určí sa víťaz turnaja.

---

## Tím
Každý tím má:
- názov (max. 5 písmen, kvôli formátovaniu textu)
- členov tímu
  - trénera
  - hráčov
    - brankára
    - dvoch hráčov v poli (útočník a obranca)
- štatistiky (počet bodov, výher, remíz, prehier, strelených gólov, inkasovaných gólov)
- sumu (odmenu), ktorú dostane na konci turnaja za počet získaných bodov

## Člen tímu
Každý člen tímu má:
- meno

### Tréner
Každý tréner má:
-  trénerskú licenciu (Licencia A, Licencia B, Licencia C) 
 
### Hráč
Každý hráč má
- číslo dresu

#### Brankár
Každý brankár má
- počet čistých kont, ktoré sa mu podarilo dosiahnuť
- sumu (odmenu), ktorú dostane na konci turnaja za počet čistých kont

#### Hráč v poli
Každý hráč v poli má:
- pozíciu, na ktorej hrá (útočník alebo obranca)
  
 
