package base.forum.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*
import javax.persistence.TemporalType.TIMESTAMP


@Entity
@Table(name = "comments")
data class Comment(
        @Id
        @GeneratedValue
        val id: Long = 0,

        val content: String = "",

        @Temporal(TIMESTAMP)
        val timestamp: Date = Date(),

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "topic_id", referencedColumnName = "id", nullable = false)
        val topic: Topic? = null
)
