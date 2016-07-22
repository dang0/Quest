package controller

import model.PlayerState
import scala.swing.Component
import scala.swing.event._
import scala.swing.event.MouseEntered
import view.GameArea
import scala.swing.event.Key
import scala.swing.Reactor

trait KeyboardController extends Reactor {
  listenTo(GameArea.keys)
	reactions += {
//      case KeyPressed(_,Key.W,_,_) => PlayerState.up = true
//	  case KeyReleased(_,Key.W,_,_) => PlayerState.up = false
//	  case KeyPressed(_,Key.S,_,_) => PlayerState.down = true
//	  case KeyReleased(_,Key.S,_,_) => PlayerState.down = false
      case KeyPressed(_,Key.Space,_,_) => PlayerState.jumping = true
      case KeyReleased(_,Key.Space,_,_) => PlayerState.jumping = false
	  case KeyPressed(_,Key.A,_,_) => PlayerState.left = true
	  case KeyReleased(_,Key.A,_,_) => PlayerState.left = false
	  case KeyPressed(_,Key.D,_,_) => PlayerState.right = true
	  case KeyReleased(_,Key.D,_,_) => PlayerState.right = false
	}
}