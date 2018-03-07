package com.facebook.saved.helper;

import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.inject.InjectorLike;
import com.facebook.saved.common.data.SavedDashboardSection;
import com.facebook.saved.common.data.SavedSectionResources;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: invite_friends_banner_dismiss */
public class SavedSectionHelper {
    private static volatile SavedSectionHelper f9174b;
    private final SavedSectionResources f9175a;

    public static com.facebook.saved.helper.SavedSectionHelper m9180a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9174b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.saved.helper.SavedSectionHelper.class;
        monitor-enter(r1);
        r0 = f9174b;	 Catch:{ all -> 0x003a }
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
        r0 = m9182b(r0);	 Catch:{ all -> 0x0035 }
        f9174b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9174b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved.helper.SavedSectionHelper.a(com.facebook.inject.InjectorLike):com.facebook.saved.helper.SavedSectionHelper");
    }

    private static SavedSectionHelper m9182b(InjectorLike injectorLike) {
        return new SavedSectionHelper(SavedSectionResources.a(injectorLike));
    }

    @Inject
    public SavedSectionHelper(SavedSectionResources savedSectionResources) {
        this.f9175a = savedSectionResources;
    }

    public static Optional<GraphQLSavedDashboardSectionType> m9181a(Optional<SavedDashboardSection> optional) {
        if (optional.isPresent()) {
            return Optional.fromNullable(((SavedDashboardSection) optional.get()).a);
        }
        return Absent.INSTANCE;
    }

    public static GraphQLSavedDashboardSectionType m9179a(@Nullable String str) {
        GraphQLSavedDashboardSectionType fromString = GraphQLSavedDashboardSectionType.fromString(str);
        if (fromString == null || fromString == GraphQLSavedDashboardSectionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return GraphQLSavedDashboardSectionType.ALL;
        }
        return fromString;
    }

    public final Optional<SavedDashboardSection> m9183a(@Nullable GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType) {
        ImmutableList a = this.f9175a.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            SavedDashboardSection savedDashboardSection = (SavedDashboardSection) a.get(i);
            Optional a2 = m9181a(Optional.of(savedDashboardSection));
            if (a2.isPresent() && graphQLSavedDashboardSectionType == a2.get()) {
                return Optional.of(savedDashboardSection);
            }
        }
        return Absent.INSTANCE;
    }
}
