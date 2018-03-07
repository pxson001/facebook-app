package com.facebook.components;

import android.content.res.Configuration;
import android.support.v4.util.LruCache;

/* compiled from: getLanguagePackInfo */
public class ResourceCache {
    private static ResourceCache f22552a;
    private Configuration f22553b;
    private final LruCache<Integer, Object> f22554c = new LruCache<Integer, Object>(this, 500) {
        final /* synthetic */ ResourceCache f22555a;

        protected final int mo3292b(Object obj, Object obj2) {
            if (obj2 instanceof String) {
                return ((String) obj2).length();
            }
            return 1;
        }
    };

    public static synchronized ResourceCache m30449a(Configuration configuration) {
        ResourceCache resourceCache;
        synchronized (ResourceCache.class) {
            if (f22552a == null || !f22552a.f22553b.equals(configuration)) {
                f22552a = new ResourceCache(configuration);
            }
            resourceCache = f22552a;
        }
        return resourceCache;
    }

    private ResourceCache(Configuration configuration) {
        this.f22553b = configuration;
    }

    public final void m30451a(int i, Object obj) {
        this.f22554c.m4433a(Integer.valueOf(i), obj);
    }

    public final <T> T m30450a(int i) {
        return this.f22554c.m4432a(Integer.valueOf(i));
    }
}
