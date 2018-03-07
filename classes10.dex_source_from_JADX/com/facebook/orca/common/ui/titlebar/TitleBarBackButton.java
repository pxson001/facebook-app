package com.facebook.orca.common.ui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewGroup;

/* compiled from: p2p_group_send_display_picker_dialog */
public class TitleBarBackButton extends CustomViewGroup {
    private ImageButton f5299a;

    /* compiled from: p2p_group_send_display_picker_dialog */
    class C07471 implements OnClickListener {
        final /* synthetic */ TitleBarBackButton f5298a;

        C07471(TitleBarBackButton titleBarBackButton) {
            this.f5298a = titleBarBackButton;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 722891305);
            this.f5298a.performClick();
            Logger.a(2, EntryType.UI_INPUT_END, 1323103128, a);
        }
    }

    public TitleBarBackButton(Context context) {
        this(context, null);
    }

    public TitleBarBackButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TitleBarBackButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905896);
        this.f5299a = (ImageButton) getView(2131565241);
        this.f5299a.setOnClickListener(new C07471(this));
    }
}
