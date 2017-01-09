package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

/**
  * Created by h on 14/12/2016.
  */
case class WAvatar(
  val url: String,
  val size: String
)

object WAvatar {
  implicit val listReads: Reads[WAvatar] = Json.reads[WAvatar]
  implicit def serializeRequest(req: HttpRequest): WAvatar = {
    Json.parse(req.asString.body).as[WAvatar]
  }
}