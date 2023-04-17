import java.util.Scanner

object ScreenCreateNote {

    fun createNote(archive: Archive) {
        do {
            println("0.Создать заметку\n1.Назад")
            try {
                when (Scanner(System.`in`).nextLine().toInt()) {
                    0 -> {
                        println("Введите название заметки")
                        var title = Scanner(System.`in`).nextLine()
                        println("Введите текст заметки")
                        var text = Scanner(System.`in`).nextLine()
                        val note = Note(title, text)
                        archive.notes.add(note)
                        println("Создана заметка ${note.title.uppercase()}")
                    }
                    1 -> break
                    else -> println("для выбора введите 0 или 1")
                }
            }
            catch (e: NumberFormatException) {println("для выбора введите 0 или 1")}
        } while (true)
        ScreenSelectNote.select(archive)
    }
}