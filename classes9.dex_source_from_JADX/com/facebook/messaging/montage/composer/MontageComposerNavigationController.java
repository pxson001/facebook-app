package com.facebook.messaging.montage.composer;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.Assisted;
import com.facebook.messaging.media.editing.MultimediaEditorView;
import com.facebook.messaging.montage.composer.MontageComposerController.C13812;
import com.facebook.messaging.montage.composer.MontageComposerFragmentFactory.C13861;
import com.facebook.messaging.montage.composer.MontageComposerNavigationView.OnItemClickListener;
import com.facebook.messaging.montage.composer.MontageComposerNavigationView.TabItem;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.inject.Inject;

/* compiled from: is_prepay_account */
public class MontageComposerNavigationController {
    private static final SpringConfig f12499a = new SpringConfig(200.0d, 15.0d);
    private final Spring f12500b;
    public final MontageComposerNavigationView f12501c;
    public CanvasType f12502d;
    public CanvasType f12503e;
    public C13812 f12504f;

    /* compiled from: is_prepay_account */
    class C13881 implements OnItemClickListener {
        final /* synthetic */ MontageComposerNavigationController f12495a;

        C13881(MontageComposerNavigationController montageComposerNavigationController) {
            this.f12495a = montageComposerNavigationController;
        }

        public final void mo488a(CanvasType canvasType) {
            MontageComposerNavigationController montageComposerNavigationController = this.f12495a;
            CanvasType canvasType2 = montageComposerNavigationController.f12502d;
            montageComposerNavigationController.f12502d = canvasType;
            if (montageComposerNavigationController.f12504f != null) {
                C13812 c13812;
                if (montageComposerNavigationController.f12502d != canvasType2) {
                    MontageComposerCanvas montageComposerCanvas;
                    c13812 = montageComposerNavigationController.f12504f;
                    if (CanvasType.CAMERA.equals(canvasType)) {
                        c13812.f12460a.f12477l.f12501c.m12985a(0.0f);
                    } else {
                        c13812.f12460a.f12477l.f12501c.m12985a(1.0f);
                    }
                    if (canvasType == CanvasType.PALETTE) {
                        montageComposerCanvas = (MontageEditorView) c13812.f12460a.f12479n.f11566c;
                        c13812.f12460a.f12477l.m12969e();
                        c13812.f12460a.f12479n.m12221b();
                        c13812.f12460a.f12479n.m12223f();
                        MontageComposerController.m12936j(c13812.f12460a);
                    } else {
                        MontageComposerController.m12937k(c13812.f12460a);
                        MontageComposerFragmentFactory montageComposerFragmentFactory = c13812.f12460a.f12469d;
                        FbFragment fbFragment = (FbFragment) montageComposerFragmentFactory.f12486b.get(canvasType);
                        if (fbFragment == null) {
                            WeakReference weakReference = (WeakReference) montageComposerFragmentFactory.f12485a.get(canvasType);
                            if (weakReference != null) {
                                fbFragment = (FbFragment) weakReference.get();
                            }
                        }
                        FbFragment fbFragment2 = fbFragment;
                        if (fbFragment2 == null) {
                            fbFragment2 = MontageComposerFragmentFactory.m12948b(canvasType);
                            switch (C13861.f12483a[canvasType.ordinal()]) {
                                case 1:
                                    montageComposerFragmentFactory.f12486b.put(canvasType, fbFragment2);
                                    break;
                                case 2:
                                case 3:
                                    montageComposerFragmentFactory.f12485a.put(canvasType, new WeakReference(fbFragment2));
                                    break;
                            }
                        }
                        FbFragment fbFragment3 = fbFragment2;
                        c13812.f12460a.m12934b(fbFragment3);
                        MontageComposerController montageComposerController = c13812.f12460a;
                        if (montageComposerController.f12475j != null) {
                            montageComposerController.f12475j.m12928a((MontageComposerCanvas) fbFragment3);
                        }
                        montageComposerController.f12476k.s().a().a(2130968684, 2130968685).b(montageComposerController.f12480o.getId(), fbFragment3).b();
                        montageComposerCanvas = (MontageComposerCanvas) fbFragment3;
                    }
                    MontageComposerFragment montageComposerFragment = c13812.f12460a.f12476k;
                    boolean lV_ = montageComposerCanvas.lV_();
                    if (montageComposerFragment.am == null) {
                        montageComposerFragment.ao = lV_;
                    } else {
                        montageComposerFragment.am.l = lV_;
                    }
                    return;
                }
                c13812 = montageComposerNavigationController.f12504f;
                if (canvasType == CanvasType.PALETTE) {
                    MultimediaEditorView multimediaEditorView = c13812.f12460a.f12479n.f11566c;
                } else {
                    MontageComposerController.m12939n(c13812.f12460a);
                }
            }
        }

