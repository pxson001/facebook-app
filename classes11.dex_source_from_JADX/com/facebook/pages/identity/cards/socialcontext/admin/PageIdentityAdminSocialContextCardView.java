package com.facebook.pages.identity.cards.socialcontext.admin;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.adinterfaces.util.AdInterfacesHelper;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageHeaderCardView;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageAdminSocialContextDataModel.PageLikersModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: platform_name */
public class PageIdentityAdminSocialContextCardView extends CustomFrameLayout implements PageHeaderCardView {
    private final TextView f3739a = ((TextView) c(2131565422));
    private final TextView f3740b = ((TextView) c(2131565423));
    private final View f3741c = c(2131565424);
    private final View f3742d = c(2131565425);
    public PagesAnalytics f3743e;
    public FbUriIntentHandler f3744f;

    /* compiled from: platform_name */
    class C05101 implements OnClickListener {
        final /* synthetic */ PageIdentityAdminSocialContextCardView f3735a;

        C05101(PageIdentityAdminSocialContextCardView pageIdentityAdminSocialContextCardView) {
            this.f3735a = pageIdentityAdminSocialContextCardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1881114262);
            PageIdentityAdminSocialContextCardView.m4729a(this.f3735a);
            Logger.a(2, EntryType.UI_INPUT_END, -497074367, a);
        }
    }

    /* compiled from: platform_name */
    class C05112 implements OnClickListener {
        final /* synthetic */ PageIdentityAdminSocialContextCardView f3736a;

        C05112(PageIdentityAdminSocialContextCardView pageIdentityAdminSocialContextCardView) {
            this.f3736a = pageIdentityAdminSocialContextCardView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2038259810);
            PageIdentityAdminSocialContextCardView.m4729a(this.f3736a);
            Logger.a(2, EntryType.UI_INPUT_END, -1535035750, a);
        }
    }

    public static void m4730a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageIdentityAdminSocialContextCardView pageIdentityAdminSocialContextCardView = (PageIdentityAdminSocialContextCardView) obj;
        PagesAnalytics a = PagesAnalytics.a(fbInjector);
        FbUriIntentHandler a2 = FbUriIntentHandler.a(fbInjector);
        AdInterfacesHelper.a(fbInjector);
        QeInternalImplMethodAutoProvider.a(fbInjector);
        pageIdentityAdminSocialContextCardView.f3743e = a;
        pageIdentityAdminSocialContextCardView.f3744f = a2;
    }

    public PageIdentityAdminSocialContextCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PageIdentityAdminSocialContextCardView.class;
        m4730a(this, getContext());
        setContentView(2130906002);
    }

    public void setParentFragment(FbFragment fbFragment) {
    }

    public final void mo29a(final PageHeaderData pageHeaderData) {
        PageLikersModel H = pageHeaderData.e.H();
        if (H != null) {
            this.f3739a.setText(StringLocaleUtil.a("%,d", new Object[]{Integer.valueOf(H.a())}));
            this.f3740b.setText(getResources().getQuantityString(2131689618, H.a()));
            this.f3739a.setVisibility(0);
            this.f3740b.setVisibility(0);
            this.f3741c.setVisibility(0);
        } else {
            this.f3739a.setVisibility(8);
            this.f3740b.setVisibility(8);
            this.f3741c.setVisibility(8);
        }
        this.f3739a.setOnClickListener(new C05101(this));
        this.f3740b.setOnClickListener(new C05112(this));
        this.f3742d.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageIdentityAdminSocialContextCardView f3738b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1609609908);
                this.f3738b.f3743e.a(TapEvent.EVENT_TAPPED_INVITE_MORE_FRIENDS, pageHeaderData.a);
                PageIdentityAdminSocialContextCardView pageIdentityAdminSocialContextCardView = this.f3738b;
                pageIdentityAdminSocialContextCardView.f3744f.a(pageIdentityAdminSocialContextCardView.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.cs, Uri.encode(StringFormatUtil.formatStrLocaleSafe("/send_page_invite/?pageid=%1$d&reference=public", Long.valueOf(pageHeaderData.a)))));
                Logger.a(2, EntryType.UI_INPUT_END, -88397312, a);
            }
        });
    }

    public static void m4729a(PageIdentityAdminSocialContextCardView pageIdentityAdminSocialContextCardView) {
        pageIdentityAdminSocialContextCardView.f3744f.a(pageIdentityAdminSocialContextCardView.getContext(), "fb://pma/newlikes");
    }
}
