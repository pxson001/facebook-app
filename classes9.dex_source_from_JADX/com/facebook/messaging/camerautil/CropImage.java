package com.facebook.messaging.camerautil;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.camerautil.ImageManager.DataLocation;
import com.facebook.messaging.camerautil.ImageManager.ImageListParam;
import com.facebook.messaging.camerautil.gallery.IImage;
import com.facebook.messaging.camerautil.gallery.IImageList;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.concurrent.CountDownLatch;

/* compiled from: messenger_transcode_failed */
public class CropImage extends MonitoredActivity {
    private static final Class<?> f9630t = CropImage.class;
    public boolean f9631A = false;
    public final Handler f9632B = new Handler();
    private int f9633C;
    private int f9634D;
    private boolean f9635E;
    private boolean f9636F = true;
    public CropImageView f9637G;
    private ContentResolver f9638H;
    public Bitmap f9639I;
    private IImageList f9640J;
    public IImage f9641K;
    boolean f9642p;
    boolean f9643q;
    HighlightView f9644r;
    Runnable f9645s = new C11246(this);
    private CompressFormat f9646u = CompressFormat.JPEG;
    private Uri f9647v = null;
    private boolean f9648w = false;
    public int f9649x;
    public int f9650y;
    public boolean f9651z = true;

    /* compiled from: messenger_transcode_failed */
    class C11171 implements OnClickListener {
        final /* synthetic */ CropImage f9613a;

