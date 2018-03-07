package com.facebook.messaging.ui.segmentedtabbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: null content-location */
public class SegmentedTabBar extends CustomFrameLayout {
    private View f18264a;
    private TextView f18265b;
    private TextView f18266c;
    private Tab f18267d;
    public Listener f18268e;

    /* compiled from: null content-location */
    public interface Listener {
        void mo312a(Tab tab);
    }

    /* compiled from: null content-location */
    public enum Tab {
        LEFT,
        RIGHT
    }

    /* compiled from: null content-location */
    class TabClickListener implements OnClickListener {
        final /* synthetic */ SegmentedTabBar f18257a;
        private final Tab f18258b;

        public TabClickListener(SegmentedTabBar segmentedTabBar, Tab tab) {
            this.f18257a = segmentedTabBar;
            this.f18258b = tab;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1591996306);
            this.f18257a.setSelectedTab(this.f18258b);
            Logger.a(2, EntryType.UI_INPUT_END, 102950037, a);
        }
    }

    public SegmentedTabBar(Context context) {
        super(context);
        m18235a(context, null, 0);
    }

    public SegmentedTabBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18235a(context, attributeSet, 0);
    }

    public SegmentedTabBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18235a(context, attributeSet, i);
    }

    private void m18235a(Context context, AttributeSet attributeSet, int i) {
        setContentView(2130907053);
        this.f18264a = c(2131567392);
        this.f18265b = (TextView) c(2131567393);
        this.f18266c = (TextView) c(2131567394);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SegmentedTabBar, i, 0);
        this.f18265b.setText(obtainStyledAttributes.getString(0));
        this.f18266c.setText(obtainStyledAttributes.getString(1));
        obtainStyledAttributes.recycle();
        this.f18265b.setOnClickListener(new TabClickListener(this, Tab.LEFT));
        this.f18266c.setOnClickListener(new TabClickListener(this, Tab.RIGHT));
        setSelectedTab(Tab.LEFT);
    }

    public Tab getSelectedTab() {
        return this.f18267d;
    }

    public void setListener(Listener listener) {
        this.f18268e = listener;
    }

    public void setLeftTabName(String str) {
        this.f18265b.setText(str);
    }

    public void setRightTabName(String str) {
        this.f18266c.setText(str);
    }

    public void setSelectedTab(Tab tab) {
        boolean z = true;
        if (this.f18267d != tab) {
            boolean z2;
            this.f18267d = tab;
            boolean z3 = this.f18267d == Tab.LEFT;
            this.f18265b.setSelected(z3);
            TextView textView = this.f18265b;
            if (z3) {
                z2 = false;
            } else {
                z2 = true;
            }
            textView.setClickable(z2);
            TextView textView2 = this.f18266c;
            if (z3) {
                z = false;
            }
            textView2.setSelected(z);
            this.f18266c.setClickable(z3);
            this.f18264a.setBackgroundResource(z3 ? 2130843315 : 2130843318);
            if (this.f18268e != null) {
                this.f18268e.mo312a(this.f18267d);
            }
        }
    }
}
