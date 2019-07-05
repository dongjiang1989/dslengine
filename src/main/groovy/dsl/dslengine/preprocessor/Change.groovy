package dsl.dslengine.preprocessor

interface Change {
    String applyTo(String line)
}
