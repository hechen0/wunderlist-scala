package services

import com.hechen0.wunderlist_scala.Request
import models.WFilePreview

/**
  * Created by h on 04/01/2017.
  */
case class FilePreviewService() extends Request {

  def get(file_id: Long, platform: String, size: String): WFilePreview = {
    get_req("previews").
      param("file_id", file_id.toString()).
      param("platform", platform).
      param("size", size)
  }
}