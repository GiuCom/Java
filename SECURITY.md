# Security Policy

## Versioni Supportate

Al momento forniamo aggiornamenti di sicurezza per le seguenti versioni:

| Version | Supported          |
| ------- | ------------------ |
| 5.1.x   | :white_check_mark: |
| 5.0.x   | :x:                |
| 4.0.x   | :white_check_mark: |
| < 4.0   | :x:                |

## Segnalazione di una vulnerabilità

La sicurezza del codice è una priorità. Se ritieni di aver trovato una vulnerabilità, ti preghiamo di **non** aprire una Issue pubblica.

### Procedura di invio
Invia una segnalazione dettagliata a: **info@compagno.cloud**

Includi nel messaggio:
- Una descrizione del rischio.
- Passaggi dettagliati per riprodurre il problema (PoC).
- Eventuali suggerimenti per la correzione.

### Cosa aspettarsi
- **Risposta:** Riceverai una conferma di ricezione entro 48 ore.
- **Analisi:** Ti terremo aggiornato sull'avanzamento della risoluzione.
- **Divulgazione:** Una volta risolto il problema, verrà rilasciata una nuova versione e (se applicabile) una CVE.

## Strumenti consigliati
Per i contributori, consigliamo di scansionare le dipendenze Java prima di ogni commit utilizzando:
- `mvn dependency-check:check` (OWASP Dependency-Check)
- `snyk test`
