package com.facebook.feedplugins.searchresult;

import android.content.res.Resources;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: image_file */
public class MatchWordsHighlighter {
    private static volatile MatchWordsHighlighter f20452b;
    public final int f20453a;

    public static com.facebook.feedplugins.searchresult.MatchWordsHighlighter m28189a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20452b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.searchresult.MatchWordsHighlighter.class;
        monitor-enter(r1);
        r0 = f20452b;	 Catch:{ all -> 0x003a }
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
        r0 = m28190b(r0);	 Catch:{ all -> 0x0035 }
        f20452b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20452b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.searchresult.MatchWordsHighlighter.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.searchresult.MatchWordsHighlighter");
    }

    private static MatchWordsHighlighter m28190b(InjectorLike injectorLike) {
        return new MatchWordsHighlighter(ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public MatchWordsHighlighter(Resources resources) {
        this.f20453a = resources.getColor(2131363069);
    }

    public final void m28191a(ImmutableList<String> immutableList, Spannable spannable) {
        Pattern compile = Pattern.compile("[.^|$?*+!\\[\\](){}\\\\]");
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Matcher matcher = Pattern.compile("(?i)(" + compile.matcher((String) immutableList.get(i)).replaceAll("\\\\$0") + ")").matcher(spannable);
            while (matcher.find()) {
                spannable.setSpan(new BackgroundColorSpan(this.f20453a), matcher.start(), matcher.end(), 18);
            }
        }
    }
}
