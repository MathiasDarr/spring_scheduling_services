"""
This script creates a providers table and populates it

"""

"""
This script populates an Apache Cassandra table with product information
"""
import os
import csv

from utilities.cassandra_utilities import createCassandraConnection, createKeySpace
from utilities.query_utilities import execute_query

dbsession = createCassandraConnection()
createKeySpace("ks1", dbsession)
try:
    dbsession.set_keyspace('ks1')
except Exception as e:
    print(e)

create_patients_department_table = """CREATE TABLE IF NOT EXISTS patients(
    patient_id int, 
    first_name text,
    last_name text,
    PRIMARY KEY(patient_id)
);"""

dbsession.execute(create_patients_department_table)

insert_provider_department = """INSERT INTO patients(patient_id, first_name,last_name) VALUES(%s,%s,%s);"""


def insert_patient(patient):
    dbsession.execute(insert_provider_department, [int(patient['patient_id']), patient['first_name'], patient['last_name']])


PROVIDERS_CSV_FILE = 'data/patients/patients.csv'

with open(PROVIDERS_CSV_FILE, newline='') as csvfile:
    reader = csv.DictReader(csvfile)
    for row in reader:
        print(row)
        insert_patient(row)
