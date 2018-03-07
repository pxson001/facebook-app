package com.facebook.appdiscovery.lite.ui.rows.sections.actor;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.appdiscovery.lite.common.ui.NoUnderlineClickableSpan;

/* compiled from: selected_transaction_payment_option */
public class ActorHeaderPartDefinition$3 extends NoUnderlineClickableSpan {
    final /* synthetic */ OnClickListener f4154a;
    final /* synthetic */ ActorHeaderPartDefinition f4155b;

    public ActorHeaderPartDefinition$3(ActorHeaderPartDefinition actorHeaderPartDefinition, OnClickListener onClickListener) {
        this.f4155b = actorHeaderPartDefinition;
        this.f4154a = onClickListener;
    }

    public void onClick(View view) {
        this.f4154a.onClick(view);
    }
}
