package base.forum.repository

import base.forum.model.Comment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CommentRepository: JpaRepository<Comment, Long> {
    fun findByTopicId(topicId: Long): List<Comment>
}
