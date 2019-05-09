package base.forum.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType.ALL
import javax.persistence.CascadeType.PERSIST
import javax.persistence.TemporalType.TIMESTAMP

@Entity
@Table(name = "topics")
data class Topic(
        @Id
        @GeneratedValue
        var id: Long = 0,

        var title: String = "",

        @Temporal(TIMESTAMP)
        var timestamp: Date = Date(),

        @OneToMany(cascade = [ALL])
        @JoinColumn(name = "topic_id", referencedColumnName = "id")
        var comments: List<Comment> = listOf()
)
