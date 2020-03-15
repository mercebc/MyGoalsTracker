package com.goals.myGoalsTracker.goals.web

import com.goals.myGoalsTracker.goals.Goal
import com.goals.myGoalsTracker.goals.GoalToCreate
import java.util.UUID

data class CreateGoalRequest(
		val information: String
)

data class SavedGoalResponse(
		val id: UUID
)

object Mappers {
	fun toGoal(createGoalRequest: CreateGoalRequest) = GoalToCreate(
			information = createGoalRequest.information
	)

	fun toSavedGoalResponse(goal: Goal) = SavedGoalResponse(
			id = goal.id
	)
}
