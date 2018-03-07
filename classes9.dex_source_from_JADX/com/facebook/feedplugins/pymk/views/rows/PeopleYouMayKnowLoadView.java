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

/* compiled from: THIRD_PARTY_PROCESSOR_AND_MERCHANT */
public class PeopleYouMayKnowLoadView extends PagerItemWrapperLayout implements RecyclableView {
    @Inject
    public PymkGatekeepers f24924a;
    public boolean f24925b;

    public static void m26693a(Object obj, Context context) {
        ((PeopleYouMayKnowLoadView) obj).f24924a = PymkGatekeepers.m26572a(FbInjector.get(context));
    }

    public PeopleYouMayKnowLoadView(Context context) {
        this(context, null);
    }

    private PeopleYouMayKnowLoadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PeopleYouMayKnowLoadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Class cls = PeopleYouMayKnowLoadView.class;
        m26693a(this, getContext());
        if (i == 1 || this.f24924a.f24692a || this.f24924a.f24694c || this.f24924a.f24695d) {
            setContentView(2130906528);
        } else if (this.f24924a.f24693b) {
            setContentView(2130906524);
        } else {
            setContentView(2130906526);
        }
        ViewStub viewStub = (ViewStub) c(2131566454);
        viewStub.setLayoutResource(2130906527);
        viewStub.inflate();
        TextView textView = (TextView) c(2131566455);
        textView.setText(2131235586);
        textView.setContentDescription(getResources().getString(2131235586));
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 919338054);
        super.onAttachedToWindow();
        this.f24925b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 705504138, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1818819570);
        super.onDetachedFromWindow();
        this.f24925b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1871939010, a);
    }

    public final boolean m26694a() {
        return this.f24925b;
    }
}
