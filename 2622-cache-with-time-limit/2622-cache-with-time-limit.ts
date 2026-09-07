type CacheItem = {
    value: number;
    expiry: number;
    timer: ReturnType<typeof setTimeout>;
};

class TimeLimitedCache {
    private cache: Map<number, CacheItem>;

    constructor() {
        this.cache = new Map();
    }

    set(key: number, value: number, duration: number): boolean {
        const existing = this.cache.get(key);

        const alreadyExists =
            existing !== undefined &&
            existing.expiry > Date.now();

        if (existing) {
            clearTimeout(existing.timer);
        }

        const expiry = Date.now() + duration;

        const timer = setTimeout(() => {
            this.cache.delete(key);
        }, duration);

        this.cache.set(key, {
            value,
            expiry,
            timer
        });

        return alreadyExists;
    }

    get(key: number): number {
        const item = this.cache.get(key);

        if (item === undefined || item.expiry <= Date.now()) {
            if (item) {
                clearTimeout(item.timer);
                this.cache.delete(key);
            }

            return -1;
        }

        return item.value;
    }

    count(): number {
        let count = 0;

        for (const item of this.cache.values()) {
            if (item.expiry > Date.now()) {
                count++;
            }
        }

        return count;
    }
}