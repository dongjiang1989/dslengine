package dsl.dslengine.preprocessor

class ChangeChain implements Change {

    Change[] changes = []

    String applyTo(String line) {
        String modifiedLine = line
        changes.each { change ->
            modifiedLine = change.applyTo modifiedLine
        }
        modifiedLine
    }

}
