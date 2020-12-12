"""
This script creates an appointments table and populates it

built in indices are best for tables having many rows that contain the indexed value.  More unique values that exist in a particular column, the more over head you will have on average to query and maintain the index

DO NOT USE AN INDEX
 - high cardinality columns for a query of a huge volume of records for a small number of results
 - tables that youse a counter column
 - frequntly updated or deleted column

High cardinality column w/ many distinct values, a query will incur many seeks for very few results

"""
# !/usr/bin/env python3
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

create_patient_appointments_table = """CREATE TABLE IF NOT EXISTS patients_appointments (
    patient_id text,
    appointment_time timestamp,
    provider_id text,
    length int,
    PRIMARY KEY(patient_id,appointment_time)
); 
"""

insert_patients_appointment_query = "INSERT INTO patients_appointments(patient_id, appointment_time, provider_id, length) VALUES(%s, %s, %s, %s);"

def insert_into_patients_appointments_table(row):
    dbsession.execute(insert_patients_appointment_query,
                      [row['patient_id'], row['appointment_time'], row['provider_id'], row['length']])


dbsession.execute(create_patient_appointments_table)

PROVIDERS_CSV_FILE = 'data/appointments/patient_appointments.csv'

with open(PROVIDERS_CSV_FILE, newline='') as csvfile:
    reader = csv.DictReader(csvfile)
    for row in reader:
        print(row['appointment_time'])
        dbsession.execute(insert_patients_appointment_query,
                          [row['patient_id'], row['appointment_time'], row['provider_id'], int(row['length'])])

