package com.hechen0.wunderlist_scala

import org.scalatest.FunSpec

/**
  * Created by h on 18/12/2016.
  */
class CredentialSpec extends FunSpec {
  describe("credential throw exception"){
    it("should throw exception when didn't proper set") {
      assertThrows[IllegalArgumentException]{
        Credential.get_id
      }

      assertThrows[IllegalArgumentException]{
        Credential.get_token
      }
    }
  }
}
