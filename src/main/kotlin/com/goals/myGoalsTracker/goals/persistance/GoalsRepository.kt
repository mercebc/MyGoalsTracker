package com.goals.myGoalsTracker.goals.persistance


import com.goals.myGoalsTracker.goals.Goal
import com.goals.myGoalsTracker.goals.GoalToCreate
import com.goals.myGoalsTracker.utils.pipe
import org.jetbrains.exposed.dao.*
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
class GoalsRepository {
	fun save(goal: GoalToCreate): Goal =
			GoalEntity.new {
				information = goal.information
			}.pipe(Mappers::toGoal)

}

private object Mappers {
	fun toGoal(goalEntity: GoalEntity) = Goal(
			id = goalEntity.id.value,
			information = goalEntity.information
	)
}

object GoalTable : UUIDTable() {
	val information = varchar("information", 50).index()
}

class GoalEntity(id: EntityID<UUID>) : UUIDEntity(id) {
	companion object : UUIDEntityClass<GoalEntity>(GoalTable)

	var information by GoalTable.information
}
