package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

case class WFolder(
  val id: Long,
  val title: String,
  val list_ids: List[Long],
  val `type`: String,
  val revision: Long
)

object WFolder {
  implicit val listReads: Reads[WFolder] = Json.reads[WFolder]
  implicit def serializeRequest(req: HttpRequest): WFolder = Json.parse(req.asString.body).as[WFolder]
  implicit def serializeRequestList(req: HttpRequest): List[WFolder] = Json.parse(req.asString.body).as[List[WFolder]]
}