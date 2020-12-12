## One to many ##
James, Rodger, Becky -> Family Medicine department
Create table department(
    provider_id int, 
    provider_name text,
    department_name text
);


INSERT INTO patients_appointments(patient_id, appointment_time, provider_id, length) VALUES('patien1', '2018-04-26 14:59', 'provider1',60)


Ideal Cassandra Use Cases
-Writes exceed reads by a large margin
- Data is rarely upldated and when updates are made they are idemptoent
- read access is by a known primary key
- data can be partitioned via a key that allows the databbase to be spread evenly across multiple nodes
- no need of joins or aggregates 


Good Use Cases
- Transcation logging: purchases
- Time series data
- storhing health tracker data

