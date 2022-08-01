package com.example.issueservice.service

import com.example.issueservice.dto.CreateIssueCommand
import com.example.issueservice.dto.IssueResult
import com.example.issueservice.exception.unwrap
import com.example.issueservice.repository.IssueRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IssueService(
    private val issueRepository: IssueRepository
) {
    @Transactional
    fun createIssue(command: CreateIssueCommand): IssueResult {
        val issue = issueRepository.save(command.issue).unwrap()
        return IssueResult(issue)
    }
}