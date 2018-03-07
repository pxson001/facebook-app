package com.facebook.orca.compose;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.videocodec.base.VideoMetadataExtractor;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: chain */
public class VideoLengthChecker {
    private final Context f18366a;
    private final NavigationLogger f18367b;
    public final VideoMetadataExtractor f18368c;
    public final ExecutorService f18369d;
    public final ListeningExecutorService f18370e;
    public final AbstractFbErrorReporter f18371f;

    /* compiled from: chain */
    public class C21263 implements Callable<Long> {
        final /* synthetic */ Uri f18361a;
        final /* synthetic */ VideoLengthChecker f18362b;

        public C21263(VideoLengthChecker videoLengthChecker, Uri uri) {
            this.f18362b = videoLengthChecker;
            this.f18361a = uri;
        }

        public Object call() {
            return Long.valueOf(this.f18362b.f18368c.a(this.f18361a).a);
        }
    }

    /* compiled from: chain */
    public class C21274 implements FutureCallback<Long> {
        final /* synthetic */ String f18363a;
        final /* synthetic */ Function f18364b;
        final /* synthetic */ VideoLengthChecker f18365c;

        public C21274(VideoLengthChecker videoLengthChecker, String str, Function function) {
            this.f18365c = videoLengthChecker;
            this.f18363a = str;
            this.f18364b = function;
        }

        public void onSuccess(Object obj) {
            VideoLengthChecker.m18366a(this.f18365c, (Long) obj, this.f18363a, this.f18364b);
        }

        public void onFailure(Throwable th) {
            this.f18365c.f18371f.a("video_length_retreval_category", "Failed to get meta data for video", th);
        }
    }

    @Inject
    public VideoLengthChecker(Context context, NavigationLogger navigationLogger, VideoMetadataExtractor videoMetadataExtractor, ExecutorService executorService, ListeningExecutorService listeningExecutorService, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f18366a = context;
        this.f18367b = navigationLogger;
        this.f18368c = videoMetadataExtractor;
        this.f18369d = executorService;
        this.f18370e = listeningExecutorService;
        this.f18371f = abstractFbErrorReporter;
    }

    private void m18367a(String str, Function<Void, Void> function) {
        m18368a(str, Optional.of(function));
    }

    private void m18368a(String str, Optional<Function<Void, Void>> optional) {
        m18369a(str, optional, this.f18366a.getString(2131231728), this.f18366a.getString(2131231729), "messenger_video_too_short_dialog");
    }

    private void m18369a(String str, final Optional<Function<Void, Void>> optional, String str2, String str3, String str4) {
        new FbAlertDialogBuilder(this.f18366a).a(str2).b(str3).a(17039370, new OnClickListener(this) {
            final /* synthetic */ VideoLengthChecker f18360b;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                if (optional.isPresent()) {
                    ((Function) optional.get()).apply(null);
                }
            }
        }).a(new OnCancelListener(this) {
            final /* synthetic */ VideoLengthChecker f18358b;

            public void onCancel(DialogInterface dialogInterface) {
                if (optional.isPresent()) {
                    ((Function) optional.get()).apply(null);
                }
            }
        }).b();
        this.f18367b.a(str4, true, Collections.singletonMap("from_module", str));
    }

    public static void m18366a(VideoLengthChecker videoLengthChecker, Long l, String str, Function function) {
        Object obj;
        if (l.longValue() < 1000) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            videoLengthChecker.m18367a(str, function);
        }
    }
}
