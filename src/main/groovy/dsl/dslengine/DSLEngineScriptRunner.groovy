package dsl.dslengine

import org.codehaus.groovy.control.CompilerConfiguration;

class DSLEngineScriptRunner {
    private GroovyShell shell;

    public DSLEngineScriptRunner() {
        CompilerConfiguration configuration = new CompilerConfiguration();
        configuration.setScriptBaseClass("dsl.dslengine.DSLEngineScript");
        shell = new GroovyShell(configuration);
    }

    public Object evaluateScript(File script) throws IOException {
        return shell.evaluate(script);
    }

    public Object evaluateScript(String script) {
        return shell.evaluate(script);
    }

    public static void main(String[] args) {
        try {
            DSLEngineScriptRunner runner = new DSLEngineScriptRunner();
            runner.evaluateScript(new File(args[0]));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
