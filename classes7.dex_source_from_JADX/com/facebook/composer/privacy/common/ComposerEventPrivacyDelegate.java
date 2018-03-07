package com.facebook.composer.privacy.common;

import android.content.res.Resources;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.privacy.common.ComposerFixedPrivacyData.Builder;
import com.facebook.composer.privacy.common.ComposerPrivacyDelegate.PrivacyUpdatedHandler;
import com.facebook.composer.privacy.common.graphql.FetchEventDetailsGraphQL.EventDetailsQueryString;
import com.facebook.composer.privacy.common.graphql.FetchEventDetailsGraphQLModels.EventDetailsModel;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.PrivacyType;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiException;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ui.futures.TasksManager;
import javax.inject.Inject;

/* compiled from: tapped_videohub_card_header */
public final class ComposerEventPrivacyDelegate extends ComposerPrivacyDelegate {
    private final long f1967a;
    private final String f1968b;
    private final GraphQLQueryExecutor f1969c;
    public final Resources f1970d;
    public final ComposerTargetDataPrivacyScopeFields f1971e;

    /* compiled from: tapped_videohub_card_header */
    /* synthetic */ class C02042 {
        static final /* synthetic */ int[] f1966a = new int[PrivacyType.values().length];

        static {
            try {
                f1966a[PrivacyType.EVERYONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1966a[PrivacyType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1966a[PrivacyType.FRIENDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1966a[PrivacyType.EVENT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    @Inject
    public ComposerEventPrivacyDelegate(@Assisted PrivacyUpdatedHandler privacyUpdatedHandler, AbstractFbErrorReporter abstractFbErrorReporter, TasksManager tasksManager, @Assisted Long l, @Assisted String str, @Assisted ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields, GraphQLQueryExecutor graphQLQueryExecutor, Resources resources) {
        super(privacyUpdatedHandler, abstractFbErrorReporter, tasksManager);
        this.f1967a = l.longValue();
        this.f1968b = str;
        this.f1971e = composerTargetDataPrivacyScopeFields;
        this.f1969c = graphQLQueryExecutor;
        this.f1970d = resources;
    }

    public final void mo91a() {
        super.mo91a();
        boolean z = true;
        Builder builder = new Builder();
        builder.f1972a = GraphQLPrivacyOptionType.EVENT;
        builder = builder;
        builder.f1973b = this.f1970d.getString(2131234276);
        builder = builder;
        builder.f1974c = this.f1970d.getString(2131234277);
        ComposerFixedPrivacyData a = builder.m1926a();
        if (this.f1971e != null) {
            builder = new Builder();
            builder.f1972a = m1920a(this, this.f1971e);
            builder = builder;
            builder.f1973b = m1921b(this, this.f1971e);
            builder = builder;
            builder.f1974c = m1922c(this, this.f1971e);
            a = builder.m1926a();
        }
        ComposerPrivacyData.Builder builder2 = new ComposerPrivacyData.Builder();
        builder2.f1994a = true;
        builder2 = builder2;
        if (this.f1971e != null) {
            z = false;
        }
        builder2.f1995b = z;
        final ComposerPrivacyData a2 = builder2.m1943a(a).m1945a();
        m1904a(a2);
        if (a2.f2003d) {
            GraphQlQueryString eventDetailsQueryString = new EventDetailsQueryString();
            eventDetailsQueryString.a("event_id", String.valueOf(this.f1967a));
            this.f1956c.a("fetch_event_data", this.f1969c.a(GraphQLRequest.a(eventDetailsQueryString)), new AbstractDisposableFutureCallback<GraphQLResult<EventDetailsModel>>(this) {
                final /* synthetic */ ComposerEventPrivacyDelegate f1965b;

                protected final void m1918a(Object obj) {
                    EventDetailsModel eventDetailsModel = (EventDetailsModel) ((GraphQLResult) obj).e;
                    if (eventDetailsModel != null && eventDetailsModel.m2002a() != null && eventDetailsModel.m2002a().b() != null) {
                        Builder builder = new Builder(a2.f2000a);
                        builder.f1972a = ComposerEventPrivacyDelegate.m1920a(this.f1965b, eventDetailsModel.m2002a());
                        builder = builder;
                        builder.f1973b = ComposerEventPrivacyDelegate.m1921b(this.f1965b, eventDetailsModel.m2002a());
                        builder = builder;
                        builder.f1974c = ComposerEventPrivacyDelegate.m1922c(this.f1965b, eventDetailsModel.m2002a());
                        ComposerFixedPrivacyData a = builder.m1926a();
                        ComposerPrivacyData.Builder builder2 = new ComposerPrivacyData.Builder(a2);
                        builder2.f1995b = false;
                        this.f1965b.m1904a(builder2.m1943a(a).m1945a());
                    }
                }

                protected final void m1919a(Throwable th) {
                    ComposerPrivacyData.Builder builder = new ComposerPrivacyData.Builder(a2);
                    builder.f1995b = false;
                    this.f1965b.m1904a(builder.m1945a());
                    if (th instanceof ApiException) {
                        this.f1965b.f1955b.a("composer_event_details_fetch_error", "Failed to fetch event details for composer", th);
                    }
                }
            });
        }
    }

    public static GraphQLPrivacyOptionType m1920a(ComposerEventPrivacyDelegate composerEventPrivacyDelegate, ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
        switch (C02042.f1966a[PrivacyType.getByValue(composerTargetDataPrivacyScopeFields.a().d()).ordinal()]) {
            case 1:
                return GraphQLPrivacyOptionType.EVERYONE;
            case 2:
                return GraphQLPrivacyOptionType.GROUP;
            case 3:
            case 4:
                return GraphQLPrivacyOptionType.EVENT;
            default:
                composerEventPrivacyDelegate.f1955b.a("composer_event_undefined_privacy", "Could not determine event privacy, id=" + composerEventPrivacyDelegate.f1967a + ", privacyScopeType=" + composerTargetDataPrivacyScopeFields.a().d());
                return GraphQLPrivacyOptionType.EVENT;
        }
    }

    public static String m1921b(ComposerEventPrivacyDelegate composerEventPrivacyDelegate, ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
        switch (C02042.f1966a[PrivacyType.getByValue(composerTargetDataPrivacyScopeFields.a().d()).ordinal()]) {
            case 1:
                return composerEventPrivacyDelegate.f1970d.getString(2131234252);
            case 2:
            case 3:
                return composerEventPrivacyDelegate.f1970d.getString(2131234266);
            case 4:
                return composerEventPrivacyDelegate.f1970d.getString(2131234273);
            default:
                return null;
        }
    }

    public static String m1922c(ComposerEventPrivacyDelegate composerEventPrivacyDelegate, ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
        switch (C02042.f1966a[PrivacyType.getByValue(composerTargetDataPrivacyScopeFields.a().d()).ordinal()]) {
            case 1:
                return composerEventPrivacyDelegate.f1970d.getString(2131234260);
            case 2:
            case 3:
                return composerEventPrivacyDelegate.f1970d.getString(2131234259);
            case 4:
                return composerEventPrivacyDelegate.f1970d.getString(2131234258);
            default:
                return null;
        }
    }

    public final String mo92b() {
        return "event:" + String.valueOf(this.f1967a);
    }
}
