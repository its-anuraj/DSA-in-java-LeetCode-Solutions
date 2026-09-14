
interface Array<T> {
    groupBy(fn: (item: T) => string): Record<string, T[]>
}


Array.prototype.groupBy = function (fn) {
    return this.reduce((obj, item) => {
        const key = fn(item);

        if (!obj[key]) {
            obj[key] = [];
        }

        obj[key].push(item);

        return obj;
    }, {});
}

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */