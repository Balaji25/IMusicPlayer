package com.bg.callhistory.callback

import com.bg.imusicplayer.data.model.obj.xmlobj.Entry


interface MusicCallback {
    fun onClick(transaction: Entry)
}