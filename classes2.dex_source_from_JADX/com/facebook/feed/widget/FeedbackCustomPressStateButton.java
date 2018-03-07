package com.facebook.feed.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.widget.springbutton.TouchSpring;
import com.facebook.widget.springbutton.TouchSpring.TouchSpringUpdateListener;
import javax.annotation.Nullable;

/* compiled from: gk/ */
public class FeedbackCustomPressStateButton extends ImageWithTextView implements TouchSpringUpdateListener {
    public static final int f22330a = 2130840220;
    public static final int f22331b = 2130843499;
    private static final int f22332c = 2130772571;
    private DownstateType f22333d;
    private int f22334e;
    private BackgroundResourceCache f22335f;
    @Nullable
    public OnTouchListener f22336g;
    @Nullable
    public TouchSpring f22337h;

    /* compiled from: gk/ */
    public class BackgroundResourceCache {
        private View f22338a;
        private int f22339b;
        private int f22340c = 0;
        private Drawable f22341d;

        public BackgroundResourceCache(View view) {
            this.f22338a = view;
        }

        public final void m30275a(int i) {
            if (i != 0) {
                this.f22340c = i;
                this.f22341d = this.f22338a.getResources().getDrawable(i);
            }
        }

        public final void m30276b(int i) {
            if (i == 0 || i != this.f22339b) {
                if (i == 0 || i != this.f22340c) {
                    this.f22338a.setBackgroundResource(i);
                } else {
                    this.f22338a.setBackgroundDrawable(this.f22341d);
                }
                this.f22339b = i;
            }
        }
    }

    /* compiled from: gk/ */
    class C09071 implements OnTouchListener {
        final /* synthetic */ FeedbackCustomPressStateButton f22342a;

        C09071(FeedbackCustomPressStateButton feedbackCustomPressStateButton) {
            this.f22342a = feedbackCustomPressStateButton;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.f22342a.f22336g != null) {
                this.f22342a.f22336g.onTouch(view, motionEvent);
            }
            if (this.f22342a.f22337h != null) {
                return this.f22342a.f22337h.onTouch(view, motionEvent);
            }
            return false;
        }
    }

    /* compiled from: gk/ */
    /* synthetic */ class C09172 {
        static final /* synthetic */ int[] f22491a = new int[DownstateType.values().length];

        static {
            try {
                f22491a[DownstateType.NEWSFEED_SHADOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22491a[DownstateType.SUBSTORY_SHADOW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public FeedbackCustomPressStateButton(Context context) {
        this(context, null);
    }

    public FeedbackCustomPressStateButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedbackCustomPressStateButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22333d = DownstateType.NEWSFEED_SHADOW;
        this.f22335f = new BackgroundResourceCache(this);
        TrackingNodes.m27141a((View) this, TrackingNode.FEEDBACK_SECTION);
        TrackingNodes.m27141a((View) this, TrackingNode.ACTION_ICON);
        super.setOnTouchListener(new C09071(this));
    }

    public void setWarmupBackgroundResId(int i) {
        this.f22335f.m30275a(i);
    }

    public void setDrawable(int i) {
        if (i == 0 || i != this.f22334e) {
            setImageResource(i);
            this.f22334e = i;
        }
    }

    public void setDownstateType(DownstateType downstateType) {
        this.f22333d = downstateType;
        if (this.f22333d != null) {
            this.f22335f.m30276b(getBackgroundResource());
        }
    }

    private int getBackgroundResource() {
        int i;
        int i2;
        switch (C09172.f22491a[this.f22333d.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                i = f22330a;
                i2 = i;
                i = f22332c;
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                i2 = f22331b;
                i = 0;
                break;
            default:
                throw new IllegalArgumentException("Unknown DownState type");
        }
        if (i == 0) {
            return i2;
        }
        return ContextUtils.m2501b(getContext(), i, i2);
    }

    public void setSpring(TouchSpring touchSpring) {
        touchSpring.m30311a((TouchSpringUpdateListener) this);
        this.f22337h = touchSpring;
    }

    public TouchSpring getSpring() {
        return this.f22337h;
    }

    public final void mo3275b() {
        if (this.f22337h != null) {
            this.f22337h.m30309a();
            this.f22337h = null;
        }
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f22336g = onTouchListener;
    }

    public final void mo3274a(float f) {
        setImageScaleX(f);
        setImageScaleY(f);
    }
}
