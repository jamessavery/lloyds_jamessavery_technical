package com.example.lloyds_jamessavery_technical.data.mapper

import com.example.lloyds_jamessavery_technical.data.model.Procedure
import com.example.lloyds_jamessavery_technical.data.model.ProcedureDetail

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