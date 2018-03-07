package com.facebook.photos.mediagallery.ui.tagging;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.MediaLogger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.TagScreen;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel;
import com.facebook.photos.galleryutil.GlobalOnLayoutHelper;
import com.facebook.photos.galleryutil.SizeAnimation;
import com.facebook.photos.galleryutil.SizeAnimation.Dimension;
import com.facebook.photos.galleryutil.SizeAnimation.Type;
import com.facebook.photos.galleryutil.VisibilityAnimator;
import com.facebook.photos.mediagallery.ui.tagging.MediaTaggingController.C03002;
import com.facebook.photos.mediagallery.ui.tagging.MediaTaggingController.C03002.C02981;
import com.facebook.photos.mediagallery.ui.tagging.MediaTaggingController.C03002.C02992;
import com.facebook.photos.tagging.shared.BubbleLayout;
import com.facebook.photos.tagging.shared.BubbleLayout.ArrowDirection;
import com.facebook.photos.tagging.shared.layout.InsetContainerBounds;
import com.facebook.photos.tagging.shared.layout.LayoutableTagView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.PhotoButton;
import com.facebook.widget.listeners.BaseAnimationListener;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: slideshow */
public class TagView extends CustomFrameLayout implements LayoutableTagView {
    private static final ArrowDirection f2533e = ArrowDirection.UP;
    @VisibleForTesting
    final BubbleLayout f2534a = ((BubbleLayout) c(2131563716));
    @VisibleForTesting
    final FbTextView f2535b;
    @VisibleForTesting
    public final PhotoButton f2536c;
    @Inject
    public ViewHelperViewAnimatorFactory f2537d;
    public final boolean f2538f;
    public final boolean f2539g;
    public final C03002 f2540h;
    public VisibilityAnimator f2541i;
    public VisibilityAnimator f2542j;
    public SizeAnimation f2543k;
    public SizeAnimation f2544l;
    private OnGlobalLayoutListener f2545m;
    public int f2546n;
    private int f2547o;

    /* compiled from: slideshow */
    class C03131 implements Runnable {
        final /* synthetic */ TagView f2530a;

        /* compiled from: slideshow */
        class C03111 extends BaseAnimationListener {
            final /* synthetic */ C03131 f2528a;

            C03111(C03131 c03131) {
                this.f2528a = c03131;
            }

            public void onAnimationEnd(Animation animation) {
                this.f2528a.f2530a.f2541i.a(false);
                this.f2528a.f2530a.f2536c.setEnabled(true);
            }
        }

        /* compiled from: slideshow */
        class C03122 extends BaseAnimationListener {
            final /* synthetic */ C03131 f2529a;

            C03122(C03131 c03131) {
                this.f2529a = c03131;
            }

            public void onAnimationEnd(Animation animation) {
                this.f2529a.f2530a.f2541i.b(false);
                this.f2529a.f2530a.f2536c.setEnabled(false);
            }
        }

        C03131(TagView tagView) {
            this.f2530a = tagView;
        }

        public void run() {
            int width = this.f2530a.f2534a.getWidth() + this.f2530a.f2546n;
            this.f2530a.f2543k = new SizeAnimation(this.f2530a.f2534a, Dimension.WIDTH, Type.EXPAND, this.f2530a.f2534a.getWidth(), width);
            this.f2530a.f2543k.setDuration(150);
            this.f2530a.f2543k.setAnimationListener(new C03111(this));
            this.f2530a.f2544l = new SizeAnimation(this.f2530a.f2534a, Dimension.WIDTH, Type.COLLAPSE, this.f2530a.f2534a.getWidth(), width);
            this.f2530a.f2544l.setDuration(150);
            this.f2530a.f2544l.setAnimationListener(new C03122(this));
        }
    }

    /* compiled from: slideshow */
    public class C03142 implements OnClickListener {
        final /* synthetic */ TagView f2531a;

