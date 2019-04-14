package base.forum.controller

import base.forum.model.Topic
import base.forum.repository.TopicRepository
import base.forum.service.TopicService
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topic")
@CrossOrigin
class TopicController(private val service: TopicService, private val repository: TopicRepository) {

    @GetMapping("/")
    fun getAll(): List<Topic> {
        return repository.findAll()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): Topic {
        return repository.findById(id).get()
    }

    @PostMapping
    @ResponseStatus(OK)
    fun post(@RequestBody topic: Topic) = service.save(topic)

    @PutMapping
    @ResponseStatus(OK)
    fun put(@RequestBody topic: Topic) = repository.save(topic)

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    fun delete(@PathVariable("id") id: Long) = repository.deleteById(id)
}
