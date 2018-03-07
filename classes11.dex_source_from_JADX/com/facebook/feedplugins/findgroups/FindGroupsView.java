package com.facebook.feedplugins.findgroups;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: dotted */
public class FindGroupsView extends CustomLinearLayout {
    private final Button f7588a = ((Button) a(2131561998));

    public FindGroupsView(Context context) {
        super(context);
        setContentView(2130904337);
        setOrientation(1);
    }

    public void setButtonClickListener(OnClickListener onClickListener) {
        this.f7588a.setOnClickListener(onClickListener);
    }
}
