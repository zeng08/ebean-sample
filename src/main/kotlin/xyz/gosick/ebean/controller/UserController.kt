package xyz.gosick.ebean.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import xyz.gosick.ebean.model.User
import xyz.gosick.ebean.service.UserService

/**
 * Created by ks on 2017/3/10.
 */
@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/list")
    fun getUser(): List<User> {
        return userService.getUser()
    }

    @GetMapping("/add/{name}")
    fun addUser(@PathVariable name: String): User {
        val user = User()
        user.name = name
        return userService.save(user)
    }
}