package com.facebook.messaging.media.picking;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.analytics.NavigationLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.MaxVideoSizeHelper;
import com.facebook.messaging.media.upload.MessagesVideoSizeEstimator;
import javax.inject.Inject;

/* compiled from: logInWithReadPermissions */
public class VideoSizeChecker {
    public final MessagesVideoSizeEstimator f11815a;
    public final Context f11816b;
    public final NavigationLogger f11817c;
    public final MaxVideoSizeHelper f11818d;

    /* compiled from: logInWithReadPermissions */
    public class C13321 implements OnClickListener {
        final /* synthetic */ DialogListener f11809a;
        final /* synthetic */ VideoSizeChecker f11810b;

        public C13321(VideoSizeChecker videoSizeChecker, DialogListener dialogListener) {
            this.f11810b = videoSizeChecker;
            this.f11809a = dialogListener;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f11809a.m12437a();
        }
    }

    /* compiled from: logInWithReadPermissions */
    public class C13332 implements OnClickListener {
        final /* synthetic */ DialogListener f11811a;
        final /* synthetic */ VideoSizeChecker f11812b;

        public C13332(VideoSizeChecker videoSizeChecker, DialogListener dialogListener) {
            this.f11812b = videoSizeChecker;
            this.f11811a = dialogListener;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: logInWithReadPermissions */
    public class C13343 implements OnClickListener {
        final /* synthetic */ DialogListener f11813a;
        final /* synthetic */ VideoSizeChecker f11814b;

        public C13343(VideoSizeChecker videoSizeChecker, DialogListener dialogListener) {
            this.f11814b = videoSizeChecker;
            this.f11813a = dialogListener;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            this.f11813a.m12437a();
        }
    }

    /* compiled from: logInWithReadPermissions */
    public interface DialogListener {
        void m12437a();
    }

    public static VideoSizeChecker m12438a(InjectorLike injectorLike) {
        return new VideoSizeChecker(MessagesVideoSizeEstimator.a(injectorLike), (Context) injectorLike.getInstance(Context.class), NavigationLogger.a(injectorLike), MaxVideoSizeHelper.m12454b(injectorLike));
    }

    @Inject
    public VideoSizeChecker(MessagesVideoSizeEstimator messagesVideoSizeEstimator, Context context, NavigationLogger navigationLogger, MaxVideoSizeHelper maxVideoSizeHelper) {
        this.f11815a = messagesVideoSizeEstimator;
        this.f11816b = context;
        this.f11817c = navigationLogger;
        this.f11818d = maxVideoSizeHelper;
    }
}
