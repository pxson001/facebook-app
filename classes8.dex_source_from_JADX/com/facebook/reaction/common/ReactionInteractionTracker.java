package com.facebook.reaction.common;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.Assisted;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionSource;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.analytics.ReactionAnalytics.WelcomeHeaderInteractionType;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger;
import com.facebook.reaction.analytics.ReactionAnalyticsLogger.Event;
import com.facebook.reaction.analytics.perflog.ReactionPerfLogger;
import com.facebook.reaction.constants.ReactionIntentConstants.EntryPoint;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitDefaultFields;
import com.google.common.base.Strings;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: custom_cta_mobile_invalid_url */
public class ReactionInteractionTracker implements ReactionAttachmentListener {
    public static final String f16096a = ReactionInteractionTracker.class.getSimpleName();
    public Bundle f16097b;
    public AbstractFbErrorReporter f16098c;
    private InteractingStory f16099d;
    private long f16100e;
    private LinearLayoutManager f16101f;
    public ReactionAnalyticsLogger f16102g;
    private long f16103h = 0;
    public int f16104i = 0;
    public final ReactionPerfLogger f16105j;
    public String f16106k;
    public final ReactionSession f16107l;
    public boolean f16108m = true;
    public boolean f16109n = true;
    public long f16110o = 0;
    private final List<String> f16111p;
    private final List<String> f16112q;
    private final List<UnitInteractionType> f16113r;
    public final List<String> f16114s;
    public final List<String> f16115t;
    private final Map<String, Unit> f16116u;
    private final List<String> f16117v;
    private final List<String> f16118w;

    /* compiled from: custom_cta_mobile_invalid_url */
    public class InteractingStory {
        final /* synthetic */ ReactionInteractionTracker f18840a;
        public final String f18841b;
        public final String f18842c;
        public final UnitInteractionType f18843d;
        public long f18844e;
        public final String f18845f;

        private InteractingStory(ReactionInteractionTracker reactionInteractionTracker, String str, @Nullable String str2, @Nullable String str3, UnitInteractionType unitInteractionType) {
            this.f18840a = reactionInteractionTracker;
            this.f18842c = str;
            this.f18841b = str2;
            this.f18843d = unitInteractionType;
            this.f18845f = str3;
        }
    }

    /* compiled from: custom_cta_mobile_invalid_url */
    public class Unit {
        public final String f18846a;
        public String f18847b;
        public int f18848c;
        public int f18849d;
        public int f18850e;
        public String f18851f;
        public boolean f18852g;
        public boolean f18853h;
        public long f18854i;
        public long f18855j;
        public int f18856k;
        public int f18857l;

        public Unit(String str) {
            this.f18846a = str;
        }

        public final String m22872a() {
            return this.f18846a;
        }

        public final int m22873b() {
            return this.f18856k;
        }

        public final int m22874c() {
            return this.f18857l;
        }

        public final String m22875d() {
            return this.f18847b;
        }

        public final int m22876e() {
            return this.f18848c;
        }

        public final String m22877f() {
            return this.f18851f;
        }

        public final boolean m22878g() {
            return this.f18851f != null;
        }

        public final long m22879i() {
            return this.f18854i;
        }
    }

    @Inject
    public ReactionInteractionTracker(@Assisted ReactionSession reactionSession, @Nullable @Assisted LinearLayoutManager linearLayoutManager, AbstractFbErrorReporter abstractFbErrorReporter, ReactionAnalyticsLogger reactionAnalyticsLogger, ReactionPerfLogger reactionPerfLogger) {
        this.f16098c = abstractFbErrorReporter;
        this.f16101f = linearLayoutManager;
        this.f16102g = reactionAnalyticsLogger;
        this.f16105j = reactionPerfLogger;
        this.f16107l = reactionSession;
        this.f16111p = new LinkedList();
        this.f16112q = new LinkedList();
        this.f16113r = new LinkedList();
        this.f16114s = new LinkedList();
        this.f16115t = new LinkedList();
        this.f16117v = new LinkedList();
        this.f16118w = new LinkedList();
        this.f16116u = new HashMap();
    }

    public final void m18933a(ReactionUnitDefaultFields reactionUnitDefaultFields, int i, int i2) {
        if (!Strings.isNullOrEmpty(reactionUnitDefaultFields.d())) {
            Unit e = m18919e(reactionUnitDefaultFields.d());
            if (e.m22878g()) {
                e.f18849d = Math.max(e.f18849d, i2);
                e.f18850e = Math.min(e.f18850e, i2);
                return;
            }
            String fv_ = reactionUnitDefaultFields.fv_();
            String n = reactionUnitDefaultFields.n();
            e.f18847b = fv_;
            e.f18849d = i2;
            e.f18850e = i2;
            e.f18848c = i;
            e.f18851f = n;
            e.f18852g = false;
            e.f18854i = 0;
            e.f18855j = 0;
        }
    }

