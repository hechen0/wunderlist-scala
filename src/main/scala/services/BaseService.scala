package services

/**
  * Created by h on 09/01/2017.
  */
abstract class BaseService {
  def parse_type(t: String): String = t match {
    case "task" => "task_id"
    case "list" => "list_id"
    case unknown => throw new IllegalArgumentException(unknown)
  }
}
