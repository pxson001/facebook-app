package com.facebook.feedplugins.highlighter;

import android.text.Spannable;
import android.text.SpannableString;
import com.facebook.feedplugins.searchresult.MatchWordsHighlighter;
import com.facebook.graphql.model.GraphQLGraphSearchResultDecoration;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: image_high_height */
public class FeedHighlighter {
    private static volatile FeedHighlighter f20450b;
    private final MatchWordsHighlighter f20451a;

    public static com.facebook.feedplugins.highlighter.FeedHighlighter m28184a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20450b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.highlighter.FeedHighlighter.class;
        monitor-enter(r1);
        r0 = f20450b;	 Catch:{ all -> 0x003a }
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
        r0 = m28186b(r0);	 Catch:{ all -> 0x0035 }
        f20450b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20450b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.highlighter.FeedHighlighter.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.highlighter.FeedHighlighter");
    }

    private static FeedHighlighter m28186b(InjectorLike injectorLike) {
        return new FeedHighlighter(MatchWordsHighlighter.m28189a(injectorLike));
    }

    @Inject
    public FeedHighlighter(MatchWordsHighlighter matchWordsHighlighter) {
        this.f20451a = matchWordsHighlighter;
    }

    public static boolean m28185a(@Nullable GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return false;
        }
        GraphQLGraphSearchResultDecoration i = PropertyHelper.m21307i(graphQLStory);
        ImmutableList m = i != null ? i.m() : null;
        if (m == null || m.isEmpty()) {
            return false;
        }
        return true;
    }

    @Nullable
    public final CharSequence m28187a(GraphQLStory graphQLStory, @Nullable CharSequence charSequence) {
        GraphQLGraphSearchResultDecoration i = PropertyHelper.m21307i(graphQLStory);
        ImmutableList m = i != null ? i.m() : null;
        if (!(m == null || charSequence == null)) {
            charSequence = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
            this.f20451a.m28191a(m, charSequence);
        }
        return charSequence;
    }

    public final void m28188a(GraphQLStory graphQLStory, @Nullable Spannable spannable) {
        GraphQLGraphSearchResultDecoration i = PropertyHelper.m21307i(graphQLStory);
        ImmutableList m = i != null ? i.m() : null;
        if (m != null && spannable != null) {
            this.f20451a.m28191a(m, spannable);
        }
    }
}
