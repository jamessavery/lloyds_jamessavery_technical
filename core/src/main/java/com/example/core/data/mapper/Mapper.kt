package com.example.core.data.mapper

import com.example.core.data.model.Procedure
import com.example.core.data.model.ProcedureDetail

fun ProcedureDetail.mapToProcedure(): Procedure {
    return Procedure(
        uuid = this.uuid,
        icon = this.icon,
        name = this.name,
        phases = this.phases.map { this.uuid },
        datePublished = this.datePublished,
        duration = this.duration
    )
}