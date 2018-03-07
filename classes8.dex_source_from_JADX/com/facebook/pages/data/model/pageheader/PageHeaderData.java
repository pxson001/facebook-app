package com.facebook.pages.data.model.pageheader;

import android.location.Location;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.FetchPageHeaderQueryModel;
import com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLModels.ProfileVideoHeaderFieldsModel;
import com.facebook.timeline.profilevideo.playback.protocol.ProfileVideoHeaderData;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: confirmation_back_press */
public class PageHeaderData implements ProfileVideoHeaderData {
    public final long f17304a;
    public final Location f17305b;
    private DataFreshnessResult f17306c = DataFreshnessResult.NO_DATA;
    private InitializationState f17307d = InitializationState.UNINITIALIZED;
    public FetchPageHeaderQueryModel f17308e;
    public ProfileVideoHeaderFieldsModel f17309f;
    public String f17310g;

    /* compiled from: confirmation_back_press */
    public enum InitializationState {
        UNINITIALIZED,
        PRELIMINARY_DATA,
        FINAL_DATA
    }

    public PageHeaderData(long j, Location location) {
        this.f17304a = j;
        this.f17305b = location;
    }

    public final void m21326a(FetchPageHeaderQueryModel fetchPageHeaderQueryModel, DataFreshnessResult dataFreshnessResult) {
        Preconditions.checkNotNull(Long.valueOf(this.f17304a));
        m21325a(fetchPageHeaderQueryModel);
        this.f17306c = dataFreshnessResult;
        this.f17307d = InitializationState.FINAL_DATA;
    }

    public final void m21327a(FetchPageHeaderQueryModel fetchPageHeaderQueryModel, String str) {
        Preconditions.checkNotNull(Long.valueOf(this.f17304a));
        m21325a(fetchPageHeaderQueryModel);
        this.f17310g = str;
        this.f17307d = InitializationState.PRELIMINARY_DATA;
    }

    public final boolean m21330c() {
        return this.f17307d == InitializationState.FINAL_DATA;
    }

    public final boolean m21331d() {
        return this.f17307d != InitializationState.UNINITIALIZED;
    }

    public final long m21332e() {
        return this.f17304a;
    }

    public final boolean m21328a(Permission permission) {
        if (this.f17308e.af().isEmpty()) {
            return false;
        }
        return new ProfilePermissions(this.f17308e.af()).a(permission);
    }

    @Nullable
    public final FetchPageHeaderQueryModel m21333g() {
        return this.f17308e;
    }

    @Nullable
    public final String m21334i() {
        if (this.f17308e.m20891N() != null) {
            return this.f17308e.m20891N().b();
        }
        if (StringUtil.a(this.f17310g)) {
            return null;
        }
        return this.f17310g;
    }

    public final void m21325a(FetchPageHeaderQueryModel fetchPageHeaderQueryModel) {
        this.f17308e = fetchPageHeaderQueryModel;
        if (this.f17308e != null && this.f17308e.m20893P() != null) {
            this.f17309f = this.f17308e.m20893P().j();
        }
    }

    public final String m21324a() {
        return null;
    }

    public final ProfileVideoHeaderFieldsModel m21329b() {
        return this.f17309f;
    }
}
