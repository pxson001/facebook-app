package com.facebook.saved2.ui.itemadapters;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLVideo.Builder;
import com.facebook.inject.Lazy;
import com.facebook.ipc.feed.PermalinkStoryIdParams;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

/* compiled from: includeViewerAsCohostChoice */
public class Saved2ItemClickHandler {
    private final SaveAnalyticsLogger f9641a;
    public final Lazy<FullscreenVideoPlayerLauncher> f9642b;
    public final Lazy<ViewPermalinkIntentFactory> f9643c;
    public final Lazy<SecureContextHelper> f9644d;
    public final Lazy<FbUriIntentHandler> f9645e;

    @Inject
    public Saved2ItemClickHandler(SaveAnalyticsLogger saveAnalyticsLogger, Lazy<FullscreenVideoPlayerLauncher> lazy, Lazy<ViewPermalinkIntentFactory> lazy2, Lazy<SecureContextHelper> lazy3, Lazy<FbUriIntentHandler> lazy4) {
        this.f9641a = saveAnalyticsLogger;
        this.f9642b = lazy;
        this.f9643c = lazy2;
        this.f9644d = lazy3;
        this.f9645e = lazy4;
    }

    public final void m9881a(Context context, String str, BaseQueryDAO baseQueryDAO) {
        m9880a(baseQueryDAO.w(), str);
        if (baseQueryDAO.t() && baseQueryDAO.v()) {
            Builder builder = new Builder();
            builder.H = baseQueryDAO.w();
            builder = builder;
            builder.ak = baseQueryDAO.G();
            builder = builder;
            builder.bn = baseQueryDAO.H();
            builder = builder;
            builder.bi = baseQueryDAO.I();
            builder = builder;
            builder.bl = baseQueryDAO.K();
            builder = builder;
            builder.bk = baseQueryDAO.L();
            builder = builder;
            builder.bj = baseQueryDAO.J();
            builder = builder;
            builder.Y = baseQueryDAO.M();
            builder = builder;
            builder.Z = baseQueryDAO.N();
            builder = builder;
            builder.aa = baseQueryDAO.O();
            builder = builder;
            builder.aI = baseQueryDAO.u();
            ((FullscreenVideoPlayerLauncher) this.f9642b.get()).a(builder.a(), context, PlayerOrigin.SAVED_DASHBOARD);
        } else if (baseQueryDAO.p()) {
            PermalinkStoryIdParams.Builder builder2 = new PermalinkStoryIdParams.Builder();
            builder2.a = baseQueryDAO.q();
            ((SecureContextHelper) this.f9644d.get()).a(((ViewPermalinkIntentFactory) this.f9643c.get()).a(builder2.a()), context);
        } else if (!baseQueryDAO.n()) {
        } else {
            if (baseQueryDAO.C() == null) {
                ((FbUriIntentHandler) this.f9645e.get()).a(context, baseQueryDAO.o());
            } else if (baseQueryDAO.D() != null) {
                ((FbUriIntentHandler) this.f9645e.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.fe, baseQueryDAO.C(), Uri.encode(baseQueryDAO.D())));
            } else {
                ((FbUriIntentHandler) this.f9645e.get()).a(context, StringFormatUtil.formatStrLocaleSafe(FBLinks.fd, baseQueryDAO.C()));
            }
        }
    }

    private void m9880a(String str, String str2) {
        String str3 = str2;
        this.f9641a.b.b("saved_dashboard", null, null, ImmutableMap.of("action_name", "saved_dashboard_item_clicked", "object_id", Strings.nullToEmpty(str), "section_type", str3, "event_id", SafeUUIDGenerator.a().toString()));
    }
}
