package com.eltimn.scalaxml

import org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl

class TagSoupFactoryAdapter extends SAXFactoryAdapter
                            with HTMLFactoryAdapter {
  private val parserFactory = new SAXFactoryImpl
  parserFactory.setNamespaceAware(true)
  //parserFactory.setFeature("http://xml.org/sax/features/validation", false)
  //parserFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false)
  //parserFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false) 
  //parserFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false)

  def getReader() = parserFactory.newSAXParser().getXMLReader()
}
