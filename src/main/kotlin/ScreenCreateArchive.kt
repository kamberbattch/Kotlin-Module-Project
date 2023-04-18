import java.util.Scanner

object ScreenCreateArchive: ScreenCreate() {

    override fun create(archive: Archive?) {
        while (true) {
            println("Введите название Архива")
            val title = Scanner(System.`in`).nextLine()
            val notes: MutableList<Note> = mutableListOf()
            val archive = Archive(title, notes)
            ScreenSelectArchive.archives.add(archive)
            println("Создан архив ${archive.title.uppercase()}\n0.Создать архив\n1.Назад")
            try {
                when (Scanner(System.`in`).nextLine().toInt()) {
                    0 -> continue
                    1 -> break
                    else -> println("для выбора введите 0 или 1")
                }
            }
            catch (e: NumberFormatException) {println("для выбора введите 0 или 1")}
        }
        ScreenSelectArchive.select()
    }
}