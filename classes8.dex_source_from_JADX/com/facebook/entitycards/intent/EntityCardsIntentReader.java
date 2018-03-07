package com.facebook.entitycards.intent;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.facebook.entitycards.surface.EntityCardsSurfaceConfiguration;
import com.facebook.entitycards.surface.STATICDI_MULTIBIND_PROVIDER$EntityCardsSurfaceConfiguration;
import com.facebook.entitycardsplugins.person.surface.BasePersonCardsSurfaceConfiguration;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: image_landscape_width */
public class EntityCardsIntentReader {
    private static volatile EntityCardsIntentReader f10990c;
    private final EntityCardsLauncherCache f10991a;
    private final Set<EntityCardsSurfaceConfiguration> f10992b;

    public static com.facebook.entitycards.intent.EntityCardsIntentReader m12924a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10990c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.entitycards.intent.EntityCardsIntentReader.class;
        monitor-enter(r1);
        r0 = f10990c;	 Catch:{ all -> 0x003a }
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
        r0 = m12926b(r0);	 Catch:{ all -> 0x0035 }
        f10990c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10990c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.entitycards.intent.EntityCardsIntentReader.a(com.facebook.inject.InjectorLike):com.facebook.entitycards.intent.EntityCardsIntentReader");
    }

    private static EntityCardsIntentReader m12926b(InjectorLike injectorLike) {
        return new EntityCardsIntentReader(EntityCardsLauncherCache.m12940a(injectorLike), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$EntityCardsSurfaceConfiguration(injectorLike)));
    }

    @Inject
    public EntityCardsIntentReader(EntityCardsLauncherCache entityCardsLauncherCache, Set<EntityCardsSurfaceConfiguration> set) {
        this.f10991a = entityCardsLauncherCache;
        this.f10992b = set;
    }

    private static boolean m12930c(Bundle bundle) {
        return bundle.getParcelable("entity_cards_fragment_parameters") != null;
    }

    public static EntityCardsParameters m12925a(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        return (EntityCardsParameters) ((Parcelable) Preconditions.checkNotNull(bundle.getParcelable("entity_cards_fragment_parameters")));
    }

    public final BasePersonCardsSurfaceConfiguration m12932a(String str) {
        Preconditions.checkNotNull(str);
        for (BasePersonCardsSurfaceConfiguration basePersonCardsSurfaceConfiguration : this.f10992b) {
            if (Objects.equal(str, (String) Preconditions.checkNotNull(basePersonCardsSurfaceConfiguration.mo833a(), "EntityCardsSurfaceConfiguration.getKey should not be null"))) {
                return basePersonCardsSurfaceConfiguration;
            }
        }
        throw new IllegalStateException("EntityCardsFragment can't be instantiated without a configuration");
    }

    public final Bundle m12931a(Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle2 == null) {
            return this.f10991a.m12941a((ParcelUuid) bundle.getParcelable("entity_cards_config_extras_uuid"));
        }
        Bundle bundle3 = (Bundle) bundle2.getParcelable("entity_cards_config_extras");
        return bundle3 == null ? this.f10991a.m12941a((ParcelUuid) bundle.getParcelable("entity_cards_config_extras_uuid")) : bundle3;
    }

    public static ImmutableList<String> m12927b(Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle2 == null || !m12930c(bundle2)) {
            return m12925a(bundle).f11007c;
        }
        return m12925a(bundle2).f11007c;
    }

    public static String m12929c(Bundle bundle, @Nullable Bundle bundle2) {
        if (bundle2 == null || !m12930c(bundle2)) {
            return m12925a(bundle).f11008d;
        }
        return m12925a(bundle2).f11008d;
    }

    @Nullable
    public static String m12928b(Bundle bundle) {
        return m12925a(bundle).f11010f;
    }
}
