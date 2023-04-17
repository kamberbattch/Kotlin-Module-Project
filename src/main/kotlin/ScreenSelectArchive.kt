import java.util.Scanner

object ScreenSelectArchive {
    val archives: MutableList<Archive> = mutableListOf()

    fun select() {
        while (true) {
            println("0.Создать архив\nСписок архивов:\n${printArchives()}\n${archives.size+1}.Выход")
            try {
                when (val choice = Scanner(System.`in`).nextLine().toInt()) {
                    0 -> {
                        ScreenCreateArchive.createArchive()
                        break
                    }
                    in 1..archives.size -> ScreenSelectNote.select(archive = archives[choice-1])
                    archives.size+1 -> break
                    else -> println("для выбора введите цифры от 0 до ${archives.size+1}")
                }
            } catch (e: NumberFormatException) {println("следует вводить цифру")}
        }
    }

    private fun printArchives(): String {
        var string = ""
        for (archive in archives) string += "${archives.indexOf(archive)+1}.${archive.title}\n"
        return string
    }
}