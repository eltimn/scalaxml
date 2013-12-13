package com.eltimn.scalaxml

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers

object TagSoupSpecs extends WordSpec with ShouldMatchers {

  "ScalaXml TagSoup" should {
    "retrieve a URI and parse response into well-formed XML" in {
      val html = (new TagSoupFactoryAdapter).load("http://www.xml.org/")
      val divs = (html \\ "body" \\ "div")
      val firstDivIdTxt = (divs.head \ "@id").text

      divs.length should be > 0
      firstDivIdTxt should be ("pagewrapper")
    }
  }
}
