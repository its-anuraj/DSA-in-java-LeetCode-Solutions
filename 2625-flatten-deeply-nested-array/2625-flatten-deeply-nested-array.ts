type MultiDimensionalArray = (number | MultiDimensionalArray)[];

var flat = function (arr: MultiDimensionalArray, n: number): MultiDimensionalArray {
    const result: any[] = [];

    function dfs(array: any[], depth: number): void {
        for (const item of array) {
            if (Array.isArray(item) && depth > 0) {
                dfs(item, depth - 1);
            } else {
                result.push(item);
            }
        }
    }

    dfs(arr, n);
    return result;
};