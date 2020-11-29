import com.cra.figaro.algorithm.factored.VariableElimination
import com.cra.figaro.language._
import com.cra.figaro.library.atomic.discrete.Binomial

val sunnyDaysInMonth = Binomial(30, 0.2)

def getMonthQuality(x: Int) = {
  if(x > 10) "good" else if(x > 5) "average" else "poor"
}
val monthQuality = Apply(sunnyDaysInMonth, getMonthQuality)

VariableElimination.probability(monthQuality, "good")

