package main.scala.Source.GameView

import com.badlogic.gdx.graphics.g2d.{BitmapFont, SpriteBatch, TextureAtlas}
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType
import com.badlogic.gdx.graphics.{GL20, OrthographicCamera}
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.{Label, Skin, Table, TextButton}
import com.badlogic.gdx.{Gdx, Input, Screen}
import main.scala.Source.GameEngine.{AliveCell, Cell, EstrategiaDeDerivacao}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
  * Tela inicial
  */
@Component
class GameScreen extends Screen {

  //Varaveis para desenho da ui grafica
  private var batch: SpriteBatch = _ // o lugar a ser desenhada a textura/imagem (papel)



  @Autowired
  var GameMode: EstrategiaDeDerivacao =_

  //Variaveis para a camera
  var width = Gdx.graphics.getWidth
  var height = Gdx.graphics.getHeight
  var cells = Array.ofDim[Cell](width/10, height/10) //Divide pelo lado do quadrado (10) pra ter a quantidade em linahs e colunas
  val camera = new OrthographicCamera(width, height)
  camera.position.set(width/2, height/2, 0)
  camera.update()
  val shapeRenderer = new ShapeRenderer
  shapeRenderer.setProjectionMatrix(camera.combined)


  //Tentativa de criar botao
  private var stage: Stage = _
  private var atlas: TextureAtlas = _
  private var skin: Skin = _
  private var table: Table = _
  private var playButtuon, exitButton: TextButton = _
  private var white: BitmapFont = _
  private var heading: Label = _


  /**
    * Desenha um unica celula
    * @param c celula viva a ser desenhada com sua posicao
    */
  private def drawCell(c: AliveCell) = {
    shapeRenderer.begin(ShapeType.Filled)
    shapeRenderer.setColor(1,1,1,1)             //setando cor branca para as celulas
    shapeRenderer.rect(c.x, c.y, 10, 10)        //10 eh o lado do quadrado
    shapeRenderer.end()
  }

  /**
    * Desenha as celulas da GameView
    */
  //AINDA NAO FUNCIONA
  private def drawAliveCells():Unit={
    shapeRenderer.translate(width, height, 0)
    if(GameView.alive != null){
      GameView.alive.foreach(c => drawCell(c))
    }
  }

  /**
    * Funciona como a create. Eh a primeira coisa executada ao ser chamada
    */
  def show(): Unit = {
    batch = new SpriteBatch //lugar a ser desenhado como um papel
  }

  /**
    * Renderiza constantemente. A mesma coisa que a update
    */
  def render(delta: Float): Unit = {
    Gdx.gl.glClearColor(0, 0, 0, 1) //setando a tela com uma cor
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT) //limpando a tela com a cor


    batch.begin() //comecar a desenhar a textura

    drawAliveCells()

    batch.end() //terminou de desenhar a textura

  }

  def resize(width: Int, height: Int): Unit = {}

  def pause(): Unit = {}

  def resume(): Unit = {}

  def hide(): Unit = {}

  /**
    * Usado para liberar espaco na memoria quando nao se utiliza mais um recurso
    */
  def dispose(): Unit = {
    batch.dispose()
  }
}
