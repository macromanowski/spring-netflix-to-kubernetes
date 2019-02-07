package it.romanowski.snd.players.repository;

import it.romanowski.snd.players.model.Player;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersRepository extends CassandraRepository<Player, String> {
}