    public final void m18930a(long j, ReactionUnitDefaultFields reactionUnitDefaultFields, ReactionUnitDefaultFields reactionUnitDefaultFields2) {
        Unit e = m18919e(reactionUnitDefaultFields2.d());
        if (e.m22878g()) {
            m18933a(reactionUnitDefaultFields, e.f18848c, e.f18850e);
            m18933a(reactionUnitDefaultFields, e.f18848c, e.f18849d);
            m18921g(j);
        }
    }

    public final void m18929a(long j, ReactionUnitDefaultFields reactionUnitDefaultFields) {
        if (!Strings.isNullOrEmpty(reactionUnitDefaultFields.d())) {
            Unit e = m18919e(reactionUnitDefaultFields.d());
            e.f18850e = -1;
            e.f18849d = -1;
            m18921g(j);
        }
    }

    public final void m18932a(ReactionUnitDefaultFields reactionUnitDefaultFields) {
        if (!this.f16117v.contains(reactionUnitDefaultFields.d())) {
            this.f16117v.add(reactionUnitDefaultFields.d());
            this.f16118w.add(reactionUnitDefaultFields.n());
        }
    }

    public final void m18922a() {
        this.f16111p.clear();
        this.f16112q.clear();
        this.f16113r.clear();
        this.f16114s.clear();
        this.f16115t.clear();
        this.f16117v.clear();
        this.f16118w.clear();
        this.f16116u.clear();
    }

    public final String m18945b() {
        return this.f16107l.f18658a;
    }

    public final void m18947c() {
        int size = this.f16116u.size();
        for (Unit unit : this.f16116u.values()) {
            if (unit.m22879i() > 0) {
                this.f16102g.m22830a(this.f16107l.m22562f(), this.f16107l.m22575w(), unit.m22872a(), unit.m22877f(), size, unit.m22876e(), unit.m22873b(), unit.m22874c(), unit.m22879i(), unit.m22875d(), this.f16106k);
            }
        }
    }

    public final void m18924a(long j) {
        m18921g(j);
    }

    public final void m18925a(long j, int i, int i2) {
        m18920f(j);
        m18915a(i, i2);
    }

    public void mo981a(String str, String str2, ReactionAttachmentIntent reactionAttachmentIntent) {
        String stringExtra;
        String c = m18917c(str);
        ReactionAnalyticsLogger reactionAnalyticsLogger = this.f16102g;
        String f = this.f16107l.m22562f();
        Surface w = this.f16107l.m22575w();
        Bundle bundle = this.f16097b;
        String str3 = this.f16106k;
        int d = m18918d(str);
        String v = this.f16107l.m22574v();
        String str4 = reactionAttachmentIntent.f18829b;
        UnitInteractionType unitInteractionType = reactionAttachmentIntent.f18828a;
        if (reactionAttachmentIntent.f18831d != null) {
            stringExtra = reactionAttachmentIntent.f18831d.getStringExtra("event_suggestion_token");
        } else {
            stringExtra = null;
        }
        reactionAnalyticsLogger.m22822a(f, w, bundle, str3, c, str, d, str2, null, v, str4, null, unitInteractionType, stringExtra);
        this.f16111p.add(str);
        this.f16112q.add(str2);
        this.f16113r.add(reactionAttachmentIntent.f18828a);
        this.f16099d = new InteractingStory(c, str, str2, reactionAttachmentIntent.f18828a);
    }

    public final void m18943a(String str, String str2, @Nullable String str3, ReactionAttachmentIntent reactionAttachmentIntent) {
        String stringExtra;
        String c = m18917c(str);
        ReactionAnalyticsLogger reactionAnalyticsLogger = this.f16102g;
        String f = this.f16107l.m22562f();
        Surface w = this.f16107l.m22575w();
        Bundle bundle = this.f16097b;
        String str4 = this.f16106k;
        int d = m18918d(str);
        String v = this.f16107l.m22574v();
        String str5 = reactionAttachmentIntent.f18829b;
        UnitInteractionType unitInteractionType = reactionAttachmentIntent.f18828a;
        if (reactionAttachmentIntent.f18831d != null) {
            stringExtra = reactionAttachmentIntent.f18831d.getStringExtra("event_suggestion_token");
        } else {
            stringExtra = null;
        }
        reactionAnalyticsLogger.m22822a(f, w, bundle, str4, c, str, d, str2, str3, v, str5, null, unitInteractionType, stringExtra);
        this.f16111p.add(str);
        this.f16112q.add(str2);
        this.f16113r.add(reactionAttachmentIntent.f18828a);
        this.f16099d = new InteractingStory(c, str, str2, reactionAttachmentIntent.f18828a);
    }

