DROP KEYSPACE IF EXISTS snd_demo;

CREATE KEYSPACE snd_demo WITH replication = {
  'class': 'SimpleStrategy',
  'replication_factor': 1
};
