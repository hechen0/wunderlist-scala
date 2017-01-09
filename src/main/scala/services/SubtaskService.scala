package services

import com.hechen0.wunderlist_scala.Request
import models.WSubtask

/**
  * Created by h on 09/01/2017.
  */
case class SubtaskService() extends BaseService with Request {
  def list(id: Long, id_type: String): List[WSubtask] =
    get_req("subtasks").param(parse_type(id_type), id.toString)

  def completed(completed: Boolean, id: Long, id_type: String): List[WSubtask] =
    get_req("subtasks").
      param(parse_type(id_type), id.toString).
      param("completed", completed.toString)

  def get(id: Long): WSubtask =
    get_req(s"subtasks/$id")

  def create(task_id: Long, title: String, completed: Boolean) = false

  def update(revision: Long, title: String, completed: Boolean) = false

  def delete(id: Long) = false
}
