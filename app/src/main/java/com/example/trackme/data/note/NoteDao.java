package com.example.trackme.data.note;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.Collection;
import java.util.List;

@Dao  /* Data access object. Will have methods signatures for accessing the data stored in the
         room database */
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    default void insertAll(Note... notes) {
        for (Note note : notes) {
            insert(note);
        }
    }

    default void updateAll(Note... notes) {
        for (Note note : notes) {
            update(note);
        }
    }

    default void deleteListOfNotes(Note... notes) {
        for (Note note : notes) {
            delete(note);
        }
    }

    default void insertAll(Collection<Note> notes) {
        for (Note note : notes) {
            insert(note);
        }
    }

    default void updateAll(Collection<Note> notes) {
        for (Note note : notes) {
            update(note);
        }
    }

    default void deleteListOfNotes(Collection<Note> notes) {
        for (Note note : notes) {
            delete(note);
        }
    }

    @Query("DELETE FROM note_table")  // By calling this method the query will be executed
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();
}
