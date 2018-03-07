package com.facebook.feed.util.injection;

import com.fasterxml.jackson.core.JsonParser;
import java.io.File;

/* compiled from: meme_busting_sentry_warning_cancel */
class InjectedFeedStoryHolder$2 implements InjectedFeedStoryHolder$ThrowingRunnable {
    final /* synthetic */ File f10435a;
    final /* synthetic */ InjectedFeedStoryHolder f10436b;

    InjectedFeedStoryHolder$2(InjectedFeedStoryHolder injectedFeedStoryHolder, File file) {
        this.f10436b = injectedFeedStoryHolder;
        this.f10435a = file;
    }

    public final void mo1041a() {
        JsonParser jsonParser = null;
        try {
            jsonParser = this.f10436b.a.a(this.f10435a);
            InjectedFeedStoryHolder.a(this.f10436b, jsonParser);
        } finally {
            if (jsonParser != null) {
                jsonParser.close();
            }
        }
    }
}
