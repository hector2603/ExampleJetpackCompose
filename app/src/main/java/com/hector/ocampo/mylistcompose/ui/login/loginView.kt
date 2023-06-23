package com.hector.ocampo.mylistcompose.ui.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hector.ocampo.mylistcompose.R
import com.hector.ocampo.mylistcompose.ui.theme.MyListComposeTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun login( modifier: Modifier = Modifier) {
    var user by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    val context = LocalContext.current

    Box(
        modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.fondo), contentScale = ContentScale.FillBounds)
    ){
        Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally ) {
            Spacer(modifier = modifier.height(175.dp))
            Image(painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo image",
                modifier = Modifier
                    .width(184.dp)
                    .height(184.dp))
            Spacer(modifier = modifier.height(56.dp))
            Text(text = "MyList" , style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = modifier.height(28.dp))
            TextField(
                value = user,
                onValueChange = { user = it },
                label = { Text("Login") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.primaryContainer ),
                leadingIcon = { Icon(painter = painterResource(R.drawable.baseline_person_24) , contentDescription = null)},
            )
            Spacer(modifier = modifier.height(19.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                singleLine = true,
                label = { Text("Password") },
                colors = TextFieldDefaults.textFieldColors(containerColor = MaterialTheme.colorScheme.primaryContainer ),
                leadingIcon = { Icon(painter = painterResource(R.drawable.baseline_password_24) , contentDescription = null)},
                visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { passwordHidden = !passwordHidden }) {
                        val visibilityIcon = if (passwordHidden) painterResource(R.drawable.baseline_visibility_24) else painterResource(R.drawable.baseline_visibility_off_24)
                        val description = if (passwordHidden) "Show password" else "Hide password"
                        Icon(painter = visibilityIcon, contentDescription = description)
                    }
                }
            )
            Spacer(modifier = modifier.height(35.dp))
            Button(onClick = { Toast.makeText(context,"$user  $password ",Toast.LENGTH_LONG).show() }) { Text("Acceder") }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyListComposeTheme {
        login()
    }
}