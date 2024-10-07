package com.example.lloyds_jamessavery_technical.domain.usecase

import com.example.lloyds_jamessavery_technical.data.model.Procedure
import com.example.lloyds_jamessavery_technical.data.repository.ProcedureRepository
import com.example.lloyds_jamessavery_technical.domain.util.Result
import com.example.lloyds_jamessavery_technical.data.model.ProcedureDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProcedureUsecaseImpl @Inject constructor(
    private val procedureRepo: ProcedureRepository
) : ProcedureUsecase {

    override suspend fun getProcedureList(): Flow<Result<List<Procedure>>> {
        return procedureRepo.getProcedureList()
    }

    override suspend fun getProcedureDetail(procedureId: String): Flow<Result<ProcedureDetail>> {
        return procedureRepo.getProcedureDetail(procedureId)
    }

}

interface ProcedureUsecase {
    suspend fun getProcedureList(): Flow<Result<List<Procedure>>>
    suspend fun getProcedureDetail(procedureId: String): Flow<Result<ProcedureDetail>>
}