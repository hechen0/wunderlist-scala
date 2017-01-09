package services

import com.hechen0.wunderlist_scala.Request
import models.WMembership

/**
  * Created by h on 09/01/2017.
  */
case class MemberShipService() extends Request {
  def list: List[WMembership] = {
    get_req("memberships")
  }

  def add_member(list_id: Long, user_id: Long, muted: Boolean): Boolean = {
    false
  }

  def add_member(list_id: Long, email: String, muted: Boolean): Boolean = {
    false
  }

  def accept_member(revision: Long, state: String, muted: Boolean): Boolean = {
    false
  }

  def delete_member(revision: Long): Boolean = {
    false
  }

  def reject_invite(revision: Long): Boolean = {
    false
  }
}
