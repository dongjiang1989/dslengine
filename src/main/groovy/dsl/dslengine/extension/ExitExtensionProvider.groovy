package dsl.dslengine.extension


class ExitExtensionProvider implements LanguageExtensionProvider {
    void extend(script) {
        System.metaClass.static.invokeMethod = { String name, args ->
            if (name in ["exit", "Exit", "EXIT"]) {
                def vaildMethod = System.metaClass.getStaticMetaMethod(name, args)
                if (vaildMethod != null) {
                    vaildMethod.invoke(delegate, args)
                } else {
                    return System.metaClass.invokeMissingMethod(delegate, name, args)
                }
            }
        }
    }
}
