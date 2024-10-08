package com.example.features.procedures.domain.di

import com.example.features.procedures.data.repository.ProcedureRepository
import com.example.features.procedures.data.repository.ProcedureRepositoryImpl
import com.example.core.services.api.ProcedureApi
import com.example.features.procedures.domain.usecase.ProcedureUsecase
import com.example.features.procedures.domain.usecase.ProcedureUsecaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ProcedureModule {

    @Provides
    @Singleton
    fun provideCharacterRepository(
        procedureApi: ProcedureApi
    ): ProcedureRepository {
        return ProcedureRepositoryImpl(procedureApi)
    }

    @Provides
    @Singleton
    fun provideProcedureUsecase(
        procedureRepository: ProcedureRepository
    ): ProcedureUsecase {
        return ProcedureUsecaseImpl(procedureRepository)
    }

}