package dsl.dslengine.preprocessor.support

import dsl.dslengine.preprocessor.Change

class TrimString implements Change {

    String applyTo(String line) {
        line.trim()
    }
}