package base.forum.model

import java.util.*
import javax.persistence.*
import javax.persistence.TemporalType.TIMESTAMP


@Entity
@Table(name = "comments")
data class Comment(
        @Id
        @GeneratedValue
        var id: Long = 0,

        var content: String = "",

        @Temporal(TIMESTAMP)
        var timestamp: Date = Date()
)
