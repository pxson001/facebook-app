package com.facebook.common.android;

import android.app.SearchManager;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: streaming_image */
public class SearchManagerMethodAutoProvider extends AbstractProvider<SearchManager> {
    private static SearchManager m3616b(InjectorLike injectorLike) {
        return AndroidModule.j((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.j((Context) getInstance(Context.class));
    }
}
