package com.facebook.pages.identity.cards.actionbar;

import com.facebook.api.graphql.saved.SaveDefaultsGraphQLModels.SavableTimelineAppCollectionExtraFieldsModel;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.Assisted;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageAdminInfoBaseDataModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: privacy_checkup_write_request_flush_failure */
public class PagesActionBarItemFactoryModel {
    private final PageHeaderData f3280a;
    @Nullable
    private final FetchPageHeaderQueryModel f3281b;
    @Nullable
    private final PageAdminInfoBaseDataModel f3282c;

    /* compiled from: privacy_checkup_write_request_flush_failure */
    /* synthetic */ class C04411 {
        static final /* synthetic */ int[] f3279a = new int[GraphQLSubscribeStatus.values().length];

        static {
            try {
                f3279a[GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3279a[GraphQLSubscribeStatus.CANNOT_SUBSCRIBE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    @Inject
    public PagesActionBarItemFactoryModel(@Assisted PageHeaderData pageHeaderData) {
        FetchPageHeaderQueryModel fetchPageHeaderQueryModel;
        PageAdminInfoBaseDataModel pageAdminInfoBaseDataModel = null;
        Preconditions.checkNotNull(pageHeaderData);
        this.f3280a = pageHeaderData;
        if (pageHeaderData != null) {
            fetchPageHeaderQueryModel = this.f3280a.e;
        } else {
            fetchPageHeaderQueryModel = null;
        }
        this.f3281b = fetchPageHeaderQueryModel;
        if (this.f3281b != null) {
            pageAdminInfoBaseDataModel = this.f3281b.l();
        }
        this.f3282c = pageAdminInfoBaseDataModel;
    }

    public final boolean m4404a() {
        return this.f3282c != null && this.f3282c.k();
    }

    private boolean m4397B() {
        return this.f3281b != null && this.f3281b.w();
    }

    public final boolean m4405b() {
        return this.f3280a.a(Permission.BASIC_ADMIN);
    }

    public final boolean m4406c() {
        return this.f3280a.a(Permission.CREATE_ADS);
    }

    public final boolean m4407d() {
        return this.f3280a.a(Permission.ADMINISTER);
    }

    public final boolean m4408e() {
        return this.f3280a.e.p();
    }

    @Nullable
    private SavableTimelineAppCollectionExtraFieldsModel m4398C() {
        return this.f3281b != null ? this.f3281b.S() : null;
    }

    @Nullable
    private GraphQLSavedState m4399D() {
        return this.f3281b != null ? this.f3281b.ag() : null;
    }

    public final boolean m4409f() {
        return (!this.f3280a.a(Permission.CREATE_CONTENT) || this.f3281b == null || this.f3281b.D() == null || this.f3280a.i() == null) ? false : true;
    }

    public final boolean m4410g() {
        return (!this.f3280a.a(Permission.CREATE_CONTENT) || this.f3281b == null || this.f3281b.D() == null || this.f3280a.i() == null) ? false : true;
    }

    public final boolean m4411h() {
        return this.f3282c != null && this.f3282c.a();
    }

    public final boolean m4412i() {
        return this.f3280a.a(Permission.EDIT_PROFILE);
    }

    public final boolean m4413j() {
        return this.f3281b != null && this.f3281b.v();
    }

    public final boolean m4414k() {
        return this.f3281b != null && this.f3281b.q();
    }

    @Nullable
    private GraphQLSubscribeStatus m4400E() {
        return this.f3281b != null ? this.f3281b.Y() : GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }

    @Nullable
    private GraphQLSecondarySubscribeStatus m4401F() {
        return this.f3281b != null ? this.f3281b.T() : null;
    }

    public final boolean m4415l() {
        switch (C04411.f3279a[m4400E().ordinal()]) {
            case 1:
            case 2:
                return false;
            default:
                return true;
        }
    }

    public final boolean m4416m() {
        return GraphQLSubscribeStatus.IS_SUBSCRIBED == m4400E();
    }

    public final boolean m4417n() {
        return GraphQLSecondarySubscribeStatus.SEE_FIRST == m4401F();
    }

    public final boolean m4418o() {
        return (m4407d() || m4398C() == null || !m4402a(m4398C()) || m4399D() == GraphQLSavedState.NOT_SAVABLE) ? false : true;
    }

    private static boolean m4402a(SavableTimelineAppCollectionExtraFieldsModel savableTimelineAppCollectionExtraFieldsModel) {
        return (savableTimelineAppCollectionExtraFieldsModel == null || savableTimelineAppCollectionExtraFieldsModel.b() == null || savableTimelineAppCollectionExtraFieldsModel.j() == null || savableTimelineAppCollectionExtraFieldsModel.k() == null || StringUtil.a(savableTimelineAppCollectionExtraFieldsModel.k().c())) ? false : true;
    }

    public final boolean m4419p() {
        return this.f3281b != null && this.f3281b.ag() == GraphQLSavedState.SAVED;
    }

    public final boolean m4420q() {
        return (m4405b() || this.f3281b == null || !this.f3281b.V()) ? false : true;
    }

    public final boolean m4421r() {
        return (!m4405b() || this.f3281b == null || StringUtil.c(this.f3281b.C())) ? false : true;
    }

    public final boolean m4422s() {
        return m4397B();
    }

    public final boolean m4423t() {
        return !m4405b() && this.f3281b != null && this.f3281b.r() && this.f3281b.W();
    }

    public final boolean m4424u() {
        return (this.f3281b == null || this.f3281b.ab() == null) ? false : true;
    }

    public final boolean m4425v() {
        return this.f3281b != null && this.f3281b.n();
    }

    public final boolean m4426w() {
        return !m4405b() && m4397B();
    }

    public final boolean m4427x() {
        return (m4405b() || m4397B()) ? false : true;
    }

    public final boolean m4428y() {
        if (this.f3281b == null) {
            return false;
        }
        GraphQLPlaceType K = this.f3281b.K();
        if (m4405b() || !m4397B() || K == GraphQLPlaceType.RESIDENCE || K == GraphQLPlaceType.CITY) {
            return false;
        }
        return true;
    }

    public final boolean m4429z() {
        return this.f3282c != null && this.f3282c.j();
    }

    public final boolean m4403A() {
        return (!this.f3280a.a(Permission.CREATE_CONTENT) || this.f3281b == null || this.f3281b.D() == null || this.f3280a.i() == null) ? false : true;
    }
}
