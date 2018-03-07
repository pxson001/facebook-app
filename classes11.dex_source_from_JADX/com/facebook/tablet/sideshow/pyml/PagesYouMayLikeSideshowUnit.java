package com.facebook.tablet.sideshow.pyml;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.tablet.sideshow.analytics.SideshowAnalyticsLogger;
import com.facebook.tablet.sideshow.loader.SideshowLoader.1;
import com.facebook.tablet.sideshow.pyml.events.SideshowPageLikeEvents.PageLikeClickedEvent;
import com.facebook.tablet.sideshow.pyml.events.SideshowPageLikeEvents.PageLikeClickedEventSubscriber;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshow.FetchPagesYouMayLikeSideshowString;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowDataRequest;
import com.facebook.tablet.sideshow.pyml.graphql.FetchPagesYouMayLikeSideshowDataRequest.C06531;
import com.facebook.tablet.sideshow.pyml.model.PagesYouMayLikeDataHolder;
import com.facebook.tablet.sideshow.pyml.model.PagesYouMayLikeDataHolder.C06541;
import com.facebook.tablet.sideshow.pyml.model.PagesYouMayLikeRow;
import com.facebook.tablet.sideshow.pyml.ui.PagesYouMayLikeListAdapter;
import com.facebook.tablet.sideshow.pyml.ui.PagesYouMayLikeListAdapter.C06551;
import com.facebook.tablet.sideshow.widget.ActionContentViewSideshowUnit;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView;
import com.facebook.tablet.sideshow.widget.SideshowExpandableListView.OnItemClickedListener;
import com.facebook.tablet.sideshow.widget.SideshowUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.util.concurrent.Futures;

/* compiled from: onContentSizeChange */
public class PagesYouMayLikeSideshowUnit extends ActionContentViewSideshowUnit {
    public PagesYouMayLikeListAdapter f4794b;
    private PagesYouMayLikeDataHolder f4795c;
    public SideshowAnalyticsLogger f4796d;
    public SecureContextHelper f4797e;
    public UriIntentMapper f4798f;
    private FeedEventBus f4799g;
    public FbEventSubscriberListManager f4800h;
    public RawLikeHelper f4801i;

    /* compiled from: onContentSizeChange */
    public class C06501 extends PageLikeClickedEventSubscriber {
        final /* synthetic */ PagesYouMayLikeSideshowUnit f4789a;

        public C06501(PagesYouMayLikeSideshowUnit pagesYouMayLikeSideshowUnit) {
            this.f4789a = pagesYouMayLikeSideshowUnit;
        }

        public final void m5980b(FbEvent fbEvent) {
            boolean z;
            PageLikeClickedEvent pageLikeClickedEvent = (PageLikeClickedEvent) fbEvent;
            PagesYouMayLikeSideshowUnit pagesYouMayLikeSideshowUnit = this.f4789a;
            RawLikeHelper rawLikeHelper = pagesYouMayLikeSideshowUnit.f4801i;
            String str = pageLikeClickedEvent.f4814a;
            if (pageLikeClickedEvent.f4815b) {
                z = false;
            } else {
                z = true;
            }
            rawLikeHelper.a(str, z, "sideshow_page_like", pageLikeClickedEvent.f4816c, null, null, null, false, new C06512(pagesYouMayLikeSideshowUnit, pageLikeClickedEvent));
        }
    }

    /* compiled from: onContentSizeChange */
    public class C06512 implements MutationCallback<String> {
        final /* synthetic */ PageLikeClickedEvent f4790a;
        final /* synthetic */ PagesYouMayLikeSideshowUnit f4791b;

        public C06512(PagesYouMayLikeSideshowUnit pagesYouMayLikeSideshowUnit, PageLikeClickedEvent pageLikeClickedEvent) {
            this.f4791b = pagesYouMayLikeSideshowUnit;
            this.f4790a = pageLikeClickedEvent;
        }

        public final /* bridge */ /* synthetic */ void m5983b(Object obj) {
        }

        public final /* bridge */ /* synthetic */ void m5984c(Object obj) {
        }

        public final void m5981a(Object obj) {
            this.f4791b.f4794b.m6059a(this.f4790a.f4814a, !this.f4790a.f4815b);
        }

        public final void m5982a(Object obj, ServiceException serviceException) {
            this.f4791b.f4794b.m6059a(this.f4790a.f4814a, this.f4790a.f4815b);
        }
    }

