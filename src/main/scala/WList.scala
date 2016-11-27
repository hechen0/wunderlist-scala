package com.hechen0.wunderlist_scala

case class WList(
  val id: Long,
  val created_at: String,
  val title: String,
  val list_type: String,
  val `type`: String,
  val revision: Long
)

