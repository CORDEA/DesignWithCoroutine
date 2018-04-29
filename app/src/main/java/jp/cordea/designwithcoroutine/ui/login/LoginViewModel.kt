package jp.cordea.designwithcoroutine.ui.login

import android.view.View
import jp.cordea.designwithcoroutine.KeyManager
import jp.cordea.designwithcoroutine.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class LoginViewModel @Inject constructor(
        private val keyManager: KeyManager,
        private val navigator: LoginNavigator
) {
    init {
        if (keyManager.get() != null) {
            navigator.navigateToMain()
        }
    }

    var apiKey: String = ""

    val onClick = View.OnClickListener {
        if (apiKey.isEmpty()) {
            return@OnClickListener
        }
        keyManager.set(apiKey)
        navigator.navigateToMain()
    }
}
