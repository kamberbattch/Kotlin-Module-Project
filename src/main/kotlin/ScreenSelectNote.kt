import java.util.Scanner

object ScreenSelectNote: ScreenSelect() {

    override fun select(archive: Archive?) {
        while (true) {
            if (archive != null) {
                println("\n0.Создать заметку\nСписок заметок:\n${print(archive)}\n${archive.notes.size + 1}.Назад")
                try {
                    when (val choice = Scanner(System.`in`).nextLine().toInt()) {
                        0 -> {
                            ScreenCreateNote.create(archive)
//                            break
                        }
                        in 1..archive.notes.size -> {
                            ScreenViewNote.viewNote(
                                archive,
                                archive.notes[choice - 1]
                            )
                            break
                        }
                        archive.notes.size + 1 -> break
                        else -> println("для выбора введите цифры от 0 до ${archive.notes.size + 1}")
                    }
                } catch (e: NumberFormatException) {
                    println("для выбора введите цифры от 0 до ${archive.notes.size + 1}")
                }
            }
        }
//        ScreenSelectArchive.select()
    }

    override fun print(archive: Archive?): String {
        var string = ""
        if (archive != null) {
            for (note in archive.notes) string += "${archive.notes.indexOf(note)+1}.${note.title}\n"
        }
        return string
    }

}
