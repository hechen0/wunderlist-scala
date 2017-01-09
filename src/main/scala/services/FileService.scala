package services

import com.hechen0.wunderlist_scala.Request
import models.WFile
import play.api.libs.json.Json

/**
  * Created by h on 04/01/2017.
  */
case class FileService() extends Request {

  /**
    * https://developer.wunderlist.com/documentation/endpoints/file
    *
    * @param id actual value
    * @param id_type id type: task or list
    * @return
    */
  def list(id: Long, id_type: String): List[WFile] = {
    val h: String = id_type match {
      case "task" => "task_id"
      case "list" => "list_id"
      case unkownstring => throw new IllegalArgumentException(unkownstring)
    }
    get_req("files").
      param(h, id.toString)
  }

  def get(id: Long): WFile = {
    get_req(s"files/$id")
  }

  def create(upload_id: Long, task_id: Long, local_created_at: String): Unit ={
  }

  def delete(id: Long, revision: Long): Boolean = {
    false
  }
}
