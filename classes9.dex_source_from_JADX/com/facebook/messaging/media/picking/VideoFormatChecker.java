package com.facebook.messaging.media.picking;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.facebook.analytics.NavigationLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.Files;
import java.util.Collections;
import javax.inject.Inject;

/* compiled from: logOut */
public class VideoFormatChecker {
    public static final ImmutableSet<String> f11806c = ImmutableSet.of("avi", "flv", "mkv", "mov", "mpg", "webm", new String[]{"wmv"});
    public final Context f11807a;
    public final NavigationLogger f11808b;

    /* compiled from: logOut */
    class C13311 implements OnClickListener {
        final /* synthetic */ VideoFormatChecker f11805a;

        C13311(VideoFormatChecker videoFormatChecker) {
            this.f11805a = videoFormatChecker;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static VideoFormatChecker m12435b(InjectorLike injectorLike) {
        return new VideoFormatChecker((Context) injectorLike.getInstance(Context.class), NavigationLogger.a(injectorLike));
    }

    @Inject
    public VideoFormatChecker(Context context, NavigationLogger navigationLogger) {
        this.f11807a = context;
        this.f11808b = navigationLogger;
    }

    public static VideoFormatChecker m12434a(InjectorLike injectorLike) {
        return m12435b(injectorLike);
    }

    public final boolean m12436a(Uri uri, String str) {
        Object obj;
        boolean z;
        OnClickListener c13311 = new C13311(this);
        Preconditions.checkNotNull(c13311);
        if (f11806c.contains(Files.a(uri.getPath()).toLowerCase())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            Preconditions.checkNotNull(c13311);
            new FbAlertDialogBuilder(this.f11807a).a(2131231754).b(2131231755).a(17039370, c13311).a(false).b();
            this.f11808b.a("messenger_video_format_not_supported_dialog", true, Collections.singletonMap("fromModule", str));
            z = false;
        } else {
            z = true;
        }
        return z;
    }
}
