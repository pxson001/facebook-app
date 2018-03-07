package com.facebook.feed.loader;

import com.facebook.api.feed.data.FetchPortion;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event;
import com.google.common.base.Preconditions;

/* compiled from: selfupdate_download_validation_failure */
public class HeadLoaderStatus {
    public Type f5724a = Type.NOT_LOADING;
    private final NewsFeedEventLogger f5725b;
    public FeedLoaderParams f5726c;
    private FetchPortion f5727d = FetchPortion.FULL;

    /* compiled from: selfupdate_download_validation_failure */
    public enum Type {
        NOT_LOADING,
        LOADING_FOR_UI,
        LOADING_FOR_BACKGROUND
    }

    public HeadLoaderStatus(NewsFeedEventLogger newsFeedEventLogger) {
        this.f5725b = newsFeedEventLogger;
    }

    private void m9857a(Type type) {
        this.f5725b.m4411a("HeadLoaderStatus", Event.STATUS_CHANGED, type.toString());
        this.f5724a = type;
    }

    public final void m9859b() {
        m9857a(Type.NOT_LOADING);
    }

    public final void m9860c() {
        Preconditions.checkState(this.f5724a != Type.LOADING_FOR_UI);
        m9857a(Type.LOADING_FOR_UI);
        this.f5727d = FetchPortion.CHUNKED_INITIAL;
    }

    public final void m9861d() {
        Preconditions.checkState(this.f5724a == Type.NOT_LOADING);
        m9857a(Type.LOADING_FOR_BACKGROUND);
        this.f5727d = FetchPortion.FULL;
    }

    public final boolean m9862e() {
        return this.f5724a != Type.NOT_LOADING;
    }

    public final void m9863f() {
        Preconditions.checkState(m9862e());
        m9857a(Type.NOT_LOADING);
    }

    public final void m9864g() {
        Preconditions.checkState(this.f5724a != Type.NOT_LOADING);
        m9857a(Type.NOT_LOADING);
    }

    public final void m9858a(FetchPortion fetchPortion) {
        this.f5727d = fetchPortion;
    }

    public final FetchPortion m9865i() {
        return this.f5727d;
    }
}
