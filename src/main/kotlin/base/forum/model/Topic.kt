package base.forum.model

import javax.persistence.*

@Entity
@Table(name="topics")
data class Topic (
        @Id
        @GeneratedValue
        val id: Long = 0,

        val title: String = ""
)
