package com.example.issueservice.converter

import com.example.issueservice.dto.CreateIssueCommand
import com.example.issueservice.dto.CreateIssueRequest
import com.example.issueservice.dto.IssueResponse
import com.example.issueservice.dto.IssueResult
import com.example.issueservice.model.Issue

fun CreateIssueRequest.toCommand(): CreateIssueCommand {
    val issue = Issue(
        userId = userId,
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
        userId = issue.userId,
        type = issue.type,
        priority = issue.priority,
        status = issue.status,
        createdAt = issue.createdAt,
        updatedAt = issue.updatedAt
    )