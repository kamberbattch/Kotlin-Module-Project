import java.util.Scanner

object ScreenCreateNote: ScreenCreate() {

    override fun create(archive: Archive?) {

        while (true) {
            println("\nВведите название заметки")
            val title = Scanner(System.`in`).nextLine()
            println("Введите текст заметки")
            val text = Scanner(System.`in`).nextLine()
            val note = Note(title, text)
            archive?.notes?.add(note)
            println("Создана заметка ${note.title.uppercase()}")
            println("0.Создать ещё заметку\n1.Назад")
            try {
                when (Scanner(System.`in`).nextLine().toInt()) {
                    0 -> continue
                    1 -> break
                    else -> println("для выбора введите 0 или 1")
                }
            }
            catch (e: NumberFormatException) {println("для выбора введите 0 или 1")}
        }
    }
}