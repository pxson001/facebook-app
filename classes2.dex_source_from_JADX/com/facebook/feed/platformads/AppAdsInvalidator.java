package com.facebook.feed.platformads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.thirdparty.MobileStoreObjectInvalidationBehavior;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: logout */
public class AppAdsInvalidator {
    private final NewsFeedAnalyticsEventBuilder f15963a;
    private final AnalyticsLogger f15964b;
    private final Context f15965c;

    public static AppAdsInvalidator m22749b(InjectorLike injectorLike) {
        return new AppAdsInvalidator(NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public AppAdsInvalidator(NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, Context context) {
        this.f15963a = newsFeedAnalyticsEventBuilder;
        this.f15964b = analyticsLogger;
        this.f15965c = context;
    }

    public final boolean m22750a(@Nullable String str, JsonNode jsonNode, GraphQLObjectType graphQLObjectType) {
        if (TextUtils.isEmpty(str) || !NativeThirdPartyUriHelper.m29571a(str)) {
            return false;
        }
        Uri b = NativeThirdPartyUriHelper.m29573b(str);
        if (!m22746a(b)) {
            this.f15964b.mo533c(this.f15963a.m14127a(jsonNode, graphQLObjectType, NativeThirdPartyUriHelper.m29576c(b) == MobileStoreObjectInvalidationBehavior.INSTALLED ? "already_present" : "applink_no_fallback"));
            return true;
        } else if (NativeThirdPartyUriHelper.m29576c(b) != MobileStoreObjectInvalidationBehavior.NONE) {
            return false;
        } else {
            Intent d = NativeThirdPartyUriHelper.m29578d(this.f15965c, b);
            String str2 = null;
            if (d == null) {
                str2 = "reengagement_fallback";
            } else if (!("android.intent.action.DIAL".equals(d.getAction()) || "android.intent.action.CALL".equals(d.getAction()))) {
                str2 = "reengagement";
            }
            if (str2 == null) {
                return false;
            }
            HoneyAnalyticsEvent b2 = new HoneyClientEvent("ad_treatment").m5085a("tracking", jsonNode).m5090b("unit_type", graphQLObjectType.m22299e()).m5090b("reason", str2);
            b2.f3099c = "native_newsfeed";
            this.f15964b.mo533c(b2);
            return false;
        }
    }

    private boolean m22746a(Uri uri) {
        if (uri == null || !NativeThirdPartyUriHelper.m29569a(uri)) {
            return true;
        }
        MobileStoreObjectInvalidationBehavior c = NativeThirdPartyUriHelper.m29576c(uri);
        if (c == MobileStoreObjectInvalidationBehavior.NONE) {
            return true;
        }
        Collection b = NativeThirdPartyUriHelper.m29574b(uri);
        if (b == null || b.isEmpty()) {
            return true;
        }
        boolean a = m22748a(b);
        if (c == MobileStoreObjectInvalidationBehavior.INSTALLED) {
            if (a) {
                return false;
            }
            return true;
        } else if (c == MobileStoreObjectInvalidationBehavior.NOT_INSTALLED) {
            return a;
        } else {
            return true;
        }
    }

    private boolean m22748a(Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            return false;
        }
        for (String a : collection) {
            if (m22747a(a)) {
                return true;
            }
        }
        return false;
    }

    private boolean m22747a(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return false;
        }
        try {
            this.f15965c.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
