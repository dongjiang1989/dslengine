package dsl.dslengine.preprocessor.support

import dsl.dslengine.preprocessor.Change

class AddQuotes implements Change {
    String delimiter = " "
    boolean eachElement
    boolean entireLine
    def elements = []

    String applyTo(String line) {
        def newLine = ""
        if (entireLine) {
            newLine = "\"${line}\""
        } else if (eachElement) {
            int last = line.split(delimiter).size()-1
            line.split(delimiter).eachWithIndex { element, i ->
                newLine += "\"${element}\""

                if (i<last) {
                    newLine +="${delimiter}"
                }
            }
        } else {
            int last = line.split(delimiter).size()-1
            line.split(delimiter).eachWithIndex { element, i ->
                if (elements.contains(i)) {
                    newLine += "\"${element}\""
                } else {
                    newLine += "${element}"
                }

                if (i<last) {
                    newLine +="${delimiter}"
                }
            }
        }
        newLine
    }
}
