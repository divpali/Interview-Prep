package Heap;

import java.util.PriorityQueue;

/*
 * a median is a middle number with half the number below and half above
 * if there are 2 medians then you add them and divide by 2.[find average]
 */
public class FindMedianInStream {

	PriorityQueue<Integer> maxHeap, minHeap;
    public FindMedianInStream() {
        maxHeap = new PriorityQueue<Integer>((a,b)->b.compareTo(a));
        minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if(num > findMedian()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
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
    
    public double findMedian() {
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
		FindMedianInStream f = new FindMedianInStream();
		f.addNum(3);
		f.addNum(8);
		f.addNum(6);
		double val1 = f.findMedian();
		System.out.println(val1);
		f.addNum(10);
		f.addNum(9);
		f.addNum(11);
		double val2 = f.findMedian();
		System.out.println(val2);

	}

}
