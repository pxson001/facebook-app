package android.support.v7.media;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.support.v4.media.VolumeProviderCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.media.MediaRouteProvider.ProviderMetadata;
import android.support.v7.media.MediaRouteProvider.RouteController;
import android.support.v7.media.MediaRouteSelector.Builder;
import android.support.v7.media.SystemMediaRouteProvider.SyncCallback;
import android.util.Log;
import android.view.Display;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* compiled from: custom_cta_mobile_contact_us_toggle_responded */
public final class MediaRouter {
    static GlobalMediaRouter f16321a;
    public static final boolean f16322d = Log.isLoggable("MediaRouter", 3);
    public final Context f16323b;
    final ArrayList<CallbackRecord> f16324c = new ArrayList();

    /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
    public abstract class Callback {
        public void mo1246a(RouteInfo routeInfo) {
        }

        public void mo1245a() {
        }

        public void mo1248a(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void mo1247a(MediaRouter mediaRouter) {
        }

        public void mo1250b(MediaRouter mediaRouter) {
        }

        public void mo1253b(MediaRouter mediaRouter, RouteInfo routeInfo) {
        }

        public void mo1249b() {
        }

        public void mo1251c() {
        }

        public void mo1252d() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
    @interface CallbackFlags {
    }

    /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
    public final class CallbackRecord {
        public final MediaRouter f16271a;
        public final Callback f16272b;
        public MediaRouteSelector f16273c = MediaRouteSelector.f16268a;
        public int f16274d;

        public CallbackRecord(MediaRouter mediaRouter, Callback callback) {
            this.f16271a = mediaRouter;
            this.f16272b = callback;
        }
    }

    /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
    public abstract class ControlRequestCallback {
    }

    /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
    public final class GlobalMediaRouter implements android.support.v7.media.RegisteredMediaRouteProviderWatcher.Callback, SyncCallback {
        public final Context f16283a;
        public final ArrayList<WeakReference<MediaRouter>> f16284b = new ArrayList();
        public final ArrayList<RouteInfo> f16285c = new ArrayList();
        private final ArrayList<ProviderInfo> f16286d = new ArrayList();
        private final ArrayList<Object> f16287e = new ArrayList();
        private final RemoteControlClientCompat$PlaybackInfo f16288f = new RemoteControlClientCompat$PlaybackInfo();
        private final ProviderCallback f16289g = new ProviderCallback(this);
        private final CallbackHandler f16290h = new CallbackHandler(this);
        private final DisplayManagerCompat f16291i;
        public final SystemMediaRouteProvider f16292j;
        public final boolean f16293k;
        public RegisteredMediaRouteProviderWatcher f16294l;
        public RouteInfo f16295m;
        public RouteInfo f16296n;
        public RouteController f16297o;
        private MediaRouteDiscoveryRequest f16298p;
        private MediaSessionRecord f16299q;

        /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
        final class CallbackHandler extends Handler {
            final /* synthetic */ GlobalMediaRouter f16275a;
            private final ArrayList<CallbackRecord> f16276b = new ArrayList();

            public CallbackHandler(android.support.v7.media.MediaRouter.GlobalMediaRouter r2) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r1.f16275a = r2;
                r1.<init>();
                r0 = new java.util.ArrayList;
                r0.<init>();
                r1.f16276b = r0;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.CallbackHandler.<init>(android.support.v7.media.MediaRouter$GlobalMediaRouter):void");
            }

            public final void m20348a(int r2, java.lang.Object r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.obtainMessage(r2, r3);
                r0.sendToTarget();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.CallbackHandler.a(int, java.lang.Object):void");
            }

            public final void handleMessage(android.os.Message r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r2 = r6.what;
                r3 = r6.obj;
                r5.m20347b(r2, r3);
                r0 = r5.f16275a;	 Catch:{ all -> 0x0056 }
                r0 = r0.f16284b;	 Catch:{ all -> 0x0056 }
                r0 = r0.size();	 Catch:{ all -> 0x0056 }
            L_0x000f:
                r1 = r0 + -1;	 Catch:{ all -> 0x0056 }
                if (r1 < 0) goto L_0x0037;	 Catch:{ all -> 0x0056 }
            L_0x0013:
                r0 = r5.f16275a;	 Catch:{ all -> 0x0056 }
                r0 = r0.f16284b;	 Catch:{ all -> 0x0056 }
                r0 = r0.get(r1);	 Catch:{ all -> 0x0056 }
                r0 = (java.lang.ref.WeakReference) r0;	 Catch:{ all -> 0x0056 }
                r0 = r0.get();	 Catch:{ all -> 0x0056 }
                r0 = (android.support.v7.media.MediaRouter) r0;	 Catch:{ all -> 0x0056 }
                if (r0 != 0) goto L_0x002e;	 Catch:{ all -> 0x0056 }
            L_0x0025:
                r0 = r5.f16275a;	 Catch:{ all -> 0x0056 }
                r0 = r0.f16284b;	 Catch:{ all -> 0x0056 }
                r0.remove(r1);	 Catch:{ all -> 0x0056 }
                r0 = r1;	 Catch:{ all -> 0x0056 }
                goto L_0x000f;	 Catch:{ all -> 0x0056 }
            L_0x002e:
                r4 = r5.f16276b;	 Catch:{ all -> 0x0056 }
                r0 = r0.f16324c;	 Catch:{ all -> 0x0056 }
                r4.addAll(r0);	 Catch:{ all -> 0x0056 }
                r0 = r1;	 Catch:{ all -> 0x0056 }
                goto L_0x000f;	 Catch:{ all -> 0x0056 }
            L_0x0037:
                r0 = r5.f16276b;	 Catch:{ all -> 0x0056 }
                r4 = r0.size();	 Catch:{ all -> 0x0056 }
                r0 = 0;	 Catch:{ all -> 0x0056 }
                r1 = r0;	 Catch:{ all -> 0x0056 }
            L_0x003f:
                if (r1 >= r4) goto L_0x0050;	 Catch:{ all -> 0x0056 }
            L_0x0041:
                r0 = r5.f16276b;	 Catch:{ all -> 0x0056 }
                r0 = r0.get(r1);	 Catch:{ all -> 0x0056 }
                r0 = (android.support.v7.media.MediaRouter.CallbackRecord) r0;	 Catch:{ all -> 0x0056 }
                m20346a(r0, r2, r3);	 Catch:{ all -> 0x0056 }
                r0 = r1 + 1;
                r1 = r0;
                goto L_0x003f;
            L_0x0050:
                r0 = r5.f16276b;
                r0.clear();
                return;
            L_0x0056:
                r0 = move-exception;
                r1 = r5.f16276b;
                r1.clear();
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.CallbackHandler.handleMessage(android.os.Message):void");
            }

            private void m20347b(int r2, java.lang.Object r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                switch(r2) {
                    case 257: goto L_0x0004;
                    case 258: goto L_0x000e;
                    case 259: goto L_0x0018;
                    case 260: goto L_0x0003;
                    case 261: goto L_0x0003;
                    case 262: goto L_0x0022;
                    default: goto L_0x0003;
                };
            L_0x0003:
                return;
            L_0x0004:
                r0 = r1.f16275a;
                r0 = r0.f16292j;
                r3 = (android.support.v7.media.MediaRouter.RouteInfo) r3;
                r0.mo1265a(r3);
                goto L_0x0003;
            L_0x000e:
                r0 = r1.f16275a;
                r0 = r0.f16292j;
                r3 = (android.support.v7.media.MediaRouter.RouteInfo) r3;
                r0.mo1268b(r3);
                goto L_0x0003;
            L_0x0018:
                r0 = r1.f16275a;
                r0 = r0.f16292j;
                r3 = (android.support.v7.media.MediaRouter.RouteInfo) r3;
                r0.mo1271c(r3);
                goto L_0x0003;
            L_0x0022:
                r0 = r1.f16275a;
                r0 = r0.f16292j;
                r3 = (android.support.v7.media.MediaRouter.RouteInfo) r3;
                r0.mo1273d(r3);
                goto L_0x0003;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.CallbackHandler.b(int, java.lang.Object):void");
            }

            private static void m20346a(android.support.v7.media.MediaRouter.CallbackRecord r4, int r5, java.lang.Object r6) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = r4.f16271a;
                r1 = r4.f16272b;
                r2 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;
                r2 = r2 & r5;
                switch(r2) {
                    case 256: goto L_0x000c;
                    case 512: goto L_0x003c;
                    default: goto L_0x000b;
                };
            L_0x000b:
                return;
            L_0x000c:
                r6 = (android.support.v7.media.MediaRouter.RouteInfo) r6;
                r3 = r4.f16274d;
                r3 = r3 & 2;
                if (r3 != 0) goto L_0x001c;
            L_0x0014:
                r3 = r4.f16273c;
                r3 = r6.m20373a(r3);
                if (r3 == 0) goto L_0x004c;
            L_0x001c:
                r3 = 1;
            L_0x001d:
                r2 = r3;
                if (r2 == 0) goto L_0x000b;
            L_0x0020:
                switch(r5) {
                    case 257: goto L_0x0024;
                    case 258: goto L_0x0028;
                    case 259: goto L_0x002c;
                    case 260: goto L_0x0030;
                    case 261: goto L_0x000b;
                    case 262: goto L_0x0034;
                    case 263: goto L_0x0038;
                    default: goto L_0x0023;
                };
            L_0x0023:
                goto L_0x000b;
            L_0x0024:
                r1.mo1248a(r0, r6);
                goto L_0x000b;
            L_0x0028:
                r1.mo1247a(r0);
                goto L_0x000b;
            L_0x002c:
                r1.mo1250b(r0);
                goto L_0x000b;
            L_0x0030:
                r1.mo1253b(r0, r6);
                goto L_0x000b;
            L_0x0034:
                r1.mo1246a(r6);
                goto L_0x000b;
            L_0x0038:
                r1.mo1245a();
                goto L_0x000b;
            L_0x003c:
                switch(r5) {
                    case 513: goto L_0x0040;
                    case 514: goto L_0x0044;
                    case 515: goto L_0x0048;
                    default: goto L_0x003f;
                };
            L_0x003f:
                goto L_0x000b;
            L_0x0040:
                r1.mo1249b();
                goto L_0x000b;
            L_0x0044:
                r1.mo1251c();
                goto L_0x000b;
            L_0x0048:
                r1.mo1252d();
                goto L_0x000b;
            L_0x004c:
                r3 = 0;
                goto L_0x001d;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.CallbackHandler.a(android.support.v7.media.MediaRouter$CallbackRecord, int, java.lang.Object):void");
            }
        }

