package com.facebook.feedplugins.hpp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.graphql.enums.GraphQLAYMTNativeAction;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.fasterxml.jackson.databind.JsonNode;

/* compiled from: current_battery_level */
class C0990x91f79a42 implements OnClickListener {
    final /* synthetic */ MobilePageAdminPanelPagePartDefinition f7827a;
    private long f7828b;
    private long f7829c;
    private String f7830d;
    private String f7831e;
    private boolean f7832f;
    private String f7833g;
    private GraphQLAYMTNativeAction f7834h;
    private String f7835i;
    private JsonNode f7836j;

    public C0990x91f79a42(MobilePageAdminPanelPagePartDefinition mobilePageAdminPanelPagePartDefinition, long j, long j2, String str, String str2, boolean z, String str3, GraphQLAYMTNativeAction graphQLAYMTNativeAction, String str4, JsonNode jsonNode) {
        this.f7827a = mobilePageAdminPanelPagePartDefinition;
        this.f7828b = j;
        this.f7829c = j2;
        this.f7830d = str;
        this.f7831e = str2;
        this.f7832f = z;
        this.f7833g = str3;
        this.f7834h = graphQLAYMTNativeAction;
        this.f7835i = str4;
        this.f7836j = jsonNode;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1403676516);
        if (this.f7834h != null && this.f7834h.name() != null && !this.f7834h.name().toString().isEmpty()) {
            switch (MobilePageAdminPanelPagePartDefinition$4.f7822b[this.f7834h.ordinal()]) {
                case 1:
                    m8975a(this.f7827a.j.d(), this.f7829c, this.f7830d, this.f7831e, (Activity) ContextUtils.a(view.getContext(), Activity.class));
                    break;
                case 2:
                    Intent a2 = this.f7827a.l.a((Context) ContextUtils.a(view.getContext(), Activity.class), FBLinks.ay);
                    if (a2 != null) {
                        this.f7827a.k.a(a2, (Context) ContextUtils.a(view.getContext(), Activity.class));
                        break;
                    }
                    break;
                case 3:
                case 4:
                    break;
                default:
                    if (this.f7835i == null) {
                        this.f7827a.f.a(view.getContext(), this.f7831e);
                        break;
                    } else {
                        this.f7827a.f.a(view.getContext(), this.f7835i);
                        break;
                    }
            }
        }
        this.f7827a.f.a(view.getContext(), this.f7835i);
        AnalyticsLogger analyticsLogger = this.f7827a.d;
        NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f7827a.e;
        analyticsLogger.c(NewsFeedAnalyticsEventBuilder.a(this.f7836j, this.f7828b, this.f7829c, this.f7832f, this.f7833g));
        LogUtils.a(381094694, a);
    }

    private void m8975a(ViewerContext viewerContext, long j, String str, String str2, Activity activity) {
        this.f7827a.h.a(null, this.f7827a.i.a(j, str, str2, viewerContext).a(), 1756, activity);
    }
}
