package no003

import "math"

func lengthOfLongestSubstring(s string) int {
	last := make([]int, 128)

	for i := 0; i < 128; i++ {
		last[i] = -1
	}

	n := len(s)

	res := 0
	start := 0 // 窗口开始位置
	for i := 0; i < n; i++ {
		index := s[i]
		start = int(math.Max(float64(start), float64(last[index]+1)))
		res = int(math.Max(float64(res), float64(i-start+1)))
		last[index] = i
	}

	return res
}
