package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

case class WFolderRevision(
  val id: Long,
  val `type`: String,
  val revision: Long
)

object WFolderRevision {
  implicit val listReads: Reads[WFolderRevision] = Json.reads[WFolderRevision]
  implicit def serializeRequest(req: HttpRequest): WFolderRevision = Json.parse(req.asString.body).as[WFolderRevision]
}