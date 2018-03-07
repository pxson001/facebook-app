package com.facebook.saved2.ui;

import android.support.annotation.UiThread;
import android.support.v4.util.SimpleArrayMap;
import com.facebook.inject.InjectorLike;
import com.facebook.saved2.network.Saved2DataFetcher;
import javax.inject.Inject;

@UiThread
/* compiled from: instant_shopping_audio_button_click */
public class Saved2NetworkController {
    public final Saved2DataFetcher f9502a;
    private final SimpleArrayMap<String, Boolean> f9503b = new SimpleArrayMap(12);
    public boolean f9504c;

    public static Saved2NetworkController m9778b(InjectorLike injectorLike) {
        return new Saved2NetworkController(Saved2DataFetcher.m9708a(injectorLike));
    }

    @Inject
    public Saved2NetworkController(Saved2DataFetcher saved2DataFetcher) {
        this.f9502a = saved2DataFetcher;
    }

    public final boolean m9780a(String str) {
        if (this.f9503b.put(str, Boolean.TRUE) == Boolean.TRUE) {
            return false;
        }
        m9779c(str);
        return true;
    }

    public final void m9781b(String str) {
        m9779c(str);
    }

    private void m9779c(String str) {
        this.f9502a.m9710a(str, null);
    }
}
