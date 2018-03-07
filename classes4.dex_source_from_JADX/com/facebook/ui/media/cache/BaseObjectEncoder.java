package com.facebook.ui.media.cache;

import com.facebook.binaryresource.BinaryResource;
import com.google.common.io.Closeables;
import java.io.BufferedInputStream;
import java.io.InputStream;

/* compiled from: entry_action */
public abstract class BaseObjectEncoder<KeyT extends MediaCacheKey, ValueT> implements ObjectEncoder<KeyT, ValueT> {
    public abstract ValueT mo933a(KeyT keyT, InputStream inputStream);

    public ValueT mo932a(KeyT keyT, BinaryResource binaryResource) {
        InputStream a = binaryResource.a();
        try {
            ValueT a2 = mo933a((MediaCacheKey) keyT, new BufferedInputStream(a));
            return a2;
        } finally {
            Closeables.a(a);
        }
    }
}
