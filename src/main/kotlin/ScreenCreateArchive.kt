import java.util.Scanner

object ScreenCreateArchive: ScreenCreate() {

    override fun create(archive: Archive?) {
        println("\nВведите название архива")
        val title = Scanner(System.`in`).nextLine()
        val notes: MutableList<Note> = mutableListOf()
        val archive = Archive(title, notes)
        ScreenSelectArchive.archives.add(archive)
        println("Создан архив ${archive.title}\n")
    }
}