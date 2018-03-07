package com.facebook.feedplugins.pymk.views.rows;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.feedplugins.pymk.PymkGatekeepers;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import javax.inject.Inject;

/* compiled from: THEME_WORK_CHAT */
public class SeeAllPeopleYouMayKnowView extends PagerItemWrapperLayout implements RecyclableView {
    @Inject
    public PymkGatekeepers f24931a;
    public boolean f24932b;

    public static void m26697a(Object obj, Context context) {
        ((SeeAllPeopleYouMayKnowView) obj).f24931a = PymkGatekeepers.m26572a(FbInjector.get(context));
    }

    public SeeAllPeopleYouMayKnowView(Context context) {
        this(context, null);
    }

    private SeeAllPeopleYouMayKnowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SeeAllPeopleYouMayKnowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Class cls = SeeAllPeopleYouMayKnowView.class;
        m26697a(this, getContext());
        if (i == 1 || this.f24931a.f24692a || this.f24931a.f24694c || this.f24931a.f24695d) {
            setContentView(2130906528);
        } else if (this.f24931a.f24693b) {
            setContentView(2130906524);
        } else {
            setContentView(2130906526);
        }
        ViewStub viewStub = (ViewStub) c(2131566454);
        viewStub.setLayoutResource(2130906525);
        viewStub.inflate();
        TextView textView = (TextView) c(2131566455);
        textView.setText(2131235585);
        textView.setContentDescription(getResources().getString(2131235584));
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 865375234);
        super.onAttachedToWindow();
        this.f24932b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1811231696, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 182792115);
        super.onDetachedFromWindow();
        this.f24932b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1936974433, a);
    }

    public final boolean m26698a() {
        return this.f24932b;
    }
}
