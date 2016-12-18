package com.hechen0.wunderlist_scala

import java.io.{File, FileReader}

import org.apache.commons.io.FileUtils
import play.api.libs.json.{JsValue, Json}

/**
  * Created by h on 18/12/2016.
  */
object CredentialFile {

  private def content : JsValue = {
    Json.parse(FileUtils.readFileToString(new File("credentials.json"), "UTF-8"))
  }

  def get_id: String = {
    (content \ "id").as[String]
  }

  def get_token: String = {
    (content \ "token").as[String]
  }

  def get_name: String = {
    (content \ "name").as[String]
  }
}
