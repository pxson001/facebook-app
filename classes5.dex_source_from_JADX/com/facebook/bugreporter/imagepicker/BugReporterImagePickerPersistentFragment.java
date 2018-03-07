package com.facebook.bugreporter.imagepicker;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bitmaps.ImageResizer;
import com.facebook.bitmaps.ImageResizerMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: android.intent.extra.shortcut.INTENT */
public class BugReporterImagePickerPersistentFragment extends FbFragment {
    public static final String f10754a = BugReporterImagePickerPersistentFragment.class.getSimpleName();
    public ImageResizer f10755b;
    public ListeningExecutorService f10756c;
    public Map<Uri, Bitmap> f10757d = Maps.e();

    /* compiled from: android.intent.extra.shortcut.INTENT */
    public class C10471 implements Callable<Bitmap> {
        final /* synthetic */ Uri f10752a;
        final /* synthetic */ BugReporterImagePickerPersistentFragment f10753b;

        public C10471(BugReporterImagePickerPersistentFragment bugReporterImagePickerPersistentFragment, Uri uri) {
            this.f10753b = bugReporterImagePickerPersistentFragment;
            this.f10752a = uri;
        }

        public Object call() {
            int dimensionPixelSize = this.f10753b.jW_().getDimensionPixelSize(2131430591);
            try {
                Bitmap a = this.f10753b.f10755b.mo1115a(this.f10752a.getPath(), 0, this.f10753b.jW_().getDimensionPixelSize(2131430592), dimensionPixelSize, false);
                this.f10753b.f10757d.put(this.f10752a, a);
                return a;
            } catch (Throwable e) {
                BLog.b(BugReporterImagePickerPersistentFragment.f10754a, "Unable to create thumbnail bitmap.", e);
                return null;
            }
        }
    }

    public static void m18788a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        BugReporterImagePickerPersistentFragment bugReporterImagePickerPersistentFragment = (BugReporterImagePickerPersistentFragment) obj;
        ImageResizer b = ImageResizerMethodAutoProvider.m18454b(fbInjector);
        ListeningExecutorService a = ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(fbInjector);
        bugReporterImagePickerPersistentFragment.f10755b = b;
        bugReporterImagePickerPersistentFragment.f10756c = a;
    }

    public final void m18789c(Bundle bundle) {
        super.c(bundle);
        Class cls = BugReporterImagePickerPersistentFragment.class;
        m18788a(this, getContext());
        d(true);
    }
}