        public final void mo489a(EditType editType) {
            if (this.f12495a.f12504f != null) {
                C13812 c13812 = this.f12495a.f12504f;
                if (!MontageComposerController.m12938l(c13812.f12460a)) {
                    c13812.f12460a.f12477l.m12966a(CanvasType.PALETTE);
                    c13812.f12460a.f12477l.m12969e();
                }
                switch (editType) {
                    case TEXT:
                        c13812.f12460a.f12479n.f11570g.m16259j();
                        return;
                    case DOODLE:
                        c13812.f12460a.f12479n.f11570g.m16261l();
                        return;
                    case STICKER:
                        c13812.f12460a.f12479n.f11570g.m16260k();
                        return;
                    default:
                        return;
                }
            }
        }

        public final void mo487a() {
            if (this.f12495a.f12504f != null) {
                this.f12495a.f12504f.f12460a.f12479n.m12217a();
            }
        }
    }

    /* compiled from: is_prepay_account */
    class HideShowSpringListener extends SimpleSpringListener {
        final /* synthetic */ MontageComposerNavigationController f12498a;

        public final void m12960b(Spring spring) {
            if (Float.compare((float) spring.i, 0.0f) == 0) {
                this.f12498a.f12501c.setVisibility(4);
            }
        }

        public HideShowSpringListener(MontageComposerNavigationController montageComposerNavigationController) {
            this.f12498a = montageComposerNavigationController;
        }

        public final void m12959a(Spring spring) {
            float d = (float) spring.d();
            this.f12498a.f12501c.setAlpha(d);
            this.f12498a.f12501c.setTranslationY((1.0f - d) * ((float) this.f12498a.f12501c.getHeight()));
        }
    }

    @Inject
    public MontageComposerNavigationController(SpringSystem springSystem, @Assisted MontageComposerNavigationView montageComposerNavigationView, @Assisted List<CanvasType> list, @Assisted List<EditType> list2) {
        this.f12501c = montageComposerNavigationView;
        Spring a = springSystem.a().a(f12499a).b(0.0d).a(1.0d);
        a.c = true;
        this.f12500b = a.l().a(new HideShowSpringListener(this));
        this.f12501c.f12523g = new C13881(this);
        for (CanvasType canvasType : list) {
            MontageComposerNavigationView montageComposerNavigationView2 = this.f12501c;
            TabItem tabItem = new TabItem(canvasType);
            tabItem.f12516d = m12963c(canvasType);
            tabItem = tabItem;
            tabItem.f12515c = m12964d(canvasType);
            montageComposerNavigationView2.m12988a(tabItem);
        }
        this.f12501c.m12986a(this.f12501c.getChildCount());
        for (EditType editType : list2) {
            montageComposerNavigationView2 = this.f12501c;
            tabItem = new TabItem(editType);
            tabItem.f12516d = m12961a(editType);
            tabItem = tabItem;
            tabItem.f12515c = m12962b(editType);
            montageComposerNavigationView2.m12988a(tabItem);
        }
    }

    public final void m12966a(CanvasType canvasType) {
        this.f12501c.m12987a(canvasType);
    }

    public final void m12967c() {
        if (!m12965i()) {
            this.f12501c.setAlpha(0.0f);
            this.f12501c.setTranslationY((float) this.f12501c.getHeight());
            this.f12501c.setVisibility(0);
            this.f12500b.b(1.0d);
        }
    }

    public final void m12968d() {
        if (m12965i()) {
            this.f12500b.b(0.0d);
        }
    }

    public final void m12969e() {
        if (!m12970g()) {
            this.f12503e = this.f12502d;
            this.f12501c.setPrimaryMode(this.f12503e);
        }
    }

    public final boolean m12970g() {
        return m12965i() && this.f12503e != null;
    }

    private boolean m12965i() {
        return this.f12501c.getVisibility() == 0;
    }

    @StringRes
    public static int m12963c(CanvasType canvasType) {
        switch (canvasType) {
            case CAMERA:
                return 2131240929;
            case MEDIA_PICKER:
                return 2131240930;
            case LOCATION:
                return 2131240934;
            case PALETTE:
                return 2131240935;
            default:
                throw new IllegalStateException("Unrecognised canvas type: " + canvasType);
        }
    }

    @StringRes
    public static int m12961a(EditType editType) {
        switch (editType) {
            case TEXT:
                return 2131240931;
            case DOODLE:
                return 2131240933;
            case STICKER:
                return 2131240932;
            default:
                throw new IllegalStateException("Unrecognised freeform type: " + editType);
        }
    }

    @DrawableRes
    public static int m12964d(CanvasType canvasType) {
        switch (canvasType) {
            case CAMERA:
                return 2130841344;
            case MEDIA_PICKER:
                return 2130841384;
            case LOCATION:
                return 2130841424;
            case PALETTE:
                return 2130841355;
            default:
                throw new IllegalStateException("Unrecognised canvas type: " + canvasType);
        }
    }

    @DrawableRes
    public static int m12962b(EditType editType) {
        switch (editType) {
            case TEXT:
                return 2130841447;
            case DOODLE:
                return 2130841405;
            case STICKER:
                return 2130841443;
            default:
                throw new IllegalStateException("Unrecognised freeform type: " + editType);
        }
    }
}
