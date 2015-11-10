package io.circe.scalajs

import io.circe.tests.CirceSuite
import io.circe.generic.auto._
import scala.scalajs.js
import scala.scalajs.js.JSON
import scalajs.js.Dynamic.{literal => sjson}

case class Sample(name: String)

class ScalajsSuite extends CirceSuite {

  test("should decode js.Object to Scala Class") {
    val in = sjson(name = "decode")
    assert(decodeJS[Sample](in).getOrElse(null).name == "decode")
  }

  test("should encode Scala class to js.Object") {
    assert(Sample("encode").asJSAny.asInstanceOf[js.Dynamic].name.toString == "encode")
  }

}
