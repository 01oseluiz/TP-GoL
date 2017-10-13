package main.scala.Source.GameView

import main.scala.Source.GameController.GameController
import main.scala.Source.GameEngine.AliveCell
import main.scala.Source.GameEngine.GameEngine

import scala.io.StdIn.readInt

object GameView {

  //Variavel usada para passar as celulas vivas para a GameEngine
  var alive: List[AliveCell] =_

  //Variavel que mantem a tela ACHO QUE PODE SER RETIRADO
  val screen = new GameScreen


  private var GameEngine:GameEngine = _
  def UpdateGameEngine(x:GameEngine) = GameEngine = x

  /**
    * Atualiza o componente view (representado pela classe GameBoard),
    * possivelmente como uma resposta a uma atualizacao do jogo.
    */
  def update {
    for(i <- (0 until GameEngine.width)) {
      for(j <- (0 until GameEngine.width)) {
        //if (GameEngine.isCellAlive(i, j))
          //FAZER DESENHAR A CELULA AQUI POSICAO DO MOUSE VEZES O LADO DO QUADRADO (10)
      }
    }
  }


  /** MUDAR PARA FAZER ISSO COM BOTOES
    * Função TEMPORARIA
    */
  def chooseRules(Rules: Array[Any]): Any ={
    println

    var i=0
    Rules.foreach {x =>
      print("["+i.toString+"] ")
      i+=1
      print(x + "\t\t\t")
      if(i%2 == 0) println
    }
    println

    print("Digite um valor de 0 a " + (Rules.size-1).toString + ": ")
    val Entrada = readInt()

    if (Entrada < (Rules).size && Entrada >= 0) Rules(Entrada) else chooseRules(Rules)
  }



  //MUDAR PARA FAZER ISSO COM O CLICK DO MOUSE
  private def makeCellAlive {

//    var i = 0
//    var j = 0
//
//    do {
//      print("\n Inform the row number (0 - " + (GameEngine.height - 1) + "): ")
//      i = readInt
//
//      print("\n Inform the column number (0 - " + (GameEngine.width - 1) + "): ")
//      j = readInt
//
//    } while(!validPosition(i,j))

    //GameController.makeCellAlive(i, j)
  }

//  private def nextGeneration = GameController.nextGeneration
//  private def halt = GameController.halt

}
