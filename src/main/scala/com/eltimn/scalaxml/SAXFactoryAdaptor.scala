package com.eltimn.scalaxml

import _root_.org.xml.sax.{XMLReader,InputSource}
import _root_.scala.xml.{Node,TopScope}

trait SAXFactoryAdapter extends NonBindingFactoryAdapter {

  /** The method [getReader] has to implemented by
      concrete subclasses */
  def getReader() : XMLReader;

  override def loadXML(source : InputSource) : Node = {
    val reader = getReader()
    reader.setContentHandler(this)
    scopeStack.push(TopScope)
    reader.parse(source)
    scopeStack.pop
    return rootElem
  }
}
