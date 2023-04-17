import java.util.Scanner

object ScreenViewNote {

    fun viewNote(archive: Archive, note: Note) {
        println("${note.title.uppercase()}\n${note.text}\n0.Назад")
        try {
            when (Scanner(System.`in`).nextLine().toInt()) {
                0 -> ScreenSelectNote.select(archive)
                else -> println("для выхода введите 0")
            }
        }
        catch (e: NumberFormatException) {println("для выхода введите 0")}
    }
}