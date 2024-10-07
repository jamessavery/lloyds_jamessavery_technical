package com.example.lloyds_jamessavery_technical.data.mapper

import com.example.lloyds_jamessavery_technical.data.model.Procedure
import com.example.lloyds_jamessavery_technical.mock.MockData
import org.junit.Assert.assertEquals
import org.junit.Test

class MapperTest {
    @Test
    fun testMapToProcedure() {
        // given
        val procedureDetailMock = MockData.procedureDetailMock
        val expectedProcedureResult = Procedure(
            procedureDetailMock.uuid,
            procedureDetailMock.icon,
            procedureDetailMock.name,
            listOf(
                "uuid",
                "uuid",
                "uuid",
                "uuid"
            ),
            procedureDetailMock.datePublished,
            procedureDetailMock.duration
        )

        // when
        val procedure = procedureDetailMock.mapToProcedure()

        // then
        assertEquals(expectedProcedureResult.uuid, procedure.uuid)
        assertEquals(expectedProcedureResult.name, procedure.name)
        assertEquals(expectedProcedureResult.icon, procedure.icon)
        assertEquals(expectedProcedureResult.phases.size, procedure.phases.size)
        assertEquals(expectedProcedureResult.phases, procedure.phases)
        assertEquals(expectedProcedureResult.datePublished, procedure.datePublished)
        assertEquals(expectedProcedureResult.duration, procedure.duration)
    }
}