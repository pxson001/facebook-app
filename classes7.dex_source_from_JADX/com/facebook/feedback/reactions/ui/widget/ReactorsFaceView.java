package com.facebook.feedback.reactions.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.inject.Inject;

/* compiled from: send message graphql mutation failed */
public class ReactorsFaceView extends View {
    private static final CallerContext f4082b = CallerContext.a(ReactorsFaceView.class, "feedback_reactions");
    @Inject
    public FbDraweeControllerBuilder f4083a;
    private final DraweeHolder f4084c;
    private final GenericDraweeHierarchyBuilder f4085d;
    private final int f4086e;
    private final Paint f4087f;
    private Drawable f4088g;
    private Drawable f4089h;
    private boolean f4090i;
    private int f4091j;
    private int f4092k;
    private int f4093l;

    private static <T extends View> void m4698a(Class<T> cls, T t) {
        m4699a((Object) t, t.getContext());
    }

    private static void m4699a(Object obj, Context context) {
        ((ReactorsFaceView) obj).f4083a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public ReactorsFaceView(Context context) {
        this(context, null);
    }

    public ReactorsFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ReactorsFaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4092k = 0;
        this.f4093l = 0;
        m4698a(ReactorsFaceView.class, (View) this);
        Resources resources = context.getResources();
        this.f4085d = new GenericDraweeHierarchyBuilder(resources);
        this.f4084c = new DraweeHolder(this.f4085d.u());
        this.f4083a.a(f4082b);
        this.f4087f = new Paint(1);
        this.f4087f.setStyle(Style.FILL_AND_STROKE);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ReactorsFaceView, i, 0);
        this.f4092k = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f4090i = obtainStyledAttributes.getBoolean(1, false);
        this.f4087f.setColor(obtainStyledAttributes.getColor(3, resources.getColor(2131361920)));
        this.f4091j = obtainStyledAttributes.getDimensionPixelSize(2, resources.getDimensionPixelSize(2131430635));
        this.f4087f.setStrokeWidth((float) this.f4091j);
        this.f4086e = obtainStyledAttributes.getDimensionPixelSize(4, resources.getDimensionPixelSize(2131430618));
        obtainStyledAttributes.recycle();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -12225950);
        super.onAttachedToWindow();
        this.f4084c.b();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1095218820, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1096410033);
        super.onDetachedFromWindow();
        this.f4084c.d();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1895787963, a);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        this.f4084c.d();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        this.f4084c.b();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f4092k == 0 && MeasureSpec.getMode(i2) == 1073741824) {
            this.f4093l = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        } else {
            this.f4093l = this.f4092k;
        }
        int i3 = this.f4090i ? this.f4091j : 0;
        setMeasuredDimension(View.resolveSize((((this.f4093l + getPaddingLeft()) + getPaddingRight()) + this.f4086e) + i3, i), View.resolveSize(i3 + (((this.f4093l + getPaddingTop()) + getPaddingBottom()) + this.f4086e), i2));
        m4694a();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4088g != null) {
            this.f4088g.draw(canvas);
        }
        if (this.f4089h != null) {
            if (this.f4090i) {
                canvas.drawCircle((float) this.f4089h.getBounds().centerX(), (float) this.f4089h.getBounds().centerY(), (float) ((this.f4089h.getIntrinsicWidth() / 2) + (this.f4091j / 2)), this.f4087f);
            }
            this.f4089h.draw(canvas);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (this.f4088g == drawable || this.f4089h == drawable) {
            return true;
        }
        return super.verifyDrawable(drawable);
    }

    public void setFaceSize(int i) {
        if (this.f4092k != i) {
            this.f4092k = i;
            invalidate();
            requestLayout();
        }
    }

    public int getFaceSize() {
        return this.f4093l;
    }

    public final void m4700a(GraphQLActor graphQLActor, FeedbackReaction feedbackReaction) {
        m4697a(graphQLActor);
        m4696a(feedbackReaction);
        invalidate();
        requestLayout();
    }

    private void m4697a(GraphQLActor graphQLActor) {
        if (graphQLActor.ai() != null) {
            Uri parse = Uri.parse(graphQLActor.ai().b());
            if (parse != null) {
                this.f4084c.a(this.f4083a.b(parse).s());
                this.f4088g = this.f4084c.h();
            }
        } else {
            this.f4088g = getResources().getDrawable(2130838386);
        }
        if (this.f4088g != null) {
            this.f4088g.setCallback(this);
        }
    }

    private void m4696a(FeedbackReaction feedbackReaction) {
        if (feedbackReaction == FeedbackReaction.c || feedbackReaction == FeedbackReaction.d) {
            this.f4089h = null;
        } else {
            this.f4089h = feedbackReaction.e();
        }
        if (this.f4089h != null) {
            this.f4089h.setCallback(this);
        }
    }

    private void m4694a() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (this.f4088g != null) {
            this.f4088g.setBounds(paddingLeft, paddingTop, this.f4093l + paddingLeft, this.f4093l + paddingTop);
        }
        if (this.f4089h != null) {
            this.f4089h.setBounds(((this.f4093l + paddingLeft) - this.f4089h.getIntrinsicWidth()) + this.f4086e, ((this.f4093l + paddingTop) - this.f4089h.getIntrinsicHeight()) + this.f4086e, (paddingLeft + this.f4093l) + this.f4086e, (paddingTop + this.f4093l) + this.f4086e);
        }
    }

    private void m4695a(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f4083a = fbDraweeControllerBuilder;
    }
}
