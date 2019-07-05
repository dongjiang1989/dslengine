package dsl.dslengine

import dsl.dslengine.preprocessor.LineProcessor
import dsl.dslengine.preprocessor.support.AddQuotes

class AddQuotesTest extends GroovyTestCase {

    /*
     * Testing changing:
     *
     * dongjiang
     *
     * To:
     *
     * "dongjiang"
     */
    void testQuoteEntireLine() {
        def change = new AddQuotes(entireLine:true)
        def lineProcessor = new LineProcessor(change:change)
        lineProcessor.line = "dongjiang"
        assert lineProcessor.processLine() == "\"dongjiang\""
    }

    /*
     * Testing changing:
     *
     * dong jiang abc
     *
     * To:
     *
     * "dong" "jiang" "abc"
     */
    void testQuoteEachElement() {
        def change = new AddQuotes(eachElement:true)
        def lineProcessor = new LineProcessor(change:change)
        lineProcessor.line = "dong jiang abc"
        assert lineProcessor.processLine() == "\"dong\" \"jiang\" \"abc\""
    }

    /*
     * Testing changing:
     *
     * > GET /api
     *
     * To:
     *
     * > GET "/api"
     */
    void testQuoteAnElement() {
        def change = new AddQuotes(elements:[2])
        def lineProcessor = new LineProcessor(change:change)
        lineProcessor.line = "> GET /api"
        assert lineProcessor.processLine() == "> GET \"/api\""
    }

    /*
     * Testing changing:
     *
     * To be or not to be
     *
     * To:
     *
     * To "be" or "not" to "be"
     */
    void testQuoteSomeElements() {
        def change = new AddQuotes(elements:[1,3,5])
        def lineProcessor = new LineProcessor(change:change)
        lineProcessor.line = "To be or not to be"
        assert lineProcessor.processLine() == "To \"be\" or \"not\" to \"be\""
    }
}
