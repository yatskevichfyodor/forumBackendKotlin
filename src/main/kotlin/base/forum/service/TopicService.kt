package base.forum.service

import base.forum.model.Comment
import base.forum.model.Topic
import base.forum.repository.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicService(private val repository: TopicRepository) {
    fun save(topic: Topic) {
        val updatedComments = ArrayList<Comment>()
        topic.comments.forEach {comment ->
            updatedComments.add(Comment(topic = topic, content = comment.content))
        }
        val topicToSave = Topic(title = topic.title, comments = updatedComments)
        repository.save(topicToSave)
    }
}
