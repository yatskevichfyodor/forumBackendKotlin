package base.forum.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

@Entity
@Table(name="topics")
data class Topic (
        @Id
        @GeneratedValue
        val id: Long = 0,

        val title: String = "",

        @Temporal(TemporalType.TIMESTAMP)
        val timestamp: Date = Date(),

        @JsonIgnore
        @OneToMany(mappedBy = "topic")
        val comments: List<Comment>? = null
)
