package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmv;
import com.google.android.gms.internal.zzmx;
import java.lang.ref.WeakReference;

public abstract class zza {
    final zza f6521a;
    protected int f6522b;
    public int f6523c;

    final class zza {
        public final Uri f6520a;

        public zza(Uri uri) {
            this.f6520a = uri;
        }

        public final boolean equals(Object obj) {
            return !(obj instanceof zza) ? false : this == obj ? true : zzw.a(((zza) obj).f6520a, this.f6520a);
        }

        public final int hashCode() {
            return zzw.a(new Object[]{this.f6520a});
        }
    }

    public final class zzc extends zza {
        private WeakReference<OnImageLoadedListener> f6524d;

        protected final void mo740a(Drawable drawable, boolean z, boolean z2) {
            if (!z) {
                this.f6524d.get();
            }
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc com_google_android_gms_common_images_zza_zzc = (zzc) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.f6524d.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) com_google_android_gms_common_images_zza_zzc.f6524d.get();
            return onImageLoadedListener2 != null && onImageLoadedListener != null && zzw.a(onImageLoadedListener2, onImageLoadedListener) && zzw.a(com_google_android_gms_common_images_zza_zzc.f6521a, this.f6521a);
        }

        public final int hashCode() {
            return zzw.a(new Object[]{this.f6521a});
        }
    }

    final void m12191a(Context context, Bitmap bitmap, boolean z) {
        zzb.m12279a((Object) bitmap);
        if ((this.f6523c & 1) != 0) {
            bitmap = zzmv.m12881a(bitmap);
        }
        mo740a(new BitmapDrawable(context.getResources(), bitmap), false, true);
    }

    final void m12192a(Context context, zzmx com_google_android_gms_internal_zzmx, boolean z) {
        Drawable drawable = null;
        if (this.f6522b != 0) {
            Drawable drawable2;
            int i = this.f6522b;
            Resources resources = context.getResources();
            if (this.f6523c > 0) {
                com.google.android.gms.internal.zzmx.zza com_google_android_gms_internal_zzmx_zza = new com.google.android.gms.internal.zzmx.zza(i, this.f6523c);
                drawable2 = (Drawable) com_google_android_gms_internal_zzmx.a(com_google_android_gms_internal_zzmx_zza);
                if (drawable2 == null) {
                    drawable2 = resources.getDrawable(i);
                    if ((this.f6523c & 1) != 0) {
                        drawable2 = new BitmapDrawable(resources, zzmv.m12881a(zzmv.m12882a(drawable2)));
                    }
                    com_google_android_gms_internal_zzmx.a(com_google_android_gms_internal_zzmx_zza, drawable2);
                }
            } else {
                drawable2 = resources.getDrawable(i);
            }
            drawable = drawable2;
        }
        mo740a(drawable, false, false);
    }

    protected abstract void mo740a(Drawable drawable, boolean z, boolean z2);
}
