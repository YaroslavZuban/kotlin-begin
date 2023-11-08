package com.eltex.draft.service

import com.eltex.draft.elements.Note
import java.time.Instant
import java.util.Collections

class NoteServiceImpl : NoteService {
    private var notesList: MutableList<Note> = mutableListOf()

    fun getNoteById(id: Long): Note {
        val index = notesList.indexOfFirst { it.id == id }

        return if (index != -1) {
            notesList[index]
        } else {
            throw IllegalArgumentException("Such identifier does not exist: $id")
        }
    }

    fun updateText(noteId: Long, text: String) {
        val currentTime = Instant.now()

        val existNoteIndex = notesList.indexOfFirst { it.id == noteId }

        if (existNoteIndex != -1) {
            notesList[existNoteIndex] = notesList[existNoteIndex].copy(text = text, updateAt = currentTime)
        } else {
            throw IllegalArgumentException("Such identifier does not exist: $noteId")
        }
    }

    override fun save(note: Note): Note {
        notesList.add(note)
        return note
    }

    override fun getAll(): List<Note> = notesList.toList()

    override fun getAllUniqueTexts(): List<String> = notesList.map { it.text }.distinct()

    override fun getBefore(count: Int, id: Long): List<Note> {
        var indexNoteId = notesList.indexOfFirst { it.id == id }

        if (indexNoteId == -1) {
            return emptyList()
        }

        indexNoteId++

        val startIndex = indexNoteId - count

        return if (startIndex >= 0) {
            notesList.subList(startIndex, indexNoteId)
        } else {
            notesList.subList(0, indexNoteId)
        }
    }

    override fun getAfter(count: Int, id: Long): List<Note> {
        var indexNoteId = notesList.indexOfFirst { it.id == id }

        if (indexNoteId == -1) {
            return emptyList()
        }

        val endIndex = indexNoteId + count

        return if (endIndex >= notesList.size) {
            notesList.subList(indexNoteId, notesList.size)
        } else {
            notesList.subList(indexNoteId, endIndex)
        }
    }
}