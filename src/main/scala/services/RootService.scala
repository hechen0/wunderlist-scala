package services

import com.hechen0.wunderlist_scala.Request
import models.WRoot

/**
  * Created by h on 09/01/2017.
  */
case class RootService() extends BaseService with Request {
  def get: WRoot = get_req("root")
}
