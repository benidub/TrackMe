package com.example.trackme.data.note;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNotes = repository.getAllNotes();
    }

    public LiveData<List<Note>> getAllNotes() {
        return repository.getAllNotes();
    }

    public void insert(Note... notes) {
        repository.insert(notes);
    }

    public void update(Note... notes) {
        repository.update(notes);
    }

    public void delete(Note... notes) {
        repository.delete(notes);
    }

    public void deleteAllNotes() {
        repository.deleteAllNotes();
    }

}
