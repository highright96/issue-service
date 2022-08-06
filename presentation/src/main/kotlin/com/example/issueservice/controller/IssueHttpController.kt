package com.example.issueservice.controller

import com.example.issueservice.converter.toCommand
import com.example.issueservice.converter.toResponse
import com.example.issueservice.dto.CreateIssueRequest
import com.example.issueservice.dto.IssueResponse
import com.example.issueservice.model.IssueStatus
import com.example.issueservice.service.IssueService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/issues")
class IssueHttpController(
    private val issueService: IssueService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createIssue(
        @RequestBody request: CreateIssueRequest
    ): IssueResponse {
        val result = issueService.createIssue(request.toCommand())
        return result.toResponse()
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getIssues(
        @RequestParam status: IssueStatus
    ): List<IssueResponse> {
        val result = issueService.getIssues(status)
        return result.toResponse()
    }
}