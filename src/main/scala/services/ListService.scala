package services

import com.hechen0.wunderlist_scala.Request
import models.WList

/**
  * Created by h on 09/01/2017.
  */
case class ListService() extends Request {
  def list: List[WList] = {
    get_req("lists")
  }

  def get(id: Long): WList = {
    get_req(s"lists/$id")
  }

  def create(title: String): Boolean = {
    false
  }

  def update(revision: Long, title: String): Boolean = {
    false
  }

  def delete(revision: Long): Boolean = {
    false
  }
}
