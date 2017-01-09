package services

import com.hechen0.wunderlist_scala.Request
import models.WReminder

/**
  * Created by h on 09/01/2017.
  */
case class ReminderService() extends BaseService with Request {
  def list(id: Long, id_type: String): List[WReminder] = {
    get_req("reminders").
      param(parse_type(id_type), id.toString)
  }

  def create(task_id: Long, date: String, created_by_device_udid: String): Boolean = {
    false
  }

  def update(id: Long, date: String, revision: String): Boolean = {
    false
  }

  def delete(id: Long, revision: String): Boolean = {
    false
  }
}
