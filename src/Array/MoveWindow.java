package Array;

import java.util.*;

/**
 * @author lihui
 */
public class MoveWindow {
    /**
     * 209. 长度最小的子数组
     *
     * @param target 正整数目标值
     * @param nums   含有 n 个正整数的数组
     * @return 找出该数组中满足其和 ≥ target 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0, fast = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (fast < nums.length) {
            sum += nums[fast];
            while (sum >= target) {
                int len = fast - slow + 1;
                minLen = Math.min(len, minLen);
                sum -= nums[slow++];
            }
            fast++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    /**
     * 76. 最小覆盖子串
     *
     * @param s 字符串
     * @param t 字符串
     * @return s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
     */
    public String minWindow(String s, String t) {
        int subStrLen = Integer.MAX_VALUE;
        Map<Character, Integer> tMap = new HashMap<>(t.length());
        Map<Character, Integer> windowMap = new HashMap<>(t.length());
        for (int i = 0; i < t.length(); i++) {
            Character tmp = t.charAt(i);
            tMap.put(tmp, tMap.getOrDefault(tmp, 0) + 1);
        }

        int windowStart = 0, windowEnd = 0;
        int resStart = -1, resEnd = -1;
        while (windowEnd < s.length()) {
            // 添加一个字母
            Character addToWindow = s.charAt(windowEnd);
            if (tMap.containsKey(addToWindow)) {
                windowMap.put(addToWindow, windowMap.getOrDefault(addToWindow, 0) + 1);
            }
            // 在满足覆盖的情况下，窗口左边界右移
            while (isCoverage(windowMap, tMap)) {
                if (windowEnd - windowStart + 1 < subStrLen) {
                    subStrLen = windowEnd - windowStart + 1;
                    resStart = windowStart;
                    resEnd = windowEnd;
                }
                Character removeFromWindow = s.charAt(windowStart);
                if (windowMap.containsKey(removeFromWindow)) {
                    windowMap.put(removeFromWindow, windowMap.get(removeFromWindow) - 1);
                }
                windowStart++;
            }
            // 窗口右边界右移
            windowEnd++;
        }

        return resStart == -1 ? "" : s.substring(resStart, resEnd + 1);
    }

