package services

import com.hechen0.wunderlist_scala.Request
import models.WTask

/**
  * Created by h on 09/01/2017.
  */
case class TaskService() extends BaseService with Request {
  def list(list_id: Long): List[WTask] =
    get_req("tasks").param("list_id", list_id.toString)

  def completed(completed: Boolean, list_id: Long): List[WTask] =
    get_req("tasks").
      param("completed", completed.toString).
      param("list_id", list_id.toString)

  def get(id: Long): WTask = get_req(s"tasks/$id")

  def create(
              list_id: Long,
              title: String,
              assignee_id: Long,
              completed: Boolean,
              recurrence_type: String,
              recurrence_count: Long,
              due_date: String,
              starred: Boolean
            ) = false
  
}
