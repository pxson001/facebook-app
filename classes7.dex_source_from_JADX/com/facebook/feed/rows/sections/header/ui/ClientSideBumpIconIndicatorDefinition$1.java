package com.facebook.feed.rows.sections.header.ui;

import android.view.View;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.PropertyHelper;

/* compiled from: Unexpected MIME type. */
public class ClientSideBumpIconIndicatorDefinition$1 implements Runnable {
    final /* synthetic */ FeedUnit f21393a;
    final /* synthetic */ View f21394b;
    final /* synthetic */ ClientSideBumpIconIndicatorDefinition$State f21395c;
    final /* synthetic */ ClientSideBumpIconIndicatorDefinition f21396d;

    public ClientSideBumpIconIndicatorDefinition$1(ClientSideBumpIconIndicatorDefinition clientSideBumpIconIndicatorDefinition, FeedUnit feedUnit, View view, ClientSideBumpIconIndicatorDefinition$State clientSideBumpIconIndicatorDefinition$State) {
        this.f21396d = clientSideBumpIconIndicatorDefinition;
        this.f21393a = feedUnit;
        this.f21394b = view;
        this.f21395c = clientSideBumpIconIndicatorDefinition$State;
    }

    public void run() {
        String str;
        boolean z;
        String a;
        if (this.f21393a != null) {
            String b = PropertyHelper.b(this.f21393a);
            str = b;
            z = PropertyHelper.a(this.f21393a).y;
            a = PropertyHelper.a(this.f21393a);
        } else {
            z = false;
            str = null;
            a = null;
        }
        if (this.f21396d.a) {
            ((ClientSideIconIndicator) this.f21394b).mo1501a(z, str, this.f21395c.f21397a);
        } else {
            ((ClientSideIconIndicator) this.f21394b).mo1500a(a, str, this.f21395c.f21397a);
        }
    }
}
