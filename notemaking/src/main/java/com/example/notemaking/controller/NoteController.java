package com.example.notemaking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notemaking.model.NoteModel;
import com.example.notemaking.service.NoteService;

@RestController
@RequestMapping("/api")
public class NoteController {
    
    @Autowired
    NoteService noteService;

    @PostMapping("/add/Note")
    public String addNote(@RequestBody NoteModel note){
        noteService.addNote(note);
        return "Your Note saved";
    }

    @GetMapping("/getAllContent/id/{id}")
    public NoteModel getContent(@PathVariable Integer id){
      return noteService.getContent(id);
    }
    @GetMapping("/getAllContent")
    public List<NoteModel> getAllContent(){
      return noteService.getAllContent();
    }

    @PutMapping("/update/note/id/{id}")
    public String updateNote(@RequestBody NoteModel newNote, @PathVariable Integer id){
         noteService.updateNote(newNote,id);
         return "saved your update";
    }

    @DeleteMapping("deleteById/id/{id}")
    public String deleteById(@PathVariable Integer id){
        noteService.deleteById(id);
        return "deleted";
    }
}
