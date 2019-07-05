package dsl.dslengine


import org.codehaus.groovy.control.CompilerConfiguration

class RTCDSLEngineTest extends GroovyTestCase {
    void testDSL() {
        String newScript = new File("src/test/resources/call.dsl").getText()

        def configuration = new CompilerConfiguration()
        configuration.setScriptBaseClass("dsl.dslengine.DSLEngineScript")
        def shell = new GroovyShell(configuration)
        shell.evaluate newScript
    }
}
