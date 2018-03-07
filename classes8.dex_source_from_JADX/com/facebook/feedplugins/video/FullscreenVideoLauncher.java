package com.facebook.feedplugins.video;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.feedplugins.attachments.video.VideoAttachmentDelegate;
import com.facebook.inject.Assisted;
import com.facebook.inject.ForAppContext;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import javax.inject.Inject;

/* compiled from: form_fields */
public class FullscreenVideoLauncher {
    public final VideoAttachmentDelegate f13038a;
    private final ZeroDialogController f13039b;
    private final Context f13040c;
    public boolean f13041d;
    private FragmentActivity f13042e;
    public int f13043f;

    /* compiled from: form_fields */
    class FullscreenListener implements FullscreenTransitionListener {
        final /* synthetic */ FullscreenVideoLauncher f13037a;

        public FullscreenListener(FullscreenVideoLauncher fullscreenVideoLauncher) {
            this.f13037a = fullscreenVideoLauncher;
        }

        public final void m14735a(ExitFullScreenResult exitFullScreenResult) {
            this.f13037a.f13041d = false;
            if (exitFullScreenResult.b) {
                this.f13037a.f13043f = 0;
                return;
            }
            this.f13037a.f13043f = exitFullScreenResult.c;
        }
    }

    @Inject
    public FullscreenVideoLauncher(FragmentActivity fragmentActivity, @Assisted VideoAttachmentDelegate videoAttachmentDelegate, ZeroDialogController zeroDialogController, @ForAppContext Context context) {
        this.f13042e = fragmentActivity;
        this.f13038a = videoAttachmentDelegate;
        this.f13038a.a();
        this.f13039b = zeroDialogController;
        this.f13040c = context;
        this.f13038a.a(new FullscreenListener(this));
    }

    public final void m14736a(final View view) {
        if (!this.f13041d) {
            this.f13041d = true;
            this.f13039b.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, this.f13040c.getString(2131232932), new Listener(this) {
                final /* synthetic */ FullscreenVideoLauncher f13036b;

                public final void m14734a(Object obj) {
                    this.f13036b.f13038a.a(view);
                    this.f13036b.f13038a.a(this.f13036b.f13043f, this.f13036b.f13043f, false);
                }

                public final void m14733a() {
                    this.f13036b.f13041d = false;
                }
            });
            this.f13039b.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, this.f13042e.kO_());
        }
    }
}
