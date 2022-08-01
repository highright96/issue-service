package com.example.issueservice.controller

import com.example.issueservice.converter.toCommand
import com.example.issueservice.converter.toResponse
import com.example.issueservice.dto.CreateIssueRequest
import com.example.issueservice.dto.IssueResponse
import com.example.issueservice.service.IssueService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/issues")
class IssueHttpController(
    private val issueService: IssueService
) {
    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun createIssue(@RequestBody request: CreateIssueRequest): IssueResponse {
        val result = issueService.createIssue(request.toCommand())
        return result.toResponse()
    }
}