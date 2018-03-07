package com.facebook.messaging.users;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CounterLogger;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.facebook.messaging.cache.ThreadDisplayCache;
import com.facebook.messaging.material.abtest.MaterialDesignExperimentHelper;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.presence.LastActiveHelper;
import com.facebook.messaging.presence.LastActiveHelper.TextFormat;
import com.facebook.messaging.presence.LastActiveHelper.Verbosity;
import com.facebook.messaging.ui.name.MessengerThreadNameViewData;
import com.facebook.pages.messaging.responsiveness.PageResponseTimespan;
import com.facebook.pages.messaging.responsiveness.PageResponsivenessCache;
import com.facebook.pages.messaging.responsiveness.PageResponsivenessContext;
import com.facebook.pages.messaging.responsiveness.PageResponsivenessHandler;
import com.facebook.pages.messaging.responsiveness.PageResponsivenessUtils;
import com.facebook.presence.Availability;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceManager.OnContactPresenceStateChangedListener;
import com.facebook.presence.PresenceManager.PresenceDownloadState;
import com.facebook.presence.PresenceState;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.LastActive;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Locale;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: chat_head_nux_recangular_vch */
public class CanonicalThreadPresenceHelper {
    private final DefaultPresenceManager f18295a;
    private final ThreadDisplayCache f18296b;
    private final LastActiveHelper f18297c;
    private final CounterLogger f18298d;
    private final LocalStatsLoggerImpl f18299e;
    public final AnalyticsLogger f18300f;
    private final PageResponsivenessHandler f18301g;
    private final Executor f18302h;
    private final UserCache f18303i;
    private final MaterialDesignExperimentHelper f18304j;
    private final OnContactPresenceStateChangedListener f18305k;
    public boolean f18306l;
    private MessengerThreadNameViewData f18307m;
    public ParticipantInfo f18308n;
    private long f18309o;
    private User f18310p;
    private UserKey f18311q;
    public PresenceState f18312r = PresenceState.a;
    public Listener f18313s;
    public PageResponsivenessListener f18314t;

    /* compiled from: chat_head_nux_recangular_vch */
    class C21201 extends OnContactPresenceStateChangedListener {
        final /* synthetic */ CanonicalThreadPresenceHelper f18292a;

        C21201(CanonicalThreadPresenceHelper canonicalThreadPresenceHelper) {
            this.f18292a = canonicalThreadPresenceHelper;
        }

        public final void m18247a(UserKey userKey, PresenceState presenceState) {
            CanonicalThreadPresenceHelper.m18256a(this.f18292a, userKey, presenceState);
        }
    }

    /* compiled from: chat_head_nux_recangular_vch */
    public abstract class Listener {
        public abstract void m18248a(PresenceState presenceState);
    }

    /* compiled from: chat_head_nux_recangular_vch */
    public interface PageResponsivenessListener {
        void m18249a();
    }

