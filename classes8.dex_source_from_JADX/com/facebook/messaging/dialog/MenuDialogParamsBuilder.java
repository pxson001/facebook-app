package com.facebook.messaging.dialog;

import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: tos_version */
public class MenuDialogParamsBuilder {
    public int f1524a;
    public String f1525b;
    public List<MenuDialogItem> f1526c = Lists.a();
    public Object f1527d;

    public final MenuDialogParamsBuilder m1683a(MenuDialogItem menuDialogItem) {
        this.f1526c.add(menuDialogItem);
        return this;
    }

    public final MenuDialogParams m1684e() {
        return new MenuDialogParams(this);
    }
}
