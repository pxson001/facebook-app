package com.facebook.appdiscovery.lite.ui.rows.sections.relatedapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.text.BetterTextView;

/* compiled from: selected_interval */
public class SmallPageItemView extends FrameLayout implements RecyclableView {
    public static final CallerContext f4184a = CallerContext.a(SmallPageItemView.class);
    public boolean f4185b;
    public FbDraweeView f4186c;
    public TextView f4187d;
    public TextView f4188e;

    public SmallPageItemView(Context context) {
        super(context);
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(getContext()).inflate(2130907138, this);
        this.f4187d = (BetterTextView) frameLayout.findViewById(2131560124);
        this.f4186c = (FbDraweeView) frameLayout.findViewById(2131559122);
        this.f4188e = (BetterTextView) frameLayout.findViewById(2131567499);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1299592550);
        super.onAttachedToWindow();
        this.f4185b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1370291470, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1028962629);
        super.onDetachedFromWindow();
        this.f4185b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1802651247, a);
    }

    public final boolean m4236a() {
        return this.f4185b;
    }
}
