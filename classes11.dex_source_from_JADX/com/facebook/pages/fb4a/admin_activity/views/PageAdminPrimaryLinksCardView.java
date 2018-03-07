package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLInterfaces.FetchPageActivityQuery.ActivityAdminInfo;
import com.facebook.pages.common.protocol.graphql.FetchPageActivityGraphQLModels.FetchPageActivityQueryModel.ActivityAdminInfoModel;
import com.facebook.pages.fb4a.abtest.PagesFb4aAbTestGatekeepers;
import com.facebook.pages.fb4a.abtest.qe.ExperimentsForPagesFb4aAbTestModule;
import com.facebook.pages.fb4a.admin_activity.views.PageIdentityLinkView.WebViewLaunchedListener;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: questionId not in unit */
public class PageAdminPrimaryLinksCardView extends CustomFrameLayout {
    @Inject
    public GatekeeperStoreImpl f2878a;
    @Inject
    public QeAccessor f2879b;
    private Handler f2880c;

    private static <T extends View> void m3829a(Class<T> cls, T t) {
        m3830a((Object) t, t.getContext());
    }

    private static void m3830a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageAdminPrimaryLinksCardView pageAdminPrimaryLinksCardView = (PageAdminPrimaryLinksCardView) obj;
        GatekeeperStoreImpl a = GatekeeperStoreImplMethodAutoProvider.a(fbInjector);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        pageAdminPrimaryLinksCardView.f2878a = a;
        pageAdminPrimaryLinksCardView.f2879b = qeAccessor;
    }

    public PageAdminPrimaryLinksCardView(Context context) {
        super(context);
        m3828a();
    }

    public PageAdminPrimaryLinksCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3828a();
    }

    public PageAdminPrimaryLinksCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3828a();
    }

    private void m3828a() {
        setContentView(2130905962);
        this.f2880c = new Handler(Looper.getMainLooper());
        m3829a(PageAdminPrimaryLinksCardView.class, (View) this);
    }

    public final void m3835a(long j, ActivityAdminInfo activityAdminInfo, Optional<? extends WebViewLaunchedListener> optional, boolean z) {
        ImmutableList a = m3827a(z);
        int size = a.size();
        for (int i = 0; i < size; i++) {
            PageAdminActionItem pageAdminActionItem = (PageAdminActionItem) a.get(i);
            PageIdentityLinkView pageIdentityLinkView = (PageIdentityLinkView) c(pageAdminActionItem.resId);
            pageIdentityLinkView.mo75a(pageAdminActionItem.uri, j, optional);
            pageIdentityLinkView.f2892b = pageAdminActionItem.loggingEvent;
            pageIdentityLinkView.setVisibility(0);
            if (pageAdminActionItem.equals(PageAdminActionItem.NEW_LIKES) || pageAdminActionItem.equals(PageAdminActionItem.SCHEDULED_POSTS) || pageAdminActionItem.equals(PageAdminActionItem.DRAFTS)) {
                pageIdentityLinkView.setBadgeStyle(PagesLinkViewBadgeStyle.SECONDARY);
            }
        }
        m3836a((ActivityAdminInfoModel) activityAdminInfo);
        m3837b(activityAdminInfo);
    }

    private ImmutableList<PageAdminActionItem> m3827a(boolean z) {
        Builder builder = ImmutableList.builder();
        if (z && this.f2879b.a(Liveness.Live, ExperimentsForPagesFb4aAbTestModule.i, false)) {
            builder.c(PageAdminActionItem.MESSAGES);
        }
        builder.c(PageAdminActionItem.NOTIFICATIONS);
        if (this.f2878a.a(PagesFb4aAbTestGatekeepers.a, false)) {
            builder.c(PageAdminActionItem.PAGES_FEED);
        }
        builder.c(PageAdminActionItem.NEW_LIKES);
        builder.c(PageAdminActionItem.SCHEDULED_POSTS);
        builder.c(PageAdminActionItem.DRAFTS);
        if (this.f2878a.a(PagesFb4aAbTestGatekeepers.k, false)) {
            builder.c(PageAdminActionItem.PAGE_TIPS);
        }
        return builder.b();
    }

    public final void m3834a(final int i, final int i2) {
        HandlerDetour.b(this.f2880c, new Runnable(this) {
            final /* synthetic */ PageAdminPrimaryLinksCardView f2873c;

            public void run() {
                PageIdentityLinkView pageIdentityLinkView = (PageIdentityLinkView) this.f2873c.c(PageAdminActionItem.NOTIFICATIONS.resId);
                ((PageIdentityLinkView) this.f2873c.c(PageAdminActionItem.NEW_LIKES.resId)).setBadgeNumber((long) i);
                pageIdentityLinkView.setBadgeNumber((long) i2);
            }
        }, 100, -80487091);
    }

    public final void m3836a(ActivityAdminInfoModel activityAdminInfoModel) {
        final int a = activityAdminInfoModel == null ? 0 : activityAdminInfoModel.m2745b().m2697a();
        HandlerDetour.b(this.f2880c, new Runnable(this) {
            final /* synthetic */ PageAdminPrimaryLinksCardView f2875b;

            public void run() {
                PageIdentityLinkView pageIdentityLinkView = (PageIdentityLinkView) this.f2875b.c(PageAdminActionItem.SCHEDULED_POSTS.resId);
                pageIdentityLinkView.setBadgeNumber((long) a);
                pageIdentityLinkView.setVisibility(a > 0 ? 0 : 8);
            }
        }, 100, 206249898);
    }

    public final void m3837b(ActivityAdminInfoModel activityAdminInfoModel) {
        final int a = activityAdminInfoModel == null ? 0 : activityAdminInfoModel.m2743a().m2691a();
        HandlerDetour.b(this.f2880c, new Runnable(this) {
            final /* synthetic */ PageAdminPrimaryLinksCardView f2877b;

            public void run() {
                PageIdentityLinkView pageIdentityLinkView = (PageIdentityLinkView) this.f2877b.c(PageAdminActionItem.DRAFTS.resId);
                pageIdentityLinkView.setBadgeNumber((long) a);
                pageIdentityLinkView.setVisibility(a > 0 ? 0 : 8);
            }
        }, 100, 965571281);
    }
}
