package com.facebook.appdiscovery.lite.ui.rows.sections.actor;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.appdiscovery.lite.model.unit.AppDetailsFeedUnit;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: selected_transaction_payment_option */
public class ActorHeaderPartDefinition$2 implements OnClickListener {
    final /* synthetic */ AppDetailsFeedUnit f4152a;
    final /* synthetic */ ActorHeaderPartDefinition f4153b;

    public ActorHeaderPartDefinition$2(ActorHeaderPartDefinition actorHeaderPartDefinition, AppDetailsFeedUnit appDetailsFeedUnit) {
        this.f4153b = actorHeaderPartDefinition;
        this.f4152a = appDetailsFeedUnit;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1289348603);
        if (this.f4152a.d.m4007c() != null) {
            this.f4153b.e.a(new HoneyClientEvent("app_discovery_lite_profile_clicked"));
            this.f4153b.d.b(new Intent("android.intent.action.VIEW").setData(Uri.parse(StringFormatUtil.a(FBLinks.aX, new Object[]{this.f4152a.d.m4007c()}))), this.f4153b.f);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -884787980, a);
    }
}
