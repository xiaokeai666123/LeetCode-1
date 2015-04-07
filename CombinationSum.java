/*
	Combination Sum 
	Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	The same repeated number may be chosen from C unlimited number of times.

	Note:
		All numbers (including target) will be positive integers.
		Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
		The solution set must not contain duplicate combinations.

	For example, given candidate set 2,3,6,7 and target 7, 
		A solution set is: 
		[7] 
		[2, 2, 3] 
	Tags:Array Backtracking

	和II的 区别在于数组里的数可以无限的试探使用
*/


public class Solution {

	//递归
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> item = new ArrayList<Integer>();
		if (candidates.length == 0 || candidates == null)
			return res;
		Arrays.sort(candidates);
		dfs(candidates, target, 0, item, res);
		return res;
	}

	private void dfs(int[] candidates, int target, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res) {
		if (target < 0)
			return ;

		//dfs终点条件，target值不停在变
		if (target == 0) {
			res.add(new ArrayList<Integer>(item));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			// The same repeated number may be chosen from C unlimited number of times.
			if (i > 0 && candidates[i] == candidates[i - 1])//假如candidates[i]和 [i- 1]相同，则之前已经遍历过该数字的所有情况，因此跳出选下个数字
				continue;//deal with dupicate
				
			item.add(candidates[i]);
			int newTarget = target - candidates[i];//关键
			dfs(candidates, newTarget, i, item, res);
			//之所以不传i+1，是因为The same repeated number may be chosen from C
			//unlimited number of times. num[i]可以任意使用n多次
			item.remove(item.size() - 1);
		}
	}

	//非递归
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> dp = new ArrayList<List<List<Integer>>>();
        for (int i = 1; i <= target; i++) {
            List<List<Integer>> list_i = new ArrayList<List<Integer>>();
            for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                if (i == candidates[j])
                    list_i.add(Arrays.asList(candidates[j]));
                else {
                    for (List<Integer> l : dp.get(i - 1 - candidates[j])) {
                        if (candidates[j] <= l.get(0)) {
                            List<Integer> tmp = new ArrayList<Integer>();
                            tmp.add(candidates[j]);
                            tmp.addAll(l);
                            if (!list_i.contains(tmp))
                                list_i.add(tmp);
                        }
                    }
                }  
            }
            dp.add(list_i);
        }
        return dp.get(target - 1);
    }
}