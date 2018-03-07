package com.facebook.messaging.media.mediatray;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.media.mediatray.MediaTrayPopupVideoView.Listener;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.photoeditor.IsPhotoEditorEnabled;
import com.facebook.qe.api.QeAccessor;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.images.effects.Blur;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceScheme;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.ScaleViewUtil;
import com.facebook.widget.SquareFrameLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@TargetApi(11)
/* compiled from: security_checkup_login_alerts */
public class MediaTrayItemViewHolder extends ViewHolder {
    public Type f3054A;
    public ClickListener f3055B;
    public MediaTrayLoader$Item f3056C;
    public MediaResource f3057D;
    private final SpringSystem f3058l;
    @IsPhotoEditorEnabled
    public final Provider<Boolean> f3059m;
    public final FbDraweeControllerBuilder f3060n;
    public final Spring f3061o;
    private final ValueAnimator f3062p = ValueAnimator.ofFloat(new float[]{1.0f, 0.98f}).setDuration(100);
    private SquareFrameLayout f3063q;
    public View f3064r;
    public View f3065s;
    public View f3066t;
    public FbDraweeView f3067u;
    @Nullable
    public MediaTrayPopupVideoView f3068v;
    public ImageView f3069w;
    public boolean f3070x;
    public boolean f3071y;
    public Bitmap f3072z;

    /* compiled from: security_checkup_login_alerts */
    public interface ClickListener {
        @Nullable
        ThreadKey mo105a();

        void mo106a(MediaTrayItemViewHolder mediaTrayItemViewHolder, int i);

        void mo107a(MediaTrayLoader$Item mediaTrayLoader$Item, int i);

        void mo108b(MediaTrayLoader$Item mediaTrayLoader$Item, int i);
    }

    /* compiled from: security_checkup_login_alerts */
    class C04971 implements Listener {
        final /* synthetic */ MediaTrayItemViewHolder f3047a;

        C04971(MediaTrayItemViewHolder mediaTrayItemViewHolder) {
            this.f3047a = mediaTrayItemViewHolder;
        }

        public final void mo109a() {
            this.f3047a.f3066t.setVisibility(0);
        }
    }

    /* compiled from: security_checkup_login_alerts */
    class C04982 implements OnClickListener {
        final /* synthetic */ MediaTrayItemViewHolder f3048a;

