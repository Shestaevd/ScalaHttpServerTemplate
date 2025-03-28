package org.pvgus
package http

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import scala.concurrent.Future

object Server {

  implicit val system: ActorSystem = ActorSystem("HttpServer")

  val route: Route = path("test" / Segment) {  value =>
    get {
      complete(StatusCodes.OK, s"got value: $value")
    }
  }

  def server: Future[Http.ServerBinding] = Http().newServerAt("0.0.0.0", 9090).bind(route)

}
