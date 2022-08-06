package com.example.issueservice.repository

import arrow.core.Either
import com.example.issueservice.exception.RepositoryException
import com.example.issueservice.model.Issue
import com.example.issueservice.model.IssueStatus

interface IssueRepository {
    fun save(issue: Issue): Either<RepositoryException, Issue>
    fun findByStatus(status: IssueStatus): Either<RepositoryException, List<Issue>>
}