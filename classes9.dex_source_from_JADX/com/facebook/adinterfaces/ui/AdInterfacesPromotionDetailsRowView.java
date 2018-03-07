package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: UsersInvite */
public class AdInterfacesPromotionDetailsRowView extends CustomLinearLayout {
    public BetterTextView f22875a = ((BetterTextView) a(2131559314));
    public BetterTextView f22876b = ((BetterTextView) a(2131559313));

    public AdInterfacesPromotionDetailsRowView(Context context, String str, String str2) {
        super(context);
        setContentView(2130903132);
        this.f22876b.setText(str);
        this.f22875a.setText(str2);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        a(2131559315).setVisibility(0);
    }
}
