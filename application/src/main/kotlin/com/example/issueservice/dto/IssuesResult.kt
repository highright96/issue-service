package com.example.issueservice.dto

import com.example.issueservice.model.Issue

data class IssuesResult(
    val issues: List<Issue>
)
