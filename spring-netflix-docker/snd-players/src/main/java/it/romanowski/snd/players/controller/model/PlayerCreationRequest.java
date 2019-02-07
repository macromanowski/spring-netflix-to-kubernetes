package it.romanowski.snd.players.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlayerCreationRequest {
    private String id;
    private String firstName;
    private String lastName;
    private String position;
    private String teamId;
}
