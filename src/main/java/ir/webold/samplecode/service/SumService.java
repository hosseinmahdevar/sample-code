package ir.webold.samplecode.service;

import ir.webold.samplecode.domian.dto.SumRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class SumService implements ISumService{
    @Override
    public List<List<Integer>> collectAllSum(SumRequest request){
        List<List<Integer>> result = new ArrayList<>();
        collectAllSum(result,request.getNums(),request.getTarget());
        return result;
    }



    private  void collectAllSum(List<List<Integer>> result,int[] nums, int target)
    {
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        insert(hashMap, 0, -1);
        int sum_so_far = 0;
        for (int index = 0; index < nums.length; index++)
        {
            sum_so_far += nums[index];

            if (hashMap.containsKey(sum_so_far - target))
            {
                List<Integer> list = hashMap.get(sum_so_far - target);
                for (Integer value: list) {
                    store(result,nums, value + 1, index);
                }
            }
            insert(hashMap, sum_so_far, index);
        }
    }
    private  void insert(Map<Integer, List<Integer>> hashMap, Integer key, Integer value)
    {
        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(value);
    }
    private  void store(List<List<Integer>> result,int[] nums, int i, int j)
    {
        result.add(IntStream.range(i, j + 1)
                .mapToObj(k -> nums[k])
                .collect(Collectors.toList()));
    }

}
