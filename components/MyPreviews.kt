package com.example.movieapp.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview


@Preview(
   name = "Pixel XL",
   group = "Devices",
   device = Devices.PIXEL_XL,
   showSystemUi = true
)
@Preview(
   name = "Pixel XL",
   group = "Devices",
   device = Devices.PIXEL_2,
   showSystemUi = true
)
@Preview(
   name = "Pixel XL",
   group = "Devices",
   device = Devices.PIXEL_3,
   showSystemUi = true
)
@Preview(
   name = "Pixel XL",
   group = "Devices",
   device = Devices.PIXEL_4,
   showSystemUi = true
)
@Preview(
   name = "Pixel XL",
   group = "Devices",
   device = Devices.PIXEL_C,
   showSystemUi = true
)
annotation class MyDevices


@Preview(
   name = "Large Font",
   group = "Large Font Group",
   fontScale = 1.5f,
   uiMode = UI_MODE_NIGHT_YES,
   showBackground = true
)
@Preview(
   name = "Small Font",
   group = "Small Font Group",
   fontScale = 0.5f,
   uiMode = UI_MODE_NIGHT_YES,
   showBackground = true
)
annotation class FontScalePreview