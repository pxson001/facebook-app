package com.facebook.messaging.media.mediapicker.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mediastorage.MediaStorage;
import com.facebook.messaging.camerautil.CropImage;
import com.facebook.messaging.media.mediapicker.MediaPickerActivity;
import com.facebook.messaging.media.mediapicker.MediaPickerEnvironment;
import com.facebook.messaging.media.mediapicker.MediaPickerEnvironment.Builder;
import com.facebook.runtimepermissions.RequestPermissionsActivity;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.media.attachments.MediaResourceHelper;
import com.facebook.ui.media.attachments.MediaResourceUtil;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

@SuppressLint({"WorldWriteableFiles"})
/* compiled from: m._ROWID_ AS _id */
public class PickMediaDialogFragment extends FbDialogFragment {
    private static final Class<?> am = PickMediaDialogFragment.class;
    private RuntimePermissionsUtil aA;
    public PickMediaDialogParams aB;
    public Uri aC;
    public Uri aD;
    public Listener aE;
    public ListenableFuture<?> aF;
    private Bundle aG;
    public MediaResourceHelper an;
    private MediaResourceUtil ao;
    public MediaStorage ap;
    public TempFileManager aq;
    public SecureContextHelper ar;
    private Toaster as;
    private ListeningExecutorService at;
    private Executor au;
    public DefaultAndroidThreadUtil av;
    private ContentResolver aw;
    private AbstractFbErrorReporter ax;
    private Provider<Boolean> ay;
    public Provider<Boolean> az;

    /* compiled from: m._ROWID_ AS _id */
    class C13161 implements Runnable {
        final /* synthetic */ PickMediaDialogFragment f11761a;

        C13161(PickMediaDialogFragment pickMediaDialogFragment) {
            this.f11761a = pickMediaDialogFragment;
        }

        public void run() {
            PickMediaDialogFragment pickMediaDialogFragment = this.f11761a;
            pickMediaDialogFragment.av.b();
            if (pickMediaDialogFragment.aC == null) {
                pickMediaDialogFragment.aC = pickMediaDialogFragment.ap.c();
            }
            if (pickMediaDialogFragment.aB.f11770b != null && pickMediaDialogFragment.aD == null) {
                pickMediaDialogFragment.aD = Uri.fromFile(pickMediaDialogFragment.aq.a("crop", ".jpg", Privacy.PREFER_SDCARD));
            }
        }
    }

    /* compiled from: m._ROWID_ AS _id */
    class C13194 implements FutureCallback<ImmutableList<MediaResource>> {
        final /* synthetic */ PickMediaDialogFragment f11766a;

        C13194(PickMediaDialogFragment pickMediaDialogFragment) {
            this.f11766a = pickMediaDialogFragment;
        }

        public void onSuccess(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            PickMediaDialogFragment pickMediaDialogFragment = this.f11766a;
            if (pickMediaDialogFragment.mx_()) {
                if (pickMediaDialogFragment.aE != null) {
                    pickMediaDialogFragment.aE.mo556a(immutableList);
                }
                pickMediaDialogFragment.b();
            }
        }

        public void onFailure(Throwable th) {
            PickMediaDialogFragment.aB(this.f11766a);
        }
    }

    /* compiled from: m._ROWID_ AS _id */
    public interface Listener {
        void mo555a();

        void mo556a(List<MediaResource> list);

        void mo557b();
    }

