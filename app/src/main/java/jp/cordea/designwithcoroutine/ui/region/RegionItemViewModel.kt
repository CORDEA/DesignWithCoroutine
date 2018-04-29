package jp.cordea.designwithcoroutine.ui.region

import jp.cordea.designwithcoroutine.api.response.Region

data class RegionItemViewModel(
        val title: String,
        val description: String
) {

    companion object {

        fun from(region: Region) =
                RegionItemViewModel(region.name, region.continent)
    }
}
