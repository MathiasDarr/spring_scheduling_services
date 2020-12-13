import os
import csv

from utilities.cassandra_utilities import createCassandraConnection, createKeySpace

dbsession = createCassandraConnection()
createKeySpace("ks1", dbsession)
try:
    dbsession.set_keyspace('ks1')
except Exception as e:
    print(e)

create_drivers_department_table = """Create table IF NOT EXISTS drivers(
    user_id text, 
    PRIMARY KEY(user_id)
);"""

dbsession.execute(create_drivers_department_table)
insert_trip_data_point = """INSERT INTO drivers(user_id) VALUES(%s);"""

PROVIDERS_CSV_FILE = 'data/drivers/drivers.csv'
with open(PROVIDERS_CSV_FILE, newline='') as csvfile:
    reader = csv.DictReader(csvfile)
    for row in reader:
        dbsession.execute(insert_trip_data_point, [row['driver_id']])
