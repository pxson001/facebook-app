package com.facebook.richdocument.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cdn.handler.CdnHeaderResponse;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.http.common.FbHttpRequestCancelTrigger;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.richdocument.fonts.FontResourceCache.FontResourceEntry;
import com.facebook.richdocument.fonts.FontResourceCache.FontResourceKey;
import com.facebook.ui.media.cache.MediaCacheKey;
import com.facebook.ui.media.fetch.DownloadResultResponseHandler;
import com.facebook.ui.media.fetch.MediaDownloadRequest;
import com.google.common.base.Throwables;
import com.google.common.io.Files;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.inject.Inject;

@ContextScoped
/* compiled from: preloadTime cannot be negative or Nan. */
public class FetchFontExecutor {
    public static final Class<?> f5238a = FetchFontExecutor.class;
    public static final Map<FontResourceKey, Boolean> f5239b = Collections.synchronizedMap(new HashMap());
    private static FetchFontExecutor f5240h;
    private static final Object f5241i = new Object();
    public final Lazy<ListeningExecutorService> f5242c;
    private final Lazy<FontsDownloader> f5243d;
    public final Lazy<FontResourceCache> f5244e;
    public final Lazy<FontCache> f5245f;
    public final Lazy<FbErrorReporter> f5246g;

    /* compiled from: preloadTime cannot be negative or Nan. */
    public class C06891 implements Callable<FontResourceEntry> {
        final /* synthetic */ FetchFontParams f5231a;
        final /* synthetic */ FontResourceKey f5232b;
        final /* synthetic */ FetchFontExecutor f5233c;

        public C06891(FetchFontExecutor fetchFontExecutor, FetchFontParams fetchFontParams, FontResourceKey fontResourceKey) {
            this.f5233c = fetchFontExecutor;
            this.f5231a = fetchFontParams;
            this.f5232b = fontResourceKey;
        }

        public Object call() {
            FontResourceEntry a = FetchFontExecutor.m5174a(this.f5233c, this.f5231a.f5247a, this.f5231a.f5248b, this.f5231a.f5249c);
            FontResourceCache fontResourceCache = (FontResourceCache) this.f5233c.f5244e.get();
            FontResourceEntry fontResourceEntry = (FontResourceEntry) fontResourceCache.f5264e.put(this.f5232b, a);
            ((FontResourceCache) this.f5233c.f5244e.get()).m5199a();
            return a;
        }
    }

    /* compiled from: preloadTime cannot be negative or Nan. */
    public class FontsResponseHandler implements DownloadResultResponseHandler<FontResourceEntry> {
        final /* synthetic */ FetchFontExecutor f5234a;
        public final String f5235b;
        public final String f5236c;
        private final FontResourceKey f5237d;

        FontsResponseHandler(FetchFontExecutor fetchFontExecutor, String str, String str2) {
            this.f5234a = fetchFontExecutor;
            this.f5235b = str;
            this.f5236c = str2;
            this.f5237d = new FontResourceKey(str, str2);
        }

        public final Object m5172a(InputStream inputStream, long j, CdnHeaderResponse cdnHeaderResponse) {
            InputStream zipInputStream = new ZipInputStream(new BufferedInputStream(inputStream));
            List arrayList = new ArrayList();
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    FetchFontExecutor.f5239b.remove(this.f5237d);
                    return new FontResourceEntry(this.f5235b, this.f5236c, arrayList);
                } else if (!nextEntry.isDirectory()) {
                    String b = Files.b(nextEntry.getName());
                    MediaCacheKey fontCacheKey = new FontCacheKey(this.f5235b, this.f5236c, b);
                    File file = ((FileBinaryResource) ((FontCache) this.f5234a.f5245f.get()).a(fontCacheKey, zipInputStream)).a;
                    if (file == null || !m5171a(file)) {
                        ((AbstractFbErrorReporter) this.f5234a.f5246g.get()).a(FetchFontExecutor.f5238a.getSimpleName(), "Invalid font file: " + fontCacheKey);
                    } else {
                        arrayList.add(b);
                    }
                    zipInputStream.closeEntry();
                }
            }
        }

        private static boolean m5171a(File file) {
            try {
                Typeface.createFromFile(file);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    private static FetchFontExecutor m5175b(InjectorLike injectorLike) {
        return new FetchFontExecutor(IdBasedSingletonScopeProvider.b(injectorLike, 3834), IdBasedLazy.a(injectorLike, 10306), IdBasedSingletonScopeProvider.b(injectorLike, 10305), IdBasedLazy.a(injectorLike, 10304), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public FetchFontExecutor(Lazy<ListeningExecutorService> lazy, Lazy<FontsDownloader> lazy2, Lazy<FontResourceCache> lazy3, Lazy<FontCache> lazy4, Lazy<FbErrorReporter> lazy5) {
        this.f5242c = lazy;
        this.f5243d = lazy2;
        this.f5244e = lazy3;
        this.f5245f = lazy4;
        this.f5246g = lazy5;
    }

    public static FetchFontExecutor m5173a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FetchFontExecutor b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5241i) {
                FetchFontExecutor fetchFontExecutor;
                if (a2 != null) {
                    fetchFontExecutor = (FetchFontExecutor) a2.a(f5241i);
                } else {
                    fetchFontExecutor = f5240h;
                }
                if (fetchFontExecutor == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m5175b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5241i, b3);
                        } else {
                            f5240h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fetchFontExecutor;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static FontResourceEntry m5174a(FetchFontExecutor fetchFontExecutor, String str, String str2, String str3) {
        try {
            return (FontResourceEntry) ((FontsDownloader) fetchFontExecutor.f5243d.get()).a(new MediaDownloadRequest(Uri.parse(str3), new FontsResponseHandler(fetchFontExecutor, str, str2), new FbHttpRequestCancelTrigger(), CallerContext.a(fetchFontExecutor.getClass())));
        } catch (Throwable e) {
            Throwable th = e;
            ((AbstractFbErrorReporter) fetchFontExecutor.f5246g.get()).a(f5238a.getSimpleName(), "Error in fetchFontResource: " + str3 + ", " + str + ", " + str2, th);
            throw Throwables.propagate(th);
        }
    }
}
