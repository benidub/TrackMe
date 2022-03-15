package com.example.trackme.data.note;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")  // for changing the table name
public class Note {

    // Will be the unique id of the database elements
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "title")  // for changing the name of the column
    private String title;
    private String description;
    private int priority;

    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    // Room will use this method to create the database fields
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
