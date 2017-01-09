package services

import com.hechen0.wunderlist_scala.Request
import models._

/**
  * Created by h on 18/12/2016.
  */
case class AvatarService() extends Request {

  /**
    *
    * @param size, possible options: 25, 28, 30, 32, 50, 54, 56, 60, 64, 108, 128, 135, 256, 270, 512 and original
    * @return new avatar instance
    */
  def get(size: String): WAvatar = {
    val req = get_req("avatar")
    WAvatar(
      url: req.asString.location.getOrElse,
      size: size
    )
  }
}
