package com.facebook.pages.common.surface.calltoaction.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.surface.calltoaction.fragment.PageUserCallToActionFragment;
import com.facebook.pages.common.surface.calltoaction.fragment.PageUserCallToActionFragment.ToolbarButtonListener.C18161.C18151;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: coverVideo */
public class PageCallToActionConfirmationPopoverView extends CustomRelativeLayout {
    public OnClickListener f16799a = new C18171(this);
    public TextView f16800b;
    public PopoverWindow f16801c;
    public C18151 f16802d;

    /* compiled from: coverVideo */
    class C18171 implements OnClickListener {
        final /* synthetic */ PageCallToActionConfirmationPopoverView f16798a;

        C18171(PageCallToActionConfirmationPopoverView pageCallToActionConfirmationPopoverView) {
            this.f16798a = pageCallToActionConfirmationPopoverView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1320709119);
            if (!(this.f16798a.f16802d == null || this.f16798a.f16801c == null)) {
                C18151 c18151 = this.f16798a.f16802d;
                this.f16798a.f16801c.l();
                PageUserCallToActionFragment.m19737b(c18151.f16701a.f16702a.f16703a);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1828031261, a);
        }
    }

    public PageCallToActionConfirmationPopoverView(Context context) {
        super(context);
        setContentView(2130905970);
        this.f16800b = (TextView) a(2131565376);
        this.f16800b.setOnClickListener(this.f16799a);
    }

    protected void onMeasure(int i, int i2) {
        Resources resources = getResources();
        float dimension = resources.getDimension(2131432984);
        super.onMeasure(MeasureSpec.makeMeasureSpec((int) (((float) resources.getDisplayMetrics().widthPixels) - (dimension * 2.0f)), 1073741824), MeasureSpec.makeMeasureSpec((int) (((float) resources.getDisplayMetrics().heightPixels) - (resources.getDimension(2131432985) * 2.0f)), 1073741824));
    }
}
