package com.facebook.photos.editgallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.CropMode;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryZoomCropParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLogger.EventListener;
import com.facebook.photos.creativeediting.interfaces.PhotoOverlayItem.OverlayItemType;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.CreativeEditingData.Builder;
import com.facebook.photos.creativeediting.model.DraweeSwipeableItem;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.swipeable.composer.BaseGeneratorEventSubscriber;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableControllerProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;
import com.facebook.photos.creativeediting.swipeable.composer.SwipeableDraweeControllerGenerator$EventSubscriber;
import com.facebook.photos.creativeediting.swipeable.composer.SwipeableDraweeControllerGeneratorImpl;
import com.facebook.photos.creativeediting.ui.MovableContainerView;
import com.facebook.photos.creativeediting.utilities.CreativeEditingImageHelper;
import com.facebook.photos.creativeediting.utilities.MediaRotationHelper;
import com.facebook.photos.editgallery.EditFeatureController.UriRequestType;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.EditGalleryCallback;
import com.facebook.photos.editgallery.EditGalleryFragmentManager.UsageParams;
import com.facebook.photos.editgallery.animations.AnimationParam;
import com.facebook.photos.editgallery.animations.EditGalleryAnimation;
import com.facebook.photos.editgallery.common.FeatureSelectorController;
import com.facebook.photos.editgallery.common.FeatureSelectorController.FeatureSelectorControllerCallback;
import com.facebook.photos.editgallery.common.MediaEditFeatureController;
import com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Absent;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@TargetApi(12)
/* compiled from: left_title */
public class EditGalleryFragmentController {
    public static final CallerContext f10297a = CallerContext.a(EditGalleryFragmentController.class, "edit_gallery");
    private final CreativeEditingSwipeableControllerProvider f10298A;
    private final Provider<SwipeableDraweeControllerGeneratorImpl> f10299B;
    public State f10300C;
    public Optional<EditGalleryAnimation> f10301D = Absent.withType();
    public CreativeEditingSwipeableController f10302E;
    public FeatureSelectorController f10303F;
    public FeatureSelectorController f10304G;
    public EditFeatureController f10305H;
    public SwipeableDraweeControllerGeneratorImpl f10306I;
    public Optional<CreativeEditingLogger> f10307J = Absent.withType();
    public String f10308K;
    public Lazy<TasksManager> f10309L;
    public CreativeEditingImageHelper f10310M;
    public boolean f10311N;
    public boolean f10312O;
    public int f10313P;
    public int f10314Q;
    public boolean f10315R;
    public boolean f10316S;
    public boolean f10317T;
    public int f10318U;
    public Rect f10319V;
    public boolean f10320W;
    private final EventListener f10321b = new C08651(this);
    public final SwipeableDraweeControllerGenerator$EventSubscriber f10322c = new C08662(this);
    private final C08673 f10323d = new C08673(this);
    private final FeatureSelectorControllerCallback f10324e = new C08684(this);
    private final C08695 f10325f = new C08695(this);
    public final OnKeyListener f10326g = new C08706(this);
    public final ControllerListener<ImageInfo> f10327h = new C08717(this);
    public final OnLayoutChangeListener f10328i = new C08728(this);
    private final MovableItemListener f10329j = new C08739(this);
    public final Uri f10330k;
    public final EditGalleryDialogFragment f10331l;
    public final EditGalleryCallback f10332m;
    public final List<FeatureSelectorController> f10333n = new ArrayList();
    public final List<MovableItemListener> f10334o = new ArrayList();
    private final DoodlesEditControllerProvider f10335p;
    private final TextEditControllerProvider f10336q;
    private final StickerEditControllerProvider f10337r;
    private final CropEditControllerProvider f10338s;
    private final FilterEditControllerProvider f10339t;
    private final ZoomCropEditControllerProvider f10340u;
    public final FbDraweeControllerBuilder f10341v;
    public final Lazy<MediaRotationHelper> f10342w;
    public final PostprocessorFactory f10343x;
    private final ScreenUtil f10344y;
    @Nullable
    private final AnimationParam f10345z;

    /* compiled from: left_title */
    class C08651 implements EventListener {
        final /* synthetic */ EditGalleryFragmentController f10270a;

        C08651(EditGalleryFragmentController editGalleryFragmentController) {
            this.f10270a = editGalleryFragmentController;
        }

        public final void mo490a(String str) {
        }

        public final void mo491a(String str, int i) {
        }

        public final void mo493b(String str, int i) {
        }

        public final void mo494c(String str, int i) {
        }

        public final void mo496e(String str, int i) {
        }

        public final void mo492a(String str, SwipeableParams swipeableParams, int i) {
            EditGalleryFragmentController editGalleryFragmentController = this.f10270a;
            editGalleryFragmentController.f10318U++;
            if (this.f10270a.f10307J.isPresent()) {
                ((CreativeEditingLogger) this.f10270a.f10307J.get()).m11478a(swipeableParams);
            }
        }

        public final void mo495d(String str, int i) {
        }
    }

