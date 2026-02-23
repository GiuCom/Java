# Guida ai Contributi

Grazie per il tuo interesse a contribuire! Questo progetto raccoglie **implementazioni in Java di Design Patterns** (GoF e oltre) con esempi didattici, test e documentazione.

Questa guida spiega **come proporre modifiche**, **aprire issue**, **scrivere codice**, **aggiungere test** e **mantenere coerenza** nello stile e nella struttura del repository.

---

## Sommario
- [Codice di condotta](#codice-di-condotta)
- [Prerequisiti](#prerequisiti)
- [Setup ambiente di sviluppo](#setup-ambiente-di-sviluppo)
- [Struttura del repository](#struttura-del-repository)
- [Regole di stile e qualità](#regole-di-stile-e-qualità)
- [Linee guida specifiche per i Design Pattern](#linee-guida-specifiche-per-i-design-pattern)
- [Aprire una Issue](#aprire-una-issue)
- [Flusso Git e Branching](#flusso-git-e-branching)
- [Messaggi di commit (Conventional Commits)](#messaggi-di-commit-conventional-commits)
- [Pull Request](#pull-request)
- [Test](#test)
- [Documentazione e Javadoc](#documentazione-e-javadoc)
- [Sicurezza](#sicurezza)
- [Licenza e Copyright](#licenza-e-copyright)

---

## Codice di condotta
La community deve rimanere **accogliente e rispettosa**. Partecipando, accetti di rispettare il nostro **Codice di Condotta**.

- Vedi: `CODE_OF_CONDUCT.md` (se assente, proponine uno con il modello Contributor Covenant).

Se noti comportamenti inappropriati, apri una issue con il tag `conduct` oppure contatta i maintainer.

---

## Prerequisiti
- **Java**: 17 o superiore (LTS)
- **Build tool**: Maven **oppure** Gradle
- **Gestione stile/qualità**: Checkstyle, SpotBugs, EditorConfig
- **Test**: JUnit 5, Mockito, JaCoCo per coverage
- **UML opzionale**: PlantUML per diagrammi

> Se proponi una feature che richiede librerie nuove, discutila prima in una issue.

---

## Setup ambiente di sviluppo

### 1) Clona e prepara
```bash
# fork sul tuo account, poi:
git clone https://github.com/<tuo-utente>/<nome-repo>.git
cd <nome-repo>
```

### 2) Importa nel tuo IDE
- IntelliJ IDEA (consigliato) o Eclipse/VS Code con estensioni Java.
- Abilita **EditorConfig**.

### 3) Costruisci ed esegui test
**Maven**
```bash
mvn -v
mvn clean verify
```
**Gradle**
```bash
gradle -v
gradle clean build
```

Se falliscono i check di stile/qualità, vedi la sezione successiva.

---

## Struttura del repository
Esempio (indicativo):
```
/.
├── patterns/
│   ├── creational/
│   │   └── singleton/
│   │       ├── src/main/java/...  # implementazione
│   │       ├── src/test/java/...  # test JUnit
│   │       └── README.md           # spiegazione del pattern
│   ├── structural/
│   └── behavioral/
├── docs/                           # guide, UML, note
├── build/                          # configurazioni comuni (Checkstyle, SpotBugs)
├── .editorconfig
├── pom.xml | build.gradle
├── CONTRIBUTING.md
└── CODE_OF_CONDUCT.md
```

> Ogni pattern vive in un **modulo/cartella dedicata**, con **README.md** e **test**.

---

## Regole di stile e qualità

### Stile Java
- **Google Java Style** (o lo standard definito dal progetto). Usa il formatter dell'IDE.
- File `.editorconfig` per regole coerenti tra editor.

### Linting & static analysis
- **Checkstyle**: il build deve passare. Per eseguire:
  - Maven: `mvn checkstyle:check`
  - Gradle: `gradle checkstyleMain checkstyleTest`
- **SpotBugs**: nessun bug di alta priorità.
  - Maven: `mvn spotbugs:check`
  - Gradle: `gradle spotbugsMain spotbugsTest`

### Coverage
- **JaCoCo**: copertura minima **80%** sui nuovi/modificati.
  - Maven: `mvn test jacoco:report`
  - Gradle: `gradle jacocoTestReport`

### Performance & complessità
- Evita complessità ciclomatica eccessiva (target < 10 per metodo).
- Preferisci composizione a ereditarietà quando possibile.

---

## Linee guida specifiche per i Design Pattern

1. **Naming**
   - Pacchetti: `it.<org>.<repo>.patterns.<categoria>.<pattern>` (es. `it.example.dp.patterns.creational.singleton`).
   - Classi principali con nomi canonici (es. `Singleton`, `AbstractFactory`, `Observer`).

2. **Struttura**
   - Mantieni l'**interfaccia del pattern** chiara (ruoli: `Product`, `Creator`, `Observer`, `Subject`, ecc.).
   - Includi **varianti** (thread-safe, lazy/eager, ecc.) se rilevanti, con benchmark o note.

3. **Documentazione del pattern**
   - In `README.md` del modulo includi:
     - **Intento** del pattern
     - **Motivazione** e contesto d'uso
     - **Diagramma UML** (PlantUML consigliato)
     - **Esempio minimale** e **anti-pattern comuni**
     - **Pro e Contro**, **Trade-off**, **Implicazioni di concorrenza**

4. **Esempi d'uso**
   - Fornisci una **classe demo** o test che mostrino l'uso end-to-end.

5. **Compatibilità**
   - Evita dipendenze superflue. Le implementazioni devono essere **auto-contenute**.

---

## Aprire una Issue
Prima cerca tra le issue esistenti. Se non c'è, apri una nuova usando i **template**.

### Tipi di issue
- `bug`: malfunzionamenti
- `enhancement`: miglioramenti/feature
- `documentation`: doc, esempi, UML
- `pattern-proposal`: proposta di nuovo pattern/variante

### Informazioni minime
- Versione Java e OS
- Passi per riprodurre (se bug)
- Contesto e motivazione (se proposta)
- Output di build/test rilevante

---

## Flusso Git e Branching
- **Branch principali**: `main` (stabile), `develop` (in sviluppo) — opzionale.
- **Feature branches**: `feat/<breve-descrizione>`
- **Fix branches**: `fix/<breve-descrizione>`
- **Refactor/Docs**: `refactor/...`, `docs/...`

> Mantieni i branch piccoli e focalizzati; punta a PR < ~400 LOC.

---

## Messaggi di commit (Conventional Commits)
Usa il formato:
```
<type>(<scope>): <descrizione>
```
**type**: `feat`, `fix`, `docs`, `style`, `refactor`, `test`, `chore`, `perf`

Esempi:
```
feat(singleton): aggiunta versione thread-safe con double-checked locking
fix(observer): evita memory leak scollegando gli observer in remove()
```

Se la PR introduce breaking changes, aggiungi `BREAKING CHANGE:` nel body.

---

## Pull Request
1. Assicurati che:
   - build, lint, test e coverage **passino**
   - sia presente/aggiornato il **README.md** del pattern
   - ci siano **test JUnit 5** adeguati
   - siano aggiornati i **diagrammi** (se necessari)
2. Collega la PR a una issue: `Closes #<numero>`
3. Compila il **template PR** (motivazione, soluzioni alternative, impatti)
4. Richiedi **almeno 1 review** (2 per cambi breaking)

### Criteri di accettazione
- Aderenza alle linee guida
- Niente regressioni ai test
- Qualità del codice e chiarezza didattica dell'esempio

---

## Test
- **JUnit 5** per unit test; **Mockito** per mocking.
- Ogni pattern deve avere **casi felici** e **casi limite**.
- Testare **concorrente** dove applicabile (es. Singleton thread-safe).
- Eseguire test locali prima della PR:
  - Maven: `mvn clean verify`
  - Gradle: `gradle clean build`

---

## Documentazione e Javadoc
- Fornisci **Javadoc** per classi pubbliche e metodi non banali.
- Nel README del pattern includi snippet **compilabili** (verifica con build di esempio o doctest se configurato).
- Aggiorna `docs/CHANGELOG.md` se la modifica è rilevante.

---

## Sicurezza
- Non includere **segreti** (token, password) nel codice o nella configurazione.
- Segnala vulnerabilità privatamente ai maintainer (security advisory) prima della disclosure pubblica.

---

## Licenza e Copyright
- Contribuendo, accetti che il contributo sia rilasciato sotto la **licenza del repository** (vedi `LICENSE`).
- Se richiesto, conferma la tua paternità con **DCO** (Developer Certificate of Origin) nel trailer del commit: `Signed-off-by: Nome <email>`.

---

## Domande?
Apri una **discussion** o una **issue** con il tag `question`. Siamo felici di aiutarti!
