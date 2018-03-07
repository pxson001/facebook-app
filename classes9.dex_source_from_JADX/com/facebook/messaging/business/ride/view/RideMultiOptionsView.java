package com.facebook.messaging.business.ride.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: mmssms_quickfail_type */
public class RideMultiOptionsView extends CustomLinearLayout {
    private final ImageView f9352a;
    private final BetterTextView f9353b;
    private final BetterTextView f9354c;
    private final FbRelativeLayout f9355d;
    private final LinearLayout f9356e;
    private final ImageView f9357f;
    private final ImageView f9358g;
    private final BetterTextView f9359h;
    private final BetterTextView f9360i;
    private final ProgressBar f9361j;
    public Listener f9362k;

    /* compiled from: mmssms_quickfail_type */
    class C10851 implements OnClickListener {
        final /* synthetic */ RideMultiOptionsView f9348a;

        C10851(RideMultiOptionsView rideMultiOptionsView) {
            this.f9348a = rideMultiOptionsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1705995631);
            if (this.f9348a.f9362k != null) {
                this.f9348a.f9362k.mo331a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -639976160, a);
        }
    }

    /* compiled from: mmssms_quickfail_type */
    class C10862 implements OnClickListener {
        final /* synthetic */ RideMultiOptionsView f9349a;

        C10862(RideMultiOptionsView rideMultiOptionsView) {
            this.f9349a = rideMultiOptionsView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2072694509);
            if (this.f9349a.f9362k != null) {
                this.f9349a.f9362k.mo332b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1618130636, a);
        }
    }

    /* compiled from: mmssms_quickfail_type */
    public interface Listener {
        void mo331a();

        void mo332b();
    }

    public RideMultiOptionsView(Context context) {
        this(context, null);
    }

    public RideMultiOptionsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RideMultiOptionsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906890);
        this.f9352a = (ImageView) a(2131567056);
        this.f9353b = (BetterTextView) a(2131567057);
        this.f9354c = (BetterTextView) a(2131567058);
        this.f9355d = (FbRelativeLayout) a(2131567059);
        this.f9356e = (LinearLayout) a(2131567060);
        this.f9357f = (ImageView) a(2131567064);
        this.f9358g = (ImageView) a(2131567065);
        this.f9359h = (BetterTextView) a(2131567062);
        this.f9360i = (BetterTextView) a(2131567063);
        this.f9361j = (ProgressBar) a(2131567066);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RideView, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            this.f9352a.setImageDrawable(getResources().getDrawable(resourceId));
        } else {
            this.f9352a.setVisibility(8);
        }
        obtainStyledAttributes.recycle();
    }

    public void setListener(Listener listener) {
        this.f9362k = listener;
    }

    public void setActionText(@Nullable String str) {
        if (!Strings.isNullOrEmpty(str)) {
            m9817e();
            this.f9353b.setText(str);
            this.f9353b.setOnClickListener(new C10851(this));
            this.f9353b.setVisibility(0);
        }
    }

    public void setSelectedItem(@Nullable String str) {
        if (!Strings.isNullOrEmpty(str)) {
            m9817e();
            this.f9360i.setVisibility(8);
            this.f9359h.setText(str);
            OnClickListener c10862 = new C10862(this);
            this.f9356e.setOnClickListener(c10862);
            this.f9357f.setOnClickListener(c10862);
            this.f9355d.setVisibility(0);
        }
    }

    public void setSelectedSubText(@Nullable String str) {
        if (!Strings.isNullOrEmpty(str)) {
            this.f9360i.setVisibility(0);
            this.f9360i.setText(str);
        }
    }

    public final void m9818a() {
        this.f9360i.setVisibility(8);
    }

    public void setRequirementText(@Nullable String str) {
        if (!Strings.isNullOrEmpty(str)) {
            m9817e();
            this.f9354c.setText(str);
            this.f9354c.setVisibility(0);
        }
    }

    public void setupCancelButton(final OnClickListener onClickListener) {
        this.f9357f.setVisibility(8);
        this.f9358g.setVisibility(0);
        this.f9358g.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RideMultiOptionsView f9351b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1255242627);
                onClickListener.onClick(view);
                Logger.a(2, EntryType.UI_INPUT_END, -577078129, a);
            }
        });
    }

    public void setIconTintColor(int i) {
        this.f9352a.setColorFilter(i);
    }

    public final void m9819b() {
        m9817e();
        this.f9361j.setVisibility(0);
    }

    public final void m9820c() {
        this.f9357f.setVisibility(8);
    }

    public final void m9821d() {
        this.f9357f.setVisibility(0);
    }

    private void m9817e() {
        this.f9361j.setVisibility(8);
        this.f9353b.setVisibility(8);
        this.f9354c.setVisibility(8);
        this.f9355d.setVisibility(8);
    }
}
