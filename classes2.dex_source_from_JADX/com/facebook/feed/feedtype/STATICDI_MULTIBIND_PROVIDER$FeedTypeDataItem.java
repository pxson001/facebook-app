package com.facebook.feed.feedtype;

import com.facebook.events.feed.data.EventFeedStoriesDataItem;
import com.facebook.feed.data.typemanager.PreferredFeedTypeManager;
import com.facebook.groups.feed.data.CrossGroupFeedForSaleDataItem;
import com.facebook.groups.feed.data.GroupsFeedAvailableForSaleDataItem;
import com.facebook.groups.feed.data.GroupsFeedDataItem;
import com.facebook.groups.feed.data.GroupsFeedOwnerAuthoredAvailableForSaleDataItem;
import com.facebook.groups.feed.data.GroupsFeedOwnerAuthoredExpiredForSaleDataItem;
import com.facebook.groups.feed.data.GroupsFeedOwnerAuthoredSoldForSaleDataItem;
import com.facebook.groups.feed.data.GroupsFeedPendingDataItem;
import com.facebook.groups.feed.data.GroupsFeedPinnedDataItem;
import com.facebook.groups.feed.data.GroupsFeedReportedDataItem;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Injector;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.MultiBindIndexedProvider;
import com.facebook.inject.MultiBinderSet;
import com.facebook.inject.ProviderLazy;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: webrtc */
public final class STATICDI_MULTIBIND_PROVIDER$FeedTypeDataItem implements MultiBindIndexedProvider<FeedTypeDataItem>, Provider<Set<FeedTypeDataItem>> {
    private final InjectorLike f5723a;

    public STATICDI_MULTIBIND_PROVIDER$FeedTypeDataItem(InjectorLike injectorLike) {
        this.f5723a = injectorLike;
    }

    public final Object get() {
        return new MultiBinderSet(this.f5723a.getScopeAwareInjector(), this);
    }

    public static Lazy<Set<FeedTypeDataItem>> m9856a(InjectorLike injectorLike) {
        return ProviderLazy.m1699a(new STATICDI_MULTIBIND_PROVIDER$FeedTypeDataItem(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector());
    }

    public final int size() {
        return 20;
    }

    public final Object provide(Injector injector, int i) {
        switch (i) {
            case 0:
                return new EventFeedStoriesDataItem(IdBasedLazy.m1808a(injector, 5600));
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return new FriendListFeedTypeDataItem(IdBasedLazy.m1808a(injector, 5884));
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return new GoodFriendsFeedTypeDataItem(IdBasedLazy.m1808a(injector, 5885));
            case 3:
                return new HashTagFeedTypeDataItem(IdBasedLazy.m1808a(injector, 5886));
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return new NewsFeedTypeDataItem(IdBasedLazy.m1808a(injector, 1469), PreferredFeedTypeManager.m4198a((InjectorLike) injector));
            case 5:
                return new PageFeedTypeDataItem(IdBasedLazy.m1808a(injector, 5888));
            case 6:
                return new PageNewsFeedTypeDataItem(IdBasedLazy.m1808a(injector, 1469));
            case 7:
                return new ReactionFeedTypeDataItem(IdBasedLazy.m1808a(injector, 5890));
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return new StoriesAboutPageFeedTypeDataItem(IdBasedLazy.m1808a(injector, 5891));
            case 9:
                return new TopicFeedTypeDataItem(IdBasedLazy.m1808a(injector, 5892));
            case 10:
                return new TrendingTopicFeedTypeDataItem(IdBasedLazy.m1808a(injector, 5891));
            case 11:
                return new CrossGroupFeedForSaleDataItem(IdBasedLazy.m1808a(injector, 6981));
            case 12:
                return new GroupsFeedAvailableForSaleDataItem(IdBasedLazy.m1808a(injector, 6981));
            case 13:
                return new GroupsFeedDataItem(IdBasedLazy.m1808a(injector, 6981));
            case 14:
                return new GroupsFeedOwnerAuthoredAvailableForSaleDataItem(IdBasedLazy.m1808a(injector, 6981));
            case 15:
                return new GroupsFeedOwnerAuthoredExpiredForSaleDataItem(IdBasedLazy.m1808a(injector, 6981));
            case HTTPTransportCallback.HEADER_BYTES_GENERATED /*16*/:
                return new GroupsFeedOwnerAuthoredSoldForSaleDataItem(IdBasedLazy.m1808a(injector, 6981));
            case 17:
                return new GroupsFeedPendingDataItem(IdBasedLazy.m1808a(injector, 6981));
            case 18:
                return new GroupsFeedPinnedDataItem(IdBasedLazy.m1808a(injector, 6981));
            case 19:
                return new GroupsFeedReportedDataItem(IdBasedLazy.m1808a(injector, 6981));
            default:
                throw new IllegalArgumentException("Invalid binding index");
        }
    }
}
