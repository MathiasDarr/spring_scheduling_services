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
from utilities.query_utilities import execute_query

dbsession = createCassandraConnection()
createKeySpace("ks1", dbsession)
try:
    dbsession.set_keyspace('ks1')
except Exception as e:
    print(e)

create_provider_department_table = """Create table IF NOT EXISTS provider_department(
    provider_id text, 
    provider_first_name text,
    provider_last_name text,
    department_name text,
    PRIMARY KEY(department_name, provider_id)
);"""

dbsession.execute(create_provider_department_table)

insert_provider_department = """INSERT INTO provider_department(provider_id, provider_first_name,provider_last_name, department_name) VALUES(%s,%s,%s,%s);"""


def insert_provider_department_row(provider):
    dbsession.execute(insert_provider_department,
                      [provider['id'], provider['first_name'], provider['last_name'], provider['department']])


# Create a list of .csv files
PROVIDERS_CSV_FILE = 'data/providers/providers.csv'

with open(PROVIDERS_CSV_FILE, newline='') as csvfile:
    reader = csv.DictReader(csvfile)
    for row in reader:
        print(row)
        insert_provider_department_row(row)
