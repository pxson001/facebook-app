package com.facebook.bugreporter.imagepicker;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.bugreporter.imagepicker.BugReporterImagePickerFragment.C10391;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager$Privacy;
import com.facebook.common.ui.util.ViewOrientationLockHelper;
import com.facebook.common.ui.util.ViewOrientationLockHelperProvider;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawingview.DrawingView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: android.intent.extra.shortcut.NAME */
public class BugReporterImagePickerDoodleFragment extends FbDialogFragment {
    private static final CallerContext ar = CallerContext.a(BugReporterImagePickerDoodleFragment.class);
    public static final Class<?> as = BugReporterImagePickerDoodleFragment.class;
    @ForNonUiThread
    @Inject
    public ListeningExecutorService am;
    @Inject
    @ForUiThread
    public Executor an;
    @Inject
    TempFileManager ao;
    @Inject
    Toaster ap;
    @Inject
    ViewOrientationLockHelperProvider aq;
    private DrawingView at;
    private FbDraweeView au;
    @Nullable
    public C10391 av;
    private View aw;
    public FrameLayout ax;
    private ViewOrientationLockHelper ay;

    /* compiled from: android.intent.extra.shortcut.NAME */
    class C10361 implements OnClickListener {
        final /* synthetic */ BugReporterImagePickerDoodleFragment f10731a;

        C10361(BugReporterImagePickerDoodleFragment bugReporterImagePickerDoodleFragment) {
            this.f10731a = bugReporterImagePickerDoodleFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2060046952);
            BugReporterImagePickerDoodleFragment bugReporterImagePickerDoodleFragment = this.f10731a;
            Futures.a(bugReporterImagePickerDoodleFragment.am.a(new C10372(bugReporterImagePickerDoodleFragment)), new C10383(bugReporterImagePickerDoodleFragment), bugReporterImagePickerDoodleFragment.an);
            Logger.a(2, EntryType.UI_INPUT_END, -528634406, a);
        }
    }

    /* compiled from: android.intent.extra.shortcut.NAME */
    public class C10372 implements Callable<Uri> {
        final /* synthetic */ BugReporterImagePickerDoodleFragment f10732a;

        public C10372(BugReporterImagePickerDoodleFragment bugReporterImagePickerDoodleFragment) {
            this.f10732a = bugReporterImagePickerDoodleFragment;
        }

        public Object call() {
            this.f10732a.ax.setDrawingCacheEnabled(true);
            this.f10732a.ax.buildDrawingCache();
            Bitmap createBitmap = Bitmap.createBitmap(this.f10732a.ax.getDrawingCache());
            this.f10732a.ax.setDrawingCacheEnabled(false);
            Uri fromFile = Uri.fromFile(this.f10732a.ao.a("bugreporter-doodle-", ".jpg", TempFileManager$Privacy.REQUIRE_PRIVATE));
            OutputStream fileOutputStream = new FileOutputStream(fromFile.getPath());
            try {
                createBitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
                return fromFile;
            } finally {
                fileOutputStream.close();
            }
        }
    }

    /* compiled from: android.intent.extra.shortcut.NAME */
    public class C10383 implements FutureCallback<Uri> {
        final /* synthetic */ BugReporterImagePickerDoodleFragment f10733a;

        public C10383(BugReporterImagePickerDoodleFragment bugReporterImagePickerDoodleFragment) {
            this.f10733a = bugReporterImagePickerDoodleFragment;
        }

        public void onSuccess(@javax.annotation.Nullable Object obj) {
            Uri uri = (Uri) obj;
            if (this.f10733a.av != null) {
                this.f10733a.av.m18761a(uri);
            }
            this.f10733a.a();
        }

        public void onFailure(Throwable th) {
            this.f10733a.a();
            this.f10733a.ap.a(new ToastBuilder(2131230758));
            BLog.b(BugReporterImagePickerDoodleFragment.as, "Saving the bitmap failed, could not generate Uri.", th);
        }
    }

    public static void m18754a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BugReporterImagePickerDoodleFragment) obj).m18753a((ListeningExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), TempFileManager.a(fbInjector), Toaster.b(fbInjector), (ViewOrientationLockHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ViewOrientationLockHelperProvider.class));
    }

    private void m18753a(ListeningExecutorService listeningExecutorService, Executor executor, TempFileManager tempFileManager, Toaster toaster, ViewOrientationLockHelperProvider viewOrientationLockHelperProvider) {
        this.am = listeningExecutorService;
        this.an = executor;
        this.ao = tempFileManager;
        this.ap = toaster;
        this.aq = viewOrientationLockHelperProvider;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 627004251);
        super.mi_();
        this.ay = this.aq.m3883a(this.T);
        this.ay.m3881a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1031191636, a);
    }

    public final void m18758a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1994460530);
        super.a(bundle);
        Class cls = BugReporterImagePickerDoodleFragment.class;
        m18754a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1597401256, a);
    }

    public final View m18756a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -499087991);
        View inflate = layoutInflater.inflate(2130903454, viewGroup);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1460794979, a);
        return inflate;
    }

    public final void m18760d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -990633191);
        super.d(bundle);
        this.au = (FbDraweeView) e(2131560060);
        this.au.a((Uri) this.s.getParcelable("arg_screenshot_bitmap_uri"), ar);
        this.at = (DrawingView) e(2131560061);
        this.at.setColour(jW_().getColor(2131361918));
        this.aw = e(2131560062);
        this.aw.setOnClickListener(new C10361(this));
        this.ax = (FrameLayout) e(2131560059);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -630759184, a);
    }

    public final Dialog m18759c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.setTitle(b(2131235881));
        c.setCanceledOnTouchOutside(true);
        return c;
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1406101894);
        super.mj_();
        this.ay.m3882b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1194222333, a);
    }

    public final void m18755I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2045894693);
        super.I();
        this.ay.m3882b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1121259953, a);
    }

    public final void m18757a() {
        super.a();
        this.ay.m3882b();
    }
}
