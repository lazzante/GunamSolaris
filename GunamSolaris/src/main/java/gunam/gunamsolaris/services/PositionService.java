package gunam.gunamsolaris.services;

import gunam.gunamsolaris.entities.Position;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PositionService {
    ResponseEntity<List<Position>> getAllPositions();

    ResponseEntity<String> addPosition(Position position) ;

    ResponseEntity<Position> findPositionById(int id) ;

    ResponseEntity<String> updatePosition(int id,Position position) ;

    ResponseEntity<String> deletePosition(int id);


}
