package com.ailenaguino.noteapp.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ailenaguino.noteapp.feature_note.presentation.theme.*

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: String,
    val color: Int,
    @PrimaryKey val id: Int? = null,
) {
    companion object{
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }

}
