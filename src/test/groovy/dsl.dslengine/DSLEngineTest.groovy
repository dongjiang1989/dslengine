package dsl.dslengine


import org.codehaus.groovy.control.CompilerConfiguration

class DSLEngineTest extends GroovyTestCase {

    String testScript = """
                        echo "This is a test."
                        debug "So is this."
                        debug 1234
                        echo "House"
                        debug ([key:"value"])
                        debug 123:"abc"
                        echo (["one","two","three"])
                        89.key "Eighty Nine"
                        def test = new BigDecimal(99)
                        test.key "wow"
                        """

    void testDSL() {
        def configuration = new CompilerConfiguration()
        configuration.setScriptBaseClass("dsl.dslengine.DSLEngineScript")
        def shell = new GroovyShell(configuration)
        shell.evaluate testScript
    }
}
