package io.wookoo.flyticketssearch.data.mappers

import io.wookoo.flyticketssearch.data.database.dbos.UserFromEntity
import io.wookoo.flyticketssearch.domain.models.UserFromModel

fun UserFromModel.toUserFromEntity(): UserFromEntity {
    return UserFromEntity(
        id = this.id,
        lastUserInput = this.lastUserInput
    )
}
