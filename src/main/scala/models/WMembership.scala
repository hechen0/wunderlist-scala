package models

import play.api.libs.json.{Json, Reads}

import scalaj.http.HttpRequest

/**
  * Created by h on 09/01/2017.
  */
case class WMembership (
                      val id: Long
                      )

object WMembership {
  implicit val listReads: Reads[WMembership] = Json.reads[WMembership]
  implicit def serializeRequest(req: HttpRequest): WMembership = Json.parse(req.asString.body).as[WMembership]
  implicit def serializeRequestList(req: HttpRequest): List[WMembership] = Json.parse(req.asString.body).as[List[WMembership]]
}