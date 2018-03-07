package com.facebook.resources.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: container_object_story */
public class ExpandingEllipsizingTextView extends EllipsizingTextView {
    private int f5250a;
    private ExpandState f5251b;
    private boolean f5252c;
    private int f5253d;
    private int f5254e;
    private Optional<OnExpandStateChangeListener> f5255f;

    /* compiled from: container_object_story */
    class C04931 implements OnClickListener {
        final /* synthetic */ ExpandingEllipsizingTextView f5249a;

        C04931(ExpandingEllipsizingTextView expandingEllipsizingTextView) {
            this.f5249a = expandingEllipsizingTextView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1282164880);
            this.f5249a.m10158a(true);
            Logger.a(2, EntryType.UI_INPUT_END, 637690396, a);
        }
    }

    /* compiled from: container_object_story */
    public enum ExpandState {
        EXPANDED,
        COLLAPSED
    }

    /* compiled from: container_object_story */
    public interface OnExpandStateChangeListener {
        void m10154a();

        void m10155b();
    }

    public ExpandingEllipsizingTextView(Context context) {
        super(context);
        m10156a(context, null);
    }

    public ExpandingEllipsizingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10156a(context, attributeSet);
    }

    public ExpandingEllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10156a(context, attributeSet);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        throw new UnsupportedOperationException("Can't override the onClickListener for this viewTry using EllipsizingTextView instead");
    }

    private void m10156a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandingEllipsizingTextView);
        this.f5253d = obtainStyledAttributes.getInteger(1, 10);
        this.f5252c = obtainStyledAttributes.getBoolean(0, false);
        this.f5254e = obtainStyledAttributes.getInteger(2, 500);
        obtainStyledAttributes.recycle();
        this.f5251b = ExpandState.COLLAPSED;
        this.f5255f = Absent.INSTANCE;
        this.f5250a = getMaxLines();
        super.setOnClickListener(new C04931(this));
    }

    public void setOnExpandedStateChangeListener(@Nullable OnExpandStateChangeListener onExpandStateChangeListener) {
        this.f5255f = Optional.fromNullable(onExpandStateChangeListener);
    }

    public void setExpandState(ExpandState expandState) {
        if (this.f5251b != expandState) {
            m10158a(false);
        }
    }

    public ExpandState getExpandState() {
        return this.f5251b;
    }

    private void m10158a(boolean z) {
        if (this.f5251b == ExpandState.EXPANDED) {
            m10160c(z);
            this.f5251b = ExpandState.COLLAPSED;
            return;
        }
        m10159b(z);
        this.f5251b = ExpandState.EXPANDED;
    }

    private void m10159b(boolean z) {
        setMaxLines(Integer.MAX_VALUE);
        if (this.f5255f.isPresent() && z) {
            ((OnExpandStateChangeListener) this.f5255f.get()).m10154a();
        }
    }

    private void m10160c(boolean z) {
        if (this.f5252c && z) {
            setMaxLines(getLineCount());
            int lineCount = getLineCount() - this.f5250a;
            if (lineCount > 0) {
                ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "maxLines", new int[]{this.f5250a});
                ofInt.setDuration((long) Math.min(lineCount * this.f5253d, this.f5254e));
                ofInt.start();
            } else {
                setMaxLines(this.f5250a);
            }
        } else {
            setMaxLines(this.f5250a);
        }
        if (this.f5255f.isPresent() && z) {
            ((OnExpandStateChangeListener) this.f5255f.get()).m10155b();
        }
    }
}
