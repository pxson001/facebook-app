package com.facebook.phonenumbers;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

/* compiled from: education_type */
public class RegexCache {
    private LRUCache<String, Pattern> cache;

    /* compiled from: education_type */
    class LRUCache<K, V> {
        private LinkedHashMap<K, V> map;
        public int size;

        public LRUCache(int i) {
            this.size = i;
            this.map = new LinkedHashMap<K, V>(((i * 4) / 3) + 1, 0.75f, true) {
                protected boolean removeEldestEntry(Entry<K, V> entry) {
                    return size() > LRUCache.this.size;
                }
            };
        }

        public synchronized V get(K k) {
            return this.map.get(k);
        }

        public synchronized void put(K k, V v) {
            this.map.put(k, v);
        }
    }

    public RegexCache(int i) {
        this.cache = new LRUCache(i);
    }

    public Pattern getPatternForRegex(String str) {
        Pattern pattern = (Pattern) this.cache.get(str);
        if (pattern != null) {
            return pattern;
        }
        pattern = Pattern.compile(str);
        this.cache.put(str, pattern);
        return pattern;
    }
}
