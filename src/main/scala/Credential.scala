package com.hechen0.wunderlist_scala
/**
  * Created by h on 18/12/2016.
  */
object Credential {

  private var token = ""
  private var cliend_id = ""

  def get_token: String = {
    if(token == "") throw new IllegalArgumentException("token has not been set!")
    token
  }

  def set_token(t: String) = this.token = t

  def get_id: String = {
    if(cliend_id == "") throw new IllegalArgumentException("cliend_id has not been set!")
    cliend_id
  }

  def set_id(t: String) = this.cliend_id = t
}
