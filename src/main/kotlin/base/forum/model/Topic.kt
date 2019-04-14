package base.forum.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*
import javax.persistence.CascadeType.PERSIST
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

        @JsonIgnore
        @OneToMany(mappedBy = "topic", cascade = [PERSIST])
        val comments: List<Comment> = listOf()
)
