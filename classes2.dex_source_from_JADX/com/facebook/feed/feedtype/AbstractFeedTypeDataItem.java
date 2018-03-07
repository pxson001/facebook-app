package com.facebook.feed.feedtype;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.protocol.FetchFeedMethod;
import com.facebook.inject.Lazy;

/* compiled from: self_update */
public abstract class AbstractFeedTypeDataItem {
    public final Name f5763a;
    private final Lazy<? extends FetchFeedMethod> f5764b;
    public final boolean f5765c;
    public final boolean f5766d;

    public abstract FeedType mo1400a(Intent intent);

    public abstract String mo1401a(Intent intent, FeedType feedType);

    public AbstractFeedTypeDataItem(Name name, Lazy<? extends FetchFeedMethod> lazy) {
        this(name, lazy, true, true);
    }

    public AbstractFeedTypeDataItem(Name name, Lazy<? extends FetchFeedMethod> lazy, boolean z, boolean z2) {
        this.f5763a = name;
        this.f5764b = lazy;
        this.f5765c = z;
        this.f5766d = z2;
    }

    public final FetchFeedMethod m9888b() {
        return (FetchFeedMethod) this.f5764b.get();
    }
}
