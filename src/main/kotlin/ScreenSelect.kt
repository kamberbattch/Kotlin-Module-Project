abstract class ScreenSelect {
    abstract fun select (archive: Archive? = null)

    abstract fun print (archive: Archive? = null): String
}