package com.facebook.feed.data.freshfeed;

import android.os.Looper;
import android.os.Message;
import com.facebook.api.feedcache.db.DbFeedHomeStoriesHandler;
import com.facebook.api.feedtype.FeedType;
import com.facebook.feed.freshfeed.FreshFeedHandler;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.FreshFeedEvent;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.inject.Assisted;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: messenger_profile_image_webp_android */
public class FreshFeedDBHandler extends FreshFeedHandler {
    private static final String f13826a = FreshFeedDBHandler.class.getSimpleName();
    private final FreshFeedDataLoaderUIHandler f13827b;
    private final DbFeedHomeStoriesHandler f13828c;
    private final FreshFeedBackgroundUIWorkHandler f13829d;
    private final NewsFeedEventLogger f13830e;

    @Inject
    public FreshFeedDBHandler(@Assisted Looper looper, @Assisted FreshFeedDataLoaderUIHandler freshFeedDataLoaderUIHandler, @Assisted FreshFeedBackgroundUIWorkHandler freshFeedBackgroundUIWorkHandler, DbFeedHomeStoriesHandler dbFeedHomeStoriesHandler, NewsFeedEventLogger newsFeedEventLogger) {
        super(looper);
        this.f13827b = freshFeedDataLoaderUIHandler;
        this.f13828c = dbFeedHomeStoriesHandler;
        this.f13829d = freshFeedBackgroundUIWorkHandler;
        this.f13830e = newsFeedEventLogger;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                m20230d();
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                m20231e();
                return;
            default:
                throw new IllegalArgumentException("Unknown what=" + message.what);
        }
    }

    private void m20230d() {
        this.f13829d.m9986b(m20232f(), 3);
        FreshFeedDataLoaderUIHandler freshFeedDataLoaderUIHandler = this.f13827b;
        freshFeedDataLoaderUIHandler.sendMessage(freshFeedDataLoaderUIHandler.obtainMessage(3));
    }

    private void m20231e() {
        this.f13829d.m9986b(m20232f(), 4);
    }

    private ImmutableList<ClientFeedUnitEdge> m20232f() {
        ImmutableList<ClientFeedUnitEdge> a = this.f13828c.m9161a(FeedType.f5039b, 259200000);
        this.f13830e.m4413a(f13826a, FreshFeedEvent.STORIES_READ_FROM_DB, a == null ? "0" : String.valueOf(a.size()));
        return a;
    }

    public final void m20233b() {
        sendMessage(obtainMessage(1));
    }

    public final void m20234c() {
        sendMessage(obtainMessage(2));
    }
}
