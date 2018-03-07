package com.facebook.bugreporter.imagepicker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.bugreporter.activity.BugReportActivity;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: android.media.metadata.COMPOSER */
public class BugReporterImagePickerFragment extends FbFragment {
    public static final String f10743a = BugReporterImagePickerFragment.class.getSimpleName();
    private Executor al;
    private Toaster am;
    private View f10744b;
    private ImagePickerContainer f10745c;
    public LinearLayout f10746d;
    public final C10391 f10747e = new C10391(this);
    public BugReporterImagePickerDoodleFragment f10748f;
    private View f10749g;
    public int f10750h = 0;
    private SecureContextHelper f10751i;

    /* compiled from: android.media.metadata.COMPOSER */
    public interface ImagePickerContainer {
        ListenableFuture<Uri> mo1125a(Uri uri);

        ImmutableList<Uri> mo1126b();

        void mo1127b(Uri uri);
    }

    /* compiled from: android.media.metadata.COMPOSER */
    public class C10391 {
        final /* synthetic */ BugReporterImagePickerFragment f10734a;

        C10391(BugReporterImagePickerFragment bugReporterImagePickerFragment) {
            this.f10734a = bugReporterImagePickerFragment;
        }

        public final void m18761a(Uri uri) {
            this.f10734a.m18763a(uri);
        }
    }

    /* compiled from: android.media.metadata.COMPOSER */
    class C10402 implements OnClickListener {
        final /* synthetic */ BugReporterImagePickerFragment f10735a;

