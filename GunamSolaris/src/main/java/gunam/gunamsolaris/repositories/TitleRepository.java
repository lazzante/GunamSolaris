package gunam.gunamsolaris.repositories;

import gunam.gunamsolaris.entities.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title,Integer> {
}
