package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

case class WFile(
  val id: Long,
  val url: String,
  val task_id: Long,
  val user_id: Long,
  val content_type: String,
  val file_name: String,
  val file_size: Long,
  val `type`: String,
  val revision: Long
)

object WFile {
  implicit val listReads: Reads[WFile] = Json.reads[WFile]
  implicit def serializeRequest(req: HttpRequest): WFile = Json.parse(req.asString.body).as[WFile]
  implicit def serializeRequestToList(req: HttpRequest): List[WFile] = Json.parse(req.asString.body).as[List[WFile]]
}