    public static void m12400a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PickMediaDialogFragment) obj).m12398a(ContentResolverMethodAutoProvider.b(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), MediaResourceHelper.a(fbInjector), MediaResourceUtil.a(fbInjector), MediaStorage.a(fbInjector), TempFileManager.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), Toaster.b(fbInjector), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), DefaultAndroidThreadUtil.b(fbInjector), IdBasedProvider.a(fbInjector, 4078), IdBasedProvider.a(fbInjector, 4099), RuntimePermissionsUtil.b(fbInjector));
    }

    public static PickMediaDialogFragment m12396a(PickMediaDialogParams pickMediaDialogParams) {
        boolean z;
        boolean z2 = true;
        if (pickMediaDialogParams.f11769a == PickMediaSource.CAMERA) {
            if (pickMediaDialogParams.f11772d.size() > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            Preconditions.checkArgument(pickMediaDialogParams.f11772d.contains(Type.PHOTO));
        }
        if (pickMediaDialogParams.f11770b != null) {
            if (pickMediaDialogParams.f11772d.size() == 1) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            Preconditions.checkArgument(pickMediaDialogParams.f11772d.contains(Type.PHOTO));
            if (pickMediaDialogParams.f11771c) {
                z2 = false;
            }
            Preconditions.checkArgument(z2);
        }
        PickMediaDialogFragment pickMediaDialogFragment = new PickMediaDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("p", pickMediaDialogParams);
        pickMediaDialogFragment.g(bundle);
        return pickMediaDialogFragment;
    }

    public final void m12405I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 405032069);
        super.I();
        if (this.aF != null) {
            this.aF.cancel(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -522668769, a);
    }

    @Inject
    private void m12398a(ContentResolver contentResolver, FbErrorReporter fbErrorReporter, MediaResourceHelper mediaResourceHelper, MediaResourceUtil mediaResourceUtil, MediaStorage mediaStorage, TempFileManager tempFileManager, SecureContextHelper secureContextHelper, Toaster toaster, ListeningExecutorService listeningExecutorService, Executor executor, AndroidThreadUtil androidThreadUtil, Provider<Boolean> provider, Provider<Boolean> provider2, RuntimePermissionsUtil runtimePermissionsUtil) {
        this.aw = contentResolver;
        this.ax = fbErrorReporter;
        this.an = mediaResourceHelper;
        this.ao = mediaResourceUtil;
        this.ap = mediaStorage;
        this.aq = tempFileManager;
        this.ar = secureContextHelper;
        this.as = toaster;
        this.at = listeningExecutorService;
        this.au = executor;
        this.av = androidThreadUtil;
        this.ay = provider;
        this.az = provider2;
        this.aA = runtimePermissionsUtil;
    }

    public final void m12407a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 646940118);
        super.a(bundle);
        Class cls = PickMediaDialogFragment.class;
        m12400a((Object) this, getContext());
        a(2, 16973840);
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.aB = (PickMediaDialogParams) bundle2.getParcelable("p");
        }
        if (bundle != null) {
            this.aC = (Uri) bundle.getParcelable("tmp_camera_file");
            this.aD = (Uri) bundle.getParcelable("tmp_crop_file");
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -232539447, a);
    }

    public final void m12410e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("tmp_camera_file", this.aC);
        bundle.putParcelable("tmp_crop_file", this.aD);
    }

    public final Dialog m12408c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.setCanceledOnTouchOutside(true);
        return c;
    }

    public final void m12409d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1437206651);
        super.d(bundle);
        this.aG = bundle;
        if (aq()) {
            at();
        } else {
            String string;
            PickMediaSource pickMediaSource = this.aB.f11769a;
            List arrayList = new ArrayList();
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.aB.f11769a == PickMediaSource.CAMERA) {
                arrayList.add("android.permission.CAMERA");
            }
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            if (this.aB.f11769a == PickMediaSource.CAMERA) {
                string = jW_().getString(2131231163);
            } else {
                string = jW_().getString(2131231164);
            }
            String str = string;
            if (this.aB.f11769a == PickMediaSource.CAMERA) {
                string = jW_().getString(2131231165);
            } else {
                string = jW_().getString(2131231166);
            }
            String str2 = string;
            Intent intent = new Intent(getContext(), RequestPermissionsActivity.class);
            intent.putExtra("extra_permissions", strArr);
            intent.putExtra("extra_custom_title", str);
            intent.putExtra("extra_custom_subtitle", str2);
            this.ar.a(intent, 6, this);
        }
        LogUtils.f(2087297159, a);
    }

    private boolean aq() {
        boolean a = this.aA.a("android.permission.WRITE_EXTERNAL_STORAGE");
        boolean a2 = this.aA.a("android.permission.CAMERA");
        if (this.aB.f11769a == PickMediaSource.CAMERA) {
            return a && a2;
        } else {
            return a;
        }
    }

    private void at() {
        this.aF = this.at.a(new C13161(this));
        final boolean z = this.aG != null;
        Futures.a(this.aF, new FutureCallback<Object>(this) {
            final /* synthetic */ PickMediaDialogFragment f11763b;

            public void onSuccess(Object obj) {
                if (!z) {
                    PickMediaDialogFragment.av(this.f11763b);
                }
                this.f11763b.aF = null;
            }

            public void onFailure(Throwable th) {
                PickMediaDialogFragment.aB(this.f11763b);
                this.f11763b.aF = null;
            }
        }, this.au);
    }

    public static void av(PickMediaDialogFragment pickMediaDialogFragment) {
        switch (pickMediaDialogFragment.aB.f11769a) {
            case CAMERA:
                if (pickMediaDialogFragment.aB.f11772d.contains(Type.PHOTO)) {
                    pickMediaDialogFragment.aw();
                    return;
                } else {
                    pickMediaDialogFragment.aA();
                    return;
                }
            case GALLERY:
                if (((Boolean) pickMediaDialogFragment.ay.get()).booleanValue()) {
                    boolean z;
                    boolean z2 = true;
                    Builder builder = new Builder();
                    if (pickMediaDialogFragment.aB.f11772d.contains(Type.VIDEO) && ((Boolean) pickMediaDialogFragment.az.get()).booleanValue()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    builder.f11673b = z;
                    Builder builder2 = builder;
                    builder2.f11674c = pickMediaDialogFragment.aB.f11774f;
                    builder2 = builder2;
                    if (pickMediaDialogFragment.aB.f11771c) {
                        z2 = false;
                    }
                    builder2.f11672a = z2;
                    builder2 = builder2;
                    builder2.f11675d = pickMediaDialogFragment.aB.f11776h;
                    builder2 = builder2;
                    builder2.f11676e = pickMediaDialogFragment.aB.f11777i;
                    pickMediaDialogFragment.ar.a(MediaPickerActivity.m12334a(pickMediaDialogFragment.getContext(), pickMediaDialogFragment.aB.f11775g, new MediaPickerEnvironment(builder2)), 5, pickMediaDialogFragment);
                    return;
                }
                pickMediaDialogFragment.ax();
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void aw() {
        try {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", this.aC);
            this.ar.b(intent, 2, this);
        } catch (ActivityNotFoundException e) {
            aB(this);
            this.as.a(new ToastBuilder(2131234296));
        }
    }

    private void ax() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        Iterable a = Lists.a();
        if (this.aB.f11772d.contains(Type.PHOTO)) {
            a.add("image/*");
        }
        if (a.isEmpty()) {
            aA();
            return;
        }
        intent.setType(Joiner.on(',').join(a));
        this.ar.b(intent, 1, this);
    }

    public final void m12406a(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                m12397a(i2, intent);
                return;
            case 2:
                m12403f(i2);
                return;
            case 3:
                m12404g(i2);
                return;
            case 5:
                m12402b(i2, intent);
                return;
            case 6:
                az();
                return;
            default:
                return;
        }
    }

    private void m12397a(int i, Intent intent) {
        if (i != -1) {
            aA();
            return;
        }
        ImmutableList of;
        if (VERSION.SDK_INT < 18 || intent.getClipData() == null) {
            of = ImmutableList.of(intent.getData());
        } else {
            ClipData clipData = intent.getClipData();
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i2 = 0; i2 < clipData.getItemCount(); i2++) {
                builder.c(clipData.getItemAt(i2).getUri());
            }
            of = builder.b();
        }
        ImmutableList immutableList = of;
        ImmutableList.Builder builder2 = ImmutableList.builder();
        Uri uri = (Uri) immutableList.get(0);
        String type = this.aw.getType(uri);
        if (type == null) {
            type = intent.getType();
        }
        if (type == null) {
            type = URLConnection.guessContentTypeFromName(uri.getPath());
        }
        MediaResourceBuilder a = MediaResource.a();
        a.a = uri;
        MediaResourceBuilder mediaResourceBuilder = a;
        mediaResourceBuilder.c = Source.GALLERY;
        mediaResourceBuilder = mediaResourceBuilder;
        if (type == null || !type.contains("image")) {
            this.ax.a(am.getName(), "unsupported/unknown media type returned from gallery");
            aB(this);
            return;
        }
        mediaResourceBuilder.b = Type.PHOTO;
        MediaResource C = mediaResourceBuilder.C();
        if (MediaResourceUtil.a(C)) {
            builder2.c(C);
            List b = builder2.b();
            if (this.aB.f11770b != null) {
                m12399a(((MediaResource) b.get(0)).c);
                return;
            } else {
                m12401a(b);
                return;
            }
        }
        aB(this);
    }

    private void m12402b(int i, Intent intent) {
        if (i != -1) {
            aA();
            return;
        }
        List parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
        if (this.aB.f11770b != null) {
            m12399a(((MediaResource) parcelableArrayListExtra.get(0)).c);
        } else {
            m12401a(parcelableArrayListExtra);
        }
    }

    private void m12403f(int i) {
        if (i != -1) {
            aA();
        } else if (this.aB.f11770b != null) {
            m12399a(this.aC);
        } else {
            MediaResourceBuilder a = MediaResource.a();
            a.a = this.aC;
            a = a;
            a.b = Type.PHOTO;
            a = a;
            a.c = Source.CAMERA;
            m12401a(ImmutableList.of(a.C()));
        }
    }

    private void m12404g(int i) {
        Source source;
        switch (this.aB.f11769a) {
            case CAMERA:
                source = Source.CAMERA;
                break;
            case GALLERY:
                source = Source.GALLERY;
                break;
            default:
                source = Source.UNSPECIFIED;
                break;
        }
        if (this.aB.f11769a == PickMediaSource.GALLERY) {
            source = Source.GALLERY;
        }
        if (i == -1) {
            MediaResourceBuilder a = MediaResource.a();
            a.a = this.aD;
            a = a;
            a.b = Type.PHOTO;
            a = a;
            a.c = source;
            m12401a(ImmutableList.of(a.C()));
            return;
        }
        aA();
    }

    private void m12399a(Uri uri) {
        CropImageParams cropImageParams = this.aB.f11770b;
        Intent intent = new Intent(getContext(), CropImage.class);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("outputX", cropImageParams.f11751a);
        intent.putExtra("outputY", cropImageParams.f11752b);
        intent.putExtra("aspectX", cropImageParams.f11753c);
        intent.putExtra("aspectY", cropImageParams.f11754d);
        intent.putExtra("scale", true);
        intent.putExtra("output", this.aD);
        intent.putExtra("outputFormat", CompressFormat.JPEG.toString());
        this.ar.a(intent, 3, this);
    }

    private void az() {
        if (aq()) {
            at();
        } else {
            aA();
        }
    }

    private void m12401a(final List<MediaResource> list) {
        Futures.a(this.at.a(new Callable<ImmutableList<MediaResource>>(this) {
            final /* synthetic */ PickMediaDialogFragment f11765b;

            public Object call() {
                PickMediaDialogFragment pickMediaDialogFragment = this.f11765b;
                List<MediaResource> list = list;
                pickMediaDialogFragment.av.b();
                for (MediaResource mediaResource : list) {
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(mediaResource.c);
                    pickMediaDialogFragment.getContext().sendBroadcast(intent);
                }
                ImmutableList.Builder builder = ImmutableList.builder();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Object obj = (MediaResource) it.next();
                    if (!MediaResourceHelper.a(obj)) {
                        MediaResourceBuilder a = MediaResource.a().a(obj);
                        pickMediaDialogFragment.an.a(a);
                        obj = a.C();
                    }
                    builder.c(obj);
                }
                return builder.b();
            }
        }), new C13194(this), this.au);
    }

    private void aA() {
        if (mx_()) {
            if (this.aE != null) {
                this.aE.mo557b();
            }
            b();
        }
    }

    public static void aB(PickMediaDialogFragment pickMediaDialogFragment) {
        if (pickMediaDialogFragment.mx_()) {
            if (pickMediaDialogFragment.aE != null) {
                pickMediaDialogFragment.aE.mo555a();
            }
            pickMediaDialogFragment.b();
        }
    }
}
