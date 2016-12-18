package com.hechen0.wunderlist_scala

import org.scalatest.{FunSpec, Matchers}

class ClientSpec extends FunSpec with Matchers {

  Credential.set_id(CredentialFile.get_id)
  Credential.set_token(CredentialFile.get_token)

  it("should work") {
    Client.user.get.name shouldBe CredentialFile.get_name
  }
}
