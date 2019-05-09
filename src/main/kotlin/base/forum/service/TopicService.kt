package base.forum.service

import base.forum.model.Comment
import base.forum.model.Topic
import base.forum.repository.CommentRepository
import base.forum.repository.TopicRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TopicService(private val commentRepository: CommentRepository, private val topicRepository: TopicRepository) {

    @Transactional
    fun save(topicDto: Topic) {
        val topicToSave = Topic(title = topicDto.title)
        val savedTopic = topicRepository.save(topicToSave)
        val firstComment = Comment(content = topicDto.comments.first().content, topic = savedTopic)
        val savedComment = commentRepository.save(firstComment)
    }

}
