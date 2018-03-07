package com.facebook.pages.identity.cards.postsbyothers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.common.intent_builder.IPageIdentityIntentBuilder;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.pages.data.graphql.cards.PostsByOthersCardGraphQLModels.PostsByOthersCardQueryModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.identity.intent.impl.FbAndroidPageSurfaceIntentBuilder;
import com.facebook.pages.identity.ui.PageIdentityPublisher;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: previousText */
public class PageIdentityPostsByOthersCardView extends CustomFrameLayout implements PageSecondaryCardView {
    @Inject
    public DefaultPageSurfaceIntentBuilder f3629a;
    @Inject
    public SecureContextHelper f3630b;
    @Inject
    PagesAnalytics f3631c;
    @Inject
    public Resources f3632d = getResources();
    @Inject
    Lazy<FbErrorReporter> f3633e;
    public BetterTextView f3634f = ((BetterTextView) c(2131565524));
    public PageIdentityPublisher f3635g = ((PageIdentityPublisher) c(2131565525));

    public static void m4665a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityPostsByOthersCardView) obj).m4664a((DefaultPageSurfaceIntentBuilder) FbAndroidPageSurfaceIntentBuilder.m5074b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), PagesAnalytics.a(fbInjector), ResourcesMethodAutoProvider.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 494));
    }

    public PageIdentityPostsByOthersCardView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PageIdentityPostsByOthersCardView.class;
        m4665a(this, getContext());
        setContentView(2130906032);
        setContentDescription(this.f3632d.getString(2131235503));
    }

    public final void m4666a(final long j, final FetchPageHeaderQueryModel fetchPageHeaderQueryModel, PostsByOthersCardQueryModel postsByOthersCardQueryModel) {
        m4663a(j, fetchPageHeaderQueryModel.D(), fetchPageHeaderQueryModel.N() != null ? fetchPageHeaderQueryModel.N().b() : null, postsByOthersCardQueryModel.j(), postsByOthersCardQueryModel.k(), new ProfilePermissions(fetchPageHeaderQueryModel.af()).a(Permission.CREATE_CONTENT));
        this.f3634f.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageIdentityPostsByOthersCardView f3628c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 905935169);
                this.f3628c.f3631c.a(TapEvent.EVENT_TAPPED_POSTS_BY_OTHERS, j);
                PageIdentityPostsByOthersCardView pageIdentityPostsByOthersCardView = this.f3628c;
                Intent c = pageIdentityPostsByOthersCardView.f3629a.c(j, fetchPageHeaderQueryModel.D());
                if (c != null) {
                    pageIdentityPostsByOthersCardView.f3630b.a(c, pageIdentityPostsByOthersCardView.getContext());
                }
                Logger.a(2, EntryType.UI_INPUT_END, -503215782, a);
            }
        });
    }

    private void m4663a(long j, String str, String str2, boolean z, boolean z2, boolean z3) {
        if (!z || z3) {
            this.f3635g.setVisibility(8);
            return;
        }
        this.f3635g.setVisibility(0);
        this.f3635g.m5229a(j, str, str2, z2, "pages_public_view");
    }

    private void m4664a(IPageIdentityIntentBuilder iPageIdentityIntentBuilder, SecureContextHelper secureContextHelper, PagesAnalytics pagesAnalytics, Resources resources, Lazy<FbErrorReporter> lazy) {
        this.f3629a = iPageIdentityIntentBuilder;
        this.f3630b = secureContextHelper;
        this.f3631c = pagesAnalytics;
        this.f3632d = resources;
        this.f3633e = lazy;
    }
}
