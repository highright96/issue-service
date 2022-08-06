package com.example.issueservice.repository

import com.example.issueservice.JpaIssueRepository
import com.example.issueservice.model.IssueStatus
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

    @Test
    fun `get issues`() {
        // given
        jpaIssueRepository.save(IssueStub.gen(IssueStatus.IN_PROGRESS))
        jpaIssueRepository.save(IssueStub.gen(IssueStatus.TODO))

        // when
        val actual = jpaIssueRepository.findByStatus(IssueStatus.IN_PROGRESS).orNull()

        // then
        assertEquals(1, actual!!.size)
    }
}