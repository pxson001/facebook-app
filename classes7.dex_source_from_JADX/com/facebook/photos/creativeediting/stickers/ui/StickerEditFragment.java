package com.facebook.photos.creativeediting.stickers.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.composer.ui.titlebar.ComposerBaseTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar;
import com.facebook.composer.ui.titlebar.ComposerTitleBar.StateBuilder;
import com.facebook.composer.ui.titlebar.HarrisonPlusIconType;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger.Events;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.StickerParams;
import com.facebook.photos.creativeediting.renderers.CreativeEditingPhotoOverlayView;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController;
import com.facebook.photos.creativeediting.renderers.PhotoOverlayController.OverlayType;
import com.facebook.photos.creativeediting.stickers.events.StickerEventBus;
import com.facebook.photos.creativeediting.stickers.events.StickerEvents.StickerSelectedEvent;
import com.facebook.photos.creativeediting.stickers.stickers.StickerPicker;
import com.facebook.photos.creativeediting.ui.ImageContainerView;
import com.facebook.photos.creativeediting.ui.ImageContainerView.ImageContainerListener;
import com.facebook.photos.imageprocessing.FiltersRepeatedPostprocessor;
import com.facebook.sequencelogger.Sequence;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mMessage */
public class StickerEditFragment extends FbDialogFragment implements AnalyticsFragment {
    private static final String ar = StickerEditFragment.class.getSimpleName();
    private final StickerSelectedEventSubscriber aA = new StickerSelectedEventSubscriber(this);
    private final ShowStickerPickerEventSubscriber aB = new ShowStickerPickerEventSubscriber(this);
    private int aC = -1;
    public Uri aD;
    private String aE;
    private String aF;
    public ImmutableList<StickerParams> aG = RegularImmutableList.a;
    public RectF aH = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    public boolean aI;
    public Optional<ProgressBar> aJ = Absent.INSTANCE;
    public boolean aK = false;
    @Nullable
    public FiltersRepeatedPostprocessor aL;
    @Nullable
    public CreativeEditingData aM;
    @Inject
    Lazy<StickerEventBus> am;
    @Inject
    Lazy<BitmapUtils> an;
    @Inject
    CreativeEditingAnalyticsLogger ao;
    @Inject
    CreativeEditingLogger ap;
    @Inject
    PhotoOverlayController aq;
    private View as;
    public StickerPicker at;
    public FrameLayout au;
    public ImageContainerView av;
    public StickerContainerView aw;
    private CreativeEditingPhotoOverlayView ax;
    public OnToolbarButtonListener ay;
    @Nullable
    public EventListener az;

    /* compiled from: mMessage */
    public interface EventListener {
        void mo506a(ImmutableList<StickerParams> immutableList, boolean z, FileEditingListener fileEditingListener);
    }

    /* compiled from: mMessage */
    public class C07911 implements OnClickListener {
        final /* synthetic */ StickerEditFragment f9689a;

        public C07911(StickerEditFragment stickerEditFragment) {
            this.f9689a = stickerEditFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            StickerEditFragment.ar(this.f9689a);
        }
    }

    /* compiled from: mMessage */
    class C07922 extends OnToolbarButtonListener {
        final /* synthetic */ StickerEditFragment f9690a;

        C07922(StickerEditFragment stickerEditFragment) {
            this.f9690a = stickerEditFragment;
        }

