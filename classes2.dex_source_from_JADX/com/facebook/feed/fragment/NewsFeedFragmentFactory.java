package com.facebook.feed.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.common.fragmentfactory.IReusableFragmentFactory;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.feed.feedtype.FeedTypeDataItem;
import com.facebook.feed.feedtype.STATICDI_MULTIBIND_PROVIDER$FeedTypeDataItem;
import com.facebook.feed.fragment.NewsFeedFragment.Builder;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.google.common.base.Strings;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: process_status */
public class NewsFeedFragmentFactory implements IReusableFragmentFactory {
    public Lazy<Set<FeedTypeDataItem>> f8970a;

    public static NewsFeedFragmentFactory m13847b(InjectorLike injectorLike) {
        return new NewsFeedFragmentFactory(STATICDI_MULTIBIND_PROVIDER$FeedTypeDataItem.m9856a(injectorLike));
    }

    @Inject
    public NewsFeedFragmentFactory(Lazy<Set<FeedTypeDataItem>> lazy) {
        this.f8970a = lazy;
    }

    public final Fragment mo1883a(Intent intent) {
        return m13849b(intent).m13850d();
    }

    public final Builder m13849b(Intent intent) {
        String str;
        FeedType a;
        String stringExtra = intent.getStringExtra("feed_type_name");
        if (Strings.isNullOrEmpty(stringExtra)) {
            str = Name.f5046a.f5072A;
        } else {
            str = stringExtra;
        }
        for (AbstractFeedTypeDataItem abstractFeedTypeDataItem : (Set) this.f8970a.get()) {
            if (str.equals(abstractFeedTypeDataItem.f5763a.f5072A)) {
                a = abstractFeedTypeDataItem.mo1400a(intent);
                break;
            }
        }
        a = FeedType.f5039b;
        FeedType feedType = a;
        boolean booleanExtra = intent.getBooleanExtra("should_update_title_bar", true);
        Builder builder = new Builder();
        builder.f8999a = feedType;
        builder = builder;
        builder.f9001c = booleanExtra;
        builder = builder;
        for (AbstractFeedTypeDataItem abstractFeedTypeDataItem2 : (Set) this.f8970a.get()) {
            if (feedType.f5044g.equals(abstractFeedTypeDataItem2.f5763a)) {
                builder.f9000b = abstractFeedTypeDataItem2.mo1401a(intent, feedType);
                break;
            }
        }
        return builder;
    }
}
