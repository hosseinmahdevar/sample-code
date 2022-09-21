package ir.webold.samplecode.service;

import ir.webold.samplecode.domian.dto.SumRequest;

import java.util.List;

public interface ISumService {

    public List<List<Integer>> collectAllSum(SumRequest request);
}
