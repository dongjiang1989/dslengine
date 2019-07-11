package dsl.dslengine

import org.codehaus.groovy.control.CompilerConfiguration

class AsyncTest extends GroovyTestCase {
    void testDSL() {
            String newScript = new File("src/test/resources/async/async.dsl").getText()

            def configuration = new CompilerConfiguration()
            configuration.setScriptBaseClass("dsl.dslengine.DSLEngineScript")
            configuration.setSourceEncoding("utf-8")
            def shell = new GroovyShell(configuration)
            Object result = shell.evaluate newScript
        }
}
