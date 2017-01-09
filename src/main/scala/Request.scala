package com.hechen0.wunderlist_scala

import play.api.libs.json.Json

import scalaj.http._

trait Request {
  private lazy val base = "http://a.wunderlist.com/api/v1"

  def get_req(endpoint: String): HttpRequest = {
    Http(s"$base/$endpoint")
      .header("X-Client-ID", Credential.get_id)
      .header("X-Access-Token", Credential.get_token)
  }

  def delete_req(endpoint: String) = {

  }
}
