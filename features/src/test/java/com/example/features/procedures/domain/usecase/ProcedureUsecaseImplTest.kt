package com.example.features.procedures.domain.usecase

import com.example.features.procedures.data.repository.ProcedureRepository
import com.example.core.mock.MockData
import com.example.core.domain.util.Result
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ProcedureUsecaseImplTest {

    private val procedureRepoMock = mockk<ProcedureRepository>(relaxed = true)

    private lateinit var usecase: ProcedureUsecaseImpl

    private val procedureId = "procedureId"

    @Before
    fun setup() {
        usecase = ProcedureUsecaseImpl(procedureRepoMock)
    }

    @Test
    fun `WHEN getProcedureList() THEN return success`() = runTest {
        // given
        val expectedProcedures = listOf(MockData.procedureMock)
        coEvery { procedureRepoMock.getProcedureList() } returns flowOf(
            Result.Success(
                expectedProcedures
            )
        )

        // when
        val result = usecase.getProcedureList().first()

        // then
        assert(result is Result.Success)
        assertEquals(expectedProcedures, (result as Result.Success).data)
        coVerify { procedureRepoMock.getProcedureList() }
    }

    @Test
    fun `WHEN getProcedureList() THEN return error`() = runTest {
        // given
        val expectedError = Exception("Error")
        coEvery { procedureRepoMock.getProcedureList() } returns flowOf(Result.Error(expectedError))

        // when
        val result = usecase.getProcedureList().first()

        // then
        assert(result is Result.Error)
        assertEquals(expectedError, (result as Result.Error).exception)
        coVerify { procedureRepoMock.getProcedureList() }
    }

    @Test
    fun `WHEN getProcedureDetail() THEN return success`() = runTest {
        // given
        val expectedProcedureDetail = MockData.procedureDetailMock
        coEvery { procedureRepoMock.getProcedureDetail(procedureId) } returns flowOf(
            Result.Success(
                expectedProcedureDetail
            )
        )

        // when
        val result = usecase.getProcedureDetail(procedureId).first()

        // then
        assert(result is Result.Success)
        assertEquals(expectedProcedureDetail, (result as Result.Success).data)
        coVerify { procedureRepoMock.getProcedureDetail(procedureId) }
    }

    @Test
    fun `WHEN getProcedureDetail() THEN return error`() = runTest {
        // given
        val expectedError = Exception("Error")
        coEvery { procedureRepoMock.getProcedureDetail(procedureId) } returns flowOf(
            Result.Error(
                expectedError
            )
        )

        // when
        val result = usecase.getProcedureDetail(procedureId).first()

        // then
        assert(result is Result.Error)
        assertEquals(expectedError, (result as Result.Error).exception)
        coVerify { procedureRepoMock.getProcedureDetail(procedureId) }
    }

}