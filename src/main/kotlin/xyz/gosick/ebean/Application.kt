package xyz.gosick.ebean

import io.ebean.EbeanServer
import io.ebean.EbeanServerFactory
import io.ebean.config.ServerConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import javax.sql.DataSource

/**
 * Created by ks on 2017/3/9.
 */
@SpringBootApplication
class Application {

    @Bean
    fun ebeanServer(dataSource: DataSource): EbeanServer {
        val serverConfig = ServerConfig()
        serverConfig.name = "mariadb"
        serverConfig.isDefaultServer = true
        serverConfig.dataSource = dataSource
        return EbeanServerFactory.create(serverConfig)
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}