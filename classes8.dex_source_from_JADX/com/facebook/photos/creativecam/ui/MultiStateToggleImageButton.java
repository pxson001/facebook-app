package com.facebook.photos.creativecam.ui;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.List;
import java.util.Map.Entry;

/* compiled from: sslx */
public class MultiStateToggleImageButton extends ImageView {
    private int f2263a = 0;
    private List<Entry<String, Integer>> f2264b;

    public MultiStateToggleImageButton(Context context) {
        super(context);
        m2408a();
    }

    public MultiStateToggleImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2408a();
    }

    public MultiStateToggleImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2408a();
    }

    private void m2408a() {
        setClickable(true);
    }

    public void setStates(List<Entry<String, Integer>> list) {
        this.f2264b = list;
        invalidate();
    }

    private void setCurrentStateIndex(int i) {
        if (this.f2264b == null) {
            throw new RuntimeException("States not initialised");
        } else if (i < 0 || i >= this.f2264b.size()) {
            throw new IllegalArgumentException("index must be in range of states");
        } else {
            this.f2263a = i;
            setImageDrawable(ContextCompat.a(getContext(), ((Integer) ((Entry) this.f2264b.get(i)).getValue()).intValue()));
        }
    }

    public void setCurrentState(String str) {
        for (int i = 0; i < this.f2264b.size(); i++) {
            if (str.equals(((Entry) this.f2264b.get(i)).getKey())) {
                setCurrentStateIndex(i);
                return;
            }
        }
    }

    public String getCurrentStateId() {
        return (String) ((Entry) this.f2264b.get(this.f2263a)).getKey();
    }

    public boolean performClick() {
        setCurrentStateIndex((this.f2263a + 1) % this.f2264b.size());
        return super.performClick();
    }
}
