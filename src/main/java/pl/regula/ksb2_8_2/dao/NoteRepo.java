package pl.regula.ksb2_8_2.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.regula.ksb2_8_2.entity.Note;

import java.util.List;

@Repository
public interface NoteRepo extends CrudRepository<Note,Long> {

    List<Note> findAll();

}
