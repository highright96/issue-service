package com.example.issueservice

import arrow.core.Either.Left
import arrow.core.Either.Right
import com.example.issueservice.exception.RepositoryException
import com.example.issueservice.model.Issue
import com.example.issueservice.model.IssueStatus
import com.example.issueservice.repository.IssueRepository
import com.linecorp.kotlinjdsl.querydsl.expression.col
import com.linecorp.kotlinjdsl.spring.data.SpringDataQueryFactory
import com.linecorp.kotlinjdsl.spring.data.listQuery
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

@Repository
class JpaIssueRepository(
    private val queryFactory: SpringDataQueryFactory,
    private val em: EntityManager
) : IssueRepository {

    @Transactional
    override fun save(issue: Issue) =
        try {
            em.persist(issue)
            Right(issue)
        } catch (e: Exception) {
            Left(RepositoryException.DatabaseInternalException(cause = e))
        }

    override fun findByStatus(status: IssueStatus) =
        try {
            val results =
                queryFactory.listQuery<Issue> {
                    select(entity(Issue::class))
                    from(entity(Issue::class))
                    where(col(Issue::status).equal(status))
                    orderBy(col(Issue::createdAt).desc())
                }
            Right(results)
        } catch (e: Exception) {
            Left(RepositoryException.DatabaseInternalException(cause = e))
        }
}