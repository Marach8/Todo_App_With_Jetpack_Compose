package com.example.todoapp.topappbar

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ContentAlpha


@Composable
fun AppBarScreen(viewModel : MainViewModel){
    val searchWidgetState by viewModel.searchWidgetState
    val searchTextState by viewModel.searchTextState

    Scaffold (
        topBar = {
            MainAppBar(
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState,
                onCloseClicked = {
                    viewModel.updateSearchWidgetState(newState = SearchWidgetState.CLOSED)
                    viewModel.updateSearchTextState(newState = "")
                },
                onTextChanged = {
                    viewModel.updateSearchTextState(newState = it)
                },
                onSearchClicked = {
                    Log.d("This is the search text $it", "it")
                },
                onSearchTriggered = {
                    viewModel.updateSearchWidgetState(newState = SearchWidgetState.OPENED)
                }
            )
        }
    ){ padding ->
        Box(
            modifier = Modifier.padding(padding)
        )
    }
}


@Composable
fun MainAppBar(
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onCloseClicked: () -> Unit,
    onTextChanged: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit
){
    when(searchWidgetState){
        SearchWidgetState.CLOSED -> {
            DefaultAppBar(onSearchClicked = onSearchTriggered)
        }
        SearchWidgetState.OPENED -> {
            SearchBar(
                text = searchTextState,
                onTextChanged = onTextChanged,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onSearchClicked
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultAppBar(onSearchClicked: () -> Unit){
    TopAppBar(
        modifier = Modifier.background(
            color = Color.Green
        ),
        title = {Text(text = "Home")},
        actions = {
            IconButton(
                onClick = {onSearchClicked()}
            ) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = "Search Icon",
                    //tint = Color.Yellow
                )
            }
        }
    )
}


@Composable
fun SearchBar(
    text: String,
    onSearchClicked: (String) -> Unit,
    onTextChanged: (String) -> Unit,
    onCloseClicked: () -> Unit,
){
    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .offset(y = 40.dp)
        //shadowElevation = 20.dp,
        //color = Color.Green
    ){
        TextField(
            value = text,
            onValueChange = {onTextChanged(it)},
            modifier = Modifier
                .alpha(ContentAlpha.medium)
                .fillMaxWidth(),
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "Search here...",
                )
            },
            singleLine = true,
            textStyle = TextStyle(fontSize = 20.sp),
            leadingIcon = {
                IconButton(
                    onClick = {},
                    modifier = Modifier.alpha(ContentAlpha.medium)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "Search Icon",
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if(text.isNotEmpty()){
                            onTextChanged("")
                        } else{
                            onCloseClicked()
                        }
                    },
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "Close Icon",
                        //tint = Color.White
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {onSearchClicked(text)}
            ),
            colors = TextFieldDefaults.colors(
                cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun AppbarPreview(){
    //CustomAppbar()
    SearchBar(
        text = "Search something",
        onTextChanged = {},
        onCloseClicked = {},
        onSearchClicked = {}
    )
}