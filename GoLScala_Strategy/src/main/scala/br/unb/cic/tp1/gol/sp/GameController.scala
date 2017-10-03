package br.unb.cic.tp1.gol.sp

/**
 * Relaciona o componente View com o componente Model. 
 * 
 * baseado na implementacao de Breno Xavier, utilizando padrão de design template method
 */
object GameController {
  
  def start {
    GameView.update
  }
  
  def halt() {
    //oops, nao muito legal fazer sysout na classe Controller
    println("\n \n")
    Statistics.display
    System.exit(0)
  }

  def makeCellAlive(i: Int, j: Int) {
    try {
			GameEngine.makeCellAlive(i, j)
			GameView.update
		}
		catch {
		  case ex: IllegalArgumentException => {
		    println(ex.getMessage)
		  }
		}
  }
  
  def nextGeneration {
    GameEngine.nextGeneration
    GameView.update
  }
  
}