package com.ahmed.habib.petcare.features.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.ahmed.habib.petcare.R
import com.ahmed.habib.petcare.ui.common.AsyncImage
import com.ahmed.habib.petcare.ui.common.SwipeButton
import com.ahmed.habib.petcare.ui.common.getCatamaranFont
import com.ahmed.habib.petcare.ui.common.getNotoSansFont
import com.ahmed.habib.petcare.ui.theme.Blue0
import com.ahmed.habib.petcare.ui.theme.Blue1
import com.ahmed.habib.petcare.ui.theme.Grey2
import com.ahmed.habib.petcare.ui.theme.Grey3
import com.ahmed.habib.petcare.ui.theme.Grey7


@Composable
fun DashboardContent(
    modifier: Modifier = Modifier,
    drawerStatus: CustomDrawerState,
    onDrawerClick: (CustomDrawerState) -> Unit,
) {

    var searchBarState by remember { mutableStateOf(false) }

    ConstraintLayout(
        modifier = modifier.clickable(
            enabled = drawerStatus == CustomDrawerState.Opened,
        ) {
            onDrawerClick(CustomDrawerState.Closed)
        }
    ) {

        val (toolbar, lineSeparationOne, content, bottomBar) = createRefs()

        Toolbar(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .constrainAs(toolbar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            searchBarStatus = searchBarState,
            onSearchBarStateChanged = { searchBarState = it },
            onDrawerClick = { onDrawerClick(it) },
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(lineSeparationOne) {
                    top.linkTo(toolbar.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            thickness = 1.dp,
            color = Grey7
        )

        Box(
            modifier = Modifier
                .constrainAs(content) {
                    top.linkTo(lineSeparationOne.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(bottomBar.top)
                    height = Dimension.fillToConstraints
                }
        ) {
            EmptyDashBoard(modifier = Modifier.align(Alignment.Center))
        }

        SwipeButton(
            btnName = stringResource(R.string.swipe_to_continue),
            textColor = Blue1,
            icon = R.drawable.right_arrow,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Blue0)
                .constrainAs(bottomBar) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            onSwipeCompleted()
        }
    }
}

@Composable
private fun Toolbar(
    modifier: Modifier,
    userName: String = "Ahmed Adel",
    userImageUrl: String? = null,
    searchBarStatus: Boolean = false,
    onSearchBarStateChanged: (Boolean) -> Unit,
    onDrawerClick: (CustomDrawerState) -> Unit,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(0.7f)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = userImageUrl ?: "",
                contentDescription = "User Image",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.user),
                error = painterResource(id = R.drawable.user)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    text = "Hello,",
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                Text(
                    text = userName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        Box(
            modifier = Modifier
                .weight(1.3f)
                .fillMaxHeight(),
            contentAlignment = Alignment.CenterEnd
        ) {
            if (searchBarStatus) {
                Text(
                    "search",
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clickable { onSearchBarStateChanged(false) }
                )
            } else {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = "Search",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { onSearchBarStateChanged(true) },
                    )

                    VerticalDivider(
                        thickness = 1.dp,
                        color = Grey7,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .width(1.dp)
                            .height(16.dp)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.side_menu),
                        contentDescription = "Menu",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable { onDrawerClick(CustomDrawerState.Opened) },
                    )
                }
            }
        }
    }
}

@Composable
private fun EmptyDashBoard(modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.animals),
            contentDescription = "Empty Dashboard",
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.uh_oh),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = getCatamaranFont(),
            color = Grey3
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.looks_like_you_have_no_profiles_set_up_at_this_moment_add_your_pet_now),
            fontSize = 16.sp,
            color = Grey2,
            fontFamily = getNotoSansFont(),
            textAlign = TextAlign.Center
        )
    }
}

private fun onSwipeCompleted() {
    println("Swipe stopped : ")
    // todo: Navigate to the next screen
}