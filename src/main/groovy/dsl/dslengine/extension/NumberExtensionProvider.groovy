package dsl.dslengine.extension

import dsl.dslengine.extension.LanguageExtensionProvider

class NumberExtensionProvider implements LanguageExtensionProvider {
    void extend(script) {
        Number.metaClass.key = { String key ->
            println "${key}:${delegate}"
        }
    }
}
