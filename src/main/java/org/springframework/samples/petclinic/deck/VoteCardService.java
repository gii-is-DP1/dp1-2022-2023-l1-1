package org.springframework.samples.petclinic.deck;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.deck.VoteCard.VCType;
import org.springframework.samples.petclinic.enums.CurrentRound;
import org.springframework.samples.petclinic.game.Game;
import org.springframework.samples.petclinic.game.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class VoteCardService {

    @Autowired
    VoteCardRepository voteCardRepository;

    @Autowired
    GameRepository gameRepository ;

    @Autowired
    public VoteCardService (VoteCardRepository voteCardRepository, GameRepository gameRepository) {
        this.voteCardRepository = voteCardRepository;
        this.gameRepository = gameRepository;
    }

    public List<VoteCard> getAll() {
        return voteCardRepository.findAll();
    }

    public VoteCard getById (VCType type) {
        return voteCardRepository.findById(type).get();
    }

    public List<VoteCard> getChangeOptions(Game game, VoteCard selectedCard) {
        List<VoteCard> res = voteCardRepository.findAll();
        if (game.getRound() == CurrentRound.FIRST) {
            res.remove(selectedCard);
            res.remove(voteCardRepository.findById(VCType.YELLOW).get());
        }
        if (game.getRound() == CurrentRound.SECOND) {
            res.remove(selectedCard);
        }
        return res;
    }
    
}