    public static CanonicalThreadPresenceHelper m18260b(InjectorLike injectorLike) {
        return new CanonicalThreadPresenceHelper(DefaultPresenceManager.a(injectorLike), ThreadDisplayCache.m10136a(injectorLike), LastActiveHelper.m16446a(injectorLike), CounterLogger.a(injectorLike), LocalStatsLoggerMethodAutoProvider.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), new PageResponsivenessHandler(PageResponsivenessCache.m18419a(injectorLike), GraphQLQueryExecutor.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike)), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), UserCache.a(injectorLike), MaterialDesignExperimentHelper.b(injectorLike));
    }

    public static CanonicalThreadPresenceHelper m18250a(InjectorLike injectorLike) {
        return m18260b(injectorLike);
    }

    @Inject
    public CanonicalThreadPresenceHelper(DefaultPresenceManager defaultPresenceManager, ThreadDisplayCache threadDisplayCache, LastActiveHelper lastActiveHelper, CounterLogger counterLogger, LocalStatsLoggerImpl localStatsLoggerImpl, AnalyticsLogger analyticsLogger, PageResponsivenessHandler pageResponsivenessHandler, Executor executor, UserCache userCache, MaterialDesignExperimentHelper materialDesignExperimentHelper) {
        this.f18295a = defaultPresenceManager;
        this.f18296b = threadDisplayCache;
        this.f18297c = lastActiveHelper;
        this.f18298d = counterLogger;
        this.f18299e = localStatsLoggerImpl;
        this.f18300f = analyticsLogger;
        this.f18301g = pageResponsivenessHandler;
        this.f18302h = executor;
        this.f18303i = userCache;
        this.f18304j = materialDesignExperimentHelper;
        this.f18305k = new C21201(this);
    }

    public final void m18268a(boolean z) {
        this.f18306l = z;
        m18263e();
    }

    public final void m18267a(MessengerThreadNameViewData messengerThreadNameViewData) {
        this.f18307m = messengerThreadNameViewData;
        if (this.f18307m != null) {
            this.f18308n = this.f18307m.f18236a;
            this.f18309o = this.f18307m.m18193b();
        } else {
            this.f18308n = null;
            this.f18309o = 0;
        }
        if (this.f18308n != null) {
            this.f18310p = this.f18303i.a(this.f18308n.b);
        } else {
            this.f18310p = null;
        }
        m18263e();
    }

    public final boolean m18269c() {
        return this.f18308n != null;
    }

    public final String m18266a(Context context, String str, TextFormat textFormat, boolean z, @Nullable User user) {
        if (m18259a(user)) {
            return m18252a(context, str, textFormat, user);
        }
        return m18253a(textFormat, z);
    }

    private String m18253a(TextFormat textFormat, boolean z) {
        if (m18265g()) {
            return m18261b(textFormat, z);
        }
        if (m18264f() != 0) {
            return m18262c(textFormat, z);
        }
        return null;
    }

    private String m18261b(TextFormat textFormat, boolean z) {
        return this.f18297c.m16452a(z ? Verbosity.ABBREVIATED : Verbosity.VERBOSE, textFormat);
    }

    private void m18263e() {
        UserKey userKey = null;
        if (this.f18306l) {
            if (this.f18308n != null) {
                userKey = this.f18308n.b;
            }
            m18257a(userKey);
            return;
        }
        m18257a(null);
    }

    private void m18257a(@Nullable UserKey userKey) {
        if (!Objects.equal(userKey, this.f18311q)) {
            this.f18312r = PresenceState.a;
            if (this.f18311q != null) {
                this.f18295a.b(this.f18311q, this.f18305k);
            }
            this.f18311q = userKey;
            if (this.f18311q != null) {
                this.f18295a.a(this.f18311q, this.f18305k);
                this.f18312r = this.f18295a.c(this.f18311q);
            }
        }
    }

    public static void m18256a(CanonicalThreadPresenceHelper canonicalThreadPresenceHelper, UserKey userKey, PresenceState presenceState) {
        if (canonicalThreadPresenceHelper.f18311q != null && Objects.equal(userKey, canonicalThreadPresenceHelper.f18311q) && !canonicalThreadPresenceHelper.f18312r.equals(presenceState)) {
            canonicalThreadPresenceHelper.f18312r = presenceState;
            if (canonicalThreadPresenceHelper.f18313s != null) {
                canonicalThreadPresenceHelper.f18313s.m18248a(presenceState);
            }
            if (canonicalThreadPresenceHelper.f18310p != null && canonicalThreadPresenceHelper.f18310p.T() && presenceState.b == Availability.AVAILABLE) {
                canonicalThreadPresenceHelper.m18258a("displayed_page_presence_online_values", 5505051);
            }
        }
    }

    private long m18264f() {
        if (this.f18310p == null) {
            return 0;
        }
        LastActive d = this.f18295a.d(this.f18310p.T);
        if (d == null) {
            m18258a("canonical_no_presence", 5505058);
            return 0;
        }
        Long l;
        int i = 0;
        long j = d.a;
        m18258a("canonical_presence_checks", 5505050);
        if (this.f18309o > j) {
            i = 1;
            m18254a(j, this.f18309o, "read");
            m18255a(this.f18309o - j, "canonical_presence_lastread_stale_lessthanthreshold", "canonical_presence_lastread_stale_morethanthreshold", 5505054, 5505053);
            j = this.f18309o;
        }
        ThreadDisplayCache threadDisplayCache = this.f18296b;
        UserKey userKey = this.f18310p.T;
        if (userKey == null) {
            l = null;
        } else {
            l = (Long) threadDisplayCache.f9553c.get(userKey.c());
        }
        Long l2 = l;
        if (l2 != null && l2.longValue() > j) {
            i++;
            m18254a(j, l2.longValue(), "sent");
            m18255a(l2.longValue() - j, "canonical_presence_lastsent_stale_lessthanthreshold", "canonical_presence_lastsent_stale_morethanthreshold", 5505055, 5505056);
            j = l2.longValue();
        }
        if (i == 2) {
            m18258a("canonical_presence_doublestale", 5505052);
        }
        return LastActiveHelper.m16445a(j, this.f18312r.b);
    }

    private void m18254a(long j, long j2, String str) {
        if (j2 - j >= 180000) {
            HoneyClientEvent b = new HoneyClientEvent("presence_stale").a("stale_active_time_ms", j).a("new_active_time_ms", j2).b("source", str);
            b.c = "presence_staleness";
            b = b;
            if (m18269c()) {
                b.b("other_user_id", this.f18310p.a);
            }
            this.f18300f.a(b);
        }
    }

    private void m18255a(long j, String str, String str2, int i, int i2) {
        if (j >= 180000) {
            m18258a(str2, i2);
        } else if (j >= 5000) {
            m18258a(str, i);
        }
    }

    private void m18258a(String str, int i) {
        if (this.f18295a.K != PresenceDownloadState.MQTT_DISCONNECTED) {
            this.f18298d.a(str);
            this.f18299e.a(i);
        }
    }

    private boolean m18265g() {
        return this.f18312r.b == Availability.AVAILABLE;
    }

    private String m18262c(TextFormat textFormat, boolean z) {
        if (this.f18310p == null) {
            return "";
        }
        if (z) {
            return this.f18297c.m16450a(m18264f(), textFormat);
        }
        return this.f18297c.m16451a(m18264f(), textFormat, this.f18304j.f());
    }

    private boolean m18259a(@Nullable User user) {
        if (user == null) {
            user = this.f18310p;
        }
        return user != null && user.T();
    }

    private String m18252a(Context context, String str, TextFormat textFormat, User user) {
        if (user == null) {
            return "";
        }
        Preconditions.checkArgument(user.T());
        final String str2 = user.a;
        if (this.f18301g.m18428a(str2)) {
            return m18251a(context, this.f18301g.m18429b(str2), textFormat);
        }
        if (this.f18301g.m18431d(str2)) {
            return str;
        }
        Futures.a(this.f18301g.m18430c(str2), new FutureCallback<PageResponsivenessContext>(this) {
            final /* synthetic */ CanonicalThreadPresenceHelper f18294b;

            public void onSuccess(@Nullable Object obj) {
                PageResponsivenessContext pageResponsivenessContext = (PageResponsivenessContext) obj;
                if (this.f18294b.f18314t != null) {
                    this.f18294b.f18314t.m18249a();
                }
            }

            public void onFailure(Throwable th) {
            }
        }, this.f18302h);
        return str;
    }

    private String m18251a(Context context, @Nullable PageResponsivenessContext pageResponsivenessContext, TextFormat textFormat) {
        String str;
        if (!m18265g() || (pageResponsivenessContext != null && pageResponsivenessContext.f18439b)) {
            String a;
            if (pageResponsivenessContext == null) {
                a = PageResponsivenessUtils.m18432a(context, PageResponseTimespan.NONE, false);
            } else {
                a = PageResponsivenessUtils.m18432a(context, pageResponsivenessContext.f18438a, pageResponsivenessContext.f18439b);
            }
            str = a;
            if (pageResponsivenessContext != null) {
                HoneyClientEventFast a2 = this.f18300f.a("displayed_page_responsiveness_value", false);
                if (a2.a()) {
                    a2.a("page_responsiveness", pageResponsivenessContext.f18438a.ordinal());
                    a2.b();
                }
            }
        } else {
            str = m18261b(textFormat, false);
        }
        if (textFormat == TextFormat.UPPER_CASE) {
            return str.toUpperCase(Locale.getDefault());
        }
        return str;
    }
}
