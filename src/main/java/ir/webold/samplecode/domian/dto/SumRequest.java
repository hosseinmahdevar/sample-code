package ir.webold.samplecode.domian.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SumRequest {
    private int target;
    private int[] nums;
}
