package com.facebook.katana.ui;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Actions;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElementsTypes;
import com.facebook.ui.custommenu.CustomMenu;
import com.facebook.ui.custommenu.CustomMenuItem;

/* compiled from: work-in-house */
public class Fb4aCustomMenu extends CustomMenu {
    public Fb4aCustomMenu(Context context, LayoutInflater layoutInflater) {
        super(context, layoutInflater);
    }

    protected final String m111a() {
        return Modules.b;
    }

    protected final void m112a(CustomMenuItem customMenuItem) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent(Actions.a);
        honeyClientEvent.c = Modules.b;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.e = customMenuItem.a;
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.d = UIElementsTypes.a;
        this.b.a(honeyClientEvent);
    }
}
