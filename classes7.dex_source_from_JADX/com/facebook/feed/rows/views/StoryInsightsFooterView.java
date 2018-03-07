package com.facebook.feed.rows.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.widget.CustomRelativeLayout;
import java.text.NumberFormat;

/* compiled from: UI_HIDDEN */
public class StoryInsightsFooterView extends CustomRelativeLayout {
    public TextView f21598a;
    private TextView f21599b;
    private StoryInsightsExtendedFooterView f21600c;
    private View f21601d;
    private View f21602e;
    private View f21603f;
    private View f21604g;

    public StoryInsightsFooterView(Context context) {
        this(context, null);
    }

    private StoryInsightsFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904343);
        this.f21598a = (TextView) a(2131562008);
        this.f21599b = (TextView) a(2131562009);
        this.f21600c = (StoryInsightsExtendedFooterView) a(2131562014);
        this.f21601d = a(2131562011);
        this.f21602e = a(2131562012);
        this.f21603f = a(2131562013);
        this.f21604g = a(2131562010);
    }

    public final void m24213a(int i, int i2, int i3, int i4, int i5) {
        m24211a(i, i5, i2, i3);
        if (i3 > 0) {
            this.f21600c.m24209a(i2, i3, i4);
            this.f21600c.setVisibility(0);
            return;
        }
        this.f21600c.setVisibility(8);
    }

    private void m24211a(int i, int i2, int i3, int i4) {
        if (i == 0) {
            this.f21598a.setVisibility(4);
        } else {
            this.f21598a.setVisibility(0);
            NumberFormat instance = NumberFormat.getInstance(getResources().getConfiguration().locale);
            this.f21598a.setText(getContext().getResources().getQuantityString(2131689536, i, new Object[]{instance.format((long) i)}));
        }
        m24210a(i2, i3, i4);
    }

    private void m24210a(int i, int i2, int i3) {
        if (i == 0 || (i2 == 0 && i3 == 0)) {
            this.f21604g.setVisibility(4);
            return;
        }
        this.f21604g.setVisibility(0);
        float f = (((float) i2) * 1.0f) / ((float) i);
        float f2 = (((float) i3) * 1.0f) / ((float) i);
        m24212a(this.f21601d, f);
        m24212a(this.f21602e, f2);
        m24212a(this.f21603f, (1.0f - f) - f2);
    }

    private static void m24212a(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutParams.weight = f;
        view.setLayoutParams(layoutParams);
    }

    public void setButtonText(int i) {
        this.f21599b.setText(i);
    }

    public void setViewInsightsClickListener(OnClickListener onClickListener) {
        this.f21599b.setOnClickListener(onClickListener);
    }

    public void setReachCountClickListener(OnClickListener onClickListener) {
        this.f21598a.setOnClickListener(onClickListener);
    }

    public void setBoostBarClickListener(OnClickListener onClickListener) {
        this.f21604g.setOnClickListener(onClickListener);
    }

    public void setExtendedFooterViewClickListener(OnClickListener onClickListener) {
        this.f21600c.setOnClickListener(onClickListener);
    }
}
