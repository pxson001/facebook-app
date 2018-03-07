package com.facebook.greetingcards.verve.render;

import android.content.Context;
import android.widget.FrameLayout;
import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.mutablemodel.DeckInfo;

/* compiled from: view_profile_tap */
public class VerveGroupView extends FrameLayout {
    public final VerveContainerController f417a;

    public VerveGroupView(Context context, DeckInfo deckInfo) {
        super(context);
        this.f417a = new VerveContainerController(this, deckInfo);
    }

    public final void m399a(VMView vMView, int i) {
        this.f417a.m380a(vMView, i);
    }
}
