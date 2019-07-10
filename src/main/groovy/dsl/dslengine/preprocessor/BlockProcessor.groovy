package dsl.dslengine.preprocessor

class BlockProcessor {
    Change change


    String processBlock() {
        String newFileContents = ""

        file.eachLine { line ->
            newFileContents += change.applyTo line
            newFileContents += "\n"
        }
        newFileContents
    }
}
