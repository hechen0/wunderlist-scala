package com.hechen0.wunderlist_scala

import scalaj.http._
import scala.collection.immutable.HashMap
import play.api.libs.json._
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

object Client {

  val base = "http://a.wunderlist.com/api/v1"
  private val clientId = "b42c3be2c43b557cdce5"
  private val clientSecret =  "790de0151255643c53db60f4e21564c33da986d4b3dd03204b45e2811657"
  private val redirectUri = "http://localhost:4000/auth"
  var token = "58628909f5b2fdfa19ca919211605f2a443cf4853c22552582d33dd47647"

  case class Location(lat: Double, long: Double)

  implicit val locationWriter = new Writes[Location]{
    def writes(location: Location) = Json.obj(
      "lat" -> location.lat,
      "long" -> location.long
      )
  }

  implicit val locationReads: Reads[Location] = (
    (JsPath \ "lat").read[Double] and
    (JsPath \ "long").read[Double]
  )(Location.apply _)

  implicit val listReads: Reads[WList] = Json.reads[WList]
  implicit val taskReads: Reads[WTask] = Json.reads[WTask]
  implicit val userReads: Reads[WUser] = Json.reads[WUser]

  def main(args: Array[String]): Unit = {
    println(tasks(lists(16).id))
  }


  def GetToken {
    println(f"GOTO: https://www.wunderlist.com/oauth/authorize?client_id=$clientId%s&redirect_uri=$redirectUri%s&state=random")

    val code = Console.readLine("Enter code get: ").trim

    val res = Http("https://www.wunderlist.com/oauth/access_token").postForm(Seq(
      "client_id" -> clientId,
      "client_secret" -> clientSecret,
      "code" -> code
      )).asString.body

    token = (Json.parse(res) \ "access_token").get.toString
    println(token)
  }

  //endpoint

  def lists: List[WList] ={
    request("lists").as[List[WList]]
  }

  def list(id: Long): WList ={
    request(s"lists/$id").as[WList]
  }

  def tasks(list_id: Long): List[WTask] = {
    val r = request("tasks", params=Seq("list_id"->list_id.toString))
    println(r)
    r.as[List[WTask]]
  }

  def user: WUser = {
    request("user").as[WUser]
  }

  //convert response to json object
   private def request(
     endpoint: String, 
     method: String="GET", 
     params: Seq[(String, String)]=Seq()): JsValue ={
    val url = f"$base%s/$endpoint%s"
    val re = Http(url)

    Json.parse(re
      .method(method.toUpperCase)
      .compress(true)
      .header("X-Client-ID", clientId)
      .header("X-Access-Token", token)
      .params(params)
      .asString.body)
  }

  def version: String ={
    "0.0.1"
  }

}
