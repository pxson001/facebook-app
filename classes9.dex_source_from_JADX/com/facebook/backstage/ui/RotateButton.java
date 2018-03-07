package com.facebook.backstage.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.facebook.backstage.StacksConstants;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;

/* compiled from: search_button */
public class RotateButton extends ImageView {
    public final Spring f5497a;
    public RotateButtonListener f5498b;
    public double f5499c;

    /* compiled from: search_button */
    public interface RotateButtonListener {
        void mo144a();

        void mo145a(float f);
    }

    /* compiled from: search_button */
    class C05821 implements OnClickListener {
        final /* synthetic */ RotateButton f5495a;

        C05821(RotateButton rotateButton) {
            this.f5495a = rotateButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 749495563);
            RotateButton.m5730a(this.f5495a, 180.0d);
            this.f5495a.f5497a.b(this.f5495a.f5499c);
            if (this.f5495a.f5498b != null) {
                this.f5495a.f5498b.mo144a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -585608734, a);
        }
    }

    /* compiled from: search_button */
    class RotateSpringListener extends SimpleSpringListener {
        final /* synthetic */ RotateButton f5496a;

        public RotateSpringListener(RotateButton rotateButton) {
            this.f5496a = rotateButton;
        }

        public final void m5728a(Spring spring) {
            this.f5496a.setRotation((float) spring.b());
            if (this.f5496a.f5498b != null) {
                this.f5496a.f5498b.mo145a((float) spring.b());
            }
        }
    }

    static /* synthetic */ double m5730a(RotateButton rotateButton, double d) {
        double d2 = rotateButton.f5499c - d;
        rotateButton.f5499c = d2;
        return d2;
    }

    public RotateButton(Context context) {
        this(context, null);
    }

    public RotateButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RotateButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5497a = SpringSystem.b().a();
        this.f5497a.a(StacksConstants.f4251a);
        this.f5497a.a(new RotateSpringListener(this));
        setOnClickListener(new C05821(this));
    }

    public void setListener(RotateButtonListener rotateButtonListener) {
        this.f5498b = rotateButtonListener;
    }
}
