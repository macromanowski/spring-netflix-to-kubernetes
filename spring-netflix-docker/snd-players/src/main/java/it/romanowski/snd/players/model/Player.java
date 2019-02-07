package it.romanowski.snd.players.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Getter
@Setter
@Builder
@Table("player")
public class Player {
    @PrimaryKey
    private String id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String position;
    @Column
    private String teamId;
}
