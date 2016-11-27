package com.hechen0.wunderlist_scala

import org.scalatest.FlatSpec

class WListSpec extends FlatSpec {
  "A WList" should "have formatted output string" in {
     val l = new WList(id=1, title="title")
     println(l)
  }
}
