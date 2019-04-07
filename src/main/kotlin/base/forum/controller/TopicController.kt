package base.forum.controller

import base.forum.model.Topic
import base.forum.repository.TopicRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topic")
@CrossOrigin
class GameController(private val repository: TopicRepository) {

    @GetMapping("/")
    fun getAll(): List<Topic> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): Topic {
        return repository.findById(id).get()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun post(@RequestBody topic: Topic) = repository.save(topic)

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun put(@RequestBody topic: Topic) = repository.save(topic)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable("id") id: Long) = repository.deleteById(id)
}
