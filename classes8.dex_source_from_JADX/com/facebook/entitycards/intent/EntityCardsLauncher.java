package com.facebook.entitycards.intent;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ParcelUuid;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger;
import com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger.Span;
import com.facebook.entitycards.model.EntityCardsCardSupportDeclaration;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: image_landscape_height */
public class EntityCardsLauncher {
    private static volatile EntityCardsLauncher f10993j;
    private final Boolean f10994a;
    private final Lazy<FbErrorReporter> f10995b;
    public final EntityCardsIntentReader f10996c;
    private final EntityCardsLauncherCache f10997d;
    private final EntityCardsInitialCardsSequenceLogger f10998e;
    private final MonotonicClock f10999f;
    private final PackageManager f11000g;
    private final SecureContextHelper f11001h;
    private long f11002i = 0;

    public static com.facebook.entitycards.intent.EntityCardsLauncher m12933a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10993j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.entitycards.intent.EntityCardsLauncher.class;
        monitor-enter(r1);
        r0 = f10993j;	 Catch:{ all -> 0x003a }
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
        r0 = m12935b(r0);	 Catch:{ all -> 0x0035 }
        f10993j = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10993j;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.entitycards.intent.EntityCardsLauncher.a(com.facebook.inject.InjectorLike):com.facebook.entitycards.intent.EntityCardsLauncher");
    }

    private static EntityCardsLauncher m12935b(InjectorLike injectorLike) {
        return new EntityCardsLauncher(Boolean_IsTabletMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), EntityCardsIntentReader.m12924a(injectorLike), EntityCardsLauncherCache.m12940a(injectorLike), EntityCardsInitialCardsSequenceLogger.m12807a(injectorLike), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), PackageManagerMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public EntityCardsLauncher(Boolean bool, Lazy<FbErrorReporter> lazy, EntityCardsIntentReader entityCardsIntentReader, EntityCardsLauncherCache entityCardsLauncherCache, EntityCardsInitialCardsSequenceLogger entityCardsInitialCardsSequenceLogger, MonotonicClock monotonicClock, PackageManager packageManager, SecureContextHelper secureContextHelper) {
        this.f10994a = bool;
        this.f10995b = lazy;
        this.f10996c = entityCardsIntentReader;
        this.f10997d = entityCardsLauncherCache;
        this.f10998e = entityCardsInitialCardsSequenceLogger;
        this.f10999f = monotonicClock;
        this.f11000g = packageManager;
        this.f11001h = secureContextHelper;
    }

    public final void m12936a(Activity activity, String str, Optional<String> optional, ImmutableList<String> immutableList, String str2, @Nullable String str3, @Nullable Bundle bundle) {
        m12937a(activity, str, optional, immutableList, str2, str3, bundle, null);
    }

    public final void m12937a(Activity activity, String str, Optional<String> optional, ImmutableList<String> immutableList, String str2, @Nullable String str3, @Nullable Bundle bundle, @Nullable Integer num) {
        Preconditions.checkState(m12938a(str), "Entity Cards are not allowed on this device");
        long now = this.f10999f.now();
        if (now - this.f11002i >= 2000) {
            this.f11002i = now;
            String uuid = SafeUUIDGenerator.a().toString();
            this.f10998e.m12818a(uuid, str, optional, str2);
            this.f10998e.m12817a(Span.LAUNCH_ENTITY_CARD);
            Intent intent = new Intent(activity, EntityCardsActivity.class);
            intent.putExtra("entity_cards_fragment_parameters", new EntityCardsParameters(str, optional, m12934a((ImmutableList) immutableList), str2, uuid, str3));
            Object parcelUuid = new ParcelUuid(SafeUUIDGenerator.a());
            intent.putExtra("entity_cards_config_extras_uuid", parcelUuid);
            this.f10997d.m12942a(parcelUuid, bundle);
            if (num == null) {
                this.f11001h.a(intent, activity);
            } else {
                this.f11001h.a(intent, num.intValue(), activity);
            }
            activity.overridePendingTransition(0, 0);
        }
    }

    private ImmutableList<String> m12934a(ImmutableList<String> immutableList) {
        ImmutableSet copyOf = ImmutableSet.copyOf(immutableList);
        if (copyOf.size() == immutableList.size()) {
            return immutableList;
        }
        ((AbstractFbErrorReporter) this.f10995b.get()).b("entity_cards_launcher_bad_parameters", "List of initial entity IDs contained duplicates: " + immutableList);
        return ImmutableList.copyOf(copyOf);
    }

    public final boolean m12938a(String str) {
        if (VERSION.SDK_INT < 13) {
            return true;
        }
        if (!this.f10994a.booleanValue() && this.f11000g.hasSystemFeature("android.hardware.screen.portrait")) {
            Object obj;
            for (EntityCardsCardSupportDeclaration c : this.f10996c.m12932a(str).mo834b()) {
                if (!c.mo796c()) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }
}
