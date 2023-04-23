import java.util.Scanner

object ScreenCreateNote: ScreenCreate() {

    override fun create(archive: Archive?) {
            println("\nВведите название заметки")
            val title = Scanner(System.`in`).nextLine()
            println("Введите текст заметки")
            val text = Scanner(System.`in`).nextLine()
            val note = Note(title, text)
            archive?.notes?.add(note)
            println("Создана заметка ${note.title}")
    }
}