package com.eltimn.scalaxml

import org.specs.Specification
//import org.specs.runner.JUnit4

//class TagSoupSpecsTest extends JUnit4(TagSoupSpecs)

object TagSoupSpecs extends Specification {

  "ScalaXml TagSoup" should {
    "retrieve a URI and parse response into well-formed XML" in {
      val html = (new TagSoupFactoryAdapter).load("http://www.xml.org/")
      html must haveClass[scala.xml.Elem]
      val firstDivIdTxt = ((html \\ "body" \\ "div").first \ "@id").text
      firstDivIdTxt must_== "pagewrapper"
    }
  }
}
