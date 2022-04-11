package no001

func twoSum(nums []int, target int) []int {
	tempMap := make(map[int]int)
	for index, num := range nums {
		if _, ok := tempMap[target-num]; ok {
			return []int{index, tempMap[target-num]}
		} else {
			tempMap[num] = index
		}
	}

	return []int{0, 0}
}
