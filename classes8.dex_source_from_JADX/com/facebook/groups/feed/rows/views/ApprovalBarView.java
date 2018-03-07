package com.facebook.groups.feed.rows.views;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: f955d8fd755a5952258b4360627b4835 */
public class ApprovalBarView extends CustomLinearLayout {
    public View f14164a = a(2131564000);
    public View f14165b = a(2131564001);

    public ApprovalBarView(Context context) {
        super(context);
        setContentView(2130905352);
    }

    public void setPrimaryButtonListener(OnClickListener onClickListener) {
        this.f14164a.setOnClickListener(onClickListener);
    }

    public void setNegativeButtonListener(OnClickListener onClickListener) {
        this.f14165b.setOnClickListener(onClickListener);
    }
}
