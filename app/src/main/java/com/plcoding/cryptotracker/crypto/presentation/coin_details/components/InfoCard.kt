package com.plcoding.cryptotracker.crypto.presentation.coin_details.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.contentValuesOf
import com.plcoding.cryptotracker.R
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme
import org.w3c.dom.Text

@Composable
fun InfoCard(
    title: String,
    formattedText: String,
    icon: ImageVector,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,

    modifier: Modifier = Modifier
) {
    val defaultTextStyle = LocalTextStyle.current.copy(
        textAlign = TextAlign.Center, fontSize = 14.sp, color = contentColor

    )
    Card(
        shape = RectangleShape,
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer, contentColor = contentColor

        ),
        modifier = modifier
            .padding(8.dp)
            .shadow(
                elevation = 15.dp,
                shape = RectangleShape,
                ambientColor = MaterialTheme.colorScheme.primary,
                spotColor = MaterialTheme.colorScheme.primary
            )

    ) {
        AnimatedContent(
            targetState = icon,
            modifier = Modifier.align(
                alignment = Alignment.CenterHorizontally,

                ),
            label = "IconAnimation",


            ) { icon ->
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .size(75.dp)
                    .padding(top = 16.dp),
                tint = contentColor
            )


        }
        Spacer(modifier = Modifier.height(8.dp))

        AnimatedContent(
            targetState = formattedText,
            modifier = Modifier.align(
                alignment = Alignment.CenterHorizontally,

                ),
            label = "ValueAnimation",


            ) { formattedTextValue ->
            Text(
                text = formattedTextValue, style = defaultTextStyle,
//                color = contentColor,
                modifier = Modifier.padding(horizontal = 16.dp)
            )


        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            color = contentColor,
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(horizontal = 16.dp).padding(bottom = 16.dp)
        )
    }

}

@PreviewLightDark
@Composable
private fun InfoCardPreview() {
    CryptoTrackerTheme {
        InfoCard(
            title = "Price",
            formattedText = "$ 63,153.44",
            icon = ImageVector.vectorResource(R.drawable.dollar),
            modifier = Modifier,
        )

    }
}