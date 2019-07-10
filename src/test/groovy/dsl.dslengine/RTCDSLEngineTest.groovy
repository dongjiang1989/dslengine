package dsl.dslengine

import org.codehaus.groovy.control.CompilerConfiguration

class RTCDSLEngineTest extends GroovyTestCase {
    void testDSL() {
        String newScript = new File("src/test/resources/call.dsl").getText()

        def configuration = new CompilerConfiguration()
        configuration.setScriptBaseClass("dsl.dslengine.DSLEngineScript")
        configuration.setClasspath("src/test/resources/common/*.dsl")
        configuration.setScriptExtensions(['dsl'] as Set<String>)
        configuration.setSourceEncoding("utf-8")
        def shell = new GroovyShell(configuration)
        Object result = shell.evaluate newScript
        System.out.println(result.toString());
    }
}
