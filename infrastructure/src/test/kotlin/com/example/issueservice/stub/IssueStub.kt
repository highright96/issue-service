package com.example.issueservice.stub

import com.example.issueservice.model.Issue
import com.example.issueservice.model.IssuePriority
import com.example.issueservice.model.IssueStatus
import com.example.issueservice.model.IssueType
import com.example.issueservice.util.genString

object IssueStub {
    fun gen(
        status: IssueStatus = IssueStatus.IN_PROGRESS
    ) =
        Issue(
            summary = genString(),
            description = genString(),
            type = IssueType.TASK,
            priority = IssuePriority.LOW,
            status = status
        )
}