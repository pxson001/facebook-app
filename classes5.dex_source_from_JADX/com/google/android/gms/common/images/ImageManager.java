package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzmx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

public final class ImageManager {
    public static final Object f6506a = new Object();
    public static HashSet<Uri> f6507b = new HashSet();
    public final Context f6508c;
    public final Handler f6509d;
    public final ExecutorService f6510e;
    public final zzb f6511f;
    public final zzmx f6512g;
    public final Map<zza, ImageReceiver> f6513h;
    public final Map<Uri, ImageReceiver> f6514i;
    public final Map<Uri, Long> f6515j;

    final class ImageReceiver extends ResultReceiver {
        final /* synthetic */ ImageManager f6495a;
        private final Uri f6496b;
        public final ArrayList<zza> f6497c;

        public final void onReceiveResult(int i, Bundle bundle) {
            ExecutorDetour.a(this.f6495a.f6510e, new zzc(this.f6495a, this.f6496b, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")), -1971473444);
        }
    }

    public interface OnImageLoadedListener {
    }

    final class zzc implements Runnable {
        final /* synthetic */ ImageManager f6498a;
        private final Uri f6499b;
        private final ParcelFileDescriptor f6500c;

        public zzc(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.f6498a = imageManager;
            this.f6499b = uri;
            this.f6500c = parcelFileDescriptor;
        }

        public final void run() {
            zzb.m12281b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.f6500c != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.f6500c.getFileDescriptor());
                } catch (Throwable e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.f6499b, e);
                    z = true;
                }
                try {
                    this.f6500c.close();
                } catch (Throwable e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            HandlerDetour.a(this.f6498a.f6509d, new zzf(this.f6498a, this.f6499b, bitmap, z, countDownLatch), 978319241);
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.f6499b);
            }
        }
    }

    final class zzf implements Runnable {
        final /* synthetic */ ImageManager f6501a;
        private final Uri f6502b;
        private final Bitmap f6503c;
        private final CountDownLatch f6504d;
        private boolean f6505e;

        public zzf(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.f6501a = imageManager;
            this.f6502b = uri;
            this.f6503c = bitmap;
            this.f6505e = z;
            this.f6504d = countDownLatch;
        }

        private void m12188a(ImageReceiver imageReceiver, boolean z) {
            ArrayList arrayList = imageReceiver.f6497c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zza com_google_android_gms_common_images_zza = (zza) arrayList.get(i);
                if (z) {
                    com_google_android_gms_common_images_zza.m12191a(this.f6501a.f6508c, this.f6503c, false);
                } else {
                    this.f6501a.f6515j.put(this.f6502b, Long.valueOf(SystemClock.elapsedRealtime()));
                    com_google_android_gms_common_images_zza.m12192a(this.f6501a.f6508c, this.f6501a.f6512g, false);
                }
                if (!(com_google_android_gms_common_images_zza instanceof com.google.android.gms.common.images.zza.zzc)) {
                    this.f6501a.f6513h.remove(com_google_android_gms_common_images_zza);
                }
            }
        }

        public final void run() {
            zzb.m12280a("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.f6503c != null;
            if (this.f6501a.f6511f != null) {
                if (this.f6505e) {
                    this.f6501a.f6511f.a();
                    System.gc();
                    this.f6505e = false;
                    HandlerDetour.a(this.f6501a.f6509d, this, -1354877816);
                    return;
                } else if (z) {
                    this.f6501a.f6511f.a(new zza(this.f6502b), this.f6503c);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.f6501a.f6514i.remove(this.f6502b);
            if (imageReceiver != null) {
                m12188a(imageReceiver, z);
            }
            this.f6504d.countDown();
            synchronized (ImageManager.f6506a) {
                ImageManager.f6507b.remove(this.f6502b);
            }
        }
    }
}
