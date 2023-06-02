class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double tot=0;                              
        for(int i=0; i<numbers.length; i++) {   
            tot+=numbers[i];                    
        }
        answer= tot/numbers.length;     
        return answer;
    }
}