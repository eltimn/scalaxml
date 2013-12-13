package com.eltimn.scalaxml

import scala.xml.parsing.FactoryAdapter
import scala.xml.factory.NodeFactory
import scala.xml.{Elem, MetaData, NamespaceBinding, Node, Text, TopScope}

trait NonBindingFactoryAdapter extends FactoryAdapter
                               with NodeFactory[Elem] {

  //def nodeContainsText(localName: String) = true

  // methods for NodeFactory[Elem]
  /** constructs an instance of scala.xml.Elem */
  protected def create(pre: String, label: String,
                       attrs: MetaData, scpe: NamespaceBinding,
		       children: Seq[Node]): Elem =
    Elem( pre, label, attrs, scpe, true, children:_* )


  // -- methods for FactoryAdapter
  def createNode(pre: String, label: String,
                 attrs: MetaData, scpe: NamespaceBinding,
                 children: List[Node] ): Elem =
    Elem( pre, label, attrs, scpe, true, children:_* )

  def createText(text: String) = Text(text)

  def createProcInstr(target: String, data: String) =
    makeProcInstr(target, data)
}
