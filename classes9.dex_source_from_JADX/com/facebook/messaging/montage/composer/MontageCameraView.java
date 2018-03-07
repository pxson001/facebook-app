package com.facebook.messaging.montage.composer;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.internal.widget.ViewStubCompat;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;
import com.facebook.messaging.permissions.PermissionRequestIconView;
import com.facebook.messaging.quickcam.QuickCamView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import javax.annotation.Nullable;

/* compiled from: is_tricky_bin */
public class MontageCameraView extends QuickCamView {
    private final View f12445a;
    public final View f12446b;
    private final View f12447c;
    private final FbTextView f12448d;
    private final FbTextView f12449e;
    private final ProgressBar f12450f;
    private final ViewStub f12451g;
    private final ViewStubHolder<PermissionRequestIconView> f12452h;

    /* compiled from: is_tricky_bin */
    class C13771 implements OnInflateListener<PermissionRequestIconView> {
        final /* synthetic */ MontageCameraView f12443a;

        C13771(MontageCameraView montageCameraView) {
            this.f12443a = montageCameraView;
        }

        public final void m12924a(View view) {
            ((PermissionRequestIconView) view).setBackgroundColor(ContextCompat.b(this.f12443a.getContext(), 2131363803));
        }
    }

    public MontageCameraView(Context context) {
        super(context, null, 0);
        setContentView(2130907117);
        this.f12445a = c(2131565093);
        this.f12446b = c(2131559850);
        this.f12447c = c(2131565095);
        this.f12448d = (FbTextView) c(2131565091);
        this.f12449e = (FbTextView) c(2131559631);
        this.f12450f = (ProgressBar) c(2131559418);
        this.f12451g = (ViewStub) c(2131565001);
        this.f12452h = ViewStubHolder.a((ViewStubCompat) c(2131563969));
        this.f12452h.c = new C13771(this);
    }

    @Nullable
    public View getCameraFlipButton() {
        return this.f12445a;
    }

    @Nullable
    public View getCancelButton() {
        return null;
    }

    public View getCaptureButton() {
        return this.f12446b;
    }

    public View getVideoCancelOverlay() {
        return this.f12447c;
    }

    public FbTextView getTimerText() {
        return this.f12448d;
    }

    public FbTextView getErrorMessage() {
        return this.f12449e;
    }

    public ProgressBar getProgressBar() {
        return this.f12450f;
    }

    public ViewStub getCameraPreviewViewStub() {
        return this.f12451g;
    }

    public ViewStubHolder<PermissionRequestIconView> getRequestPermissionViewStub() {
        return this.f12452h;
    }
}
