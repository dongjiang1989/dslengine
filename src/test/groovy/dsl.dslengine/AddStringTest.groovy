package dsl.dslengine

import dsl.dslengine.preprocessor.LineProcessor
import dsl.dslengine.preprocessor.support.AddString

class AddStringTest extends GroovyTestCase {

    void testPrependSting() {
        def change = new AddString(prepend:"START ")
        def lineProcessor = new LineProcessor(line:"I am a cat lover!", change:change)
        assert lineProcessor.processLine() == "START I am a cat lover!"
    }

    void testAppendString() {
        def change = new AddString(append:" END")
        def lineProcessor = new LineProcessor(line:"I am a cat lover!", change:change)
        assert lineProcessor.processLine() == "I am a cat lover! END"
    }

    void testBothAppendingAndPrepending() {
        def change = new AddString(prepend:"START ", append:" END")
        def lineProcessor = new LineProcessor(line:"I am a cat lover!", change:change)
        assert lineProcessor.processLine() == "START I am a cat lover! END"
    }
}
