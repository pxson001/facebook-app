package com.facebook.pages.common.surface.calltoaction;

import android.os.ParcelUuid;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventBus;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent;
import com.facebook.pages.common.scoped_eventbus.scopedevent.PageScopedEventsSubscribers.PageFragmentScopedHeaderPerfLoggingEvent.HeaderPerfLoggingEventType;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionButton.CallToActionButtonHandler;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionViewModel.BindModel;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionViewModel.CallToActionClickState;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionViewModel.CallToActionDesignState;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionViewModel.CallToActionIconState;
import com.facebook.pages.common.surface.calltoaction.PageCallToActionViewModel.CallToActionNuxState;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.widget.OnDispatchDrawListener;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: creation_create_requested */
public class PageCallToActionButtonController implements CallToActionButtonHandler {
    private final PagesAnalytics f16626a;
    private final PageCallToActionClickHandler f16627b;
    public final PageScopedEventBus f16628c;
    private final PagesExperimentUtils f16629d;
    private long f16630e;
    private String f16631f;
    private PageCallToActionModel f16632g;
    private boolean f16633h;
    private boolean f16634i;
    public ParcelUuid f16635j;
    public boolean f16636k;

    /* compiled from: creation_create_requested */
    class C17991 implements OnDispatchDrawListener {
        final /* synthetic */ PageCallToActionButtonController f16624a;

        C17991(PageCallToActionButtonController pageCallToActionButtonController) {
            this.f16624a = pageCallToActionButtonController;
        }

        public final boolean m19667a() {
            if (!this.f16624a.f16636k || this.f16624a.f16635j == null) {
                return false;
            }
            this.f16624a.f16628c.a(new PageFragmentScopedHeaderPerfLoggingEvent(this.f16624a.f16635j, HeaderPerfLoggingEventType.CALL_TO_ACTION, Absent.INSTANCE));
            return true;
        }
    }

