package com.facebook.attachments.videos.ui;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.dialtone.common.DialtoneStateChangedListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.player.VideoTransitionNode;
import javax.inject.Inject;

/* compiled from: profile_media_type */
public class FullscreenVideoAttachmentView extends BaseVideoAttachmentView implements HasChannelFeedLauncherInfo, VideoPlayerAttachment {
    @Inject
    public DialtoneController f7350a;
    public final FbDraweeView f7351b = ((FbDraweeView) a(2131568292));
    public final ImageView f7352c = ((ImageView) a(2131563867));
    public DialtoneStateChangedListener f7353d;

    /* compiled from: profile_media_type */
    public class C04281 implements DialtoneStateChangedListener {
        final /* synthetic */ FullscreenVideoAttachmentView f7349a;

        public C04281(FullscreenVideoAttachmentView fullscreenVideoAttachmentView) {
            this.f7349a = fullscreenVideoAttachmentView;
        }

        public final void iw_() {
        }

        public final void b_(boolean z) {
            if (z) {
                this.f7349a.f7352c.setVisibility(8);
            } else {
                this.f7349a.f7352c.setVisibility(0);
            }
        }
    }

    public static void m10454a(Object obj, Context context) {
        ((FullscreenVideoAttachmentView) obj).f7350a = (DialtoneController) DialtoneControllerImpl.a(FbInjector.get(context));
    }

    public FullscreenVideoAttachmentView(Context context) {
        super(context);
        Class cls = FullscreenVideoAttachmentView.class;
        m10454a((Object) this, getContext());
        setContentView(2130907654);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 2096107158);
        super.onAttachedToWindow();
        if (this.f7350a.j()) {
            this.f7352c.setVisibility(8);
            if (this.f7353d == null) {
                this.f7353d = new C04281(this);
            }
            this.f7350a.a(this.f7353d);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -118266829, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1351251000);
        super.onDetachedFromWindow();
        if (this.f7353d != null) {
            this.f7350a.b(this.f7353d);
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2102019025, a);
    }

    public final void m10455a(int i, int i2) {
        LayoutParams layoutParams = this.f7351b.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f7351b.setLayoutParams(layoutParams);
    }

    public final void m10456b(int i, int i2) {
    }

    public DraweeController getCoverController() {
        return this.f7351b.getController();
    }

    public void setCoverController(DraweeController draweeController) {
        this.f7351b.setController(draweeController);
    }

    public void setBackgroundResource(int i) {
        this.f7351b.setBackgroundResource(i);
    }

    public int getSeekPosition() {
        return 0;
    }

    public int getLastStartPosition() {
        return 0;
    }

    public VideoTransitionNode getTransitionNode() {
        return null;
    }

    public VideoStoryPersistentState getVideoStoryPersistentState() {
        return null;
    }
}
