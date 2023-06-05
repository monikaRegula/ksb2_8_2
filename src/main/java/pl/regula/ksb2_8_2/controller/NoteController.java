package pl.regula.ksb2_8_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.regula.ksb2_8_2.entity.Note;
import pl.regula.ksb2_8_2.model.NoteDto;
import pl.regula.ksb2_8_2.service.NoteService;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {


    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<Note>> getNotes() {
        List<Note> noteList = noteService.findAllNotes();
        return new ResponseEntity<>(noteList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addNote(@RequestBody NoteDto noteDto) {
        noteService.addNote(noteDto);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PutMapping("/id/{id}")
    public ResponseEntity updateNote(@RequestBody NoteDto dto, @PathVariable long id) {
        int updated = noteService.updateNote(dto, id);
        if (updated == 0) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