        C10402(BugReporterImagePickerFragment bugReporterImagePickerFragment) {
            this.f10735a = bugReporterImagePickerFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1885511219);
            BugReporterImagePickerFragment.as(this.f10735a);
            Logger.a(2, EntryType.UI_INPUT_END, 880721541, a);
        }
    }

    /* compiled from: android.media.metadata.COMPOSER */
    class C10413 implements FutureCallback<Uri> {
        final /* synthetic */ BugReporterImagePickerFragment f10736a;

        C10413(BugReporterImagePickerFragment bugReporterImagePickerFragment) {
            this.f10736a = bugReporterImagePickerFragment;
        }

        public void onSuccess(Object obj) {
            Uri uri = (Uri) obj;
            if (uri != null) {
                BugReporterImagePickerFragment.m18778c(this.f10736a, uri);
            } else {
                BLog.a(BugReporterImagePickerFragment.f10743a, "Parent didn't return a uri.");
            }
        }

        public void onFailure(Throwable th) {
            BugReporterImagePickerFragment.m18782g(this.f10736a, 2131235878);
            BLog.b(BugReporterImagePickerFragment.f10743a, "Parent didn't return a valid source uri.", th);
        }
    }

    /* compiled from: android.media.metadata.COMPOSER */
    class C10455 implements FutureCallback<BugReporterImagePickerThumbnail> {
        final /* synthetic */ BugReporterImagePickerFragment f10741a;

        C10455(BugReporterImagePickerFragment bugReporterImagePickerFragment) {
            this.f10741a = bugReporterImagePickerFragment;
        }

        public void onSuccess(Object obj) {
            this.f10741a.f10746d.addView((BugReporterImagePickerThumbnail) obj);
        }

        public void onFailure(Throwable th) {
            BugReporterImagePickerFragment.m18782g(this.f10741a, 2131235879);
            BLog.b(BugReporterImagePickerFragment.f10743a, "Unable to create a thumbnail", th);
        }
    }

    /* compiled from: android.media.metadata.COMPOSER */
    class C10466 implements FutureCallback<List<BugReporterImagePickerThumbnail>> {
        final /* synthetic */ BugReporterImagePickerFragment f10742a;

        C10466(BugReporterImagePickerFragment bugReporterImagePickerFragment) {
            this.f10742a = bugReporterImagePickerFragment;
        }

        public void onSuccess(Object obj) {
            for (BugReporterImagePickerThumbnail bugReporterImagePickerThumbnail : (List) obj) {
                if (bugReporterImagePickerThumbnail != null) {
                    this.f10742a.f10746d.addView(bugReporterImagePickerThumbnail);
                }
            }
        }

        public void onFailure(Throwable th) {
            BugReporterImagePickerFragment.m18782g(this.f10742a, 2131235879);
            BLog.b(BugReporterImagePickerFragment.f10743a, "Unable to create thumbnails.", th);
        }
    }

    private static <T extends InjectableComponentWithContext> void m18770a(Class<T> cls, T t) {
        m18771a((Object) t, t.getContext());
    }

    private static void m18771a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BugReporterImagePickerFragment) obj).m18769a(Toaster.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector));
    }

    @Inject
    private void m18769a(Toaster toaster, SecureContextHelper secureContextHelper, Executor executor) {
        this.f10751i = secureContextHelper;
        this.al = executor;
        this.am = toaster;
    }

    public final void m18786c(Bundle bundle) {
        super.c(bundle);
        m18770a(BugReporterImagePickerFragment.class, (InjectableComponentWithContext) this);
        m18781e();
    }

    public final View m18784a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -147374977);
        this.f10749g = layoutInflater.inflate(2130904834, viewGroup, false);
        aq();
        ar();
        View view = this.f10749g;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 344402365, a);
        return view;
    }

    private void aq() {
        this.f10744b = this.f10749g.findViewById(2131563052);
        this.f10744b.setOnClickListener(new C10402(this));
    }

    private void ar() {
        this.f10746d = (LinearLayout) this.f10749g.findViewById(2131563051);
    }

    public final void m18787d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1351628395);
        super.d(bundle);
        m18772a(this.f10745c.mo1126b());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -257764313, a);
    }

    public final void m18785a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i == 1 && i2 == -1 && intent != null && intent.getData() != null) {
            m18763a(intent.getData());
        }
    }

    public static void as(BugReporterImagePickerFragment bugReporterImagePickerFragment) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        if (bugReporterImagePickerFragment.getContext().getPackageManager() == null || intent.resolveActivity(bugReporterImagePickerFragment.getContext().getPackageManager()) == null) {
            BLog.a(f10743a, "Unable to start a media-picker.");
        } else {
            bugReporterImagePickerFragment.f10751i.b(intent, 1, bugReporterImagePickerFragment);
        }
    }

    private void m18763a(@Nonnull Uri uri) {
        this.f10750h++;
        at();
        ListenableFuture listenableFuture = null;
        if (this.f10745c != null) {
            listenableFuture = this.f10745c.mo1125a(uri);
        }
        if (listenableFuture != null) {
            Futures.a(listenableFuture, new C10413(this), this.al);
        }
    }

    private void m18764a(Uri uri, View view) {
        if (this.f10745c != null) {
            this.f10745c.mo1127b(uri);
        }
        this.f10746d.removeView(view);
        if (ao() != null) {
            ((BugReportActivity) ao()).m18700b(uri);
        }
        this.f10750h--;
        at();
    }

    private void at() {
        if (this.f10750h < 3) {
            this.f10744b.setEnabled(true);
        } else {
            this.f10744b.setEnabled(false);
        }
    }

    private ListenableFuture<BugReporterImagePickerThumbnail> m18774b(@Nonnull final Uri uri) {
        if (ao() != null) {
            return Futures.a(((BugReportActivity) ao()).m18699a(uri), new Function<Bitmap, BugReporterImagePickerThumbnail>(this) {
                final /* synthetic */ BugReporterImagePickerFragment f10740b;

                /* compiled from: android.media.metadata.COMPOSER */
                class C10421 implements OnClickListener {
                    final /* synthetic */ C10444 f10737a;

                    C10421(C10444 c10444) {
                        this.f10737a = c10444;
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1780345206);
                        this.f10737a.f10740b.m18764a(uri, (View) view.getParent());
                        Logger.a(2, EntryType.UI_INPUT_END, 713815640, a);
                    }
                }

                /* compiled from: android.media.metadata.COMPOSER */
                class C10432 implements OnClickListener {
                    final /* synthetic */ C10444 f10738a;

                    C10432(C10444 c10444) {
                        this.f10738a = c10444;
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 740847383);
                        if (this.f10738a.f10740b.f10750h >= 3) {
                            Logger.a(2, EntryType.UI_INPUT_END, 825443844, a);
                            return;
                        }
                        BugReporterImagePickerFragment bugReporterImagePickerFragment = this.f10738a.f10740b;
                        Parcelable parcelable = uri;
                        BugReporterImagePickerDoodleFragment bugReporterImagePickerDoodleFragment = new BugReporterImagePickerDoodleFragment();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("arg_screenshot_bitmap_uri", parcelable);
                        bugReporterImagePickerDoodleFragment.g(bundle);
                        bugReporterImagePickerFragment.f10748f = bugReporterImagePickerDoodleFragment;
                        this.f10738a.f10740b.f10748f.av = this.f10738a.f10740b.f10747e;
                        this.f10738a.f10740b.f10748f.a(this.f10738a.f10740b.s(), BugReporterImagePickerDoodleFragment.class.getName());
                        LogUtils.a(-643204130, a);
                    }
                }

                public Object apply(@Nullable Object obj) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap == null) {
                        BugReporterImagePickerFragment.m18782g(this.f10740b, 2131235879);
                        return null;
                    }
                    Object bugReporterImagePickerThumbnail = new BugReporterImagePickerThumbnail(this.f10740b.getContext());
                    bugReporterImagePickerThumbnail.f10759a.setImageBitmap(bitmap);
                    bugReporterImagePickerThumbnail.f10760b.setOnClickListener(new C10421(this));
                    bugReporterImagePickerThumbnail.setOnClickListener(new C10432(this));
                    return bugReporterImagePickerThumbnail;
                }
            }, this.al);
        }
        m18782g(this, 2131235879);
        return null;
    }

    public static void m18778c(@Nonnull BugReporterImagePickerFragment bugReporterImagePickerFragment, Uri uri) {
        Futures.a(bugReporterImagePickerFragment.m18774b(uri), new C10455(bugReporterImagePickerFragment), bugReporterImagePickerFragment.al);
    }

    private void m18772a(List<Uri> list) {
        this.f10750h = list.size();
        at();
        Iterable a = Lists.a();
        for (Uri b : list) {
            a.add(m18774b(b));
        }
        Futures.a(Futures.b(a), new C10466(this), this.al);
    }

    public static void m18782g(BugReporterImagePickerFragment bugReporterImagePickerFragment, int i) {
        bugReporterImagePickerFragment.am.b(new ToastBuilder(i));
    }

    public final void m18783I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 708031823);
        if (this.f10748f != null) {
            this.f10748f.av = null;
        }
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2062356905, a);
    }

    private void m18781e() {
        Fragment fragment = this.G;
        Context context = getContext();
        if (fragment != null && (fragment instanceof ImagePickerContainer)) {
            this.f10745c = (ImagePickerContainer) fragment;
        } else if (context instanceof ImagePickerContainer) {
            this.f10745c = (ImagePickerContainer) context;
        } else {
            String str = f10743a;
            String str2 = "BugReporterImagePickerFragment should be embedded in contexts that implement the ImagePickerContainer interface. Currently `%s`.";
            Object[] objArr = new Object[1];
            objArr[0] = context != null ? context.toString() : "null";
            BLog.a(str, str2, objArr);
        }
    }
}
