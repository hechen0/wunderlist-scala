package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

/**
  * Created by h on 09/01/2017.
  */
case class WSubtask(
                   val id: Long,
                   val task_id: Long,
                   val created_at: String,
                   val created_by_id: Long,
                   val revision: Long,
                   val title: String
                   )

object WSubtask {
  implicit val listReads: Reads[WSubtask] = Json.reads[WSubtask]
  implicit def serializeRequest(req: HttpRequest): WSubtask = Json.parse(req.asString.body).as[WSubtask]
  implicit def serializeRequestList(req: HttpRequest): List[WSubtask] = Json.parse(req.asString.body).as[List[WSubtask]]
}

