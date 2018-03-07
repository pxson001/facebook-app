package com.facebook.facecast.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.facebook.facecast.FacecastStateManager.FacecastBroadcastState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.video.abtest.VideoAbTestGatekeepers;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: borderBottomRightRadius */
public class FacecastReconnectingPlugin extends FacecastBasePlugin {
    @Inject
    public GatekeeperStoreImpl f18468c;
    private final FbButton f18469d;
    private final ProgressBar f18470e;

    /* compiled from: borderBottomRightRadius */
    class C15841 implements OnClickListener {
        final /* synthetic */ FacecastReconnectingPlugin f18467a;

        C15841(FacecastReconnectingPlugin facecastReconnectingPlugin) {
            this.f18467a = facecastReconnectingPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -798845783);
            this.f18467a.f18166b.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_ABOUT_TO_FINISH);
            Logger.a(2, EntryType.UI_INPUT_END, 372597767, a);
        }
    }

    public static void m22114a(Object obj, Context context) {
        ((FacecastReconnectingPlugin) obj).f18468c = GatekeeperStoreImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public FacecastReconnectingPlugin(Context context) {
        this(context, null);
    }

    private FacecastReconnectingPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastReconnectingPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904227);
        Class cls = FacecastReconnectingPlugin.class;
        m22114a(this, getContext());
        this.f18469d = (FbButton) a(2131561706);
        this.f18469d.setOnClickListener(new C15841(this));
        this.f18470e = (ProgressBar) a(2131560884);
        if (!this.f18468c.a(VideoAbTestGatekeepers.f, false)) {
            this.f18470e.setVisibility(8);
        }
    }

    public final boolean mo1409a() {
        this.f18166b.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_ABOUT_TO_FINISH);
        return true;
    }
}
