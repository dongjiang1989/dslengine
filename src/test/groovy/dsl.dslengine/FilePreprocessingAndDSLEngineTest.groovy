package dsl.dslengine

import dsl.dslengine.preprocessor.ChangeChain
import dsl.dslengine.preprocessor.FileProcessor
import dsl.dslengine.preprocessor.support.AddQuotes
import dsl.dslengine.preprocessor.support.AddString
import org.codehaus.groovy.control.CompilerConfiguration

class FilePreprocessingAndDSLEngineTest extends GroovyTestCase {

    void testDSL() {
        def stringLineChanges = new ChangeChain(changes:[new AddQuotes(entireLine:true), new AddString(prepend:"debug ")])
        def fileProcessor = new FileProcessor(file:new File("src/test/resources/test/test.dsl"), change:stringLineChanges)
        String newScript = fileProcessor.processFile()

        def configuration = new CompilerConfiguration()
        configuration.setScriptBaseClass("dsl.dslengine.DSLEngineScript")
        def shell = new GroovyShell(configuration)
        shell.evaluate newScript
    }
}

