package pl.qki

import akka.actor.Actor

class RemoteActor extends Actor {

  override def receive: Receive = {
    case Message(-1) =>
      context.system.terminate()

    case m @ Message(counter) =>
      sender() ! m.copy(id = counter + 1)
  }

}
