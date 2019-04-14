package base.forum.controller

import base.forum.model.Comment
import base.forum.repository.CommentRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/comment")
@CrossOrigin
class CommentController(private val repository: CommentRepository) {

    @GetMapping("/")
    fun getAll(): List<Comment> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): Comment {
        return repository.findById(id).get()
    }

    @GetMapping("/findByTopicId/{topicId}")
    fun findByTopicId(@PathVariable("topicId") topicId: Long): List<Comment> {
        return repository.findByTopicId(topicId)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun post(@RequestBody comment: Comment) = repository.save(comment)

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun put(@RequestBody comment: Comment) = repository.save(comment)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable("id") id: Long) = repository.deleteById(id)
}
