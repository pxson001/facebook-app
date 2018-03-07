package com.facebook.feedplugins.base.footer.ui;

import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;
import com.facebook.widget.springbutton.TouchSpring;
import java.util.EnumMap;
import javax.annotation.Nullable;

/* compiled from: SyncConnectionHandler */
public class BasicFooterPartDefinition$State {
    public final ButtonClickedListener f23021a;
    @Nullable
    public final EnumMap<FooterButtonId, TouchSpring> f23022b;

    public BasicFooterPartDefinition$State(ButtonClickedListener buttonClickedListener, @Nullable EnumMap<FooterButtonId, TouchSpring> enumMap) {
        this.f23021a = buttonClickedListener;
        this.f23022b = enumMap;
    }
}
