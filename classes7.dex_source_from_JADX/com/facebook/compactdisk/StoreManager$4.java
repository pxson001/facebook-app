package com.facebook.compactdisk;

import com.facebook.compactdisk.LazySingletonMap.Factory;

/* compiled from: transliterator_word_transliterated */
class StoreManager$4 implements Factory<String, PersistentKeyValueStore> {
    final /* synthetic */ StoreManager f1202a;

    StoreManager$4(StoreManager storeManager) {
        this.f1202a = storeManager;
    }

    public final Object m1263a(Object obj) {
        return StoreManager.b(this.f1202a, (String) obj);
    }
}
