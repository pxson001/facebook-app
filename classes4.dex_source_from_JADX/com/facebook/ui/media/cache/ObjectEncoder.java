package com.facebook.ui.media.cache;

import com.facebook.binaryresource.BinaryResource;
import java.io.OutputStream;

/* compiled from: entity_only */
public interface ObjectEncoder<KeyT extends MediaCacheKey, ValueT> {
    ValueT mo932a(KeyT keyT, BinaryResource binaryResource);

    ValueT mo934a(KeyT keyT, byte[] bArr);

    void mo935a(KeyT keyT, ValueT valueT, OutputStream outputStream);
}
