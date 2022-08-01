package com.example.issueservice.repository

import arrow.core.Either
import com.example.issueservice.model.Issue
import com.example.issueservice.exception.RepositoryException

interface IssueRepository {
    fun save(issue: Issue): Either<RepositoryException, Issue>
}