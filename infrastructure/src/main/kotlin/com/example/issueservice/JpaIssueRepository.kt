package com.example.issueservice

import arrow.core.Either
import arrow.core.Either.Left
import arrow.core.Either.Right
import com.example.issueservice.exception.RepositoryException
import com.example.issueservice.model.Issue
import com.example.issueservice.repository.IssueRepository
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Repository
class JpaIssueRepository(
    private val queryFactory: SpringDataQueryFactory,
    private val em: EntityManager
) : IssueRepository {

    @Transactional
    override fun save(issue: Issue): Either<RepositoryException, Issue> =
        try {
            em.persist(issue)
            Right(issue)
        } catch (e: Exception) {
            Left(RepositoryException.DatabaseInternalException(cause = e))
        }
}