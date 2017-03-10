package xyz.gosick.ebean.model

import io.ebean.Model
import io.ebean.annotation.WhenCreated
import io.ebean.annotation.WhenModified
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.MappedSuperclass
import javax.persistence.Table

/**
 * Created by ks on 2017/3/10.
 */
@Entity
@Table(name = "cloud_users")
@MappedSuperclass
class User : Model() {
    @Id
    var id: Long? = null

    var name: String? = null

    var age: Int? = null

    @WhenCreated
    var createdAt: Timestamp? = null

    @WhenModified
    var updatedAt: Timestamp? = null
}