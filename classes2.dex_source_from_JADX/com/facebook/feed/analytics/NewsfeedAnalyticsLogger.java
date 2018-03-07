package com.facebook.feed.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams.Builder;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.facebook.feed.photos.FeedUnitImagesStateMapper;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.StringWriter;
import java.io.Writer;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ja */
public class NewsfeedAnalyticsLogger {
    private final AnalyticsLogger f18715a;
    private final FeedUnitImagesStateMapper f18716b;
    private final FbNetworkManager f18717c;
    private final Clock f18718d;
    private final ParamsCollectionPool f18719e = ParamsCollectionPool.m5397a();

    public static NewsfeedAnalyticsLogger m26299b(InjectorLike injectorLike) {
        return new NewsfeedAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FeedUnitImagesStateMapper.m14210a(injectorLike), FbNetworkManager.m3811a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    public static NewsfeedAnalyticsLogger m26297a(InjectorLike injectorLike) {
        return m26299b(injectorLike);
    }

    @Inject
    public NewsfeedAnalyticsLogger(AnalyticsLogger analyticsLogger, FeedUnitImagesStateMapper feedUnitImagesStateMapper, FbNetworkManager fbNetworkManager, Clock clock) {
        this.f18715a = analyticsLogger;
        this.f18716b = feedUnitImagesStateMapper;
        this.f18717c = fbNetworkManager;
        this.f18718d = clock;
    }

    public final void m26302a(String str, String str2, String str3, String str4) {
        HoneyClientEventFast a = this.f18715a.mo535a("share_clicked", true);
        if (a.m17388a()) {
            a.m17379a(str).m17385a("story_id", str2).m17385a("user_id", str3).m17385a("shareable_id", str4);
            a.m17390b();
        }
    }

    public final void m26304a(String str, String str2, String str3, String str4, String str5, JsonNode jsonNode) {
        HoneyClientEventFast a = this.f18715a.mo535a("feed_share_action", true);
        if (a.m17388a()) {
            a.m17379a(str).m17385a("share_type", "share_abandoned").m17385a("story_id", str2).m17385a("user_id", str3).m17385a("shareable_id", str4).m17383a("tracking", jsonNode).m17392d(str5);
            a.m17390b();
        }
    }

    public final void m26303a(String str, String str2, String str3, String str4, String str5) {
        HoneyClientEventFast a = this.f18715a.mo535a("feed_share_action", true);
        if (a.m17388a()) {
            a.m17379a(str).m17385a("share_type", "share_button_tapped").m17385a("story_id", str2).m17385a("user_id", str3).m17385a("shareable_id", str4).m17392d(str5);
            a.m17390b();
        }
    }

    public final void m26306b(String str, String str2, String str3, String str4, String str5) {
        HoneyClientEventFast a = this.f18715a.mo535a("feed_share_action", true);
        if (a.m17388a()) {
            a.m17379a(str).m17385a("share_type", "quick_share_public").m17385a("story_id", str2).m17385a("user_id", str3).m17385a("shareable_id", str4).m17392d(str5);
            a.m17390b();
        }
    }

    public final void m26308c(String str, String str2, String str3, String str4, String str5) {
        HoneyClientEventFast a = this.f18715a.mo535a("feed_share_action", true);
        if (a.m17388a()) {
            a.m17379a(str).m17385a("share_type", "quick_share_friends").m17385a("story_id", str2).m17385a("user_id", str3).m17385a("shareable_id", str4).m17392d(str5);
            a.m17390b();
        }
    }

    public final void m26309d(String str, String str2, String str3, String str4, String str5) {
        HoneyClientEventFast a = this.f18715a.mo535a("feed_share_action", true);
        if (a.m17388a()) {
            a.m17379a(str).m17385a("share_type", "quick_share_publish_start").m17385a("story_id", str2).m17385a("user_id", str3).m17385a("shareable_id", str4).m17392d(str5);
            a.m17390b();
        }
    }

    public final void m26307b(String str, String str2, String str3, String str4, String str5, JsonNode jsonNode) {
        HoneyClientEventFast a = this.f18715a.mo535a("feed_share_action", true);
        if (a.m17388a()) {
            a.m17379a(str).m17385a("share_type", "quick_share_publish_success").m17385a("story_id", str2).m17385a("user_id", str3).m17385a("shareable_id", str4).m17383a("tracking", jsonNode).m17392d(str5);
            a.m17390b();
        }
    }

    public final void m26305a(String str, String str2, String str3, String str4, String str5, String str6) {
        HoneyClientEventFast a = this.f18715a.mo535a("feed_share_action", true);
        if (a.m17388a()) {
            a.m17379a(str).m17385a("share_type", "quick_share_publish_failure").m17385a("story_id", str2).m17385a("user_id", str3).m17385a("shareable_id", str4).m17385a("error_msg", str6).m17392d(str5);
            a.m17390b();
        }
    }

    public final void m26310e(String str, String str2, String str3, String str4, String str5) {
        HoneyClientEventFast a = this.f18715a.mo535a("feed_share_action", true);
        if (a.m17388a()) {
            a.m17379a(str).m17385a("share_type", "edit_and_share").m17385a("composer_session_id", str5).m17385a("story_id", str2).m17385a("user_id", str3).m17385a("shareable_id", str4).m17392d(str5);
            a.m17390b();
        }
    }

    public final void m26311f(String str, String str2, String str3, String str4, String str5) {
        HoneyClientEventFast a = this.f18715a.mo535a("feed_share_action", true);
        if (a.m17388a()) {
            a.m17379a(str).m17385a("share_type", "send_in_message").m17385a("story_id", str2).m17385a("user_id", str3).m17385a("shareable_id", str4).m17392d(str5);
            a.m17390b();
        }
    }

    public final void m26312g(String str, String str2, String str3, String str4, String str5) {
        HoneyClientEventFast a = this.f18715a.mo535a("feed_share_action", true);
        if (a.m17388a()) {
            a.m17379a(str).m17385a("share_type", "copy_link").m17385a("story_id", str2).m17385a("user_id", str3).m17385a("shareable_id", str4).m17392d(str5);
            a.m17390b();
        }
    }

    public final void m26313h(String str, String str2, String str3, String str4, String str5) {
        HoneyClientEventFast a = this.f18715a.mo535a("feed_share_action", true);
        if (a.m17388a()) {
            a.m17379a(str).m17385a("share_type", "share_external").m17385a("story_id", str2).m17385a("user_id", str3).m17385a("shareable_id", str4).m17392d(str5);
            a.m17390b();
        }
    }

    public final void m26300a(HoneyClientEvent honeyClientEvent, FeedUnit feedUnit) {
        long j = 0;
        int i = 0;
        if (!StringUtil.m3589a(feedUnit.mo2507g())) {
            i = this.f18716b.m14214a(feedUnit.mo2507g());
        }
        if (feedUnit.T_() > 0) {
            j = this.f18718d.mo211a() - feedUnit.T_();
        }
        int i2 = -1;
        String a = PropertyHelper.m21264a(feedUnit);
        if (a != null) {
            i2 = PropertyHelper.m21303f(feedUnit);
        }
        m26298a(honeyClientEvent, i2, a, j, i);
    }

    public static void m26298a(HoneyClientEvent honeyClientEvent, int i, @Nullable String str, long j, int i2) {
        honeyClientEvent.m5083a("image_loading_state", i2);
        if (j > 0) {
            honeyClientEvent.m5084a("time_since_fetched", j);
        }
        if (str != null) {
            honeyClientEvent.m5083a("client_viewstate_position", i);
            honeyClientEvent.m5090b("client_bump_state", str);
        }
    }

    public final void m26301a(FeedUnit feedUnit, Builder builder) {
        ParamsCollection b = this.f18719e.m5398b();
        try {
            b.m5438a(ParamsJsonEncoder.m5454a());
            if (!StringUtil.m3589a(feedUnit.mo2507g())) {
                b.m5420a("image_loading_state", Integer.valueOf(this.f18716b.m14214a(feedUnit.mo2507g())));
            }
            if (feedUnit.T_() > 0) {
                b.m5420a("time_since_fetched", Long.valueOf(this.f18718d.mo211a() - feedUnit.T_()));
            }
            b.m5421a("radio_type", this.f18717c.m3837m());
            String a = PropertyHelper.m21264a(feedUnit);
            if (a != null) {
                b.m5420a("client_viewstate_position", Integer.valueOf(PropertyHelper.m21303f(feedUnit)));
                b.m5421a("client_bump_state", a);
            }
            Writer stringWriter = new StringWriter();
            b.m5439a(stringWriter);
            builder.m30321c(stringWriter.toString());
            b.m5434a();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            b.m5434a();
        }
    }
}