        public final void m11620a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            StickerEditFragment.ar(this.f9690a);
        }
    }

    /* compiled from: mMessage */
    class C07933 implements OnLayoutChangeListener {
        final /* synthetic */ StickerEditFragment f9691a;
        private boolean f9692b = false;

        C07933(StickerEditFragment stickerEditFragment) {
            this.f9691a = stickerEditFragment;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (!this.f9692b) {
                this.f9691a.aw.setPhotoBounds(this.f9691a.av.getBounds());
                this.f9691a.aw.m11602a(this.f9691a.aG);
                StickerEditFragment.m11628a(this.f9691a, new RectF(this.f9691a.av.getBounds()));
                this.f9692b = true;
            }
        }
    }

    /* compiled from: mMessage */
    class C07944 implements OnKeyListener {
        final /* synthetic */ StickerEditFragment f9693a;

        C07944(StickerEditFragment stickerEditFragment) {
            this.f9693a = stickerEditFragment;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            if (i != 4 || keyEvent.getAction() != 1) {
                return false;
            }
            if (this.f9693a.aK) {
                return true;
            }
            boolean at = StickerEditFragment.at(this.f9693a);
            if (at) {
                return at;
            }
            StickerEditFragment.ar(this.f9693a);
            return at;
        }
    }

    /* compiled from: mMessage */
    public class C07955 implements ImageContainerListener {
        final /* synthetic */ StickerEditFragment f9694a;

        public C07955(StickerEditFragment stickerEditFragment) {
            this.f9694a = stickerEditFragment;
        }

        public final void mo507a() {
            this.f9694a.aw.setVisibility(0);
            StickerEditFragment.m11628a(this.f9694a, new RectF(this.f9694a.av.getBounds()));
            if (this.f9694a.at != null && !this.f9694a.aI && this.f9694a.at.getVisibility() != 0) {
                this.f9694a.at.m11565b();
            }
        }
    }

    /* compiled from: mMessage */
    public class C07966 implements OnBackPressedListener {
        final /* synthetic */ StickerEditFragment f9695a;

        public C07966(StickerEditFragment stickerEditFragment) {
            this.f9695a = stickerEditFragment;
        }

        public final void m11623a() {
            if (!StickerEditFragment.at(this.f9695a)) {
                StickerEditFragment.ar(this.f9695a);
            }
        }
    }

    /* compiled from: mMessage */
    public class FileEditingListener {
        final /* synthetic */ StickerEditFragment f9696a;

        public FileEditingListener(StickerEditFragment stickerEditFragment) {
            this.f9696a = stickerEditFragment;
        }

        public final void m11624a() {
            if (this.f9696a.aJ.isPresent()) {
                ((ProgressBar) this.f9696a.aJ.get()).setVisibility(8);
            }
            this.f9696a.aK = false;
            this.f9696a.b();
        }
    }

    /* compiled from: mMessage */
    class ShowStickerPickerEventSubscriber extends com.facebook.photos.creativeediting.stickers.events.StickerEvents.ShowStickerPickerEventSubscriber {
        final /* synthetic */ StickerEditFragment f9697a;

        public ShowStickerPickerEventSubscriber(StickerEditFragment stickerEditFragment) {
            this.f9697a = stickerEditFragment;
        }

        public final void m11625b(FbEvent fbEvent) {
            this.f9697a.at.m11565b();
        }
    }

    /* compiled from: mMessage */
    class StickerSelectedEventSubscriber extends com.facebook.photos.creativeediting.stickers.events.StickerEvents.StickerSelectedEventSubscriber {
        final /* synthetic */ StickerEditFragment f9698a;

        public StickerSelectedEventSubscriber(StickerEditFragment stickerEditFragment) {
            this.f9698a = stickerEditFragment;
        }

        public final void m11626b(FbEvent fbEvent) {
            StickerSelectedEvent stickerSelectedEvent = (StickerSelectedEvent) fbEvent;
            if (stickerSelectedEvent.f9609a != null) {
                this.f9698a.aw.m11600a(stickerSelectedEvent.f9609a);
                this.f9698a.at.m11566c();
            }
        }
    }

    public static void m11629a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((StickerEditFragment) obj).m11627a(IdBasedSingletonScopeProvider.b(injectorLike, 9280), IdBasedLazy.a(injectorLike, 406), CreativeEditingAnalyticsLogger.m11459a(injectorLike), CreativeEditingLogger.m11468b(injectorLike), PhotoOverlayController.m11526b(injectorLike));
    }

    private void m11627a(Lazy<StickerEventBus> lazy, Lazy<BitmapUtils> lazy2, CreativeEditingAnalyticsLogger creativeEditingAnalyticsLogger, CreativeEditingLogger creativeEditingLogger, PhotoOverlayController photoOverlayController) {
        this.am = lazy;
        this.an = lazy2;
        this.ao = creativeEditingAnalyticsLogger;
        this.ap = creativeEditingLogger;
        this.aq = photoOverlayController;
    }

    public static void m11630a(String str, FragmentManager fragmentManager, Uri uri, int i, int i2, ImmutableList<StickerParams> immutableList, EventListener eventListener, @Nullable CreativeEditingData creativeEditingData, String str2, @Nullable FiltersRepeatedPostprocessor filtersRepeatedPostprocessor) {
        Preconditions.checkNotNull(uri);
        Preconditions.checkNotNull(fragmentManager);
        Bundle bundle = new Bundle();
        bundle.putParcelable("param_file_uri", uri);
        bundle.putString("param_session_id", str);
        bundle.putInt("param_bitmap_width", i);
        bundle.putInt("param_bitmap_height", i2);
        bundle.putString("param_media_iten_identifier", str2);
        if (immutableList != null) {
            bundle.putParcelableArrayList("stickers_in_composer_sticker_params", Lists.a(immutableList));
        }
        if (((StickerEditFragment) fragmentManager.a(ar)) == null) {
            StickerEditFragment stickerEditFragment = new StickerEditFragment();
            stickerEditFragment.g(bundle);
            stickerEditFragment.az = eventListener;
            stickerEditFragment.aM = creativeEditingData;
            stickerEditFragment.aL = filtersRepeatedPostprocessor;
            if (!(stickerEditFragment.aM == null || stickerEditFragment.aM.c() == null)) {
                stickerEditFragment.aH = stickerEditFragment.aM.c();
            }
            stickerEditFragment.a(fragmentManager, ar);
            fragmentManager.b();
        }
    }

    private boolean m11632a(ImmutableList<StickerParams> immutableList) {
        return !this.aG.equals(immutableList);
    }

    public static void ar(StickerEditFragment stickerEditFragment) {
        if (stickerEditFragment.at.getVisibility() == 0) {
            stickerEditFragment.at.m11566c();
        }
        if (stickerEditFragment.az == null) {
            stickerEditFragment.b();
            if (stickerEditFragment.an() instanceof StickerEditActivity) {
                stickerEditFragment.an().finish();
                return;
            }
            return;
        }
        ImmutableList stickerParamsForOriginalPhoto = stickerEditFragment.aw.getStickerParamsForOriginalPhoto();
        if (stickerEditFragment.aw.m11591g() || stickerEditFragment.m11632a(stickerParamsForOriginalPhoto) || stickerEditFragment.aI) {
            stickerEditFragment.ao.m11465d(stickerEditFragment.aE, stickerEditFragment.aw.getNumOfItems());
            stickerEditFragment.ap.m11470a(stickerEditFragment.aw.f9671n, stickerEditFragment.aw.f9672o);
            if (!stickerEditFragment.aJ.isPresent()) {
                stickerEditFragment.aJ = Optional.of((ProgressBar) ((ViewStub) stickerEditFragment.au.findViewById(2131561101)).inflate());
            }
            ((ProgressBar) stickerEditFragment.aJ.get()).setVisibility(0);
            ((ProgressBar) stickerEditFragment.aJ.get()).bringToFront();
            stickerEditFragment.aK = true;
            stickerEditFragment.az.mo506a(stickerParamsForOriginalPhoto, true, new FileEditingListener(stickerEditFragment));
            return;
        }
        stickerEditFragment.ao.m11465d(stickerEditFragment.aE, stickerEditFragment.aw.getNumOfItems());
        stickerEditFragment.ap.m11470a(stickerEditFragment.aw.f9671n, stickerEditFragment.aw.f9672o);
        stickerEditFragment.az.mo506a(stickerParamsForOriginalPhoto, false, new FileEditingListener(stickerEditFragment));
    }

    public static boolean at(StickerEditFragment stickerEditFragment) {
        if (stickerEditFragment.at.getVisibility() == 0) {
            stickerEditFragment.at.m11566c();
            return true;
        }
        ImmutableList stickerParamsForOriginalPhoto = stickerEditFragment.aw.getStickerParamsForOriginalPhoto();
        if ((stickerEditFragment.aw.m11591g() || !stickerEditFragment.m11632a(stickerParamsForOriginalPhoto)) && (!stickerEditFragment.aw.m11591g() || stickerEditFragment.aG == null || stickerEditFragment.aG.isEmpty())) {
            stickerEditFragment.ao.m11465d(stickerEditFragment.aE, 0);
            return false;
        }
        Builder b = new Builder(stickerEditFragment.getContext()).b(stickerEditFragment.jW_().getString(2131237772));
        b.a(stickerEditFragment.jW_().getString(2131237577), new C07911(stickerEditFragment));
        b.b(stickerEditFragment.jW_().getString(2131237554), null);
        b.a().show();
        return true;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1768090094);
        this.aC = an().getRequestedOrientation();
        an().setRequestedOrientation(1);
        super.mi_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2090389107, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -284782038);
        an().setRequestedOrientation(this.aC);
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -714769679, a);
    }

    public final void m11636a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1194881117);
        super.a(bundle);
        a(2, 2131626058);
        Class cls = StickerEditFragment.class;
        m11629a((Object) this, getContext());
        e(true);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -616422905, a);
    }

    public final void m11634H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1756541773);
        if (this.aJ.isPresent()) {
            ((ProgressBar) this.aJ.get()).setVisibility(8);
        }
        this.aK = false;
        super.H();
        ((StickerEventBus) this.am.get()).b(this.aA);
        ((StickerEventBus) this.am.get()).b(this.aB);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 782321886, a);
    }

    public final void m11633G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -189061691);
        super.G();
        ((StickerEventBus) this.am.get()).a(this.aA);
        ((StickerEventBus) this.am.get()).a(this.aB);
        this.at.m11567d();
        CreativeEditingAnalyticsLogger creativeEditingAnalyticsLogger = this.ao;
        Sequence b = creativeEditingAnalyticsLogger.f9511b.b(CreativeEditingAnalyticsLogger.f9509a, this.aE);
        if (b != null) {
            SequenceLoggerDetour.a(b, Events.STICKER_EDIT_FLOW.name, 136770975);
        }
        Preconditions.checkNotNull(this.av);
        this.av.m11922a(this.aD, this.s.getInt("param_bitmap_width"), this.s.getInt("param_bitmap_height"), this.aL, new C07955(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1403199110, a);
    }

    public final String am_() {
        return "stickers_in_composer";
    }

    public final View m11635a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2068247997);
        this.as = layoutInflater.inflate(2130906579, viewGroup, false);
        if (bundle != null) {
            View view = this.as;
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -616010345, a);
            return view;
        }
        m11631a(this.s.getParcelableArrayList("stickers_in_composer_sticker_params"));
        view = this.as;
        LogUtils.f(197660367, a);
        return view;
    }

    private void m11631a(List<StickerParams> list) {
        Preconditions.checkNotNull(this.as);
        this.aD = (Uri) this.s.getParcelable("param_file_uri");
        this.aE = this.s.getString("param_session_id");
        this.aF = this.s.getString("param_media_iten_identifier");
        this.ap.m11480a(this.aE, this.aF);
        this.ap.m11469a();
        if (list != null) {
            this.aG = ImmutableList.copyOf(list);
        }
        this.at = (StickerPicker) this.as.findViewById(2131566563);
        this.at.m11564a(this.aE, this.aF, StickerInterface.COMPOSER);
        this.an.get();
        int b = BitmapUtils.b(this.aD.getPath());
        int i = b > 0 ? b : 0;
        this.au = (FrameLayout) this.as.findViewById(2131561115);
        this.av = (ImageContainerView) this.as.findViewById(2131566561);
        this.aw = (StickerContainerView) this.as.findViewById(2131566562);
        this.aw.setVisibility(4);
        this.aw.f9656e = i;
        this.aw.m11601a(this.aE, this.aF);
        this.aw.setVisibleArea(this.aH);
        this.ax = new CreativeEditingPhotoOverlayView(getContext());
        this.ax.setId(1003);
        this.ay = new C07922(this);
        ComposerBaseTitleBar composerBaseTitleBar = (ComposerBaseTitleBar) this.as.findViewById(2131566560);
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.g = jW_().getString(2131234471);
        a = a;
        a.h = -2;
        TitleBarButtonSpec a2 = a.a();
        composerBaseTitleBar.setOnBackPressedListener(new C07966(this));
        StateBuilder stateBuilder = new StateBuilder();
        stateBuilder.f2092b = a2;
        StateBuilder stateBuilder2 = stateBuilder;
        stateBuilder2.f2091a = jW_().getString(2131237773);
        stateBuilder2 = stateBuilder2.m2067a(true);
        stateBuilder2.f2093c = this.ay;
        stateBuilder2 = stateBuilder2;
        stateBuilder2.f2094d = HarrisonPlusIconType.m2080c();
        ComposerTitleBar composerTitleBar = new ComposerTitleBar(composerBaseTitleBar, stateBuilder2.m2066a());
        this.as.addOnLayoutChangeListener(new C07933(this));
        this.f.setOnKeyListener(new C07944(this));
    }

    public final void m11637e(Bundle bundle) {
        super.e(bundle);
        ImmutableList stickerParamsForOriginalPhoto = this.aw.getStickerParamsForOriginalPhoto();
        ArrayList a = Lists.a();
        if (stickerParamsForOriginalPhoto != null) {
            a.addAll(stickerParamsForOriginalPhoto);
        }
        bundle.putParcelableArrayList("restore_param_in_memory_stickers", a);
        bundle.putParcelable("restore_param_visible_area", this.aH);
    }

    public final void m11638h(@android.support.annotation.Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1923310924);
        super.h(bundle);
        if (bundle != null) {
            this.aI = true;
            List parcelableArrayList = bundle.getParcelableArrayList("restore_param_in_memory_stickers");
            this.aH = (RectF) bundle.getParcelable("restore_param_visible_area");
            if (parcelableArrayList != null) {
                this.aG = ImmutableList.copyOf(parcelableArrayList);
            }
            m11631a(parcelableArrayList);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 679846233, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1238484628);
        super.mY_();
        this.at.m11563a();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1531223367, a);
    }

    public static void m11628a(StickerEditFragment stickerEditFragment, RectF rectF) {
        if (stickerEditFragment.aM != null && stickerEditFragment.aM.e() != null && rectF.width() != 0.0f && rectF.height() != 0.0f) {
            LayoutParams layoutParams = new FrameLayout.LayoutParams((int) rectF.width(), (int) rectF.height());
            layoutParams.topMargin = ((int) rectF.top) + stickerEditFragment.av.getPaddingTop();
            layoutParams.leftMargin = ((int) rectF.left) + stickerEditFragment.av.getPaddingLeft();
            stickerEditFragment.ax.setLayoutParams(layoutParams);
            if (stickerEditFragment.as.findViewById(1003) == null) {
                stickerEditFragment.au.addView(stickerEditFragment.ax);
            }
            stickerEditFragment.an.get();
            int b = BitmapUtils.b(stickerEditFragment.aD.getPath());
            stickerEditFragment.aq.m11529a(stickerEditFragment.aM, (int) rectF.width(), (int) rectF.height(), b, stickerEditFragment.ax, true, OverlayType.TEXTS, OverlayType.FRAME);
            stickerEditFragment.ax.f9581a = stickerEditFragment.aq;
        }
    }
}
