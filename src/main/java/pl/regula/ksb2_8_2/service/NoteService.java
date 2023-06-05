package pl.regula.ksb2_8_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.regula.ksb2_8_2.dao.NoteRepo;
import pl.regula.ksb2_8_2.entity.Note;
import pl.regula.ksb2_8_2.model.NoteDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    public List<Note> findAllNotes() {
        List<Note> notes = new ArrayList<>();
        noteRepo.findAll().forEach(notes::add);
        return notes;
    }

    public void addNote(NoteDto noteDto) {
        Note note = new Note(noteDto.getTitle(), noteDto.getInput());
        noteRepo.save(note);
    }

    public int updateNote(NoteDto noteDto, long id) {
        Optional<Note> byId = noteRepo.findById(id);
        if (byId.isPresent()) {
            Note note = new Note(noteDto.getTitle(), noteDto.getInput());
            note.setId(id);
            noteRepo.save(note);
            return 1;
        }
        return 0;
    }
}
