package services

import com.hechen0.wunderlist_scala.Request
import models.WUser
import play.api.libs.json.Json

/**
  * Created by h on 18/12/2016.
  */
case class UserService() extends Request {
  def current: WUser = {
    get_req("user")
  }

  def list: List[WUser] = {
    get_req("users")
  }
}
