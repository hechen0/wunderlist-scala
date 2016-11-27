package com.hechen0.wunderlist_scala

case class WUser(
  val id: Long,
  val name: String,
  val email: String,
  val created_at: String,
  val revision: Long
)

