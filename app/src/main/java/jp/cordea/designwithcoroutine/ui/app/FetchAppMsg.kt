package jp.cordea.designwithcoroutine.ui.app

import jp.cordea.designwithcoroutine.api.response.Application
import kotlinx.coroutines.experimental.CompletableDeferred

sealed class FetchAppMsg {
    class GetResult(
            val response: CompletableDeferred<List<Application>>
    ) : FetchAppMsg()

    object Fetch : FetchAppMsg()
    object ForceFetch : FetchAppMsg()
}
