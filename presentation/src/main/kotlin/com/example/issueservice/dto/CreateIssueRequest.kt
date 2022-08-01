package com.example.issueservice.dto

import com.example.issueservice.model.IssuePriority
import com.example.issueservice.model.IssueStatus
import com.example.issueservice.model.IssueType

data class CreateIssueRequest(
    val userId: Long,
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus
)