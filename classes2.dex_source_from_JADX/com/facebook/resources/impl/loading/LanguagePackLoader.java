package com.facebook.resources.impl.loading;

import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.resources.impl.model.StringResources;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.io.InputStream;
import javax.inject.Inject;

/* compiled from: thread_priority */
public class LanguagePackLoader {
    private final Lazy<ListeningExecutorService> f3046a;
    public final FlattenedStringResourcesParser f3047b;
    public final Delegate f3048c;
    public final LanguageRequest f3049d;

    /* compiled from: thread_priority */
    public interface Delegate {
        @VisibleForTesting
        InputStream mo691a(LanguageRequest languageRequest);

        @VisibleForTesting
        void mo692a();

        @VisibleForTesting
        void mo693b();

        @VisibleForTesting
        void mo694b(LanguageRequest languageRequest);

        @VisibleForTesting
        void mo695c();
    }

    @Inject
    public LanguagePackLoader(Lazy<ListeningExecutorService> lazy, FlattenedStringResourcesParser flattenedStringResourcesParser, @Assisted LanguageRequest languageRequest, @Assisted Delegate delegate) {
        this.f3046a = lazy;
        this.f3047b = flattenedStringResourcesParser;
        this.f3049d = languageRequest;
        this.f3048c = delegate;
    }

    public final ListenableFuture<StringResources> m5042a() {
        final ListenableFuture f = SettableFuture.m1547f();
        ((ListeningExecutorService) this.f3046a.get()).mo269a(new Runnable(this) {
            final /* synthetic */ LanguagePackLoader f3052b;

            public void run() {
                try {
                    InputStream a = this.f3052b.f3048c.mo691a(this.f3052b.f3049d);
                    try {
                        this.f3052b.f3048c.mo692a();
                        StringResources a2 = this.f3052b.f3047b.m5050a(a);
                        this.f3052b.f3048c.mo693b();
                        a.close();
                        FutureDetour.a(f, a2, -1982358561);
                    } catch (Exception e) {
                        this.f3052b.f3048c.mo695c();
                        throw e;
                    } catch (Throwable th) {
                        a.close();
                    }
                } catch (Throwable e2) {
                    f.mo222a(e2);
                    this.f3052b.f3048c.mo694b(this.f3052b.f3049d);
                }
            }
        });
        return f;
    }
}
