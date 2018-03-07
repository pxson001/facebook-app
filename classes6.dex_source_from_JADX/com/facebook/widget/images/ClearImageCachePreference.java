package com.facebook.widget.images;

import android.content.Context;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.module.CountingMemoryCache_BitmapMemoryCacheMethodAutoProvider;
import com.facebook.imagepipeline.module.CountingMemoryCache_SimpleImageMemoryCacheMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.images.cache.ImageCache;
import com.facebook.widget.prefs.OrcaListPreference;
import javax.inject.Inject;

/* compiled from: request_surface */
public class ClearImageCachePreference extends OrcaListPreference {
    private final ImageCache f5749a;
    private final CountingMemoryCache<?, ?> f5750b;
    private final CountingMemoryCache<?, ?> f5751c;

    public static ClearImageCachePreference m8354a(InjectorLike injectorLike) {
        return new ClearImageCachePreference((Context) injectorLike.getInstance(Context.class), ImageCache.a(injectorLike), CountingMemoryCache_SimpleImageMemoryCacheMethodAutoProvider.a(injectorLike), CountingMemoryCache_BitmapMemoryCacheMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ClearImageCachePreference(Context context, ImageCache imageCache, CountingMemoryCache countingMemoryCache, CountingMemoryCache countingMemoryCache2) {
        super(context);
        this.f5749a = imageCache;
        this.f5750b = countingMemoryCache;
        this.f5751c = countingMemoryCache2;
        setPersistent(false);
        setKey("clearimagecache");
        setTitle("Clear image cache");
        setSummary("Clears the image cache in memory and on disk");
        CharSequence[] charSequenceArr = new String[]{"Clear image cache"};
        setEntries(charSequenceArr);
        setEntryValues(charSequenceArr);
    }

    protected String getPersistedString(String str) {
        return "";
    }

    protected boolean persistString(String str) {
        this.f5749a.a();
        this.f5750b.a();
        this.f5751c.a();
        return true;
    }
}
