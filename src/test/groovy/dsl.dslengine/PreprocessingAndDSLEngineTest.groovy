package dsl.dslengine

import dsl.dslengine.preprocessor.ChangeChain
import dsl.dslengine.preprocessor.LineProcessor
import dsl.dslengine.preprocessor.support.AddQuotes
import dsl.dslengine.preprocessor.support.AddString
import org.codehaus.groovy.control.CompilerConfiguration

class PreprocessingAndDSLEngineTest extends GroovyTestCase {

    def testScript =
            """This is a test.
balabala...
dongjiang
key:value
ç
"""

    void testDSL() {
        String newScript = ""
        def mapLineChanges = new ChangeChain(changes:[new AddQuotes(delimiter:":", elements:[1]), new AddString(prepend:"([", append:"])"), new AddString(prepend:"debug ")])
        def stringLineChanges = new ChangeChain(changes:[new AddQuotes(entireLine:true), new AddString(prepend:"debug ")])
        def lineProcessor = new LineProcessor()

        testScript.eachLine { line ->
            lineProcessor.setLine line
            if (line.contains(":")) {
                lineProcessor.setChange mapLineChanges
            } else {
                lineProcessor.setChange stringLineChanges
            }
            newScript += "${lineProcessor.processLine()}\n"
        }

        def configuration = new CompilerConfiguration()
        configuration.setScriptBaseClass("dsl.dslengine.DSLEngineScript")
        def shell = new GroovyShell(configuration)
        shell.evaluate newScript
    }
}
