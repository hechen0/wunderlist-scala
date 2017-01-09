package models

import com.hechen0.wunderlist_scala.Request
import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

/**
  * Created by h on 09/01/2017.
  */
case class WNote(
                val id: Long,
                val task_id: Long,
                val content: String,
                val revision: Long
                )

object WNote {
  implicit val listReads: Reads[WNote] = Json.reads[WNote]
  implicit def serializeRequest(req: HttpRequest): WNote = Json.parse(req.asString.body).as[WNote]
  implicit def serializeRequestList(req: HttpRequest): List[WNote] = Json.parse(req.asString.body).as[List[WNote]]
}

