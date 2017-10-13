package main.scala.Source.GameEngine

import main.scala.Source.GameView.GameScreen
import main.scala.Source.GameController.Statistics
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import scala.collection.mutable.ListBuffer
import scala.util.control.TailCalls.TailRec
import scala.annotation.tailrec
import scala.collection.mutable


  /**
    * Representa a Game Engine do GoL
    *
    * baseado na implementacao de Breno Xavier, utilizando padrão de design strategy
    */
  @Component
class GameEngine {
  val gameScreen = new GameScreen
  val height = gameScreen.height/10 //Divide pelo lado do quadrado (10)
  val width = gameScreen.width/10

  var cells = Array.ofDim[Cell](height, width)

  val stateStack = new mutable.ArrayStack[Array[Array[Cell]]]

  @Autowired
  var GameMode: EstrategiaDeDerivacao = _

  for (i <- (0 until height)) {
    for (j <- (0 until width)) {
      cells(i)(j) = new Cell
    }
  }


  /**
    * Calcula uma nova geracao do ambiente. Essa implementacao utiliza o
    * algoritmo do Conway, ou seja:
    *
    * a) uma celula morta com exatamente tres celulas vizinhas vivas se torna
    * uma celula viva.
    *
    * b) uma celula viva com duas ou tres celulas vizinhas vivas permanece
    * viva.
    *
    * c) em todos os outros casos a celula morre ou continua morta.
    */

  def nextGeneration {

    val mustRevive = new ListBuffer[Cell]
    val mustKill = new ListBuffer[Cell]

    for (i <- (0 until height)) {
      for (j <- (0 until width)) {
        if (GameMode.shouldRevive(i, j)) {
          mustRevive += cells(i)(j)
        }
        else if ((!GameMode.shouldKeepAlive(i, j)) && cells(i)(j).isAlive) {
          mustKill += cells(i)(j)
        }
      }
    }


    for(cell <- mustRevive) {
      cell.revive
      Statistics.recordRevive
    }

    for(cell <- mustKill) {
      cell.kill
      Statistics.recordKill
    }
  }


  /** MUDAR ISSO PARA SER COM POSICAO DO MOUSEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    * Torna a celula de posicao (i, j) viva
    *
    * @param i posicao vertical da celula
    * @param j posicao horizontal da celula
    */
  def makeCellAlive(i: Int, j: Int) = {
      cells(i)(j).revive
      Statistics.recordRevive
  }


  /** MUDAR ISSO PARA SER COM POSICAO DO MOUSEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
    * Verifica se uma celula na posicao (i, j) estah viva.
    *
    * @param i Posicao vertical da celula
    * @param j Posicao horizontal da celula
    * @return Verdadeiro caso a celula de posicao (i,j) esteja viva.
    *
    */
  def isCellAlive(i: Int, j: Int): Boolean = {
      cells(i)(j).isAlive
  }


  /**
    * Retorna o numero de celulas vivas no ambiente.
    * Esse metodo eh particularmente util para o calculo de
    * estatisticas e para melhorar a testabilidade.
    *
    * @return  numero de celulas vivas.
    */
  def numberOfAliveCells {
    var aliveCells = 0
    for(i <- (0 until height)) {
      for(j <- (0 until width)) {
        if(isCellAlive(i, j)) aliveCells += 1
      }
    }
  }


    /* verifica se uma celula deve ser mantida viva */
    /*def shouldKeepAlive(i: Int, j: Int): Boolean = {
      (cells(i)(j).isAlive) &&
        (numberOfNeighborhoodAliveCells(i, j) == 2 || numberOfNeighborhoodAliveCells(i, j) == 3)
    }

    /* verifica se uma celula deve (re)nascer */
    def shouldRevive(i: Int, j: Int): Boolean = {
      (!cells(i)(j).isAlive) &&
        (numberOfNeighborhoodAliveCells(i, j) == 3)
    }*/



    /** PODE SER QUE FIQUE RUIM NAS BORDAS SUPERIORESSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
      * Computa o numero de celulas vizinhas vivas, dada uma posicao no ambiente
      * de referencia identificada pelos argumentos (i,j).
      */
    def numberOfNeighborhoodAliveCells(i: Int, j: Int): Int = {
      var alive = 0
      var posy = 0
      var posx = 0
      for(a <- (i - 1 to i + 1)) {
        for(b <- (j - 1 to j + 1)) {
          if (!(a==i && b==j) && cells(a)(b).isAlive) alive += 1
          else {
            posy = a
            posx = b
            if (a == -1) posy = height - 1
            else if (a == height) posy = 0
            if (b == -1) posx = width - 1
            else if (b == width) posx = 0
            if (cells(posy)(posx).isAlive) alive += 1
          }
        }
      }
      alive
    }


    def saveState: Unit = stateStack += cells

    def undo: Unit = {
      cells = stateStack.pop()
    }
}