        /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
        public final class MediaSessionRecord {
            public final MediaSessionCompat f16278a;
            public int f16279b;
            public int f16280c;
            public VolumeProviderCompat f16281d;

            /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
            public class C12851 extends VolumeProviderCompat {
                final /* synthetic */ MediaSessionRecord f16277a;

                public C12851(android.support.v7.media.MediaRouter.GlobalMediaRouter.MediaSessionRecord r1, int r2, int r3, int r4) {
                    /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                    /*
                    r0 = this;
                    r0.f16277a = r1;
                    r0.<init>(r2, r3, r4);
                    return;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.MediaSessionRecord.1.<init>(android.support.v7.media.MediaRouter$GlobalMediaRouter$MediaSessionRecord, int, int, int):void");
                }
            }
        }

        /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
        final class ProviderCallback extends android.support.v7.media.MediaRouteProvider.Callback {
            final /* synthetic */ GlobalMediaRouter f16282a;

            public ProviderCallback(android.support.v7.media.MediaRouter.GlobalMediaRouter r1) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r0 = this;
                r0.f16282a = r1;
                r0.<init>();
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.ProviderCallback.<init>(android.support.v7.media.MediaRouter$GlobalMediaRouter):void");
            }

            public final void mo1254a(android.support.v7.media.MediaRouteProvider r2, android.support.v7.media.MediaRouteProviderDescriptor r3) {
                /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r1 = this;
                r0 = r1.f16282a;
                android.support.v7.media.MediaRouter.GlobalMediaRouter.m20354a(r0, r2, r3);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.ProviderCallback.a(android.support.v7.media.MediaRouteProvider, android.support.v7.media.MediaRouteProviderDescriptor):void");
            }
        }

        GlobalMediaRouter(android.content.Context r6) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r5 = this;
            r1 = 0;
            r5.<init>();
            r0 = new java.util.ArrayList;
            r0.<init>();
            r5.f16284b = r0;
            r0 = new java.util.ArrayList;
            r0.<init>();
            r5.f16285c = r0;
            r0 = new java.util.ArrayList;
            r0.<init>();
            r5.f16286d = r0;
            r0 = new java.util.ArrayList;
            r0.<init>();
            r5.f16287e = r0;
            r0 = new android.support.v7.media.RemoteControlClientCompat$PlaybackInfo;
            r0.<init>();
            r5.f16288f = r0;
            r0 = new android.support.v7.media.MediaRouter$GlobalMediaRouter$ProviderCallback;
            r0.<init>(r5);
            r5.f16289g = r0;
            r0 = new android.support.v7.media.MediaRouter$GlobalMediaRouter$CallbackHandler;
            r0.<init>(r5);
            r5.f16290h = r0;
            r5.f16283a = r6;
            r0 = android.support.v4.hardware.display.DisplayManagerCompat.a(r6);
            r5.f16291i = r0;
            r0 = "activity";
            r0 = r6.getSystemService(r0);
            r0 = (android.app.ActivityManager) r0;
            r2 = android.os.Build.VERSION.SDK_INT;
            r3 = 19;
            if (r2 < r3) goto L_0x0067;
        L_0x004b:
            r4 = r0.isLowRamDevice();
            r2 = r4;
        L_0x0050:
            r0 = r2;
            r5.f16293k = r0;
            r2 = android.os.Build.VERSION.SDK_INT;
            r3 = 18;
            if (r2 < r3) goto L_0x0069;
        L_0x0059:
            r2 = new android.support.v7.media.SystemMediaRouteProvider$JellybeanMr2Impl;
            r2.<init>(r6, r5);
        L_0x005e:
            r0 = r2;
            r5.f16292j = r0;
            r0 = r5.f16292j;
            r5.mo1256a(r0);
            return;
        L_0x0067:
            r2 = 0;
            goto L_0x0050;
        L_0x0069:
            r2 = android.os.Build.VERSION.SDK_INT;
            r3 = 17;
            if (r2 < r3) goto L_0x0075;
        L_0x006f:
            r2 = new android.support.v7.media.SystemMediaRouteProvider$JellybeanMr1Impl;
            r2.<init>(r6, r5);
            goto L_0x005e;
        L_0x0075:
            r2 = android.os.Build.VERSION.SDK_INT;
            r3 = 16;
            if (r2 < r3) goto L_0x0081;
        L_0x007b:
            r2 = new android.support.v7.media.SystemMediaRouteProvider$JellybeanImpl;
            r2.<init>(r6, r5);
            goto L_0x005e;
        L_0x0081:
            r2 = new android.support.v7.media.SystemMediaRouteProvider$LegacyImpl;
            r2.<init>(r6);
            goto L_0x005e;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.<init>(android.content.Context):void");
        }

