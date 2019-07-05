package dsl.dslengine.preprocessor.support

import  dsl.dslengine.preprocessor.Change

class StringToLower implements Change {
    String applyTo(String line) {
        line.toLowerCase()
    }
}