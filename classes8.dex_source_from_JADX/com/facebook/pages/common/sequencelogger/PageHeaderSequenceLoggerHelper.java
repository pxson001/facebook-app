package com.facebook.pages.common.sequencelogger;

import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.pages.common.abtest.qe.ExperimentsForPagesCommonAbTestModule;
import com.facebook.pages.common.constants.PagesPerfConstants.PageSequences;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: creative_platform */
public class PageHeaderSequenceLoggerHelper {
    private static final String[] f16587a = new String[]{"ContainerFragmentOnCreateToPageViewCreated", "ContainerFragmentOnCreateToPageAboutOnResume", "ContainerFragmentOnCreateToContextItemsRendered"};
    private static final String[] f16588b = new String[]{"TimeToSurfaceOnViewCreated", "TimeToSurfaceOnResume", "TimeToActionBarRendered"};
    private static final String[] f16589c = new String[]{"TimeToHeaderFuture", "TimeToLowResProfilePicUri", "TimeToProfilePicOnSubmit", "TimeToFetchPageHeaderDataFromServer", "TimeToFetchPageHeaderDataFromCache", "TimeToCoverPhotoOnSubmit", "TimeToCoverPhotoMinipreview", "TimeToProfilePhotoComplete", "TimeToCoverPhotoComplete"};
    private static volatile PageHeaderSequenceLoggerHelper f16590k;
    private final SequenceLogger f16591d;
    private final InteractionTTILogger f16592e;
    private final Product f16593f;
    private final MonotonicClock f16594g;
    private final QeAccessor f16595h;
    private final AbstractSequenceDefinition f16596i;
    private final AbstractSequenceDefinition f16597j;

