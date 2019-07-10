package dsl.dslengine.keyword

class TimerKeywordProvider implements KeywordProvider {
    def keywords = []
    String description = "Timer - Timer keyword！"

    void addKeyword(Object keyword) {
        keywords << keyword
    }

    void addKeyword(Object name, Object help, Object closure, Object aliases) {
        def newKeyword = Keyword(name:name, help:help, closure:closure, aliases:aliases)
        keywords << newKeyword
    }

    List<Keyword> getKeywords() {
        def timerKeyword = new Keyword()
        timerKeyword.name = "Timer"
        timerKeyword.help = "Timer keyword！"
        timerKeyword.aliases = ["timer", "Timer", "TIMER"]
        timerKeyword.closure = {
            println "Timer: balabala..."
            return  new Timer()
        }
        keywords << timerKeyword

        keywords
    }
}
