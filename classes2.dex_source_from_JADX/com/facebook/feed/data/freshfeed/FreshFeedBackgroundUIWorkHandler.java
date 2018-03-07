package com.facebook.feed.data.freshfeed;

import android.os.Looper;
import android.os.Message;
import com.facebook.api.feed.FeedFetchContext;
import com.facebook.api.feed.FetchFeedParams.FetchFeedCause;
import com.facebook.api.feed.xconfig.FreshFeedConfig;
import com.facebook.api.feed.xconfig.FreshFeedConfigReader;
import com.facebook.api.feedtype.FeedType;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.Clock;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.feed.data.freshfeed.FreshFeedFetcher.FetchParams;
import com.facebook.feed.feedtype.AbstractFeedTypeDataItem;
import com.facebook.feed.freshfeed.FreshFeedHandler;
import com.facebook.feed.loader.TailLoaderStatus;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.FreshFeedEvent;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.feed.server.FeedUnitPreRenderProcessor;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.inject.Assisted;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: seconds_from_midnight */
public class FreshFeedBackgroundUIWorkHandler extends FreshFeedHandler {
    private static final int[] f5827b = new int[]{2, 3};
    @VisibleForTesting
    protected final int f5828a = 5;
    private final FreshFeedStoryCollection f5829c;
    private final FeedUnitPreRenderProcessor f5830d;
    private final FreshFeedDataLoaderUIHandler f5831e;
    private final NewsFeedEventLogger f5832f;
    private final TailLoaderStatus f5833g;
    private final Clock f5834h;
    private final FeedType f5835i;
    private final AbstractFeedTypeDataItem f5836j;
    private final FreshFeedMultiRowStoryPreparer f5837k;
    private final FreshFeedConfigReader f5838l;
    public FreshFeedFetcher f5839m;

