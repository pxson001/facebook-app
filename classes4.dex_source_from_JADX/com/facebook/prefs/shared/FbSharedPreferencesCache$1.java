package com.facebook.prefs.shared;

/* compiled from: isOutOfSpace */
class FbSharedPreferencesCache$1 implements Runnable {
    final /* synthetic */ FbSharedPreferencesCache f10159a;

    FbSharedPreferencesCache$1(FbSharedPreferencesCache fbSharedPreferencesCache) {
        this.f10159a = fbSharedPreferencesCache;
    }

    public void run() {
        synchronized (this.f10159a) {
            FbSharedPreferencesCache.a(this.f10159a, false);
        }
        FbSharedPreferencesCache.e(this.f10159a);
    }
}
