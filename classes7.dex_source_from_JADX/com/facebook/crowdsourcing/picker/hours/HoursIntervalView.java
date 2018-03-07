package com.facebook.crowdsourcing.picker.hours;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.R;
import com.facebook.common.util.StringUtil;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: com.facebook.livephotos.exoplayer.extractor.flv.FlvExtractor */
public class HoursIntervalView extends CustomLinearLayout {
    private TextView f17475a;
    private TextView f17476b;
    private ImageView f17477c;

    public HoursIntervalView(Context context) {
        super(context);
        m21379a(null);
    }

    public HoursIntervalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21379a(attributeSet);
    }

    public HoursIntervalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21379a(attributeSet);
    }

    private void m21379a(@Nullable AttributeSet attributeSet) {
        setContentView(2130904800);
        setOrientation(1);
        this.f17475a = (TextView) a(2131562936);
        this.f17476b = (TextView) a(2131562937);
        this.f17477c = (ImageView) a(2131562938);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HoursIntervalView);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        CharSequence string = obtainStyledAttributes.getString(1);
        if (resourceId != 0) {
            this.f17477c.setImageResource(resourceId);
            this.f17477c.setContentDescription(string);
        }
        obtainStyledAttributes.recycle();
    }

    public final void m21380a(@Nullable String str, @Nullable String str2) {
        this.f17475a.setText(str);
        this.f17476b.setText(str2);
    }

    public final boolean m21381a() {
        return (StringUtil.a(this.f17475a.getText()) || StringUtil.a(this.f17476b.getText())) ? false : true;
    }

    public void setIconVisibility(int i) {
        this.f17477c.setVisibility(i);
    }

    public void setIconOnClickListener(OnClickListener onClickListener) {
        this.f17477c.setOnClickListener(onClickListener);
    }

    public void setStartHoursOnClickListener(OnClickListener onClickListener) {
        this.f17475a.setOnClickListener(onClickListener);
    }

    public void setEndHoursOnClickListener(OnClickListener onClickListener) {
        this.f17476b.setOnClickListener(onClickListener);
    }
}
