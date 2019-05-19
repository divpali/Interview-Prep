package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
	
	PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public SlidingWindowMedian() {
    	 maxHeap = new PriorityQueue<Integer>((a,b)->b.compareTo(a));
         minHeap = new PriorityQueue<Integer>();
	}
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] re = new double[nums.length - k + 1];
        if (re.length == 0) return re;
        
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) getMedianByAddAndRemove(nums[i], null);
            if (i == k -1) re[i - k + 1] = getMedianByAddAndRemove(nums[i], null);
            if (i > k - 1) re[i - k + 1] = getMedianByAddAndRemove(nums[i], nums[i - k]);
        }
        return re;
    }
    
    private double getMedianByAddAndRemove(int add, Integer remove) {
        addNum(add);
        if (remove != null) {
        	removeNum((int) remove);
        }
        return findMedian();
    }
    
    private void addNum(int num) {
        if (num < findMedian()) {
        	maxHeap.add(num);
        } else {
        	minHeap.add(num);
        }
        balance();
    }
    
    private void removeNum(int num) {
        if (maxHeap.peek() == null && minHeap.peek() == null) {
        	return;
        }
        if (maxHeap.peek() != null && maxHeap.peek() >= num) {
        	maxHeap.remove(num);
        }
        else if (minHeap.peek() != null && minHeap.peek() <= num) {
        	minHeap.remove(num);
        }
        balance();
    }
    
    private void balance() {
    	if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    private double findMedian() {
    	if(maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0;
        } else if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        } else {
            return maxHeap.peek();
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SlidingWindowMedian s = new SlidingWindowMedian();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		double[] t = s.medianSlidingWindow(nums, 4);
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + ", ");
		}

	}

}
