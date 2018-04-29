package jp.cordea.designwithcoroutine.ui.login

import android.arch.lifecycle.ViewModel
import android.view.View
import jp.cordea.designwithcoroutine.KeyManager
import javax.inject.Inject

class LoginViewModel : ViewModel() {

    @Inject
    lateinit var keyManager: KeyManager

    @Inject
    lateinit var navigator: LoginNavigator

    var apiKey: String = ""

    val onClick = View.OnClickListener {
        if (apiKey.isEmpty()) {
            return@OnClickListener
        }
        keyManager.set(apiKey)
        navigator.navigateToMain()
    }

    fun start() {
        if (keyManager.get() != null) {
            navigator.navigateToMain()
        }
    }
}
