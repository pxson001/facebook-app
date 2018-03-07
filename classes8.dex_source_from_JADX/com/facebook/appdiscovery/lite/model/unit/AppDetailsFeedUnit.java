package com.facebook.appdiscovery.lite.model.unit;

import com.facebook.appdiscovery.lite.model.contract.AppDiscoverySeeMoreQueryable;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLModels.AppStoreAppFragmentModel;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLModels.UserFacePileFragmentModel;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLMoreAppsUnitRenderStyle;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: is_failed_bootstrap_entity */
public class AppDetailsFeedUnit extends AppDiscoveryBaseFeedUnit implements AppDiscoverySeeMoreQueryable {
    private final String f10579a;
    private final String f10580b;
    public final AppStoreAppFragmentModel f10581c;
    public final UserFacePileFragmentModel f10582d;
    public final String f10583e;
    private final String f10584f;
    private final GraphQLMoreAppsUnitRenderStyle f10585g;

    public AppDetailsFeedUnit(String str, String str2, AppStoreAppFragmentModel appStoreAppFragmentModel, UserFacePileFragmentModel userFacePileFragmentModel, String str3, String str4, GraphQLMoreAppsUnitRenderStyle graphQLMoreAppsUnitRenderStyle) {
        this.f10579a = str;
        this.f10580b = str2;
        this.f10581c = appStoreAppFragmentModel;
        this.f10582d = userFacePileFragmentModel;
        this.f10583e = str3;
        this.f10584f = str4;
        this.f10585g = graphQLMoreAppsUnitRenderStyle;
    }

    @Nullable
    public final String m12488f() {
        if (this.f10581c == null || this.f10581c.kU_() == null || StringUtil.a(this.f10581c.kU_().m12555d())) {
            return null;
        }
        return this.f10581c.kU_().m12555d();
    }

    @Nullable
    public final String m12489k() {
        if (this.f10581c == null || StringUtil.a(this.f10581c.m12534a())) {
            return null;
        }
        return this.f10581c.m12534a();
    }

    @Nullable
    public final String m12490m() {
        if (this.f10581c == null || this.f10581c.m12538g() == null || StringUtil.a(this.f10581c.m12538g().b())) {
            return null;
        }
        return this.f10581c.m12538g().b();
    }

    @Nullable
    public final DefaultImageFields m12491o() {
        if (!(this.f10581c == null || this.f10581c.m12536c() == null || this.f10581c.m12536c().isEmpty())) {
            DefaultImageFields defaultImageFields = (DefaultImageFields) this.f10581c.m12536c().get(0);
            if (!(defaultImageFields == null || StringUtil.a(defaultImageFields.b()))) {
                return defaultImageFields;
            }
        }
        return null;
    }

    @Nullable
    public final String m12492t() {
        if (this.f10582d == null || this.f10582d.d() == null || StringUtil.a(this.f10582d.d().b())) {
            return null;
        }
        return this.f10582d.d().b();
    }

    @Nullable
    public final Long m12493v() {
        try {
            return Long.valueOf(Long.parseLong(this.f10584f));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public final String mo746a() {
        return this.f10580b;
    }
}
