package com.annguyenhoang.tracker_presentation.search.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.annguyenhoang.core.R
import com.annguyenhoang.core_ui.LocalSpacing
import com.annguyenhoang.tracker_presentation.components.NutrientInfo
import com.annguyenhoang.tracker_presentation.search.TrackableFoodUiState

@OptIn(ExperimentalCoilApi::class)
@Composable
fun TrackableFoodItem(
    trackableFoodUiState: TrackableFoodUiState,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onAmountChange: (String) -> Unit,
    onTrack: () -> Unit
) {
    val food = trackableFoodUiState.food
    val spacing = LocalSpacing.current

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(5.dp))
            .padding(spacing.spaceSmall)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(5.dp)
            )
            .background(MaterialTheme.colorScheme.surface)
            .clickable { onClick() }
            .padding(end = spacing.spaceMedium)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = food.imageUrl,
                        builder = {
                            crossfade(true)
                            error(R.drawable.ic_burger)
                            fallback(R.drawable.ic_burger)
                        }
                    ),
                    contentDescription = food.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(topStart = 5.dp))
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                Column(
                    modifier = Modifier.align(CenterVertically),
                ) {
                    Text(
                        text = food.name,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(spacing.spaceSmall))
                    Text(
                        text = stringResource(
                            id = R.string.kcal,
                            food.caloriesPer100g
                        ),
                        style = MaterialTheme.typography.displayMedium
                    )
                }
            }
            Row {
                NutrientInfo(
                    name = stringResource(id = R.string.carbs),
                    amount = food.carbsPer100g,
                    unit = stringResource(id = R.string.grams),
                    amountTextSize = 16.sp,
                    unitTextSize = 12.sp,
                    nameTextStyle = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.width(spacing.spaceSmall))
                NutrientInfo(
                    name = stringResource(id = R.string.protein),
                    amount = food.proteinPer100g,
                    unit = stringResource(id = R.string.grams),
                    amountTextSize = 16.sp,
                    unitTextSize = 12.sp,
                    nameTextStyle = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.width(spacing.spaceSmall))
                NutrientInfo(
                    name = stringResource(id = R.string.fat),
                    amount = food.fatPer100g,
                    unit = stringResource(id = R.string.grams),
                    amountTextSize = 16.sp,
                    unitTextSize = 12.sp,
                    nameTextStyle = MaterialTheme.typography.bodyMedium
                )
            }
        }
        AnimatedVisibility(visible = trackableFoodUiState.isExpanded) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(spacing.spaceMedium),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = CenterVertically
            ) {
                Row {
                    BasicTextField(
                        value = trackableFoodUiState.amount,
                        onValueChange = onAmountChange,
                        keyboardOptions = KeyboardOptions(
                            imeAction = if (trackableFoodUiState.amount.isNotBlank()) {
                                ImeAction.Done
                            } else {
                                ImeAction.Default
                            },
                            keyboardType = KeyboardType.Number
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                onTrack()
                                defaultKeyboardAction(ImeAction.Done)
                            }
                        ),
                        singleLine = true,
                        modifier = Modifier
                            .border(
                                shape = RoundedCornerShape(5.dp),
                                width = .5.dp,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            .alignBy(LastBaseline)
                            .padding(spacing.spaceMedium)
                    )
                    Spacer(modifier = Modifier.width(spacing.spaceExtraSmall))
                    Text(
                        text = stringResource(id = R.string.grams),
                        style = MaterialTheme.typography.displayLarge,
                        modifier = Modifier.alignBy(LastBaseline)
                    )
                }
                IconButton(
                    onClick = onTrack,
                    enabled = trackableFoodUiState.amount.isNotBlank()
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = stringResource(id = R.string.track)
                    )
                }
            }
        }
    }
}