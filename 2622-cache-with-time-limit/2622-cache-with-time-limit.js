var TimeLimitedCache = function () {
    this.cache = new Map();
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration
 * @return {boolean}
 */
TimeLimitedCache.prototype.set = function (key, value, duration) {
    const existing = this.cache.get(key);


    const alreadyExists = existing !== undefined &&
        existing.expiry > Date.now();


    if (existing) {
        clearTimeout(existing.timer);
    }

    const expiry = Date.now() + duration;

    const timer = setTimeout(() => {
        this.cache.delete(key);
    }, duration);

    this.cache.set(key, {
        value: value,
        expiry: expiry,
        timer: timer
    });

    return alreadyExists;
};

/**
 * @param {number} key
 * @return {number}
 */
TimeLimitedCache.prototype.get = function (key) {
    const item = this.cache.get(key);

    if (item === undefined || item.expiry <= Date.now()) {
        if (item) {
            clearTimeout(item.timer);
            this.cache.delete(key);
        }
        return -1;
    }

    return item.value;
};

/**
 * @return {number}
 */
TimeLimitedCache.prototype.count = function () {
    let count = 0;

    for (const [key, item] of this.cache) {
        if (item.expiry > Date.now()) {
            count++;
        }
    }

    return count;
};