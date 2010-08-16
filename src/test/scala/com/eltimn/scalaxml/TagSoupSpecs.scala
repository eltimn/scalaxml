package com.eltimn.scalaxml

import org.specs.Specification
import org.specs.runner.JUnit4

class TagSoupSpecsTest extends JUnit4(TagSoupSpecs)

object TagSoupSpecs extends Specification {

  "ScalaXml TagSoup" should {
    "retrieve a URI and parse response into well-formed XML" in {
      val html = (new TagSoupFactoryAdapter).load("http://www.xml.org/")
      val divs = (html \\ "body" \\ "div")
      val firstDivIdTxt = (divs.head \ "@id").text

      html must haveClass[scala.xml.Elem]
      divs.length must beGreaterThan(0)
      firstDivIdTxt must_== "pagewrapper"
    }
  }
}
