package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import com.facebook.pages.common.viewercontextutils.ViewerContextUtil;
import com.facebook.pages.fb4a.abtest.qe.ExperimentsForPagesFb4aAbTestModule;
import com.facebook.pages.fb4a.admin_activity.fragment.PageActivityFragment.UpdateViewListener;
import com.facebook.pages.fb4a.admin_activity.uri.PagesFb4aAdminActivityUriIntentBuilder;
import com.facebook.pages.fb4a.admin_activity.views.PageIdentityLinkView.WebViewLaunchedListener;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pymi_xout */
public class PageIdentityNotificationsLinkView extends PageIdentityLinkView {
    @Inject
    QeAccessor f2907h;
    @Inject
    AdminedPagesRamCache f2908i;
    @Inject
    PagesFb4aAdminActivityUriIntentBuilder f2909j;
    @Inject
    ViewerContextUtil f2910k;

    private static <T extends View> void m3865a(Class<T> cls, T t) {
        m3866a((Object) t, t.getContext());
    }

    private static void m3866a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityNotificationsLinkView) obj).m3864a((QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector), AdminedPagesRamCache.a(fbInjector), PagesFb4aAdminActivityUriIntentBuilder.m3759a(fbInjector), ViewerContextUtil.b(fbInjector));
    }

    public PageIdentityNotificationsLinkView(Context context) {
        super(context);
        m3863a();
    }

    public PageIdentityNotificationsLinkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3863a();
    }

    public PageIdentityNotificationsLinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3863a();
    }

    private void m3864a(QeAccessor qeAccessor, AdminedPagesRamCache adminedPagesRamCache, PagesFb4aAdminActivityUriIntentBuilder pagesFb4aAdminActivityUriIntentBuilder, ViewerContextUtil viewerContextUtil) {
        this.f2907h = qeAccessor;
        this.f2908i = adminedPagesRamCache;
        this.f2909j = pagesFb4aAdminActivityUriIntentBuilder;
        this.f2910k = viewerContextUtil;
    }

    private void m3863a() {
        m3865a(PageIdentityNotificationsLinkView.class, (View) this);
    }

    public final void mo75a(String str, long j, Optional<? extends WebViewLaunchedListener> optional) {
        final long j2 = j;
        final String str2 = str;
        final Optional<? extends WebViewLaunchedListener> optional2 = optional;
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageIdentityNotificationsLinkView f2906d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1520405936);
                Intent b = PageIdentityNotificationsLinkView.m3867b(this.f2906d, j2);
                if (b == null || !this.f2906d.f2907h.a(Liveness.Live, ExperimentsForPagesFb4aAbTestModule.a, false)) {
                    this.f2906d.m3855a(j2);
                    Intent a2 = this.f2906d.f2895e.a(this.f2906d.getContext(), StringFormatUtil.formatStrLocaleSafe(str2, Long.valueOf(j2)));
                    a2.putExtra("uri_unhandled_report_category_name", "PageFacewebUriNotHandled");
                    if (optional2.isPresent()) {
                        ((UpdateViewListener) optional2.get()).m3741a();
                    }
                    this.f2906d.f2893c.a(a2, this.f2906d.getContext());
                } else {
                    this.f2906d.f2893c.a(b, this.f2906d.getContext());
                }
                LogUtils.a(-1268390856, a);
            }
        });
    }

    @Nullable
    public static Intent m3867b(PageIdentityNotificationsLinkView pageIdentityNotificationsLinkView, long j) {
        String valueOf = String.valueOf(j);
        AdminedPagesPrefetchNode adminedPagesPrefetchNode = (AdminedPagesPrefetchNode) pageIdentityNotificationsLinkView.f2908i.b(valueOf);
        if (adminedPagesPrefetchNode == null || !adminedPagesPrefetchNode.b.isPresent()) {
            return null;
        }
        ViewerContext a = pageIdentityNotificationsLinkView.f2910k.a(valueOf, (String) ((AdminedPagesPrefetchNode) pageIdentityNotificationsLinkView.f2908i.b(valueOf)).b.get());
        Intent a2 = pageIdentityNotificationsLinkView.f2909j.a(pageIdentityNotificationsLinkView.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.a("page/%s/notifications"), Long.valueOf(j)));
        if (a2 == null) {
            return null;
        }
        a2.putExtra("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT", a);
        return a2;
    }
}
