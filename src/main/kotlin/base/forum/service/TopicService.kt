package base.forum.service

import base.forum.model.Comment
import base.forum.model.Topic
import base.forum.repository.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicService(private val repository: TopicRepository) {
    fun save(topic: Topic) =
            repository.save(topic)

}
