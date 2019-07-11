package dsl.dslengine.keyword

import static grails.async.Promises.*

class TaskKeywordProvider  implements KeywordProvider {
    def keywords = []
    String description = "Task - Task keyword！！！"

    void addKeyword(keyword) {
        keywords << keyword
    }

    void addKeyword(name, help, closure, aliases) {
        def newKeyword = Keyword(name:name, help:help, closure:closure, aliases:aliases)
        keywords << newKeyword
    }

    List<Keyword> getKeywords() {
        def taskKeyword = new Keyword()
        taskKeyword.name = "Task"
        taskKeyword.help = "Task keyword"
        taskKeyword.aliases = ["task", "TASK", "async", "Async", "ASYNC"]
        taskKeyword.closure = { value ->
            if (value instanceof List) {
                return tasks(value)
            } else {
                return task(value)
            }
        }
        keywords << taskKeyword

        keywords
    }
}
