package com.example.notemaking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notemaking.model.NoteModel;
import com.example.notemaking.repo.NoteRepo;

@Service
public class NoteService {

    @Autowired
    NoteRepo noteRepo;

    public void addNote(NoteModel note) {
        noteRepo.save(note);
    }

  
    public NoteModel getContent(Integer id) {
        return  noteRepo.findById(id).get();
    }


    public void updateNote(NoteModel newNote, Integer id) {

        NoteModel note = noteRepo.findById(id).get();

        note.setTitle(newNote.getTitle());
        note.setContent(newNote.getContent());
         
        noteRepo.save(note);
    }


    public void deleteById(Integer id) {
        noteRepo.deleteById(id);
    }


    public List<NoteModel> getAllContent( ) {
       return noteRepo.findAll();
    
    }
    
}
