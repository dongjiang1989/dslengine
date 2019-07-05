package dsl.dslengine.keyword

class SendMessageKeywordPrivider implements KeywordProvider {
    def keywords = []
    String description = "SendMessage - Send Message keyword！！！"

    void addKeyword(keyword) {
        keywords << keyword
    }

    void addKeyword(name, help, closure, aliases) {
        def newKeyword = Keyword(name:name, help:help, closure:closure, aliases:aliases)
        keywords << newKeyword
    }

    List<Keyword> getKeywords() {
        def sendKeyword = new Keyword()
        sendKeyword.name = "SendMessage"
        sendKeyword.help = "Send Message keyword。"
        sendKeyword.aliases = ["sendmessage", "SENDMESSAGE", "send"]
        sendKeyword.closure = { value ->
            if (value instanceof List) {
                value.each {
                    println "send1: ${it}"
                }
            } else if (value instanceof Map) {
                value.each { k,v ->
                    if (v instanceof  Script) {
                        println "send2"+v.toString()
                    } else {
                        println "send3: ${k}:${v}"
                    }
                }
            } else {
                println "send4: ${value}"
            }
        }
        keywords << sendKeyword

        keywords
    }
}

