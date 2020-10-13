package cn.evan.learn.chap01


import com.cra.figaro.algorithm.factored.VariableElimination
import com.cra.figaro.language.{Element, Flip, Select}
import com.cra.figaro.library.compound.If


object HelloWorld {
	val sunnyToday: Element[Boolean] = Flip(0.2)
	val greetingToday: If[String] = getGreeting(sunnyToday)
	val sunnyTomorrow: Element[Boolean] = If(sunnyToday, Flip(0.8), Flip(0.05))
	val greetingTomorrow: If[String] = getGreeting(sunnyTomorrow)
	val HELLO_WORLD: String = "Hello world!"
	
	def getGreeting(weather: Element[Boolean]): If[String] = {
		If(weather, Select(0.6 -> HELLO_WORLD, 0.4 -> "Howdy, universe!"), Select(0.2 -> HELLO_WORLD, 0.8 -> "Oh no, not again!"))
	}
	
	def predict(): Unit = {
		val result = VariableElimination.probability(greetingToday, HELLO_WORLD)
		println(s"Today's greeting is '$HELLO_WORLD' with probability $result.")
	}
	
	def infer(): Unit = {
		greetingToday.observe(HELLO_WORLD)
		val result = VariableElimination.probability(sunnyToday, true)
		println(s"If today's greeting is '$HELLO_WORLD', the weather is sunny with probability $result.")
	}
	
	def learnAndPredict(): Unit = {
		greetingToday.observe(HELLO_WORLD)
		val result = VariableElimination.probability(greetingTomorrow, HELLO_WORLD)
		println(s"If today's greeting is '$HELLO_WORLD', tomorrow's greeting will be '$HELLO_WORLD' with probability $result.")
	}
	
	def main(args: Array[String]): Unit = {
		predict()
		infer()
		learnAndPredict()
	}
	
	
	
	
	
}
