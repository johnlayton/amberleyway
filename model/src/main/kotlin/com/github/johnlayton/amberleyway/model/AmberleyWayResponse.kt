package com.github.johnlayton.amberleyway.model;

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "AmberleyWayResponse")
@XmlAccessorType(XmlAccessType.FIELD)
data class AmberleyWayResponse(
    @field:XmlElement(name = "id", nillable = false, required = true) val id: Int = 0,
    @field:XmlElement(name = "name", nillable = false, required = true) val name: String = ""
)