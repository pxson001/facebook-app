package com.facebook.storyteller;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.util.Pair;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.hardware.CameraDetectionUtil;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.device.ScreenUtil;
import com.facebook.friendsharing.souvenirs.abtest.ExperimentsForSouvenirAbtestModule;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.storyteller.models.CheckPoints;
import com.facebook.storyteller.models.ClusterConfig;
import com.facebook.storyteller.models.Config;
import com.facebook.storyteller.models.ProcessConfig;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: media exists */
public class StoryTellerConfig {
    private static final String f9031a = StoryTellerConfig.class.getSimpleName();
    private static volatile StoryTellerConfig f9032g;
    private final ScreenUtil f9033b;
    public final QeAccessor f9034c;
    private final CameraDetectionUtil f9035d;
    private final Provider<TriState> f9036e;
    private byte[] f9037f;

    public static com.facebook.storyteller.StoryTellerConfig m10752a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9032g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.storyteller.StoryTellerConfig.class;
        monitor-enter(r1);
        r0 = f9032g;	 Catch:{ all -> 0x003a }
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
        r0 = m10754b(r0);	 Catch:{ all -> 0x0035 }
        f9032g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9032g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.storyteller.StoryTellerConfig.a(com.facebook.inject.InjectorLike):com.facebook.storyteller.StoryTellerConfig");
    }

    private static StoryTellerConfig m10754b(InjectorLike injectorLike) {
        return new StoryTellerConfig(ScreenUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), new CameraDetectionUtil(PackageManagerMethodAutoProvider.a(injectorLike)), IdBasedProvider.a(injectorLike, 640));
    }

    @Inject
    public StoryTellerConfig(ScreenUtil screenUtil, QeAccessor qeAccessor, CameraDetectionUtil cameraDetectionUtil, Provider<TriState> provider) {
        this.f9033b = screenUtil;
        this.f9034c = qeAccessor;
        this.f9035d = cameraDetectionUtil;
        this.f9036e = provider;
    }

    public final synchronized byte[] m10756a() {
        byte[] bArr;
        if (this.f9037f != null) {
            bArr = this.f9037f;
        } else {
            boolean z;
            Object obj = !this.f9034c.a(ExperimentsForSouvenirAbtestModule.q, false) ? 1 : null;
            if (((TriState) this.f9036e.get()).asBoolean(false) || BuildConstants.e()) {
                z = true;
            } else {
                z = false;
            }
            int a = this.f9034c.a(ExperimentsForSouvenirAbtestModule.u, 7);
            int a2 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.t, 4);
            int a3 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.s, 50);
            int a4 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.d, 4);
            boolean a5 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.p, false);
            boolean a6 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.c, false);
            boolean a7 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.m, true);
            float a8 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.n, 5.0f);
            boolean a9 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.l, false);
            boolean a10 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.k, false);
            boolean a11 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.g, false);
            boolean a12 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.i, false);
            boolean a13 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.h, false);
            boolean a14 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.f, false);
            boolean a15 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.j, false);
            boolean a16 = this.f9034c.a(ExperimentsForSouvenirAbtestModule.e, false);
            Pair g = m10755g();
            int intValue = ((Integer) g.first).intValue();
            int intValue2 = ((Integer) g.second).intValue();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a17 = ClusterConfig.m10762a(flatBufferBuilder, 3.0f, 0.2f, 4.0f, 2.5f, 10.0f);
            int c = this.f9033b.c();
            int d = this.f9033b.d();
            if (obj != null) {
                a4 = Integer.MAX_VALUE;
            }
            Config.m10766a(flatBufferBuilder, Config.m10764a(flatBufferBuilder, a17, ProcessConfig.m10770a(flatBufferBuilder, a, a2, a3, intValue, a5, a6, 0.0f, 640, true, 2.5f, c, d, a7, a8, a4, true, 32, 2.0f, 30.0f, intValue2), z, a9, a10, CheckPoints.m10761a(flatBufferBuilder, a11, a12, a13, a14, a15, a16)));
            this.f9037f = flatBufferBuilder.e();
            m10753a(this.f9037f);
            bArr = this.f9037f;
        }
        return bArr;
    }

    public final long m10757b() {
        int a = this.f9034c.a(ExperimentsForSouvenirAbtestModule.u, 7);
        return (a > 0 ? ((long) a) + 1 : 8) * 86400000;
    }

    public final boolean m10758c() {
        return this.f9034c.a(ExperimentsForSouvenirAbtestModule.l, false);
    }

    public final boolean m10759d() {
        return this.f9034c.a(ExperimentsForSouvenirAbtestModule.F, true);
    }

    @SuppressLint({"DeprecatedClass"})
    private Pair<Integer, Integer> m10755g() {
        int i = 2500000;
        int i2 = 691200;
        if (!this.f9035d.a()) {
            return Pair.create(Integer.valueOf(2500000), Integer.valueOf(691200));
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        int i3 = 0;
        while (i3 < numberOfCameras) {
            try {
                int i4;
                Camera open = Camera.open(i3);
                Parameters parameters = open.getParameters();
                open.release();
                Size pictureSize = parameters.getPictureSize();
                if (pictureSize.width * pictureSize.height < i) {
                    i4 = pictureSize.width * pictureSize.height;
                } else {
                    i4 = i;
                }
                try {
                    List<Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
                    if (supportedVideoSizes != null) {
                        int i5 = 0;
                        for (Size size : supportedVideoSizes) {
                            i5 = Math.max(i5, size.height * size.width);
                        }
                        i = Math.min(i2, i5);
                    } else {
                        i = i2;
                    }
                    i3++;
                    i2 = i;
                    i = i4;
                } catch (RuntimeException e) {
                    i = i4;
                }
            } catch (RuntimeException e2) {
            }
        }
        return Pair.create(Integer.valueOf(i), Integer.valueOf(i2));
    }

    private static void m10753a(byte[] bArr) {
        if (BLog.b(3)) {
            ByteBuffer byteBuffer;
            ClusterConfig clusterConfig;
            ProcessConfig processConfig;
            float f;
            Config a = Config.m10765a(ByteBuffer.wrap(bArr));
            ClusterConfig clusterConfig2 = new ClusterConfig();
            int a2 = a.a(4);
            if (a2 != 0) {
                a2 = a.b(a2 + a.a);
                byteBuffer = a.b;
                clusterConfig2.a = a2;
                clusterConfig2.b = byteBuffer;
                clusterConfig = clusterConfig2;
            } else {
                clusterConfig = null;
            }
            Table table = clusterConfig;
            ProcessConfig processConfig2 = new ProcessConfig();
            a2 = a.a(6);
            if (a2 != 0) {
                a2 = a.b(a2 + a.a);
                byteBuffer = a.b;
                processConfig2.a = a2;
                processConfig2.b = byteBuffer;
                processConfig = processConfig2;
            } else {
                processConfig = null;
            }
            Table table2 = processConfig;
            StringBuilder stringBuilder = new StringBuilder("Storyteller configuration: \n");
            stringBuilder.append("  cluster configuration: \n");
            StringBuilder append = stringBuilder.append("\t hourTimeThresholdIfNoKnownDistance: ");
            int a3 = table.a(4);
            if (a3 != 0) {
                f = table.b.getFloat(a3 + table.a);
            } else {
                f = 0.0f;
            }
            append.append(f).append("\n");
            stringBuilder.append("\t kmDistanceThresholdForCloseDistanceCheck: ").append(table.m10763b()).append("\n");
            append = stringBuilder.append("\t hourTimeThresholdIfPassesCloseDistanceCheck: ");
            a3 = table.a(8);
            if (a3 != 0) {
                f = table.b.getFloat(a3 + table.a);
            } else {
                f = 0.0f;
            }
            append.append(f).append("\n");
            append = stringBuilder.append("\t hourTimeThresholdForCloseTimeCheck: ");
            a3 = table.a(10);
            if (a3 != 0) {
                f = table.b.getFloat(a3 + table.a);
            } else {
                f = 0.0f;
            }
            append.append(f).append("\n");
            stringBuilder.append("\t kmDistanceThresholdIfPassesCloseTimeCheck: ").append(table.m10763b()).append("\n");
            stringBuilder.append("  process configuration:  \n");
            StringBuilder append2 = stringBuilder.append("\t minRecencyInDays: ");
            a3 = table2.a(4);
            if (a3 != 0) {
                a3 = table2.b.getInt(a3 + table2.a);
            } else {
                a3 = 14;
            }
            append2.append(a3).append("\n");
            append2 = stringBuilder.append("\t minAssetCount: ");
            a3 = table2.a(6);
            if (a3 != 0) {
                a3 = table2.b.getInt(a3 + table2.a);
            } else {
                a3 = 4;
            }
            append2.append(a3).append("\n");
            append2 = stringBuilder.append("\t maxAssetCount: ");
            a3 = table2.a(8);
            if (a3 != 0) {
                a3 = table2.b.getInt(a3 + table2.a);
            } else {
                a3 = 30;
            }
            append2.append(a3).append("\n");
            append2 = stringBuilder.append("\t photoPixelCount: ");
            a3 = table2.a(10);
            if (a3 != 0) {
                a3 = table2.b.getInt(a3 + table2.a);
            } else {
                a3 = 2500000;
            }
            append2.append(a3).append("\n");
            append2 = stringBuilder.append("\t faceDetectionEnabled: ");
            boolean z = false;
            a2 = table2.a(12);
            if (!(a2 == 0 || table2.b.get(a2 + table2.a) == (byte) 0)) {
                z = true;
            }
            append2.append(z).append("\n");
            append2 = stringBuilder.append("\t blurryPhotoRemovalEnabled: ");
            z = false;
            a2 = table2.a(14);
            if (!(a2 == 0 || table2.b.get(a2 + table2.a) == (byte) 0)) {
                z = true;
            }
            append2.append(z).append("\n");
            append2 = stringBuilder.append("\t blurryPhotoDetectorThreshold: ");
            a3 = table2.a(16);
            if (a3 != 0) {
                f = table2.b.getFloat(a3 + table2.a);
            } else {
                f = 0.0f;
            }
            append2.append(f).append("\n");
            append2 = stringBuilder.append("\t blurryPhotoDetectorResolution: ");
            a3 = table2.a(18);
            if (a3 != 0) {
                a3 = table2.b.getInt(a3 + table2.a);
            } else {
                a3 = 0;
            }
            append2.append(a3).append("\n");
            append2 = stringBuilder.append("\t panoramaRemovalEnabled: ");
            z = false;
            a2 = table2.a(20);
            if (!(a2 == 0 || table2.b.get(a2 + table2.a) == (byte) 0)) {
                z = true;
            }
            append2.append(z).append("\n");
            append2 = stringBuilder.append("\t panoramaMaxRatio: ");
            a3 = table2.a(22);
            if (a3 != 0) {
                f = table2.b.getFloat(a3 + table2.a);
            } else {
                f = 0.0f;
            }
            append2.append(f).append("\n");
            append2 = stringBuilder.append("\t nativeResolutionWidth: ");
            a3 = table2.a(24);
            if (a3 != 0) {
                a3 = table2.b.getInt(a3 + table2.a);
            } else {
                a3 = 0;
            }
            append2.append(a3).append("\n");
            append2 = stringBuilder.append("\t nativeResolutionHeight: ");
            a3 = table2.a(26);
            if (a3 != 0) {
                a3 = table2.b.getInt(a3 + table2.a);
            } else {
                a3 = 0;
            }
            append2.append(a3).append("\n");
            append2 = stringBuilder.append("\t burstProcessorEnabled: ");
            a3 = table2.a(28);
            if (a3 == 0 || table2.b.get(a3 + table2.a) != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            append2.append(z).append("\n");
            append2 = stringBuilder.append("\t burstSimilarityThreshold: ");
            a3 = table2.a(30);
            if (a3 != 0) {
                f = table2.b.getFloat(a3 + table2.a);
            } else {
                f = 0.0f;
            }
            append2.append(f).append("\n");
            append2 = stringBuilder.append("\t burstMinPhotosCountForLoop: ");
            a3 = table2.a(32);
            if (a3 != 0) {
                a3 = table2.b.getInt(a3 + table2.a);
            } else {
                a3 = 0;
            }
            append2.append(a3).append("\n");
            append2 = stringBuilder.append("\t videoEnabled: ");
            z = false;
            a2 = table2.a(34);
            if (!(a2 == 0 || table2.b.get(a2 + table2.a) == (byte) 0)) {
                z = true;
            }
            append2.append(z).append("\n");
            append2 = stringBuilder.append("\t minVideoDurationInSeconds: ");
            a3 = table2.a(38);
            if (a3 != 0) {
                f = table2.b.getFloat(a3 + table2.a);
            } else {
                f = 0.0f;
            }
            append2.append(f).append("\n");
            append2 = stringBuilder.append("\t maxVideoDurationInSeconds: ");
            a3 = table2.a(40);
            if (a3 != 0) {
                f = table2.b.getFloat(a3 + table2.a);
            } else {
                f = 0.0f;
            }
            append2.append(f).append("\n");
            append2 = stringBuilder.append("\t videoPixelCount: ");
            a3 = table2.a(42);
            if (a3 != 0) {
                a3 = table2.b.getInt(a3 + table2.a);
            } else {
                a3 = 0;
            }
            append2.append(a3).append("\n");
            append2 = stringBuilder.append("\t employeeLoggingEnabled: ");
            z = false;
            a2 = a.a(8);
            if (!(a2 == 0 || a.b.get(a2 + a.a) == (byte) 0)) {
                z = true;
            }
            append2.append(z).append("\n");
            append2 = stringBuilder.append("\t useCompactDiskCache: ");
            z = false;
            a2 = a.a(10);
            if (!(a2 == 0 || a.b.get(a2 + a.a) == (byte) 0)) {
                z = true;
            }
            append2.append(z).append("\n");
        }
    }
}