    /* compiled from: left_title */
    /* synthetic */ class AnonymousClass20 {
        static final /* synthetic */ int[] f10271a = new int[CropMode.values().length];

        static {
            try {
                f10271a[CropMode.DEFAULT_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10271a[CropMode.ZOOM_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: left_title */
    class C08662 extends BaseGeneratorEventSubscriber {
        final /* synthetic */ EditGalleryFragmentController f10272a;

        C08662(EditGalleryFragmentController editGalleryFragmentController) {
            this.f10272a = editGalleryFragmentController;
        }

        private void m12154a(boolean z) {
            if (UriRequestType.SHOW_ORIGINAL_URI.equals(this.f10272a.f10305H.mo573k())) {
                this.f10272a.f10319V = EditGalleryFragmentController.m12193w(this.f10272a);
                return;
            }
            EditGalleryFragmentController editGalleryFragmentController = this.f10272a;
            Rect w = EditGalleryFragmentController.m12193w(editGalleryFragmentController);
            if (!Objects.equal(w, editGalleryFragmentController.f10319V) || z) {
                editGalleryFragmentController.f10319V = w;
                EditGalleryFragmentController.m12178a(editGalleryFragmentController, w);
            }
            EditGalleryFragmentController.m12194x(editGalleryFragmentController);
        }

        public final void mo516b(DraweeSwipeableItem draweeSwipeableItem, DraweeSwipeableItem draweeSwipeableItem2, DraweeSwipeableItem draweeSwipeableItem3) {
            super.mo516b(draweeSwipeableItem, draweeSwipeableItem2, draweeSwipeableItem3);
            if (!this.f10272a.f10320W) {
                m12154a(true);
            }
            this.f10272a.f10320W = true;
        }

        public final void mo514a(DraweeSwipeableItem draweeSwipeableItem) {
            super.mo514a(draweeSwipeableItem);
            this.f10272a.f10320W = false;
            m12154a(false);
        }
    }

    /* compiled from: left_title */
    public class C08673 {
        public final /* synthetic */ EditGalleryFragmentController f10273a;

        C08673(EditGalleryFragmentController editGalleryFragmentController) {
            this.f10273a = editGalleryFragmentController;
        }

        public final CreativeEditingSwipeableController m12157a() {
            return this.f10273a.f10302E;
        }
    }

    /* compiled from: left_title */
    class C08684 implements FeatureSelectorControllerCallback {
        final /* synthetic */ EditGalleryFragmentController f10274a;

        C08684(EditGalleryFragmentController editGalleryFragmentController) {
            this.f10274a = editGalleryFragmentController;
        }

        public final void mo577a(FeatureSelectorController featureSelectorController) {
            for (FeatureSelectorController featureSelectorController2 : this.f10274a.f10333n) {
                if (featureSelectorController2 != featureSelectorController) {
                    featureSelectorController2.m12367a(false);
                }
            }
            EditGalleryFragmentController.m12179a(this.f10274a, featureSelectorController);
        }

        public final boolean mo578a() {
            return !this.f10274a.f10317T;
        }
    }

    /* compiled from: left_title */
    public class C08695 {
        final /* synthetic */ EditGalleryFragmentController f10275a;

        C08695(EditGalleryFragmentController editGalleryFragmentController) {
            this.f10275a = editGalleryFragmentController;
        }

        public final void m12162a() {
            this.f10275a.f10331l.ax();
            this.f10275a.f10311N = true;
        }

        public final void m12163a(CreativeEditingData creativeEditingData) {
            this.f10275a.f10300C.f10290k = creativeEditingData;
            this.f10275a.f10331l.ay();
            this.f10275a.f10311N = false;
            if (!this.f10275a.f10312O) {
                EditGalleryFragmentController.m12184m(this.f10275a);
                EditGalleryFragmentController.m12186p(this.f10275a);
                this.f10275a.f10305H.mo561a(this.f10275a.f10300C);
                this.f10275a.f10331l.m12139a(this.f10275a.f10303F.m12366a());
            } else if (this.f10275a.f10300C.f10288i && !this.f10275a.f10300C.f10290k.h().isEmpty() && this.f10275a.f10300C.f10285f) {
                EditGalleryFragmentController.m12189s(this.f10275a);
            } else {
                if (this.f10275a.f10332m != null) {
                    this.f10275a.f10332m.mo221a(this.f10275a.f10300C.f10290k);
                }
                EditGalleryFragmentController.m12182b(this.f10275a, true);
            }
        }
    }

    /* compiled from: left_title */
    class C08706 implements OnKeyListener {
        final /* synthetic */ EditGalleryFragmentController f10276a;

        C08706(EditGalleryFragmentController editGalleryFragmentController) {
            this.f10276a = editGalleryFragmentController;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            if (this.f10276a.f10311N) {
                return true;
            }
            boolean d;
            if (this.f10276a.f10303F != null) {
                d = this.f10276a.f10305H.mo566d();
            } else {
                d = false;
            }
            if (d) {
                return d;
            }
            if (this.f10276a.f10300C.f10294o && (this.f10276a.f10300C.f10288i || this.f10276a.f10305H.mo574l())) {
                EditGalleryFragmentController.m12192v(this.f10276a);
                return true;
            }
            if (this.f10276a.f10332m != null) {
                this.f10276a.f10305H.mo564b();
                this.f10276a.f10332m.mo222a(this.f10276a.f10300C.f10280a, this.f10276a.f10331l.aq(), false);
            }
            EditGalleryFragmentController.m12190t(this.f10276a);
            return true;
        }
    }

    /* compiled from: left_title */
    class C08717 extends BaseControllerListener {
        final /* synthetic */ EditGalleryFragmentController f10277a;

        C08717(EditGalleryFragmentController editGalleryFragmentController) {
            this.f10277a = editGalleryFragmentController;
        }

        public final void m12164a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            super.a(str, (CloseableImage) obj, animatable);
            Rect b = EditGalleryFragmentController.m12180b(this.f10277a.f10331l.av);
            if (b.width() > 0 && b.height() > 0) {
                EditGalleryFragmentController.m12178a(this.f10277a, b);
                EditGalleryFragmentController.m12194x(this.f10277a);
            }
        }

        public final void m12165b(String str, @Nullable Object obj) {
            super.b(str, (CloseableImage) obj);
            Rect b = EditGalleryFragmentController.m12180b(this.f10277a.f10331l.av);
            if (b.width() > 0 && b.height() > 0) {
                EditGalleryFragmentController.m12178a(this.f10277a, b);
                EditGalleryFragmentController.m12194x(this.f10277a);
            }
        }
    }

    /* compiled from: left_title */
    class C08728 implements OnLayoutChangeListener {
        final /* synthetic */ EditGalleryFragmentController f10278a;

        C08728(EditGalleryFragmentController editGalleryFragmentController) {
            this.f10278a = editGalleryFragmentController;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            UriRequestType k = this.f10278a.f10305H.mo573k();
            if (!this.f10278a.f10315R && k == UriRequestType.SHOW_ORIGINAL_URI) {
                Rect r = EditGalleryFragmentController.m12188r(this.f10278a);
                if (r != null) {
                    this.f10278a.f10315R = true;
                    EditGalleryFragmentController.m12178a(this.f10278a, r);
                    EditGalleryFragmentController.m12194x(this.f10278a);
                }
            }
        }
    }

    /* compiled from: left_title */
    class C08739 implements MovableItemListener {
        final /* synthetic */ EditGalleryFragmentController f10279a;

        C08739(EditGalleryFragmentController editGalleryFragmentController) {
            this.f10279a = editGalleryFragmentController;
        }

        public final void mo579a(@Nullable OverlayItemType overlayItemType) {
            for (MovableItemListener a : this.f10279a.f10334o) {
                a.mo579a(overlayItemType);
            }
        }

        public final void mo580a(String str, @Nullable OverlayItemType overlayItemType) {
            for (MovableItemListener a : this.f10279a.f10334o) {
                a.mo580a(str, overlayItemType);
            }
        }

        public final void mo581b(String str, @Nullable OverlayItemType overlayItemType) {
            for (MovableItemListener b : this.f10279a.f10334o) {
                b.mo581b(str, overlayItemType);
            }
        }

        public final void mo582c(String str, @Nullable OverlayItemType overlayItemType) {
            for (MovableItemListener c : this.f10279a.f10334o) {
                c.mo582c(str, overlayItemType);
            }
        }
    }

    /* compiled from: left_title */
    public class State implements Parcelable {
        public static final Creator<State> CREATOR = new C08741();
        public UsageParams f10280a = new UsageParams();
        @Nullable
        public String f10281b = null;
        public boolean f10282c = false;
        private final List<EditFeature> f10283d = new ArrayList();
        private CropMode f10284e;
        public boolean f10285f = false;
        public int f10286g;
        public EditFeature f10287h;
        public boolean f10288i = false;
        public boolean f10289j = false;
        public CreativeEditingData f10290k;
        public List<RectF> f10291l = new ArrayList();
        public EditGalleryZoomCropParams f10292m;
        public String f10293n = null;
        public boolean f10294o = true;
        public ImmutableList<SwipeableParams> f10295p;
        private boolean f10296q = true;

        /* compiled from: left_title */
        final class C08741 implements Creator<State> {
            C08741() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            public final Object[] newArray(int i) {
                return new State[i];
            }
        }

        public State(CreativeEditingData creativeEditingData) {
            this.f10290k = creativeEditingData;
        }

        public State(Parcel parcel) {
            this.f10287h = EditFeature.values()[parcel.readInt()];
            this.f10284e = CropMode.values()[parcel.readInt()];
            parcel.readList(this.f10283d, EditFeature.class.getClassLoader());
            this.f10288i = ParcelUtil.a(parcel);
            this.f10289j = ParcelUtil.a(parcel);
            this.f10286g = parcel.readInt();
            this.f10290k = (CreativeEditingData) parcel.readParcelable(CreativeEditingData.class.getClassLoader());
            this.f10280a = (UsageParams) parcel.readParcelable(UsageParams.class.getClassLoader());
            this.f10281b = parcel.readString();
            parcel.readList(this.f10291l, RectF.class.getClassLoader());
            this.f10285f = ParcelUtil.a(parcel);
            this.f10282c = true;
            this.f10293n = parcel.readString();
            this.f10294o = ParcelUtil.a(parcel);
            this.f10295p = ParcelUtil.a(parcel, SwipeableParams.CREATOR);
            this.f10292m = (EditGalleryZoomCropParams) parcel.readParcelable(EditGalleryZoomCropParams.class.getClassLoader());
            this.f10296q = ParcelUtil.a(parcel);
        }

        public final void m12174a(EditFeature editFeature, CropMode cropMode, List<EditFeature> list, boolean z, String str, String str2, boolean z2, ImmutableList<SwipeableParams> immutableList, EditGalleryZoomCropParams editGalleryZoomCropParams, boolean z3) {
            this.f10287h = editFeature;
            this.f10284e = cropMode;
            this.f10283d.addAll(list);
            this.f10285f = z;
            this.f10281b = str;
            this.f10293n = str2;
            this.f10294o = z2;
            this.f10295p = immutableList;
            this.f10292m = editGalleryZoomCropParams;
            this.f10296q = z3;
        }

        public final boolean m12175a() {
            return this.f10296q;
        }

        public final boolean m12176a(EditFeature editFeature) {
            return !this.f10283d.contains(editFeature);
        }

        public final CropMode m12177f() {
            return this.f10284e;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f10287h.ordinal());
            parcel.writeInt(this.f10284e.ordinal());
            parcel.writeList(this.f10283d);
            ParcelUtil.a(parcel, this.f10288i);
            ParcelUtil.a(parcel, this.f10289j);
            parcel.writeInt(this.f10286g);
            parcel.writeParcelable(this.f10290k, i);
            parcel.writeParcelable(this.f10280a, i);
            parcel.writeString(this.f10281b);
            parcel.writeList(this.f10291l);
            ParcelUtil.a(parcel, this.f10285f);
            parcel.writeString(this.f10293n);
            ParcelUtil.a(parcel, this.f10294o);
            parcel.writeTypedList(this.f10295p);
            parcel.writeParcelable(this.f10292m, i);
            ParcelUtil.a(parcel, this.f10296q);
        }
    }

    @Inject
    public EditGalleryFragmentController(@Assisted EditGalleryDialogFragment editGalleryDialogFragment, @Assisted EditGalleryCallback editGalleryCallback, @Assisted Uri uri, @Assisted Integer num, @Assisted Integer num2, @Assisted State state, @Nullable @Assisted AnimationParam animationParam, Provider<SwipeableDraweeControllerGeneratorImpl> provider, CreativeEditingSwipeableControllerProvider creativeEditingSwipeableControllerProvider, ScreenUtil screenUtil, Lazy<MediaRotationHelper> lazy, Lazy<TasksManager> lazy2, CreativeEditingImageHelper creativeEditingImageHelper, DoodlesEditControllerProvider doodlesEditControllerProvider, TextEditControllerProvider textEditControllerProvider, StickerEditControllerProvider stickerEditControllerProvider, CropEditControllerProvider cropEditControllerProvider, FilterEditControllerProvider filterEditControllerProvider, ZoomCropEditControllerProvider zoomCropEditControllerProvider, CreativeEditingLogger creativeEditingLogger, FbDraweeControllerBuilder fbDraweeControllerBuilder, PostprocessorFactoryProvider postprocessorFactoryProvider) {
        Preconditions.checkNotNull(editGalleryDialogFragment);
        Preconditions.checkNotNull(uri);
        Preconditions.checkNotNull(state);
        Preconditions.checkArgument(num.intValue() > 0);
        Preconditions.checkArgument(num2.intValue() > 0);
        this.f10331l = editGalleryDialogFragment;
        this.f10330k = uri;
        this.f10313P = num.intValue();
        this.f10314Q = num2.intValue();
        this.f10332m = editGalleryCallback;
        this.f10300C = state;
        this.f10345z = animationParam;
        this.f10344y = screenUtil;
        this.f10342w = lazy;
        this.f10335p = doodlesEditControllerProvider;
        this.f10336q = textEditControllerProvider;
        this.f10337r = stickerEditControllerProvider;
        this.f10309L = lazy2;
        this.f10310M = creativeEditingImageHelper;
        this.f10338s = cropEditControllerProvider;
        this.f10339t = filterEditControllerProvider;
        this.f10340u = zoomCropEditControllerProvider;
        this.f10341v = fbDraweeControllerBuilder;
        this.f10299B = provider;
        this.f10306I = (SwipeableDraweeControllerGeneratorImpl) this.f10299B.get();
        this.f10298A = creativeEditingSwipeableControllerProvider;
        this.f10302E = this.f10298A.a(this.f10321b, this.f10306I, m12195y(), this.f10330k.toString());
        this.f10343x = postprocessorFactoryProvider.m12268a(this.f10300C.f10291l);
        this.f10307J = Optional.of(creativeEditingLogger);
        ((CreativeEditingLogger) this.f10307J.get()).m11479a(this.f10300C.f10281b);
        m12183l();
    }

    private void m12183l() {
        View at = this.f10331l.at();
        View inflate = this.f10331l.aB().inflate();
        inflate.setVisibility(4);
        if (this.f10300C.m12176a(EditFeature.FILTER)) {
            MediaEditFeatureController a = this.f10339t.m12258a(this.f10331l.aC(), this.f10331l.ar(), this.f10331l.av(), this.f10323d, this.f10307J, this.f10330k, inflate);
            View findViewById = at.findViewById(2131561103);
            this.f10333n.add(new FeatureSelectorController(this.f10331l.getContext(), findViewById, this.f10324e, a, this.f10331l.aE(), (ImageButton) findViewById.findViewById(2131561104), (FbTextView) findViewById.findViewById(2131561105)));
        }
        if (this.f10300C.m12176a(EditFeature.CROP)) {
            Preconditions.checkNotNull(this.f10300C.m12177f());
            View findViewById2 = at.findViewById(2131561106);
            switch (AnonymousClass20.f10271a[this.f10300C.m12177f().ordinal()]) {
                case 1:
                    findViewById = findViewById2;
                    this.f10333n.add(new FeatureSelectorController(this.f10331l.getContext(), findViewById, this.f10324e, this.f10338s.m12086a(this.f10330k, this.f10331l.aA(), this.f10331l.av(), this.f10331l.as(), inflate, this.f10325f, this.f10300C.f10281b, this, this.f10307J, this.f10331l.aF()), this.f10331l.aE(), (ImageButton) findViewById2.findViewById(2131561104), (FbTextView) findViewById2.findViewById(2131561105)));
                    break;
                case 2:
                    Preconditions.checkNotNull(this.f10331l.aE());
                    if (this.f10300C.m12175a()) {
                        ((ViewStub) this.f10331l.aD().findViewById(2131561128)).inflate();
                    }
                    a = this.f10340u.m12361a(this.f10330k, this.f10331l.aA(), this.f10325f, this.f10300C.f10281b);
                    findViewById = ((ViewStub) at.findViewById(2131561107)).inflate();
                    this.f10333n.add(new FeatureSelectorController(this.f10331l.getContext(), findViewById, this.f10324e, a, this.f10331l.aE(), (ImageButton) findViewById.findViewById(2131561104), (FbTextView) findViewById.findViewById(2131561105)));
                    break;
            }
        }
        if (this.f10300C.m12176a(EditFeature.STICKER)) {
            a = this.f10337r.m12298a(this.f10331l.au(), this.f10331l.av(), this.f10300C.f10281b, this.f10329j, this.f10307J);
            findViewById = at.findViewById(2131561108);
            this.f10333n.add(new FeatureSelectorController(this.f10331l.getContext(), findViewById, this.f10324e, a, this.f10331l.aE(), (ImageButton) findViewById.findViewById(2131561104), (FbTextView) findViewById.findViewById(2131561105)));
        }
        if (this.f10300C.m12176a(EditFeature.TEXT)) {
            a = this.f10336q.m12333a(this.f10330k, this.f10331l.aE(), this.f10300C.f10293n, this.f10331l.au(), this.f10331l.av(), this.f10300C.f10281b, this.f10343x, this, this.f10329j, this.f10307J);
            findViewById = at.findViewById(2131561109);
            this.f10333n.add(new FeatureSelectorController(this.f10331l.getContext(), findViewById, this.f10324e, a, this.f10331l.aE(), (ImageButton) findViewById.findViewById(2131561104), (FbTextView) findViewById.findViewById(2131561105)));
        }
        if (this.f10300C.m12176a(EditFeature.DOODLE)) {
            MediaEditFeatureController a2 = this.f10335p.m12107a(this.f10331l.au(), inflate, this.f10331l.av(), this.f10300C.f10281b, this.f10307J, this);
            View findViewById3 = at.findViewById(2131561110);
            this.f10333n.add(new FeatureSelectorController(this.f10331l.getContext(), findViewById3, this.f10324e, a2, this.f10331l.aE(), (ImageButton) findViewById3.findViewById(2131561104), (FbTextView) findViewById3.findViewById(2131561105)));
        }
        for (FeatureSelectorController featureSelectorController : this.f10333n) {
            if (featureSelectorController.m12368b() instanceof MovableItemListener) {
                this.f10334o.add((MovableItemListener) featureSelectorController.m12368b());
            }
            if (this.f10303F == null && featureSelectorController.m12366a() == this.f10300C.f10287h) {
                featureSelectorController.m12367a(true);
                m12179a(this, featureSelectorController);
            }
        }
        if (this.f10333n.size() < 2) {
            at.setVisibility(4);
        }
    }

    public static void m12184m(EditGalleryFragmentController editGalleryFragmentController) {
        if (editGalleryFragmentController.f10302E.m11789k()) {
            editGalleryFragmentController.f10302E.m11788j();
        }
        editGalleryFragmentController.f10306I = (SwipeableDraweeControllerGeneratorImpl) editGalleryFragmentController.f10299B.get();
        editGalleryFragmentController.f10302E = editGalleryFragmentController.f10298A.a(editGalleryFragmentController.f10321b, editGalleryFragmentController.f10306I, editGalleryFragmentController.m12195y(), editGalleryFragmentController.f10330k.toString());
    }

    private void m12185o() {
        int i = this.f10313P;
        int i2 = this.f10314Q;
        if (this.f10300C.f10290k.c() != null) {
            i = (int) (((float) i) * this.f10300C.f10290k.c().width());
            i2 = (int) (((float) i2) * this.f10300C.f10290k.c().height());
        }
        this.f10302E.m11774a(this.f10331l.aP, i, i2, true);
        this.f10302E.m11777a(this.f10300C.f10295p, this.f10300C.f10290k.a());
        this.f10306I.m11813a(this.f10322c);
        if (this.f10300C.f10291l != null) {
            this.f10302E.m11779a((RectF[]) this.f10300C.f10291l.toArray(new RectF[0]));
        }
        this.f10302E.m11782b(true);
    }

    public static void m12186p(EditGalleryFragmentController editGalleryFragmentController) {
        UriRequestType k = editGalleryFragmentController.f10305H.mo573k();
        if (k != UriRequestType.SHOW_ORIGINAL_URI && k != UriRequestType.SHOW_EDITED_URI) {
            editGalleryFragmentController.f10331l.av.setVisibility(8);
            editGalleryFragmentController.f10331l.aP.setVisibility(8);
            editGalleryFragmentController.f10331l.aA.setVisibility(8);
        } else if (k == UriRequestType.SHOW_ORIGINAL_URI) {
            editGalleryFragmentController.f10331l.av.setAlpha(0.0f);
            editGalleryFragmentController.f10331l.av.setVisibility(0);
            FiltersRepeatedPostprocessor a = editGalleryFragmentController.f10343x.m12267a(editGalleryFragmentController.f10300C.f10290k, UriRequestType.SHOW_ORIGINAL_URI, editGalleryFragmentController.f10300C.f10286g);
            FbDraweeControllerBuilder fbDraweeControllerBuilder = editGalleryFragmentController.f10341v;
            ImageRequestBuilder a2 = ImageRequestBuilder.a(editGalleryFragmentController.f10330k);
            a2.d = new ResizeOptions(editGalleryFragmentController.f10313P, editGalleryFragmentController.f10314Q);
            a2 = a2;
            a2.j = a;
            editGalleryFragmentController.f10331l.av.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) fbDraweeControllerBuilder.c(a2.m())).a(editGalleryFragmentController.f10327h)).a(f10297a).s());
        } else if (k == UriRequestType.SHOW_EDITED_URI) {
            editGalleryFragmentController.m12185o();
        }
    }

    public static void m12179a(EditGalleryFragmentController editGalleryFragmentController, FeatureSelectorController featureSelectorController) {
        boolean z;
        Preconditions.checkState(editGalleryFragmentController.f10333n.contains(featureSelectorController));
        editGalleryFragmentController.m12187q();
        UriRequestType k = ((EditFeatureController) featureSelectorController.f10488b).mo573k();
        UriRequestType k2 = editGalleryFragmentController.f10303F != null ? editGalleryFragmentController.f10305H.mo573k() : null;
        if (editGalleryFragmentController.f10300C.f10282c || ((k2 == null && editGalleryFragmentController.f10345z == null) || k2 != ((EditFeatureController) featureSelectorController.f10488b).mo573k())) {
            z = true;
        } else {
            z = false;
        }
        editGalleryFragmentController.f10316S = z;
        editGalleryFragmentController.f10304G = editGalleryFragmentController.f10303F;
        editGalleryFragmentController.f10300C.f10287h = featureSelectorController.m12366a();
        editGalleryFragmentController.f10303F = featureSelectorController;
        editGalleryFragmentController.f10305H = (EditFeatureController) editGalleryFragmentController.f10303F.f10488b;
        editGalleryFragmentController.f10305H.mo562a(editGalleryFragmentController.f10300C.f10280a);
        if (!editGalleryFragmentController.f10311N) {
            editGalleryFragmentController.f10305H.mo561a(editGalleryFragmentController.f10300C);
            editGalleryFragmentController.f10331l.m12139a(editGalleryFragmentController.f10303F.m12366a());
            if (k2 == null || k == UriRequestType.SHOW_ORIGINAL_URI || !editGalleryFragmentController.f10302E.m11789k()) {
                m12186p(editGalleryFragmentController);
            } else if (k2 == k || editGalleryFragmentController.f10319V == null) {
                Rect r = m12188r(editGalleryFragmentController);
                if (r != null) {
                    editGalleryFragmentController.f10305H.mo560a(r);
                    editGalleryFragmentController.f10305H.mo570h();
                }
            } else {
                m12178a(editGalleryFragmentController, editGalleryFragmentController.f10319V);
                m12194x(editGalleryFragmentController);
            }
        }
    }

    private void m12187q() {
        if (this.f10303F != null && this.f10305H.mo574l()) {
            this.f10300C = this.f10305H.mo575m();
            this.f10300C.f10288i = true;
        }
    }

    public static void m12178a(EditGalleryFragmentController editGalleryFragmentController, Rect rect) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkNotNull(rect);
        if (rect.width() > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (rect.height() <= 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        editGalleryFragmentController.f10331l.aA.f9656e = editGalleryFragmentController.m12196a(editGalleryFragmentController.f10330k);
        editGalleryFragmentController.f10331l.aA.setPhotoBounds(rect);
        RectF rectF = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        if (!(editGalleryFragmentController.f10300C.f10290k == null || editGalleryFragmentController.f10300C.f10290k.c() == null)) {
            rectF = editGalleryFragmentController.f10300C.f10290k.c();
        }
        editGalleryFragmentController.f10331l.aA.setVisibleArea(rectF);
        editGalleryFragmentController.f10331l.aA.getMovableItemContainer().m11523j();
        MovableContainerView movableContainerView = editGalleryFragmentController.f10331l.aA;
        movableContainerView.f9661j = new ColorDrawable[4];
        movableContainerView.m11592i();
        movableContainerView.invalidate();
        if (!(editGalleryFragmentController.f10331l.aA == null || editGalleryFragmentController.f10300C.f10290k == null)) {
            editGalleryFragmentController.f10331l.aA.m12229a(editGalleryFragmentController.f10300C.f10290k.h());
        }
        editGalleryFragmentController.f10305H.mo560a(rect);
    }

    @Nullable
    private View m12181b(FeatureSelectorController featureSelectorController) {
        if (featureSelectorController == null) {
            return null;
        }
        UriRequestType k = ((EditFeatureController) featureSelectorController.f10488b).mo573k();
        if (k == UriRequestType.SHOW_ORIGINAL_URI) {
            return this.f10331l.av;
        }
        if (k == UriRequestType.SHOW_EDITED_URI) {
            return this.f10331l.aP;
        }
        return null;
    }

    public final Parcelable m12198e() {
        m12187q();
        return this.f10300C;
    }

    @Nullable
    public static Rect m12188r(EditGalleryFragmentController editGalleryFragmentController) {
        UriRequestType k = editGalleryFragmentController.f10305H.mo573k();
        Rect w = k == UriRequestType.SHOW_EDITED_URI ? m12193w(editGalleryFragmentController) : k == UriRequestType.SHOW_ORIGINAL_URI ? m12180b(editGalleryFragmentController.f10331l.av) : null;
        if (w == null || w.width() == 0 || w.height() == 0) {
            return null;
        }
        return w;
    }

    public static void m12189s(EditGalleryFragmentController editGalleryFragmentController) {
        Uri uri;
        Preconditions.checkNotNull(editGalleryFragmentController.f10300C.f10290k);
        Preconditions.checkArgument(editGalleryFragmentController.f10300C.f10290k.l());
        editGalleryFragmentController.f10331l.ax();
        editGalleryFragmentController.f10311N = true;
        Uri o = editGalleryFragmentController.f10300C.f10290k.o() != null ? editGalleryFragmentController.f10300C.f10290k.o() : editGalleryFragmentController.f10330k;
        if (o.isAbsolute()) {
            uri = o;
        } else {
            uri = Uri.fromFile(new File(editGalleryFragmentController.f10330k.getPath()));
        }
        editGalleryFragmentController.f10308K = "SavingTextPhoto_" + uri;
        ((TasksManager) editGalleryFragmentController.f10309L.get()).a(editGalleryFragmentController.f10308K, new Callable<ListenableFuture<Uri>>(editGalleryFragmentController) {
            final /* synthetic */ EditGalleryFragmentController f10260b;

            public Object call() {
                return this.f10260b.f10310M.a(1.0f, this.f10260b.f10300C.f10290k, uri, true);
            }
        }, new AbstractDisposableFutureCallback<Uri>(editGalleryFragmentController) {
            final /* synthetic */ EditGalleryFragmentController f10261a;

            {
                this.f10261a = r1;
            }

            protected final void m12144a(Object obj) {
                Uri uri = (Uri) obj;
                State state = this.f10261a.f10300C;
                Builder builder = new Builder(this.f10261a.f10300C.f10290k);
                builder.d = uri;
                state.f10290k = builder.a();
                if (this.f10261a.f10332m != null) {
                    this.f10261a.f10332m.mo221a(this.f10261a.f10300C.f10290k);
                }
                EditGalleryFragmentController.m12182b(this.f10261a, true);
            }

            protected final void m12145a(Throwable th) {
                if (this.f10261a.f10332m != null) {
                    this.f10261a.f10332m.mo221a(this.f10261a.f10300C.f10290k);
                }
                EditGalleryFragmentController.m12182b(this.f10261a, true);
            }
        });
    }

    public static void m12182b(EditGalleryFragmentController editGalleryFragmentController, boolean z) {
        if (editGalleryFragmentController.f10332m != null) {
            editGalleryFragmentController.f10332m.mo222a(editGalleryFragmentController.f10300C.f10280a, editGalleryFragmentController.f10331l.aq(), z);
        }
        for (FeatureSelectorController featureSelectorController : editGalleryFragmentController.f10333n) {
            if (!editGalleryFragmentController.f10300C.f10282c) {
                ((EditFeatureController) featureSelectorController.f10488b).mo563a(z);
            }
            featureSelectorController.f10488b.mo564b();
        }
        editGalleryFragmentController.f10311N = false;
        EditGalleryDialogFragment editGalleryDialogFragment = editGalleryFragmentController.f10331l;
        if (editGalleryDialogFragment.an() != null) {
            ((InputMethodManager) editGalleryDialogFragment.an().getSystemService("input_method")).hideSoftInputFromWindow(editGalleryDialogFragment.T.getWindowToken(), 0);
        }
        editGalleryFragmentController.f10331l.ay();
        m12190t(editGalleryFragmentController);
    }

    public static void m12190t(EditGalleryFragmentController editGalleryFragmentController) {
        View b = editGalleryFragmentController.m12181b(editGalleryFragmentController.f10303F);
        if (!editGalleryFragmentController.f10301D.isPresent() || b == null) {
            if (editGalleryFragmentController.f10302E.m11789k()) {
                editGalleryFragmentController.f10302E.m11788j();
            }
            editGalleryFragmentController.f10331l.b();
            return;
        }
        EditGalleryAnimation editGalleryAnimation = (EditGalleryAnimation) editGalleryFragmentController.f10301D.get();
        AnonymousClass11 anonymousClass11 = new AnimationListener(editGalleryFragmentController) {
            final /* synthetic */ EditGalleryFragmentController f10258a;

            {
                this.f10258a = r1;
            }

            public void onAnimationStart(Animation animation) {
                Preconditions.checkState(this.f10258a.f10301D.isPresent());
                this.f10258a.f10305H.mo571i();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                if (this.f10258a.f10302E.m11789k()) {
                    this.f10258a.f10302E.m11788j();
                }
                this.f10258a.f10331l.b();
            }
        };
        Animation translateAnimation = new TranslateAnimation(editGalleryAnimation.f10483a.x, editGalleryAnimation.f10483a.x, editGalleryAnimation.f10483a.y, editGalleryAnimation.f10483a.y + editGalleryAnimation.f10485c);
        translateAnimation.setDuration((long) editGalleryAnimation.f10484b);
        if (anonymousClass11 != null) {
            translateAnimation.setAnimationListener(anonymousClass11);
        }
        b.clearAnimation();
        b.setAnimation(translateAnimation);
        translateAnimation.startNow();
    }

    public static void m12191u(EditGalleryFragmentController editGalleryFragmentController) {
        if (editGalleryFragmentController.f10305H.mo574l()) {
            editGalleryFragmentController.f10300C = editGalleryFragmentController.f10305H.mo575m();
            editGalleryFragmentController.f10300C.f10288i = true;
        }
        if (editGalleryFragmentController.f10311N) {
            editGalleryFragmentController.f10312O = true;
        } else if (!editGalleryFragmentController.f10300C.f10288i) {
        } else {
            if (editGalleryFragmentController.f10300C.f10290k.h().isEmpty() || !editGalleryFragmentController.f10300C.f10285f) {
                if (editGalleryFragmentController.f10332m != null) {
                    editGalleryFragmentController.f10332m.mo221a(editGalleryFragmentController.f10300C.f10290k);
                }
                m12182b(editGalleryFragmentController, true);
                return;
            }
            m12189s(editGalleryFragmentController);
        }
    }

    public final void m12197a(String str) {
        Fb4aTitleBar fb4aTitleBar = this.f10331l.aH;
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.g = str;
        fb4aTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
    }

    public final void m12199f() {
        Fb4aTitleBar fb4aTitleBar = this.f10331l.aH;
        fb4aTitleBar.a(new OnClickListener(this) {
            final /* synthetic */ EditGalleryFragmentController f10262a;

            {
                this.f10262a = r1;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1656410741);
                if (this.f10262a.f10300C.f10294o && (this.f10262a.f10300C.f10288i || this.f10262a.f10305H.mo574l())) {
                    EditGalleryFragmentController.m12192v(this.f10262a);
                } else if (this.f10262a.f10300C.f10294o) {
                    EditGalleryFragmentController.m12182b(this.f10262a, true);
                } else {
                    EditGalleryFragmentController.m12182b(this.f10262a, false);
                }
                LogUtils.a(1479490252, a);
            }
        });
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.g = this.f10331l.b(2131234500);
        fb4aTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
        fb4aTitleBar.setOnToolbarButtonListener(new OnToolbarButtonListener(this) {
            final /* synthetic */ EditGalleryFragmentController f10263a;

            {
                this.f10263a = r1;
            }

            public final void m12146a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                if (this.f10263a.f10305H.mo567e()) {
                    this.f10263a.m12197a(this.f10263a.f10300C.f10293n);
                } else if (this.f10263a.f10300C.f10288i || this.f10263a.f10305H.mo574l()) {
                    this.f10263a.m12197a(this.f10263a.f10300C.f10293n);
                    EditGalleryFragmentController.m12191u(this.f10263a);
                } else {
                    EditGalleryFragmentController.m12182b(this.f10263a, true);
                }
            }
        });
    }

    public static void m12192v(EditGalleryFragmentController editGalleryFragmentController) {
        if (!editGalleryFragmentController.f10311N) {
            AlertDialog.Builder b = new AlertDialog.Builder(editGalleryFragmentController.f10331l.getContext()).b(editGalleryFragmentController.f10331l.jW_().getString(2131237794));
            b.a(editGalleryFragmentController.f10331l.jW_().getString(2131237796), new DialogInterface.OnClickListener(editGalleryFragmentController) {
                final /* synthetic */ EditGalleryFragmentController f10264a;

                {
                    this.f10264a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    EditGalleryFragmentController.m12191u(this.f10264a);
                }
            });
            b.b(editGalleryFragmentController.f10331l.jW_().getString(2131237795), new DialogInterface.OnClickListener(editGalleryFragmentController) {
                final /* synthetic */ EditGalleryFragmentController f10265a;

                {
                    this.f10265a = r1;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    if (this.f10265a.f10332m != null && this.f10265a.f10300C.f10289j) {
                        ((MediaRotationHelper) this.f10265a.f10342w.get()).a(this.f10265a.f10330k, this.f10265a.f10300C.f10286g);
                        this.f10265a.f10332m.mo220a(this.f10265a.f10300C.f10286g);
                    }
                    EditGalleryFragmentController.m12182b(this.f10265a, false);
                }
            });
            b.a().show();
        }
    }

    public static Rect m12193w(EditGalleryFragmentController editGalleryFragmentController) {
        Rect rect = new Rect();
        editGalleryFragmentController.f10331l.aP.getActualImageBounds().round(rect);
        return rect;
    }

    public static void m12194x(EditGalleryFragmentController editGalleryFragmentController) {
        View b = editGalleryFragmentController.m12181b(editGalleryFragmentController.f10303F);
        if (!editGalleryFragmentController.f10301D.isPresent() && editGalleryFragmentController.f10345z != null && editGalleryFragmentController.m12181b(editGalleryFragmentController.f10303F) != null) {
            RectF rectF;
            RectF rectF2 = new RectF();
            if (b instanceof FbDraweeView) {
                ((GenericDraweeHierarchy) ((FbDraweeView) b).getHierarchy()).a(rectF2);
                rectF = rectF2;
            } else if (b instanceof CreativeEditingSwipeableLayout) {
                rectF = ((CreativeEditingSwipeableLayout) b).getActualImageBounds();
            } else {
                rectF = rectF2;
            }
            editGalleryFragmentController.f10301D = Optional.of(new EditGalleryAnimation(editGalleryFragmentController.f10345z, AnimationParam.m12363a(b, rectF), new PointF((float) b.getLeft(), (float) b.getTop()), editGalleryFragmentController.f10344y.d()));
            ((EditGalleryAnimation) editGalleryFragmentController.f10301D.get()).m12365a(b, new AnimationListener(editGalleryFragmentController) {
                final /* synthetic */ EditGalleryFragmentController f10257a;

                {
                    this.f10257a = r1;
                }

                public void onAnimationStart(Animation animation) {
                    Preconditions.checkState(this.f10257a.f10301D.isPresent());
                    this.f10257a.f10305H.mo571i();
                    this.f10257a.f10317T = true;
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    this.f10257a.f10305H.mo570h();
                    this.f10257a.f10317T = false;
                }
            });
        } else if (editGalleryFragmentController.f10316S) {
            r0 = editGalleryFragmentController.m12181b(editGalleryFragmentController.f10303F);
            b = editGalleryFragmentController.m12181b(editGalleryFragmentController.f10304G);
            if (r0 == null || b == null) {
                if (r0 != null) {
                    r0.setVisibility(0);
                    r0.setAlpha(1.0f);
                    editGalleryFragmentController.f10305H.mo570h();
                }
                if (b != null) {
                    b.setVisibility(8);
                    editGalleryFragmentController.f10304G.f10488b.mo571i();
                }
            } else {
                r0.setAlpha(0.0f);
                r0.setVisibility(0);
                r0.animate().alpha(1.0f).setDuration(800).setListener(new AnimatorListenerAdapter(editGalleryFragmentController) {
                    final /* synthetic */ EditGalleryFragmentController f10267b;

                    public void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        r0.setAlpha(1.0f);
                        r0.setVisibility(0);
                        this.f10267b.f10305H.mo570h();
                        this.f10267b.f10317T = false;
                    }

                    public void onAnimationStart(Animator animator) {
                        super.onAnimationStart(animator);
                        this.f10267b.f10316S = false;
                        this.f10267b.f10305H.mo571i();
                        this.f10267b.f10317T = true;
                    }
                });
                b.animate().alpha(0.0f).setDuration(500).setListener(new AnimatorListenerAdapter(editGalleryFragmentController) {
                    final /* synthetic */ EditGalleryFragmentController f10269b;

                    public void onAnimationEnd(Animator animator) {
                        b.setVisibility(8);
                    }
                });
            }
        } else if (!editGalleryFragmentController.f10317T) {
            r0 = editGalleryFragmentController.m12181b(editGalleryFragmentController.f10303F);
            if (r0 != null) {
                r0.setVisibility(0);
                r0.setAlpha(1.0f);
            }
            b = editGalleryFragmentController.m12181b(editGalleryFragmentController.f10304G);
            if (!(b == null || b == r0)) {
                b.setVisibility(4);
            }
            if ((r0 != null || b != null) && r0 != b) {
                editGalleryFragmentController.f10305H.mo570h();
                editGalleryFragmentController.f10304G.f10488b.mo571i();
            }
        }
    }

    private Uri m12195y() {
        Uri uri = this.f10330k;
        if (this.f10300C.f10290k.o() == null || this.f10300C.f10290k.c() == null) {
            return uri;
        }
        return this.f10300C.f10290k.o().isAbsolute() ? this.f10300C.f10290k.o() : Uri.fromFile(new File(this.f10300C.f10290k.o().getPath()));
    }

    public final int m12196a(Uri uri) {
        return ((MediaRotationHelper) this.f10342w.get()).a(uri);
    }

    public static Rect m12180b(FbDraweeView fbDraweeView) {
        RectF rectF = new RectF();
        ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).a(rectF);
        Rect rect = new Rect();
        rectF.round(rect);
        return rect;
    }
}
