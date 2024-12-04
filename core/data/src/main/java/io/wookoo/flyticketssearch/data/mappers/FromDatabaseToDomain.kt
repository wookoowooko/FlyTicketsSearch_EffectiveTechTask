package io.wookoo.flyticketssearch.data.mappers

import io.wookoo.flyticketssearch.data.database.dbos.UserFromEntity
import io.wookoo.flyticketssearch.domain.models.UserFromModel

fun UserFromEntity.toUserFromModel(): UserFromModel {
    return UserFromModel(
        lastUserInput = lastUserInput
    )

}