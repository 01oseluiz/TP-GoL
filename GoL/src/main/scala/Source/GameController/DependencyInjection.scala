package Source.GameController

import org.springframework.context.annotation._
import org.springframework.util.StringUtils

object DependencyInjection {
  private val PACKAGE_NAME : String = "GameRules"
  private val CLASS_INJECTION: String = "Source.GameEngine.GameEngine"
  private var CLASS_NAMES : Array[Any] = Array.empty

  var context = new AnnotationConfigApplicationContext()
  context.scan(PACKAGE_NAME)

  /**
    * Gera lista de Classes Com Regras de Jogo
    */
  context.getBeanDefinitionNames.drop(6).foreach(x => if (!x.equals("messagePrinter")) CLASS_NAMES :+= StringUtils.capitalize(x))
  context.close()

  def getClasses: Array[Any] = CLASS_NAMES

  def setRule(Class_name:String): Any ={
    context = new AnnotationConfigApplicationContext()
    context.register(Class.forName(CLASS_INJECTION))
    context.register(Class.forName(PACKAGE_NAME + "." + Class_name))
    context.refresh()

    val Rule = context.getBean(Class.forName(CLASS_INJECTION))
    Rule
  }
}
