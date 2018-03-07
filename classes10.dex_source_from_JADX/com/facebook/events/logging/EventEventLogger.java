package com.facebook.events.logging;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.impression.ImpressionManager;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.events.common.ActionMechanism;
import com.facebook.growth.prefs.GrowthPrefKeys;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: changeGroupSubscriptionStatus */
public class EventEventLogger {
    private boolean f17779a;
    public boolean f17780b;
    public boolean f17781c;
    private String f17782d;
    private String f17783e;
    private PrefKey f17784f;
    public Context f17785g;
    private final FbObjectMapper f17786h;
    public AnalyticsLogger f17787i;
    public ImpressionManager f17788j;
    private final NavigationLogger f17789k;
    private Lazy<FbSharedPreferences> f17790l;

    public static EventEventLogger m18119b(InjectorLike injectorLike) {
        return new EventEventLogger((Context) injectorLike.getInstance(Context.class), FbObjectMapperMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ImpressionManager.a(injectorLike), NavigationLogger.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3078), IdBasedProvider.a(injectorLike, 4442));
    }

    public static EventEventLogger m18116a(InjectorLike injectorLike) {
        return m18119b(injectorLike);
    }

    @Inject
    public EventEventLogger(Context context, FbObjectMapper fbObjectMapper, AnalyticsLogger analyticsLogger, ImpressionManager impressionManager, NavigationLogger navigationLogger, Lazy<FbSharedPreferences> lazy, Provider<String> provider) {
        this.f17785g = context;
        this.f17786h = fbObjectMapper;
        this.f17787i = analyticsLogger;
        this.f17788j = impressionManager;
        this.f17789k = navigationLogger;
        this.f17790l = lazy;
        this.f17784f = GrowthPrefKeys.a((String) provider.get());
    }

    public static ImmutableMap<String, Object> m18117a(Object obj) {
        if (obj == null) {
            return null;
        }
        return ImmutableBiMap.b("event_id", obj);
    }

    public final void m18133a(String str, String str2, String str3, int i, String str4) {
        if (!this.f17779a) {
            HoneyClientEventFast a = this.f17787i.a("view", false);
            if (a.a()) {
                a.a("event_permalink").c(str).b("Event").d(this.f17788j.b(this.f17785g)).a("action_ref", i).a("ref_mechanism", str3).a("ref_module", str2).a("has_installed_launcher", false);
                JsonNode g = m18120g(str4);
                if (g != null) {
                    a.a("tracking", g);
                }
                a.b();
            }
            this.f17779a = true;
        }
    }

    private JsonNode m18120g(String str) {
        JsonNode jsonNode = null;
        if (!Strings.isNullOrEmpty(str)) {
            try {
                jsonNode = this.f17786h.a(str);
            } catch (IOException e) {
            }
        }
        return jsonNode;
    }

    public final void m18128a(String str, int i, String str2, int i2) {
        if (!Objects.equal(this.f17782d, str)) {
            HoneyClientEventFast a = this.f17787i.a("view", false);
            if (a.a()) {
                a.a("event_dashboard").b("EventDashboardFilter").c(str).d(this.f17788j.b(this.f17785g)).a("ref_module", str2).a("action_ref", i2).a("has_installed_launcher", false).a("events_count", i).b();
            }
            this.f17782d = str;
        }
    }

    public final void m18141c(String str) {
        if (!Objects.equal(this.f17783e, str)) {
            HoneyClientEventFast a = this.f17787i.a("click", false);
            if (a.a()) {
                a.a("event_dashboard").c(str).b("EventDashboardFilter").d(this.f17788j.b(this.f17785g)).b();
            }
            this.f17783e = str;
        }
    }

    public final void m18124a(int i) {
        HoneyClientEventFast a = this.f17787i.a("click", false);
        if (a.a()) {
            a.a("event_dashboard").b("EventDashboardViewAll").d(this.f17788j.b(this.f17785g)).a("action_ref", i).a("has_installed_launcher", false).b();
        }
    }

    public final void m18132a(@Nullable String str, String str2, int i, int i2, String str3) {
        Builder b = new Builder().b("event_id", str2).b("ticket_info_count", Integer.valueOf(i)).b("action_ref", Integer.valueOf(i2)).b("has_installed_launcher", Boolean.FALSE);
        if (!TextUtils.isEmpty(str3)) {
            b.b("tracking", Arrays.asList(new String[]{str3}));
        }
        this.f17789k.a("event_permalink", "EventTicketInfo", str, b.b());
    }

    public final void m18123a() {
        m18121g("event_composer_open", "event_composer");
    }

    public final HoneyClientEventFast m18122a(long j, int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        HoneyClientEventFast a = this.f17787i.a("event_composer_create_success", false);
        if (a.a()) {
            a.a("event_composer").d(this.f17788j.b(this.f17785g)).a("has_installed_launcher", false).a("time_on_screen_millis", j).a("name_length", i).a("name_max_length_ever", i2).a("description_length", i3).a("time_has_been_edited", z).a("privacy_options_viewed", z2).a("privacy_can_guest_invite_friends_toggled", z3).a("has_clicked_on_location_picker", z4).a("has_location", z5).a("has_clicked_on_cohost_selector", z6).a("has_clicked_on_cover_photo_selector", z7).a("has_clicked_on_cover_photo_upload", z8).a("has_clicked_on_cover_photo_fb_album", z9).a("has_clicked_on_cover_photo_themes", z10);
        }
        return a;
    }

    public final void m18138b() {
        m18121g("event_composer_create_success", "event_composer");
    }

    public final void m18140c() {
        m18121g("event_composer_create_failure", "event_composer");
    }

    public final void m18136a(boolean z, long j, int i, int i2, int i3, boolean z2, boolean z3, boolean z4) {
        HoneyClientEventFast a = this.f17787i.a(z ? "event_composer_cancel" : "event_composer_exit", false);
        if (a.a()) {
            a.a("event_composer").d(this.f17788j.b(this.f17785g)).a("has_installed_launcher", false).a("time_on_screen_millis", j).a("name_length", i).a("name_max_length_ever", i2).a("description_length", i3).a("time_has_been_edited", z2).a("privacy_options_viewed", z3).a("has_location", z4).b();
        }
    }

    public final void m18137a(boolean z, long j, int i, int i2, int i3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, String str) {
        HoneyClientEventFast a = this.f17787i.a(z ? "event_composer_cancel" : "event_composer_exit", true);
        if (a.a()) {
            a.a("event_composer").d(this.f17788j.b(this.f17785g)).a("has_installed_launcher", false).a("time_on_screen_millis", j).a("name_length", i).a("name_max_length_ever", i2).a("description_length", i3).a("time_has_been_edited", z2).a("privacy_options_viewed", z3).a("privacy_can_guest_invite_friends_toggled", z4).a("has_clicked_on_location_picker", z5).a("has_location", z6).a("has_clicked_on_cohost_selector", z7).a("has_clicked_on_cover_photo_selector", z8).a("has_clicked_on_cover_photo_upload", z9).a("has_clicked_on_cover_photo_fb_album", z10).a("has_clicked_on_cover_photo_themes", z11).a("action_mechanism", str).b();
        }
    }

    private void m18121g(String str, String str2) {
        HoneyClientEventFast a = this.f17787i.a(str, true);
        if (a.a()) {
            a.a(str2).d(this.f17788j.b(this.f17785g)).a("has_installed_launcher", false).b();
        }
    }

    public final void m18131a(@Nonnull String str, String str2, int i, int i2) {
        m18118a("view", str, str2, i, i2);
    }

    public final void m18139b(@Nonnull String str, String str2, int i, int i2) {
        m18118a("click", str, str2, i, i2);
    }

    private void m18118a(String str, @Nonnull String str2, String str3, int i, int i2) {
        HoneyClientEventFast a = this.f17787i.a(str, true);
        if (a.a()) {
            a.a(str3).c(str2).b("Event").d(this.f17788j.b(this.f17785g)).a("position", i).a("action_source", i2).a("has_installed_launcher", false).b();
        }
    }

    public final void m18127a(String str, int i, int i2, boolean z) {
        HoneyClientEventFast a = this.f17787i.a("view", false);
        if (a.a()) {
            a.a(str).d(this.f17788j.b(this.f17785g)).a("is_successful", z).a("action_source", i).a("action_ref", i2).a("has_installed_launcher", false).b();
        }
    }

    public final void m18126a(String str, int i, int i2) {
        HoneyClientEventFast a = this.f17787i.a("event_suggestion_fetched_count", false);
        if (a.a()) {
            a.a(str).d(this.f17788j.b(this.f17785g)).a("count", i).a("action_source", i2).a("has_installed_launcher", false).b();
        }
    }

    public final void m18130a(String str, ImmutableList<String> immutableList, int i, ImmutableList<Integer> immutableList2, ImmutableList<Integer> immutableList3, ImmutableList<Integer> immutableList4, ImmutableList<Integer> immutableList5, ImmutableList<Integer> immutableList6, ImmutableList<Integer> immutableList7) {
        HoneyClientEventFast a = this.f17787i.a("events_guest_list_session", false);
        if (a.a()) {
            a.a("event_guest_list").d(this.f17788j.b(this.f17785g)).b("Event").c(str).a("guest_statuses", immutableList).a("count_tab_switches", i).a("count_guest_statuses_tab_viewed", immutableList2).a("count_guest_statuses_loaded", immutableList3).a("count_guest_statuses_viewed", immutableList4).a("count_guest_statuses_profile_viewed", immutableList5).a("count_messaged", immutableList6).a("count_friends_requested", immutableList7).a("has_installed_launcher", false).b();
        }
    }

    public final void m18135a(String str, Map<String, String> map) {
        HoneyClientEventFast a = this.f17787i.a("event_invite_dialog_session", false);
        if (a.a()) {
            a.a("event_invite").d(this.f17788j.b(this.f17785g)).b("Event").c(str).a(map).a("contacts_upload_on", ((FbSharedPreferences) this.f17790l.get()).a(this.f17784f, false)).b();
        }
    }

    public final void m18143c(String str, String str2, int i, int i2) {
        HoneyClientEventFast a = this.f17787i.a(str, false);
        if (a.a()) {
            a.a("event_permalink").d(this.f17788j.b(this.f17785g)).b("Event").c(str2).a("action_source", i).a("action_ref", i2).a("has_installed_launcher", false).b();
        }
    }

    public final void m18125a(String str, int i) {
        HoneyClientEventFast a = this.f17787i.a("message_event_guests_canceled", false);
        if (a.a()) {
            a.a("event_message_guests").d(this.f17788j.b(this.f17785g)).b("Event").c(str).a("total_selected_message_guests", Integer.toString(i)).b();
        }
    }

    public final void m18145d(String str) {
        HoneyClientEventFast a = this.f17787i.a("message_event_guests_button_clicked", false);
        if (a.a()) {
            a.a("event_message_guests").d(this.f17788j.b(this.f17785g)).b("Event").c(str).b();
        }
    }

    public final void m18129a(String str, ActionMechanism actionMechanism, String str2, String str3, String str4) {
        HoneyClientEventFast a = this.f17787i.a("event_message_inviter_click", false);
        if (a.a()) {
            a.a(str).a("action_mechanism", actionMechanism.toString()).a("ref_module", str2).d(this.f17788j.b(this.f17785g)).b("Event").c(str3);
            if (str4 != null) {
                a.a("messenger_version", str4);
            }
            a.b();
        }
    }

    public final void m18142c(String str, int i, int i2) {
        HoneyClientEventFast a = this.f17787i.a("event_permalink_first_scroll", false);
        if (a.a()) {
            a.a("event_permalink");
            a.d(this.f17788j.b(this.f17785g));
            a.b("Event");
            a.c(str);
            a.a("action_source", i);
            a.a("action_ref", i2);
            a.b();
        }
    }

    public final void m18134a(String str, String str2, String str3, String str4, String str5) {
        HoneyClientEventFast a = this.f17787i.a("event_cover_photo_click", false);
        if (a.a()) {
            a.a("event_permalink");
            a.d(this.f17788j.b(this.f17785g));
            a.b("Event");
            a.c(str);
            a.a("ref_module", str2);
            a.a("source_module", str3);
            a.a("ref_mechanism", str4);
            a.a("cover_photo_id", str5);
            a.b();
        }
    }

    public final void m18144c(String str, String str2, String str3) {
        HoneyClientEventFast a = this.f17787i.a("event_discovery_open_filter_surface", false);
        if (a.a()) {
            a.a("event_discovery").a("ref_module", str).a("ref_mechanism", str2).a("event_suggestion_token", str3).b();
        }
    }

    public final void m18146e() {
        m18121g("event_creation_expand_options_click", "event_composer");
    }
}
