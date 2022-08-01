package com.example.issueservice.dto

import com.example.issueservice.model.Issue

data class CreateIssueCommand(
    val issue: Issue
)
