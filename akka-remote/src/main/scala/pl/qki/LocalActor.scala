package pl.qki

import akka.actor.Actor

class LocalActor extends Actor {

  private val remote = context.actorSelection("akka://HelloRemoteSystem@127.0.0.1:25520/user/RemoteActor")

  final val Max = 100000

  override def receive: Receive = {
    case "START" =>
      remote ! Message(/* Map("a" -> 1, "b" -> 2, "c" -> 3), */ 1)

    case m @ Message(/*body, */ counter) =>
      if(counter < Max)
        sender() ! m
      else {
        println("Shutting down...")
        sender() !  m.copy(id = -1)
        context.system.terminate()
      }
  }
}
