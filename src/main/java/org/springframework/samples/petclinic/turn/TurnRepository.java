package org.springframework.samples.petclinic.turn;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.game.Game;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnRepository extends CrudRepository<Turn, Long>{

    @Query("SELECT g.turn FROM Game g WHERE g LIKE :game")
    public Turn findTurnByGame(@Param("game") Game game);

    @Query("SELECT g FROM Game g WHERE g.turn LIKE :turn")
    public Game findGameByTurn(@Param("turn") Turn turn);


}
