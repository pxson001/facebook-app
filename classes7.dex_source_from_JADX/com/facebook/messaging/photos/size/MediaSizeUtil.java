package com.facebook.messaging.photos.size;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.attachment.AttachmentImageType;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: offset_from_top */
public class MediaSizeUtil {
    private static final Class f7844a = MediaSizeUtil.class;
    private static volatile MediaSizeUtil f7845q;
    private final Context f7846b;
    private final WindowManager f7847c;
    private final GatekeeperStoreImpl f7848d;
    private volatile int f7849e;
    private volatile int f7850f;
    private volatile int f7851g;
    private volatile int f7852h;
    private volatile int f7853i;
    private volatile Point f7854j;
    private volatile String f7855k;
    private volatile Rect f7856l;
    private volatile Rect f7857m;
    private volatile Rect f7858n;
    private volatile Rect f7859o;
    private final Provider<Boolean> f7860p;

    /* compiled from: offset_from_top */
    enum Size {
        TWO_IMAGE_WIDTH_HEIGHT(175),
        THREE_IMAGE_WIDTH_HEIGHT(130),
        SINGLE_IMAGE_LANDSCAPE_HEIGHT(280),
        SINGLE_IMAGE_PORTRAIT_SQUARE_HEIGHT(320),
        SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT(320);
        
        public final int dp;

        private Size(int i) {
            this.dp = i;
        }
    }

