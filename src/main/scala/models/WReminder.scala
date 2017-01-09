package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

/**
  * Created by h on 09/01/2017.
  */
case class WReminder(
                    val id: Long,
                    val date: String,
                    val task_id: Long,
                    val revision: Long,
                    val `type`: String,
                    val created_at: String,
                    val updated_at: String
                    )

object WReminder {
  implicit val listReads: Reads[WReminder] = Json.reads[WReminder]
  implicit def serializeRequest(req: HttpRequest): WReminder = Json.parse(req.asString.body).as[WReminder]
  implicit def serializeRequestList(req: HttpRequest): List[WReminder] = Json.parse(req.asString.body).as[List[WReminder]]
}

