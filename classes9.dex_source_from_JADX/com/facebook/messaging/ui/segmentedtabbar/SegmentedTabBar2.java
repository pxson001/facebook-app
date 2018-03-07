package com.facebook.messaging.ui.segmentedtabbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: checkPaymentPinParams */
public class SegmentedTabBar2 extends CustomFrameLayout {
    public LinearLayout f18260a;
    private OnClickListener f18261b;
    public View f18262c;
    public Listener f18263d;

    /* compiled from: checkPaymentPinParams */
    class C21191 implements OnClickListener {
        final /* synthetic */ SegmentedTabBar2 f18259a;

        C21191(SegmentedTabBar2 segmentedTabBar2) {
            this.f18259a = segmentedTabBar2;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 190287867);
            if (this.f18259a.f18262c == view) {
                Logger.a(2, EntryType.UI_INPUT_END, -1286388892, a);
                return;
            }
            if (this.f18259a.f18262c != null) {
                this.f18259a.f18262c.setSelected(false);
            }
            view.setSelected(true);
            this.f18259a.f18262c = view;
            if (this.f18259a.f18263d != null) {
                this.f18259a.f18263d.m18227a(this.f18259a.f18260a.indexOfChild(view));
            }
            LogUtils.a(241104864, a);
        }
    }

    /* compiled from: checkPaymentPinParams */
    public interface Listener {
        void m18227a(int i);
    }

    public SegmentedTabBar2(Context context) {
        super(context);
        m18230a(context, null, 0);
    }

    public SegmentedTabBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18230a(context, attributeSet, 0);
    }

    public SegmentedTabBar2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18230a(context, attributeSet, i);
    }

    private void m18230a(Context context, AttributeSet attributeSet, int i) {
        setContentView(2130907054);
        this.f18260a = (LinearLayout) findViewById(2131565174);
        this.f18261b = new C21191(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SegmentedTabBar2, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        if (resourceId > 0) {
            String[] stringArray = getResources().getStringArray(resourceId);
            LayoutInflater from = LayoutInflater.from(context);
            for (CharSequence text : stringArray) {
                View view = (TextView) from.inflate(2130907365, this.f18260a, false);
                view.setText(text);
                m18234a(view);
            }
        }
    }

    public void setListener(Listener listener) {
        this.f18263d = listener;
    }

    public final void m18233a(int i) {
        View childAt = this.f18260a.getChildAt(i);
        if (childAt != null) {
            this.f18261b.onClick(childAt);
        }
    }

    public final void m18234a(View view) {
        view.setOnClickListener(this.f18261b);
        this.f18260a.addView(view);
    }

    public ViewGroup getTabContainer() {
        return this.f18260a;
    }
}
