package com.facebook.entitycards.analytics;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.StringUtil;
import com.facebook.entitycards.model.EntityCardsDataSource;
import com.facebook.inject.Assisted;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: initial-slide */
public class EntityCardsImpressionLogger extends SimpleOnPageChangeListener {
    private final EntityCardsAnalyticsLogger f10876a;
    private final EntityCardsDataSource f10877b;
    private final MonotonicClock f10878c;
    @Nullable
    private String f10879d = null;
    private long f10880e = -1;
    private boolean f10881f = false;

    @Inject
    public EntityCardsImpressionLogger(@Assisted EntityCardsAnalyticsLogger entityCardsAnalyticsLogger, @Assisted EntityCardsDataSource entityCardsDataSource, MonotonicClock monotonicClock) {
        this.f10876a = entityCardsAnalyticsLogger;
        this.f10877b = entityCardsDataSource;
        this.f10878c = monotonicClock;
    }

    public final void e_(int i) {
        m12805c(i);
        ImmutableList g = this.f10877b.mo784g();
        if (i < g.size()) {
            String str = (String) g.get(i);
            EntityCardsAnalyticsLogger entityCardsAnalyticsLogger = this.f10876a;
            Preconditions.checkArgument(!StringUtil.a(str));
            Map hashMap = new HashMap();
            hashMap.put("profile_id", str);
            ((NavigationLogger) entityCardsAnalyticsLogger.f10866b.get()).a(null, "entity_cards", "entity_cards", null, hashMap);
        }
    }

    public final void m12803a() {
        m12802c();
        this.f10881f = true;
    }

    public final void m12804b() {
        if (this.f10881f) {
            m12801a(this.f10879d);
        }
        this.f10881f = false;
    }

    public final void m12805c(int i) {
        ImmutableList g = this.f10877b.mo784g();
        if (i < g.size()) {
            String str = (String) g.get(i);
            if (!Objects.equal(str, this.f10879d)) {
                m12802c();
                m12801a(str);
            }
        }
    }

    private void m12801a(String str) {
        this.f10879d = str;
        this.f10880e = this.f10878c.now();
    }

    private void m12802c() {
        if (this.f10879d != null) {
            this.f10876a.m12797a(this.f10879d, ((double) (this.f10878c.now() - this.f10880e)) / 1000.0d);
            this.f10880e = -1;
        }
    }
}
