package com.vinhbqph33437.baitapbuoi5.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vinhbqph33437.baitapbuoi5.R

class Bai5 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetLayout("Thanh Toán")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GetLayout(title: String = "Thanh Toán", innerPadding: PaddingValues = PaddingValues(0.dp)) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xFF252121))
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        GetTextTitle(title, innerPadding)
        // "Địa chỉ nhận hàng" section
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Địa chỉ nhận hàng",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = "Tri | 22222222 \n 22/333 đường Trung Mỹ Tây 1 \n phường Tân Thới Nhất \n quận 12, Thành phố Hồ Chí Minh", // Replace with actual address
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Left,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            Text(
                text = "Vui Lòng chọn một trong những phương thức sau: ",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
        GetRowItem(color = Color(0xFFeb8b33), imageResId = R.drawable.paypal, text = "Paypal")
        GetRowItem(color = Color(0xFFFFFFFF), imageResId = R.drawable.visa, text = "Visa") // #ffffff
        GetRowItem(color = Color(0xFFd93485), imageResId = R.drawable.momo, text = "Momo") // #d93485
        GetRowItem(color = Color(0xFF57bff7), imageResId = R.drawable.zalo, text = "Zalo Pay") // #57bff7
        GetRowItem(color = Color(0xFF6ee8e8), imageResId = R.drawable.img, text = "Thanh toán trực tiếp") // #6ee8e8

        // Adding the "Next" button at the bottom
        Button(
            onClick = { /* Handle click event */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFed7b57)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .width(60.dp)
        ) {
            Text(
                text = "Tiếp theo",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun GetRowItem(color: Color, imageResId: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = color, shape = RoundedCornerShape(12.dp))
            .height(70.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "",
            modifier = Modifier
                .width(60.dp)
                .padding(10.dp)
        )
        Text(
            text = text,
            modifier = Modifier.weight(1f),
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        RadioButton(selected = false, onClick = { /*TODO*/ })
    }
}

@Composable
fun GetTextTitle(title: String = "Trang chủ", innerPadding: PaddingValues = PaddingValues(0.dp)) {
    Text(
        text = title,
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxWidth(),
        fontSize = 30.sp,
        color = Color.White,
        textAlign = TextAlign.Center
    )
}
