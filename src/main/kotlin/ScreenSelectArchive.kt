import java.util.Scanner

object ScreenSelectArchive: ScreenSelect() {
    val archives: MutableList<Archive> = mutableListOf()

    override fun select(archive: Archive?) {
        while (true) {
            println("0.Создать архив\nСписок архивов:\n${print()}\n${archives.size+1}.Выход")
            try {
                when (val choice = Scanner(System.`in`).nextLine().toInt()) {
                    0 -> {
                        ScreenCreateArchive.create(archive = null)
                        break
                    }
                    in 1..archives.size -> ScreenSelectNote.select(archive = archives[choice-1])
                    archives.size+1 -> break
                    else -> println("для выбора введите цифры от 0 до ${archives.size+1}")
                }
            } catch (e: NumberFormatException) {println("следует вводить цифру")}
        }
    }

    override fun print(archive: Archive?): String {
        var string = ""
        for (archive in archives) string += "${archives.indexOf(archive)+1}.${archive.title}\n"
        return string
    }
}