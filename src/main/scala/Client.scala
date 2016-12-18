package com.hechen0.wunderlist_scala

import controllers._
import play.api.libs.json._

import scala.io.StdIn
import scalaj.http._

object Client {

  val base = "http://a.wunderlist.com/api/v1"
  private val clientId = "b42c3be2c43b557cdce5"
  private val clientSecret =  "790de0151255643c53db60f4e21564c33da986d4b3dd03204b45e2811657"
  private val redirectUri = "http://localhost:4000/auth"

  private[wunderlist_scala] def get_token: String = token
  implicit var token = "58628909f5b2fdfa19ca919211605f2a443cf4853c22552582d33dd47647"

  implicit def convertLongToString(l: Long): String = l.toString
  implicit def requestToJsValue(req: HttpRequest): JsValue = Json.parse(req.asString.body)

  def randomString: String = {
    val r = new scala.util.Random
    val sb = new StringBuilder
    for(i <- 1 to 100){
      sb.append(r.nextPrintableChar)
    }
    sb.toString
  }

  def GetToken {
    println(s"GOTO: https://www.wunderlist.com/oauth/authorize?client_id=$clientId&redirect_uri=$redirectUri&state=random")

    val code = StdIn.readLine("Enter code get: ").trim

    val res = Http("https://www.wunderlist.com/oauth/access_token").postForm(Seq(
      "client_id" -> clientId,
      "client_secret" -> clientSecret,
      "code" -> code
    )).asString.body

    token = (Json.parse(res) \ "access_token").get.toString
    println(token)
  }

  def main(args: Array[String]): Unit = {
  }

  def avatar = AvatarController()
  def user = UserController()
}


