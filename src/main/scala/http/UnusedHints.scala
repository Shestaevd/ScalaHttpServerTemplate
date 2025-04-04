package org.pvgus
package http

import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.model.{HttpEntity, HttpRequest, HttpResponse}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import org.pvgus.http.Server.system
import spray.json.DefaultJsonProtocol._
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

import scala.concurrent.Future

object UnusedHints {

  case class TestObject(name:String) extends SprayJsonSupport with DefaultJsonProtocol
  implicit val testJsonCodec: RootJsonFormat[TestObject] = jsonFormat1(TestObject)

  val postPath: Route = path("test") {
    post {
      entity(as[TestObject]) { entry =>
        ???
      }
    }
  }

  val requestExample: Future[HttpResponse] = Http.singleRequest(
    HttpRequest(
      uri = "http://akka.io",
      entity = HttpEntity("{}")
    )
  )

}
