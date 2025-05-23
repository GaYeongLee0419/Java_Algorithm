package dfs.chaeyeon;
class TargetNumber {
    static int cnt = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);
        return cnt;
    }

    public void dfs(int[] numbers, int target, int depth, int sum){
        if(depth == numbers.length){
            if (sum == target){
                cnt++;
            }
            return;
        }
        dfs(numbers,target,depth+1,sum+numbers[depth]);
        dfs(numbers,target,depth+1,sum-numbers[depth]);

    }
}