    public PagesYouMayLikeSideshowUnit(PagesYouMayLikeListAdapter pagesYouMayLikeListAdapter, FetchPagesYouMayLikeSideshowDataRequest fetchPagesYouMayLikeSideshowDataRequest, SideshowAnalyticsLogger sideshowAnalyticsLogger, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, FeedEventBus feedEventBus, RawLikeHelper rawLikeHelper, SideshowUtils sideshowUtils) {
        super(sideshowUtils);
        this.f4794b = pagesYouMayLikeListAdapter;
        this.f4796d = sideshowAnalyticsLogger;
        this.f4795c = new PagesYouMayLikeDataHolder(fetchPagesYouMayLikeSideshowDataRequest);
        PagesYouMayLikeListAdapter pagesYouMayLikeListAdapter2 = this.f4794b;
        PagesYouMayLikeDataHolder pagesYouMayLikeDataHolder = this.f4795c;
        if (pagesYouMayLikeListAdapter2.f4850b != pagesYouMayLikeDataHolder) {
            pagesYouMayLikeListAdapter2.f4850b = pagesYouMayLikeDataHolder;
            C06551 c06551 = new C06551(pagesYouMayLikeListAdapter2);
            pagesYouMayLikeDataHolder.f4838b.add(c06551);
            if (pagesYouMayLikeDataHolder.m6055a() > 0) {
                c06551.m6056b();
            }
        }
        this.f4797e = secureContextHelper;
        this.f4798f = uriIntentMapper;
        this.f4799g = feedEventBus;
        this.f4801i = rawLikeHelper;
    }

    public final View m5986a(final Context context, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(context);
        View inflate = from.inflate(2130903082, viewGroup);
        SideshowExpandableListView sideshowExpandableListView = (SideshowExpandableListView) inflate.findViewById(16908298);
        sideshowExpandableListView.g = new OnItemClickedListener(this) {
            final /* synthetic */ PagesYouMayLikeSideshowUnit f4793b;

            public final void m5985a(View view, Object obj) {
                this.f4793b.f4796d.b(this.f4793b.m5991d());
                PagesYouMayLikeRow pagesYouMayLikeRow = (PagesYouMayLikeRow) obj;
                PagesYouMayLikeSideshowUnit pagesYouMayLikeSideshowUnit = this.f4793b;
                Context context = context;
                String str = pagesYouMayLikeRow.f4841a;
                String str2 = pagesYouMayLikeRow.f4842b;
                Intent a = pagesYouMayLikeSideshowUnit.f4798f.a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.af, str));
                if (a != null) {
                    pagesYouMayLikeSideshowUnit.f4797e.a(a, context);
                }
            }
        };
        ActionContentViewSideshowUnit.a(from, sideshowExpandableListView, viewGroup, 2131241716);
        a(context, sideshowExpandableListView);
        sideshowExpandableListView.setAdapter(this.f4794b);
        this.f4800h = new FbEventSubscriberListManager();
        this.f4800h.a(new C06501(this));
        return inflate;
    }

    public final void m5987a() {
        if (this.f4800h != null) {
            this.f4800h.a(this.f4799g);
        }
    }

    public final void m5989b() {
        if (this.f4800h != null) {
            this.f4800h.b(this.f4799g);
        }
    }

    public final void m5990c() {
        PagesYouMayLikeDataHolder pagesYouMayLikeDataHolder = this.f4795c;
        pagesYouMayLikeDataHolder.f4839c = null;
        pagesYouMayLikeDataHolder.f4840d.clear();
        for (C06551 c06551 : pagesYouMayLikeDataHolder.f4838b) {
            AdapterDetour.a(c06551.f4848a, -98440110);
        }
        this.f4800h = null;
    }

    public final void m5988a(Context context, 1 1) {
        PagesYouMayLikeDataHolder pagesYouMayLikeDataHolder = this.f4795c;
        FetchPagesYouMayLikeSideshowDataRequest fetchPagesYouMayLikeSideshowDataRequest = pagesYouMayLikeDataHolder.f4837a;
        Futures.a(fetchPagesYouMayLikeSideshowDataRequest.f4820a.a(GraphQLRequest.a((FetchPagesYouMayLikeSideshowString) new FetchPagesYouMayLikeSideshowString().a("count", Integer.valueOf(10)))), new C06531(fetchPagesYouMayLikeSideshowDataRequest, new C06541(pagesYouMayLikeDataHolder, 1)), fetchPagesYouMayLikeSideshowDataRequest.f4821b);
    }

    public final String m5991d() {
        return "pyml";
    }
}
