package com.facebook.messaging.ui.header;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewGroup;
import javax.annotation.Nullable;

/* compiled from: place_name_state */
public class ActionableSectionHeaderView extends CustomViewGroup {
    public Button f4853a = ((Button) getView(2131564413));
    public TextView f4854b = ((TextView) getView(2131564412));
    @Nullable
    public OnClickListener f4855c;
    public int f4856d;

    /* compiled from: place_name_state */
    public class C06621 implements OnClickListener {
        final /* synthetic */ ActionableSectionHeaderView f4852a;

        public C06621(ActionableSectionHeaderView actionableSectionHeaderView) {
            this.f4852a = actionableSectionHeaderView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1600412707);
            if (this.f4852a.f4855c != null) {
                this.f4852a.f4855c.onClick(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1581750664, a);
        }
    }

    public ActionableSectionHeaderView(Context context) {
        super(context);
        setContentView(2130905553);
        this.f4853a.setOnClickListener(new C06621(this));
        this.f4856d = this.f4853a.getCurrentTextColor();
    }

    public void setText(String str) {
        this.f4854b.setText(str);
    }

    public void setActionButtonText(@Nullable String str) {
        this.f4853a.setText(str);
        this.f4853a.setVisibility(StringUtil.a(str) ? 8 : 0);
    }

    public void setActionButtonTextColor(int i) {
        this.f4853a.setTextColor(i);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
