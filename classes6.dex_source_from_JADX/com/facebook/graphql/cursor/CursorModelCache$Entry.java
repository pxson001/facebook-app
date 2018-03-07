package com.facebook.graphql.cursor;

import com.facebook.flatbuffers.Flattenable;
import java.lang.ref.WeakReference;

/* compiled from: mPromptImageUri */
class CursorModelCache$Entry {
    public final WeakReference<Flattenable> f10960a;
    public final long f10961b;

    public CursorModelCache$Entry(Flattenable flattenable, long j) {
        this.f10960a = new WeakReference(flattenable);
        this.f10961b = j;
    }
}
