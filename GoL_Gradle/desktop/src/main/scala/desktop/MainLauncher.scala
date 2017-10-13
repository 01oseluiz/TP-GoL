package main.scala.desktop


import com.badlogic.gdx.backends.lwjgl.{LwjglApplication, LwjglApplicationConfiguration}
import main.scala.Source.GameController.GameController

object MainLauncher {

  def main(arg: Array[String]): Unit = {
    val config = new LwjglApplicationConfiguration
    new LwjglApplication(GameController, config)

    //Resolucao e outras configuracoes graficas do app assim que lancado
    config.width = 640
    config.height = 480
    config.title = "Game of Life"
    config.forceExit = false
    config.vSyncEnabled = true

  }
}