    private boolean isCoverage(Map<Character, Integer> wMap, Map<Character, Integer> tMap) {
        for (Character key : tMap.keySet()) {
            if (wMap.getOrDefault(key, 0) - tMap.get(key) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 567. 字符串的排列
     *
     * @param s1 字符串
     * @param s2 字符串
     * @return 判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false
     */
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s1Len > s2Len) {
            return false;
        }

        Map<Character, Integer> windowMap = new HashMap<>(s1Len);
        Map<Character, Integer> targetMap = new HashMap<>(s1Len);
        for (int i = 0; i < s1Len; i++) {
            Character tmp = s1.charAt(i);
            targetMap.put(tmp, targetMap.getOrDefault(tmp, 0) + 1);
        }
        // 先把第一个窗口的所有字母添加到表中
        for (int i = 0; i < s1Len; i++) {
            Character tmp = s2.charAt(i);
            windowMap.put(tmp, windowMap.getOrDefault(tmp, 0) + 1);
        }

        int windowEnd = s1Len - 1;
        while (windowEnd < s2Len) {
            // 当前窗口是否是目标的一个排列
            if (isAllIn(windowMap, targetMap)) {
                return true;
            }
            // 窗口右移，添加右边的元素，移除左边的元素，并维护哈希表
            if (windowEnd + 1 < s2Len && targetMap.containsKey(s2.charAt(windowEnd + 1))) {
                windowMap.put(s2.charAt(windowEnd + 1), windowMap.getOrDefault(s2.charAt(windowEnd + 1), 0) + 1);
            }
            windowEnd++;
            if (windowMap.containsKey(s2.charAt(windowEnd - s1Len))) {
                windowMap.put(s2.charAt(windowEnd - s1Len), windowMap.get(s2.charAt(windowEnd - s1Len)) - 1);
            }
        }
        return false;
    }

    private boolean isAllIn(Map<Character, Integer> wMap, Map<Character, Integer> tMap) {
        for (Character key : tMap.keySet()) {
            if (wMap.getOrDefault(key, 0) - tMap.get(key) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 438. 找到字符串中所有字母异位词
     *
     * @param s 字符串
     * @param p 字符串
     * @return 找到 s 中所有 p 的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * 异位词指由相同字母重排列形成的字符串（包括相同的字符串）
     */
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> result = new LinkedList<>();
        if (sLen < pLen) {
            return result;
        }
        Map<Character, Integer> pMap = new HashMap<>(pLen);
        Map<Character, Integer> sMap = new HashMap<>(pLen);
        // 将目标字符串中的字母加入pMap中
        for (int i = 0; i < pLen; i++) {
            Character tmp = p.charAt(i);
            pMap.put(tmp, pMap.getOrDefault(tmp, 0) + 1);
        }
        // 加入字符串s的第一个窗口的字母
        for (int i = 0; i < pLen; i++) {
            Character tmp = s.charAt(i);
            if (pMap.containsKey(tmp)) {
                sMap.put(tmp, sMap.getOrDefault(tmp, 0) + 1);
            }
        }
        int start = 0, end = pLen - 1;
        while (end < sLen) {
            // 是异位词，在结果列表中加入窗口开始索引
            if (isAnagrams(sMap, pMap)) {
                result.add(start);
            }
            // 移动窗口
            // 移除字母
            Character tmp = s.charAt(start);
            if (pMap.containsKey(tmp)) {
                sMap.put(tmp, sMap.get(tmp) - 1);
            }
            start++;
            // 添加字母
            if (end + 1 < sLen && pMap.containsKey(s.charAt(end + 1))) {
                sMap.put(s.charAt(end + 1), sMap.getOrDefault(s.charAt(end + 1), 0) + 1);
            }
            end++;
        }
        return result;
    }

    private boolean isAnagrams(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
        for (Character c : pMap.keySet()) {
            if (sMap.getOrDefault(c, 0) - pMap.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 3. 无重复字符的最长子串
     *
     * @param s 字符串
     * @return 返回其中不含有重复字符的 最长子串 的长度
     */
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxSubLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            while (hasDuplication(map)) {
                Character tmp = s.charAt(start);
                map.put(tmp, map.get(tmp) - 1);
                if (map.get(tmp) == 0) {
                    map.remove(tmp);
                }
                ++start;
            }
            maxSubLen = Math.max(maxSubLen, i - start + 1);
        }
        return maxSubLen;
    }

    private boolean hasDuplication(Map<Character, Integer> map) {
        for (Character key : map.keySet()) {
            if (map.get(key) > 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * GOOD 解法
     *
     * @param s 同上
     * @return 同上
     */
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // map 记录一个字符上一次出现的位置，在重复之后将左指针直接跳转到记录的下一个位置
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        return max;
    }

    /**
     * 904. 水果成篮
     *
     * @param fruits 第 i 棵树产生 fruits[i] 型的水果。
     * @return 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。返回能收集的水果树的最大总量
     */
    public int totalFruit(int[] fruits) {
        final int BASKET = 2;
        int maxFruitNum = 0;
        int start = 0, end = 0;
        // 队列维持两个数，表示两个篮子
        Deque<Integer> currFruit = new LinkedList<>();
        while (end < fruits.length) {
            // 在两个篮子中添加水果
            while (end < fruits.length && currFruit.size() <= BASKET) {
                if (!currFruit.contains(fruits[end])) {
                    if (currFruit.size() < BASKET) {
                        currFruit.add(fruits[end]);
                        end++;
                    } else {
                        break;
                    }
                } else {
                    end++;
                }
            }
            // 记录这种方案能收集的水果数量
            int currNum = end - start;
            if (currNum > maxFruitNum) {
                maxFruitNum = currNum;
            }
            // 移除队列的左值
            if (BASKET == currFruit.size()) {
                int tmp = fruits[end - 1];
                currFruit.clear();
                currFruit.add(tmp);
                for (int j = end - 1; j >= 0; j--) {
                    if (fruits[j] != tmp) {
                        start = j + 1;
                        break;
                    }
                }
            }
        }
        return maxFruitNum;
    }

    /**
     * GOOD 解法
     *
     * @param fruits 同上
     * @return 同上
     */
    public int totalFruit2(int[] fruits) {
        if (fruits == null || fruits.length == 0) {
            return 0;
        }
        int maxLen = 0, left = 0;
        // 这个map相当于是篮子
        Map<Integer, Integer> basket = new HashMap<>(3);
        for (int i = 0; i < fruits.length; i++) {
            // 往篮子中添加水果
            basket.put(fruits[i], basket.getOrDefault(fruits[i], 0) + 1);
            while (basket.size() > 2) {
                // 如果篮子的个数多于两个（其实就是三个），就从左边开始往外拿水果，直到空出来一个篮子，也就是剩两个篮子
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MoveWindow mw = new MoveWindow();
        mw.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        mw.minWindow("a", "a");
        mw.totalFruit(new int[]{1, 0, 1, 4, 1, 4, 1, 2, 3});
        mw.findAnagrams("aba", "ab");
    }
}
