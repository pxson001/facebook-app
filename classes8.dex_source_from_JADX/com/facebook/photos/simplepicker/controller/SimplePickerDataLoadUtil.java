package com.facebook.photos.simplepicker.controller;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.photos.local.LocalMediaCursor;
import com.facebook.photos.local.LocalMediaCursorImp;
import com.facebook.photos.local.LocalMediaCursorMethodAutoProvider;
import com.facebook.photos.simplepicker.LegacySimplePickerFragment.C03652;
import com.facebook.photos.simplepicker.SimplePickerFragment.CursorUpdatedCallback;
import com.facebook.photos.simplepicker.SimplePickerTaskId;
import com.facebook.photos.simplepicker.logging.SimplePickerAssetLogger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: share_failed */
public class SimplePickerDataLoadUtil {
    public static final String f3127b = SimplePickerDataLoadUtil.class.getSimpleName();
    final DefaultAndroidThreadUtil f3128a;
    public Lazy<TasksManager> f3129c;
    public LocalMediaCursorImp f3130d;
    public DefaultAppChoreographer f3131e;
    public ListeningExecutorService f3132f;
    public Lazy<FbErrorReporter> f3133g;
    public int f3134h;
    public final SimplePickerAssetLogger f3135i;

    /* compiled from: share_failed */
    class C04032 extends AbstractDisposableFutureCallback<Void> {
        final /* synthetic */ SimplePickerDataLoadUtil f3126a;

        C04032(SimplePickerDataLoadUtil simplePickerDataLoadUtil) {
            this.f3126a = simplePickerDataLoadUtil;
        }

        protected final void m3138a(Throwable th) {
            ((AbstractFbErrorReporter) this.f3126a.f3133g.get()).a(SimplePickerDataLoadUtil.f3127b, "Unable to complete MediaStore query");
        }
    }

    public static SimplePickerDataLoadUtil m3140b(InjectorLike injectorLike) {
        return new SimplePickerDataLoadUtil(IdBasedLazy.a(injectorLike, 3561), IdBasedSingletonScopeProvider.b(injectorLike, 494), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), SimplePickerGridViewUtil.m3142a(injectorLike), LocalMediaCursorMethodAutoProvider.b(injectorLike), DefaultAppChoreographer.a(injectorLike), SimplePickerAssetLogger.m3166a(injectorLike));
    }

    public static SimplePickerDataLoadUtil m3139a(InjectorLike injectorLike) {
        return m3140b(injectorLike);
    }

    @Inject
    public SimplePickerDataLoadUtil(Lazy<TasksManager> lazy, Lazy<FbErrorReporter> lazy2, ListeningExecutorService listeningExecutorService, AndroidThreadUtil androidThreadUtil, SimplePickerGridViewUtil simplePickerGridViewUtil, LocalMediaCursor localMediaCursor, AppChoreographer appChoreographer, SimplePickerAssetLogger simplePickerAssetLogger) {
        this.f3129c = lazy;
        this.f3133g = lazy2;
        this.f3132f = listeningExecutorService;
        this.f3128a = androidThreadUtil;
        this.f3130d = localMediaCursor;
        this.f3131e = appChoreographer;
        this.f3135i = simplePickerAssetLogger;
        this.f3134h = simplePickerGridViewUtil.m3144a();
    }

    public final void m3141a(SupportedMediaType supportedMediaType, boolean z, @Nullable C03652 c03652, @Nullable CursorUpdatedCallback cursorUpdatedCallback, @Nullable SimplePickerViewController simplePickerViewController, String str) {
        final SupportedMediaType supportedMediaType2 = supportedMediaType;
        final String str2 = str;
        final SimplePickerViewController simplePickerViewController2 = simplePickerViewController;
        final boolean z2 = z;
        final CursorUpdatedCallback cursorUpdatedCallback2 = cursorUpdatedCallback;
        final C03652 c036522 = c03652;
        ((TasksManager) this.f3129c.get()).a(SimplePickerTaskId.MEDIA_STORE_QUERY, new Callable<ListenableFuture>(this) {
            final /* synthetic */ SimplePickerDataLoadUtil f3125g;

            /* compiled from: share_failed */
            class C04011 implements Callable<Void> {
                final /* synthetic */ C04021 f3118a;

                C04011(C04021 c04021) {
                    this.f3118a = c04021;
                }

                public Object call() {
                    Cursor a = this.f3118a.f3125g.f3130d.a(supportedMediaType2, str2);
                    if ((simplePickerViewController2 != null && simplePickerViewController2.m3063a()) || z2) {
                        new MatrixCursor(new String[]{"_id", "media_type", "mime_type", "camera_entry"}).addRow(new Object[]{Integer.valueOf(-1), Integer.valueOf(0), "", Integer.valueOf(1)});
                        a = new MergeCursor(new Cursor[]{r1, a});
                    }
                    this.f3118a.f3125g.f3128a.a(new Runnable(this) {
                        final /* synthetic */ C04011 f3117b;

                        public void run() {
                            if (cursorUpdatedCallback2 != null) {
                                cursorUpdatedCallback2.mo134a(a);
                            }
                        }
                    });
                    List a2 = this.f3118a.f3125g.f3130d.a(a, this.f3118a.f3125g.f3134h);
                    if (c036522 != null) {
                        c036522.m2919a(a2);
                    }
                    return null;
                }
            }

            public Object call() {
                ListenableFuture a = this.f3125g.f3132f.a(new C04011(this));
                this.f3125g.f3131e.a(a);
                return a;
            }
        }, new C04032(this));
    }
}
