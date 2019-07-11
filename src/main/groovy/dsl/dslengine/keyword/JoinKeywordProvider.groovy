package dsl.dslengine.keyword


import static grails.async.Promises.waitAll

class JoinKeywordProvider implements  KeywordProvider {
    def keywords = []
    String description = "Join Keywords - Join Async jobs"

    void addKeyword(keyword) {
        keywords << keyword
    }

    void addKeyword(name, help, closure, aliases) {
        def newKeyword = Keyword(name:name, help:help, closure:closure, aliases:aliases)
        keywords << newKeyword
    }

    List<Keyword> getKeywords() {
        def joinKeyword = new Keyword()
        joinKeyword.name = "Join"
        joinKeyword.help = "Join Async jobs"
        joinKeyword.aliases = ["join", "Join", "JOIN"]
        joinKeyword.closure = { value ->
            if (value instanceof List) {
                return waitAll(value)
            } else {
                return value.get()
            }
        }
        keywords << joinKeyword

        keywords
    }
}
