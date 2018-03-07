package com.facebook.facecastdisplay;

import android.content.Context;
import android.support.v4.view.VelocityTrackerCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View.MeasureSpec;
import android.widget.HorizontalScrollView;
import com.facebook.common.internal.Preconditions;
import com.facebook.facecastdisplay.LiveFeedbackInputViewContainer.LiveFeedbackInputViewContainerListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: aux_message */
public class LiveFeedbackInputView extends HorizontalScrollView {
    private final LiveFeedbackInputViewContainer f18839a;
    private final VelocityTracker f18840b;

    public LiveFeedbackInputView(Context context) {
        this(context, null);
    }

    public LiveFeedbackInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveFeedbackInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(getContext()).inflate(2130905078, this);
        this.f18839a = (LiveFeedbackInputViewContainer) findViewById(2131563476);
        this.f18840b = VelocityTracker.obtain();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2083921405);
        super.onTouchEvent(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f18840b.clear();
                this.f18840b.addMovement(motionEvent);
                break;
            case 1:
                if ((VelocityTrackerCompat.a(this.f18840b, motionEvent.getPointerId(motionEvent.getActionIndex())) * -1.0f) + ((float) getScrollX()) <= ((float) (getWidth() / 2))) {
                    fullScroll(17);
                    break;
                }
                fullScroll(66);
                this.f18839a.m22496c();
                break;
            case 2:
                this.f18840b.addMovement(motionEvent);
                this.f18840b.computeCurrentVelocity(1000);
                break;
        }
        LogUtils.a(195839915, a);
        return true;
    }

    public void setListener(LiveFeedbackInputViewContainerListener liveFeedbackInputViewContainerListener) {
        this.f18839a.f18883u = liveFeedbackInputViewContainerListener;
    }

    public void setVideoTime(float f) {
        this.f18839a.setVideoTime(f);
    }

    public final void m22439a() {
        this.f18839a.m22494a();
    }

    public void setStory(FeedProps<GraphQLStory> feedProps) {
        Preconditions.a(((GraphQLStory) feedProps.a).l());
        this.f18839a.setStory(feedProps);
    }

    public final void m22440b() {
        this.f18839a.m22495b();
    }

    public final boolean m22441c() {
        return this.f18839a.f18861D;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f18839a.setEnabled(z);
        setVisibility(z ? 0 : 4);
    }

    protected void onMeasure(int i, int i2) {
        this.f18839a.f18888z = MeasureSpec.getSize(i);
        super.onMeasure(i, i2);
    }
}
