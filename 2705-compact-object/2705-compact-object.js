/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function (obj) {
    if (Array.isArray(obj)) {
        return obj
            .filter(Boolean)
            .map(compactObject);
    }

    if (obj !== null && typeof obj === "object") {
        const result = {};

        for (const key in obj) {
            if (Boolean(obj[key])) {
                result[key] = compactObject(obj[key]);
            }
        }

        return result;
    }

    return obj;

};