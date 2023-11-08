package com.eltex.draft.service

import com.eltex.draft.elements.Note
import com.eltex.kotlin_strong.service.WallServiceImpl
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.time.Instant

class NoteServiceImplTest {

    @Test
    fun updateText() {
        val noteServiceImpl = getNotesAddService(20)

        noteServiceImpl.updateText(1L, "11")
        val note1 = noteServiceImpl.getNoteById(1L)
        assertEquals(Note(1L, "11", createAt = note1.createAt, updateAt = note1.updateAt), note1)

        noteServiceImpl.updateText(2L, "22")
        val note2 = noteServiceImpl.getNoteById(2L)
        assertEquals(Note(2L, "22", createAt = note2.createAt, updateAt = note2.updateAt), note2)

        noteServiceImpl.updateText(3L, "33")
        val note3 = noteServiceImpl.getNoteById(3L)
        assertEquals(Note(3L, "33", createAt = note3.createAt, updateAt = note3.updateAt), note3)

        noteServiceImpl.updateText(4L, "44")
        val note4 = noteServiceImpl.getNoteById(4L)
        assertEquals(Note(4L, "44", createAt = note4.createAt, updateAt = note4.updateAt), note4)

        noteServiceImpl.updateText(11L, "1111")
        val note5 = noteServiceImpl.getNoteById(11L)
        assertEquals(Note(11L, "1111", createAt = note5.createAt, updateAt = note5.updateAt), note5)

        try {
            noteServiceImpl.updateText(40L, "4040")
        } catch (e: IllegalArgumentException) {
            assertTrue(true)
        }
    }

    @Test
    fun save() {
        var noteServiceImpl = getNotesAddService(20)
        val notesList1 = noteServiceImpl.getAll()

        assertEquals(notesList1.size, 20)

        noteServiceImpl = getNotesAddService(40)
        val notesList2 = noteServiceImpl.getAll()

        assertEquals(notesList2.size, 40)

        noteServiceImpl = getNotesAddService(60)
        val notesList3 = noteServiceImpl.getAll()

        assertEquals(notesList3.size, 60)

        noteServiceImpl = getNotesAddService(10)
        val notesList4 = noteServiceImpl.getAll()

        assertEquals(notesList4.size, 10)

        noteServiceImpl = getNotesAddService(0)
        val notesList5 = noteServiceImpl.getAll()

        assertEquals(notesList5.size, 0)
    }

    @Test
    fun getAll() {
        var noteServiceImpl = getNotesAddService(20)

        val noteList1 = getNotesList(20, noteServiceImpl)
        assertEquals(noteList1, noteServiceImpl.getAll())

        noteServiceImpl = getNotesAddService(40)
        val noteList2 = getNotesList(40, noteServiceImpl)
        assertEquals(noteList2, noteServiceImpl.getAll())

        noteServiceImpl = getNotesAddService(30)
        val noteList3 = getNotesList(30, noteServiceImpl)
        assertEquals(noteList3, noteServiceImpl.getAll())

        noteServiceImpl = getNotesAddService(5)
        val noteList4 = getNotesList(5, noteServiceImpl)
        assertEquals(noteList4, noteServiceImpl.getAll())

        noteServiceImpl = getNotesAddService(2)
        val noteList5 = getNotesList(2, noteServiceImpl)
        assertEquals(noteList5, noteServiceImpl.getAll())

        noteServiceImpl = getNotesAddService(120)
        val noteList6 = getNotesList(120, noteServiceImpl)
        assertEquals(noteList6, noteServiceImpl.getAll())
    }

    @Test
    fun getAllUniqueTexts() {
        val noteServiceImpl = NoteServiceImpl()
        noteServiceImpl.save(Note(1L, "1", Instant.now()))
        assertEquals(listOf("1"), noteServiceImpl.getAllUniqueTexts())

        noteServiceImpl.save(Note(2L, "2", Instant.now()))
        assertEquals(listOf("1", "2"), noteServiceImpl.getAllUniqueTexts())

        noteServiceImpl.save(Note(3L, "1", Instant.now()))
        assertEquals(listOf("1", "2"), noteServiceImpl.getAllUniqueTexts())

        noteServiceImpl.save(Note(4L, "4", Instant.now()))
        assertEquals(listOf("1", "2", "4"), noteServiceImpl.getAllUniqueTexts())

        noteServiceImpl.save(Note(5L, "1", Instant.now()))
        assertEquals(listOf("1", "2", "4"), noteServiceImpl.getAllUniqueTexts())

        noteServiceImpl.save(Note(6L, "10", Instant.now()))
        assertEquals(listOf("1", "2", "4", "10"), noteServiceImpl.getAllUniqueTexts())
    }

    @Test
    fun getBefore() {
        val noteServiceImpl = getNotesAddService(20)
        val notesList1 = noteServiceImpl.getAll().subList(0, 1)
        assertEquals(notesList1, noteServiceImpl.getBefore(2, 1L))

        val notesList2 = noteServiceImpl.getAll().subList(0, 2)
        assertEquals(notesList2, noteServiceImpl.getBefore(2, 2L))

        val notesList3 = noteServiceImpl.getAll().subList(8, 10)
        assertEquals(notesList3, noteServiceImpl.getBefore(2, 10L))

        val notesList4 = noteServiceImpl.getAll().subList(0, 20)
        assertEquals(notesList4, noteServiceImpl.getBefore(50, 20L))

        val notesList5 = mutableListOf<Note>()
        assertEquals(notesList5, noteServiceImpl.getBefore(50, 40L))
    }

    @Test
    fun getAfter() {
        val noteServiceImpl = getNotesAddService(20)
        val notesList1 = noteServiceImpl.getAll().subList(0, 2)
        assertEquals(notesList1, noteServiceImpl.getAfter(2, 1L))

        val notesList2 = noteServiceImpl.getAll().subList(1, 3)
        assertEquals(notesList2, noteServiceImpl.getAfter(2, 2L))

        val notesList3 = noteServiceImpl.getAll().subList(9, 11)
        assertEquals(notesList3, noteServiceImpl.getAfter(2, 10L))

        val notesList4 = noteServiceImpl.getAll().subList(19, 20)
        assertEquals(notesList4, noteServiceImpl.getAfter(50, 20L))

        val notesList5 = mutableListOf<Note>()
        assertEquals(notesList5, noteServiceImpl.getAfter(50, 40L))
    }

    fun getNotesList(count: Int, noteServiceImpl: NoteServiceImpl): MutableList<Note> {
        val notesList: MutableList<Note> = mutableListOf()

        for (i in 1..count) {
            val tempNote = noteServiceImpl.getNoteById(i.toLong())
            notesList.add(Note(i.toLong(), "$i", tempNote.createAt))
        }

        return notesList
    }

    fun getNotesAddService(count: Int): NoteServiceImpl {
        val noteServiceImpl = NoteServiceImpl()

        for (i in 1..count) {
            noteServiceImpl.save(Note(i.toLong(), "$i", Instant.now()))
        }

        return noteServiceImpl
    }
}