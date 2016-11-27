package com.hechen0.wunderlist_scala

import org.scalatest.FunSpec

class ClientSpec extends FunSpec {
  it("should have right version") {
    assert(Client.version === "0.0.1")
  }

  it("should return lists"){
    val lists = Client.lists

    for(list <- lists)
      println(list)
  }
}
