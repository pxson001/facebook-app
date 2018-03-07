package com.facebook.groups.editfavorites.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: activated */
public class GroupEditFavoritesSectionHeaderView extends CustomLinearLayout {
    private final FbTextView f10126a;

    public GroupEditFavoritesSectionHeaderView(Context context) {
        this(context, null);
    }

    private GroupEditFavoritesSectionHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904651);
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131361981)));
        this.f10126a = (FbTextView) findViewById(2131562659);
    }

    public final void m10479a(String str) {
        this.f10126a.setText(str);
    }
}