    public final void mo980a(String str, String str2) {
        int d = m18918d(str);
        Unit e = m18919e(str);
        if (!e.f18852g) {
            this.f16102g.m22831a(this.f16107l.f18658a, this.f16107l.f18660c, e.f18847b, str, d, str2);
            e.f18852g = true;
        }
    }

    public final void mo979a(String str, int i) {
        Unit e = m18919e(str);
        e.f18857l = Math.max(i, e.f18857l);
    }

    public final void mo983b(String str, int i) {
        Unit e = m18919e(str);
        e.f18856k = Math.max(i, e.f18856k);
    }

    public final void mo982a(Throwable th) {
        this.f16102g.m22834a(this.f16107l.f18658a, this.f16107l.f18660c, th);
    }

    public final void m18948c(long j) {
        if (this.f16108m) {
            this.f16102g.f18800a.a(ReactionAnalyticsLogger.m22811a(Event.REACTION_FORWARD_SCROLL, this.f16107l.f18658a, "reaction_attachment", this.f16107l.f18660c).a("time_to_scroll", j));
            this.f16108m = false;
        }
    }

    public final void m18939a(String str, String str2, int i, String str3) {
        this.f16102g.m22833a(this.f16107l.f18658a, this.f16107l.f18660c, m18919e(str).f18847b, str, str2, i, str3);
    }

    public final void m18950e() {
        this.f16108m = true;
    }

    public final void m18952g() {
        this.f16109n = true;
    }

    public final void m18923a(int i, long j) {
        this.f16105j.a(1966084, this.f16107l.f18658a);
        m18916b(i, j);
        this.f16103h = j;
        this.f16110o = 0;
        this.f16104i++;
    }

    public final void m18926a(long j, long j2) {
        this.f16102g.m22825a(this.f16107l.m22562f(), this.f16107l.m22575w(), this.f16107l.m22561e(), this.f16107l.m22560c(), this.f16106k, this.f16118w, j, j2, this.f16111p, this.f16112q, (Iterable) this.f16113r, this.f16113r.size());
        if (!(this.f16107l.m22568o() == null || this.f16107l.m22568o().m22529g() == null)) {
            this.f16102g.m22829a(this.f16107l.m22562f(), this.f16107l.m22575w(), this.f16107l.m22561e(), this.f16107l.m22560c(), this.f16106k, this.f16107l.m22568o().m22529g(), this.f16118w, j, j2, this.f16111p, this.f16112q, this.f16113r, this.f16113r.size());
        }
        m18947c();
    }

    public final void m18927a(long j, long j2, long j3, long j4, long j5, long j6) {
        this.f16102g.m22826a(this.f16107l.m22562f(), this.f16107l.m22575w(), this.f16107l.m22561e(), this.f16107l.m22560c(), this.f16106k, this.f16118w, this.f16115t, this.f16114s, j, j2, j5 - j4, j3, j6);
        if (this.f16101f != null) {
            m18915a(this.f16101f.l(), this.f16101f.n());
        }
        this.f16100e = j5;
        this.f16103h = j5;
    }

    public final void m18935a(String str, long j, long j2, long j3) {
        String str2;
        Surface surface;
        String str3;
        EntryPoint entryPoint;
        ReactionAnalyticsLogger reactionAnalyticsLogger = this.f16102g;
        if (this.f16107l == null) {
            str2 = "NO_SESSION_ID";
        } else {
            str2 = this.f16107l.m22562f();
        }
        if (this.f16107l == null) {
            surface = Surface.ANDROID_COMPOSER;
        } else {
            surface = this.f16107l.m22575w();
        }
        if (this.f16107l == null) {
            str3 = null;
        } else {
            str3 = this.f16107l.m22561e();
        }
        if (this.f16107l == null) {
            entryPoint = null;
        } else {
            entryPoint = this.f16107l.m22560c();
        }
        reactionAnalyticsLogger.m22827a(str2, surface, str3, entryPoint, this.f16106k, this.f16118w, this.f16115t, this.f16114s, j, j2, j3, str);
    }

    public final void m18949d(long j) {
        if (this.f16099d != null) {
            this.f16099d.f18844e = j;
        }
        m18920f(j);
    }

