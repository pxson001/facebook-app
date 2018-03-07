package com.facebook.omnistore.module;

import com.facebook.omnistore.Collection;
import com.facebook.omnistore.Delta;
import com.facebook.omnistore.IndexedFields;
import com.facebook.omnistore.Omnistore;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: mOmnistoreMutex */
public interface OmnistoreComponent {
    IndexedFields indexObject(String str, String str2, ByteBuffer byteBuffer);

    void onCollectionAvailable(Collection collection);

    void onCollectionInvalidated();

    void onDeltasReceived(List<Delta> list);

    SubscriptionInfo provideSubscriptionInfo(Omnistore omnistore);
}
