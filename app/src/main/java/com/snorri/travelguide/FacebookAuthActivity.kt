package com.snorri.travelguide

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import java.util.*


class FacebookAuthActivity : AppCompatActivity() {

    private var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facebook_auth)

        var btnLoginFacebook = findViewById<Button>(R.id.login_button)
        val int_redir_to_work = Intent(this,WorkActivity::class.java)

        btnLoginFacebook.setOnClickListener(View.OnClickListener {
            callbackManager = CallbackManager.Factory.create()
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile","email"))
            LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess(loginResult: LoginResult) {
                        Log.d("FacebookAuthActivity","Facebook token: " + loginResult.accessToken)
                        startActivity(int_redir_to_work)
                    }

                    override fun onCancel() {
                        Log.d("FacebookAuthActivity","Facebook onCancel")
                    }

                    override fun onError(error: FacebookException?) {
                        Log.d("FacebookAuthActivity","Facebook onError")
                    }
                })
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode,resultCode,data)
    }
}
