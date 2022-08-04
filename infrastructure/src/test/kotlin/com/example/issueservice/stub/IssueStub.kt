package com.example.issueservice.stub

import com.example.issueservice.model.Issue
import com.example.issueservice.model.IssuePriority
import com.example.issueservice.model.IssueStatus
import com.example.issueservice.model.IssueType
import com.example.issueservice.util.genString

object IssueStub {
    fun gen() =
        Issue(
            summary = genString(),
            description = genString(),
            type = IssueType.TASK,
            priority = IssuePriority.LOW,
            status = IssueStatus.IN_PROGRESS
        )
}