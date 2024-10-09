package com.leeturner

import io.quarkus.test.junit.QuarkusTest
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.CoreMatchers.equalTo
import org.junit.jupiter.api.Test

@QuarkusTest
class MarsRoverResourceTest {

  @Test
  fun `mars rover endpoint returns all rovers`() {
    When {
      get("/rovers")
    } Then {
      statusCode(200)
      body(
        "[0].id", equalTo(0),
        "[0].name", equalTo("Spirit"),
        "[1].id", equalTo(1),
        "[1].name", equalTo("Opportunity"),
        "[2].id", equalTo(2),
        "[2].name", equalTo("Curiosity"),
        "[3].id", equalTo(3),
        "[3].name", equalTo("Perseverance"),
        "[4].id", equalTo(4),
        "[4].name", equalTo("Sojourner"),
      )
    }
  }

  @Test
  internal fun `get by id returns a 404 when the rover is not found`() {
    When {
      get("/rovers/9999")
    } Then {
      statusCode(404)
    }
  }
  
  @Test
  fun `get by id returns the correct rover`() {
    When {
      get("/rovers/2")
    } Then {
      statusCode(200)
      body(
        "id", equalTo(2),
        "name", equalTo("Curiosity"),
      )
    }
  }
}