    public final void m18951e(long j) {
        if (this.f16099d != null) {
            this.f16102g.m22832a(this.f16107l.f18658a, this.f16107l.f18660c, this.f16099d.f18842c, this.f16099d.f18845f, j - this.f16099d.f18844e, this.f16099d.f18841b, this.f16099d.f18845f, this.f16099d.f18843d);
            this.f16099d = null;
        }
        if (this.f16101f != null) {
            m18915a(this.f16101f.l(), this.f16101f.n());
        }
        this.f16100e = j;
    }

    public void mo984a(String str, String str2, @Nullable UnitInteractionSource unitInteractionSource, UnitInteractionType unitInteractionType) {
        this.f16102g.m22822a(this.f16107l.m22562f(), this.f16107l.m22575w(), this.f16097b, this.f16106k, m18917c(str), str, m18918d(str), str2, null, this.f16107l.m22574v(), null, unitInteractionSource, unitInteractionType, null);
    }

    public final void m18941a(String str, String str2, @Nullable UnitInteractionSource unitInteractionSource, UnitInteractionType unitInteractionType, String str3) {
        this.f16102g.m22822a(this.f16107l.m22562f(), this.f16107l.m22575w(), this.f16097b, this.f16106k, m18917c(str), str, m18918d(str), str2, null, this.f16107l.m22574v(), str3, unitInteractionSource, unitInteractionType, null);
    }

    public final void m18936a(String str, WelcomeHeaderInteractionType welcomeHeaderInteractionType) {
        m18937a(str, welcomeHeaderInteractionType, null);
    }

    public final void m18937a(String str, WelcomeHeaderInteractionType welcomeHeaderInteractionType, @Nullable String str2) {
        this.f16102g.m22823a(this.f16107l.f18658a, this.f16107l.f18660c, str, welcomeHeaderInteractionType, str2);
    }

    public final void m18928a(long j, long j2, @Nullable String str, String str2) {
        if (this.f16107l.m22568o() == null) {
            this.f16098c.a(f16096a, "No query params on local serp");
        } else if (this.f16107l.m22568o().m22529g() == null && this.f16107l.m22568o().m22528b() == null) {
            this.f16098c.a(f16096a, "No place id on local serp");
        } else {
            this.f16102g.m22819a(this.f16107l, this.f16107l.m22568o().m22529g(), this.f16107l.m22568o().m22528b(), this.f16106k, str, str2, j, j2, this.f16116u.values(), this.f16111p);
        }
    }

    public final void m18931a(LinearLayoutManager linearLayoutManager, long j, boolean z) {
        this.f16101f = linearLayoutManager;
        if (z) {
            m18924a(j);
        }
    }

    private void m18916b(int i, long j) {
        this.f16102g.m22821a(this.f16107l.m22562f(), this.f16107l.m22575w(), this.f16104i, i, this.f16107l.m22567l() - this.f16103h, this.f16110o != 0 ? this.f16110o - this.f16103h : 0, this.f16107l.m22566k(), this.f16110o != 0 ? j - this.f16110o : 0, j - this.f16107l.m22570q());
    }

    @Nullable
    private String m18917c(String str) {
        Unit unit = (Unit) this.f16116u.get(str);
        return unit == null ? null : unit.f18847b;
    }

    private int m18918d(String str) {
        Unit unit = (Unit) this.f16116u.get(str);
        return unit == null ? -1 : unit.f18848c;
    }

    private Unit m18919e(String str) {
        Unit unit = (Unit) this.f16116u.get(str);
        if (unit != null) {
            return unit;
        }
        unit = new Unit(str);
        this.f16116u.put(str, unit);
        return unit;
    }

    private void m18920f(long j) {
        long j2 = j - this.f16100e;
        this.f16100e = j;
        for (Unit unit : this.f16116u.values()) {
            long j3 = this.f16100e;
            if (unit.f18853h && j3 > unit.f18855j) {
                unit.f18854i += j2;
                unit.f18855j = j3;
            }
        }
    }

    private void m18921g(long j) {
        m18920f(j);
        if (this.f16101f != null) {
            m18915a(this.f16101f.l(), this.f16101f.n());
        }
    }

    private void m18915a(int i, int i2) {
        for (Unit unit : this.f16116u.values()) {
            boolean z = false;
            if (unit.m22878g() && unit.f18848c >= 0 && i >= 0 && i2 >= 0 && unit.f18849d >= i && unit.f18850e <= i2) {
                z = true;
            }
            unit.f18853h = z;
        }
    }
}
