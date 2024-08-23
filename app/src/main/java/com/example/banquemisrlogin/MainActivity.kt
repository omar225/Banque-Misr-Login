package com.example.banquemisrlogin

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.banquemisrlogin.ui.theme.BanqueMisrLoginTheme
import com.example.banquemisrlogin.ui.theme.TransparentWineRed
import com.example.banquemisrlogin.ui.theme.WineRed
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BanqueMisrLoginTheme {
                AppHeader()
                LoginFields()
                Footer()
            }
        }
    }
}

@Composable
fun AppHeader(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var isEnglish by remember { mutableStateOf(true) }
    Box(
        modifier = modifier.padding(top = 80.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.bm_icon), contentDescription = "logo",
                modifier = modifier
                    .wrapContentWidth(Alignment.Start)
                    .padding(start = 25.dp)
            )
            TextButton(
                modifier = modifier
                    .padding(end = 15.dp),
                onClick = {
                    val newLocale = if (isEnglish) Locale("ar") else Locale("en")
                    updateLocale(context, newLocale)
                    isEnglish = !isEnglish
                }
            ) {
                Text(
                    text = stringResource(id = R.string.language),
                    color = WineRed,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                        .wrapContentWidth(Alignment.End)


                )
            }
        }
    }

}

@Composable
fun LoginFields(modifier: Modifier = Modifier) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(true) }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 40.dp, end = 25.dp, start = 25.dp)
            .height(720.dp)
            .wrapContentSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.width(350.dp),
        ) {
            TextField(
                modifier = Modifier
                    .border(1.dp, color = Color.Gray, shape = RoundedCornerShape(4.dp))
                    .clip(shape = RoundedCornerShape(4.dp))
                    .width(350.dp),
                value = userName,
                onValueChange = { newText -> userName = newText },
                label = {
                    Text(
                        text = stringResource(id = R.string.username),
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Gray,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = Color.Gray

                )
            )
            TextField(
                modifier = Modifier
                    .border(1.dp, color = Color.Gray, shape = RoundedCornerShape(4.dp))
                    .clip(shape = RoundedCornerShape(4.dp))
                    .width(350.dp),
                value = password,
                onValueChange = { newText -> password = newText },
                label = {
                    Text(
                        text = stringResource(id = R.string.password),
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold,
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_visibility_off_24),
                        contentDescription = "visibilityOff",
                        tint = Color.Gray
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Gray,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = Color.Gray
                ),

                )

            Text(
                text = stringResource(id = R.string.forgotPassword),
                textDecoration = TextDecoration.Underline,
                fontSize = 12.sp,
                modifier = modifier
                    .fillMaxWidth()

            )
            Button(
                colors = ButtonColors(
                    containerColor = if (userName.isNotEmpty() && password.isNotEmpty()) WineRed else TransparentWineRed,
                    contentColor = Color.White,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = modifier
                    .width(350.dp)
                    .height(50.dp),
                onClick = {}
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )

            }
            Row(modifier = modifier.width(345.dp)) {
                Text(
                    text = stringResource(id = R.string.help),
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.wrapContentWidth(Alignment.Start)
                )
                Text(
                    text = stringResource(id = R.string.contact),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 12.sp,
                    color = WineRed,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(start = 4.dp)
                )
            }

            HorizontalDivider(
                thickness = 1.dp,
                modifier = modifier.padding(top = 10.dp)
            )

        }

    }
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
            .offset(x = 0.dp, y = 600.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.width(80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.our_products),
                contentDescription = "products",
                modifier = modifier.size(40.dp)
            )

            Text(
                text = stringResource(id = R.string.ourProducts),
                textAlign = TextAlign.Center,

                )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.width(80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.exchange_rate),
                contentDescription = "products",
                modifier = modifier.size(40.dp)
            )

            Text(
                text = stringResource(id = R.string.xchangeRate),
                textAlign = TextAlign.Center
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.width(80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.security_tips),
                contentDescription = "products",
                modifier = modifier.size(40.dp)
            )

            Text(
                text = stringResource(id = R.string.securityTips),
                textAlign = TextAlign.Center
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.width(80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.nearest_branch_or_atm),
                contentDescription = "products",
                modifier = modifier.size(40.dp)
            )

            Text(
                text = stringResource(id = R.string.nearestBranch),
                textAlign = TextAlign.Center,
            )
        }


    }
}

fun updateLocale(context: Context, locale: Locale) {
    val config = Configuration(context.resources.configuration)
    config.setLocale(locale)
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
}

@Preview(showSystemUi = true)
@Composable
private fun AppPreview() {
    AppHeader()
    LoginFields()
    Footer()
}

