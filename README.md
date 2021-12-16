# 记录

## 26. 删除有序数组中的重复项

注意判断条件

## 34. 在排序数组中查找元素的第一个和最后一个位置

二分应用

## 844. 比较含退格的字符串 

退格的操作，左指针减一

## 76. 最小覆盖子串

1. 在选择最小子字符串时，不要使用subString构建子字符串再进行长度的比较，比较费时。
2. 在存储源字符串时，不要存储所有的字符，这样浪费空间，而且在进行isCoverage操作时会进行没用的比较，只需要存目标子字符串里包含的字母。