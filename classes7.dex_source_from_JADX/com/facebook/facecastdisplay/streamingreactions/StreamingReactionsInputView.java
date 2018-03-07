package com.facebook.facecastdisplay.streamingreactions;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.auth.module.String_ViewerContextUserIdMethodAutoProvider;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.feedback.reactions.ui.FeedbackReactionsController;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: start() should be called before calling getFingerprintBuffer() */
public class StreamingReactionsInputView extends CustomLinearLayout {
    @Inject
    FeedbackReactionsController f3379a;
    @Inject
    StreamingReactionsInputMutator f3380b;
    @Inject
    MonotonicClock f3381c;
    private final int f3382d;
    private final int f3383e;
    private final List<FacecastReactionView> f3384f;
    private final int f3385g;
    private final Paint f3386h;
    public GraphQLStory f3387i;
    @Nullable
    public LiveReactionsListener f3388j;
    private int f3389k;
    private int f3390l;
    public long f3391m;
    public float f3392n;

    /* compiled from: start() should be called before calling getFingerprintBuffer() */
    class C02931 implements OnClickListener {
        final /* synthetic */ StreamingReactionsInputView f3376a;

        C02931(StreamingReactionsInputView streamingReactionsInputView) {
            this.f3376a = streamingReactionsInputView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -221062887);
            this.f3376a.m4111a(view);
            int i = ((FacecastReactionView) view).f3294a;
            long now = this.f3376a.f3381c.now();
            if (now - this.f3376a.f3391m > 400 && this.f3376a.f3387i != null) {
                this.f3376a.f3380b.m4107a(i, this.f3376a.f3387i, (int) this.f3376a.f3392n);
                this.f3376a.f3391m = now;
            }
            if (this.f3376a.f3388j != null) {
                this.f3376a.f3388j.mo1445a(i, now == this.f3376a.f3391m);
            }
            LogUtils.a(1447097712, a);
        }
    }

    /* compiled from: start() should be called before calling getFingerprintBuffer() */
    public interface LiveReactionsListener {
        void mo1445a(int i, boolean z);
    }

    private static <T extends View> void m4114a(Class<T> cls, T t) {
        m4115a((Object) t, t.getContext());
    }

    private static void m4115a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((StreamingReactionsInputView) obj).m4113a(FeedbackReactionsController.a(fbInjector), new StreamingReactionsInputMutator(GraphQLQueryExecutor.a(fbInjector), String_ViewerContextUserIdMethodAutoProvider.b(fbInjector), (Clock) SystemClockMethodAutoProvider.a(fbInjector)), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(fbInjector));
    }

    public StreamingReactionsInputView(Context context) {
        this(context, null);
    }

    public StreamingReactionsInputView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StreamingReactionsInputView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3389k = -1;
        this.f3390l = -1;
        this.f3392n = 0.0f;
        m4114a(StreamingReactionsInputView.class, (View) this);
        setOrientation(0);
        this.f3382d = getResources().getDimensionPixelSize(2131428050);
        this.f3383e = getResources().getDimensionPixelSize(2131428051);
        this.f3384f = new ArrayList();
        this.f3385g = getResources().getDimensionPixelSize(2131428052);
        this.f3386h = new Paint();
        this.f3386h.setStyle(Style.FILL);
        this.f3386h.setColor(ContextCompat.b(context, 2131361917));
        setWillNotDraw(false);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3389k >= 0 && this.f3390l >= 0) {
            canvas.drawCircle((float) this.f3389k, (float) this.f3390l, (float) (this.f3385g / 2), this.f3386h);
        }
    }

    public void setStory(GraphQLStory graphQLStory) {
        List c;
        this.f3387i = (GraphQLStory) Preconditions.a(graphQLStory);
        Preconditions.a(graphQLStory.l());
        for (FacecastReactionView removeView : this.f3384f) {
            removeView(removeView);
        }
        this.f3384f.clear();
        this.f3389k = -1;
        this.f3390l = -1;
        ImmutableList a = this.f3379a.a(this.f3387i.l().K());
        if (a == null) {
            c = this.f3379a.c();
        } else {
            c = a;
        }
        for (int i = 0; i < c.size(); i++) {
            int i2;
            int i3;
            int i4 = ((FeedbackReaction) c.get(i)).e;
            FeedbackReaction b = this.f3379a.b(i4);
            final View facecastReactionView = new FacecastReactionView(getContext());
            facecastReactionView.setReaction(b);
            facecastReactionView.setClickable(true);
            facecastReactionView.setOnClickListener(new C02931(this));
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.height = this.f3382d;
            generateDefaultLayoutParams.width = this.f3382d;
            if (i == 0) {
                i2 = 0;
            } else {
                i2 = this.f3383e / 2;
            }
            int i5 = this.f3383e;
            if (i == c.size() - 1) {
                i3 = 0;
            } else {
                i3 = this.f3383e / 2;
            }
            generateDefaultLayoutParams.setMargins(i2, i5, i3, this.f3383e);
            addView(facecastReactionView, generateDefaultLayoutParams);
            this.f3384f.add(facecastReactionView);
            facecastReactionView.setContentDescription(b.f);
            if (this.f3387i.l().S() == i4) {
                post(new Runnable(this) {
                    final /* synthetic */ StreamingReactionsInputView f3378b;

                    public void run() {
                        this.f3378b.m4111a(facecastReactionView);
                    }
                });
            }
        }
    }

    public void setListener(LiveReactionsListener liveReactionsListener) {
        this.f3388j = liveReactionsListener;
    }

    public void setVideoTime(float f) {
        this.f3392n = f;
    }

    public int getVisibleWidth() {
        return (int) ((((double) this.f3382d) * 1.5d) + ((double) this.f3383e));
    }

    public View getLeftMostReactionView() {
        return (View) this.f3384f.get(0);
    }

    private void m4111a(View view) {
        this.f3389k = (int) (view.getX() + ((float) (view.getWidth() / 2)));
        this.f3390l = getHeight();
        invalidate();
    }

    private void m4113a(FeedbackReactionsController feedbackReactionsController, StreamingReactionsInputMutator streamingReactionsInputMutator, MonotonicClock monotonicClock) {
        this.f3379a = feedbackReactionsController;
        this.f3380b = streamingReactionsInputMutator;
        this.f3381c = monotonicClock;
    }
}
