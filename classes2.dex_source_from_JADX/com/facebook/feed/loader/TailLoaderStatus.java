package com.facebook.feed.loader;

import com.facebook.feed.logging.bugreport.NewsFeedEventLogger;
import com.facebook.feed.logging.bugreport.NewsFeedEventLogger.Event;
import com.google.common.base.Preconditions;

/* compiled from: selfupdate_download_success_file_uri */
public class TailLoaderStatus {
    private Type f5728a = Type.NOT_LOADING;
    private final NewsFeedEventLogger f5729b;

    /* compiled from: selfupdate_download_success_file_uri */
    enum Type {
        NOT_LOADING,
        LOADING
    }

    public TailLoaderStatus(NewsFeedEventLogger newsFeedEventLogger) {
        this.f5729b = newsFeedEventLogger;
    }

    private void m9866a(Type type) {
        this.f5729b.m4411a("TailLoaderStatus", Event.STATUS_CHANGED, type.toString());
        this.f5728a = type;
    }

    public final void m9867a() {
        m9866a(Type.NOT_LOADING);
    }

    public final void m9868b() {
        Preconditions.checkState(this.f5728a == Type.NOT_LOADING);
        m9866a(Type.LOADING);
    }

    public final boolean m9869c() {
        return this.f5728a == Type.LOADING;
    }
}
