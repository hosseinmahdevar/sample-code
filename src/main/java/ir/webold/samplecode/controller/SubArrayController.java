package ir.webold.samplecode.controller;

import ir.webold.samplecode.domian.dto.SumRequest;
import ir.webold.samplecode.service.ISumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rest")
public class SubArrayController {
    private final ISumService service;
    @PostMapping("/sum")
    public ResponseEntity<List<List<Integer>>> getTargetSum(@RequestBody SumRequest req){
        List<List<Integer>> result = service.collectAllSum(req);
        return result.isEmpty()?ResponseEntity.noContent().build():ResponseEntity.ok(result);
    }
}
