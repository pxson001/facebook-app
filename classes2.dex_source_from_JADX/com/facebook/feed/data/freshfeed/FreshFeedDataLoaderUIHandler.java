package com.facebook.feed.data.freshfeed;

import android.os.Looper;
import android.os.Message;
import com.facebook.api.feed.FetchFeedParams;
import com.facebook.api.feed.FetchFeedParamsBuilder;
import com.facebook.api.feed.FetchFeedResult;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.api.feed.data.FetchPortion;
import com.facebook.api.feed.data.ViewPortShift;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.feed.abtest.ExperimentsForNewsFeedAbTestModule;
import com.facebook.feed.data.freshfeed.FreshFeedDataLoader.C02711;
import com.facebook.feed.data.freshfeed.FreshFeedDataLoader.FreshFeedCollectionListener;
import com.facebook.feed.freshfeed.FreshFeedHandler;
import com.facebook.feed.loader.FeedDataLoaderListener;
import com.facebook.feed.loader.HeadLoaderStatus;
import com.facebook.feed.loader.LoadIntentHint;
import com.facebook.feed.loader.TailLoaderStatus;
import com.facebook.feed.model.ClientFeedUnitEdge;
import com.facebook.feed.model.FetchResultState;
import com.facebook.feed.sponsored.SponsoredFeedUnitValidator;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: selected_tags */
public class FreshFeedDataLoaderUIHandler extends FreshFeedHandler {
    private static final int[] f5769i = new int[]{5};
    private final FeedUnitCollection f5770a;
    public final HeadLoaderStatus f5771b;
    public final TailLoaderStatus f5772c;
    private final TailLoaderStatus f5773d;
    private final Lazy<SponsoredFeedUnitValidator> f5774e;
    private final QeAccessor f5775f;
    public final FreshFeedCollectionListener f5776g;
    public FeedDataLoaderListener f5777h;
    public boolean f5778j = false;
    private FetchFeedParams f5779k;
    private GraphQLPageInfo f5780l;
    public C02711 f5781m;

    @Inject
    public FreshFeedDataLoaderUIHandler(@Assisted Looper looper, @Assisted FeedUnitCollection feedUnitCollection, @Assisted HeadLoaderStatus headLoaderStatus, @Assisted TailLoaderStatus tailLoaderStatus, @Assisted FeedDataLoaderListener feedDataLoaderListener, @Assisted TailLoaderStatus tailLoaderStatus2, @Assisted CollectionChangeListener collectionChangeListener, Lazy<SponsoredFeedUnitValidator> lazy, QeAccessor qeAccessor) {
        super(looper, f5769i);
        this.f5770a = feedUnitCollection;
        this.f5771b = headLoaderStatus;
        this.f5772c = tailLoaderStatus;
        this.f5777h = feedDataLoaderListener;
        this.f5773d = tailLoaderStatus2;
        this.f5779k = new FetchFeedParams(new FetchFeedParamsBuilder());
        this.f5780l = new GraphQLPageInfo();
        this.f5774e = lazy;
        this.f5775f = qeAccessor;
        this.f5776g = collectionChangeListener;
    }

    public void handleMessage(Message message) {
        int i;
        switch (message.what) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                m9898b(message.arg1, message.arg2);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                i = message.arg1;
                this.f5772c.m9867a();
                if (this.f5781m != null) {
                    this.f5781m.m9971b(i);
                }
                this.f5777h.mo1369a(0, LoadIntentHint.HideLoadingIndicator);
                return;
            case 3:
                this.f5771b.m9863f();
                return;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                m9897a(message.arg1, (ImmutableList) message.obj);
                return;
            case 5:
                this.f5778j = true;
                return;
            case 6:
                i = message.arg1;
                if (this.f5776g != null) {
                    FreshFeedDataLoader.m8979b(this.f5776g.f5768a, i);
                }
                return;
            case 7:
                m9899e(message.arg1);
                return;
            default:
                throw new IllegalArgumentException("Unknown what=" + message.what);
        }
    }

    private void m9898b(int i, int i2) {
        TracerDetour.a("FreshFeedDataLoaderUIHandler.doNetworkCompleteRequest", 1578210530);
        try {
            this.f5772c.m9867a();
            if (this.f5781m != null) {
                this.f5781m.m9969a(i2);
            }
            this.f5777h.mo1369a(i, LoadIntentHint.HideLoadingIndicator);
        } finally {
            TracerDetour.a(-1766550230);
        }
    }

    private void m9897a(int i, ImmutableList<ClientFeedUnitEdge> immutableList) {
        TracerDetour.a("FreshFeedDataLoaderUIHandler.doSendStoriesToUI", -881088229);
        try {
            int t = this.f5770a.m9701t();
            this.f5777h.mo1368a();
            if (this.f5778j || m9900f(i)) {
                this.f5778j = false;
                this.f5770a.m9696m();
                this.f5777h.mo1369a(immutableList.size(), LoadIntentHint.HideLoadingIndicator);
            }
            this.f5770a.m9681b((List) immutableList);
            if (this.f5781m != null) {
                this.f5781m.m9970a((ImmutableList) immutableList);
            }
            ((SponsoredFeedUnitValidator) this.f5774e.get()).m26732a(this.f5770a, (List) immutableList, true, FetchPortion.CHUNKED_REMAINDER);
            FeedDataLoaderListener feedDataLoaderListener = this.f5777h;
            FetchFeedResult fetchFeedResult = new FetchFeedResult(this.f5779k, immutableList, this.f5780l, null, DataFreshnessResult.FROM_SERVER, 0, false);
            feedDataLoaderListener.mo1371a(false, fetchFeedResult, FetchResultState.SUCCESS, null, 0, FetchPortion.FULL, ViewPortShift.Perform);
            this.f5773d.m9867a();
            if (t > 0) {
                int size = immutableList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (!((ClientFeedUnitEdge) immutableList.get(i2)).m21228F()) {
                        this.f5777h.mo1369a(immutableList.size(), LoadIntentHint.ShowMoreStoryPill);
                        break;
                    }
                }
            }
            TracerDetour.a(1917608237);
        } catch (Throwable th) {
            TracerDetour.a(-1934479060);
        }
    }

    private void m9899e(int i) {
        TracerDetour.a("FreshFeedDataLoaderUIHandler.doStageStoriesCompleted", 281265283);
        try {
            this.f5777h.mo1369a(i, LoadIntentHint.ShowNewStoryPill);
        } finally {
            TracerDetour.a(-1050795280);
        }
    }

    private boolean m9900f(int i) {
        return i == 0 && this.f5777h.mo1372b() && this.f5775f.mo596a(ExperimentsForNewsFeedAbTestModule.f5084K, false);
    }

    public final void m9906a(Throwable th, int i) {
        sendMessage(obtainMessage(2, i, 0, th));
    }

    public final void m9903a(int i, int i2) {
        sendMessage(obtainMessage(1, i, i2));
    }

    public final void m9905a(ImmutableList<ClientFeedUnitEdge> immutableList, int i) {
        sendMessage(obtainMessage(4, i, 0, immutableList));
    }

    public final void m9904a(FeedDataLoaderListener feedDataLoaderListener) {
        this.f5777h = feedDataLoaderListener;
    }

    public final void m9908c() {
        sendMessage(obtainMessage(5));
    }

    public final void m9902a(int i) {
        sendMessage(obtainMessage(6, i, 0));
    }

    public final void m9907b(int i) {
        sendMessage(obtainMessage(7, i, 0));
    }

    public final void mo1402a() {
        super.mo1402a();
        this.f5778j = false;
    }
}