        C04982(MediaTrayItemViewHolder mediaTrayItemViewHolder) {
            this.f3048a = mediaTrayItemViewHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 154185067);
            this.f3048a.f3055B.mo107a(this.f3048a.f3056C, this.f3048a.e());
            Logger.a(2, EntryType.UI_INPUT_END, -575726954, a);
        }
    }

    /* compiled from: security_checkup_login_alerts */
    class C04993 implements OnClickListener {
        final /* synthetic */ MediaTrayItemViewHolder f3049a;

        C04993(MediaTrayItemViewHolder mediaTrayItemViewHolder) {
            this.f3049a = mediaTrayItemViewHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 647578741);
            this.f3049a.f3055B.mo108b(this.f3049a.f3056C, this.f3049a.e());
            Logger.a(2, EntryType.UI_INPUT_END, 428020515, a);
        }
    }

    /* compiled from: security_checkup_login_alerts */
    class C05004 implements OnClickListener {
        final /* synthetic */ MediaTrayItemViewHolder f3050a;

        C05004(MediaTrayItemViewHolder mediaTrayItemViewHolder) {
            this.f3050a = mediaTrayItemViewHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1217965652);
            this.f3050a.f3055B.mo106a(this.f3050a, this.f3050a.e());
            Logger.a(2, EntryType.UI_INPUT_END, 582064015, a);
        }
    }

    /* compiled from: security_checkup_login_alerts */
    class C05015 implements AnimatorUpdateListener {
        final /* synthetic */ MediaTrayItemViewHolder f3051a;

        C05015(MediaTrayItemViewHolder mediaTrayItemViewHolder) {
            this.f3051a = mediaTrayItemViewHolder;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f3051a.f3067u.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
            this.f3051a.f3067u.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            if (this.f3051a.f3068v != null) {
                this.f3051a.f3068v.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f3051a.f3068v.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        }
    }

    /* compiled from: security_checkup_login_alerts */
    public class C05026 extends BaseControllerListener {
        final /* synthetic */ MediaTrayItemViewHolder f3052a;

        public C05026(MediaTrayItemViewHolder mediaTrayItemViewHolder) {
            this.f3052a = mediaTrayItemViewHolder;
        }

        public final void m3018a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            boolean z;
            CloseableImage closeableImage = (CloseableImage) obj;
            MediaTrayItemViewHolder mediaTrayItemViewHolder = this.f3052a;
            if (closeableImage != null) {
                z = true;
            } else {
                z = false;
            }
            mediaTrayItemViewHolder.f3070x = z;
            if (this.f3052a.f3071y && animatable != null) {
                animatable.start();
            }
        }

        public final void m3019b(String str, Throwable th) {
            this.f3052a.f3066t.setVisibility(0);
        }
    }

    /* compiled from: security_checkup_login_alerts */
    class ImageSpringListener extends SimpleSpringListener {
        final /* synthetic */ MediaTrayItemViewHolder f3053a;

        public final void m3021b(Spring spring) {
            if (spring.i == 0.0d) {
                this.f3053a.f3069w.setVisibility(8);
            }
        }

        public ImageSpringListener(MediaTrayItemViewHolder mediaTrayItemViewHolder) {
            this.f3053a = mediaTrayItemViewHolder;
        }

        public final void m3020a(Spring spring) {
            float d = (float) spring.d();
            float f = 1.0f + (0.25f * d);
            this.f3053a.f3067u.setScaleX(f);
            this.f3053a.f3067u.setScaleY(f);
            this.f3053a.f3069w.setScaleX(f);
            this.f3053a.f3069w.setScaleY(f);
            this.f3053a.f3069w.setAlpha(d);
        }
    }

    @Inject
    public MediaTrayItemViewHolder(QeAccessor qeAccessor, SpringSystem springSystem, Provider<Boolean> provider, FbDraweeControllerBuilder fbDraweeControllerBuilder, @Assisted SquareFrameLayout squareFrameLayout, @Assisted Type type) {
        super(squareFrameLayout);
        this.f3063q = squareFrameLayout;
        this.f3058l = springSystem;
        this.f3059m = provider;
        this.f3060n = fbDraweeControllerBuilder;
        boolean z = type == Type.VIDEO || type == Type.PHOTO;
        Preconditions.checkArgument(z);
        this.f3054A = type;
        this.f3067u = (FbDraweeView) squareFrameLayout.findViewById(2131562910);
        this.f3064r = squareFrameLayout.findViewById(2131563756);
        this.f3065s = squareFrameLayout.findViewById(qeAccessor.a(ExperimentsForMediaTrayModule.f3024a, false) ? 2131563752 : 2131563754);
        this.f3066t = squareFrameLayout.findViewById(2131563743);
        this.f3069w = (ImageView) squareFrameLayout.findViewById(2131563751);
        this.f3061o = this.f3058l.a().a(SpringConfig.a(100.0d, 7.0d)).a(new ImageSpringListener(this));
        if (this.f3054A == Type.VIDEO) {
            this.f3068v = (MediaTrayPopupVideoView) ((ViewStub) squareFrameLayout.findViewById(2131563749)).inflate();
            this.f3068v.f3142i = new C04971(this);
        }
        this.f3064r.setOnClickListener(new C04982(this));
        this.f3065s.setOnClickListener(new C04993(this));
        this.f3063q.setOnClickListener(new C05004(this));
        this.f3062p.setInterpolator(new LinearInterpolator());
        this.f3062p.addUpdateListener(new C05015(this));
    }

    public final void m3024b(EventTriggerType eventTriggerType) {
        if (this.f3054A == Type.VIDEO) {
            this.f3068v.m3115b(eventTriggerType);
        } else if (this.f3054A == Type.PHOTO) {
            Animatable g = this.f3067u.getController().g();
            if (g != null) {
                g.stop();
            }
        }
        this.f3071y = false;
    }

    public final void m3027x() {
        Object obj;
        this.f3064r.setVisibility(0);
        Object obj2 = null;
        if (this.f3054A == Type.PHOTO && ((Boolean) this.f3059m.get()).booleanValue() && !this.f3057D.c()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null || this.f3054A == Type.VIDEO) {
            MediaResourceScheme fromOrNull = MediaResourceScheme.fromOrNull(this.f3057D);
            if (fromOrNull != null && fromOrNull.isLikelyLocal()) {
                obj2 = 1;
            }
        }
        if (obj2 != null) {
            this.f3065s.setVisibility(0);
            this.a.findViewById(2131563755).setVisibility(0);
        }
        m3022C();
    }

    public final boolean m3028z() {
        return this.f3057D != null && this.f3070x;
    }

    final void m3025b(boolean z) {
        m3023a(z, true);
    }

    public final void m3026c(boolean z) {
        m3023a(z, false);
    }

    private void m3023a(boolean z, boolean z2) {
        this.f3065s.setVisibility(z ? 0 : 8);
        if (!z2) {
            this.f3062p.setCurrentPlayTime(z ? 100 : 0);
        } else if (z) {
            this.f3062p.start();
        } else {
            this.f3062p.reverse();
        }
    }

    private void m3022C() {
        Bitmap bitmap;
        Drawable topLevelDrawable = this.f3067u.getTopLevelDrawable();
        LayoutParams a = ScaleViewUtil.a(this.a.getHeight() / 6, topLevelDrawable.getBounds().width(), topLevelDrawable.getBounds().height());
        int i = a.width;
        int i2 = a.height;
        if (!(this.f3072z != null && this.f3072z.getWidth() == i && this.f3072z.getHeight() == i2)) {
            if (this.f3072z != null) {
                this.f3072z.recycle();
            }
            this.f3072z = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(this.f3072z);
        Paint paint = new Paint();
        paint.setFilterBitmap(true);
        paint.setAntiAlias(true);
        canvas.scale(((float) i) / ((float) topLevelDrawable.getBounds().width()), ((float) i2) / ((float) topLevelDrawable.getBounds().height()));
        topLevelDrawable.draw(canvas);
        Bitmap bitmap2 = this.f3072z;
        if (3 <= null) {
            bitmap = null;
        } else {
            bitmap = bitmap2.copy(bitmap2.getConfig(), true);
            Blur.b(bitmap, 3);
        }
        this.f3069w.setImageBitmap(bitmap);
        this.f3069w.setVisibility(0);
        Spring spring = this.f3061o;
        spring.c = false;
        spring.b(1.0d);
    }
}
