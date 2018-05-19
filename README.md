# Think about design with kotlin coroutines

Based on https://github.com/CORDEA/VultrShowcase.

## Pattern

MVVM + Repository

## Overview

### Api Interface

Defined Deferred\<T\> as a return value. I used [JakeWharton's Kotlin Coroutine Adapter](https://github.com/JakeWharton/retrofit2-kotlin-coroutines-adapter) here.

### ApiClient

Defined suspend functions.

### Data source & Repository

Defined suspend functions.

### ViewModel

#### RegionViewModel, RegionDetailViewModel

I think this viewmodels implementation is simple. [Around here.](https://github.com/CORDEA/DesignWithCoroutine/blob/master/app/src/main/java/jp/cordea/designwithcoroutine/ui/region/RegionViewModel.kt#L25-L33)

#### AppViewModel

This viewmodel used actor. I think this implementation is better if it is expected to become complicated. [Around here.](https://github.com/CORDEA/DesignWithCoroutine/blob/master/app/src/main/java/jp/cordea/designwithcoroutine/ui/app/AppViewModel.kt#L32-L51)
