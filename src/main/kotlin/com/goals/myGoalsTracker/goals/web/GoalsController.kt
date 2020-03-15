package com.goals.myGoalsTracker.goals.web

import com.goals.myGoalsTracker.goals.GoalsService
import com.goals.myGoalsTracker.utils.pipe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class GoalsController(@Autowired val goalsService: GoalsService) {

	@GetMapping("/add")
	fun add(createGoalRequest: CreateGoalRequest): SavedGoalResponse =
			Mappers.toGoal(createGoalRequest)
					.pipe(goalsService::save)
					.pipe(Mappers::toSavedGoalResponse)


}
