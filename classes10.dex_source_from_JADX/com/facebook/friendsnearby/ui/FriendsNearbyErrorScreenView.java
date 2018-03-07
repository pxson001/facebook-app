package com.facebook.friendsnearby.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: YEAR_SECTION */
public class FriendsNearbyErrorScreenView extends CustomLinearLayout {
    private TextView f20827a;
    private TextView f20828b;
    private Button f20829c;

    public FriendsNearbyErrorScreenView(Context context) {
        super(context);
        m21730a();
    }

    public FriendsNearbyErrorScreenView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m21730a();
    }

    public FriendsNearbyErrorScreenView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21730a();
    }

    private void m21730a() {
        setContentView(2130904525);
        setOrientation(1);
        setGravity(17);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131434235);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setBackgroundResource(2131361981);
        this.f20827a = (TextView) a(2131562366);
        this.f20828b = (TextView) a(2131562367);
        this.f20829c = (Button) a(2131562368);
    }

    public void setTitle(int i) {
        this.f20827a.setText(i);
    }

    public void setSubtitle(int i) {
        this.f20828b.setText(i);
    }

    public final void m21731a(int i, OnClickListener onClickListener) {
        this.f20829c.setText(i);
        this.f20829c.setOnClickListener(onClickListener);
    }
}
