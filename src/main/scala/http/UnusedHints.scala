package org.pvgus
package http

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import spray.json.DefaultJsonProtocol._
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

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

}
