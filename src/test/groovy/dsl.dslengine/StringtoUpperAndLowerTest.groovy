package dsl.dslengine

import dsl.dslengine.preprocessor.LineProcessor
import dsl.dslengine.preprocessor.support.StringToLower
import dsl.dslengine.preprocessor.support.StringToUpper


class StringtoUpperAndLowerTest extends GroovyTestCase {
    void testStringToLower() {
        def change = new StringToLower()
        def lineProcessor = new LineProcessor(change:change)
        def lines = ["I Hope thIS WOrks!","I hope this WORKS!","I hope this wOrks!","I hope this wORks!"]

        lines.each { line ->
            lineProcessor.line = line
            assert lineProcessor.processLine() == "i hope this works!"
        }
    }

    void testStringToUpper() {
        def change = new StringToUpper()
        def lineProcessor = new LineProcessor(change:change)
        def lines = ["I Hope thIS WOrks!","I hope this WORKS!","I hope this wOrks!","I hope this wORks!"]

        lines.each { line ->
            lineProcessor.line = line
            assert lineProcessor.processLine() == "I HOPE THIS WORKS!"
        }
    }
}
