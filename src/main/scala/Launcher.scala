package org.pvgus

import org.pvgus.http.Server

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Launcher {

  def main(args: Array[String]): Unit = {
    Await.result(Server.server, Duration.Inf)
  }

}
