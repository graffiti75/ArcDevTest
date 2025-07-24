package com.cericatto.arcdev.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.cericatto.arcdev.R
import com.cericatto.arcdev.data.model.ArcItem
import com.cericatto.arcdev.ui.utils.contentColor
import com.cericatto.arcdev.ui.utils.isLandscapeOrientation

@Composable
fun FlickrListItem(
	index: Int,
	item: ArcItem,
	modifier: Modifier = Modifier
) {
	val cornerShapePadding: Dp = 20.dp
	val isLandscape = isLandscapeOrientation()
	val startPadding = if (isLandscape) {
		5.dp
	} else {
		10.dp
	}
	val endPadding = if (isLandscape) {
		if (index % 2 == 0) 0.dp else 5.dp
	} else {
		10.dp
	}
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.Start,
		modifier = modifier
			.padding(3.dp)
			.fillMaxWidth()
			.wrapContentHeight()
			.padding(15.dp)
	) {
		Text(
			text = "Name: ${item.title}",
			style = TextStyle(
				fontWeight = FontWeight.Bold,
				fontSize = 18.sp
			),
			color = contentColor(),
		)
		RoundedAsyncImage(item)
	}
}

@Composable
fun RowScope.RoundedAsyncImage(
	item: ArcItem
) {
	AsyncImage(
		model = ImageRequest.Builder(LocalContext.current)
			.data(item.media.m)
			.placeholder(R.drawable.placeholder)
			.error(R.drawable.placeholder)
			.build(),
		contentDescription = item.title,
//		contentScale = ContentScale.Crop,
		modifier = Modifier.size(120.dp)
	)
}

@Preview(showBackground = true)
@Composable
fun FlickrListItemPreview() {
	FlickrListItem(
		index = 0,
		item = ArcItem(),
		modifier = Modifier.height(160.dp)
	)
}
