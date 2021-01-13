package com.bg.imusicplayer.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bg.imusicplayer.data.model.obj.xmlobj.Feed


/**
 * Created by Balaji Gaikwad on 10/01/21.
 */
@Dao
interface MusicDao {

    @Query("SELECT * FROM Feed")
    fun getOfflineTopSongs() : LiveData<Feed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTopSongInfo(ResultsItem : Feed)
}