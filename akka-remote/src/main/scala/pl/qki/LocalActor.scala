/*
*  Copyright (c) 2016 ADVA Optical Networking Sp. z o.o.
*  All rights reserved. Any unauthorized disclosure or publication of the confidential and
*  proprietary information to any other party will constitute an infringement of copyright laws.
*
*  Author: Paweł Kukawski, pkukawski@advaoptical.com
*
*  Created: 18/12/2016
*
*  Description:
*/
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
