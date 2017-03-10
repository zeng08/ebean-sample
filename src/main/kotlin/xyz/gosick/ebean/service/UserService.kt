package xyz.gosick.ebean.service

import io.ebean.EbeanServer
import io.ebean.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
//import org.springframework.transaction.annotation.Transactional
import xyz.gosick.ebean.model.User

/**
 * Created by ks on 2017/3/10.
 */

@Service
class UserService {

    @Autowired
    lateinit var ebeanServer: EbeanServer

    fun getUser(): List<User> {
        return ebeanServer.find(User::class.java).findList()
    }

    @Transactional
    fun save(user: User): User {
        ebeanServer.save(user)
        if (user.name == "rollback") throw RuntimeException("boooom!!")
        return user
    }
}