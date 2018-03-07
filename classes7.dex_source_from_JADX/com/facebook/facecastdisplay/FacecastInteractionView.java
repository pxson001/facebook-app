package com.facebook.facecastdisplay;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.facebook.facecastdisplay.LiveFeedbackInputViewContainer.LiveFeedbackInputViewContainerListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: submit_claim */
public class FacecastInteractionView extends CustomRelativeLayout implements LiveFeedbackInputViewContainerListener {
    @Inject
    public FacecastUtil f2813a;
    public final LiveEventsTickerView f2814b;
    private final ViewStub f2815c;
    private final View f2816d;
    @Nullable
    public FrameLayout f2817e;
    @Nullable
    private LiveFeedbackInputView f2818f;
    @Nullable
    private FbTextView f2819g;
    @Nullable
    private FacecastInteractionViewListener f2820h;
    public double f2821i;

    /* compiled from: submit_claim */
    class FacecastInteractionFullScreenOverlayDrawable extends ShapeDrawable {
        public FacecastInteractionFullScreenOverlayDrawable(Resources resources) {
            super(new RectShape());
            setShaderFactory(m3078a(resources));
        }

        private ShaderFactory m3078a(Resources resources) {
            final int[] iArr = new int[]{0, 0, resources.getColor(2131362600)};
            final float[] fArr = new float[]{0.0f, 0.5f, 1.0f};
            return new ShaderFactory(this) {
                final /* synthetic */ FacecastInteractionFullScreenOverlayDrawable f2812c;

                public Shader resize(int i, int i2) {
                    return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, iArr, fArr, TileMode.CLAMP);
                }
            };
        }
    }

    private static <T extends View> void m3082a(Class<T> cls, T t) {
        m3083a((Object) t, t.getContext());
    }

    private static void m3083a(Object obj, Context context) {
        ((FacecastInteractionView) obj).f2813a = FacecastUtil.m3107b(FbInjector.get(context));
    }

    private void m3081a(FacecastUtil facecastUtil) {
        this.f2813a = facecastUtil;
    }

    public FacecastInteractionView(Context context) {
        this(context, null);
    }

    public FacecastInteractionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FacecastInteractionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2821i = 1.0d;
        m3082a(FacecastInteractionView.class, (View) this);
        setContentView(2130904220);
        this.f2814b = (LiveEventsTickerView) a(2131561690);
        this.f2815c = (ViewStub) a(2131561687);
        this.f2816d = a(2131561688);
        this.f2816d.setBackgroundDrawable(new FacecastInteractionFullScreenOverlayDrawable(getResources()));
        if (this.f2813a.f2822a.a(886, false)) {
            ((ViewStub) a(2131561691)).inflate();
            this.f2814b.setVisibility(8);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1784665797);
        super.onSizeChanged(i, i2, i3, i4);
        m3080a(i, i2);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1896200826, a);
    }

    public void setVideoAspectRatio(double d) {
        this.f2821i = d;
        if (getWidth() != 0 && getHeight() != 0) {
            m3080a(getWidth(), getHeight());
        }
    }

    public void setStoryForViewer(FeedProps<GraphQLStory> feedProps) {
        this.f2814b.setStoryForViewer(feedProps);
        if (((GraphQLStory) feedProps.a).l() != null) {
            if (this.f2817e == null) {
                this.f2817e = (FrameLayout) this.f2815c.inflate();
                this.f2818f = (LiveFeedbackInputView) this.f2817e.findViewById(2131563482);
                this.f2819g = (FbTextView) this.f2817e.findViewById(2131563483);
            }
            this.f2818f.setStory(feedProps);
            this.f2818f.setListener(this);
            this.f2818f.setVisibility(0);
            return;
        }
        this.f2815c.setVisibility(8);
    }

    public void setVideoIdForBroadcaster(String str) {
        this.f2814b.setVideoIdForBroadcaster(str);
    }

    public void setFullScreenMode(boolean z) {
        this.f2816d.setVisibility(z ? 0 : 8);
        this.f2814b.setFullScreenMode(z);
    }

    public void setStoryForContext(FeedProps<GraphQLStory> feedProps) {
        this.f2814b.setStoryForContext(feedProps);
    }

    public final void m3087a() {
        boolean z;
        this.f2814b.m3302d();
        LiveEventsTickerView liveEventsTickerView = this.f2814b;
        if (this.f2818f == null) {
            z = false;
        } else {
            z = this.f2818f.m22441c();
        }
        liveEventsTickerView.f3037y = z;
    }

    public final void m3092b() {
        this.f2814b.m3303e();
        m3086g();
        this.f2814b.m3301c();
    }

    public void setListener(FacecastInteractionViewListener facecastInteractionViewListener) {
        this.f2820h = facecastInteractionViewListener;
        this.f2814b.setListener(facecastInteractionViewListener);
    }

    public final void m3093c() {
        if (this.f2818f != null) {
            this.f2818f.m22439a();
        }
    }

    private void m3086g() {
        if (this.f2818f != null) {
            this.f2818f.m22440b();
        }
    }

    public final void m3091a(boolean z) {
        this.f2814b.m3299a(z);
    }

    public void setVideoTime(float f) {
        this.f2814b.setVideoTime(f);
        if (this.f2818f != null) {
            this.f2818f.setVideoTime(f);
        }
    }

    public final void m3094d() {
        if (this.f2818f != null) {
            this.f2818f.setEnabled(true);
        }
        if (this.f2819g != null) {
            this.f2819g.setVisibility(8);
        }
    }

    public final void m3095e() {
        if (this.f2818f != null) {
            this.f2818f.setEnabled(false);
        }
        if (this.f2819g != null) {
            this.f2819g.setVisibility(0);
        }
    }

    public void setSuspended(boolean z) {
        this.f2814b.setSuspended(z);
    }

    public final void m3090a(String str, int i, LiveEventAuthor liveEventAuthor) {
        this.f2814b.m3297a(str, i, liveEventAuthor);
    }

    public final void mo116a(String str, float f) {
        this.f2814b.m3296a(str, f);
    }

    public final void mo115a(int i, boolean z) {
        if (this.f2820h != null) {
            this.f2820h.a(i, z);
        }
    }

    public final void mo117f() {
        if (this.f2820h != null) {
            this.f2820h.a();
        }
    }

    private void m3080a(final int i, final int i2) {
        post(new Runnable(this) {
            final /* synthetic */ FacecastInteractionView f2809c;

            public void run() {
                LayoutParams layoutParams = this.f2809c.f2814b.getLayoutParams();
                int min = i2 - Math.min(i, (int) (((double) i) / this.f2809c.f2821i));
                if (this.f2809c.f2817e != null) {
                    min -= this.f2809c.f2817e.getHeight();
                }
                layoutParams.height = min;
                this.f2809c.f2814b.setLayoutParams(layoutParams);
            }
        });
    }
}
