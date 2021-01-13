package com.bg.imusicplayer.data.model.obj.xmlobj
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root




@Root(name = "attributes")
data class Attributes (

		@field:Element(name="rel")
		val rel : String="",
		@field:Element(name="type")
		val type : String="",
		@field:Element(name="href")
		val href : String=""
)