        C11171(CropImage cropImage) {
            this.f9613a = cropImage;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1961178438);
            this.f9613a.setResult(0);
            this.f9613a.finish();
            Logger.a(2, EntryType.UI_INPUT_END, 926219509, a);
        }
    }

    /* compiled from: messenger_transcode_failed */
    class C11182 implements OnClickListener {
        final /* synthetic */ CropImage f9614a;

        C11182(CropImage cropImage) {
            this.f9614a = cropImage;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1114217791);
            CropImage.m10244j(this.f9614a);
            Logger.a(2, EntryType.UI_INPUT_END, 999105695, a);
        }
    }

    /* compiled from: messenger_transcode_failed */
    class C11203 implements Runnable {
        final /* synthetic */ CropImage f9618a;

        C11203(CropImage cropImage) {
            this.f9618a = cropImage;
        }

        public void run() {
            Bitmap a;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            if (this.f9618a.f9641K != null) {
                a = this.f9618a.f9641K.mo389a(-1, 1048576);
            } else {
                a = this.f9618a.f9639I;
            }
            HandlerDetour.a(this.f9618a.f9632B, new Runnable(this) {
                final /* synthetic */ C11203 f9617c;

                public void run() {
                    if (!(a == this.f9617c.f9618a.f9639I || a == null)) {
                        this.f9617c.f9618a.f9637G.a(a, true);
                        this.f9617c.f9618a.f9639I.recycle();
                        this.f9617c.f9618a.f9639I = a;
                    }
                    if (this.f9617c.f9618a.f9637G.getScale() == 1.0f) {
                        this.f9617c.f9618a.f9637G.a(true, true);
                    }
                    countDownLatch.countDown();
                }
            }, -1758618769);
            try {
                countDownLatch.await();
                this.f9618a.f9645s.run();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: messenger_transcode_failed */
    class C11246 implements Runnable {
        float f9624a = 1.0f;
        Matrix f9625b;
        Face[] f9626c = new Face[3];
        int f9627d;
        final /* synthetic */ CropImage f9628e;

        /* compiled from: messenger_transcode_failed */
        class C11231 implements Runnable {
            final /* synthetic */ C11246 f9623a;

            C11231(C11246 c11246) {
                this.f9623a = c11246;
            }

            public void run() {
                boolean z;
                CropImage cropImage = this.f9623a.f9628e;
                if (this.f9623a.f9627d > 1) {
                    z = true;
                } else {
                    z = false;
                }
                cropImage.f9642p = z;
                if (this.f9623a.f9627d > 0) {
                    for (int i = 0; i < this.f9623a.f9627d; i++) {
                        this.f9623a.m10226a(this.f9623a.f9626c[i]);
                    }
                } else {
                    this.f9623a.m10225a();
                }
                this.f9623a.f9628e.f9637G.invalidate();
                if (this.f9623a.f9628e.f9637G.f9652i.size() == 1) {
                    this.f9623a.f9628e.f9644r = (HighlightView) this.f9623a.f9628e.f9637G.f9652i.get(0);
                    this.f9623a.f9628e.f9644r.f9659b = true;
                }
                if (this.f9623a.f9627d > 1) {
                    Toast.makeText(this.f9623a.f9628e, 2131231514, 0).show();
                }
            }
        }

        C11246(CropImage cropImage) {
            this.f9628e = cropImage;
        }

        private void m10226a(Face face) {
            boolean z = false;
            PointF pointF = new PointF();
            int eyesDistance = ((int) (face.eyesDistance() * this.f9624a)) * 2;
            face.getMidPoint(pointF);
            pointF.x *= this.f9624a;
            pointF.y *= this.f9624a;
            int i = (int) pointF.x;
            int i2 = (int) pointF.y;
            HighlightView highlightView = new HighlightView(this.f9628e.f9637G);
            Rect rect = new Rect(0, 0, this.f9628e.f9639I.getWidth(), this.f9628e.f9639I.getHeight());
            RectF rectF = new RectF((float) i, (float) i2, (float) i, (float) i2);
            rectF.inset((float) (-eyesDistance), (float) (-eyesDistance));
            if (rectF.left < 0.0f) {
                rectF.inset(-rectF.left, -rectF.left);
            }
            if (rectF.top < 0.0f) {
                rectF.inset(-rectF.top, -rectF.top);
            }
            if (rectF.right > ((float) rect.right)) {
                rectF.inset(rectF.right - ((float) rect.right), rectF.right - ((float) rect.right));
            }
            if (rectF.bottom > ((float) rect.bottom)) {
                rectF.inset(rectF.bottom - ((float) rect.bottom), rectF.bottom - ((float) rect.bottom));
            }
            Matrix matrix = this.f9625b;
            boolean z2 = this.f9628e.f9631A;
            if (!(this.f9628e.f9649x == 0 || this.f9628e.f9650y == 0)) {
                z = true;
            }
            highlightView.m10258a(matrix, rect, rectF, z2, z);
            this.f9628e.f9637G.m10251a(highlightView);
        }

        private void m10225a() {
            int i;
            int i2;
            boolean z = false;
            HighlightView highlightView = new HighlightView(this.f9628e.f9637G);
            int width = this.f9628e.f9639I.getWidth();
            int height = this.f9628e.f9639I.getHeight();
            Rect rect = new Rect(0, 0, width, height);
            int min = (Math.min(width, height) * 4) / 5;
            if (this.f9628e.f9649x == 0 || this.f9628e.f9650y == 0) {
                i = min;
                i2 = min;
            } else if (this.f9628e.f9649x > this.f9628e.f9650y) {
                i = (this.f9628e.f9650y * min) / this.f9628e.f9649x;
                i2 = min;
            } else {
                i2 = (this.f9628e.f9649x * min) / this.f9628e.f9650y;
                i = min;
            }
            width = (width - i2) / 2;
            height = (height - i) / 2;
            RectF rectF = new RectF((float) width, (float) height, (float) (i2 + width), (float) (i + height));
            Matrix matrix = this.f9625b;
            boolean z2 = this.f9628e.f9631A;
            if (!(this.f9628e.f9649x == 0 || this.f9628e.f9650y == 0)) {
                z = true;
            }
            highlightView.m10258a(matrix, rect, rectF, z2, z);
            this.f9628e.f9637G.m10251a(highlightView);
        }

        private Bitmap m10229b() {
            if (this.f9628e.f9639I == null) {
                return null;
            }
            if (this.f9628e.f9639I.getWidth() > 256) {
                this.f9624a = 256.0f / ((float) this.f9628e.f9639I.getWidth());
            }
            Matrix matrix = new Matrix();
            matrix.setScale(this.f9624a, this.f9624a);
            return Bitmap.createBitmap(this.f9628e.f9639I, 0, 0, this.f9628e.f9639I.getWidth(), this.f9628e.f9639I.getHeight(), matrix, true);
        }

        public void run() {
            this.f9625b = this.f9628e.f9637G.getImageMatrix();
            Bitmap b = m10229b();
            this.f9624a = 1.0f / this.f9624a;
            if (b != null && this.f9628e.f9651z) {
                this.f9627d = new FaceDetector(b.getWidth(), b.getHeight(), this.f9626c.length).findFaces(b, this.f9626c);
            }
            if (!(b == null || b == this.f9628e.f9639I)) {
                b.recycle();
            }
            HandlerDetour.a(this.f9628e.f9632B, new C11231(this), 1067780656);
        }
    }

    public final void mo383b(Bundle bundle) {
        super.mo383b(bundle);
        this.f9638H = getContentResolver();
        requestWindowFeature(1);
        setContentView(2130905679);
        this.f9637G = (CropImageView) findViewById(2131559119);
        int a = MenuHelper.m10278a();
        CharSequence charSequence = null;
        if (a == -1) {
            if (Environment.getExternalStorageState() == "checking") {
                charSequence = getString(2131231506);
            } else {
                charSequence = getString(2131231507);
            }
        } else if (a <= 0) {
            charSequence = getString(2131231508);
        }
        if (charSequence != null) {
            Toast.makeText(this, charSequence, 5000).show();
        }
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            boolean z;
            if (extras.getString("circleCrop") != null) {
                this.f9631A = true;
                this.f9649x = 1;
                this.f9650y = 1;
            }
            this.f9647v = (Uri) extras.getParcelable("output");
            if (this.f9647v != null) {
                String string = extras.getString("outputFormat");
                if (string != null) {
                    this.f9646u = CompressFormat.valueOf(string);
                }
            } else {
                this.f9648w = extras.getBoolean("setWallpaper");
            }
            this.f9639I = (Bitmap) extras.getParcelable("data");
            this.f9649x = extras.getInt("aspectX");
            this.f9650y = extras.getInt("aspectY");
            this.f9633C = extras.getInt("outputX");
            this.f9634D = extras.getInt("outputY");
            this.f9635E = extras.getBoolean("scale", true);
            this.f9636F = extras.getBoolean("scaleUpIfNeeded", true);
            if (extras.containsKey("noFaceDetection") && extras.getBoolean("noFaceDetection")) {
                z = false;
            } else {
                z = true;
            }
            this.f9651z = z;
        }
        if (this.f9639I == null) {
            IImageList a2;
            Uri data = intent.getData();
            ContentResolver contentResolver = this.f9638H;
            String uri = data != null ? data.toString() : "";
            if (uri.startsWith("content://drm")) {
                a2 = ImageManager.m10272a(contentResolver, DataLocation.ALL, 2, 1, null);
            } else if (uri.startsWith("content://media/external/video")) {
                a2 = ImageManager.m10272a(contentResolver, DataLocation.EXTERNAL, 4, 1, null);
            } else {
                Object obj;
                if (uri.startsWith(Media.EXTERNAL_CONTENT_URI.toString()) || uri.startsWith(Media.INTERNAL_CONTENT_URI.toString())) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    ImageListParam imageListParam = new ImageListParam();
                    imageListParam.f9679e = data;
                    a2 = ImageManager.m10273a(contentResolver, imageListParam);
                } else {
                    a2 = ImageManager.m10272a(contentResolver, DataLocation.ALL, 1, 1, data.getQueryParameter("bucketId"));
                }
            }
            this.f9640J = a2;
            this.f9641K = this.f9640J.mo386a(data);
            if (this.f9641K != null) {
                this.f9639I = this.f9641K.mo393a(true);
            }
        }
        if (this.f9639I == null) {
            finish();
            return;
        }
        getWindow().addFlags(1024);
        findViewById(2131563217).setOnClickListener(new C11171(this));
        findViewById(2131564815).setOnClickListener(new C11182(this));
        m10242i();
    }

    private void m10242i() {
        if (!isFinishing()) {
            this.f9637G.a(this.f9639I, true);
            CameraUtil.m10222a((MonitoredActivity) this, null, getResources().getString(2131231509), new C11203(this), this.f9632B);
        }
    }

    public static void m10244j(CropImage cropImage) {
        if (cropImage.f9644r != null && !cropImage.f9643q) {
            Object a;
            cropImage.f9643q = true;
            Rect b;
            int height;
            Canvas canvas;
            if (cropImage.f9633C == 0 || cropImage.f9634D == 0 || cropImage.f9635E) {
                b = cropImage.f9644r.m10261b();
                int width = b.width();
                height = b.height();
                Bitmap createBitmap = Bitmap.createBitmap(width, height, cropImage.f9631A ? Config.ARGB_8888 : Config.RGB_565);
                new Canvas(createBitmap).drawBitmap(cropImage.f9639I, b, new Rect(0, 0, width, height), null);
                cropImage.f9637G.a();
                cropImage.f9639I.recycle();
                if (cropImage.f9631A) {
                    canvas = new Canvas(createBitmap);
                    Path path = new Path();
                    path.addCircle(((float) width) / 2.0f, ((float) height) / 2.0f, ((float) width) / 2.0f, Direction.CW);
                    canvas.clipPath(path, Op.DIFFERENCE);
                    canvas.drawColor(0, Mode.CLEAR);
                }
                if (!(cropImage.f9633C == 0 || cropImage.f9634D == 0 || !cropImage.f9635E)) {
                    a = CameraUtil.m10218a(new Matrix(), createBitmap, cropImage.f9633C, cropImage.f9634D, cropImage.f9636F, true);
                }
            } else {
                a = Bitmap.createBitmap(cropImage.f9633C, cropImage.f9634D, Config.RGB_565);
                canvas = new Canvas(a);
                b = cropImage.f9644r.m10261b();
                Rect rect = new Rect(0, 0, cropImage.f9633C, cropImage.f9634D);
                height = (b.width() - rect.width()) / 2;
                int height2 = (b.height() - rect.height()) / 2;
                b.inset(Math.max(0, height), Math.max(0, height2));
                rect.inset(Math.max(0, -height), Math.max(0, -height2));
                canvas.drawBitmap(cropImage.f9639I, b, rect, null);
                cropImage.f9637G.a();
                cropImage.f9639I.recycle();
            }
            cropImage.f9637G.a(a, true);
            cropImage.f9637G.a(true, true);
            cropImage.f9637G.f9652i.clear();
            Bundle extras = cropImage.getIntent().getExtras();
            if (extras == null || (extras.getParcelable("data") == null && !extras.getBoolean("return-data"))) {
                CameraUtil.m10222a((MonitoredActivity) cropImage, null, cropImage.getResources().getString(cropImage.f9648w ? 2131231512 : 2131231513), new Runnable(cropImage) {
                    final /* synthetic */ CropImage f9620b;

                    public void run() {
                        this.f9620b.f9639I = a;
                    }
                }, cropImage.f9632B);
                return;
            }
            extras = new Bundle();
            extras.putParcelable("data", a);
            cropImage.setResult(-1, new Intent().setAction("inline-data").putExtras(extras));
            cropImage.finish();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m10233a(com.facebook.messaging.camerautil.CropImage r11, final android.graphics.Bitmap r12) {
        /*
        r1 = 0;
        r7 = -1;
        r0 = 0;
        r2 = r11.f9647v;
        if (r2 == 0) goto L_0x005c;
    L_0x0007:
        r0 = r11.f9638H;	 Catch:{ IOException -> 0x0043 }
        r2 = r11.f9647v;	 Catch:{ IOException -> 0x0043 }
        r1 = r0.openOutputStream(r2);	 Catch:{ IOException -> 0x0043 }
        if (r1 == 0) goto L_0x0018;
    L_0x0011:
        r0 = r11.f9646u;	 Catch:{ IOException -> 0x0043 }
        r2 = 75;
        r12.compress(r0, r2, r1);	 Catch:{ IOException -> 0x0043 }
    L_0x0018:
        com.facebook.messaging.camerautil.CameraUtil.m10223a(r1);
    L_0x001b:
        r0 = new android.os.Bundle;
        r0.<init>();
        r1 = new android.content.Intent;
        r2 = r11.f9647v;
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r1.putExtras(r0);
        r11.setResult(r7, r0);
    L_0x0032:
        r0 = r11.f9632B;
        r1 = new com.facebook.messaging.camerautil.CropImage$5;
        r1.<init>(r11, r12);
        r2 = -575391701; // 0xffffffffddb4382b float:-1.6232721E18 double:NaN;
        com.facebook.tools.dextr.runtime.detour.HandlerDetour.a(r0, r1, r2);
        r11.finish();
        return;
    L_0x0043:
        r0 = move-exception;
        r2 = f9630t;	 Catch:{ all -> 0x0057 }
        r3 = "Cannot open file: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0057 }
        r5 = 0;
        r6 = r11.f9647v;	 Catch:{ all -> 0x0057 }
        r4[r5] = r6;	 Catch:{ all -> 0x0057 }
        com.facebook.debug.log.BLog.b(r2, r0, r3, r4);	 Catch:{ all -> 0x0057 }
        com.facebook.messaging.camerautil.CameraUtil.m10223a(r1);
        goto L_0x001b;
    L_0x0057:
        r0 = move-exception;
        com.facebook.messaging.camerautil.CameraUtil.m10223a(r1);
        throw r0;
    L_0x005c:
        r1 = r11.f9648w;
        if (r1 == 0) goto L_0x0078;
    L_0x0060:
        r1 = android.app.WallpaperManager.getInstance(r11);	 Catch:{ IOException -> 0x006c }
        r1.setBitmap(r12);	 Catch:{ IOException -> 0x006c }
        r1 = -1;
        r11.setResult(r1);	 Catch:{ IOException -> 0x006c }
        goto L_0x0032;
    L_0x006c:
        r1 = move-exception;
        r2 = f9630t;
        r3 = "Failed to set wallpaper.";
        com.facebook.debug.log.BLog.b(r2, r3, r1);
        r11.setResult(r0);
        goto L_0x0032;
    L_0x0078:
        r10 = new android.os.Bundle;
        r10.<init>();
        r1 = "rect";
        r2 = r11.f9644r;
        r2 = r2.m10261b();
        r2 = r2.toString();
        r10.putString(r1, r2);
        r1 = new java.io.File;
        r2 = r11.f9641K;
        r2 = r2.mo390a();
        r1.<init>(r2);
        r5 = new java.io.File;
        r2 = r1.getParent();
        r5.<init>(r2);
        r1 = r1.getName();
        r2 = ".";
        r2 = r1.lastIndexOf(r2);
        r7 = r1.substring(r0, r2);
    L_0x00ae:
        r6 = r0 + 1;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r5.toString();
        r0 = r0.append(r1);
        r1 = "/";
        r0 = r0.append(r1);
        r0 = r0.append(r7);
        r1 = "-";
        r0 = r0.append(r1);
        r0 = r0.append(r6);
        r1 = ".jpg";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r1 = new java.io.File;
        r1.<init>(r0);
        r0 = r1.exists();
        if (r0 == 0) goto L_0x00e8;
    L_0x00e6:
        r0 = r6;
        goto L_0x00ae;
    L_0x00e8:
        r0 = 1;
        r9 = new int[r0];	 Catch:{ Exception -> 0x0138 }
        r0 = r11.f9638H;	 Catch:{ Exception -> 0x0138 }
        r1 = r11.f9641K;	 Catch:{ Exception -> 0x0138 }
        r1 = r1.mo392d();	 Catch:{ Exception -> 0x0138 }
        r2 = r11.f9641K;	 Catch:{ Exception -> 0x0138 }
        r2 = r2.mo391b();	 Catch:{ Exception -> 0x0138 }
        r4 = 0;
        r5 = r5.toString();	 Catch:{ Exception -> 0x0138 }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0138 }
        r8.<init>();	 Catch:{ Exception -> 0x0138 }
        r7 = r8.append(r7);	 Catch:{ Exception -> 0x0138 }
        r8 = "-";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x0138 }
        r6 = r7.append(r6);	 Catch:{ Exception -> 0x0138 }
        r7 = ".jpg";
        r6 = r6.append(r7);	 Catch:{ Exception -> 0x0138 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0138 }
        r8 = 0;
        r7 = r12;
        r0 = com.facebook.messaging.camerautil.ImageManager.m10271a(r0, r1, r2, r4, r5, r6, r7, r8, r9);	 Catch:{ Exception -> 0x0138 }
        r1 = -1;
        r2 = new android.content.Intent;	 Catch:{ Exception -> 0x0138 }
        r2.<init>();	 Catch:{ Exception -> 0x0138 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0138 }
        r0 = r2.setAction(r0);	 Catch:{ Exception -> 0x0138 }
        r0 = r0.putExtras(r10);	 Catch:{ Exception -> 0x0138 }
        r11.setResult(r1, r0);	 Catch:{ Exception -> 0x0138 }
        goto L_0x0032;
    L_0x0138:
        r0 = move-exception;
        r1 = f9630t;
        r2 = "store image fail, continue anyway";
        com.facebook.debug.log.BLog.b(r1, r2, r0);
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.camerautil.CropImage.a(com.facebook.messaging.camerautil.CropImage, android.graphics.Bitmap):void");
    }

    protected void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -4327033);
        super.onPause();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -940164817, a);
    }

    protected void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -197932382);
        if (this.f9640J != null) {
            this.f9640J.mo387a();
        }
        super.onDestroy();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 412902413, a);
    }
}
