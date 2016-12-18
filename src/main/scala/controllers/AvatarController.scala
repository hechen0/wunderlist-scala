package controllers

import com.hechen0.wunderlist_scala.Request
import models.WAvatar

/**
  * Created by h on 18/12/2016.
  */
case class AvatarController() extends Request[WAvatar] {
  def get: WAvatar = {
    get_req("avatar")
  }
}
