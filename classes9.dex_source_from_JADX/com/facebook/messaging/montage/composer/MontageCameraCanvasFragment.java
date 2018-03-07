package com.facebook.messaging.montage.composer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.quickcam.QuickCamController;
import com.facebook.messaging.quickcam.QuickCamControllerProvider;
import com.facebook.runtimepermissions.ActivitylessRuntimePermissionsManagerProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_using_google_api */
public class MontageCameraCanvasFragment extends AbstractMontageCanvasFragment implements MontageComposerCanvas {
    @Inject
    public ActivitylessRuntimePermissionsManagerProvider f12438a;
    @Inject
    public QuickCamControllerProvider f12439b;
    public MontageComposerController f12440c;
    private MontageCameraView f12441d;
    private QuickCamController f12442e;

    /* compiled from: is_using_google_api */
    public class C13761 {
        public final /* synthetic */ MontageCameraCanvasFragment f12437a;

        C13761(MontageCameraCanvasFragment montageCameraCanvasFragment) {
            this.f12437a = montageCameraCanvasFragment;
        }
    }

    public static void m12919a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MontageCameraCanvasFragment montageCameraCanvasFragment = (MontageCameraCanvasFragment) obj;
        ActivitylessRuntimePermissionsManagerProvider activitylessRuntimePermissionsManagerProvider = (ActivitylessRuntimePermissionsManagerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ActivitylessRuntimePermissionsManagerProvider.class);
        QuickCamControllerProvider quickCamControllerProvider = (QuickCamControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(QuickCamControllerProvider.class);
        montageCameraCanvasFragment.f12438a = activitylessRuntimePermissionsManagerProvider;
        montageCameraCanvasFragment.f12439b = quickCamControllerProvider;
    }

    public final void m12923c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = MontageCameraCanvasFragment.class;
        m12919a((Object) this, getContext());
    }

    public final View m12920a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1147124127);
        this.f12441d = new MontageCameraView(getContext());
        this.f12441d.setLayoutParams(new LayoutParams(-1, -1));
        MontageCameraView montageCameraView = this.f12441d;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1867371174, a);
        return montageCameraView;
    }

    public final void mo476a(View view, @Nullable Bundle bundle) {
        super.mo476a(view, bundle);
        this.f12442e = this.f12439b.m16528a(this.f12441d, this.f12438a.m19957a(this));
        this.f12442e.f16467I = new C13761(this);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1849154211);
        super.mi_();
        this.f12442e.m16526b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1851730143, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 954645477);
        this.f12442e.m16527c();
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -120100322, a);
    }

    public final boolean lV_() {
        return true;
    }

    protected final void mo475a(View view, int i, int i2, int i3, int i4) {
        View view2 = this.f12441d.f12446b;
        view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getPaddingRight(), i4);
    }
}
