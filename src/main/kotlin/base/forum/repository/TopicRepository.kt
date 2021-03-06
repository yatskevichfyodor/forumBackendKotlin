package base.forum.repository

import base.forum.model.Topic
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicRepository: JpaRepository<Topic, Long>
