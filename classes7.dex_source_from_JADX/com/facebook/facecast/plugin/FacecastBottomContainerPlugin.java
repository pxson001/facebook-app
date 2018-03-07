package com.facebook.facecast.plugin;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.facecast.FacecastStateManager.FacecastBroadcastState;
import com.facebook.facecast.FacecastStateManager.FacecastStateChangeListener;
import com.facebook.facecast.plugin.FacecastToolbarContainer.OnBroadcasterPostCommentListener;
import com.facebook.facecastdisplay.FacecastInteractionView;
import com.facebook.facecastdisplay.LiveEventAuthor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.sounds.FBSoundUtil;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: broadcast_duration */
public class FacecastBottomContainerPlugin extends FacecastBasePlugin implements FacecastStateChangeListener, OnBroadcasterPostCommentListener {
    public final View f18211c;
    @Inject
    public Lazy<FBSoundUtil> f18212d;
    @Nullable
    public FacecastBroadcastFinishedListener f18213e;
    private final FacecastInteractionView f18214f;
    private final View f18215g;
    public final FacecastToolbarContainer f18216h;
    public final FbButton f18217i;

    /* compiled from: broadcast_duration */
    class C15321 implements OnClickListener {
        final /* synthetic */ FacecastBottomContainerPlugin f18209a;

        C15321(FacecastBottomContainerPlugin facecastBottomContainerPlugin) {
            this.f18209a = facecastBottomContainerPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1705250934);
            if (this.f18209a.f18213e != null) {
                this.f18209a.f18213e.hD_();
                ((FBSoundUtil) this.f18209a.f18212d.get()).a(2131165214, 2, 0.15f);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -553345918, a);
        }
    }

    /* compiled from: broadcast_duration */
    public interface FacecastBroadcastFinishedListener {
        void hD_();
    }

    public static void m21970a(Object obj, Context context) {
        ((FacecastBottomContainerPlugin) obj).f18212d = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 10994);
    }

    public FacecastBottomContainerPlugin(Context context) {
        this(context, null);
    }

    private FacecastBottomContainerPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastBottomContainerPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastBottomContainerPlugin.class;
        m21970a((Object) this, getContext());
        setContentView(2130904189);
        this.f18211c = a(2131561605);
        this.f18214f = (FacecastInteractionView) a(2131561606);
        this.f18215g = a(2131561607);
        this.f18216h = (FacecastToolbarContainer) a(2131561608);
        this.f18217i = (FbButton) a(2131561609);
        this.f18217i.setOnClickListener(new C15321(this));
        this.f18216h.f18547q = this;
    }

    protected final void hE_() {
        super.hE_();
        this.f18166b.m21882a((FacecastStateChangeListener) this);
    }

    protected final void mo1408a(ViewGroup viewGroup, FacecastStateManager facecastStateManager) {
        super.mo1408a(viewGroup, facecastStateManager);
        facecastStateManager.m21884b((FacecastStateChangeListener) this);
    }

    public final void mo1385a(FacecastBroadcastState facecastBroadcastState, FacecastBroadcastState facecastBroadcastState2) {
        switch (facecastBroadcastState2) {
            case FACECAST_BROADCAST_STATE_RECORDING:
                this.f18216h.m22173a();
                break;
        }
        switch (facecastBroadcastState) {
            case FACECAST_BROADCAST_STATE_FINISHED:
                this.f18214f.m3092b();
                return;
            default:
                return;
        }
    }

    public final void m21974a(String str, ComposerTargetData composerTargetData, boolean z, float f) {
        this.f18214f.setVideoAspectRatio((double) f);
        this.f18214f.setFullScreenMode(z);
        this.f18214f.setVideoIdForBroadcaster(str);
        this.f18215g.setBackgroundDrawable(new ColorDrawable(getResources().getColor(z ? 2131363609 : 2131363608)));
        this.f18216h.m22174a(str, composerTargetData);
        this.f18214f.m3087a();
    }

    public void setSuspended(boolean z) {
        this.f18214f.setSuspended(z);
    }

    public final void m21975a(boolean z) {
        this.f18217i.setEnabled(z);
    }

    public final void mo1411a(String str, int i, LiveEventAuthor liveEventAuthor) {
        this.f18214f.m3090a(str, i, liveEventAuthor);
    }

    public View getToolbarContainer() {
        return this.f18216h;
    }
}
