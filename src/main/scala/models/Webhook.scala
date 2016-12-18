package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

/**
  * Created by h on 18/12/2016.
  */
case class Webhook (
                     val id: Long,
                     val list_id: Long,
                     val membership_id: Long,
                     val membership_type: String,
                     val url: String,
                     val processor_type: String,
                     val configuration: String,
                     val created_at: String,
                     val updated_at: String
)

object Webhook {
  implicit val listReads: Reads[Webhook] = Json.reads[Webhook]
  implicit def serializeRequest(req: HttpRequest): Webhook = Json.parse(req.asString.body).as[Webhook]

}