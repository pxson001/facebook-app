package com.facebook.ui.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.titlebar.Fb4aTitleBar.TitleBarState;
import com.facebook.widget.text.TextViewUtils;

/* compiled from: rewrite_rules */
public class Fb4aExpandingTitleBar extends Fb4aTitleBar {
    public Tooltip f6595m;
    public boolean f6596n;

    public Fb4aExpandingTitleBar(Context context) {
        this(context, null);
    }

    public Fb4aExpandingTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Fb4aExpandingTitleBar(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6602e.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ Fb4aExpandingTitleBar f6952b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 837005174);
                if (this.f6952b.f6606i == TitleBarState.TEXT && this.f6952b.f6596n) {
                    if (this.f6952b.f6595m == null) {
                        this.f6952b.f6595m = new Tooltip(context, 1);
                        this.f6952b.f6595m.b(0.0f);
                        this.f6952b.f6595m.a(Position.BELOW);
                        this.f6952b.f6595m.r = context.getResources().getDimensionPixelSize(2131429238);
                        this.f6952b.f6595m.d(true);
                        this.f6952b.f6595m.a(this.f6952b.f6602e.getText());
                    }
                    this.f6952b.f6595m.f(this.f6952b);
                    LogUtils.a(1685542854, a);
                    return;
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1993149404, a);
            }
        });
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f6596n = TextViewUtils.m13826a(this.f6602e);
    }

    public void setTitle(String str) {
        super.setTitle(str);
        if (this.f6595m != null) {
            this.f6595m.a(str);
        }
    }
}
