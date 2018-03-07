package com.facebook.pages.identity.cards.postsbyothers.admin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.intent_builder.DefaultPageSurfaceIntentBuilder;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageHeaderCardView;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.intent.impl.FbAndroidPageSurfaceIntentBuilder;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: prefetch_notification_image_in_bkg */
public class PageIdentityAdminPostsByOthersCardView extends CustomFrameLayout implements PageHeaderCardView {
    public DefaultPageSurfaceIntentBuilder f3638a;
    public SecureContextHelper f3639b;
    public PagesAnalytics f3640c;
    public Resources f3641d = getResources();
    public Lazy<FbErrorReporter> f3642e;
    public FbTextView f3643f = ((FbTextView) c(2131565421));

    public static void m4673a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageIdentityAdminPostsByOthersCardView pageIdentityAdminPostsByOthersCardView = (PageIdentityAdminPostsByOthersCardView) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        DefaultPageSurfaceIntentBuilder defaultPageSurfaceIntentBuilder = (DefaultPageSurfaceIntentBuilder) FbAndroidPageSurfaceIntentBuilder.m5074b(fbInjector);
        PagesAnalytics a = PagesAnalytics.a(fbInjector);
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 494);
        pageIdentityAdminPostsByOthersCardView.f3639b = secureContextHelper;
        pageIdentityAdminPostsByOthersCardView.f3638a = defaultPageSurfaceIntentBuilder;
        pageIdentityAdminPostsByOthersCardView.f3640c = a;
        pageIdentityAdminPostsByOthersCardView.f3642e = b;
    }

    public PageIdentityAdminPostsByOthersCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PageIdentityAdminPostsByOthersCardView.class;
        m4673a(this, getContext());
        setContentView(2130906001);
        setContentDescription(this.f3641d.getString(2131235503));
    }

    public void setParentFragment(FbFragment fbFragment) {
    }

    public final void mo29a(final PageHeaderData pageHeaderData) {
        int a;
        if (pageHeaderData.e.Q() != null) {
            a = pageHeaderData.e.Q().a();
        } else {
            a = 0;
        }
        if (a == 0) {
            this.f3643f.setText(this.f3641d.getString(2131235504));
        } else {
            this.f3643f.setText(this.f3641d.getQuantityString(2131689623, a, new Object[]{Integer.valueOf(a)}));
        }
        this.f3643f.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageIdentityAdminPostsByOthersCardView f3637b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 388862721);
                this.f3637b.f3640c.a(TapEvent.EVENT_TAPPED_POSTS_BY_OTHERS, pageHeaderData.a);
                Intent c = this.f3637b.f3638a.c(pageHeaderData.a, pageHeaderData.e.D());
                if (c != null) {
                    this.f3637b.f3639b.a(c, this.f3637b.getContext());
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1833421717, a);
            }
        });
    }
}
