package com.facebook.compactdisk;

import com.facebook.compactdisk.LazySingletonMap.Factory;

/* compiled from: transliterator_word_transliterated */
class StoreManager$3 implements Factory<String, UnmanagedStore> {
    final /* synthetic */ StoreManager f1201a;

    StoreManager$3(StoreManager storeManager) {
        this.f1201a = storeManager;
    }

    public final Object m1262a(Object obj) {
        return StoreManager.a(this.f1201a, (String) obj);
    }
}