    public static com.facebook.pages.common.sequencelogger.PageHeaderSequenceLoggerHelper m19613a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f16590k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.sequencelogger.PageHeaderSequenceLoggerHelper.class;
        monitor-enter(r1);
        r0 = f16590k;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m19615b(r0);	 Catch:{ all -> 0x0035 }
        f16590k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16590k;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.sequencelogger.PageHeaderSequenceLoggerHelper.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.sequencelogger.PageHeaderSequenceLoggerHelper");
    }

    private static PageHeaderSequenceLoggerHelper m19615b(InjectorLike injectorLike) {
        return new PageHeaderSequenceLoggerHelper((SequenceLogger) SequenceLoggerImpl.a(injectorLike), InteractionTTILogger.a(injectorLike), ProductMethodAutoProvider.b(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PageHeaderSequenceLoggerHelper(SequenceLogger sequenceLogger, InteractionTTILogger interactionTTILogger, Product product, MonotonicClock monotonicClock, QeAccessor qeAccessor) {
        this.f16591d = sequenceLogger;
        this.f16592e = interactionTTILogger;
        this.f16593f = product;
        this.f16594g = monotonicClock;
        this.f16595h = qeAccessor;
        if (this.f16593f == Product.PAA) {
            this.f16596i = PageSequences.f1715a;
            this.f16597j = null;
        } else if (this.f16595h.a(Liveness.Live, ExposureLogging.Off, ExperimentsForPagesCommonAbTestModule.f1672l, false)) {
            this.f16596i = PageSequences.f1719e;
            this.f16597j = PageSequences.f1717c;
        } else {
            this.f16596i = PageSequences.f1718d;
            this.f16597j = PageSequences.f1716b;
        }
    }

    public final PageHeaderSequenceLoggerHelper m19616a(String str) {
        if (str != null) {
            long now = this.f16594g.now();
            if (this.f16597j != null) {
                this.f16591d.a(this.f16597j, str, null, now);
            }
            this.f16591d.a(this.f16596i, str, null, now);
        }
        return this;
    }

    public final PageHeaderSequenceLoggerHelper m19619a(String str, boolean z, ImmutableMap<String, String> immutableMap) {
        if (str != null) {
            AbstractSequenceDefinition abstractSequenceDefinition = this.f16596i;
            if (this.f16593f != Product.PAA) {
                AbstractSequenceDefinition abstractSequenceDefinition2;
                if (z) {
                    abstractSequenceDefinition2 = this.f16597j;
                } else {
                    abstractSequenceDefinition2 = this.f16596i;
                    abstractSequenceDefinition = this.f16597j;
                }
                this.f16591d.a(abstractSequenceDefinition2, str);
            }
            this.f16591d.b(abstractSequenceDefinition, str, immutableMap, this.f16594g.now());
        }
        return this;
    }

    public final void m19620a(boolean z, @Nullable Map<String, String> map) {
        this.f16592e.a(z ? "LoadPageHeaderAdmin" : "LoadPageHeaderNonAdmin", null, map);
    }

    public final PageHeaderSequenceLoggerHelper m19621b(String str) {
        this.f16591d.a(this.f16596i, str);
        if (this.f16597j != null) {
            this.f16591d.a(this.f16597j, str);
        }
        return this;
    }

    public final PageHeaderSequenceLoggerHelper m19618a(String str, String str2, @Nullable ImmutableMap<String, String> immutableMap) {
        if (str2 != null) {
            Sequence b = this.f16591d.b(this.f16596i, str2);
            if (b != null) {
                SequenceLoggerDetour.a(b, str, null, immutableMap, -1579194655);
            }
            if (this.f16597j != null) {
                b = this.f16591d.b(this.f16597j, str2);
                if (b != null) {
                    SequenceLoggerDetour.a(b, str, null, immutableMap, 2009825039);
                }
            }
        }
        return this;
    }

    public final PageHeaderSequenceLoggerHelper m19623b(String str, String str2, @Nullable ImmutableMap<String, String> immutableMap) {
        return (str2 == null || m19626c(str, str2)) ? this : m19618a(str, str2, (ImmutableMap) immutableMap);
    }

    public final PageHeaderSequenceLoggerHelper m19624c(String str, String str2, @Nullable ImmutableMap<String, String> immutableMap) {
        if (str2 != null) {
            Sequence b = this.f16591d.b(this.f16596i, str2);
            if (b != null) {
                SequenceLoggerDetour.b(b, str, null, immutableMap, -165208556);
            }
            if (this.f16597j != null) {
                b = this.f16591d.b(this.f16597j, str2);
                if (b != null) {
                    SequenceLoggerDetour.b(b, str, null, immutableMap, -2018193864);
                }
            }
        }
        return this;
    }

    public final PageHeaderSequenceLoggerHelper m19628d(String str, String str2, @Nullable ImmutableMap<String, String> immutableMap) {
        return (str2 != null && m19626c(str, str2)) ? m19624c(str, str2, immutableMap) : this;
    }

    public final PageHeaderSequenceLoggerHelper m19617a(String str, String str2) {
        if (str2 != null) {
            Sequence b = this.f16591d.b(this.f16596i, str2);
            if (b != null) {
                SequenceLoggerDetour.d(b, str, -1219529494);
            }
            if (this.f16597j != null) {
                b = this.f16591d.b(this.f16597j, str2);
                if (b != null) {
                    SequenceLoggerDetour.d(b, str, -1934676205);
                }
            }
        }
        return this;
    }

    public final PageHeaderSequenceLoggerHelper m19622b(String str, String str2) {
        return (str2 != null && m19626c(str, str2)) ? m19617a(str, str2) : this;
    }

    public final boolean m19625c(String str) {
        if (this.f16591d.b(this.f16596i, str) != null) {
            return true;
        }
        if (this.f16597j == null || this.f16591d.b(this.f16597j, str) == null) {
            return false;
        }
        return true;
    }

    public final boolean m19626c(String str, String str2) {
        Sequence b = this.f16591d.b(this.f16596i, str2);
        if (b != null && b.f(str)) {
            return true;
        }
        if (this.f16597j != null) {
            b = this.f16591d.b(this.f16597j, str2);
            if (b != null && b.f(str)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public final PageHeaderSequenceLoggerHelper m19627d(String str) {
        m19614a(f16587a, str);
        m19614a(f16589c, str);
        return this;
    }

    public final PageHeaderSequenceLoggerHelper m19629e(String str) {
        m19614a(f16588b, str);
        m19614a(f16589c, str);
        return this;
    }

    private PageHeaderSequenceLoggerHelper m19614a(String[] strArr, String str) {
        Sequence b;
        Sequence b2 = this.f16591d.b(this.f16596i, str);
        if (this.f16597j != null) {
            b = this.f16591d.b(this.f16597j, str);
        } else {
            b = null;
        }
        int i = 0;
        while (strArr != null && i < strArr.length) {
            String str2 = strArr[i];
            if (b2 != null) {
                SequenceLoggerDetour.a(b2, str2, null, null, 1461476818);
            }
            if (b != null) {
                SequenceLoggerDetour.a(b, str2, null, null, -1149076490);
            }
            i++;
        }
        return this;
    }

    public final PageHeaderSequenceLoggerHelper m19630e(String str, String str2, @Nullable ImmutableMap<String, String> immutableMap) {
        Sequence b = this.f16591d.b(this.f16596i, str);
        if (b != null) {
            SequenceLoggerDetour.a(b, str2, immutableMap, this.f16594g.now(), 2056728394);
        }
        if (this.f16597j != null) {
            b = this.f16591d.b(this.f16597j, str);
            if (b != null) {
                SequenceLoggerDetour.a(b, str2, immutableMap, this.f16594g.now(), -299239330);
            }
        }
        return this;
    }
}
