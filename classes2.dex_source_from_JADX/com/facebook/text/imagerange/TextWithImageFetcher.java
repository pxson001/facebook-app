package com.facebook.text.imagerange;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.images.fetch.FetchImageExecutor;
import com.facebook.ui.images.fetch.FetchImageParams;
import com.facebook.ui.images.fetch.FetchImageRequestBuilder;
import com.facebook.widget.text.FbImageSpan;
import com.facebook.widget.text.abtest.ExperimentsForWidgetTextAbTestModule;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: image */
public class TextWithImageFetcher {
    public static final Comparator<IconSpanDefinition> f20530a = new C08275();
    private static volatile TextWithImageFetcher f20531f;
    private final Context f20532b;
    public final AbstractFbErrorReporter f20533c;
    private final Lazy<FetchImageExecutor> f20534d;
    private final QeAccessor f20535e;

    /* compiled from: image */
    final class C08275 implements Comparator<IconSpanDefinition> {
        C08275() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((IconSpanDefinition) obj2).b.f22086a - ((IconSpanDefinition) obj).b.f22086a;
        }
    }

    public static com.facebook.text.imagerange.TextWithImageFetcher m28266a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f20531f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.text.imagerange.TextWithImageFetcher.class;
        monitor-enter(r1);
        r0 = f20531f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m28267b(r0);	 Catch:{ all -> 0x0035 }
        f20531f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20531f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.text.imagerange.TextWithImageFetcher.a(com.facebook.inject.InjectorLike):com.facebook.text.imagerange.TextWithImageFetcher");
    }

    private static TextWithImageFetcher m28267b(InjectorLike injectorLike) {
        return new TextWithImageFetcher((Context) injectorLike.getInstance(Context.class), FbErrorReporterImpl.m2317a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3566));
    }

    @Inject
    public TextWithImageFetcher(Context context, FbErrorReporter fbErrorReporter, QeAccessor qeAccessor, Lazy<FetchImageExecutor> lazy) {
        this.f20532b = context;
        this.f20533c = fbErrorReporter;
        this.f20535e = qeAccessor;
        this.f20534d = lazy;
    }

    public final ListenableFuture<IconSpanDefinition> m28268a(UTF16Range uTF16Range, Uri uri) {
        ListenableFuture a = ((FetchImageExecutor) this.f20534d.get()).a(new FetchImageRequestBuilder(FetchImageParams.a(uri).a()).a(CallerContext.m9060a(getClass())).g());
        Futures.m2458a(a, new 1(this, uri), MoreExecutors.m1813a());
        return Futures.m2450a(a, new 2(this, uTF16Range), MoreExecutors.m1813a());
    }

    public final ListenableFuture<CharSequence> m28269a(CharSequence charSequence, List<ListenableFuture<IconSpanDefinition>> list, float f, int i) {
        return Futures.m2450a(Futures.m2462b((Iterable) list), new 3(this, charSequence, f, i), MoreExecutors.m1813a());
    }

    public final CharSequence m28270a(CharSequence charSequence, UTF16Range uTF16Range, Bitmap bitmap, float f, int i) {
        Object fbImageSpan;
        CharSequence spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.insert(uTF16Range.f22086a, " ");
        spannableStringBuilder.insert(uTF16Range.f22086a, "‌");
        float height = (f / ((float) bitmap.getHeight())) * ((float) bitmap.getWidth());
        Drawable bitmapDrawable = new BitmapDrawable(this.f20532b.getResources(), bitmap);
        bitmapDrawable.setBounds(0, 0, (int) height, (int) f);
        if (this.f20535e.mo596a(ExperimentsForWidgetTextAbTestModule.f21793a, false)) {
            int i2;
            switch (i) {
                case 0:
                    i2 = 0;
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    i2 = 2;
                    break;
                default:
                    i2 = 1;
                    break;
            }
            fbImageSpan = new FbImageSpan(bitmapDrawable, i2);
        } else {
            fbImageSpan = new ImageSpan(bitmapDrawable, i);
        }
        spannableStringBuilder.setSpan(fbImageSpan, uTF16Range.f22086a, uTF16Range.m29947c() + 1, 33);
        return spannableStringBuilder;
    }
}
