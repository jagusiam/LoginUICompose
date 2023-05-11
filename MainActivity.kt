package com.learning.compose.loginuicompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learning.compose.loginuicompose.ui.theme.LoginUIComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //LoginUIComposeTheme {
            //}

            //we need a context to display toast message
            //LoginUI(applicationContext)

            LoginUIComposeTheme {
            //we need a context to display toast message
            LoginUI(applicationContext)
            }
        }
    }
}


@Composable
fun LoginUI(context: Context) {
    //email var
    var email by remember{ mutableStateOf("") }
    var password by remember{ mutableStateOf("") }

    /*TODO: Fallo implementando Scaffold: Corregir*/
    Scaffold(
        topBar = {
            //if (password == "" && email == "") {
           TopAppBar(
                title = {
                    //if (password == "")
                        Text(text = "Login")
                    //else
                        //Text(text = "${email}")
                },
                //title = { Text(text = "Login") },
                //actions = {
                //    IconButton(onClick = {/*TODO*/ }) {
                //        Text(text = "Log out")
                //    }
                //}
            )
        }
    ) {
            //paddingValues ->

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

            Text(
                text = "Login",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                color = Color.Red,
                fontSize = 48.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text(text = "Enter your email") },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "persom")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, top = 10.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Enter your password") },
                leadingIcon = {
                    Icon(Icons.Default.Info, contentDescription = "password")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, top = 10.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            OutlinedButton(

                onClick = { logged(email, password, context) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp, top = 10.dp),
                //habilitar el boton solo cuando se introduzca nombre y contraseña
                enabled = (email.isNotEmpty() && password.isNotEmpty()),
                //enabled = false,

            ) {
                Text(
                    text = "Login",
                    textAlign = TextAlign.Center
                )
            }

            
    } //fin column
    } //fin scaffold

} //fin function


//Funcion para imprimir un Toast si se ha logeado o no con exito
//Email y contraseña arbitrarios: Hardcodeado por ahora
fun logged(email: String, password: String, context: Context) {
    if (email == "aga" && password == "abc123.") {
        Toast.makeText(context, "Logged In Successfully", Toast.LENGTH_LONG).show()
    } else {
        Toast.makeText(context, "Logged In Failed", Toast.LENGTH_SHORT).show()
    }
}




