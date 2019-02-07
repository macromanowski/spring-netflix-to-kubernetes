package it.romanowski.snd.players.service;

import it.romanowski.snd.players.exception.ResourceNotFoundException;
import it.romanowski.snd.players.model.Player;
import it.romanowski.snd.players.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlayersService {

    private final PlayersRepository playersRepository;

    @Autowired
    public PlayersService(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    public Collection<Player> findAll() {
        return playersRepository.findAll();
    }

    public Player findById(String id) {
        return playersRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    public Player savePlayer(Player player) {
        return playersRepository.save(player);
    }
}