    public static com.facebook.messaging.photos.size.MediaSizeUtil m9463a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7845q;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.photos.size.MediaSizeUtil.class;
        monitor-enter(r1);
        r0 = f7845q;	 Catch:{ all -> 0x003a }
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
        r0 = m9466b(r0);	 Catch:{ all -> 0x0035 }
        f7845q = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7845q;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.photos.size.MediaSizeUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.photos.size.MediaSizeUtil");
    }

    private static MediaSizeUtil m9466b(InjectorLike injectorLike) {
        return new MediaSizeUtil((Context) injectorLike.getInstance(Context.class), WindowManagerMethodAutoProvider.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4188));
    }

    @Inject
    public MediaSizeUtil(Context context, WindowManager windowManager, GatekeeperStore gatekeeperStore, Provider<Boolean> provider) {
        this.f7846b = context;
        this.f7847c = windowManager;
        this.f7848d = gatekeeperStore;
        this.f7860p = provider;
    }

    public final int m9472a() {
        if (this.f7849e == 0) {
            this.f7849e = SizeUtil.a(this.f7846b, (float) Size.TWO_IMAGE_WIDTH_HEIGHT.dp);
        }
        return this.f7849e;
    }

    public final int m9473b() {
        if (this.f7850f == 0) {
            this.f7850f = SizeUtil.a(this.f7846b, (float) Size.THREE_IMAGE_WIDTH_HEIGHT.dp);
        }
        return this.f7850f;
    }

    public final int m9475c() {
        if (this.f7851g == 0) {
            this.f7851g = SizeUtil.a(this.f7846b, (float) Size.SINGLE_IMAGE_LANDSCAPE_HEIGHT.dp);
        }
        return this.f7851g;
    }

    public final int m9476d() {
        if (this.f7852h == 0) {
            this.f7852h = SizeUtil.a(this.f7846b, (float) Size.SINGLE_IMAGE_PORTRAIT_SQUARE_HEIGHT.dp);
            this.f7852h = m9460a(this.f7852h);
        }
        return this.f7852h;
    }

    public final int m9477e() {
        if (this.f7853i == 0) {
            this.f7853i = SizeUtil.a(this.f7846b, (float) Size.SINGLE_IMAGE_NO_SIZE_WIDTH_HEIGHT.dp);
            this.f7853i = m9460a(this.f7853i);
        }
        return this.f7853i;
    }

    private int m9460a(int i) {
        return Math.min(i, this.f7846b.getResources().getDisplayMetrics().widthPixels - SizeUtil.a(this.f7846b, 120.0f));
    }

    public final int m9478f() {
        if (this.f7854j == null) {
            m9471p();
        }
        if (this.f7848d.a(331, false)) {
            return Math.max(this.f7854j.x, this.f7854j.y);
        }
        if (this.f7848d.a(332, false)) {
            return m9461a(this.f7854j);
        }
        return this.f7854j.x;
    }

    public final int m9479g() {
        if (this.f7854j == null) {
            m9471p();
        }
        if (this.f7848d.a(331, false)) {
            return Math.max(this.f7854j.x, this.f7854j.y);
        }
        if (this.f7848d.a(332, false)) {
            return m9461a(this.f7854j);
        }
        return this.f7854j.y;
    }

    private static int m9461a(Point point) {
        if (Math.max(point.x, point.y) > 960) {
            return 2048;
        }
        return 960;
    }

    public final String m9480h() {
        if (this.f7855k == null) {
            StringBuilder stringBuilder = new StringBuilder(50);
            Point p = m9471p();
            stringBuilder.append("width = ").append(p.x).append(" and height = ").append(p.y).append(" and resize_mode = 'COVER'");
            stringBuilder.append(" OR width = ").append(m9477e()).append(" and height = ").append(m9477e()).append(" and resize_mode = " + (((Boolean) this.f7860p.get()).booleanValue() ? "'CONTAIN'" : "'COVER'"));
            stringBuilder.append(" OR width = ").append(m9472a()).append(" and height = ").append(m9472a()).append(" and resize_mode = 'COVER'");
            if (((Boolean) this.f7860p.get()).booleanValue()) {
                stringBuilder.append(" and is_crop = 1");
            }
            stringBuilder.append(" OR width = ").append(m9473b()).append(" and height = ").append(m9473b()).append(" and resize_mode = 'COVER'");
            if (((Boolean) this.f7860p.get()).booleanValue()) {
                stringBuilder.append(" and is_crop = 1");
            }
            this.f7855k = stringBuilder.toString();
        }
        return this.f7855k;
    }

    public static String m9464a(int i, int i2) {
        return i + "x" + i2;
    }

    public final synchronized int m9481i() {
        return m9477e();
    }

    private synchronized Rect m9467l() {
        if (this.f7856l == null) {
            this.f7856l = new Rect(0, 0, m9477e(), m9477e());
        }
        return this.f7856l;
    }

    public final synchronized int m9482j() {
        return m9472a();
    }

    private synchronized Rect m9468m() {
        if (this.f7857m == null) {
            this.f7857m = new Rect(0, 0, m9472a(), m9472a());
        }
        return this.f7857m;
    }

    public final synchronized int m9483k() {
        return m9473b();
    }

    private synchronized Rect m9469n() {
        if (this.f7858n == null) {
            this.f7858n = new Rect(0, 0, m9473b(), m9473b());
        }
        return this.f7858n;
    }

    private synchronized Rect m9470o() {
        if (this.f7859o == null) {
            Point p = m9471p();
            this.f7859o = new Rect(0, 0, p.x, p.y);
        }
        return this.f7859o;
    }

    private synchronized Point m9471p() {
        if (this.f7854j == null) {
            this.f7854j = m9462a(this.f7847c.getDefaultDisplay());
        }
        return this.f7854j;
    }

    private static Point m9462a(Display display) {
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            display.getRealSize(point);
            if (point.x > point.y) {
                point.set(point.y, point.x);
            }
        } else if (VERSION.SDK_INT >= 13) {
            display.getSize(point);
            if (point.x > point.y) {
                point.set(point.y, point.x);
            }
        } else if (display.getWidth() < display.getHeight()) {
            point.set(display.getWidth(), display.getHeight());
        } else {
            point.set(display.getHeight(), display.getWidth());
        }
        return point;
    }

    public final AttachmentImageType m9474b(int i, int i2) {
        if (m9465a(m9470o(), i, i2)) {
            return AttachmentImageType.FULL_SCREEN;
        }
        if (m9465a(m9469n(), i, i2)) {
            return AttachmentImageType.SMALL_PREVIEW;
        }
        if (m9465a(m9468m(), i, i2)) {
            return AttachmentImageType.MEDIUM_PREVIEW;
        }
        if (m9465a(m9467l(), i, i2)) {
            return AttachmentImageType.LARGE_PREVIEW;
        }
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("Parameter: ").append(i).append("x").append(i2).append('\n');
        stringBuilder.append("Full: ").append(m9470o()).append('\n');
        stringBuilder.append("Small: ").append(m9469n()).append('\n');
        stringBuilder.append("Medium: ").append(m9468m()).append('\n');
        stringBuilder.append("Large: ").append(m9467l()).append('\n');
        BLog.c(f7844a, stringBuilder.toString());
        return null;
    }

    private static boolean m9465a(Rect rect, int i, int i2) {
        return rect.width() == i && rect.height() == i2;
    }
}
