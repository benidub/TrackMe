package com.example.trackme.data.note;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.trackme.utils.ValidationUtils;

import java.util.List;

public class NoteRepository {

    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(Note... notes) {
        new InsertNotesAsyncTask(noteDao).execute(notes);
    }

    public void update(Note... notes) {
        new UpdateNotesAsyncTask(noteDao).execute(notes);
    }

    public void delete(Note... notes) {
        new DeleteNotesAsyncTask(noteDao).execute(notes);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    private static abstract class NoteDatabaseOperationAsyncTask extends AsyncTask<Note, Void, Void> {
        NoteDao noteDao;  // For making database operations

        private NoteDatabaseOperationAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }
    }

    private static class InsertNotesAsyncTask extends NoteDatabaseOperationAsyncTask {

        private InsertNotesAsyncTask(NoteDao noteDao) {
            super(noteDao);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insertAll(notes);
            return null;
        }
    }

    private static class UpdateNotesAsyncTask extends NoteDatabaseOperationAsyncTask {

        private UpdateNotesAsyncTask(NoteDao noteDao) {
            super(noteDao);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.updateAll(notes);
            return null;
        }
    }

    private static class DeleteNotesAsyncTask extends NoteDatabaseOperationAsyncTask {

        private DeleteNotesAsyncTask(NoteDao noteDao) {
            super(noteDao);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.deleteListOfNotes(notes);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends NoteDatabaseOperationAsyncTask {

        private DeleteAllNotesAsyncTask(NoteDao noteDao) {
            super(noteDao);
        }

        Void doInBackground() {
            noteDao.deleteAllNotes();
            return null;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            return doInBackground();
        }
    }
}
