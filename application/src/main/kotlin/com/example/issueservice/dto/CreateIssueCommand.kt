package com.example.issueservice.dto

import com.example.issueservice.model.Issue

/**
 * Command = application layer dto
 * 필요한 domain 객체 또는 필드를 래핑해서 presentation layer 에서 application layer 로 전달
 */
data class CreateIssueCommand(
    val issue: Issue
)
