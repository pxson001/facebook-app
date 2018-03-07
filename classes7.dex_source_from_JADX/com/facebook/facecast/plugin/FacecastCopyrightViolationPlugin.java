package com.facebook.facecast.plugin;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.facecast.FacecastCopyrightMonitor.CopyrightViolationInfo;
import com.facebook.facecast.FacecastStateManager.FacecastBroadcastState;
import com.facebook.facecast.protocol.AnswerCopyrightViolationMethod.Params;
import com.facebook.facecast.protocol.FacecastNetworker;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.FbInjector;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: breadcrumbs */
public class FacecastCopyrightViolationPlugin extends FacecastDialogPlugin {
    @Inject
    public FacecastNetworker f18237c;
    private final Runnable f18238d;
    public String f18239e;

    /* compiled from: breadcrumbs */
    class C15371 implements Runnable {
        final /* synthetic */ FacecastCopyrightViolationPlugin f18232a;

        C15371(FacecastCopyrightViolationPlugin facecastCopyrightViolationPlugin) {
            this.f18232a = facecastCopyrightViolationPlugin;
        }

        public void run() {
            this.f18232a.mo1414g();
        }
    }

    public static void m21993a(Object obj, Context context) {
        ((FacecastCopyrightViolationPlugin) obj).f18237c = FacecastNetworker.m22307b(FbInjector.get(context));
    }

    public FacecastCopyrightViolationPlugin(Context context) {
        this(context, null);
    }

    private FacecastCopyrightViolationPlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastCopyrightViolationPlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = FacecastCopyrightViolationPlugin.class;
        m21993a(this, getContext());
        this.f18238d = new C15371(this);
    }

    public void setViolationText(CopyrightViolationInfo copyrightViolationInfo) {
        this.f18233c.setText(copyrightViolationInfo.f17989a);
        this.f18234d.setText(copyrightViolationInfo.f17990b);
        this.f18235e.setText(copyrightViolationInfo.f17991c);
        this.f18236f.setText(copyrightViolationInfo.f17992d);
    }

    protected final void hE_() {
        super.hE_();
        Preconditions.checkNotNull(this.f18239e);
        this.f18165a.postDelayed(this.f18238d, 10000);
    }

    public final void mo1413d() {
        this.f18165a.removeCallbacks(this.f18238d);
        this.f18165a.post(this.f18238d);
    }

    protected final void mo1414g() {
        m21994a(false);
        this.f18166b.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_SHOW_END_SCREEN);
    }

    protected final void mo1415h() {
        m21994a(true);
        this.f18166b.m21883b(FacecastBroadcastState.FACECAST_BROADCAST_STATE_RECORDING);
    }

    private void m21994a(boolean z) {
        this.f18165a.removeCallbacks(this.f18238d);
        FacecastNetworker facecastNetworker = this.f18237c;
        String str = this.f18239e;
        Bundle bundle = new Bundle();
        bundle.putParcelable("answer_copyright_violation_key", new Params(str, z));
        BlueServiceOperationFactoryDetour.a(facecastNetworker.f18762a, "answer_copyright_violation_type", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(FacecastNetworker.class), 1887694989).a();
    }
}
