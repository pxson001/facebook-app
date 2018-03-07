package com.facebook.pages.identity.fragments.surface;

import android.content.Context;
import android.os.ParcelUuid;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent.HeaderPerfLoggingEventType;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionButton;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.common.surface.ui.header.CaspianPagesHeaderView;
import com.facebook.pages.common.surface.ui.metabox.PagesMetaboxView;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.pages.identity.cards.actionbar.PagesActionBar;
import com.facebook.reaction.ui.recyclerview.ReactionHeaderViewWithTouchDelegate;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: pages.identity.cards.service.PageIdentityServiceCardSpecification */
public class PagesHeaderContainer extends ReactionHeaderViewWithTouchDelegate {
    @Inject
    PagesExperimentUtils f4058b;
    @Inject
    PageScopedEventBus f4059c;
    @Inject
    PageCallToActionUtil f4060d;
    private LazyView<PageCallToActionButton> f4061e;
    public PagesActionBar f4062f;
    public CaspianPagesHeaderView f4063g;
    private PagesMetaboxView f4064h;
    private View f4065i;
    private ParcelUuid f4066j;

    /* compiled from: pages.identity.cards.service.PageIdentityServiceCardSpecification */
    class C05571 implements OnInflateRunner<PageCallToActionButton> {
        final /* synthetic */ PagesHeaderContainer f4057a;

        C05571(PagesHeaderContainer pagesHeaderContainer) {
            this.f4057a = pagesHeaderContainer;
        }

        public final void m4973a(View view) {
            PageCallToActionButton pageCallToActionButton = (PageCallToActionButton) view;
            if (this.f4057a.f4058b.c()) {
                LayoutParams layoutParams = (LayoutParams) pageCallToActionButton.getLayoutParams();
                int dimensionPixelSize = this.f4057a.getResources().getDimensionPixelSize(2131427416);
                int dimensionPixelSize2 = this.f4057a.getResources().getDimensionPixelSize(2131427418);
                layoutParams.setMargins(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
                pageCallToActionButton.setLayoutParams(layoutParams);
            }
        }
    }

    private static <T extends View> void m4976a(Class<T> cls, T t) {
        m4977a((Object) t, t.getContext());
    }

    private static void m4977a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PagesHeaderContainer) obj).m4974a(PagesExperimentUtils.a(fbInjector), PageScopedEventBus.a(fbInjector), PageCallToActionUtil.a(fbInjector));
    }

    public PagesHeaderContainer(Context context) {
        super(context);
        m4978b();
    }

    public PagesHeaderContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4978b();
    }

    private void m4978b() {
        m4976a(PagesHeaderContainer.class, (View) this);
        setContentView(2130906113);
        this.f4063g = (CaspianPagesHeaderView) c(2131565710);
        this.f4061e = new LazyView((ViewStub) c(2131565711), new C05571(this));
        this.f4062f = (PagesActionBar) c(2131565712);
        this.f4064h = (PagesMetaboxView) c(2131565713);
    }

    public final void m4980a(PageHeaderData pageHeaderData, FbFragment fbFragment) {
        this.f4063g.setPageHeaderData(pageHeaderData);
        if (pageHeaderData.c() || (pageHeaderData.d() && pageHeaderData.a(Permission.BASIC_ADMIN))) {
            this.f4062f.mo29a(pageHeaderData);
        }
        if (pageHeaderData.c()) {
            m4975a(pageHeaderData);
        }
    }

    private void m4975a(PageHeaderData pageHeaderData) {
        m4979b(pageHeaderData);
        if (this.f4058b.a()) {
            this.f4065i = c(2131565714);
            this.f4065i.setVisibility(4);
        }
        setupMetabox(pageHeaderData);
    }

    public CaspianPagesHeaderView getHeaderView() {
        return this.f4063g;
    }

    public void setLoggingUuid(ParcelUuid parcelUuid) {
        this.f4066j = parcelUuid;
        this.f4062f.setLoggingUuid(parcelUuid);
        this.f4063g.setFragmentUuidForLogging(parcelUuid);
        this.f4064h.f2673l = parcelUuid;
    }

    public PagesActionBar getActionBar() {
        return this.f4062f;
    }

    private void m4979b(PageHeaderData pageHeaderData) {
        if (PageCallToActionUtil.a(pageHeaderData)) {
            PageCallToActionButton pageCallToActionButton = (PageCallToActionButton) this.f4061e.a();
            pageCallToActionButton.setLoggingUuid(this.f4066j);
            pageCallToActionButton.a(pageHeaderData);
            pageCallToActionButton.setVisibility(0);
            return;
        }
        this.f4059c.a(new PageFragmentScopedHeaderPerfLoggingEvent(this.f4066j, HeaderPerfLoggingEventType.CALL_TO_ACTION, Optional.of(DataFreshnessResult.NO_DATA)));
    }

    private void setupMetabox(PageHeaderData pageHeaderData) {
        if (this.f4058b.d()) {
            int i;
            if (pageHeaderData == null || pageHeaderData.e == null || pageHeaderData.e.s() == null || pageHeaderData.e.s().isEmpty() || StringUtil.a((CharSequence) pageHeaderData.e.s().get(0))) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                this.f4064h.m3625a(pageHeaderData);
                this.f4064h.setVisibility(0);
                return;
            }
        }
        this.f4064h.setVisibility(8);
    }

    private void m4974a(PagesExperimentUtils pagesExperimentUtils, PageScopedEventBus pageScopedEventBus, PageCallToActionUtil pageCallToActionUtil) {
        this.f4058b = pagesExperimentUtils;
        this.f4059c = pageScopedEventBus;
        this.f4060d = pageCallToActionUtil;
    }
}
