package models

import com.hechen0.wunderlist_scala.Request
import play.api.libs.json._

import scalaj.http.HttpRequest

case class WList (
  val id: Long,
  val created_at: String,
  val title: String,
  val list_type: String,
  val `type`: String,
  val revision: Long
)

object WList {
  implicit val listReads: Reads[WList] = Json.reads[WList]
  implicit def serializeRequest(req: HttpRequest): WList = Json.parse(req.asString.body).as[WList]

}