package com.facebook.entitycards.analytics;

import com.facebook.common.util.StringUtil;
import com.facebook.entitycards.model.EntityCardsScrollDirection;
import com.facebook.inject.Assisted;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.PerformanceLogger;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: inflatedId */
public class EntityCardsPerfLogger {
    private static final Class<?> f10890a = EntityCardsPerfLogger.class;
    private final PerformanceLogger f10891b;
    private final String f10892c;
    private final String f10893d;
    private final Optional<String> f10894e;
    private final Map<String, MarkerConfig> f10895f;

    @Inject
    public EntityCardsPerfLogger(PerformanceLogger performanceLogger, @Assisted String str, @Assisted String str2, @Assisted Optional<String> optional) {
        boolean z = true;
        Preconditions.checkArgument(!StringUtil.a(str));
        if (StringUtil.a(str2)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f10895f = Maps.c();
        this.f10891b = performanceLogger;
        this.f10892c = str;
        this.f10893d = str2;
        this.f10894e = optional;
    }

    public final void m12825a(EntityCardsScrollDirection entityCardsScrollDirection) {
        new StringBuilder("StartEntityCardsScrollWaitTime_").append(entityCardsScrollDirection.toString());
        m12821a(1048579, "ec_card_scroll_wait_time");
    }

    public final void m12826b(EntityCardsScrollDirection entityCardsScrollDirection) {
        new StringBuilder("StopEntityCardsScrollWaitTime_").append(entityCardsScrollDirection.toString());
        m12822b(1048579, "ec_card_scroll_wait_time");
    }

    public final void m12824a() {
        m12823c(1048579, "ec_card_scroll_wait_time");
    }

    public final void m12827c(EntityCardsScrollDirection entityCardsScrollDirection) {
        new StringBuilder("EntityCardPageFetchTime_").append(entityCardsScrollDirection.toString());
        m12821a(1048580, "ec_cards_page_download");
    }

    public final void m12828d(EntityCardsScrollDirection entityCardsScrollDirection) {
        new StringBuilder("EntityCardPageFetchSucceeded_").append(entityCardsScrollDirection.toString());
        m12822b(1048580, "ec_cards_page_download");
    }

    public final void m12829e(EntityCardsScrollDirection entityCardsScrollDirection) {
        new StringBuilder("EntityCardPageFetchFailed_").append(entityCardsScrollDirection.toString());
        m12823c(1048580, "ec_cards_page_download");
    }

    private void m12821a(int i, String str) {
        MarkerConfig markerConfig = (MarkerConfig) this.f10895f.get(str);
        if (markerConfig == null) {
            markerConfig = new MarkerConfig(i, str);
            markerConfig.e = "entity_cards";
            MarkerConfig a = markerConfig.a(new String[]{"entity_cards"}).b().a("surface", this.f10893d);
            if (1 != null && a.l == null) {
                a.l = Maps.c();
            }
            Map map = a.l;
            map.put("instance_id", this.f10892c);
            map.put("surface", this.f10893d);
            map.put("surface_source_id", this.f10894e.isPresent() ? (String) this.f10894e.get() : "");
            this.f10895f.put(str, a);
            markerConfig = a;
        }
        this.f10891b.c(markerConfig);
    }

    private void m12822b(int i, String str) {
        this.f10891b.a(i, str, "entity_cards");
    }

    private void m12823c(int i, String str) {
        this.f10891b.c(i, str, "entity_cards");
    }
}
