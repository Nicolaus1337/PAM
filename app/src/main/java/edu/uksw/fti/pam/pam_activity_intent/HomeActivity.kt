
package edu.uksw.fti.pam.pam_activity_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Scaffold

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.uksw.fti.pam.pam_activity_intent.ui.theme.Brownbg
import edu.uksw.fti.pam.pam_activity_intent.ui.theme.Brownnv
import edu.uksw.fti.pam.pam_activity_intent.ui.theme.PAM_Activity_IntentTheme

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAM_Activity_IntentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Home()
                }
            }
        }
    }
}


@Composable
fun Home() {
    Box(modifier = Modifier
        .background(Brownbg)
        .fillMaxSize()
    ) {
        Column {
            Upper()
            Iklan()
            Updates()
            manga1()
            BottomNav()
        }
    }

}

@Composable
fun Upper() {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.mangaplus),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(width = 58.dp)
                    .height(height = 31.dp))
        }
            Box(
                modifier = Modifier
                    .width(width = 108.dp)
                    .height(height = 24.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Brownnv)
                    .padding(5.dp)

            ) {
                Text(
                    text = "Search ",
                    color = Color.White.copy(alpha = 0.58f),
                    textAlign = TextAlign.Center,
                    lineHeight = 16.sp,
                    style = TextStyle(
                        fontSize = 10.sp),
                    modifier = Modifier
                        .width(width = 112.dp)
                        .height(height = 17.dp))
                Icon(

                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "ic:round-search",
                    tint = Color.White.copy(alpha = 0.5f),
                    modifier = Modifier
                        .size(size = 18.dp)
                        )

            }
    }
}

@Composable
fun Iklan () {

    Column(
      modifier = Modifier
          .fillMaxWidth()
          .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.iklan),
            contentDescription = "iklan",
            contentScale = ContentScale.Crop,

            modifier = Modifier
                .width(width = 290.dp)
                .height(height = 108.dp)

                .clip(shape = RoundedCornerShape(13.dp)))
    }


}


@Composable
fun Updates () {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "LATEST UPDATES",
            color = Color.White,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(start = 29.dp, top = 18.dp, bottom = 8.dp))
        var selectedTabIndex by remember {
            mutableStateOf(0)
        }

        TabRow(
            selectedTabIndex = selectedTabIndex,
            backgroundColor = Color.Transparent,
            contentColor = Color.White

        ) {
            Tab(selected = selectedTabIndex == 0, onClick = {
                selectedTabIndex = 0

            }) {
                Text(
                    text = "Past 24 hours       2 days      3 days      4 - 7 days",
                    modifier = Modifier
                        .padding(10.dp)
                )


            }
        }
    }

}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun manga1() {
val items = listOf<MangaView>(
    MangaView("Akane Banashi", "chp 42", R.drawable.akanee),
    MangaView("Oshi No Ko", "chp 42", R.drawable.onk),
    MangaView("Chainsaw Man", "chp 42", R.drawable.csm),
    MangaView("One Piece", "chp 42", R.drawable.op),
    MangaView("Sakamoto Days", "chp 42", R.drawable.skmt),
    MangaView("Kaijuu 8", "chp 42", R.drawable.kaiju)
)


        LazyVerticalGrid(
            cells = GridCells.Fixed(3),

        ) {
            items(items.size) {


                Card(
                    backgroundColor = (Brownnv),
                    modifier = Modifier
                        .width(200.dp)
                        .height(210.dp)
                        .padding(15.dp)
                        
                ) {
                    Image(painter = painterResource(id = items[it].image),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(bottom = 30.dp)

                    )
                    
                    Text(
                        text = items[it].judul,
                        color = Color.White,

                        style = TextStyle(
                            fontSize = 10.sp),
                        modifier = Modifier
                            .width(width = 79.dp)
                            .height(height = 11.dp)
                            .padding(top = 152.dp, start = 5.dp)

                    )

                    Text(
                        text = items[it].chp,
                        color = Color.White.copy(alpha = 0.48f),

                        style = TextStyle(
                            fontSize = 7.sp,
                          ),
                        modifier = Modifier

                            .padding(top = 165.dp, start = 5.dp)

                    )
                }



            }
        }

}

data class MangaView(
    val judul:String,
    val chp:String,
    val image:Int
)

@Composable
fun BottomNav() {

    var bottomState by remember{
        mutableStateOf("Updates")
    }

    Scaffold(
        backgroundColor = (Brownbg),
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 17.dp, topEnd = 17.dp)),
                backgroundColor = (Brownnv),
                contentColor = (Color.White)
            ) {
                BottomNavigationItem(
                    selected = bottomState == "Updates",
                    onClick = { bottomState = "Updates" },
                    label = { Text(text = "Updates", color = Color(0xFFFFA554))},
                    icon = { Icon(
                        painter = painterResource(id = R.drawable.calendar),
                        tint = Color(0xFFFFA554),
                        contentDescription = null, modifier = Modifier
                            .size(size = 25.dp) )}
                )
                BottomNavigationItem(
                    selected = bottomState == "Star",
                    onClick = { bottomState = "Star" },

                    icon = { Icon(
                        painter = painterResource(id = R.drawable.star),
                        contentDescription = null, modifier = Modifier
                            .size(size = 25.dp) )}
                )

                BottomNavigationItem(
                    selected = bottomState == "Explore",
                    onClick = { bottomState = "Explore" },

                    icon = { Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = null, modifier = Modifier
                            .size(size = 25.dp) )}
                )

                BottomNavigationItem(
                    selected = bottomState == "brush",
                    onClick = { bottomState = "Brush" },

                    icon = { Icon(
                        painter = painterResource(id = R.drawable.brush),
                        contentDescription = null, modifier = Modifier
                            .size(size = 25.dp) )}
                )

                BottomNavigationItem(
                    selected = bottomState == "Acc",
                    onClick = { bottomState = "Acc" },

                    icon = { Icon(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = null, modifier = Modifier
                            .size(size = 25.dp) )}
                )

            }
        }
    ) {

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PAM_Activity_IntentTheme {
        Home()
    }
}