    @Inject
    public FreshFeedBackgroundUIWorkHandler(FeedUnitPreRenderProcessor feedUnitPreRenderProcessor, NewsFeedEventLogger newsFeedEventLogger, Clock clock, FreshFeedMultiRowStoryPreparerProvider freshFeedMultiRowStoryPreparerProvider, FreshFeedStoryCollection freshFeedStoryCollection, @Assisted Looper looper, @Assisted FreshFeedDataLoaderUIHandler freshFeedDataLoaderUIHandler, @Assisted TailLoaderStatus tailLoaderStatus, @Assisted FeedType feedType, @Assisted AbstractFeedTypeDataItem abstractFeedTypeDataItem, FreshFeedConfigReader freshFeedConfigReader) {
        super(looper, f5827b);
        this.f5829c = freshFeedStoryCollection;
        this.f5830d = feedUnitPreRenderProcessor;
        this.f5831e = freshFeedDataLoaderUIHandler;
        this.f5832f = newsFeedEventLogger;
        this.f5833g = tailLoaderStatus;
        this.f5834h = clock;
        this.f5835i = feedType;
        this.f5836j = abstractFeedTypeDataItem;
        this.f5837k = freshFeedMultiRowStoryPreparerProvider.m9991a(this.f5829c);
        this.f5838l = freshFeedConfigReader;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                m9973b(message.arg1, message.arg2);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                m9977e();
                return;
            case 3:
                m9975c((ImmutableList) message.obj, message.arg1);
                return;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                m9976d((ImmutableList) message.obj, message.arg1);
                return;
            case 5:
                m9981i();
                return;
            case 6:
                m9972a((UpdateImageCacheStateMessage) message.obj);
                return;
            case 7:
                m9974b((ImmutableList) message.obj);
                return;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                m9980h();
                return;
            default:
                throw new IllegalArgumentException("Unknown what=" + message.what);
        }
    }

    private void m9973b(int i, int i2) {
        int i3 = 0;
        TracerDetour.a("FeedDataBackgroundUIWorkHandler.doInitializeStoriesForUI", -902500663);
        Builder builder = new Builder();
        int i4 = 0;
        int i5 = 0;
        while (i4 < i + 100) {
            try {
                GraphQLFeedUnitEdge c = this.f5829c.m10009c();
                if (c != null) {
                    i5++;
                    builder.m1069c(c);
                    this.f5830d.m9990a(c.mo2540c(), FeedFetchContext.f5815a);
                    if (i5 >= i) {
                        break;
                    }
                } else if (this.f5829c.m10011e()) {
                    this.f5832f.m4412a("FreshFeedBackgroundUIWorkHandler", FreshFeedEvent.EMPTY_COLLECTION);
                    break;
                } else {
                    i3++;
                    BLog.a("FreshFeedBackgroundUIWorkHandler", "Fresh Feed Story Collection return a null edge");
                }
                i4++;
            } catch (Throwable th) {
                this.f5831e.m9905a(builder.m1068b(), i2);
                TracerDetour.a(1402539068);
            }
        }
        this.f5832f.m4413a("FreshFeedBackgroundUIWorkHandler", FreshFeedEvent.STORIES_FOR_UI, String.format("retrieved: %d null: %d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i3)}));
        this.f5837k.m10031a();
        this.f5831e.m9905a(builder.m1068b(), i2);
        TracerDetour.a(-331948199);
    }

    private void m9977e() {
        TracerDetour.a("FeedDataBackgroundUIWorkHandler.fetchFreshStoriesIfNeeded", 1573393341);
        try {
            int a = this.f5829c.m10003a();
            if (a < m9978f()) {
                this.f5832f.m4413a("FreshFeedBackgroundUIWorkHandler", FreshFeedEvent.FETCH_FRESH_STORIES, String.valueOf(a));
                m9979g();
            }
            TracerDetour.a(1338353115);
        } catch (Throwable th) {
            TracerDetour.a(447824513);
        }
    }

    private int m9978f() {
        return this.f5838l.m9087a(FreshFeedConfig.f5212n, 9, 5);
    }

    private void m9979g() {
        TracerDetour.a("FeedDataBackgroundUIWorkHandler.loadMoreDataFromNetwork", 1815669224);
        try {
            if (!this.f5833g.m9869c()) {
                FetchParams fetchParams = new FetchParams(DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA, this.f5835i, this.f5836j.m9888b(), "fresh_feed_more_data_fetch", this.f5834h.mo211a(), this.f5829c.m10010d(), FetchFeedCause.SCROLLING);
                this.f5833g.m9868b();
                this.f5832f.m4412a("FreshFeedBackgroundUIWorkHandler", FreshFeedEvent.LOAD_MORE_DATA_FROM_NETWORK);
                this.f5839m.m10070b(fetchParams);
                TracerDetour.a(1612177458);
            }
        } finally {
            TracerDetour.a(-1844032325);
        }
    }

    private void m9975c(ImmutableList<ClientFeedUnitEdge> immutableList, int i) {
        TracerDetour.a("FreshFeedDataLoaderUIHandler.doProcessNewStories", 736330160);
        try {
            if (this.f5829c.m10008b(immutableList, i)) {
                this.f5831e.m9902a(i);
            }
            TracerDetour.a(1047711859);
        } catch (Throwable th) {
            TracerDetour.a(1264917391);
        }
    }

    private void m9976d(ImmutableList<ClientFeedUnitEdge> immutableList, int i) {
        TracerDetour.a("FreshFeedDataLoaderUIHandler.doProcessDBStories", -1520291623);
        try {
            if (this.f5829c.m10006a((ImmutableList) immutableList, i)) {
                this.f5831e.m9902a(i);
            }
            TracerDetour.a(930398878);
        } catch (Throwable th) {
            TracerDetour.a(-220224323);
        }
    }

    private void m9974b(ImmutableList<ClientFeedUnitEdge> immutableList) {
        TracerDetour.a("FreshFeedDataLoaderUIHandler.doProcessStageStories", -713285030);
        try {
            this.f5829c.m10004a(immutableList);
        } finally {
            TracerDetour.a(972283720);
        }
    }

    private void m9980h() {
        TracerDetour.a("FreshFeedDataLoaderUIHandler.doProcessUnStageStories", 1469352096);
        try {
            this.f5829c.m10007b();
            this.f5831e.m9902a(0);
        } finally {
            TracerDetour.a(-1500821880);
        }
    }

    private void m9981i() {
        TracerDetour.a("FreshFeedDataLoaderUIHandler.doResetFreshFeedCollectionStoryPosition", 1291282993);
        try {
            this.f5829c.m10012f();
        } finally {
            TracerDetour.a(-1268033355);
        }
    }

    private void m9972a(UpdateImageCacheStateMessage updateImageCacheStateMessage) {
        TracerDetour.a("FreshFeedDataLoaderUIHandler.doUpdateImageCacheState", -1442443865);
        try {
            this.f5829c.m10005a(updateImageCacheStateMessage.a, updateImageCacheStateMessage.b, updateImageCacheStateMessage.c);
        } finally {
            TracerDetour.a(-2135194067);
        }
    }

    public final void m9982a(int i, int i2) {
        sendMessage(obtainMessage(1, i, i2));
    }

    public final void m9985b() {
        sendMessage(obtainMessage(2));
    }

    public final void m9984a(ImmutableList<ClientFeedUnitEdge> immutableList, int i) {
        sendMessage(obtainMessage(3, i, 0, immutableList));
    }

    public final void m9986b(ImmutableList<ClientFeedUnitEdge> immutableList, int i) {
        sendMessage(obtainMessage(4, i, 0, immutableList));
    }

    public final void m9987c() {
        sendMessage(obtainMessage(5));
    }

    public final void m9983a(ImmutableList<ClientFeedUnitEdge> immutableList) {
        sendMessage(obtainMessage(7, immutableList));
    }

    public final void m9988d() {
        sendMessage(obtainMessage(8));
    }
}
