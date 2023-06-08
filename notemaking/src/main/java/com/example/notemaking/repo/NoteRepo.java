package com.example.notemaking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notemaking.model.NoteModel;

public interface NoteRepo extends JpaRepository<NoteModel,Integer>{
    
}
