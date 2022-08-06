package com.example.issueservice.service

import com.example.issueservice.dto.CreateIssueCommand
import com.example.issueservice.dto.IssueResult
import com.example.issueservice.dto.IssuesResult
import com.example.issueservice.exception.ifLeftThrow
import com.example.issueservice.model.IssueStatus
import com.example.issueservice.repository.IssueRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class IssueService(
    private val issueRepository: IssueRepository
) {
    fun createIssue(command: CreateIssueCommand): IssueResult {
        val issue = issueRepository.save(command.issue).ifLeftThrow()
        return IssueResult(issue)
    }

    fun getIssues(status: IssueStatus): IssuesResult {
        val issues = issueRepository.findByStatus(status).ifLeftThrow()
        return IssuesResult(issues)
    }
}