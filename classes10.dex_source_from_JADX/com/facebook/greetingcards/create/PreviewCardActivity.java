package com.facebook.greetingcards.create;

import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.greetingcards.create.PreviewCardFragment.PreviewCardFragmentBuilder;
import com.facebook.greetingcards.model.GreetingCard;
import com.facebook.greetingcards.render.RenderCardFragment.AbstractRenderCardFragmentBuilder;
import com.google.common.collect.ImmutableList;

/* compiled from: {%s} */
public class PreviewCardActivity extends FbFragmentActivity {
    protected final void m157b(Bundle bundle) {
        super.b(bundle);
        if (bundle == null) {
            GreetingCard greetingCard = getIntent().getExtras() == null ? null : (GreetingCard) getIntent().getExtras().getParcelable("args_greeting_card");
            AbstractRenderCardFragmentBuilder previewCardFragmentBuilder = new PreviewCardFragmentBuilder();
            previewCardFragmentBuilder.m160a(ImmutableList.of(getResources().getString(2131241468), getResources().getString(2131241469)));
            if (greetingCard != null) {
                previewCardFragmentBuilder.m159a(greetingCard);
            }
            kO_().a().a(16908290, previewCardFragmentBuilder.m162b()).b();
        }
    }
}
