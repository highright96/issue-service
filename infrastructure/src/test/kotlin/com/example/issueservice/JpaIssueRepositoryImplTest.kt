package com.example.issueservice

import com.example.issueservice.model.IssueStatus
import com.example.issueservice.stub.IssueStub
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

class JpaIssueRepositoryImplTest : IntegrationTest() {

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
        jpaIssueRepository.save(IssueStub.gen(IssueStatus.RESOLVED))
        jpaIssueRepository.save(IssueStub.gen(IssueStatus.TODO))

        // when
        val actual = jpaIssueRepository.findByStatus(IssueStatus.RESOLVED).orNull()

        // then
        assertEquals(1, actual!!.size)
    }
}