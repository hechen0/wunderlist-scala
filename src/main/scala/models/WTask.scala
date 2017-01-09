package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

case class WTask(
  val id: Long,
  val assignee_id: Long,
  val created_at: String,
  val created_by_id: Long,
  val due_date: String,
  val list_id: Long,
  val revision: Long,
  val starred: Boolean,
  val title: String
)

object WTask {
  implicit val listReads: Reads[WTask] = Json.reads[WTask]
  implicit def serializeRequest(req: HttpRequest): WTask = Json.parse(req.asString.body).as[WTask]
  implicit def serializeRequestList(req: HttpRequest): List[WTask] = Json.parse(req.asString.body).as[List[WTask]]
}