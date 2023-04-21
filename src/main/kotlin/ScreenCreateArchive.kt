import java.util.Scanner

object ScreenCreateArchive: ScreenCreate() {

    override fun create(archive: Archive?) {

        while (running) {
            println("\nВведите название архива")
            val title = Scanner(System.`in`).nextLine()
            val notes: MutableList<Note> = mutableListOf()
            val archive = Archive(title, notes)
            ScreenSelectArchive.archives.add(archive)
            println("\nСоздан архив ${archive.title.uppercase()}\n0.Создать ещё архив\n1.Назад")
            super.create(archive)
        }
    }
}