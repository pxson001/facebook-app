package com.facebook.feedplugins.pymi.views;

import android.content.Context;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friends.ui.SmartButtonLite;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import javax.inject.Inject;

/* compiled from: checkup_id */
public class PymiInviteMoreView extends PagerItemWrapperLayout implements RecyclableView {
    @Inject
    public AllCapsTransformationMethod f8814a;
    public boolean f8815b;
    public SmartButtonLite f8816c = ((SmartButtonLite) c(2131566453));

    public static void m9574a(Object obj, Context context) {
        ((PymiInviteMoreView) obj).f8814a = AllCapsTransformationMethod.b(FbInjector.get(context));
    }

    public PymiInviteMoreView(Context context) {
        super(context);
        Class cls = PymiInviteMoreView.class;
        m9574a(this, getContext());
        setContentView(2130906523);
        this.f8816c.setText(this.f8814a.getTransformation(getResources().getString(2131239083), null));
        this.f8816c.setStyle(2130772395);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -2096726404);
        super.onAttachedToWindow();
        this.f8815b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1278500356, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1714883152);
        super.onDetachedFromWindow();
        this.f8815b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -2120554315, a);
    }

    public final boolean m9575a() {
        return this.f8815b;
    }
}
