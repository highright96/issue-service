package com.example.issueservice.repository

import arrow.core.Either
import com.example.issueservice.model.Issue
import com.example.issueservice.exception.RepositoryException
import org.springframework.transaction.annotation.Transactional

interface IssueRepository {
    fun save(issue: Issue): Either<RepositoryException, Issue>
}