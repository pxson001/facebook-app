package com.facebook.richdocument.model.data.impl;

import android.content.Context;
import com.facebook.richdocument.model.data.Preloadable;

/* compiled from: photo_tap */
public abstract class BasePreloadingBlockData extends BaseBlockData implements Preloadable {
    private boolean f5695a;
    private final String f5696b;

    protected abstract void mo299b(Context context);

    public BasePreloadingBlockData(String str, int i) {
        super(i);
        this.f5696b = str;
    }

    public final void mo283a(boolean z) {
        this.f5695a = !z;
    }

    public final boolean iU_() {
        return !this.f5695a;
    }

    public int mo284d() {
        return 5;
    }

    public final void mo282a(Context context) {
        mo299b(context);
        mo283a(false);
    }
}
