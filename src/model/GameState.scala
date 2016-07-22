package model

import view.GameArea

class GameState extends Runnable {
  def run() {
    while (true) {
      GameArea.update
      PlayerState.update
      Thread.sleep(30)
    }
  }
}