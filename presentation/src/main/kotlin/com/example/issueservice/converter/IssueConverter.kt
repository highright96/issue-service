package com.example.issueservice.converter

import com.example.issueservice.dto.*
import com.example.issueservice.model.Issue

/**
 * Presentation layer converter
 * Presentation layer dto 인 request 를 Application layer 의 dto 인 command 로 변경하거나
 * Application layer 의 dto 인 command 를 Presentation layer dto 인 request 변경함
 * 이때 필요한 도메인 객체 또는 필드를 생성해서 넣어줌
 */
fun CreateIssueRequest.toCommand(): CreateIssueCommand {
    val issue = Issue(
        summary = summary,
        description = description,
        type = type,
        priority = priority,
        status = status
    )
    return CreateIssueCommand(issue)
}

fun IssueResult.toResponse() =
    IssueResponse(
        id = issue.id!!,
        summary = issue.summary,
        description = issue.description,
        type = issue.type,
        priority = issue.priority,
        status = issue.status,
        createdAt = issue.createdAt,
        updatedAt = issue.updatedAt
    )

fun IssuesResult.toResponse() =
    this.issues.map {
        IssueResponse(
            id = it.id!!,
            summary = it.summary,
            description = it.description,
            type = it.type,
            priority = it.priority,
            status = it.status,
            createdAt = it.createdAt,
            updatedAt = it.updatedAt
        )
    }.toList()