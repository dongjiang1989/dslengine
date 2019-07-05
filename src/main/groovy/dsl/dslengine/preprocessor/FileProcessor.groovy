package dsl.dslengine.preprocessor

class FileProcessor {
    File file
    Change change

    String processFile() {
        String newFileContents = ""

        file.eachLine { line ->
            newFileContents += change.applyTo line
            newFileContents += "\n"
        }
        newFileContents
    }
}
