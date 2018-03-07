package com.facebook.composer.minutiae.analytics;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.typeahead.TypeaheadInteractionsEventBuilder;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbModelEdge;
import com.facebook.graphql.enums.GraphQLTaggableActivitySuggestionMechanism;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: topTouchStart */
public class ActivityPickerAnalyticsLogger {
    private static volatile ActivityPickerAnalyticsLogger f1459b;
    public final AnalyticsLogger f1460a;

    public static com.facebook.composer.minutiae.analytics.ActivityPickerAnalyticsLogger m1538a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1459b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.minutiae.analytics.ActivityPickerAnalyticsLogger.class;
        monitor-enter(r1);
        r0 = f1459b;	 Catch:{ all -> 0x003a }
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
        r0 = m1539b(r0);	 Catch:{ all -> 0x0035 }
        f1459b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1459b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.minutiae.analytics.ActivityPickerAnalyticsLogger.a(com.facebook.inject.InjectorLike):com.facebook.composer.minutiae.analytics.ActivityPickerAnalyticsLogger");
    }

    private static ActivityPickerAnalyticsLogger m1539b(InjectorLike injectorLike) {
        return new ActivityPickerAnalyticsLogger(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ActivityPickerAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.f1460a = analyticsLogger;
    }

    public final void m1541a(String str, MinutiaeVerbModelEdge minutiaeVerbModelEdge, int i, int i2, String str2) {
        this.f1460a.a(m1540f("activity_picker_verb_selected", str).a(minutiaeVerbModelEdge.f1703a.l()).g(minutiaeVerbModelEdge.f1704b).c(i).a(i2).d(str2).a);
    }

    public final void m1544a(String str, String str2, String str3, int i, ImmutableList<String> immutableList, int i2, int i3, String str4, String str5, String str6, String str7) {
        this.f1460a.a(m1540f("activity_picker_object_selected", str).a(str2).b(str3).a(i).a(immutableList).b(i2).c(i3).c(str4).d(str5).e(str6).g(str7).a);
    }

    public final void m1543a(String str, String str2, GraphQLTaggableActivitySuggestionMechanism graphQLTaggableActivitySuggestionMechanism, int i) {
        TypeaheadInteractionsEventBuilder c = m1540f("activity_picker_suggestion_tapped", str).a(str2).c(i);
        c.a.b("suggestion_mechanism", graphQLTaggableActivitySuggestionMechanism.name());
        this.f1460a.a(c.a);
    }

    public final void m1542a(String str, String str2, int i, ImmutableList<String> immutableList, int i2, String str3, String str4, String str5) {
        this.f1460a.a(m1540f("activity_picker_tapped_back", str).a(str2).a(i).a(immutableList).b(i2).c(str3).d(str4).e(str5).a);
    }

    public static TypeaheadInteractionsEventBuilder m1540f(String str, String str2) {
        return new TypeaheadInteractionsEventBuilder(str, str2, "activity_tag_picker");
    }

    public final void m1545d(String str, String str2) {
        this.f1460a.a(m1540f("minutiae_reshare_nux_qe_exposure", str).f(str2).a);
    }
}
