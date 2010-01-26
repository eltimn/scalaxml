package com.eltimn.scalaxml

import _root_.scala.xml.parsing.FactoryAdapter

trait HTMLFactoryAdapter extends FactoryAdapter {

  val emptyElements = Set("area", "base", "br", "col", "hr", "img",
                          "input", "link", "meta", "param")

  def nodeContainsText(localName: String) =
    !(emptyElements contains localName)
}
