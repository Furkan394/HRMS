# HRMS

## :briefcase: Human Resources Management System

The Hrms data model is designed and included in the repo. The project is under development. The project will be developed in accordance with the S.O.L.I.D software principles. With the first run, api test was performed using Swagger and data extraction from the database was checked. Java and Java technologies (such as Spring) will be used on the backend and React will be used on the frontend. PostgreSQL has been chosen as the database.

Dependencies: <br>
-Spring Boot DevTools <br>
-Spring Web <br>
-Spring Data JPA <br>
-PostgreSQL Driver <br>
-Lombok

### :pushpin: Requirement 1: Jobseekers must be able to register in the system.

:receipt: The registered user's name, surname, TR Identity Number, year of birth, e-mail address, password, password repeat information.<br>
:receipt: All fields are required. The user is informed.<br>
:receipt: "Mernis" verification is done, and the system is registered.<br>
:receipt: If the validation is not valid, the user is notified.<br>
:receipt: If there is a previously registered e-mail or TR Identity number, the registration will not take place. The user is informed.<br>
:receipt: Email verification is required for registration to occur.<br>

### 📌 Requirement 2: Employers must be able to register in the system.

:receipt: During registration, the user is asked for company name, website, e-mail with the same domain as the website, phone, password, password repeat information. The purpose here is to prevent non-companies from joining the system.<br>
:receipt: All fields are required. The user is informed.<br>
:receipt: Company records are verified in two ways. Email verification is required for registration to occur. Approval from HRMS staff is required.<br>
:receipt: If there is a previously registered e-mail, the registration will not take place. The user is informed.<br>

### 📌 Requirement 3: General job position names should be added to the system. For example: Software Developer, Java Developer.

:receipt: These positions cannot be repeated. The user is warned.<br>

### 📌 Requirement 4: Employers should be able to be listed.
### 📌 Requirement 5: Jobseekers should be able to be listed.
### 📌 Requirement 6: Job positions should be listed.
### 📌 Requirement 7: Employers should be able to add job postings to the system.

In the job posting form;<br>
🧾 General job position can be selected from the dropdown list. (For example, Java Developer) (Required)<br>
🧾 Job description entry should be possible. (For example, our company has command of languages such as JAVA, C#, etc.....)(Required)<br>
🧾 City information should be able to be selected from the drop-down list. (Required)<br>
🧾 It should be possible to enter min-max for the salary scale. (Optional)<br>
🧾 It should be possible to enter the number of open positions. (Required)<br>
🧾 The application deadline must be entered.<br>

### 📌 Requirement 8: All active job postings in the system should be listed.
🧾 The list must come in tabular form.<br>
🧾 Company, general job position name, number of open positions, publication date, deadline should be in the list.<br>

### 📌 Requirement 9: All active job postings in the system should be listed by date.

🧾 The list must come in tabular form.<br>
🧾 Company, general job position name, number of open positions, publication date, deadline should be in the list.<br>

### 📌 Requirement 10: All active job postings of a company should be listed in the system.

🧾 The list must come in tabular form.<br>
🧾 Company, general job position name, number of open positions, publication date, deadline should be in the list.<br>

### 📌 Requirement 11: Employers should be able to close a posting in the system. (Passive job posting)
### 📌 Requirement 12: Candidates should be able to enter their CV into the system.

🧾 Candidates should be able to add their schools to the system. (School name, department)<br>
🧾 The years in which they studied in these schools should be entered into the system.<br>
🧾 If he/she has not graduated, the graduation year should be blank.<br>
🧾 The schools attended by the candidates should be in reverse order according to the graduation year. If not graduated, this school should be displayed at the top and as "in progress".<br>
🧾 Candidates must enter their work experience. (Workplace name, position)<br>
🧾 The years of these experiences should be entered into the system.<br>
🧾 If he/she is still working, the year of leaving should be blank.<br>
🧾 Candidates' experience should be in reverse order by year. If it is still running, this experience should still be displayed at the top and as "in progress".<br>
🧾 Candidates should be able to enter the foreign languages they know into the system.<br>
🧾 Candidates must be able to enter photos into the system. The photo of the candidate will be kept in the https://cloudinary.com/pricing system. (External service integration) Use the free account.<br>
🧾 Candidates should be able to enter their GitHub addresses in the system.<br>
🧾 Candidates should be able to enter their LinkedIn addresses into the system.<br>
🧾 Candidates should be able to enter the programming languages or technologies they know into the system. (Programming/Technology name) For example; React<br>
🧾 Candidates should be able to add a cover letter to the system. (For example: I like working very much....)<br>

### 📌 Requirement 13: All CV information of a candidate should be displayed.
