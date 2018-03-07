package com.facebook.search.model.visitor;

import com.facebook.search.model.EntityTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.NearbyTypeaheadUnit;
import com.facebook.search.model.NullStateModuleSuggestionUnit;
import com.facebook.search.model.NullStateSeeMoreTypeaheadUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.PlaceTipsTypeaheadUnit;
import com.facebook.search.model.SeeMoreResultPageUnit;
import com.facebook.search.model.SeeMoreTypeaheadUnit;
import com.facebook.search.model.ShortcutTypeaheadUnit;
import com.facebook.search.model.TrendingTypeaheadUnit;
import com.facebook.search.model.TypeaheadSuggestionVisitorWithReturn;
import javax.inject.Singleton;

@Singleton
/* compiled from: TEXT_TITLE */
public class GetTitleOfTypeaheadSuggestionVisitor extends TypeaheadSuggestionVisitorWithReturn<String> {
    private static volatile GetTitleOfTypeaheadSuggestionVisitor f22331a;

    public static com.facebook.search.model.visitor.GetTitleOfTypeaheadSuggestionVisitor m25815a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f22331a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.model.visitor.GetTitleOfTypeaheadSuggestionVisitor.class;
        monitor-enter(r1);
        r0 = f22331a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m25814a();	 Catch:{ all -> 0x0034 }
        f22331a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f22331a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.model.visitor.GetTitleOfTypeaheadSuggestionVisitor.a(com.facebook.inject.InjectorLike):com.facebook.search.model.visitor.GetTitleOfTypeaheadSuggestionVisitor");
    }

    private static GetTitleOfTypeaheadSuggestionVisitor m25814a() {
        return new GetTitleOfTypeaheadSuggestionVisitor();
    }

    public final Object mo1230a(PlaceTipsTypeaheadUnit placeTipsTypeaheadUnit) {
        return placeTipsTypeaheadUnit.f22245a.m3694h();
    }

    public final Object mo1233a(ShortcutTypeaheadUnit shortcutTypeaheadUnit) {
        return shortcutTypeaheadUnit.f22276b;
    }

    public final Object mo1225a(KeywordTypeaheadUnit keywordTypeaheadUnit) {
        return keywordTypeaheadUnit.mo1211a();
    }

    public final Object mo1229a(NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit) {
        return nullStateSuggestionTypeaheadUnit.f22235b;
    }

    public final Object mo1231a(SeeMoreResultPageUnit seeMoreResultPageUnit) {
        return seeMoreResultPageUnit.f22265a.f22046b;
    }

    public final Object mo1226a(NearbyTypeaheadUnit nearbyTypeaheadUnit) {
        return nearbyTypeaheadUnit.f22157b;
    }

    public final Object mo1228a(NullStateSeeMoreTypeaheadUnit nullStateSeeMoreTypeaheadUnit) {
        return "[See More] " + nullStateSeeMoreTypeaheadUnit.k().toString();
    }

    public final Object mo1232a(SeeMoreTypeaheadUnit seeMoreTypeaheadUnit) {
        return "[See More] " + seeMoreTypeaheadUnit.toString();
    }

    public final Object mo1234a(TrendingTypeaheadUnit trendingTypeaheadUnit) {
        return trendingTypeaheadUnit.f22296b;
    }

    public final Object mo1224a(EntityTypeaheadUnit entityTypeaheadUnit) {
        return entityTypeaheadUnit.f22046b;
    }

    public final Object mo1227a(NullStateModuleSuggestionUnit nullStateModuleSuggestionUnit) {
        return nullStateModuleSuggestionUnit.f22216i;
    }
}
