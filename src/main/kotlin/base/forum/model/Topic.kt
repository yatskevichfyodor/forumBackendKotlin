package base.forum.model

import java.util.*
import javax.persistence.*
import javax.persistence.TemporalType.TIMESTAMP

@Entity
@Table(name = "topics")
data class Topic(
        @Id
        @GeneratedValue
        val id: Long = 0,

        val title: String = "",

        @Temporal(TIMESTAMP)
        val timestamp: Date = Date(),

        @OneToMany(mappedBy = "topic")
        val comments: List<Comment> = listOf()
)
