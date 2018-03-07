package com.facebook.saved.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: is_hidden */
public class SavedDashboardEmptyView extends CustomLinearLayout {
    private TextView f9335a;
    private ImageView f9336b;
    private boolean f9337c = false;
    private OnEmptyViewReadyListener f9338d;

    /* compiled from: is_hidden */
    public interface OnEmptyViewReadyListener {
        void mo416a();
    }

    public SavedDashboardEmptyView(Context context) {
        super(context);
        m9494c();
    }

    public SavedDashboardEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9494c();
    }

    private void m9494c() {
        setContentView(2130904828);
        this.f9335a = (TextView) a(2131563034);
        this.f9336b = (ImageView) a(2131563033);
        setGravity(17);
        setOrientation(1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131432251);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.f9337c = false;
    }

    public void setTitle(int i) {
        this.f9335a.setText(i);
    }

    public void setIcon(int i) {
        this.f9336b.setImageResource(i);
    }

    public final void m9495a() {
        this.f9335a.setVisibility(8);
        this.f9336b.setVisibility(8);
    }

    public final void m9496b() {
        this.f9335a.setVisibility(0);
        this.f9336b.setVisibility(0);
    }

    public void setOnEmptyViewReadyListener(OnEmptyViewReadyListener onEmptyViewReadyListener) {
        if (this.f9337c) {
            onEmptyViewReadyListener.mo416a();
        } else {
            this.f9338d = onEmptyViewReadyListener;
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f9338d != null) {
            this.f9338d.mo416a();
        }
        this.f9338d = null;
        this.f9337c = true;
    }
}
