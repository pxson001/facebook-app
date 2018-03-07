package com.facebook.friendsharing.souvenirs.util;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.friendsharing.souvenirs.models.SouvenirBurstItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.prompt.model.SouvenirPromptObject;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: most_recent_hosts_part */
public class SouvenirsLogger {
    private final AnalyticsLogger f13318a;
    private final Clock f13319b;
    @Nullable
    public String f13320c;

    public static SouvenirsLogger m19617b(InjectorLike injectorLike) {
        return new SouvenirsLogger(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), SystemClockMethodAutoProvider.m1498a(injectorLike));
    }

    public static SouvenirsLogger m19615a(InjectorLike injectorLike) {
        return m19617b(injectorLike);
    }

    @Inject
    public SouvenirsLogger(AnalyticsLogger analyticsLogger, Clock clock) {
        this.f13318a = analyticsLogger;
        this.f13319b = clock;
    }

    public final void m19618a() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.PICKER_PREVIEWS_LOADED.toString());
        honeyClientEvent.f3099c = "souvenirs";
        m19616a(honeyClientEvent);
    }

    public final void m19619a(int i, SouvenirModel souvenirModel) {
        m19616a(m19613a(Event.PICKER_PREVIEW_TAPPED.toString(), i, souvenirModel));
    }

    public final void m19622b(int i, SouvenirModel souvenirModel) {
        m19616a(m19613a(Event.PICKER_PREVIEW_SEEN.toString(), i, souvenirModel));
    }

    public final void m19621b() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.PICKER_NUX_SEEN.toString());
        honeyClientEvent.f3099c = "souvenirs";
        m19616a(honeyClientEvent);
    }

    public final void m19624c() {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Event.PICKER_NUX_DISMISSED.toString());
        honeyClientEvent.f3099c = "souvenirs";
        m19616a(honeyClientEvent);
    }

    public final void m19620a(SouvenirPromptObject souvenirPromptObject) {
        m19616a(m19613a(Event.PROMPT_CLOSED.toString(), -1, souvenirPromptObject.a));
    }

    public final void m19623b(SouvenirPromptObject souvenirPromptObject) {
        m19616a(m19613a(Event.PROMPT_DISPLAYED.toString(), -1, souvenirPromptObject.a));
    }

    public final void m19625c(SouvenirPromptObject souvenirPromptObject) {
        m19616a(m19613a(Event.PROMPT_TAPPED.toString(), -1, souvenirPromptObject.a));
    }

    private HoneyClientEvent m19613a(String str, int i, SouvenirModel souvenirModel) {
        LoggingParameters a = m19614a(souvenirModel);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f3099c = "souvenirs";
        HoneyClientEvent b = honeyClientEvent.m5083a(Extras.PHOTOS_COUNT.getParamKey(), a.a).m5083a(Extras.VIDEOS_COUNT.getParamKey(), a.b).m5083a(Extras.BURST_COUNT.getParamKey(), a.c).m5083a(Extras.TILE_COUNT.getParamKey(), a.d).m5083a(Extras.TOTAL_ASSETS_COUNT.getParamKey(), a.e).m5083a(Extras.TOTAL_ASSETS_WITHIN_BURSTS_COUNT.getParamKey(), a.f).m5084a(Extras.TIME_SINCE_STORY.getParamKey(), a.g).m5090b(Extras.SOUVENIR_UNIQUE_ID.getParamKey(), souvenirModel.a().a());
        if (i != -1) {
            b.m5083a(Extras.CURRENT_INDEX.getParamKey(), i);
        }
        return b;
    }

    private LoggingParameters m19614a(SouvenirModel souvenirModel) {
        Preconditions.checkNotNull(souvenirModel);
        LoggingParameters loggingParameters = new LoggingParameters();
        ImmutableList b = souvenirModel.b();
        loggingParameters.d = b.size();
        loggingParameters.g = (this.f13319b.mo211a() - souvenirModel.a().d()) / 60000;
        int size = b.size();
        for (int i = 0; i < size; i++) {
            SouvenirItem souvenirItem = (SouvenirItem) b.get(i);
            switch (1.a[souvenirItem.hw_().ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    loggingParameters.a++;
                    loggingParameters.e++;
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    loggingParameters.b++;
                    loggingParameters.e++;
                    break;
                case 3:
                    loggingParameters.c++;
                    int size2 = ((SouvenirBurstItem) souvenirItem).b().size();
                    loggingParameters.e += size2;
                    loggingParameters.f = size2 + loggingParameters.f;
                    break;
                default:
                    break;
            }
        }
        return loggingParameters;
    }

    private void m19616a(HoneyClientEvent honeyClientEvent) {
        if (!StringUtil.m3589a(this.f13320c)) {
            honeyClientEvent.f3102f = this.f13320c;
        }
        this.f13318a.mo526a((HoneyAnalyticsEvent) honeyClientEvent);
    }
}
