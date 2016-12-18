package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

case class WComment(
  val id: Long
)

object WComment {
  implicit val listReads: Reads[WComment] = Json.reads[WComment]
  implicit def serializeRequest(req: HttpRequest): WComment = Json.parse(req.asString.body).as[WComment]

}