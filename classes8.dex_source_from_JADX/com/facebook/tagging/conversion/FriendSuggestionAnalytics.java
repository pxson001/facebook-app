package com.facebook.tagging.conversion;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.GroupTagToken;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: max_word_kerning */
public class FriendSuggestionAnalytics {
    private static volatile FriendSuggestionAnalytics f9046b;
    public final AnalyticsLogger f9047a;

    public static com.facebook.tagging.conversion.FriendSuggestionAnalytics m10804a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9046b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.tagging.conversion.FriendSuggestionAnalytics.class;
        monitor-enter(r1);
        r0 = f9046b;	 Catch:{ all -> 0x003a }
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
        r0 = m10807b(r0);	 Catch:{ all -> 0x0035 }
        f9046b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9046b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.tagging.conversion.FriendSuggestionAnalytics.a(com.facebook.inject.InjectorLike):com.facebook.tagging.conversion.FriendSuggestionAnalytics");
    }

    private static FriendSuggestionAnalytics m10807b(InjectorLike injectorLike) {
        return new FriendSuggestionAnalytics(AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendSuggestionAnalytics(AnalyticsLogger analyticsLogger) {
        this.f9047a = analyticsLogger;
    }

    public final void m10808a(ArrayList<BaseToken> arrayList, String str, boolean z, boolean z2, boolean z3, @Nullable String str2) {
        this.f9047a.c(m10803a("friend_suggestions_cancel", (ArrayList) arrayList, str, z, z2, z3, str2));
    }

    public final void m10809a(ArrayList<BaseToken> arrayList, String str, boolean z, boolean z2, boolean z3, @Nullable List<GroupTagToken> list, @Nullable String str2) {
        this.f9047a.c(m10803a("friend_suggestions_done", (ArrayList) arrayList, str, z, z2, z3, str2));
        if (list != null && !list.isEmpty()) {
            m10806a((List) arrayList, (List) list, str2);
        }
    }

    private void m10806a(List<BaseToken> list, List<GroupTagToken> list2, @Nullable String str) {
        String str2 = ((GroupTagToken) list2.get(0)).f;
        ArrayNode b = JsonNodeFactory.a.b();
        for (int i = 0; i < list2.size(); i++) {
            if (list.contains(list2.get(i))) {
                b.c(i);
            }
        }
        if (b.e() > 0) {
            this.f9047a.a(m10802a("group_tag_suggestions_selected", str2, str).a("indices_selected", b));
        } else {
            this.f9047a.a(m10802a("group_tag_suggestions_not_selected", str2, str));
        }
    }

    public static HoneyClientEvent m10802a(String str, String str2, @Nullable String str3) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f = str3;
        return honeyClientEvent.b("suggestion_source", str2);
    }

    private static ArrayNode m10805a(List<BaseToken> list) {
        ArrayNode b = JsonNodeFactory.a.b();
        for (BaseToken baseToken : list) {
            if (baseToken instanceof SuggestionToken) {
                b.b(((SuggestionToken) baseToken).f9113g);
            } else if (baseToken instanceof SimpleUserToken) {
                b.b(Long.parseLong(((SimpleUserToken) baseToken).p()));
            }
        }
        return b;
    }

    private static HoneyClientEvent m10803a(String str, ArrayList<BaseToken> arrayList, String str2, boolean z, boolean z2, boolean z3, String str3) {
        Preconditions.checkNotNull(arrayList);
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(str);
        honeyClientEvent.f = str3;
        return honeyClientEvent.b("tracking_id", str2).a("is_place_to_people", z).a("has_initially_tagged_friends", z2).a("has_faces", z3).a("selected_friends", m10805a((List) arrayList));
    }
}
