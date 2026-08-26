type Counter = {
    increment: () => number,
    decrement: () => number,
    reset: () => number,
}

function createCounter(init: number): Counter {
    let current: number = init;

    return {
        increment(): number {
            return ++current;
        },

        decrement(): number {
            return --current;
        },

        reset(): number {
            current = init;
            return current;
        }
    };
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */