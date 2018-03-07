package com.facebook.saved.common.data;

import android.support.annotation.StringRes;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetch_after_comments_ */
public class SavedSectionResources {
    public static final SavedSectionResource f14411a = new SavedSectionResource(2130843234, 2131238121, 2131238133);
    private static final String f14412b = SavedSectionResources.class.getSimpleName();
    private static volatile SavedSectionResources f14413g;
    private final ImmutableMap<GraphQLSavedDashboardSectionType, SavedSectionResource> f14414c = new Builder().b(GraphQLSavedDashboardSectionType.ALL, new SavedSectionResource(2130843230, 2131238121, 2131238133)).b(GraphQLSavedDashboardSectionType.ARCHIVED, new SavedSectionResource(2130843231, 2131238132, 2131238144)).b(GraphQLSavedDashboardSectionType.BOOKS, new SavedSectionResource(2130843232, 2131238127, 2131238139)).b(GraphQLSavedDashboardSectionType.EVENTS, new SavedSectionResource(2130843233, 2131238130, 2131238142)).b(GraphQLSavedDashboardSectionType.LINKS, new SavedSectionResource(2130843234, 2131238122, 2131238134)).b(GraphQLSavedDashboardSectionType.MOVIES, new SavedSectionResource(2130843235, 2131238128, 2131238140)).b(GraphQLSavedDashboardSectionType.MUSIC, new SavedSectionResource(2130843236, 2131238126, 2131238138)).b(GraphQLSavedDashboardSectionType.PLACES, new SavedSectionResource(2130843238, 2131238125, 2131238137)).b(GraphQLSavedDashboardSectionType.TV_SHOWS, new SavedSectionResource(2130843239, 2131238129, 2131238141)).b(GraphQLSavedDashboardSectionType.VIDEOS, new SavedSectionResource(2130843240, 2131238131, 2131238143)).b(GraphQLSavedDashboardSectionType.PHOTOS, new SavedSectionResource(2130843237, 2131238124, 2131238136)).b(GraphQLSavedDashboardSectionType.PRODUCTS, new SavedSectionResource(2130840054, 2131238123, 2131238135)).b();
    private final AbstractFbErrorReporter f14415d;
    private final GatekeeperStoreImpl f14416e;
    private ImmutableList<SavedDashboardSection> f14417f;

    /* compiled from: fetch_after_comments_ */
    public class SavedSectionResource {
        public final int f14408a;
        public final int f14409b;
        public final int f14410c;

        public SavedSectionResource(int i, int i2, int i3) {
            this.f14408a = i;
            this.f14409b = i2;
            this.f14410c = i3;
        }
    }

    public static com.facebook.saved.common.data.SavedSectionResources m18288a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14413g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.saved.common.data.SavedSectionResources.class;
        monitor-enter(r1);
        r0 = f14413g;	 Catch:{ all -> 0x003a }
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
        r0 = m18289b(r0);	 Catch:{ all -> 0x0035 }
        f14413g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14413g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved.common.data.SavedSectionResources.a(com.facebook.inject.InjectorLike):com.facebook.saved.common.data.SavedSectionResources");
    }

    private static SavedSectionResources m18289b(InjectorLike injectorLike) {
        return new SavedSectionResources((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SavedSectionResources(AbstractFbErrorReporter abstractFbErrorReporter, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f14415d = abstractFbErrorReporter;
        this.f14416e = gatekeeperStoreImpl;
    }

    public final ImmutableList<SavedDashboardSection> m18291a() {
        if (this.f14417f == null) {
            ImmutableList.Builder c = new ImmutableList.Builder().c(new SavedDashboardSection(GraphQLSavedDashboardSectionType.ALL, 2131238145)).c(new SavedDashboardSection(GraphQLSavedDashboardSectionType.LINKS, 2131238146)).c(new SavedDashboardSection(GraphQLSavedDashboardSectionType.VIDEOS, 2131238155));
            if (this.f14416e.a(1112, false)) {
                c.c(new SavedDashboardSection(GraphQLSavedDashboardSectionType.PRODUCTS, 2131238147));
            }
            if (this.f14416e.a(1111, false)) {
                c.c(new SavedDashboardSection(GraphQLSavedDashboardSectionType.PHOTOS, 2131238148));
            }
            c.c(new SavedDashboardSection(GraphQLSavedDashboardSectionType.PLACES, 2131238149)).c(new SavedDashboardSection(GraphQLSavedDashboardSectionType.MUSIC, 2131238150)).c(new SavedDashboardSection(GraphQLSavedDashboardSectionType.BOOKS, 2131238151)).c(new SavedDashboardSection(GraphQLSavedDashboardSectionType.MOVIES, 2131238152)).c(new SavedDashboardSection(GraphQLSavedDashboardSectionType.TV_SHOWS, 2131238153)).c(new SavedDashboardSection(GraphQLSavedDashboardSectionType.EVENTS, 2131238154)).c(new SavedDashboardSection(GraphQLSavedDashboardSectionType.ARCHIVED, 2131238156));
            this.f14417f = c.b();
        }
        return this.f14417f;
    }

    @StringRes
    public static int m18287a(String str, int i) {
        Object obj = -1;
        switch (str.hashCode()) {
            case -2113236743:
                if (str.equals("TV_SHOWS")) {
                    obj = 9;
                    break;
                }
                break;
            case -2014930109:
                if (str.equals("MOVIES")) {
                    obj = 8;
                    break;
                }
                break;
            case -1935704959:
                if (str.equals("PHOTOS")) {
                    obj = 4;
                    break;
                }
                break;
            case -1932444596:
                if (str.equals("PLACES")) {
                    obj = 5;
                    break;
                }
                break;
            case -1763348648:
                if (str.equals("VIDEOS")) {
                    obj = 2;
                    break;
                }
                break;
            case -933681182:
                if (str.equals("ARCHIVED")) {
                    obj = 11;
                    break;
                }
                break;
            case -221134492:
                if (str.equals("PRODUCTS")) {
                    obj = 3;
                    break;
                }
                break;
            case 64897:
                if (str.equals("ALL")) {
                    obj = null;
                    break;
                }
                break;
            case 63384202:
                if (str.equals("BOOKS")) {
                    obj = 7;
                    break;
                }
                break;
            case 72439705:
                if (str.equals("LINKS")) {
                    obj = 1;
                    break;
                }
                break;
            case 73725445:
                if (str.equals("MUSIC")) {
                    obj = 6;
                    break;
                }
                break;
            case 2056967449:
                if (str.equals("EVENTS")) {
                    obj = 10;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return 2131238145;
            case 1:
                return 2131238146;
            case 2:
                return 2131238155;
            case 3:
                return 2131238147;
            case 4:
                return 2131238148;
            case 5:
                return 2131238149;
            case 6:
                return 2131238150;
            case 7:
                return 2131238151;
            case 8:
                return 2131238152;
            case 9:
                return 2131238153;
            case 10:
                return 2131238154;
            case 11:
                return 2131238156;
            default:
                BLog.c(f14412b, "Unsupported section type: " + str);
                return i;
        }
    }

    public final Optional<SavedSectionResource> m18290a(GraphQLSavedDashboardSectionType graphQLSavedDashboardSectionType) {
        SavedSectionResource savedSectionResource = (SavedSectionResource) this.f14414c.get(graphQLSavedDashboardSectionType);
        if (savedSectionResource != null) {
            return Optional.of(savedSectionResource);
        }
        this.f14415d.a(f14412b, "Unsupported section type: " + graphQLSavedDashboardSectionType);
        return Absent.INSTANCE;
    }
}
