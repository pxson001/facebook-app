package com.facebook.search.typeahead.rows;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.typeahead.rows.nullstate.NullStateModuleGapPartDefinition;
import com.facebook.search.typeahead.rows.nullstate.NullStateModuleItemPartDefinition;
import com.facebook.search.typeahead.rows.nullstate.NullStateModuleSeeMorePartDefinition;
import com.facebook.search.typeahead.rows.nullstate.NullStateModuleTitlePartDefinition;
import com.google.common.collect.ImmutableList;
import javax.inject.Singleton;

@Singleton
/* compiled from: vault_db */
public class SearchTypeaheadRowsDeclaration implements FeedRowSupportDeclaration {
    private static final ImmutableList<ViewType> f609a = ImmutableList.of(UnsupportedSearchTypeaheadPartDefinition.f637a, SearchTypeaheadEntityPartDefinition.f511a, SearchTypeaheadSimpleEntityPartDefinition.f617a, SearchTypeaheadNeueTrendingEntityPartDefinition.f581a, SearchTypeaheadDividerPartDefinition.f468a, SearchTypeaheadQRCodePartDefinition.f598a, SearchTypeaheadHeaderPartDefinition.f533a, SearchTypeaheadRecentSeeMorePartDefinition.f601a, SearchTypeaheadNearbyPartDefinition.f577a, SearchTypeaheadNullStateSuggestionPartDefinition.f588a, SearchTypeaheadPlaceTipsPartDefinition.f594a, SearchTypeaheadFindMorePartDefinition.f521a, new ViewType[]{SearchTypeaheadKeywordPartDefinition.f556a, SearchTypeaheadSimpleKeywordPartDefinition.f622a, SearchTypeaheadShortcutPartDefinition.f613a, SearchTypeaheadEmptyScopedNullStateDefaultPartDefinition.f472a, SearchNeueTypeaheadPartDefinition.f449a, SearchTypeaheadHorizontalRecentPartDefinition.f551a, HScrollRecentSearchPagePartDefinition.f428a, HScrollSearchSpotlightCardPagePartDefinition.f433a, NullStateModuleItemPartDefinition.f660a, NullStateModuleItemPartDefinition.f660a, NullStateModuleSeeMorePartDefinition.f676a, NullStateModuleGapPartDefinition.f640a, NullStateModuleTitlePartDefinition.f684a, SearchTypeaheadGapPartDefinition.f527a});
    private static volatile SearchTypeaheadRowsDeclaration f610b;

    public static com.facebook.search.typeahead.rows.SearchTypeaheadRowsDeclaration m703a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f610b;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.search.typeahead.rows.SearchTypeaheadRowsDeclaration.class;
        monitor-enter(r1);
        r0 = f610b;	 Catch:{ all -> 0x0039 }
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
        r0 = m702a();	 Catch:{ all -> 0x0034 }
        f610b = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f610b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.typeahead.rows.SearchTypeaheadRowsDeclaration.a(com.facebook.inject.InjectorLike):com.facebook.search.typeahead.rows.SearchTypeaheadRowsDeclaration");
    }

    private static SearchTypeaheadRowsDeclaration m702a() {
        return new SearchTypeaheadRowsDeclaration();
    }

    public final void m704a(ListItemRowController listItemRowController) {
        int size = f609a.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) f609a.get(i));
        }
    }
}
