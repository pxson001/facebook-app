package com.facebook.photos.editgallery;

import android.graphics.RectF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentManager;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.editgallery.animations.AnimationParam;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* compiled from: scanWifiDisplays */
public class EditGalleryFragmentManager {
    private static final String f10351a = EditGalleryFragmentManager.class.getSimpleName();
    private final AtomicBoolean f10352b = new AtomicBoolean(false);
    private FragmentManager f10353c;
    private WeakReference<EditGalleryDialogFragment> f10354d = new WeakReference(null);

    /* compiled from: scanWifiDisplays */
    public interface EditGalleryCallback {
        int mo220a(int i);

        void mo221a(CreativeEditingData creativeEditingData);

        void mo222a(UsageParams usageParams, ExpirationState expirationState, boolean z);
    }

    /* compiled from: scanWifiDisplays */
    public class UsageParams implements Parcelable {
        public static final Creator<UsageParams> CREATOR = new C08751();
        public int f10346a;
        public int f10347b;
        public int f10348c;
        public int f10349d;
        public int f10350e;

        /* compiled from: scanWifiDisplays */
        final class C08751 implements Creator<UsageParams> {
            C08751() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new UsageParams(parcel);
            }

            public final Object[] newArray(int i) {
                return new UsageParams[i];
            }
        }

        public UsageParams(Parcel parcel) {
            this.f10349d = parcel.readInt();
            this.f10347b = parcel.readInt();
            this.f10346a = parcel.readInt();
            this.f10348c = parcel.readInt();
            this.f10350e = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f10349d);
            parcel.writeInt(this.f10347b);
            parcel.writeInt(this.f10346a);
            parcel.writeInt(this.f10348c);
            parcel.writeInt(this.f10350e);
        }
    }

    public EditGalleryFragmentManager(FragmentManager fragmentManager) {
        this.f10353c = fragmentManager;
    }

    public final void m12201a(Uri uri, int i, int i2, EditGalleryLaunchConfiguration editGalleryLaunchConfiguration, EditGalleryCallback editGalleryCallback, @Nullable List<RectF> list, @Nullable AnimationParam animationParam) {
        Preconditions.checkNotNull(editGalleryCallback);
        Preconditions.checkNotNull(uri);
        Preconditions.checkNotNull(editGalleryLaunchConfiguration);
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i2 > 0);
        if (!this.f10352b.getAndSet(true)) {
            if (this.f10353c.a(f10351a) != null) {
                this.f10352b.set(false);
                return;
            }
            EditGalleryDialogFragment editGalleryDialogFragment = new EditGalleryDialogFragment();
            editGalleryDialogFragment.m12140a(editGalleryLaunchConfiguration, uri, i, i2, editGalleryCallback, list, animationParam);
            this.f10354d = new WeakReference(editGalleryDialogFragment);
            this.f10353c.a().a(editGalleryDialogFragment, f10351a).c();
            this.f10353c.b();
            this.f10352b.set(false);
        }
    }

    public final void m12202a(EditGalleryCallback editGalleryCallback) {
        this.f10354d = new WeakReference(this.f10353c.a(f10351a));
        if (this.f10354d.get() != null) {
            EditGalleryDialogFragment editGalleryDialogFragment = (EditGalleryDialogFragment) this.f10354d.get();
            Preconditions.checkNotNull(editGalleryCallback);
            editGalleryDialogFragment.as = editGalleryCallback;
        }
    }
}
