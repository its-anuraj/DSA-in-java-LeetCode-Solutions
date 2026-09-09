/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function (functions) {
    return new Promise((resolve, reject) => {
        const result = [];
        let completed = 0;

        if (functions.length === 0) {
            resolve([]);
            return;
        }

        functions.forEach((fn, index) => {
            fn()
                .then(value => {
                    result[index] = value;
                    completed++;

                    if (completed === functions.length) {
                        resolve(result);
                    }
                })
                .catch(reject);
        });
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */