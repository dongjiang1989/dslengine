package dsl.dslengine

import org.codehaus.groovy.control.CompilerConfiguration

class ExitKeywordTest extends GroovyTestCase {

    String testScript = """
                        echo "abc"
                        exit 100
                        echo 123
                        """

    void testDSL() {
        def configuration = new CompilerConfiguration()
        configuration.setScriptBaseClass("dsl.dslengine.DSLEngineScript")
        configuration.setSourceEncoding("utf-8")
        def shell = new GroovyShell(configuration)
        shell.evaluate testScript
    }
}
