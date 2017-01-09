package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

/**
  * Created by h on 09/01/2017.
  */
case class WPosition(
                    val id: Long,
                    val values: List[Long],
                    val revision: Long,
                    val `type`: String
                    )

object WPosition {
  implicit val listReads: Reads[WPosition] = Json.reads[WPosition]
  implicit def serializeRequest(req: HttpRequest): WPosition = Json.parse(req.asString.body).as[WPosition]
  implicit def serializeRequestList(req: HttpRequest): List[WPosition] = Json.parse(req.asString.body).as[List[WPosition]]
}
