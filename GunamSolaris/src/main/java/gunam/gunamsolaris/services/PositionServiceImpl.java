package gunam.gunamsolaris.services;

import gunam.gunamsolaris.entities.Position;
import gunam.gunamsolaris.entities.User;
import gunam.gunamsolaris.repositories.PositionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    @Override
    public ResponseEntity<List<Position>> getAllPositions() {
        return new ResponseEntity<>(positionRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addPosition(Position position) {

        Position savedPosition = positionRepository.save(position);

        if (positionRepository.existsById(savedPosition.getId())) {
            return new ResponseEntity<>("Position Saved In Database", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Error! Position Can Not Saved In Database !", HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<Position> findPositionById(int id) {
        Optional<Position> foundPosition= positionRepository.findById(id);
        if (!foundPosition.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Position _position = foundPosition.get();
            return new ResponseEntity<>(_position, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<String> updatePosition(int id, Position position) {
        Optional<Position> foundPosition = positionRepository.findById(id);
        if (foundPosition.isPresent()) {
            Position _position = foundPosition.get();
            _position.setName(position.getName());
            _position.setDescription(position.getDescription());
            positionRepository.save(_position);
            return new ResponseEntity<>("Position Updated Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Position Can Not Found By Given Id", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> deletePosition(int id) {
        if (positionRepository.existsById(id)) {
            positionRepository.deleteById(id);
            return new ResponseEntity<>("Position Deleted Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Position Can Not Found By Given Id", HttpStatus.UNPROCESSABLE_ENTITY);
        }


    }
}
