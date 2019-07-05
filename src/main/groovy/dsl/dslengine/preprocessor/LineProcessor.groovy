package dsl.dslengine.preprocessor

class LineProcessor {
    String line
    Change change

    String processLine() {
        change.applyTo line
    }
}