package com.facebook.video.engine.texview;

import android.app.Activity;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.video.view.TextureViewHolder.1;
import com.facebook.video.view.TextureViewHolder.AttachManager;
import com.facebook.video.view.TextureViewHolder.ManagedAttachment;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: pyml_unfan */
public class TextureAttachManager implements AttachManager {
    private static final String f8551a = TextureAttachManager.class.getName();
    private static volatile TextureAttachManager f8552f;
    private final AbstractFbErrorReporter f8553b;
    public Map<Activity, ActivityInfo> f8554c = Maps.m838c();
    public Map<ManagedAttachment, Activity> f8555d = Maps.m838c();
    private Activity f8556e = null;

    /* compiled from: pyml_unfan */
    public class ActivityInfo {
        public final /* synthetic */ TextureAttachManager f23259a;
        public final Activity f23260b;
        public final Set<ManagedAttachment> f23261c = Sets.m1313a();
        private boolean f23262d = false;
        private boolean f23263e = true;

        public ActivityInfo(TextureAttachManager textureAttachManager, Activity activity) {
            this.f23259a = textureAttachManager;
            this.f23260b = activity;
        }

        public final void m31388a(1 1) {
            this.f23261c.add(1);
            this.f23259a.f8555d.put(1, this.f23260b);
            if (!this.f23262d) {
                this.f23262d = true;
                this.f23259a.f8554c.put(this.f23260b, this);
            }
        }

        public final void m31389b(1 1) {
            this.f23261c.remove(1);
            this.f23259a.f8555d.remove(1);
            if (this.f23262d && this.f23261c.isEmpty()) {
                this.f23262d = false;
                this.f23259a.f8554c.remove(this.f23260b);
            }
        }
    }

    public static com.facebook.video.engine.texview.TextureAttachManager m13098a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8552f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.engine.texview.TextureAttachManager.class;
        monitor-enter(r1);
        r0 = f8552f;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13099b(r0);	 Catch:{ all -> 0x0035 }
        f8552f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8552f;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.engine.texview.TextureAttachManager.a(com.facebook.inject.InjectorLike):com.facebook.video.engine.texview.TextureAttachManager");
    }

    private static TextureAttachManager m13099b(InjectorLike injectorLike) {
        return new TextureAttachManager(FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public TextureAttachManager(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f8553b = abstractFbErrorReporter;
    }

    private ActivityInfo m13100d(Activity activity) {
        ActivityInfo activityInfo = (ActivityInfo) this.f8554c.get(activity);
        return activityInfo == null ? new ActivityInfo(this, activity) : activityInfo;
    }

    public final synchronized void m13102a(1 1) {
        if (this.f8556e == null) {
            this.f8553b.m2343a(f8551a, "Component attached and no current activity", new IllegalStateException("This is a marker exception"));
        } else {
            m13100d(this.f8556e).m31388a(1);
        }
    }

    public final synchronized void m13104b(1 1) {
        Activity activity = (Activity) this.f8555d.get(1);
        Integer.valueOf(1.hashCode());
        if (activity != null) {
            Integer.valueOf(activity.hashCode());
        }
        if (activity != null) {
            m13100d(activity).m31389b(1);
        }
    }

    public final synchronized void m13101a(Activity activity) {
        Integer.valueOf(activity.hashCode());
        if (activity != null) {
            activity.getTitle();
        }
        this.f8556e = activity;
        for (1 1 : this.f8555d.keySet()) {
            Integer.valueOf(1.hashCode());
            1.a();
        }
    }

    public final synchronized void m13103b(Activity activity) {
        Integer.valueOf(activity.hashCode());
        if (activity != null) {
            activity.getTitle();
        }
        for (1 1 : this.f8555d.keySet()) {
            Integer.valueOf(1.hashCode());
            1.b();
        }
        if (this.f8556e == activity) {
            this.f8556e = null;
        }
    }

    public final void m13105c(Activity activity) {
        Integer.valueOf(activity.hashCode());
        ActivityInfo d = m13100d(activity);
        for (1 remove : d.f23261c) {
            d.f23259a.f8555d.remove(remove);
        }
        d.f23259a.f8554c.remove(d.f23260b);
    }
}
