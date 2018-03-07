package com.facebook.facecast.plugin;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.facecast.FacecastStateManager.FacecastBroadcastState;
import javax.annotation.Nullable;

/* compiled from: borderColor */
public class FacecastPausedPlugin extends FacecastDialogPlugin {
    public FacecastPausedPlugin(Context context) {
        this(context, null);
    }

    private FacecastPausedPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastPausedPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18233c.setText(2131238232);
        this.f18234d.setText(2131238233);
        this.f18235e.setText(2131238226);
        this.f18236f.setText(2131238227);
    }

    protected final void mo1414g() {
        this.f18166b.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_ABOUT_TO_FINISH);
    }

    protected final void mo1415h() {
        this.f18166b.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_RECORDING);
    }
}
