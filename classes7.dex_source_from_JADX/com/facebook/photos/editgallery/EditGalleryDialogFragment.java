package com.facebook.photos.editgallery;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.editgallery.CropMode;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration.Builder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.RotatingFrameLayout;
import com.facebook.photos.creativeediting.abtest.ExperimentsForCreativeEditingAbtestModule;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.Filter;
import com.facebook.photos.creativeediting.renderers.CreativeEditingPhotoOverlayView;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.facebook.photos.editgallery.EditGalleryFragmentController.State;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.EditGalleryCallback;
import com.facebook.photos.editgallery.animations.AnimationParam;
import com.facebook.photos.editgallery.common.FeatureSelectorController;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.tempprofilepic.EditGalleryExpirationController;
import com.facebook.timeline.tempprofilepic.EditGalleryExpirationControllerProvider;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.widget.LazyView;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.io.File;
import java.util.List;
import javax.inject.Inject;

@TargetApi(11)
/* compiled from: left_value */
public class EditGalleryDialogFragment extends FbDialogFragment {
    public EditableOverlayContainerView aA;
    private FrameLayout aB;
    private LazyView<ProgressBar> aC;
    private RotatingFrameLayout aD;
    private ViewStub aE;
    private ViewStub aF;
    private View aG;
    public Fb4aTitleBar aH;
    private View aI;
    private ExpirationState aJ;
    private ViewStub aK;
    private Optional<CreativeEditingPhotoOverlayView> aL = Absent.INSTANCE;
    @Nullable
    private List<RectF> aM;
    @Nullable
    private AnimationParam aN;
    @Nullable
    public EditGalleryLaunchConfiguration aO;
    public CreativeEditingSwipeableLayout aP;
    @Inject
    public EditGalleryFragmentControllerProvider am;
    @Inject
    public EditGalleryExpirationControllerProvider an;
    @Inject
    public QeAccessor ao;
    private Uri ap;
    private int aq;
    private int ar;
    public EditGalleryCallback as;
    private boolean at;
    private CreativeEditingData au;
    public FbDraweeView av;
    private EditGalleryFragmentController aw;
    private EditGalleryExpirationController ax;
    private int ay = -1;
    private LinearLayout az;

