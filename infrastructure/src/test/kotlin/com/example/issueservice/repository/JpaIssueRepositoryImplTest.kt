package com.example.issueservice.repository

import com.example.issueservice.JpaIssueRepository
import com.example.issueservice.stub.IssueStub
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JpaIssueRepositoryImplTest {

    @Autowired
    private lateinit var jpaIssueRepository: JpaIssueRepository

    @Test
    fun `save issue`() {
        // given
        val expected = IssueStub.gen()

        // when
        val actual = jpaIssueRepository.save(expected).orNull()

        // then
        assertEquals(expected, actual)
    }
}