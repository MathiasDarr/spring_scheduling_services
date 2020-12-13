import psycopg2
import csv
def get_postgres_connection():
    conn = psycopg2.connect(host="localhost", port="5432", user="postgres", password="postgres", database="postgres")
    return conn

conn = get_postgres_connection()
cur = conn.cursor()


create_patients_table = """
        CREATE TABLE patients (
                patient_id VARCHAR(50) PRIMARY KEY,
                first_name VARCHAR(30),
                last_name VARCHAR(30),
                age int
        );
"""

cur.execute(create_patients_table)
conn.commit()

create_providers_table = """
        CREATE TABLE providers (
                provider_id VARCHAR(50) PRIMARY KEY,
                first_name VARCHAR(30),
                last_name VARCHAR(30),
                title VARCHAR(30),
                department VARCHAR(30)
        );
"""


cur.execute(create_providers_table)
conn.commit()







insert_into_patients_table="""INSERT INTO patients(patient_id, first_name, last_name, age) VALUES(%s,%s,%s, %s);"""
PATIENTS_CSV_FILE = 'data/patients/patients.csv'
with open(PATIENTS_CSV_FILE, newline='') as csvfile:
    reader = csv.DictReader(csvfile)

    for row in reader:
        cur.execute(insert_into_patients_table, [row['patient_id'], row['first_name'], row["last_name"], row['age']])
conn.commit()

        # dbsession.execute(insert_provider_department, [row['patient_id'], row['first_name'], row['last_name']])



PROVIDERS_CSV_FILE = 'data/providers/providers.csv'
insert_into_providers_table="""INSERT INTO providers(provider_id, first_name, last_name, title, department) VALUES(%s,%s,%s,%s,%s);"""
with open(PROVIDERS_CSV_FILE, newline='') as csvfile:
    reader = csv.DictReader(csvfile)

    for row in reader:
        cur.execute(insert_into_providers_table, [row['provider_id'], row['first_name'], row["last_name"], row['title'], row['department']])
conn.commit()



# if __name__ =='__main__':
#     populate_patients_table()
