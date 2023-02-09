@file:OptIn(ExperimentalFoundationApi::class)
@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.plcoding.instagramui


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalFoundationApi
@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
   Column(
       modifier = Modifier.fillMaxSize()
   ) {
       TopBar(name ="Efi_Erfun")
       Spacer(modifier = Modifier.height(4.dp))
       ProfileSection()
       Spacer(modifier = Modifier.height(25.dp))
       ButtonSection()
       Spacer(modifier = Modifier.height(25.dp))
       HighlightSection(
           highlights = listOf(
               ImageWithText(
                   image = painterResource(id = R.drawable.mehighlight),
                   text = "me"
               ),
               ImageWithText(
                   image = painterResource(id = R.drawable.uni),
                   text = "uni"
               ),
               ImageWithText(
                   image = painterResource(id = R.drawable.friends),
                   text = "friends"
               ),
               ImageWithText(
                   image = painterResource(id = R.drawable.liverpool),
                   text = "Liverpool"
               )
           ), modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 20.dp)

       )
       Spacer(modifier = Modifier.height(10.dp))
       PostTabView(
           imageWithText = listOf(
               ImageWithText(
                   image = painterResource(id = R.drawable.ic_grid),
                   text = "Posts"
               ),
               ImageWithText(
                   image = painterResource(id = R.drawable.ic_reels),
                   text = "Reels"
               ),
               ImageWithText(
                   image = painterResource(id = R.drawable.ic_igtv),
                   text = "IGTV"
               ),
               ImageWithText(
                   image = painterResource(id = R.drawable.profile),
                   text = "Profile"
               )
           ),
            ){
           selectedTabIndex=it
       }
       when (selectedTabIndex){
           0-> PostSection(
               posts = listOf(
                   painterResource(id = R.drawable.me7),
                   painterResource(id = R.drawable.me6),
                   painterResource(id = R.drawable.me5),
                   painterResource(id = R.drawable.me4),
                   painterResource(id = R.drawable.me3),
                   painterResource(id = R.drawable.me),
                   painterResource(id = R.drawable.me2),
                   painterResource(id = R.drawable.me1)
               )
           , modifier = Modifier.fillMaxWidth()
           )
       }

   }

}

@Composable
fun TopBar(
    name: String,
    modifier: Modifier=Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack
            , contentDescription ="Back"
        , tint = Color.Black
        , modifier = Modifier.size(24.dp)
        )
        Text(
            text = name,
            overflow = TextOverflow.Ellipsis
        , fontSize = 24.sp
        , fontWeight = FontWeight.Bold
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_bell)
            , contentDescription ="Bell"
            , tint = Color.Black
            , modifier = Modifier.size(24.dp)
        )
        Icon(
           painter = painterResource(id = R.drawable.ic_dotmenu)
            , contentDescription ="dotMenu"
            , tint = Color.Black
            , modifier = Modifier.size(20.dp)
        )

    }
}

@Composable
fun ProfileSection(
    modifier: Modifier=Modifier
){
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
            , modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.me),
                modifier = Modifier
                    .weight(3f)
                    .size(100.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(
                modifier = Modifier
                    .weight(7f)
            )

        }
        ProfileDescription(displayName = "Erfun",
            description ="Allah\n"+"Android developer\n"+"Great things take time don't give up. " ,
            url ="https://youtube.com/c/ErfunAndroid" ,
            followedBy = listOf("saeedzarezadh","JohneySins")
            , otherCount =38)

    }


}

@Composable
fun RoundImage(
    image:Painter,
    modifier: Modifier=Modifier
){
    Image(
        painter = image
        , contentDescription =null
        , contentScale = ContentScale.Crop
    , modifier = modifier
            .aspectRatio(
                1f,
                matchHeightConstraintsFirst = true
            )
            .border(
                color = Color.LightGray, width = 1.dp, shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)

    )


}

@Composable
fun StatSection(
    modifier: Modifier=Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
            ProfileStat(numberString = "8", text ="Posts" )
            ProfileStat(numberString = "867", text ="Followers" )
            ProfileStat(numberString = "441", text ="Following" )
    }

}

