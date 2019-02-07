package it.romanowski.snd.players.controller;

import it.romanowski.snd.players.controller.model.PlayerCreationRequest;
import it.romanowski.snd.players.model.Player;
import it.romanowski.snd.players.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/snd-players")
public class PlayersController {

    private final PlayersService playersService;

    @Autowired
    public PlayersController(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping
    public Collection<Player> getPlayers() {
        return playersService.findAll();
    }

    @PostMapping
    public ResponseEntity<Void> addPlayer(@RequestBody PlayerCreationRequest request, UriComponentsBuilder ucb) {
        Player playerToSave = Player.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .position(request.getPosition())
                .teamId(request.getTeamId())
                .build();

        playersService.savePlayer(playerToSave);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucb.path("/api/v1/snd-players/{id}").buildAndExpand(playerToSave.getId()).toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable String id) {
        return playersService.findById(id);
    }
}
