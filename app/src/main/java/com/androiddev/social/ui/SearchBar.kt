package com.androiddev.social.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.androiddev.social.R


@ExperimentalComposeUiApi
@Composable
@OptIn(ExperimentalAnimationApi::class)
fun Search() {
    var showSearch by remember { mutableStateOf(false) }
    IconButton(
        onClick = { showSearch = true }) {
        Icon(
            Icons.Outlined.Search,
            contentDescription = "Localized description"
        )
        DropdownMenu(
            offset = DpOffset(0.dp, 10.dp),
            expanded = showSearch,
            onDismissRequest = { showSearch = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.primary.copy(alpha = .5f)
                )
        ) {
            var searchText by remember { mutableStateOf("Search") }
            SearchBar(searchText, "Placeholder",
                { searchText = it }, { searchText = "" })
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun SearchBar(
    searchText: String,
    placeholderText: String = "",
    onSearchTextChanged: (String) -> Unit = {},
    onClearClick: () -> Unit = {},
    onImageOnly: () -> Unit = {},
    onLinksOnly: () -> Unit = {},
    onBoostedOnly: () -> Unit = {},
) {
    var showClearButton by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    Column {
        Row {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp)
                    .onFocusChanged { focusState ->
                        showClearButton = (focusState.isFocused)
                    }
                    .focusRequester(focusRequester),
                value = searchText,
                onValueChange = onSearchTextChanged,
                placeholder = {
                    Text(text = placeholderText)
                },
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                trailingIcon = {
                    AnimatedVisibility(
                        visible = showClearButton,
                        enter = fadeIn(),
                        exit = fadeOut()
                    ) {
                        IconButton(onClick = { onClearClick() }) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "search"
                            )
                        }

                    }
                },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = androidx.compose.ui.text.input.ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                }),
            )


            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }

        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            IconButton(
                modifier = Modifier.padding(8.dp),

                onClick = onImageOnly
            ) {
                Image(
                    painter = painterResource(R.drawable.filter),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.White),
                )
            }
            IconButton(
                modifier = Modifier.padding(8.dp),
                onClick = onLinksOnly
            ) {
                Image(
                    painter = painterResource(R.drawable.media),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.White),
                )
            }
            IconButton(
                modifier = Modifier.padding(8.dp),
                onClick = onBoostedOnly
            ) {
                Image(
                    painter = painterResource(R.drawable.link),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.White),
                )
            }
            IconButton(
                modifier = Modifier.padding(8.dp),
                onClick = onBoostedOnly
            ) {
                Image(
                    painter = painterResource(R.drawable.rocket2),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(Color.White),
                )
            }
        }
    }
}

