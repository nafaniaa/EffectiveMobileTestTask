package com.effectivemobile.jobsearch.ui.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    modifier: Modifier
){
   Card(
       modifier = modifier
           .padding(8.dp)
           .fillMaxWidth()

   ) {
       Column(
           horizontalAlignment = Alignment.Start,
           verticalArrangement = Arrangement.Top
       ) {
           vacancy.lookingNumber?.let { 
               Text(
                   text = stringResource(R.string.lookingNow) + "$it" + stringResource(R.string.people)
               )
           }

           vacancy.title?.let {
               Text(
                   text = it,
                   fontWeight = FontWeight(500),
                   fontSize = 16.sp,
               )
           }

           vacancy.salary?.full.let {
               Text(
                   text = it.toString(),
                   fontSize = 20.sp
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

           Row {
               Image(
                   painter = painterResource(R.drawable.job),
                   contentDescription = null,
                   modifier = Modifier
                       .padding(end = 4.dp)
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

           Button(
               shape = RoundedCornerShape(50.dp),
               onClick = { /*TODO*/ },
               modifier = Modifier
                   .width(296.dp)
                   .height(32.dp)
           ) {
               Text(
                   stringResource(R.string.respond),
                   textAlign = TextAlign.Center
               )
           }

       }

   }
}
