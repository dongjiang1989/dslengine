package dsl.dslengine.preprocessor.support

import  dsl.dslengine.preprocessor.Change

class StringToUpper implements Change {
    String applyTo(String line) {
        line.toUpperCase()
    }
}