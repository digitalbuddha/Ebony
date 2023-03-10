package com.androiddev.social.timeline.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.androiddev.social.theme.PaddingSize0_5
import com.androiddev.social.theme.PaddingSize2
import com.androiddev.social.timeline.data.Emoji
import com.androiddev.social.ui.util.EmojiText
import com.androiddev.social.ui.util.emojiText

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Boosted(
    boostedBy: String?,
    boostedAvatar: String?,
    boostedEmojis: List<Emoji>?,
    drawable: Int?,
    modifier: Modifier? = null,
    containerColor: Color = colorScheme.surface,
    onClick: () -> Unit = {}
) {
    boostedBy?.let {
        AssistChip(
            modifier = modifier ?: Modifier
                .height(24.dp)
                .wrapContentWidth()
                .padding(horizontal = PaddingSize0_5),
            colors = AssistChipDefaults.assistChipColors(
                containerColor = containerColor,
                leadingIconContentColor = colorScheme.secondary, labelColor = colorScheme.primary
            ),
            shape = RoundedCornerShape(25, 25, 25, 25),
            onClick = onClick,
            label = {
                val myColorScheme = colorScheme
                val emojiText by remember(key1 = boostedBy) {
                    mutableStateOf(
                        emojiText(
                            boostedBy,
                            emptyList(),
                            emptyList(),
                            boostedEmojis,
                            myColorScheme
                        )
                    )
                }
                Text(
                    text = emojiText.text,
                    style = MaterialTheme.typography.labelSmall.copy(color = colorScheme.primary),
                    inlineContent = emojiText.mapping,
                    maxLines = 1
                )
            },
            leadingIcon = {
                AvatarImage(size = PaddingSize2, url = boostedAvatar, onClick = onClick)
            },
            trailingIcon = {
                if (drawable != null)
                    Image(
                        modifier = Modifier.height(PaddingSize2),
                        painter = painterResource(drawable),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(colorScheme.secondary),
                    )

            }
        )
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Boosted(
    boosted: EmojiText?,
    drawable: Int?,
    boostedAvatar: String?,
    modifier: Modifier? = null,
    containerColor: Color = colorScheme.surface,
    onClick: () -> Unit = {}
) {
    boosted?.let {
        AssistChip(
            modifier = modifier ?: Modifier
                .height(24.dp)
                .wrapContentWidth()
                .padding(horizontal = PaddingSize0_5),
            colors = AssistChipDefaults.assistChipColors(
                containerColor = containerColor,
                leadingIconContentColor = colorScheme.secondary, labelColor = colorScheme.primary
            ),
            shape = RoundedCornerShape(25, 25, 25, 25),
            onClick = onClick,
            label = {
                val myColorScheme = colorScheme
                val emojiText = boosted
                Text(
                    text = emojiText.text,
                    style = MaterialTheme.typography.labelSmall.copy(color = colorScheme.primary),
                    inlineContent = emojiText.mapping,
                    maxLines = 1
                )
            },
            leadingIcon = {
//                AvatarImage(size = PaddingSize2, url = boostedAvatar, onClick = onClick)
            },
            trailingIcon = {
                if (drawable != null)
                    Image(
                        modifier = Modifier.height(PaddingSize2),
                        painter = painterResource(drawable),
                        contentDescription = "",
                        colorFilter = ColorFilter.tint(colorScheme.secondary),
                    )

            }
        )
    }
}
