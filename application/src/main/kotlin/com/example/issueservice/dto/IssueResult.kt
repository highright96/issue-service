package com.example.issueservice.dto

import com.example.issueservice.model.Issue

/**
 * Result = application layer dto
 * 필요한 domain 객체를 래핑해서 application layer 에서 presentation layer 로 전달
 */
data class IssueResult(
    val issue: Issue
)
