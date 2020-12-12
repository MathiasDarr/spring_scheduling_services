## One to many ##
James, Rodger, Becky -> Family Medicine department
Create table department(
    provider_id int, 
    provider_name text,
    department_name text
);


INSERT INTO patients_appointments(patient_id, appointment_time, provider_id, length) VALUES('patien1', '2018-04-26 14:59', 'provider1',60)
