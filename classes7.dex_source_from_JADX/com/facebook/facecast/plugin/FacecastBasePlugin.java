package com.facebook.facecast.plugin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.facecast.FacecastStateManager;
import com.facebook.widget.CustomRelativeLayout;
import com.google.common.base.Preconditions;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: broadcast_transition_from */
public class FacecastBasePlugin extends CustomRelativeLayout {
    public ViewGroup f18165a;
    public FacecastStateManager f18166b;
    public boolean f18167c;
    public final List<View> f18168d;

    public FacecastBasePlugin(Context context) {
        this(context, null);
    }

    public FacecastBasePlugin(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FacecastBasePlugin(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18168d = new LinkedList();
    }

    public final void m21948a(ViewGroup viewGroup, FacecastStateManager facecastStateManager, int i) {
        this.f18165a = (ViewGroup) Preconditions.checkNotNull(viewGroup);
        this.f18166b = (FacecastStateManager) Preconditions.checkNotNull(facecastStateManager);
        if (i == -1 || i > this.f18165a.getChildCount()) {
            i = this.f18165a.getChildCount();
        } else if (i < 0) {
            i = 0;
        }
        if (getChildCount() == 0) {
            View view = new View(getContext());
            view.setVisibility(8);
            addView(view, 0, 0);
        }
        int i2 = 0;
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            removeView(childAt);
            this.f18165a.addView(childAt, i + i2);
            i2++;
            this.f18168d.add(childAt);
        }
        this.f18167c = true;
        hE_();
    }

    public final void m21950c() {
        if (this.f18167c) {
            Preconditions.checkNotNull(this.f18165a);
            Preconditions.checkNotNull(this.f18166b);
            while (!this.f18168d.isEmpty()) {
                View view = (View) this.f18168d.remove(0);
                this.f18165a.removeView(view);
                ViewParent parent = view.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(view);
                }
                addView(view);
            }
            ViewGroup viewGroup = this.f18165a;
            FacecastStateManager facecastStateManager = this.f18166b;
            this.f18165a = null;
            this.f18166b = null;
            this.f18167c = false;
            mo1408a(viewGroup, facecastStateManager);
        }
    }

    public void setVisibility(int i) {
        for (View visibility : this.f18168d) {
            visibility.setVisibility(i);
        }
    }

    public void mo1413d() {
    }

    public void mo1419e() {
    }

    public boolean mo1409a() {
        return false;
    }

    public final void m21953f() {
        for (View bringToFront : this.f18168d) {
            bringToFront.bringToFront();
        }
    }

    @Nullable
    public Map<String, String> getLoggingInfo() {
        return null;
    }

    protected void hE_() {
    }

    protected void mo1408a(ViewGroup viewGroup, FacecastStateManager facecastStateManager) {
    }
}
