package services

import com.hechen0.wunderlist_scala.Request
import models.WNote

/**
  * Created by h on 09/01/2017.
  */
case class NoteService() extends BaseService with Request {
  def list(id: Long, id_type: String): List[WNote] = get_req("notes").
      param(parse_type(id_type), id.toString)

  def get(id: Long): WNote = get_req(s"notes/$id")

  def create(task_id: Long, content: String): Boolean = {
    false
  }

  def update(id: Long, revision: Long, content: String): Boolean = {
    false
  }

  def delete(id: Long): Boolean = {
    false
  }
}
