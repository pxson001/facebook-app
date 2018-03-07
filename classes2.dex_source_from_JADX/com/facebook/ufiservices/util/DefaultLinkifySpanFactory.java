package com.facebook.ufiservices.util;

import android.content.Context;
import android.text.style.CharacterStyle;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.feed.analytics.NewsfeedAnalyticsLogger;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view. */
public class DefaultLinkifySpanFactory {
    private static volatile DefaultLinkifySpanFactory f22500d;
    private final ContinueReadingSpanProvider f22501a;
    private final StoryContinueReadingSpanProvider f22502b;
    public final SeeTranslationSpan f22503c;

    public static com.facebook.ufiservices.util.DefaultLinkifySpanFactory m30356a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f22500d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.ufiservices.util.DefaultLinkifySpanFactory.class;
        monitor-enter(r1);
        r0 = f22500d;	 Catch:{ all -> 0x003a }
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
        r0 = m30357b(r0);	 Catch:{ all -> 0x0035 }
        f22500d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f22500d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ufiservices.util.DefaultLinkifySpanFactory.a(com.facebook.inject.InjectorLike):com.facebook.ufiservices.util.DefaultLinkifySpanFactory");
    }

    private static DefaultLinkifySpanFactory m30357b(InjectorLike injectorLike) {
        return new DefaultLinkifySpanFactory((ContinueReadingSpanProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ContinueReadingSpanProvider.class), (StoryContinueReadingSpanProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(StoryContinueReadingSpanProvider.class), new SeeTranslationSpan((Context) injectorLike.getInstance(Context.class, ForAppContext.class)));
    }

    @Inject
    public DefaultLinkifySpanFactory(ContinueReadingSpanProvider continueReadingSpanProvider, StoryContinueReadingSpanProvider storyContinueReadingSpanProvider, SeeTranslationSpan seeTranslationSpan) {
        this.f22501a = continueReadingSpanProvider;
        this.f22502b = storyContinueReadingSpanProvider;
        this.f22503c = seeTranslationSpan;
    }

    public final CharacterStyle m30359a(FeedProps<GraphQLStory> feedProps) {
        InjectorLike injectorLike = this.f22502b;
        return new StoryContinueReadingSpan((Context) injectorLike.getInstance(Context.class, ForAppContext.class), feedProps, DefaultSecureContextHelper.m4636a(injectorLike), DefaultFeedIntentBuilder.m26214a(injectorLike), DelegatingPerformanceLogger.m2803a(injectorLike), InteractionTTILogger.m4228a(injectorLike), CommonEventsBuilder.m14539b(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 137), NewsfeedAnalyticsLogger.m26299b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FeedEventBus.m4573a(injectorLike));
    }

    public final CharacterStyle m30358a(OnClickListener onClickListener) {
        return new ContinueReadingSpan((Context) this.f22501a.getInstance(Context.class, ForAppContext.class), onClickListener);
    }
}
