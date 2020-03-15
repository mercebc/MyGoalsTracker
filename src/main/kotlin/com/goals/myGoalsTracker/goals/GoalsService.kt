package com.goals.myGoalsTracker.goals

import com.goals.myGoalsTracker.goals.persistance.GoalsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GoalsService(
		@Autowired val goalsRepository: GoalsRepository
) {
	fun save(goalToCreate: GoalToCreate): Goal =
			goalsRepository.save(goalToCreate)
}
