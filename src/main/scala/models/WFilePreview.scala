package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

case class WFilePreview ( val url: String,
                          val expires_at: String,
                          val `type`: String
                        )

object WFilePreview {
  implicit val listReads: Reads[WFilePreview] = Json.reads[WFilePreview]
  implicit def serializeRequest(req: HttpRequest): WFilePreview = Json.parse(req.asString.body).as[WFilePreview]
}