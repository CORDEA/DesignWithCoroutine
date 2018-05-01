package jp.cordea.designwithcoroutine.ui.app

import jp.cordea.designwithcoroutine.api.response.Application

data class AppItemViewModel(
        val title: String,
        val description: String
) {

    companion object {

        fun from(app: Application) =
                AppItemViewModel(app.name, app.surcharge.toString())
    }
}
