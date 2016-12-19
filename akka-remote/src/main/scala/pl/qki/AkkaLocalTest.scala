package pl.qki

import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import com.typesafe.config.ConfigFactory

import scala.concurrent.Await
import scala.concurrent.duration._

object AkkaLocalTest extends App {

  val config = ConfigFactory.load()
  val system = ActorSystem(name = "LocalSystem", config.getConfig("local-test"))
  val actor = system.actorOf(Props[LocalActor], name = "LocalActor")
  implicit val timeout: Timeout = 10 seconds
  implicit val ec = system.dispatcher

  actor ! "START"

  Await.result(system.whenTerminated, 5 minutes)
}