    /* compiled from: creation_create_requested */
    /* synthetic */ class C18002 {
        static final /* synthetic */ int[] f16625a = new int[GraphQLPageCallToActionType.values().length];

        static {
            try {
                f16625a[GraphQLPageCallToActionType.SHOP_NOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16625a[GraphQLPageCallToActionType.CALL_NOW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16625a[GraphQLPageCallToActionType.MESSAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static PageCallToActionButtonController m19671b(InjectorLike injectorLike) {
        return new PageCallToActionButtonController(PagesAnalytics.a(injectorLike), PageCallToActionClickHandler.m19681b(injectorLike), PageScopedEventBus.m19596a(injectorLike), PagesExperimentUtils.m1891a(injectorLike));
    }

    public static PageCallToActionButtonController m19668a(InjectorLike injectorLike) {
        return m19671b(injectorLike);
    }

    @Inject
    public PageCallToActionButtonController(PagesAnalytics pagesAnalytics, PageCallToActionClickHandler pageCallToActionClickHandler, PageScopedEventBus pageScopedEventBus, PagesExperimentUtils pagesExperimentUtils) {
        this.f16626a = pagesAnalytics;
        this.f16627b = pageCallToActionClickHandler;
        this.f16628c = pageScopedEventBus;
        this.f16629d = pagesExperimentUtils;
    }

    public final BindModel mo1016a(PageHeaderData pageHeaderData) {
        String str;
        Optional optional;
        Optional optional2;
        Preconditions.checkNotNull(pageHeaderData);
        CallToActionIconState callToActionIconState = CallToActionIconState.HIDDEN;
        CallToActionNuxState callToActionNuxState = CallToActionNuxState.NONE;
        CallToActionClickState callToActionClickState = CallToActionClickState.NOT_CLICKABLE;
        CallToActionDesignState callToActionDesignState = CallToActionDesignState.WIDE;
        FetchPageHeaderQueryModel fetchPageHeaderQueryModel = pageHeaderData.f17308e;
        if (!(fetchPageHeaderQueryModel == null || fetchPageHeaderQueryModel.m20884G() == null)) {
            this.f16630e = pageHeaderData.f17304a;
            this.f16631f = fetchPageHeaderQueryModel.m20881D();
            this.f16632g = fetchPageHeaderQueryModel.m20884G();
            ImmutableList af = fetchPageHeaderQueryModel.af();
            this.f16633h = new ProfilePermissions(af).a(Permission.BASIC_ADMIN);
            this.f16634i = new ProfilePermissions(af).a(Permission.EDIT_PROFILE);
            boolean z = this.f16633h || !this.f16634i;
            Preconditions.checkArgument(z);
            callToActionClickState = CallToActionClickState.CLICKABLE;
            callToActionIconState = m19674d();
            callToActionNuxState = m19673c();
            callToActionDesignState = this.f16629d.m1895c() ? CallToActionDesignState.NARROW : CallToActionDesignState.WIDE;
        }
        this.f16636k = true;
        if (fetchPageHeaderQueryModel == null) {
            str = "";
        } else {
            str = fetchPageHeaderQueryModel.m20881D();
        }
        if (this.f16632g == null || this.f16632g.m21023m() == null) {
            optional = Absent.INSTANCE;
        } else {
            optional = Optional.of(this.f16632g.m21023m());
        }
        if (this.f16632g == null || this.f16632g.m21026p() == null) {
            optional2 = Absent.INSTANCE;
        } else {
            optional2 = Optional.of(this.f16632g.m21026p().m19909k());
        }
        return new BindModel(str, callToActionIconState, optional, optional2, callToActionNuxState, callToActionClickState, callToActionDesignState);
    }

    public final void mo1018a(ParcelUuid parcelUuid) {
        this.f16635j = parcelUuid;
    }

    public final OnDispatchDrawListener mo1019b() {
        return new C17991(this);
    }

    private CallToActionNuxState m19673c() {
        if (!this.f16634i || this.f16632g == null || this.f16632g.m21025o() == null) {
            return CallToActionNuxState.NONE;
        }
        if (this.f16632g.m21025o().m21002j()) {
            switch (C18002.f16625a[this.f16632g.m21019g().ordinal()]) {
                case 1:
                    return CallToActionNuxState.AUTO_PROVISION_SHOP_CTA;
                case 2:
                    return CallToActionNuxState.AUTO_PROVISION_CALL_CTA;
                case 3:
                    return CallToActionNuxState.AUTO_PROVISION_MESSENGER_CTA;
            }
        }
        if (!this.f16632g.m21025o().m21001a()) {
            return CallToActionNuxState.NONE;
        }
        if (PageCallToActionUtil.m20167a(this.f16632g)) {
            return CallToActionNuxState.EDIT_CTA;
        }
        return PageCallToActionUtil.m20166a(this.f16632g.m21019g()) ? CallToActionNuxState.CREATE_CTA : CallToActionNuxState.NONE;
    }

    private CallToActionIconState m19674d() {
        if (this.f16633h) {
            if (!this.f16634i) {
                return CallToActionIconState.HIDDEN;
            }
            if (PageCallToActionUtil.m20167a(this.f16632g)) {
                return CallToActionIconState.PENCIL;
            }
            return CallToActionIconState.HIDDEN;
        } else if (PageCallToActionUtil.m20171b(this.f16632g)) {
            return CallToActionIconState.HIDDEN;
        } else {
            return CallToActionIconState.LEAVE_APP;
        }
    }

    public final void mo1017a() {
        Preconditions.checkNotNull(this.f16632g);
        this.f16626a.a(this.f16630e, this.f16632g.m21021k(), this.f16632g.m21019g());
        if (!this.f16633h) {
            this.f16627b.m19684a(this.f16630e, this.f16631f, this.f16632g);
        } else if (this.f16634i) {
            this.f16627b.m19683a(this.f16630e, this.f16632g);
        } else {
            this.f16627b.m19685a(this.f16632g, this.f16630e);
        }
    }
}
