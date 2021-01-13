package com.bg.imusicplayer.data.model.obj.xmlobj

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root

/**
 * Created by Balaji Gaikwad on 13/1/21.
 */

@Root(strict = false, name = "content")
@Namespace(prefix = "im", reference = "http://itunes.apple.com/rss")
data class Content @JvmOverloads constructor(@field:Element(name="type",required = false)
                                             var type:String="" )
