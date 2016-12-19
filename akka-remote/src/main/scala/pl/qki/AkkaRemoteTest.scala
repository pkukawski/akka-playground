package pl.qki

import akka.actor.{ActorSystem, Props}

import scala.concurrent.Await
import akka.util.Timeout
import com.typesafe.config.ConfigFactory

import scala.concurrent.duration._

object AkkaRemoteTest extends App {

  val config = ConfigFactory.load()
  val system = ActorSystem(name = "HelloRemoteSystem", config.getConfig("remote-test"))
  val actor = system.actorOf(Props[RemoteActor], name = "RemoteActor")
  implicit val timeout: Timeout = 10 seconds
  implicit val ec = system.dispatcher

  Await.result(system.whenTerminated, 5 minutes)
}
