package com.facebook.feedplugins.graphqlstory.header;

import android.view.View;

/* compiled from: render */
public class SeeFirstTooltipPartDefinition$1 implements Runnable {
    final /* synthetic */ View f5277a;
    final /* synthetic */ SeeFirstTooltipPartDefinition$State f5278b;
    final /* synthetic */ SeeFirstTooltipPartDefinition f5279c;

    public SeeFirstTooltipPartDefinition$1(SeeFirstTooltipPartDefinition seeFirstTooltipPartDefinition, View view, SeeFirstTooltipPartDefinition$State seeFirstTooltipPartDefinition$State) {
        this.f5279c = seeFirstTooltipPartDefinition;
        this.f5277a = view;
        this.f5278b = seeFirstTooltipPartDefinition$State;
    }

    public void run() {
        ((CanShowSeeFirstIndicator) this.f5277a).a_(this.f5278b.f5281b);
    }
}