    public static void m12134a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EditGalleryDialogFragment editGalleryDialogFragment = (EditGalleryDialogFragment) obj;
        EditGalleryFragmentControllerProvider editGalleryFragmentControllerProvider = (EditGalleryFragmentControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EditGalleryFragmentControllerProvider.class);
        EditGalleryExpirationControllerProvider editGalleryExpirationControllerProvider = (EditGalleryExpirationControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EditGalleryExpirationControllerProvider.class);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        editGalleryDialogFragment.am = editGalleryFragmentControllerProvider;
        editGalleryDialogFragment.an = editGalleryExpirationControllerProvider;
        editGalleryDialogFragment.ao = qeAccessor;
    }

    public final void m12138a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -626117660);
        super.a(bundle);
        Class cls = EditGalleryDialogFragment.class;
        m12134a(this, getContext());
        a(2, 2131626061);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 982354954, a);
    }

    public final View m12137a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 572598127);
        View inflate = layoutInflater.inflate(2130903937, viewGroup, false);
        this.aD = (RotatingFrameLayout) FindViewUtil.b(inflate, 2131561111);
        this.aP = (CreativeEditingSwipeableLayout) FindViewUtil.b(inflate, 2131561116);
        ((LayoutParams) this.aP.getLayoutParams()).bottomMargin = aH();
        this.av = (FbDraweeView) FindViewUtil.b(inflate, 2131561113);
        this.az = (LinearLayout) FindViewUtil.b(inflate, 2131561102);
        this.aA = (EditableOverlayContainerView) FindViewUtil.b(inflate, 2131561117);
        this.aA.m11588b();
        this.aA.setVisibility(0);
        this.aB = (FrameLayout) FindViewUtil.b(inflate, 2131561115);
        this.aC = new LazyView((ViewStub) FindViewUtil.b(this.aB, 2131561101));
        this.aE = (ViewStub) FindViewUtil.b(inflate, 2131561119);
        this.aF = (ViewStub) FindViewUtil.b(inflate, 2131561118);
        this.aG = FindViewUtil.b(inflate, 2131561112);
        this.aH = (Fb4aTitleBar) this.aG.findViewById(2131558563);
        this.aK = (ViewStub) FindViewUtil.b(inflate, 2131561114);
        this.aI = inflate;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1741525796, a);
        return inflate;
    }

    public final void m12141d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 706753247);
        super.d(bundle);
        Preconditions.checkState(this.as != null);
        LogUtils.f(1501534479, a);
    }

    public final void m12139a(EditFeature editFeature) {
        if (this.ax != null) {
            EditGalleryExpirationController editGalleryExpirationController = this.ax;
            if (editFeature == EditFeature.CROP) {
                editGalleryExpirationController.f14906c.findViewById(2131558576).post(editGalleryExpirationController.f14905b);
            } else {
                editGalleryExpirationController.f14908e.post(editGalleryExpirationController.f14904a);
            }
        }
    }

    public final ExpirationState aq() {
        if (this.ax == null) {
            return ExpirationState.a;
        }
        boolean z;
        EditGalleryExpirationController editGalleryExpirationController = this.ax;
        ExpirationState expirationState = this.aJ;
        if (expirationState == null || !expirationState.c) {
            z = false;
        } else {
            z = true;
        }
        return new ExpirationState(z, z ? editGalleryExpirationController.f14910g.m18773a() : 0);
    }

    public final void m12135G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1282027691);
        super.G();
        for (FeatureSelectorController featureSelectorController : this.aw.f10333n) {
            featureSelectorController.f10488b.mo568f();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 24673771, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1726504590);
        if (an() != null) {
            this.ay = an().getRequestedOrientation();
            an().setRequestedOrientation(1);
        }
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 997309637, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1105761244);
        if (an() != null) {
            an().setRequestedOrientation(this.ay);
        }
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 37977149, a);
    }

    public final void m12136H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2015532585);
        EditGalleryFragmentController editGalleryFragmentController = this.aw;
        editGalleryFragmentController.f10305H.mo569g();
        ((TasksManager) editGalleryFragmentController.f10309L.get()).c(editGalleryFragmentController.f10308K);
        editGalleryFragmentController.f10331l.ay();
        if (editGalleryFragmentController.f10306I != null) {
            editGalleryFragmentController.f10306I.m11815b(editGalleryFragmentController.f10322c);
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1795962287, a);
    }

    public final void m12143h(@Nullable Bundle bundle) {
        State state;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -451894034);
        super.h(bundle);
        State state2 = new State(this.au);
        if (this.aO != null) {
            String b;
            aG();
            EditFeature editFeature = this.aO.c;
            CropMode cropMode = this.aO.e;
            List e = this.aO.e();
            boolean z = this.aO.f;
            String str = this.aO.g;
            if (this.aO.i == null) {
                b = b(2131234500);
            } else {
                b = this.aO.i;
            }
            state2.m12174a(editFeature, cropMode, e, z, str, b, this.aO.h, this.aO.l, this.aO.m, this.aO.n);
            this.aJ = this.aO.k;
        }
        if (this.aM != null) {
            state2.f10291l = this.aM;
        }
        if (bundle != null) {
            State state3;
            this.aq = bundle.getInt("edit_gallery_bitmap_width");
            this.ar = bundle.getInt("edit_gallery_bitmap_height");
            this.ap = (Uri) bundle.getParcelable("edit_gallery_photo_uri");
            if (bundle.containsKey("edit_gallery_custom_params")) {
                this.aJ = (ExpirationState) bundle.getParcelable("edit_gallery_custom_params");
            }
            if (bundle.containsKey("edit_gallery_controller_state")) {
                state3 = (State) bundle.getParcelable("edit_gallery_controller_state");
            } else {
                state3 = state2;
            }
            this.aO = (EditGalleryLaunchConfiguration) bundle.getParcelable("edit_gallery_launch_configuration");
            this.at = true;
            state = state3;
        } else {
            state = state2;
        }
        if (this.aJ != null && this.aJ.c) {
            this.ax = this.an.m18769a(this.aD, this.aB, this.aP, this.aJ.b());
            this.ax.m18768a((FbRelativeLayout) this.aI);
        }
        if (this.aP != null) {
            ((LayoutParams) this.aP.getLayoutParams()).bottomMargin = aH();
        }
        m12133a(state);
        LogUtils.f(-1540668392, a);
    }

    private void aG() {
        if (!this.aO.e().contains(EditFeature.FILTER)) {
            Builder builder = new Builder(this.aO);
            Object obj = 1;
            if (this.aO.l.size() <= 1) {
                obj = null;
            }
            this.aO = builder.b(obj == null ? EditFeature.FILTER : null).a();
        }
    }

    public final void m12142e(Bundle bundle) {
        super.e(bundle);
        bundle.putInt("edit_gallery_bitmap_width", this.aq);
        bundle.putInt("edit_gallery_bitmap_height", this.ar);
        bundle.putParcelable("edit_gallery_photo_uri", this.ap);
        bundle.putParcelable("edit_gallery_custom_params", this.aJ);
        if (this.aw != null) {
            bundle.putParcelable("edit_gallery_controller_state", this.aw.m12198e());
        }
        bundle.putParcelable("edit_gallery_launch_configuration", this.aO);
    }

    public final void m12140a(EditGalleryLaunchConfiguration editGalleryLaunchConfiguration, Uri uri, int i, int i2, EditGalleryCallback editGalleryCallback, @Nullable List<RectF> list, @Nullable AnimationParam animationParam) {
        CreativeEditingData a;
        this.as = editGalleryCallback;
        if (!uri.isAbsolute()) {
            uri = Uri.fromFile(new File(uri.getPath()));
        }
        this.ap = uri;
        this.aq = i;
        this.ar = i2;
        if (editGalleryLaunchConfiguration.j == null) {
            a = new CreativeEditingData.Builder().a();
        } else {
            a = editGalleryLaunchConfiguration.j;
        }
        this.au = a;
        this.aO = editGalleryLaunchConfiguration;
        this.aM = list;
        this.at = true;
        this.aN = animationParam;
    }

    private void m12133a(State state) {
        OnLayoutChangeListener onLayoutChangeListener;
        Preconditions.checkState(this.at);
        this.aw = this.am.m12200a(this, this.as, this.ap, Integer.valueOf(this.aq), Integer.valueOf(this.ar), state, this.aN);
        EditGalleryFragmentController editGalleryFragmentController = this.aw;
        if (Filter.PassThrough.toString().equals(editGalleryFragmentController.f10300C.f10290k.a())) {
            onLayoutChangeListener = editGalleryFragmentController.f10328i;
        } else {
            onLayoutChangeListener = null;
        }
        OnLayoutChangeListener onLayoutChangeListener2 = onLayoutChangeListener;
        if (onLayoutChangeListener2 != null) {
            this.aI.addOnLayoutChangeListener(onLayoutChangeListener2);
        }
        this.aw.m12199f();
        this.aw.m12197a(state.f10293n);
        this.f.setOnKeyListener(this.aw.f10326g);
    }

    public final CreativeEditingSwipeableLayout ar() {
        return this.aP;
    }

    public final FbDraweeView as() {
        return this.av;
    }

    public final ViewGroup at() {
        return this.az;
    }

    public final FrameLayout au() {
        return this.aB;
    }

    public final EditableOverlayContainerView av() {
        return this.aA;
    }

    public final void ax() {
        ((ProgressBar) this.aC.a()).setVisibility(0);
        ((ProgressBar) this.aC.a()).bringToFront();
    }

    public final void ay() {
        if (this.aC.b()) {
            ((ProgressBar) this.aC.a()).setVisibility(8);
        }
    }

    public final RotatingFrameLayout aA() {
        return this.aD;
    }

    public final ViewStub aB() {
        return this.aE;
    }

    public final ViewStub aC() {
        return this.aF;
    }

    private int aH() {
        int dimensionPixelSize = jW_().getDimensionPixelSize(2131429550);
        if (!(this.aO == null || this.aO.e().contains(EditFeature.FILTER) || !this.ao.a(ExperimentsForCreativeEditingAbtestModule.b, false))) {
            dimensionPixelSize = Math.max(dimensionPixelSize, jW_().getDimensionPixelSize(2131429556));
        }
        return dimensionPixelSize + (jW_().getDimensionPixelSize(2131429548) + jW_().getDimensionPixelSize(2131429549));
    }

    public final View aD() {
        return this.aG;
    }

    public final Fb4aTitleBar aE() {
        return this.aH;
    }

    public final CreativeEditingPhotoOverlayView aF() {
        if (!this.aL.isPresent()) {
            this.aL = Optional.of((CreativeEditingPhotoOverlayView) this.aK.inflate());
        }
        return (CreativeEditingPhotoOverlayView) this.aL.get();
    }
}
