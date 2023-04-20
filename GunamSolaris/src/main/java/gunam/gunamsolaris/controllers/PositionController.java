package gunam.gunamsolaris.controllers;

import gunam.gunamsolaris.entities.Position;
import gunam.gunamsolaris.services.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/position")
@AllArgsConstructor
public class PositionController {

    private final PositionService positionService;


    @GetMapping("/getAll")
    ResponseEntity<List<Position>> getAllPositions(){
        return positionService.getAllPositions();
    }

    @PostMapping("/add")
    ResponseEntity<String> addPosition(@RequestBody Position position){
        return positionService.addPosition(position);
    }

    @GetMapping("/findById/{id}")
    ResponseEntity<Position> findPositionById(@PathVariable("id") int id){
       return positionService.findPositionById(id);
    }

    @PutMapping("/updatePosition/{id}")
    ResponseEntity<String> updatePosition(@PathVariable("id") int id,@RequestBody Position position){
        return positionService.updatePosition(id,position);
    }

    @DeleteMapping("/deletePosition/{id}")
    ResponseEntity<String> deletePosition(@PathVariable("id") int id){
        return positionService.deletePosition(id);
    }




}
