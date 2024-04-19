package com.enjot.materialweather.ui.features.conditions

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enjot.materialweather.R
import com.enjot.materialweather.ui.core.indicator.ArrowDegreeIndicator

@Composable
fun WindCard(
    speed: Int,
    degree: Int,
    modifier: Modifier = Modifier
) {
    ConditionCard(
        title = stringResource(R.string.wind),
        headline = speed.toString(),
        description = stringResource(R.string.km_h),
        headlineExtra = "",
        modifier = modifier
    ) {
        ArrowDegreeIndicator(
            degree = degree,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp)
        )
    }
}

@Preview
@Composable
fun WindCardPreview() {
    WindCard(speed = 13, degree = 230)
}