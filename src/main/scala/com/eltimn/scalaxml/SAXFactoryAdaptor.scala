package com.eltimn.scalaxml

import org.xml.sax.{InputSource, XMLReader}
import scala.xml.{Node, SAXParser, TopScope}

trait SAXFactoryAdapter extends NonBindingFactoryAdapter {

  /** The method [getReader] has to be implemented by
      concrete subclasses */
  def getReader(): XMLReader

  override def loadXML(source: InputSource, parser: SAXParser): Node = {
    val reader = getReader()
    reader.setContentHandler(this)
    scopeStack.push(TopScope)
    reader.parse(source)
    scopeStack.pop
    rootElem
  }
}
