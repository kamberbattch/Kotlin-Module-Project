import java.util.*

open class ScreenCreate {
    var running = true

    open fun create (archive: Archive? = null) {
        try {
            when (Scanner(System.`in`).nextLine().toInt()) {
                0 -> this.create(archive)
                1 -> running = false
                else -> println("для выбора введите 0 или 1")
            }
        }
        catch (e: NumberFormatException) {println("для выбора введите 0 или 1")}
    }
}