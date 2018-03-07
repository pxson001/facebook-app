package com.facebook.feed.topicfeeds;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.fragmentfactory.IReusableFragmentFactory;
import com.facebook.feed.diode.abtest.ExperimentsForFeedDiodeTestModule;
import com.facebook.feed.fragment.NewsFeedFragmentFactory;
import com.facebook.feed.topicfeeds.abtest.TopicFeedsTestUtil;
import com.facebook.goodfriends.abtest.GoodFriendsFeedQEStore;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: product_id */
public class NewsFeedSwitcherFragmentFactory implements IReusableFragmentFactory {
    private final GoodFriendsFeedQEStore f8965a;
    private final NewsFeedFragmentFactory f8966b;
    private final QeAccessor f8967c;
    private final TopicFeedsTestUtil f8968d;

    public static NewsFeedSwitcherFragmentFactory m13836b(InjectorLike injectorLike) {
        return new NewsFeedSwitcherFragmentFactory(GoodFriendsFeedQEStore.m13842b(injectorLike), NewsFeedFragmentFactory.m13847b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), TopicFeedsTestUtil.m8789b(injectorLike));
    }

    @Inject
    public NewsFeedSwitcherFragmentFactory(GoodFriendsFeedQEStore goodFriendsFeedQEStore, NewsFeedFragmentFactory newsFeedFragmentFactory, QeAccessor qeAccessor, TopicFeedsTestUtil topicFeedsTestUtil) {
        this.f8965a = goodFriendsFeedQEStore;
        this.f8966b = newsFeedFragmentFactory;
        this.f8967c = qeAccessor;
        this.f8968d = topicFeedsTestUtil;
    }

    public final Fragment mo1883a(Intent intent) {
        boolean a = this.f8968d.m8791a();
        boolean a2 = this.f8965a.m13843a();
        boolean a3 = this.f8967c.mo596a(ExperimentsForFeedDiodeTestModule.f8989a, false);
        if (BuildConstants.j || (!a && !a2 && !a3)) {
            return this.f8966b.mo1883a(intent);
        }
        Parcelable b = this.f8966b.m13849b(intent);
        Fragment newsFeedSwitcherFragment = new NewsFeedSwitcherFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("newsfeed_fragment_builder", b);
        bundle.putBoolean("topic_feed_enabled", a);
        bundle.putBoolean("good_friends_feed_enabled", a2);
        bundle.putBoolean("feed_diode_enabled", a3);
        newsFeedSwitcherFragment.m271g(bundle);
        return newsFeedSwitcherFragment;
    }
}
