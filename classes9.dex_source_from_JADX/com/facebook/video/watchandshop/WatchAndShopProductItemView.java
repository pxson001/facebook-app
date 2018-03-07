package com.facebook.video.watchandshop;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import javax.annotation.Nullable;

/* compiled from: shouldShowToBuyer */
public class WatchAndShopProductItemView extends PagerItemWrapperLayout implements RecyclableView {
    public static final CallerContext f3460e = CallerContext.a(WatchAndShopProductItemView.class);
    public boolean f3461a;
    public TextView f3462b;
    public TextView f3463c;
    public FbDraweeView f3464d;

    public WatchAndShopProductItemView(Context context) {
        this(context, null);
    }

    private WatchAndShopProductItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130907767);
        this.f3462b = (TextView) c(2131568517);
        this.f3463c = (TextView) c(2131568518);
        this.f3464d = (FbDraweeView) c(2131568516);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1431966428);
        super.onAttachedToWindow();
        this.f3461a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1727634707, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1164990713);
        super.onDetachedFromWindow();
        this.f3461a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1888371085, a);
    }

    public final boolean m3275a() {
        return this.f3461a;
    }
}
