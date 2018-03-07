package com.facebook.fbtrace;

import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: file_path */
public class FbTraceEventAnnotationsUtil {

    /* compiled from: file_path */
    class NoOpMap implements FbTraceEventAnnotations {
        public static final NoOpMap f11621a = new NoOpMap();

        private NoOpMap() {
        }

        public void clear() {
        }

        public boolean containsKey(Object obj) {
            return false;
        }

        public boolean containsValue(Object obj) {
            return false;
        }

        public Set<Entry<String, Object>> entrySet() {
            return Sets.a();
        }

        public Object get(Object obj) {
            return null;
        }

        public boolean isEmpty() {
            return true;
        }

        public Set<String> keySet() {
            return Sets.a();
        }

        public Object put(Object obj, Object obj2) {
            return null;
        }

        public void putAll(Map<? extends String, ? extends Object> map) {
        }

        public Object remove(Object obj) {
            return null;
        }

        public int size() {
            return 0;
        }

        public Collection<Object> values() {
            return Sets.a();
        }
    }

    public static FbTraceEventAnnotations m12132a(FbTraceNode fbTraceNode) {
        if (fbTraceNode == FbTraceNode.a) {
            return NoOpMap.f11621a;
        }
        return new HashMapFbTraceEventAnnotations();
    }
}
