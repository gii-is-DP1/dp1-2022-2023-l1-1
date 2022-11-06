package org.springframework.samples.petclinic.deck;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="faction_cards")
public class FactionCard {
    
    @Id
    @Enumerated(EnumType.STRING)
    private Type type;

    private enum Type {
        LOYAL,TRAITOR,MERCHANT;
    }
}
