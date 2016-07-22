
import view.GameArea
import model.GameState
import scala.concurrent.ThreadRunner
import scala.swing.SimpleSwingApplication
import scala.swing.MainFrame
import java.awt.Dimension
import java.awt.Color
import view.TileMap

object GameSetup extends SimpleSwingApplication {
  
  def top = new MainFrame {
    title = "QuestTime"
//    preferredSize = new Dimension(500,500)
//    maximumSize = preferredSize
//    minimumSize = preferredSize
//    resizable = false
    centerOnScreen
    
    contents = GameArea
    pack
  }
  
  def start() {
    super.main(Array(""))
    new Thread(new GameState).start
  }
  
}

