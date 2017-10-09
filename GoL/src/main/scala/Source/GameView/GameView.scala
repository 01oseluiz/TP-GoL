package Source.GameView

import Source.GameController._
import Source.GameEngine._

import scala.io.StdIn.{readInt, readLine}

/**
 * Representa o componente View do GoL
 * 
 * @author Breno Xavier (baseado na implementacao Java de rbonifacio@unb.br
 */
object GameView {
  
	private final val LINE = "+-----+"
	private final val DEAD_CELL = "|     |"
	private final val ALIVE_CELL = "|  o  |"

	private final val MAKE_CELL_ALIVE = 1
	private final val NEXT_GENERATION = 2
	private final val CHANGE_RULES = 3
	private final val HALT = 4


	private var GameEngine:GameEngine = _
	def UpdateGameEngine(x:GameEngine) = GameEngine = x

  /**
	 * Atualiza o componente view (representado pela classe GameBoard),
	 * possivelmente como uma resposta a uma atualiza��o do jogo.
	 */
	def update {
		printFirstRow
		printLine
		
		for(i <- (0 until GameEngine.height)) {
		  for(j <- (0 until GameEngine.width)) {
		    print(if (GameEngine.isCellAlive(i, j))  ALIVE_CELL else DEAD_CELL);
		  }
		  println("   " + i)
		  printLine
		}
		printOptions
	}
  
  private def printOptions {
	  
	  var option = 0
	  println("\n\n")
	  
	  do{
	    println("Select one of the options: \n \n"); 
			println("[1] Make a cell alive");
			println("[2] Next generation");
			println("[3] Change Rules");
			println("[4] Halt");
		
			print("\n \n Option: ");
			
			option = readInt
	  }while(option == 0)
	  
	  option match {
      case MAKE_CELL_ALIVE => makeCellAlive
      case NEXT_GENERATION => nextGeneration
			case CHANGE_RULES => GameController.changeRules
      case HALT => halt
			case _ => printOptions
    }
	}

	/**
		* Função TEMPORARIA
		*/
	def chooseRules(Rules: Array[Any]): Any ={
		println

		var i=0
		Rules.foreach {x =>
			print("["+i.toString+"] ")
			i+=1
			print(x + "\t")
			if(i%4 == 0) println
		}
		println

		print("Digite um valor de 0 a " + (Rules.size-1).toString + ": ")
		val Entrada = readInt()

		if (Entrada < (Rules).size && Entrada >= 0) Rules(Entrada) else chooseRules(Rules)
	}
  
  private def makeCellAlive {
	  
	  var i = 0
	  var j = 0
	  
	  do {
      print("\n Inform the row number (0 - " + (GameEngine.height - 1) + "): ")
      i = readInt
      
      print("\n Inform the column number (0 - " + (GameEngine.width - 1) + "): ")
      j = readInt
      
    } while(!validPosition(i,j))
      
    GameController.makeCellAlive(i, j)
	}

  private def nextGeneration = GameController.nextGeneration
  private def halt = GameController.halt
	
  private def validPosition(i: Int, j: Int): Boolean = {
		println(i);
		println(j);
		i >= 0 && i < GameEngine.height && j >= 0 && j < GameEngine.width
	}
  
  /* Imprime uma linha usada como separador das linhas do tabuleiro */
	private def printLine() {
	  for(j <- (0 until GameEngine.width)) {
	    print(LINE)
	  }
	  println()
	}
  
  /*
	 * Imprime os identificadores das colunas na primeira linha do tabuleiro
	 */
	private def printFirstRow {
		println("\n \n");
		
		for(j <- (0 until GameEngine.width)) {
		  print("   " + j + "   ")
		}
		println()
	}
  
}