package com.facebook.composer.privacy.common;

import android.content.res.Resources;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData.Builder;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.composer.privacy.common.graphql.FetchGroupDetails.GroupDetailsQueryString;
import com.facebook.composer.privacy.common.graphql.FetchGroupDetailsModels.GroupDetailsQueryModel;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLGroup;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.Assisted;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: tapped_unsave_media_page */
public final class ComposerGroupPrivacyDelegate extends ComposerPrivacyDelegate {
    private final GraphQLQueryExecutor f1983a;
    private final long f1984b;
    private final String f1985c;
    public final Resources f1986d;

    /* compiled from: tapped_unsave_media_page */
    public /* synthetic */ class C02062 {
        public static final /* synthetic */ int[] f1982a = new int[GraphQLGroupVisibility.values().length];

        static {
            try {
                f1982a[GraphQLGroupVisibility.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1982a[GraphQLGroupVisibility.SECRET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1982a[GraphQLGroupVisibility.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public ComposerGroupPrivacyDelegate(@Assisted PrivacyUpdatedHandler privacyUpdatedHandler, AbstractFbErrorReporter abstractFbErrorReporter, TasksManager tasksManager, GraphQLQueryExecutor graphQLQueryExecutor, Resources resources, @Assisted Long l, @Assisted String str) {
        super(privacyUpdatedHandler, abstractFbErrorReporter, tasksManager);
        this.f1983a = graphQLQueryExecutor;
        this.f1984b = l.longValue();
        this.f1985c = str;
        this.f1986d = resources;
    }

    public final void mo91a() {
        super.mo91a();
        Builder builder = new Builder();
        builder.f1972a = GraphQLPrivacyOptionType.GROUP;
        builder = builder;
        builder.f1973b = this.f1986d.getString(2131234274);
        builder = builder;
        builder.f1974c = this.f1986d.getString(2131234275);
        ComposerFixedPrivacyData a = builder.m1926a();
        ComposerPrivacyData.Builder builder2 = new ComposerPrivacyData.Builder();
        builder2.f1994a = true;
        builder2 = builder2;
        builder2.f1995b = true;
        final ComposerPrivacyData a2 = builder2.m1943a(a).m1945a();
        m1904a(a2);
        GraphQlQueryString groupDetailsQueryString = new GroupDetailsQueryString();
        groupDetailsQueryString.a("group_id", String.valueOf(this.f1984b));
        this.f1956c.a("fetch_group_data", this.f1983a.a(GraphQLRequest.a(groupDetailsQueryString)), new AbstractDisposableFutureCallback<GraphQLResult<GroupDetailsQueryModel>>(this) {
            final /* synthetic */ ComposerGroupPrivacyDelegate f1981b;

            protected final void m1927a(Object obj) {
                GroupDetailsQueryModel groupDetailsQueryModel = (GroupDetailsQueryModel) ((GraphQLResult) obj).e;
                if (groupDetailsQueryModel == null) {
                    ComposerPrivacyData.Builder builder = new ComposerPrivacyData.Builder(a2);
                    builder.f1995b = false;
                    this.f1981b.m1904a(builder.m1945a());
                    return;
                }
                boolean z;
                GraphQLGroup graphQLGroup = null;
                if (groupDetailsQueryModel.m2037b() != null) {
                    GraphQLGroup.Builder builder2 = new GraphQLGroup.Builder();
                    builder2.E = groupDetailsQueryModel.m2037b().m2016b();
                    builder2 = builder2;
                    String c = groupDetailsQueryModel.m2037b().m2017c();
                    builder2.M = c;
                    if (builder2.a != null && builder2.a.d) {
                        builder2.a.a(builder2.b, 33, c);
                    }
                    graphQLGroup = new GraphQLGroup(builder2);
                }
                Builder builder3 = new Builder(a2.f2000a);
                ComposerGroupPrivacyDelegate composerGroupPrivacyDelegate = this.f1981b;
                GraphQLGroupVisibility c2 = groupDetailsQueryModel.m2038c();
                if (graphQLGroup != null) {
                    z = true;
                } else {
                    z = false;
                }
                builder3.f1972a = ComposerGroupPrivacyDelegate.m1929a(composerGroupPrivacyDelegate, c2, z);
                Builder builder4 = builder3;
                builder4.f1973b = ComposerGroupPrivacyDelegate.m1931b(this.f1981b, groupDetailsQueryModel.m2038c(), graphQLGroup);
                builder4 = builder4;
                builder4.f1974c = ComposerGroupPrivacyDelegate.m1930a(this.f1981b, groupDetailsQueryModel.m2038c(), graphQLGroup);
                ComposerFixedPrivacyData a = builder4.m1926a();
                ComposerPrivacyData.Builder builder5 = new ComposerPrivacyData.Builder(a2);
                builder5.f1995b = false;
                this.f1981b.m1904a(builder5.m1943a(a).m1945a());
            }

            protected final void m1928a(Throwable th) {
                ComposerPrivacyData.Builder builder = new ComposerPrivacyData.Builder(a2);
                builder.f1995b = false;
                this.f1981b.m1904a(builder.m1945a());
                if (th instanceof ApiException) {
                    this.f1981b.f1955b.a("composer_group_fetch_error", "Failed to fetch group data for composer", th);
                }
            }
        });
    }

    public static GraphQLPrivacyOptionType m1929a(ComposerGroupPrivacyDelegate composerGroupPrivacyDelegate, GraphQLGroupVisibility graphQLGroupVisibility, boolean z) {
        if (graphQLGroupVisibility != null) {
            switch (C02062.f1982a[graphQLGroupVisibility.ordinal()]) {
                case 1:
                case 2:
                    return GraphQLPrivacyOptionType.GROUP;
                case 3:
                    if (z) {
                        return GraphQLPrivacyOptionType.GROUP;
                    }
                    return GraphQLPrivacyOptionType.EVERYONE;
            }
        }
        composerGroupPrivacyDelegate.f1955b.a("composer_group_undefined_privacy", "Could not determine group privacy, id=" + composerGroupPrivacyDelegate.f1984b + ", visibility=" + graphQLGroupVisibility);
        return GraphQLPrivacyOptionType.GROUP;
    }

    static /* synthetic */ String m1931b(ComposerGroupPrivacyDelegate composerGroupPrivacyDelegate, GraphQLGroupVisibility graphQLGroupVisibility, GraphQLGroup graphQLGroup) {
        String string;
        if (graphQLGroupVisibility != null) {
            switch (C02062.f1982a[graphQLGroupVisibility.ordinal()]) {
                case 1:
                    string = composerGroupPrivacyDelegate.f1986d.getString(2131234265);
                    break;
                case 2:
                    string = composerGroupPrivacyDelegate.f1986d.getString(2131234264);
                    break;
                case 3:
                    if (graphQLGroup == null) {
                        string = composerGroupPrivacyDelegate.f1986d.getString(2131234252);
                        break;
                    }
                    string = composerGroupPrivacyDelegate.f1986d.getString(2131234267, new Object[]{graphQLGroup.P()});
                    break;
            }
        }
        string = null;
        return string;
    }

    static /* synthetic */ String m1930a(ComposerGroupPrivacyDelegate composerGroupPrivacyDelegate, GraphQLGroupVisibility graphQLGroupVisibility, GraphQLGroup graphQLGroup) {
        String string;
        if (graphQLGroupVisibility != null) {
            switch (C02062.f1982a[graphQLGroupVisibility.ordinal()]) {
                case 1:
                case 2:
                    string = composerGroupPrivacyDelegate.f1986d.getString(2131234255);
                    break;
                case 3:
                    if (graphQLGroup == null) {
                        string = composerGroupPrivacyDelegate.f1986d.getString(2131234257);
                        break;
                    }
                    string = composerGroupPrivacyDelegate.f1986d.getString(2131234256, new Object[]{graphQLGroup.P()});
                    break;
            }
        }
        string = null;
        return string;
    }

    public final String mo92b() {
        return "group:" + String.valueOf(this.f1984b);
    }
}
