package controllers

import com.hechen0.wunderlist_scala.Request
import models.WUser

/**
  * Created by h on 18/12/2016.
  */
case class UserController() extends Request[WUser] {
  def get: WUser = {
    get_req("user")
  }
}
