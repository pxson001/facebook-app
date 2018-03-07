package com.facebook.sounds.configurator;

import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.sounds.configurator.prefs.AudioConfiguratorPrefKeys;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: event_reminders */
public class AudioConfigRegistry {
    private static volatile AudioConfigRegistry f15975d;
    public float f15976a = 1.0f;
    private AudioConfigData f15977b;
    public Map<Integer, AudioConfig> f15978c;

    /* compiled from: event_reminders */
    public class AudioConfig {
        public final String f15972a;
        public final int f15973b;
        public float f15974c = 0.0f;

        public AudioConfig(float f, String str, int i) {
            this.f15974c = f;
            this.f15972a = str;
            this.f15973b = i;
        }

        public final float m23609a() {
            return this.f15974c;
        }

        public final void m23610a(float f) {
            this.f15974c = f;
        }
    }

    /* compiled from: event_reminders */
    public class AudioConfigComparator implements Comparator<AudioConfig> {
        public int compare(Object obj, Object obj2) {
            return ((AudioConfig) obj).f15972a.compareTo(((AudioConfig) obj2).f15972a);
        }
    }

    public static com.facebook.sounds.configurator.AudioConfigRegistry m23611a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15975d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.sounds.configurator.AudioConfigRegistry.class;
        monitor-enter(r1);
        r0 = f15975d;	 Catch:{ all -> 0x003a }
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
        r0 = m23613b(r0);	 Catch:{ all -> 0x0035 }
        f15975d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15975d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.sounds.configurator.AudioConfigRegistry.a(com.facebook.inject.InjectorLike):com.facebook.sounds.configurator.AudioConfigRegistry");
    }

    private static AudioConfigRegistry m23613b(InjectorLike injectorLike) {
        return new AudioConfigRegistry(IdBasedSingletonScopeProvider.a(injectorLike, 10992));
    }

    @Inject
    public AudioConfigRegistry(Provider<AudioConfigData> provider) {
        this.f15977b = (AudioConfigData) provider.get();
        this.f15978c = m23612a(this.f15977b);
    }

    public final void m23616a(float f) {
        this.f15976a = f;
    }

    public final float m23614a() {
        return this.f15976a;
    }

    public final float m23615a(int i) {
        float f;
        AudioConfig audioConfig = (AudioConfig) this.f15978c.get(Integer.valueOf(i));
        if (audioConfig != null) {
            f = audioConfig.f15974c;
        } else {
            f = 1.0f;
        }
        return f * this.f15976a;
    }

    public final List<AudioConfig> m23617b() {
        List<AudioConfig> a = Lists.a(this.f15978c.values());
        Collections.sort(a, new AudioConfigComparator());
        return a;
    }

    public final String m23619c() {
        List<AudioConfig> b = m23617b();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("master_volume : " + this.f15976a + "\n");
        for (AudioConfig audioConfig : b) {
            stringBuilder.append(audioConfig.f15972a + " : " + audioConfig.f15974c + "\n");
        }
        return stringBuilder.toString();
    }

    public final void m23618b(FbSharedPreferences fbSharedPreferences) {
        fbSharedPreferences.edit().a(AudioConfiguratorPrefKeys.c).commit();
        this.f15978c.clear();
        this.f15978c = m23612a(this.f15977b);
    }

    private Map<Integer, AudioConfig> m23612a(AudioConfigData audioConfigData) {
        TracerDetour.a("AudioConfigRegistry.loadAudioConfig", -1997554561);
        try {
            DeviceProfile a = DeviceUtil.m23653a();
            m23616a(audioConfigData.m23607b(a));
            Map<Integer, AudioConfig> a2 = audioConfigData.m23606a(a);
            return a2;
        } finally {
            TracerDetour.a(2098791444);
        }
    }
}
