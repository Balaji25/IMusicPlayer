package com.bg.imusicplayer.data.model.obj.xmlobj

import androidx.room.ColumnInfo
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "rights")
data class Rights (

		@field:Element(name="label" , required=false)
		@ColumnInfo(name = "label_Rights")
		val label : String=""
)