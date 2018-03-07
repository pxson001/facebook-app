package com.facebook.sounds.fb4a;

import android.media.AudioManager;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.sounds.FBSoundUtil;
import com.facebook.sounds.SoundPlayer;
import com.facebook.sounds.SoundPlayer.SoundPlayerListener;
import com.facebook.sounds.SoundResourceStore;
import com.facebook.sounds.configurator.AudioConfigRegistry;
import com.facebook.sounds.fb4a.prefs.SoundsPrefKeys;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: event_invitee_candidates */
public class Fb4aSoundUtil extends FBSoundUtil implements SoundPlayerListener {
    private static volatile Fb4aSoundUtil f16046e;
    public final AudioManager f16047a;
    public Provider<SoundResourceStore> f16048b;
    public Lazy<AudioConfigRegistry> f16049c;
    public FbSharedPreferences f16050d;

    public static com.facebook.sounds.fb4a.Fb4aSoundUtil m23665a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16046e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sounds.fb4a.Fb4aSoundUtil.class;
        monitor-enter(r1);
        r0 = f16046e;	 Catch:{ all -> 0x003a }
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
        r0 = m23666b(r0);	 Catch:{ all -> 0x0035 }
        f16046e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16046e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sounds.fb4a.Fb4aSoundUtil.a(com.facebook.inject.InjectorLike):com.facebook.sounds.fb4a.Fb4aSoundUtil");
    }

    private static Fb4aSoundUtil m23666b(InjectorLike injectorLike) {
        return new Fb4aSoundUtil(AudioManagerMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 10990), IdBasedSingletonScopeProvider.a(injectorLike, 10991), IdBasedSingletonScopeProvider.b(injectorLike, 10993), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public Fb4aSoundUtil(AudioManager audioManager, Provider<SoundPlayer> provider, Provider<SoundResourceStore> provider2, Lazy<AudioConfigRegistry> lazy, FbSharedPreferences fbSharedPreferences) {
        super(provider, provider2);
        this.f16047a = audioManager;
        this.f16048b = provider2;
        this.f16049c = lazy;
        this.f16050d = fbSharedPreferences;
    }

    public final void m23667b(String str) {
        boolean z = true;
        if (!this.f16050d.a(SoundsPrefKeys.f16053b, true) || this.f16047a.getStreamVolume(2) <= 0) {
            z = false;
        }
        if (z) {
            a(str, ((AudioConfigRegistry) this.f16049c.get()).m23615a(((SoundResourceStore) this.f16048b.get()).m23605a(str).intValue()));
        }
    }
}