        public C03142(TagView tagView) {
            this.f2531a = tagView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -115010890);
            this.f2531a.f2542j.b(true);
            C03002 c03002 = this.f2531a.f2540h;
            EdgesModel a2 = c03002.f2499a.f2449b.m2671a(this.f2531a);
            Preconditions.checkNotNull(a2);
            boolean z = a2.b().b() != null && a2.b().b().g() == -776825814;
            ((MediaLogger) c03002.f2499a.f2455h.get()).a(TagScreen.CONSUMPTION, z);
            c03002.f2499a.f2456i.a("MediaTaggingControllerRemoveTag" + a2.b().c(), new C02981(c03002, a2), new C02992(c03002));
            Logger.a(2, EntryType.UI_INPUT_END, -1845134972, a);
        }
    }

    /* compiled from: slideshow */
    public class C03153 implements OnClickListener {
        final /* synthetic */ TagView f2532a;

        public C03153(TagView tagView) {
            this.f2532a = tagView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1445167442);
            this.f2532a.bringToFront();
            C03002 c03002 = this.f2532a.f2540h;
            TagView tagView = this.f2532a;
            boolean z = this.f2532a.f2538f;
            c03002.f2499a.f2449b.m2672a();
            if (!z) {
                EdgesModel a2 = c03002.f2499a.f2449b.m2671a(tagView);
                Preconditions.checkNotNull(a2);
                if (!(a2.b().b() == null || a2.b().b().g() == -776825814)) {
                    TaggingIntentControllerProvider taggingIntentControllerProvider = c03002.f2499a.f2454g;
                    TaggingIntentController taggingIntentController = new TaggingIntentController(c03002.f2499a.f2453f.getContext(), (UriIntentMapper) Fb4aUriIntentMapper.a(taggingIntentControllerProvider), (SecureContextHelper) DefaultSecureContextHelper.a(taggingIntentControllerProvider));
                    if (a2.b().b().g() == 105285582) {
                        taggingIntentController.m2657a(FBLinks.aP, a2.b().c());
                    } else if (a2.b().b().g() == 2479791) {
                        taggingIntentController.m2657a(FBLinks.af, a2.b().c());
                    } else if (a2.b().b().g() == 2645995) {
                        taggingIntentController.m2657a(FBLinks.aX, a2.b().c());
                    }
                }
            } else if (tagView.f2536c.isShown()) {
                tagView.startAnimation(tagView.f2544l);
            } else {
                tagView.startAnimation(tagView.f2543k);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -77277457, a);
        }
    }

    public static void m2654a(Object obj, Context context) {
        ((TagView) obj).f2537d = ViewHelperViewAnimatorFactory.a(FbInjector.get(context));
    }

    public TagView(Context context, boolean z, boolean z2, String str, C03002 c03002) {
        super(context, null);
        Class cls = TagView.class;
        m2654a((Object) this, getContext());
        setContentView(2130905177);
        this.f2538f = z;
        this.f2539g = z2;
        this.f2540h = c03002;
        this.f2534a.setArrowDirection(f2533e);
        this.f2535b = (FbTextView) c(2131563717);
        this.f2535b.setText(str);
        this.f2535b.setOnClickListener(new C03153(this));
        this.f2536c = (PhotoButton) c(2131563718);
        this.f2536c.setOnClickListener(new C03142(this));
        this.f2546n = Math.round(getResources().getDimension(2131430313));
        this.f2547o = Math.round(getResources().getDimension(2131430314));
        PhotoButton photoButton = this.f2536c;
        int i = (this.f2538f && this.f2539g) ? 0 : 8;
        photoButton.setVisibility(i);
        if (this.f2538f) {
            this.f2542j = new VisibilityAnimator(this, 200, true, this.f2537d);
            this.f2541i = new VisibilityAnimator(this.f2536c, 100, true, this.f2537d);
        }
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1593367637);
        super.onDetachedFromWindow();
        if (this.f2545m != null) {
            GlobalOnLayoutHelper.b(this, this.f2545m);
            this.f2545m = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 841462769, a);
    }

    public void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 875710773);
        super.onAttachedToWindow();
        if (this.f2538f) {
            this.f2545m = GlobalOnLayoutHelper.b(this, new C03131(this));
            LogUtils.g(285712091, a);
            return;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -162313317, a);
    }

    public final void m2656a(ArrowDirection arrowDirection, InsetContainerBounds insetContainerBounds) {
        this.f2534a.a(arrowDirection, insetContainerBounds);
        Rect rect = insetContainerBounds.b;
        rect.left -= this.f2547o;
        rect = insetContainerBounds.b;
        rect.right += this.f2547o;
        if (this.f2538f && this.f2536c.getVisibility() != 0) {
            rect = insetContainerBounds.b;
            rect.right += this.f2546n;
        }
        insetContainerBounds.a.set(insetContainerBounds.b);
    }

    public final void m2655a(int i) {
        if (this.f2534a.getWidth() > 0) {
            this.f2534a.setArrowPosition(0.5f + (((float) i) / ((float) this.f2534a.getWidth())));
        }
    }

    public void setArrowDirection(ArrowDirection arrowDirection) {
        this.f2534a.setArrowDirection(arrowDirection);
    }

    public ArrowDirection getArrowDirection() {
        return this.f2534a.k;
    }

    public int getArrowLength() {
        return (int) this.f2534a.b;
    }
}