@Composable
fun ProfileStat(
    numberString:String,
    text:String,
    modifier: Modifier=Modifier
){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ,modifier =modifier
        ) {
                Text(
                    text = numberString,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
        Spacer(modifier = Modifier.height(4.dp))
                Text(text =text)
    }
}

@Composable
fun ProfileDescription(
    displayName:String,
    description:String,
    url:String,
    followedBy:List<String>,
    otherCount:Int
){
    val letterSpacing=0.5.sp
    val lineHeight=20.sp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Text(text = displayName,
            fontWeight = FontWeight.Bold,
            lineHeight=lineHeight,
            letterSpacing = letterSpacing
        )
        Text(text = description,
            lineHeight=lineHeight,
            letterSpacing = letterSpacing
        )
        Text(text = url,
            lineHeight=lineHeight,
            letterSpacing = letterSpacing,
            color = Color(0xFF3D3D91)
        )
        if (followedBy.isNotEmpty()){
            Text(
                text = buildAnnotatedString {
                    val boldStyle=SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Followed by ")
                    followedBy.onEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index<followedBy.size-1){
                            append(", ")
                        }
                    }
                        if (otherCount>2){
                            append(" and ")
                            pushStyle(boldStyle)
                            append("$otherCount others")
                        }
                }
            , letterSpacing = letterSpacing
            , lineHeight = lineHeight
            )
        }

    }
}

@Composable
fun ButtonSection(
    modifier: Modifier=Modifier
){
    val minWidth=95.dp
    val height=30.dp

    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
    ) {
            ActionButton(
                text ="Following",
                icon = Icons.Default.KeyboardArrowDown,
                modifier = Modifier
                    .defaultMinSize(minWidth)
                    .height(height)
            )
            ActionButton(
                text ="Message",
                modifier = Modifier
                    .defaultMinSize(minWidth)
                    .height(height)
            )
            ActionButton(
                text ="Email",
                modifier = Modifier
                    .defaultMinSize(minWidth)
                    .height(height)
             )
            ActionButton(
                icon = Icons.Default.KeyboardArrowDown,
                modifier = Modifier
                    .size(height)
            )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier=Modifier,
    text: String?=null,
    icon:ImageVector?=null
){
    Row (verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
            ){
            if (text!=null){
                Text(
                    text = text,
                fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            }
            if (icon!=null){
                Icon(
                    imageVector = icon
                    , contentDescription =null
                    , tint = Color.Black
                )
            }
    }
}

@Composable
fun HighlightSection(
    modifier: Modifier=Modifier,
    highlights:List<ImageWithText>
){
    LazyRow(modifier = modifier){
        items(highlights.size){
         Column(
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Center,
             modifier = Modifier
                 .padding(end = 15.dp)
         ) {
             RoundImage(
                 image =highlights[it].image
             , modifier = Modifier.size(70.dp)
             )
             Text(
                 text = highlights[it].text,
                 overflow = TextOverflow.Ellipsis,
                 textAlign = TextAlign.Center
             )
         }

        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier=Modifier,
    imageWithText:List<ImageWithText>,
    onTabSelected: (selectedIndex:Int)->Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)

    TabRow(
        selectedTabIndex =selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {
        imageWithText.onEachIndexed { index, item ->
            Tab(selected =selectedTabIndex==index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor
                , onClick = {
                        selectedTabIndex=index
                        onTabSelected(index)
                }
            ) {
                Icon(
                    painter =item.image ,
                    contentDescription =item.text,
                    tint = if (selectedTabIndex==index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )

            }

        }

    }
}

@Composable
fun PostSection(
    posts:List<Painter>,
    modifier: Modifier=Modifier
        .scale(1.01f)
){
    LazyVerticalGrid(
        cells =GridCells.Fixed(3)
    ){
        items(posts.size){
            Image(painter =posts[it],
                 contentDescription =null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = Color.White
                    )
            )
        }
    }
}

