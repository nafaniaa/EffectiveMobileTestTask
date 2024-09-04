package com.effectivemobile.jobsearch.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effectivemobile.jobsearch.R
import com.effectivemobile.jobsearch.data.Vacancy

@Composable
fun VacancyCard(
    vacancy: Vacancy,
    isFavorite: Boolean,
    onFavoriteClick: (Boolean) -> Unit,
    modifier: Modifier
){
   Card(
       colors = CardDefaults.cardColors(
           containerColor = MaterialTheme.colorScheme.primary,
           contentColor = Color.White
       ),
       modifier = modifier
           .padding(8.dp)
           .fillMaxWidth()
           .wrapContentHeight()

   ) {
       var favorite by remember { mutableStateOf(isFavorite) }

       Column(
           horizontalAlignment = Alignment.Start,
           verticalArrangement = Arrangement.spacedBy(8.dp),
           modifier = Modifier
               .padding(16.dp)
       ) {
           Row(
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceBetween,
               verticalAlignment = Alignment.Top
           ) {
               vacancy.lookingNumber?.let {
                   Text(
                       text = stringResource(R.string.lookingNow) + " $it " + stringResource(R.string.people),
                       color = MaterialTheme.colorScheme.secondary,
                       fontSize = 12.sp,
                       fontWeight = FontWeight.Light
                   )
               }

               IconButton(
                   onClick = {
                       favorite = !favorite
                       onFavoriteClick(favorite)
                   },
                   modifier = Modifier.size(24.dp)
               ) {
                   Icon(
                       imageVector = if (favorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                       contentDescription = if (favorite) "Remove from favorites" else "Add to favorites",
                       tint = if (favorite) Color.Red else Color.Gray
                   )
               }
           }
           vacancy.title?.let {
               Text(
                   text = it,
                   fontWeight = FontWeight.Normal,
                   fontSize = 16.sp,
               )
           }

           vacancy.salary?.full.let {
               Text(
                   text = it.toString(),
                   fontSize = 20.sp,
                   fontWeight = FontWeight.Bold
               )
           }

           vacancy.address?.let {
               Text(
                   text = it.town.toString(),
                   fontSize = 14.sp
               )
           }

           vacancy.company?.let {
               Text(
                   text = it,
                   fontSize = 14.sp
               )
           }

           Row(
               verticalAlignment = Alignment.CenterVertically
           ) {
               Image(
                   painter = painterResource(R.drawable.job),
                   contentDescription = null,
                   modifier = Modifier
                       .padding(end = 4.dp)
                       .width(16.dp)
                       .height(16.dp)
               )
               vacancy.experience?.previewText.let {
                   Text(
                       text = it.toString(),
                       fontSize = 14.sp
                   )
               }
           }

           vacancy.publishedDate?.let {
               Text(
                   text = it,
                   color = Color(133, 134, 136, 1)
               )
           }


           Box(
               modifier = Modifier
                   .fillMaxWidth()
           ) {
               Button(
                   colors = ButtonDefaults.buttonColors(
                       containerColor = MaterialTheme.colorScheme.secondary,
                       contentColor = Color.White
                   ),
                   shape = RoundedCornerShape(50.dp),
                   onClick = { /*TODO*/ },
                   modifier = Modifier
                       .width(296.dp)
                       .height(40.dp)
                       .align(Alignment.Center)
               ) {
                   Text(
                       stringResource(R.string.respond),
                   )
               }
           }


       }

   }
}
