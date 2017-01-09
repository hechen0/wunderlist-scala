package services

import com.hechen0.wunderlist_scala.Request
import models.{WFolder, WFolderRevision}

/**
  * Created by h on 04/01/2017.
  */
case class FolderService() extends Request {

  /**
    * Get all Folders created by the the current User
    *
    * GET a.wunderlist.com/api/v1/folders
    *
    * @return List[WFolder]
    */
  def list: List[WFolder] = {
    get_req("folders")
  }

  def get(id: Long): WFolder = {
    get_req(s"folders/$id")
  }

  def create(title: String, list_ids: List[Long]): Boolean = {
    false
  }

  def update(revision: Long, title: String, list_ids: List[Long]): Boolean = {
    false
  }

  def delete(revision: Long): Boolean = {
    false
  }

  def revisions: List[WFolderRevision] = {
    get_req("folder_revisions")
  }
}
