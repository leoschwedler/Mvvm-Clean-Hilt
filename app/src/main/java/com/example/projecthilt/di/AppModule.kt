package com.example.projecthilt.di

import com.example.projecthilt.data.remote.DummyAPI
import com.example.projecthilt.data.repository.UsuarioRepositoryImpl
import com.example.projecthilt.domain.repository.UsuarioRepository
import com.example.projecthilt.domain.usecase.GetUsersUseCase
import com.example.projecthilt.util.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    fun provideDummyAPI(retrofit: Retrofit): DummyAPI{
        return retrofit.create(DummyAPI::class.java)
    }
    @Provides
    fun provideUsuarioRepository(dummyAPI: DummyAPI): UsuarioRepository{
        return UsuarioRepositoryImpl(dummyAPI)
    }
    @Provides
    fun provideGetUsersUseCase(usuarioRepository: UsuarioRepository): GetUsersUseCase{
        return GetUsersUseCase(usuarioRepository)
    }
}