package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

/**
  * Created by h on 09/01/2017.
  */
case class WRoot(
                val id: Long,
                val `type`: String,
                val revision: Long,
                val user_id: Long
                )

object WRoot {
  implicit val listReads: Reads[WRoot] = Json.reads[WRoot]
  implicit def serializeRequest(req: HttpRequest): WRoot = Json.parse(req.asString.body).as[WRoot]
}

