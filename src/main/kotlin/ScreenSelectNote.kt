import java.util.Scanner

object ScreenSelectNote {

    fun select(archive: Archive?) {
        while (true) {
            if (archive != null) {
                println("Список заметок:\n0.Создать заметку\n${printNotes(archive)}\n${archive.notes.size + 1}.Назад")
                try {
                    when (val choice = Scanner(System.`in`).nextLine().toInt()) {
                        0 -> {
                            ScreenCreateNote.createNote(archive)
                            break
                        }
                        in 1..archive.notes.size -> ScreenViewNote.viewNote(
                            archive,
                            archive.notes[choice - 1]
                        )
                        archive.notes.size + 1 -> break
                        else -> println("для выбора введите цифры от 0 до ${archive.notes.size + 1}")
                    }
                } catch (e: NumberFormatException) {
                    println("для выбора введите цифры от 0 до ${archive.notes.size + 1}")
                }
            }
        }
        ScreenSelectArchive.select()
    }

    private fun printNotes(archive: Archive): String {
        var string = ""
        for (note in archive.notes) string += ("${archive.notes.indexOf(note)+1}.${note.title}\n")
        return string
    }
}
