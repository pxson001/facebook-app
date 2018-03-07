package com.facebook.adinterfaces.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.StringUtil.StringProcessor;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: VIDEO_ON */
public abstract class AdInterfacesBaseTargetingView extends CustomLinearLayout {
    protected CustomLinearLayout f22553a;
    public AdInterfacesAgeTargetingView f22554b;
    private View f22555c;
    public View f22556d;
    public AdInterfacesMapPreviewView f22557e;
    public AdInterfacesGenderView f22558f;
    private View f22559g;
    private View f22560h;
    public AdInterfacesSelectorView f22561i;
    private View f22562j;
    public AdInterfacesSelectorView f22563k;
    private View f22564l;
    public AdInterfacesLocalAwarenessAudienceView f22565m;

    public AdInterfacesBaseTargetingView(Context context) {
        super(context);
        mo1014a();
    }

    public AdInterfacesBaseTargetingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo1014a();
    }

    public AdInterfacesBaseTargetingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        mo1014a();
    }

    protected void mo1014a() {
        setOrientation(1);
        mo1016b();
        this.f22554b = (AdInterfacesAgeTargetingView) a(2131559347);
        this.f22555c = a(2131559345);
        this.f22556d = a(2131559346);
        this.f22557e = (AdInterfacesMapPreviewView) a(2131559344);
        this.f22558f = (AdInterfacesGenderView) a(2131559350);
        this.f22559g = a(2131559348);
        this.f22560h = a(2131559349);
        this.f22561i = (AdInterfacesSelectorView) a(2131559340);
        this.f22562j = a(2131559339);
        this.f22561i.setEditButtonContentDescription(getContext().getString(2131233920));
        this.f22563k = (AdInterfacesSelectorView) a(2131559342);
        this.f22564l = a(2131559341);
        this.f22563k.setEditButtonContentDescription(getContext().getString(2131233921));
        this.f22565m = (AdInterfacesLocalAwarenessAudienceView) a(2131559343);
    }

    public void mo1016b() {
        setContentView(2130903149);
    }

    public void setLocationsSelectorVisibility(int i) {
        this.f22561i.setVisibility(i);
        this.f22562j.setVisibility(i);
    }

    public void setLocationSelectorDividerVisibility(int i) {
        this.f22562j.setVisibility(i);
    }

    public final void m24429a(Iterable iterable, StringProcessor stringProcessor) {
        this.f22561i.m24919a(iterable, stringProcessor);
    }

    public void setInterestsSelectorVisibility(int i) {
        this.f22563k.setVisibility(i);
        this.f22564l.setVisibility(i);
    }

    public final void m24431b(Iterable iterable, StringProcessor stringProcessor) {
        this.f22563k.m24919a(iterable, stringProcessor);
    }

    public void setAgeViewTopDividerVisibility(int i) {
        this.f22555c.setVisibility(i);
    }

    public void setGenderViewVisibility(int i) {
        this.f22558f.setVisibility(i);
        this.f22560h.setVisibility(i);
        this.f22559g.setVisibility(i);
    }

    public CustomLinearLayout getAudienceOptionsView() {
        return this.f22553a;
    }
}
