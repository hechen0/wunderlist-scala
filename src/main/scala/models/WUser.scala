package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

case class WUser(
  val id: Long,
  val name: String,
  val email: String,
  val created_at: String,
  val revision: Long
)

object WUser {
  implicit val listReads: Reads[WUser] = Json.reads[WUser]
  implicit def serializeRequest(req: HttpRequest): WUser = Json.parse(req.asString.body).as[WUser]
  implicit def serializeRequestList(req: HttpRequest): List[WUser] = Json.parse(req.asString.body).as[List[WUser]]
}