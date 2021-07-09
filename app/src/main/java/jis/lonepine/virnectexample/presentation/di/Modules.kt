package jis.lonepine.virnectexample.presentation.di

import jis.lonepine.virnectexample.BuildConfig
import jis.lonepine.virnectexample.data.remote.NaverApiService
import jis.lonepine.virnectexample.domain.repository.SearchRepository
import jis.lonepine.virnectexample.domain.usecase.SearchItemListUseCase
import jis.lonepine.virnectexample.presentation.ui.detail.viewmodel.DetailViewModel
import jis.lonepine.virnectexample.presentation.ui.main.viewmodel.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModules = module {
    single {
        OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request: Request =
                    chain.request()
                        .newBuilder()
                        .addHeader("X-Naver-Client-Id", "bgPskim1tEIJC9bZ503v")
                        .addHeader("X-Naver-Client-Secret", "EbY52PP1N1")
                        .build()
                chain.proceed(request)
            }
            .addInterceptor(
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    ).build()

    }
    single<CallAdapter.Factory> {
        RxJava3CallAdapterFactory.create()
    }
    single<Converter.Factory> {
        GsonConverterFactory.create()
    }

    single{
        Retrofit.Builder().baseUrl(BuildConfig.API_URL)
            .addCallAdapterFactory(get())
            .addConverterFactory(get())
            .client(get())
            .build().create(NaverApiService::class.java)
    }
}

val useCaseModules = module {
    factory { SearchItemListUseCase(get()) }
}

val repositoryModule = module {
    factory { SearchRepository(get()) }
}

val viewModels = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel() }
}

val moduleList = listOf(networkModules, viewModels, repositoryModule, useCaseModules)