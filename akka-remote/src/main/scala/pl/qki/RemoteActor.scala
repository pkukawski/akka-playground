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

class RemoteActor extends Actor {

  override def receive: Receive = {
    case Message(-1) =>
      context.system.terminate()

    case m @ Message(counter) =>
      sender() ! m.copy(id = counter + 1)
  }

}
