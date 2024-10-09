package com.leeturner

import jakarta.ws.rs.GET
import jakarta.ws.rs.NotFoundException
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import kotlinx.serialization.Serializable

@Path("/rovers")
class MarsRoverResource {

  val rovers = listOf("Spirit", "Opportunity", "Curiosity", "Perseverance", "Sojourner")
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  fun rovers() = rovers.mapIndexed { index, rover ->  
    MarsRover(index, rover)
  }
  
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  fun rover(@PathParam("id") id: Int) : MarsRover {
    val name = rovers.getOrNull(id) ?: throw NotFoundException("The specified mars rover cannot be found")
    return MarsRover(id, name)
  }
}

@Serializable
data class MarsRover(val id: Int, val name: String)