import psycopg2

def get_postgres_connection():
    conn = psycopg2.connect(host="localhost", port="5432", user="postgres", password="postgres", database="postgres")
    return conn


create_patients_table = """
        CREATE TABLE patients (
                patient_id VARCHAR(30) PRIMARY KEY,
                first_name VARCHAR(30),
                last_name VARCHAR(30),
                age int
        );
"""

conn = get_postgres_connection()
cur = conn.cursor()

cur.execute(create_patients_table)
conn.commit()