"""
This script creates a providers table and populates it

"""

"""
This script populates an Apache Cassandra table with product information
"""
# !/usr/bin/env python3
import os
import csv
from utilities.cassandra_utilities import createCassandraConnection, createKeySpace


create_patients_department_table = """CREATE TABLE IF NOT EXISTS patients(
    patient_id text, 
    first_name text,
    last_name text,
    PRIMARY KEY(patient_id)
);"""

insert_provider_department = """INSERT INTO patients(patient_id, first_name,last_name) VALUES(%s,%s,%s);"""

PROVIDERS_CSV_FILE = 'data/patients/patients.csv'


def populate_patients_table():
    dbsession = createCassandraConnection()
    createKeySpace("ks1", dbsession)
    try:
        dbsession.set_keyspace('ks1')
    except Exception as e:
        print(e)
    dbsession.execute(create_patients_department_table)

    with open(PROVIDERS_CSV_FILE, newline='') as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            dbsession.execute(insert_provider_department, [row['patient_id'], row['first_name'], row['last_name']])


if __name__ =='__main__':
    populate_patients_table()
