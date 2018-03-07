package com.facebook.adpreview.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.adpreview.protocol.FetchGraphQLAdPreviewMethod;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.api.story.FetchSingleStoryParams;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.ipc.feed.ViewPermalinkParams;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: error_source */
public class AdPreviewActivity extends FbFragmentActivity {
    @Inject
    AnalyticsLogger f13870p;
    @Inject
    AbstractFbErrorReporter f13871q;
    @Inject
    FetchGraphQLAdPreviewMethod f13872r;
    @Inject
    GraphQLQueryExecutor f13873s;
    @Inject
    SecureContextHelper f13874t;
    @Inject
    TasksManager f13875u;
    @Inject
    UriIntentMapper f13876v;
    @Inject
    ViewPermalinkIntentFactory f13877w;
    @Inject
    FeedUnitDataController f13878x;
    public String f13879y;
    public boolean f13880z = false;

    /* compiled from: error_source */
    class C18791 implements Callable<ListenableFuture<GraphQLResult<FeedUnit>>> {
        final /* synthetic */ AdPreviewActivity f13868a;

        C18791(AdPreviewActivity adPreviewActivity) {
            this.f13868a = adPreviewActivity;
        }

        public Object call() {
            return this.f13868a.f13873s.a(GraphQLRequest.a(this.f13868a.f13872r.m14169a(new FetchSingleStoryParams("", DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA), this.f13868a.f13879y), FeedUnit.class));
        }
    }

    /* compiled from: error_source */
    class C18802 extends AbstractDisposableFutureCallback<GraphQLResult<FeedUnit>> {
        final /* synthetic */ AdPreviewActivity f13869a;

        C18802(AdPreviewActivity adPreviewActivity) {
            this.f13869a = adPreviewActivity;
        }

        protected final void m14153a(Object obj) {
            FeedUnit feedUnit = (FeedUnit) ((GraphQLResult) obj).e;
            ViewPermalinkParams viewPermalinkParams = new ViewPermalinkParams(feedUnit);
            viewPermalinkParams.c = true;
            this.f13869a.f13878x.a(feedUnit).s = true;
            Intent a = this.f13869a.f13877w.a(viewPermalinkParams);
            a.setFlags(67108864);
            this.f13869a.f13874t.a(a, this.f13869a);
            if (feedUnit instanceof GraphQLStory) {
                GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
                if (this.f13869a.f13880z && StoryAttachmentHelper.a(graphQLStory)) {
                    this.f13869a.f13874t.b(this.f13869a.f13876v.a(this.f13869a, Strings.nullToEmpty(StoryAttachmentHelper.o(graphQLStory).C())), this.f13869a);
                }
            }
            HoneyClientEventFast a2 = this.f13869a.f13870p.a("adpreview_graphql_success", false);
            if (a2.a()) {
                a2.a("preview_id", this.f13869a.f13879y);
                a2.b();
            }
            this.f13869a.finish();
        }

        protected final void m14154a(Throwable th) {
            SoftErrorBuilder a = SoftError.a("adpreview_graphql_error", "Error fetching ad preview.");
            a.e = 1;
            a = a;
            a.c = th;
            this.f13869a.f13871q.a(a.g());
            this.f13869a.finish();
        }
    }

    private static <T extends Context> void m14157a(Class<T> cls, T t) {
        m14158a((Object) t, (Context) t);
    }

    public static void m14158a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AdPreviewActivity) obj).m14156a(AnalyticsLoggerMethodAutoProvider.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), FetchGraphQLAdPreviewMethod.m14168c(fbInjector), GraphQLQueryExecutor.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), TasksManager.b(fbInjector), (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector), ViewPermalinkIntentFactory.a(fbInjector), FeedUnitDataController.a(fbInjector));
    }

    private void m14156a(AnalyticsLogger analyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter, FetchGraphQLAdPreviewMethod fetchGraphQLAdPreviewMethod, GraphQLQueryExecutor graphQLQueryExecutor, SecureContextHelper secureContextHelper, TasksManager tasksManager, UriIntentMapper uriIntentMapper, ViewPermalinkIntentFactory viewPermalinkIntentFactory, FeedUnitDataController feedUnitDataController) {
        this.f13870p = analyticsLogger;
        this.f13871q = abstractFbErrorReporter;
        this.f13872r = fetchGraphQLAdPreviewMethod;
        this.f13873s = graphQLQueryExecutor;
        this.f13874t = secureContextHelper;
        this.f13875u = tasksManager;
        this.f13876v = uriIntentMapper;
        this.f13877w = viewPermalinkIntentFactory;
        this.f13878x = feedUnitDataController;
    }

    protected final void m14161b(Bundle bundle) {
        super.b(bundle);
        Class cls = AdPreviewActivity.class;
        m14158a((Object) this, (Context) this);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            finish();
            return;
        }
        String string = extras.getString("extra_launch_uri");
        boolean z = extras.getBoolean("is_hype_ad_unit");
        if (m14159a(z, string)) {
            Uri parse = Uri.parse(string);
            if (z) {
                this.f13879y = parse.getQueryParameter("preview_id");
                this.f13880z = parse.getQueryParameter("open_attachment") != null;
            } else {
                this.f13879y = parse.getQuery();
            }
            if (this.f13879y == null) {
                finish();
                return;
            } else {
                this.f13875u.a(this.f13879y, new C18791(this), new C18802(this));
                return;
            }
        }
        finish();
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1730648073);
        super.onPause();
        this.f13875u.c();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -336446405, a);
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -23440476);
        super.onResume();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1694555688, a);
    }

    private static boolean m14159a(boolean z, String str) {
        if (Strings.isNullOrEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse == null || Strings.isNullOrEmpty(parse.getPath())) {
            return false;
        }
        String scheme = parse.getScheme();
        if (!Strings.isNullOrEmpty(scheme)) {
            scheme = scheme + "://";
            if (str.length() > scheme.length()) {
                str = str.substring(scheme.length());
            }
        }
        return z ? str.startsWith("ads/hype_ad?") : str.startsWith("ads/mobile_preview?");
    }
}