        public final android.support.v7.media.MediaRouter.RouteInfo m20366c() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r2 = this;
            r0 = r2.f16295m;
            if (r0 != 0) goto L_0x000c;
        L_0x0004:
            r0 = new java.lang.IllegalStateException;
            r1 = "There is no default route.  The media router has not yet been fully initialized.";
            r0.<init>(r1);
            throw r0;
        L_0x000c:
            r0 = r2.f16295m;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.c():android.support.v7.media.MediaRouter$RouteInfo");
        }

        public final android.support.v7.media.MediaRouter.RouteInfo m20367d() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r2 = this;
            r0 = r2.f16296n;
            if (r0 != 0) goto L_0x000c;
        L_0x0004:
            r0 = new java.lang.IllegalStateException;
            r1 = "There is no currently selected route.  The media router has not yet been fully initialized.";
            r0.<init>(r1);
            throw r0;
        L_0x000c:
            r0 = r2.f16296n;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.d():android.support.v7.media.MediaRouter$RouteInfo");
        }

        public final void m20364a(android.support.v7.media.MediaRouter.RouteInfo r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r3 = this;
            r0 = r3.f16285c;
            r0 = r0.contains(r4);
            if (r0 != 0) goto L_0x001d;
        L_0x0008:
            r0 = "MediaRouter";
            r1 = new java.lang.StringBuilder;
            r2 = "Ignoring attempt to select removed route: ";
            r1.<init>(r2);
            r1 = r1.append(r4);
            r1 = r1.toString();
            android.util.Log.w(r0, r1);
        L_0x001c:
            return;
        L_0x001d:
            r0 = r4.f16309f;
            if (r0 != 0) goto L_0x0036;
        L_0x0021:
            r0 = "MediaRouter";
            r1 = new java.lang.StringBuilder;
            r2 = "Ignoring attempt to select disabled route: ";
            r1.<init>(r2);
            r1 = r1.append(r4);
            r1 = r1.toString();
            android.util.Log.w(r0, r1);
            goto L_0x001c;
        L_0x0036:
            r3.m20360e(r4);
            goto L_0x001c;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.a(android.support.v7.media.MediaRouter$RouteInfo):void");
        }

        public final void m20368e() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r11 = this;
            r3 = 1;
            r5 = 0;
            r8 = new android.support.v7.media.MediaRouteSelector$Builder;
            r8.<init>();
            r0 = r11.f16284b;
            r0 = r0.size();
            r2 = r5;
            r4 = r5;
        L_0x000f:
            r7 = r0 + -1;
            if (r7 < 0) goto L_0x0060;
        L_0x0013:
            r0 = r11.f16284b;
            r0 = r0.get(r7);
            r0 = (java.lang.ref.WeakReference) r0;
            r0 = r0.get();
            r0 = (android.support.v7.media.MediaRouter) r0;
            if (r0 != 0) goto L_0x002a;
        L_0x0023:
            r0 = r11.f16284b;
            r0.remove(r7);
            r0 = r7;
            goto L_0x000f;
        L_0x002a:
            r1 = r0.f16324c;
            r9 = r1.size();
            r6 = r5;
        L_0x0031:
            if (r6 >= r9) goto L_0x005e;
        L_0x0033:
            r1 = r0.f16324c;
            r1 = r1.get(r6);
            r1 = (android.support.v7.media.MediaRouter.CallbackRecord) r1;
            r10 = r1.f16273c;
            r8.m20339a(r10);
            r10 = r1.f16274d;
            r10 = r10 & 1;
            if (r10 == 0) goto L_0x0048;
        L_0x0046:
            r2 = r3;
            r4 = r3;
        L_0x0048:
            r10 = r1.f16274d;
            r10 = r10 & 4;
            if (r10 == 0) goto L_0x0053;
        L_0x004e:
            r10 = r11.f16293k;
            if (r10 != 0) goto L_0x0053;
        L_0x0052:
            r4 = r3;
        L_0x0053:
            r1 = r1.f16274d;
            r1 = r1 & 8;
            if (r1 == 0) goto L_0x005a;
        L_0x0059:
            r4 = r3;
        L_0x005a:
            r1 = r6 + 1;
            r6 = r1;
            goto L_0x0031;
        L_0x005e:
            r0 = r7;
            goto L_0x000f;
        L_0x0060:
            if (r4 == 0) goto L_0x007f;
        L_0x0062:
            r0 = r8.m20341a();
        L_0x0066:
            r1 = r11.f16298p;
            if (r1 == 0) goto L_0x0082;
        L_0x006a:
            r1 = r11.f16298p;
            r1 = r1.m20317a();
            r1 = r1.equals(r0);
            if (r1 == 0) goto L_0x0082;
        L_0x0076:
            r1 = r11.f16298p;
            r1 = r1.m20318b();
            if (r1 != r2) goto L_0x0082;
        L_0x007e:
            return;
        L_0x007f:
            r0 = android.support.v7.media.MediaRouteSelector.f16268a;
            goto L_0x0066;
        L_0x0082:
            r1 = r0.m20345b();
            if (r1 == 0) goto L_0x00d6;
        L_0x0088:
            if (r2 != 0) goto L_0x00d6;
        L_0x008a:
            r0 = r11.f16298p;
            if (r0 == 0) goto L_0x007e;
        L_0x008e:
            r0 = 0;
            r11.f16298p = r0;
        L_0x0091:
            r0 = android.support.v7.media.MediaRouter.f16322d;
            if (r0 == 0) goto L_0x00ab;
        L_0x0095:
            r0 = "MediaRouter";
            r1 = new java.lang.StringBuilder;
            r3 = "Updated discovery request: ";
            r1.<init>(r3);
            r3 = r11.f16298p;
            r1 = r1.append(r3);
            r1 = r1.toString();
            android.util.Log.d(r0, r1);
        L_0x00ab:
            if (r4 == 0) goto L_0x00ba;
        L_0x00ad:
            if (r2 != 0) goto L_0x00ba;
        L_0x00af:
            r0 = r11.f16293k;
            if (r0 == 0) goto L_0x00ba;
        L_0x00b3:
            r0 = "MediaRouter";
            r1 = "Forcing passive route discovery on a low-RAM device, system performance may be affected.  Please consider using CALLBACK_FLAG_REQUEST_DISCOVERY instead of CALLBACK_FLAG_FORCE_DISCOVERY.";
            android.util.Log.i(r0, r1);
        L_0x00ba:
            r0 = r11.f16286d;
            r2 = r0.size();
            r1 = r5;
        L_0x00c1:
            if (r1 >= r2) goto L_0x007e;
        L_0x00c3:
            r0 = r11.f16286d;
            r0 = r0.get(r1);
            r0 = (android.support.v7.media.MediaRouter.ProviderInfo) r0;
            r0 = r0.f16300a;
            r3 = r11.f16298p;
            r0.m20327a(r3);
            r0 = r1 + 1;
            r1 = r0;
            goto L_0x00c1;
        L_0x00d6:
            r1 = new android.support.v7.media.MediaRouteDiscoveryRequest;
            r1.<init>(r0, r2);
            r11.f16298p = r1;
            goto L_0x0091;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.e():void");
        }

        public final void mo1256a(android.support.v7.media.MediaRouteProvider r6) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r5 = this;
            r0 = r5.m20358c(r6);
            if (r0 >= 0) goto L_0x003f;
        L_0x0006:
            r0 = new android.support.v7.media.MediaRouter$ProviderInfo;
            r0.<init>(r6);
            r1 = r5.f16286d;
            r1.add(r0);
            r1 = android.support.v7.media.MediaRouter.f16322d;
            if (r1 == 0) goto L_0x0028;
        L_0x0014:
            r1 = "MediaRouter";
            r2 = new java.lang.StringBuilder;
            r3 = "Provider added: ";
            r2.<init>(r3);
            r2 = r2.append(r0);
            r2 = r2.toString();
            android.util.Log.d(r1, r2);
        L_0x0028:
            r1 = r5.f16290h;
            r2 = 513; // 0x201 float:7.19E-43 double:2.535E-321;
            r1.m20348a(r2, r0);
            r4 = r6.f16261g;
            r1 = r4;
            r5.m20355a(r0, r1);
            r0 = r5.f16289g;
            r6.m20328a(r0);
            r0 = r5.f16298p;
            r6.m20327a(r0);
        L_0x003f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.a(android.support.v7.media.MediaRouteProvider):void");
        }

        public final void mo1257b(android.support.v7.media.MediaRouteProvider r6) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r5 = this;
            r2 = 0;
            r1 = r5.m20358c(r6);
            if (r1 < 0) goto L_0x003c;
        L_0x0007:
            r6.m20328a(r2);
            r6.m20327a(r2);
            r0 = r5.f16286d;
            r0 = r0.get(r1);
            r0 = (android.support.v7.media.MediaRouter.ProviderInfo) r0;
            r5.m20355a(r0, r2);
            r2 = android.support.v7.media.MediaRouter.f16322d;
            if (r2 == 0) goto L_0x0030;
        L_0x001c:
            r2 = "MediaRouter";
            r3 = new java.lang.StringBuilder;
            r4 = "Provider removed: ";
            r3.<init>(r4);
            r3 = r3.append(r0);
            r3 = r3.toString();
            android.util.Log.d(r2, r3);
        L_0x0030:
            r2 = r5.f16290h;
            r3 = 514; // 0x202 float:7.2E-43 double:2.54E-321;
            r2.m20348a(r3, r0);
            r0 = r5.f16286d;
            r0.remove(r1);
        L_0x003c:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.b(android.support.v7.media.MediaRouteProvider):void");
        }

        public static void m20354a(android.support.v7.media.MediaRouter.GlobalMediaRouter r2, android.support.v7.media.MediaRouteProvider r3, android.support.v7.media.MediaRouteProviderDescriptor r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r0 = r2.m20358c(r3);
            if (r0 < 0) goto L_0x0011;
        L_0x0006:
            r1 = r2.f16286d;
            r0 = r1.get(r0);
            r0 = (android.support.v7.media.MediaRouter.ProviderInfo) r0;
            r2.m20355a(r0, r4);
        L_0x0011:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.a(android.support.v7.media.MediaRouter$GlobalMediaRouter, android.support.v7.media.MediaRouteProvider, android.support.v7.media.MediaRouteProviderDescriptor):void");
        }

        private int m20358c(android.support.v7.media.MediaRouteProvider r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r3 = this;
            r0 = r3.f16286d;
            r2 = r0.size();
            r1 = 0;
        L_0x0007:
            if (r1 >= r2) goto L_0x001a;
        L_0x0009:
            r0 = r3.f16286d;
            r0 = r0.get(r1);
            r0 = (android.support.v7.media.MediaRouter.ProviderInfo) r0;
            r0 = r0.f16300a;
            if (r0 != r4) goto L_0x0017;
        L_0x0015:
            r0 = r1;
        L_0x0016:
            return r0;
        L_0x0017:
            r1 = r1 + 1;
            goto L_0x0007;
        L_0x001a:
            r0 = -1;
            goto L_0x0016;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.c(android.support.v7.media.MediaRouteProvider):int");
        }

        private void m20355a(android.support.v7.media.MediaRouter.ProviderInfo r12, android.support.v7.media.MediaRouteProviderDescriptor r13) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r11 = this;
            r2 = 0;
            r10 = r12.f16303d;
            if (r10 == r13) goto L_0x019e;
        L_0x0005:
            r12.f16303d = r13;
            r10 = 1;
        L_0x0008:
            r0 = r10;
            if (r0 == 0) goto L_0x0199;
        L_0x000b:
            if (r13 == 0) goto L_0x0120;
        L_0x000d:
            r0 = r13.m20336b();
            if (r0 == 0) goto L_0x010c;
        L_0x0013:
            r6 = r13.m20335a();
            r7 = r6.size();
            r5 = r2;
            r3 = r2;
        L_0x001d:
            if (r5 >= r7) goto L_0x0121;
        L_0x001f:
            r0 = r6.get(r5);
            r0 = (android.support.v7.media.MediaRouteDescriptor) r0;
            r1 = r0.m20301a();
            r8 = r12.m20369a(r1);
            if (r8 >= 0) goto L_0x006d;
        L_0x002f:
            r4 = r11.m20353a(r12, r1);
            r8 = new android.support.v7.media.MediaRouter$RouteInfo;
            r8.<init>(r12, r1, r4);
            r4 = r12.f16301b;
            r1 = r3 + 1;
            r4.add(r3, r8);
            r3 = r11.f16285c;
            r3.add(r8);
            r8.m20371a(r0);
            r0 = android.support.v7.media.MediaRouter.f16322d;
            if (r0 == 0) goto L_0x005f;
        L_0x004b:
            r0 = "MediaRouter";
            r3 = new java.lang.StringBuilder;
            r4 = "Route added: ";
            r3.<init>(r4);
            r3 = r3.append(r8);
            r3 = r3.toString();
            android.util.Log.d(r0, r3);
        L_0x005f:
            r0 = r11.f16290h;
            r3 = 257; // 0x101 float:3.6E-43 double:1.27E-321;
            r0.m20348a(r3, r8);
            r0 = r2;
        L_0x0067:
            r2 = r5 + 1;
            r5 = r2;
            r3 = r1;
            r2 = r0;
            goto L_0x001d;
        L_0x006d:
            if (r8 >= r3) goto L_0x0086;
        L_0x006f:
            r1 = "MediaRouter";
            r4 = new java.lang.StringBuilder;
            r8 = "Ignoring route descriptor with duplicate id: ";
            r4.<init>(r8);
            r0 = r4.append(r0);
            r0 = r0.toString();
            android.util.Log.w(r1, r0);
            r0 = r2;
            r1 = r3;
            goto L_0x0067;
        L_0x0086:
            r1 = r12.f16301b;
            r1 = r1.get(r8);
            r1 = (android.support.v7.media.MediaRouter.RouteInfo) r1;
            r9 = r12.f16301b;
            r4 = r3 + 1;
            java.util.Collections.swap(r9, r8, r3);
            r0 = r1.m20371a(r0);
            if (r0 == 0) goto L_0x019a;
        L_0x009b:
            r3 = r0 & 1;
            if (r3 == 0) goto L_0x00be;
        L_0x009f:
            r3 = android.support.v7.media.MediaRouter.f16322d;
            if (r3 == 0) goto L_0x00b7;
        L_0x00a3:
            r3 = "MediaRouter";
            r8 = new java.lang.StringBuilder;
            r9 = "Route changed: ";
            r8.<init>(r9);
            r8 = r8.append(r1);
            r8 = r8.toString();
            android.util.Log.d(r3, r8);
        L_0x00b7:
            r3 = r11.f16290h;
            r8 = 259; // 0x103 float:3.63E-43 double:1.28E-321;
            r3.m20348a(r8, r1);
        L_0x00be:
            r3 = r0 & 2;
            if (r3 == 0) goto L_0x00e1;
        L_0x00c2:
            r3 = android.support.v7.media.MediaRouter.f16322d;
            if (r3 == 0) goto L_0x00da;
        L_0x00c6:
            r3 = "MediaRouter";
            r8 = new java.lang.StringBuilder;
            r9 = "Route volume changed: ";
            r8.<init>(r9);
            r8 = r8.append(r1);
            r8 = r8.toString();
            android.util.Log.d(r3, r8);
        L_0x00da:
            r3 = r11.f16290h;
            r8 = 260; // 0x104 float:3.64E-43 double:1.285E-321;
            r3.m20348a(r8, r1);
        L_0x00e1:
            r0 = r0 & 4;
            if (r0 == 0) goto L_0x0104;
        L_0x00e5:
            r0 = android.support.v7.media.MediaRouter.f16322d;
            if (r0 == 0) goto L_0x00fd;
        L_0x00e9:
            r0 = "MediaRouter";
            r3 = new java.lang.StringBuilder;
            r8 = "Route presentation display changed: ";
            r3.<init>(r8);
            r3 = r3.append(r1);
            r3 = r3.toString();
            android.util.Log.d(r0, r3);
        L_0x00fd:
            r0 = r11.f16290h;
            r3 = 261; // 0x105 float:3.66E-43 double:1.29E-321;
            r0.m20348a(r3, r1);
        L_0x0104:
            r0 = r11.f16296n;
            if (r1 != r0) goto L_0x019a;
        L_0x0108:
            r0 = 1;
            r1 = r4;
            goto L_0x0067;
        L_0x010c:
            r0 = "MediaRouter";
            r1 = new java.lang.StringBuilder;
            r3 = "Ignoring invalid provider descriptor: ";
            r1.<init>(r3);
            r1 = r1.append(r13);
            r1 = r1.toString();
            android.util.Log.w(r0, r1);
        L_0x0120:
            r3 = r2;
        L_0x0121:
            r0 = r12.f16301b;
            r0 = r0.size();
            r0 = r0 + -1;
            r1 = r0;
        L_0x012a:
            if (r1 < r3) goto L_0x0141;
        L_0x012c:
            r0 = r12.f16301b;
            r0 = r0.get(r1);
            r0 = (android.support.v7.media.MediaRouter.RouteInfo) r0;
            r4 = 0;
            r0.m20371a(r4);
            r4 = r11.f16285c;
            r4.remove(r0);
            r0 = r1 + -1;
            r1 = r0;
            goto L_0x012a;
        L_0x0141:
            r11.m20356a(r2);
            r0 = r12.f16301b;
            r0 = r0.size();
            r0 = r0 + -1;
            r1 = r0;
        L_0x014d:
            if (r1 < r3) goto L_0x017a;
        L_0x014f:
            r0 = r12.f16301b;
            r0 = r0.remove(r1);
            r0 = (android.support.v7.media.MediaRouter.RouteInfo) r0;
            r2 = android.support.v7.media.MediaRouter.f16322d;
            if (r2 == 0) goto L_0x016f;
        L_0x015b:
            r2 = "MediaRouter";
            r4 = new java.lang.StringBuilder;
            r5 = "Route removed: ";
            r4.<init>(r5);
            r4 = r4.append(r0);
            r4 = r4.toString();
            android.util.Log.d(r2, r4);
        L_0x016f:
            r2 = r11.f16290h;
            r4 = 258; // 0x102 float:3.62E-43 double:1.275E-321;
            r2.m20348a(r4, r0);
            r0 = r1 + -1;
            r1 = r0;
            goto L_0x014d;
        L_0x017a:
            r0 = android.support.v7.media.MediaRouter.f16322d;
            if (r0 == 0) goto L_0x0192;
        L_0x017e:
            r0 = "MediaRouter";
            r1 = new java.lang.StringBuilder;
            r2 = "Provider changed: ";
            r1.<init>(r2);
            r1 = r1.append(r12);
            r1 = r1.toString();
            android.util.Log.d(r0, r1);
        L_0x0192:
            r0 = r11.f16290h;
            r1 = 515; // 0x203 float:7.22E-43 double:2.544E-321;
            r0.m20348a(r1, r12);
        L_0x0199:
            return;
        L_0x019a:
            r0 = r2;
            r1 = r4;
            goto L_0x0067;
        L_0x019e:
            r10 = 0;
            goto L_0x0008;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.a(android.support.v7.media.MediaRouter$ProviderInfo, android.support.v7.media.MediaRouteProviderDescriptor):void");
        }

        private java.lang.String m20353a(android.support.v7.media.MediaRouter.ProviderInfo r11, java.lang.String r12) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r10 = this;
            r1 = 2;
            r0 = new java.lang.StringBuilder;
            r0.<init>();
            r8 = r11.f16302c;
            r9 = r8.f16254a;
            r8 = r9;
            r2 = r8;
            r2 = r2.flattenToShortString();
            r0 = r0.append(r2);
            r2 = ":";
            r0 = r0.append(r2);
            r0 = r0.append(r12);
            r2 = r0.toString();
            r0 = r10.m20357b(r2);
            if (r0 >= 0) goto L_0x002a;
        L_0x0028:
            r0 = r2;
        L_0x0029:
            return r0;
        L_0x002a:
            r0 = r1;
        L_0x002b:
            r3 = java.util.Locale.US;
            r4 = "%s_%d";
            r5 = new java.lang.Object[r1];
            r6 = 0;
            r5[r6] = r2;
            r6 = 1;
            r7 = java.lang.Integer.valueOf(r0);
            r5[r6] = r7;
            r3 = java.lang.String.format(r3, r4, r5);
            r4 = r10.m20357b(r3);
            if (r4 >= 0) goto L_0x0047;
        L_0x0045:
            r0 = r3;
            goto L_0x0029;
        L_0x0047:
            r0 = r0 + 1;
            goto L_0x002b;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.a(android.support.v7.media.MediaRouter$ProviderInfo, java.lang.String):java.lang.String");
        }

        private int m20357b(java.lang.String r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r3 = this;
            r0 = r3.f16285c;
            r2 = r0.size();
            r1 = 0;
        L_0x0007:
            if (r1 >= r2) goto L_0x001e;
        L_0x0009:
            r0 = r3.f16285c;
            r0 = r0.get(r1);
            r0 = (android.support.v7.media.MediaRouter.RouteInfo) r0;
            r0 = r0.f16306c;
            r0 = r0.equals(r4);
            if (r0 == 0) goto L_0x001b;
        L_0x0019:
            r0 = r1;
        L_0x001a:
            return r0;
        L_0x001b:
            r1 = r1 + 1;
            goto L_0x0007;
        L_0x001e:
            r0 = -1;
            goto L_0x001a;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.b(java.lang.String):int");
        }

        private void m20356a(boolean r10) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r9 = this;
            r3 = 0;
            r0 = r9.f16295m;
            if (r0 == 0) goto L_0x0025;
        L_0x0005:
            r0 = r9.f16295m;
            r0 = m20359c(r0);
            if (r0 != 0) goto L_0x0025;
        L_0x000d:
            r0 = "MediaRouter";
            r1 = new java.lang.StringBuilder;
            r2 = "Clearing the default route because it is no longer selectable: ";
            r1.<init>(r2);
            r2 = r9.f16295m;
            r1 = r1.append(r2);
            r1 = r1.toString();
            android.util.Log.i(r0, r1);
            r9.f16295m = r3;
        L_0x0025:
            r0 = r9.f16295m;
            if (r0 != 0) goto L_0x0077;
        L_0x0029:
            r0 = r9.f16285c;
            r0 = r0.isEmpty();
            if (r0 != 0) goto L_0x0077;
        L_0x0031:
            r0 = r9.f16285c;
            r1 = r0.iterator();
        L_0x0037:
            r0 = r1.hasNext();
            if (r0 == 0) goto L_0x0077;
        L_0x003d:
            r0 = r1.next();
            r0 = (android.support.v7.media.MediaRouter.RouteInfo) r0;
            r4 = r0.m20379p();
            r5 = r9.f16292j;
            if (r4 != r5) goto L_0x00e3;
        L_0x004b:
            r4 = r0.f16305b;
            r5 = "DEFAULT_ROUTE";
            r4 = r4.equals(r5);
            if (r4 == 0) goto L_0x00e3;
        L_0x0055:
            r4 = 1;
        L_0x0056:
            r2 = r4;
            if (r2 == 0) goto L_0x0037;
        L_0x0059:
            r2 = m20359c(r0);
            if (r2 == 0) goto L_0x0037;
        L_0x005f:
            r9.f16295m = r0;
            r0 = "MediaRouter";
            r1 = new java.lang.StringBuilder;
            r2 = "Found default route: ";
            r1.<init>(r2);
            r2 = r9.f16295m;
            r1 = r1.append(r2);
            r1 = r1.toString();
            android.util.Log.i(r0, r1);
        L_0x0077:
            r0 = r9.f16296n;
            if (r0 == 0) goto L_0x009c;
        L_0x007b:
            r0 = r9.f16296n;
            r0 = m20359c(r0);
            if (r0 != 0) goto L_0x009c;
        L_0x0083:
            r0 = "MediaRouter";
            r1 = new java.lang.StringBuilder;
            r2 = "Unselecting the current route because it is no longer selectable: ";
            r1.<init>(r2);
            r2 = r9.f16296n;
            r1 = r1.append(r2);
            r1 = r1.toString();
            android.util.Log.i(r0, r1);
            r9.m20360e(r3);
        L_0x009c:
            r0 = r9.f16296n;
            if (r0 != 0) goto L_0x00dd;
        L_0x00a0:
            r4 = r9.f16285c;
            r5 = r4.iterator();
        L_0x00a6:
            r4 = r5.hasNext();
            if (r4 == 0) goto L_0x00e6;
        L_0x00ac:
            r4 = r5.next();
            r4 = (android.support.v7.media.MediaRouter.RouteInfo) r4;
            r6 = r9.f16295m;
            if (r4 == r6) goto L_0x00a6;
        L_0x00b6:
            r7 = r4.m20379p();
            r8 = r9.f16292j;
            if (r7 != r8) goto L_0x00e9;
        L_0x00be:
            r7 = "android.media.intent.category.LIVE_AUDIO";
            r7 = r4.m20374a(r7);
            if (r7 == 0) goto L_0x00e9;
        L_0x00c6:
            r7 = "android.media.intent.category.LIVE_VIDEO";
            r7 = r4.m20374a(r7);
            if (r7 != 0) goto L_0x00e9;
        L_0x00ce:
            r7 = 1;
        L_0x00cf:
            r6 = r7;
            if (r6 == 0) goto L_0x00a6;
        L_0x00d2:
            r6 = m20359c(r4);
            if (r6 == 0) goto L_0x00a6;
        L_0x00d8:
            r0 = r4;
            r9.m20360e(r0);
        L_0x00dc:
            return;
        L_0x00dd:
            if (r10 == 0) goto L_0x00dc;
        L_0x00df:
            r9.m20361g();
            goto L_0x00dc;
        L_0x00e3:
            r4 = 0;
            goto L_0x0056;
        L_0x00e6:
            r4 = r9.f16295m;
            goto L_0x00d8;
        L_0x00e9:
            r7 = 0;
            goto L_0x00cf;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.a(boolean):void");
        }

        public static boolean m20359c(android.support.v7.media.MediaRouter.RouteInfo r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r0 = r1.f16320q;
            if (r0 == 0) goto L_0x000a;
        L_0x0004:
            r0 = r1.f16309f;
            if (r0 == 0) goto L_0x000a;
        L_0x0008:
            r0 = 1;
        L_0x0009:
            return r0;
        L_0x000a:
            r0 = 0;
            goto L_0x0009;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.c(android.support.v7.media.MediaRouter$RouteInfo):boolean");
        }

        private void m20360e(android.support.v7.media.MediaRouter.RouteInfo r4) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r3 = this;
            r0 = r3.f16296n;
            if (r0 == r4) goto L_0x007d;
        L_0x0004:
            r0 = r3.f16296n;
            if (r0 == 0) goto L_0x003c;
        L_0x0008:
            r0 = android.support.v7.media.MediaRouter.f16322d;
            if (r0 == 0) goto L_0x0022;
        L_0x000c:
            r0 = "MediaRouter";
            r1 = new java.lang.StringBuilder;
            r2 = "Route unselected: ";
            r1.<init>(r2);
            r2 = r3.f16296n;
            r1 = r1.append(r2);
            r1 = r1.toString();
            android.util.Log.d(r0, r1);
        L_0x0022:
            r0 = r3.f16290h;
            r1 = 263; // 0x107 float:3.69E-43 double:1.3E-321;
            r2 = r3.f16296n;
            r0.m20348a(r1, r2);
            r0 = r3.f16297o;
            if (r0 == 0) goto L_0x003c;
        L_0x002f:
            r0 = r3.f16297o;
            r0.mo1262c();
            r0 = r3.f16297o;
            r0.mo1258a();
            r0 = 0;
            r3.f16297o = r0;
        L_0x003c:
            r3.f16296n = r4;
            r0 = r3.f16296n;
            if (r0 == 0) goto L_0x007a;
        L_0x0042:
            r0 = r4.m20379p();
            r1 = r4.f16305b;
            r0 = r0.mo1263a(r1);
            r3.f16297o = r0;
            r0 = r3.f16297o;
            if (r0 == 0) goto L_0x0057;
        L_0x0052:
            r0 = r3.f16297o;
            r0.mo1260b();
        L_0x0057:
            r0 = android.support.v7.media.MediaRouter.f16322d;
            if (r0 == 0) goto L_0x0071;
        L_0x005b:
            r0 = "MediaRouter";
            r1 = new java.lang.StringBuilder;
            r2 = "Route selected: ";
            r1.<init>(r2);
            r2 = r3.f16296n;
            r1 = r1.append(r2);
            r1 = r1.toString();
            android.util.Log.d(r0, r1);
        L_0x0071:
            r0 = r3.f16290h;
            r1 = 262; // 0x106 float:3.67E-43 double:1.294E-321;
            r2 = r3.f16296n;
            r0.m20348a(r1, r2);
        L_0x007a:
            r3.m20361g();
        L_0x007d:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.e(android.support.v7.media.MediaRouter$RouteInfo):void");
        }

        public final android.support.v7.media.MediaRouter.RouteInfo mo1255a(java.lang.String r3) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r2 = this;
            r0 = r2.f16292j;
            r0 = r2.m20358c(r0);
            if (r0 < 0) goto L_0x001f;
        L_0x0008:
            r1 = r2.f16286d;
            r0 = r1.get(r0);
            r0 = (android.support.v7.media.MediaRouter.ProviderInfo) r0;
            r1 = r0.m20369a(r3);
            if (r1 < 0) goto L_0x001f;
        L_0x0016:
            r0 = r0.f16301b;
            r0 = r0.get(r1);
            r0 = (android.support.v7.media.MediaRouter.RouteInfo) r0;
        L_0x001e:
            return r0;
        L_0x001f:
            r0 = 0;
            goto L_0x001e;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.a(java.lang.String):android.support.v7.media.MediaRouter$RouteInfo");
        }

        private void m20361g() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: SSA rename variables already executed
	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:120)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:52)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
            r6 = this;
            r0 = 0;
            r1 = r6.f16296n;
            if (r1 == 0) goto L_0x0073;
        L_0x0005:
            r1 = r6.f16288f;
            r2 = r6.f16296n;
            r4 = r2.f16315l;
            r2 = r4;
            r1.f16373a = r2;
            r1 = r6.f16288f;
            r2 = r6.f16296n;
            r4 = r2.f16316m;
            r2 = r4;
            r1.f16374b = r2;
            r1 = r6.f16288f;
            r2 = r6.f16296n;
            r4 = r2.f16314k;
            r2 = r4;
            r1.f16375c = r2;
            r1 = r6.f16288f;
            r2 = r6.f16296n;
            r4 = r2.f16313j;
            r2 = r4;
            r1.f16376d = r2;
            r1 = r6.f16288f;
            r2 = r6.f16296n;
            r4 = r2.f16312i;
            r2 = r4;
            r1.f16377e = r2;
            r1 = r6.f16287e;
            r2 = r1.size();
            r1 = r0;
        L_0x0039:
            if (r1 >= r2) goto L_0x0043;
        L_0x003b:
            r3 = r6.f16287e;
            r3.get(r1);
            r1 = r1 + 1;
            goto L_0x0039;
        L_0x0043:
            r1 = r6.f16299q;
            if (r1 == 0) goto L_0x0073;
        L_0x0047:
            r1 = r6.f16288f;
            r1 = r1.f16375c;
            r2 = 1;
            if (r1 != r2) goto L_0x004f;
        L_0x004e:
            r0 = 2;
        L_0x004f:
            r1 = r6.f16299q;
            r2 = r6.f16288f;
            r2 = r2.f16374b;
            r3 = r6.f16288f;
            r3 = r3.f16373a;
            r4 = r1.f16281d;
            if (r4 == 0) goto L_0x0065;
        L_0x005d:
            r4 = r1.f16279b;
            if (r0 != r4) goto L_0x0065;
        L_0x0061:
            r4 = r1.f16280c;
            if (r2 == r4) goto L_0x0073;
        L_0x0065:
            r4 = new android.support.v7.media.MediaRouter$GlobalMediaRouter$MediaSessionRecord$1;
            r4.<init>(r1, r0, r2, r3);
            r1.f16281d = r4;
            r4 = r1.f16278a;
            r5 = r1.f16281d;
            r4.a(r5);
        L_0x0073:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.media.MediaRouter.GlobalMediaRouter.g():void");
        }
    }

    /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
    public final class ProviderInfo {
        public final MediaRouteProvider f16300a;
        public final ArrayList<RouteInfo> f16301b = new ArrayList();
        public final ProviderMetadata f16302c;
        public MediaRouteProviderDescriptor f16303d;

        ProviderInfo(MediaRouteProvider mediaRouteProvider) {
            this.f16300a = mediaRouteProvider;
            this.f16302c = mediaRouteProvider.f16256b;
        }

        public final String m20370b() {
            return this.f16302c.f16254a.getPackageName();
        }

        final int m20369a(String str) {
            int size = this.f16301b.size();
            for (int i = 0; i < size; i++) {
                if (((RouteInfo) this.f16301b.get(i)).f16305b.equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        public final String toString() {
            return "MediaRouter.RouteProviderInfo{ packageName=" + m20370b() + " }";
        }
    }

    /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
    public final class RouteInfo {
        private final ProviderInfo f16304a;
        public final String f16305b;
        public final String f16306c;
        public String f16307d;
        public String f16308e;
        public boolean f16309f;
        public boolean f16310g;
        private final ArrayList<IntentFilter> f16311h = new ArrayList();
        public int f16312i;
        public int f16313j;
        public int f16314k;
        public int f16315l;
        public int f16316m;
        private Display f16317n;
        private int f16318o = -1;
        public Bundle f16319p;
        public MediaRouteDescriptor f16320q;

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
        @interface PlaybackType {
        }

        @Retention(RetentionPolicy.SOURCE)
        /* compiled from: custom_cta_mobile_contact_us_toggle_responded */
        @interface PlaybackVolume {
        }

        RouteInfo(ProviderInfo providerInfo, String str, String str2) {
            this.f16304a = providerInfo;
            this.f16305b = str;
            this.f16306c = str2;
        }

        public final boolean m20376f() {
            MediaRouter.m20388d();
            return MediaRouter.f16321a.m20367d() == this;
        }

        public final boolean m20377g() {
            MediaRouter.m20388d();
            return MediaRouter.f16321a.m20366c() == this;
        }

        public final boolean m20373a(@NonNull MediaRouteSelector mediaRouteSelector) {
            if (mediaRouteSelector == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            boolean z;
            MediaRouter.m20388d();
            List list = this.f16311h;
            if (list != null) {
                MediaRouteSelector.m20343e(mediaRouteSelector);
                int size = mediaRouteSelector.f16270c.size();
                if (size != 0) {
                    int size2 = list.size();
                    loop0:
                    for (int i = 0; i < size2; i++) {
                        IntentFilter intentFilter = (IntentFilter) list.get(i);
                        if (intentFilter != null) {
                            for (int i2 = 0; i2 < size; i2++) {
                                if (intentFilter.hasCategory((String) mediaRouteSelector.f16270c.get(i2))) {
                                    z = true;
                                    break loop0;
                                }
                            }
                            continue;
                        }
                    }
                }
            }
            z = false;
            return z;
        }

        public final boolean m20374a(@NonNull String str) {
            if (str == null) {
                throw new IllegalArgumentException("category must not be null");
            }
            MediaRouter.m20388d();
            int size = this.f16311h.size();
            for (int i = 0; i < size; i++) {
                if (((IntentFilter) this.f16311h.get(i)).hasCategory(str)) {
                    return true;
                }
            }
            return false;
        }

        public final void m20372a(int i) {
            MediaRouter.m20388d();
            GlobalMediaRouter globalMediaRouter = MediaRouter.f16321a;
            int min = Math.min(this.f16316m, Math.max(0, i));
            if (this == globalMediaRouter.f16296n && globalMediaRouter.f16297o != null) {
                globalMediaRouter.f16297o.mo1259a(min);
            }
        }

        public final void m20375b(int i) {
            MediaRouter.m20388d();
            if (i != 0) {
                GlobalMediaRouter globalMediaRouter = MediaRouter.f16321a;
                if (this == globalMediaRouter.f16296n && globalMediaRouter.f16297o != null) {
                    globalMediaRouter.f16297o.mo1261b(i);
                }
            }
        }

        public final void m20378n() {
            MediaRouter.m20388d();
            MediaRouter.f16321a.m20364a(this);
        }

        public final String toString() {
            return "MediaRouter.RouteInfo{ uniqueId=" + this.f16306c + ", name=" + this.f16307d + ", description=" + this.f16308e + ", enabled=" + this.f16309f + ", connecting=" + this.f16310g + ", playbackType=" + this.f16312i + ", playbackStream=" + this.f16313j + ", volumeHandling=" + this.f16314k + ", volume=" + this.f16315l + ", volumeMax=" + this.f16316m + ", presentationDisplayId=" + this.f16318o + ", extras=" + this.f16319p + ", providerPackageName=" + this.f16304a.m20370b() + " }";
        }

        final int m20371a(MediaRouteDescriptor mediaRouteDescriptor) {
            int i = 1;
            int i2 = 0;
            if (this.f16320q == mediaRouteDescriptor) {
                return 0;
            }
            this.f16320q = mediaRouteDescriptor;
            if (mediaRouteDescriptor == null) {
                return 0;
            }
            if (!MediaRouter.m20384a(this.f16307d, mediaRouteDescriptor.m20302b())) {
                this.f16307d = mediaRouteDescriptor.m20302b();
                i2 = 1;
            }
            if (!MediaRouter.m20384a(this.f16308e, mediaRouteDescriptor.m20303c())) {
                this.f16308e = mediaRouteDescriptor.m20303c();
                i2 = 1;
            }
            if (this.f16309f != mediaRouteDescriptor.m20304d()) {
                this.f16309f = mediaRouteDescriptor.m20304d();
            } else {
                i = i2;
            }
            if (this.f16310g != mediaRouteDescriptor.m20305e()) {
                this.f16310g = mediaRouteDescriptor.m20305e();
                i |= 1;
            }
            if (!this.f16311h.equals(mediaRouteDescriptor.m20306f())) {
                this.f16311h.clear();
                this.f16311h.addAll(mediaRouteDescriptor.m20306f());
                i |= 1;
            }
            if (this.f16312i != mediaRouteDescriptor.m20307g()) {
                this.f16312i = mediaRouteDescriptor.m20307g();
                i |= 1;
            }
            if (this.f16313j != mediaRouteDescriptor.m20308h()) {
                this.f16313j = mediaRouteDescriptor.m20308h();
                i |= 1;
            }
            if (this.f16314k != mediaRouteDescriptor.m20311k()) {
                this.f16314k = mediaRouteDescriptor.m20311k();
                i |= 3;
            }
            if (this.f16315l != mediaRouteDescriptor.m20309i()) {
                this.f16315l = mediaRouteDescriptor.m20309i();
                i |= 3;
            }
            if (this.f16316m != mediaRouteDescriptor.m20310j()) {
                this.f16316m = mediaRouteDescriptor.m20310j();
                i |= 3;
            }
            if (this.f16318o != mediaRouteDescriptor.m20312l()) {
                this.f16318o = mediaRouteDescriptor.m20312l();
                this.f16317n = null;
                i |= 5;
            }
            if (MediaRouter.m20384a(this.f16319p, mediaRouteDescriptor.m20313m())) {
                return i;
            }
            this.f16319p = mediaRouteDescriptor.m20313m();
            return i | 1;
        }

        public final MediaRouteProvider m20379p() {
            ProviderInfo providerInfo = this.f16304a;
            MediaRouter.m20388d();
            return providerInfo.f16300a;
        }
    }

    public MediaRouter(Context context) {
        this.f16323b = context;
    }

    public static MediaRouter m20380a(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context must not be null");
        }
        GlobalMediaRouter globalMediaRouter;
        MediaRouter mediaRouter;
        m20388d();
        if (f16321a == null) {
            globalMediaRouter = new GlobalMediaRouter(context.getApplicationContext());
            f16321a = globalMediaRouter;
            globalMediaRouter.f16294l = new RegisteredMediaRouteProviderWatcher(globalMediaRouter.f16283a, globalMediaRouter);
            RegisteredMediaRouteProviderWatcher registeredMediaRouteProviderWatcher = globalMediaRouter.f16294l;
            if (!registeredMediaRouteProviderWatcher.f16370f) {
                registeredMediaRouteProviderWatcher.f16370f = true;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
                intentFilter.addDataScheme("package");
                registeredMediaRouteProviderWatcher.f16365a.registerReceiver(registeredMediaRouteProviderWatcher.f16371g, intentFilter, null, registeredMediaRouteProviderWatcher.f16367c);
                HandlerDetour.a(registeredMediaRouteProviderWatcher.f16367c, registeredMediaRouteProviderWatcher.f16372h, 187255187);
            }
        }
        globalMediaRouter = f16321a;
        int size = globalMediaRouter.f16284b.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                break;
            }
            mediaRouter = (MediaRouter) ((WeakReference) globalMediaRouter.f16284b.get(i)).get();
            if (mediaRouter == null) {
                globalMediaRouter.f16284b.remove(i);
                size = i;
            } else if (mediaRouter.f16323b == context) {
                break;
            } else {
                size = i;
            }
        }
        mediaRouter = new MediaRouter(context);
        globalMediaRouter.f16284b.add(new WeakReference(mediaRouter));
        return mediaRouter;
    }

    public static List<RouteInfo> m20381a() {
        m20388d();
        return f16321a.f16285c;
    }

    @NonNull
    public static RouteInfo m20386b() {
        m20388d();
        return f16321a.m20366c();
    }

    @NonNull
    public static RouteInfo m20387c() {
        m20388d();
        return f16321a.m20367d();
    }

    public static void m20382a(@NonNull RouteInfo routeInfo) {
        if (routeInfo == null) {
            throw new IllegalArgumentException("route must not be null");
        }
        m20388d();
        if (f16322d) {
            Log.d("MediaRouter", "selectRoute: " + routeInfo);
        }
        f16321a.m20364a(routeInfo);
    }

    public static boolean m20383a(@NonNull MediaRouteSelector mediaRouteSelector, int i) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        boolean z;
        m20388d();
        GlobalMediaRouter globalMediaRouter = f16321a;
        if (mediaRouteSelector.m20345b()) {
            z = false;
        } else if ((i & 2) == 0 && globalMediaRouter.f16293k) {
            z = true;
        } else {
            int size = globalMediaRouter.f16285c.size();
            for (int i2 = 0; i2 < size; i2++) {
                RouteInfo routeInfo = (RouteInfo) globalMediaRouter.f16285c.get(i2);
                if (((i & 1) == 0 || !routeInfo.m20377g()) && routeInfo.m20373a(mediaRouteSelector)) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public final void m20389a(MediaRouteSelector mediaRouteSelector, Callback callback) {
        m20390a(mediaRouteSelector, callback, 0);
    }

    public final void m20390a(@NonNull MediaRouteSelector mediaRouteSelector, @NonNull Callback callback, int i) {
        Object obj = 1;
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        } else {
            CallbackRecord callbackRecord;
            boolean containsAll;
            m20388d();
            if (f16322d) {
                Log.d("MediaRouter", "addCallback: selector=" + mediaRouteSelector + ", callback=" + callback + ", flags=" + Integer.toHexString(i));
            }
            int b = m20385b(callback);
            if (b < 0) {
                callbackRecord = new CallbackRecord(this, callback);
                this.f16324c.add(callbackRecord);
            } else {
                callbackRecord = (CallbackRecord) this.f16324c.get(b);
            }
            Object obj2 = null;
            if (((callbackRecord.f16274d ^ -1) & i) != 0) {
                callbackRecord.f16274d |= i;
                obj2 = 1;
            }
            MediaRouteSelector mediaRouteSelector2 = callbackRecord.f16273c;
            if (mediaRouteSelector != null) {
                MediaRouteSelector.m20343e(mediaRouteSelector2);
                MediaRouteSelector.m20343e(mediaRouteSelector);
                containsAll = mediaRouteSelector2.f16270c.containsAll(mediaRouteSelector.f16270c);
            } else {
                containsAll = false;
            }
            if (containsAll) {
                obj = obj2;
            } else {
                callbackRecord.f16273c = new Builder(callbackRecord.f16273c).m20339a(mediaRouteSelector).m20341a();
            }
            if (obj != null) {
                f16321a.m20368e();
            }
        }
    }

    public final void m20391a(@NonNull Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        m20388d();
        if (f16322d) {
            Log.d("MediaRouter", "removeCallback: callback=" + callback);
        }
        int b = m20385b(callback);
        if (b >= 0) {
            this.f16324c.remove(b);
            f16321a.m20368e();
        }
    }

    private int m20385b(Callback callback) {
        int size = this.f16324c.size();
        for (int i = 0; i < size; i++) {
            if (((CallbackRecord) this.f16324c.get(i)).f16272b == callback) {
                return i;
            }
        }
        return -1;
    }

    public static void m20388d() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("The media router service must only be accessed on the application's main thread.");
        }
    }

    static <T> boolean m20384a(T t, T t2) {
        return t == t2 || !(t == null || t2 == null || !t.equals(t2));
    }
}
