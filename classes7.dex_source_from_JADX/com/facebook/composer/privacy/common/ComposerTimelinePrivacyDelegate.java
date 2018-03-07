package com.facebook.composer.privacy.common;

import android.content.res.Resources;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData.Builder;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.composer.privacy.common.graphql.FetchProfileDetailsGraphQL.ProfileDetailsQueryString;
import com.facebook.composer.privacy.common.graphql.FetchProfileDetailsGraphQLModels.ProfileDetailsModel;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: tapped_report_problem */
public class ComposerTimelinePrivacyDelegate extends ComposerPrivacyDelegate {
    private final long f2021a;
    private final GraphQLQueryExecutor f2022b;
    public final String f2023c;
    public final ComposerTargetDataPrivacyScopeFields f2024d;
    public final Resources f2025e;

    @Inject
    public ComposerTimelinePrivacyDelegate(@Assisted PrivacyUpdatedHandler privacyUpdatedHandler, AbstractFbErrorReporter abstractFbErrorReporter, TasksManager tasksManager, @Assisted Long l, @Assisted String str, @Assisted ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields, GraphQLQueryExecutor graphQLQueryExecutor, Resources resources) {
        super(privacyUpdatedHandler, abstractFbErrorReporter, tasksManager);
        this.f2022b = graphQLQueryExecutor;
        this.f2021a = l.longValue();
        this.f2023c = str;
        this.f2024d = composerTargetDataPrivacyScopeFields;
        this.f2025e = resources;
    }

    public final void mo91a() {
        super.mo91a();
        boolean z = true;
        Builder builder = new Builder();
        builder.f1972a = GraphQLPrivacyOptionType.CUSTOM;
        builder = builder;
        builder.f1973b = this.f2025e.getString(2131234199);
        builder = builder;
        builder.f1974c = this.f2025e.getString(2131234254, new Object[]{this.f2023c});
        ComposerFixedPrivacyData a = builder.m1926a();
        if (this.f2024d != null) {
            Builder builder2 = new Builder(a);
            builder2.f1972a = m1968b(this.f2024d);
            builder = builder2;
            builder.f1973b = m1967a(this, this.f2024d, this.f2023c);
            a = builder.m1926a();
        }
        ComposerPrivacyData.Builder builder3 = new ComposerPrivacyData.Builder();
        builder3.f1994a = true;
        builder3 = builder3;
        if (this.f2024d != null) {
            z = false;
        }
        builder3.f1995b = z;
        final ComposerPrivacyData a2 = builder3.m1943a(a).m1945a();
        m1904a(a2);
        if (a2.f2003d) {
            GraphQlQueryString profileDetailsQueryString = new ProfileDetailsQueryString();
            profileDetailsQueryString.a("profile_id", String.valueOf(this.f2021a));
            this.f1956c.a("fetch_profile_data", this.f2022b.a(GraphQLRequest.a(profileDetailsQueryString)), new AbstractDisposableFutureCallback<GraphQLResult<ProfileDetailsModel>>(this) {
                final /* synthetic */ ComposerTimelinePrivacyDelegate f2020b;

                protected final void m1965a(Object obj) {
                    ProfileDetailsModel profileDetailsModel = (ProfileDetailsModel) ((GraphQLResult) obj).e;
                    if (profileDetailsModel == null || profileDetailsModel.m2052a() == null || profileDetailsModel.m2052a().b() == null || profileDetailsModel.m2052a().a() == null) {
                        m1966a(new IllegalArgumentException("privacy scope missing"));
                        return;
                    }
                    Builder builder = new Builder(a2.f2000a);
                    builder.f1972a = ComposerTimelinePrivacyDelegate.m1968b(profileDetailsModel.m2052a());
                    builder = builder;
                    builder.f1973b = ComposerTimelinePrivacyDelegate.m1967a(this.f2020b, profileDetailsModel.m2052a(), this.f2020b.f2023c);
                    ComposerFixedPrivacyData a = builder.m1926a();
                    ComposerPrivacyData.Builder builder2 = new ComposerPrivacyData.Builder(a2);
                    builder2.f1995b = false;
                    this.f2020b.m1904a(builder2.m1943a(a).m1945a());
                }

                protected final void m1966a(Throwable th) {
                    ComposerPrivacyData.Builder builder = new ComposerPrivacyData.Builder(a2);
                    builder.f1995b = false;
                    this.f2020b.m1904a(builder.m1945a());
                    if (th instanceof ApiException) {
                        this.f2020b.f1955b.a("composer_profile_details_fetch_error", "Failed to fetch profile details for composer", th);
                    }
                }
            });
        }
    }

    public static GraphQLPrivacyOptionType m1968b(ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
        if (!(composerTargetDataPrivacyScopeFields == null || composerTargetDataPrivacyScopeFields.a() == null)) {
            if ("friends_of_friends".equals(composerTargetDataPrivacyScopeFields.a().d())) {
                return GraphQLPrivacyOptionType.GROUP;
            }
            if ("everyone".equals(composerTargetDataPrivacyScopeFields.a().d())) {
                return GraphQLPrivacyOptionType.EVERYONE;
            }
        }
        return GraphQLPrivacyOptionType.CUSTOM;
    }

    public static String m1967a(ComposerTimelinePrivacyDelegate composerTimelinePrivacyDelegate, ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields, String str) {
        if (!(composerTargetDataPrivacyScopeFields == null || composerTargetDataPrivacyScopeFields.a() == null)) {
            if ("friends_of_friends".equals(composerTargetDataPrivacyScopeFields.a().d())) {
                return composerTimelinePrivacyDelegate.f2025e.getString(2131234271, new Object[]{str});
            } else if ("everyone".equals(composerTargetDataPrivacyScopeFields.a().d())) {
                return composerTimelinePrivacyDelegate.f2025e.getString(2131234252);
            } else {
                if ("friends".equals(composerTargetDataPrivacyScopeFields.a().d())) {
                    return composerTimelinePrivacyDelegate.f2025e.getString(2131234270, new Object[]{str});
                }
            }
        }
        return composerTimelinePrivacyDelegate.f2025e.getString(2131234199);
    }

    public final String mo92b() {
        return "timeline:" + String.valueOf(this.f2021a);
    }
}
