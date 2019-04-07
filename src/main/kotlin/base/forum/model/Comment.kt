package base.forum.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "comments")
data class Comment(
        @Id
        @GeneratedValue
        val id: Long = 0,

        val content: String = "",

        @Temporal(TemporalType.TIMESTAMP)
        val timestamp: Date = Date(),

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "topic_id", referencedColumnName = "id")
        val topic: Topic? = null
)
