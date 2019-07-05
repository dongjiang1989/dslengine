package dsl.dslengine.preprocessor.support

import dsl.dslengine.preprocessor.Change

class AddString implements Change {
    String append = ""
    String prepend = ""

    String applyTo(String line) {
        prepend+line+append
    }
}
