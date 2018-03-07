package com.facebook.feed.rows.core;

import com.facebook.feed.util.unit.FeedUnitCacheIdUtil;
import com.facebook.feed.util.unit.FeedUnitHelper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.multirow.api.AnyEnvironment;
import java.util.HashMap;
import javax.annotation.Nullable;

/* compiled from: method/mobile.zeroInterstitialContent */
public class CachingFeedUnitAdapterFactory<P, E extends AnyEnvironment> implements FeedUnitAdapterFactory<P, E> {
    public final FeedUnitAdapterFactory<P, E> f13579a;
    public final HashMap<String, FeedUnitAdapter<P, E>> f13580b = new HashMap(10);
    public final E f13581c;

    public CachingFeedUnitAdapterFactory(FeedUnitAdapterFactory<P, E> feedUnitAdapterFactory, E e) {
        this.f13579a = feedUnitAdapterFactory;
        this.f13581c = e;
    }

    public final FeedUnitAdapter<P, E> mo2518a(@Nullable P p, E e) {
        FeedUnitAdapter<P, E> feedUnitAdapter;
        String a = m19965a((Object) p, null);
        if (a == null || this.f13581c != e) {
            feedUnitAdapter = null;
        } else {
            feedUnitAdapter = (FeedUnitAdapter) this.f13580b.remove(a);
            if (p != null) {
                FeedUnit a2 = FeedUnitHelper.m21141a(p);
                if (!(feedUnitAdapter == null || a2 == null || a2 == feedUnitAdapter.f12957b)) {
                    feedUnitAdapter = null;
                }
            }
        }
        if (feedUnitAdapter == null) {
            return this.f13579a.mo2518a(p, e);
        }
        return feedUnitAdapter;
    }

    public static String m19965a(@Nullable Object obj, String str) {
        try {
            str = FeedUnitCacheIdUtil.m20097a(obj);
        } catch (UnsupportedOperationException e) {
        }
        return str;
    }
}
