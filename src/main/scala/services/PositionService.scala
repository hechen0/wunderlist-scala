package services

import com.hechen0.wunderlist_scala.Request
import models.WPosition

/**
  * Created by h on 09/01/2017.
  */
case class PositionService() extends BaseService with Request{

  def list: List[WPosition] = {
    get_req("list_positions")
  }

  def get(id: Long): WPosition = {
    get_req(s"list_positions/$id")
  }

  def update(id: Long, values: List[Long], revision: Long): Boolean = {
    false
  }

  def task_positions(list_id: Long): List[WPosition] = {
    get_req("task_positions").
      param("list_id", list_id.toString)
  }

  def task_position(id: Long): WPosition = {
    get_req(s"task_positions/$id")
  }

  def update_task_positions(id: Long, values: List[Long], revision: Long): Boolean = {
    false
  }

  def subtask_positions(id: Long, id_type: String): List[WPosition] = {
    get_req("subtask_positions").
      param(parse_type(id_type), id.toString)
  }

  def subtask_position(id: Long): WPosition = {
    get_req(s"subtask_positions/$id")
  }

  def update_subtask_position(id: Long, values: List[Long], revision: Long): Boolean = {
    false
  }

}
