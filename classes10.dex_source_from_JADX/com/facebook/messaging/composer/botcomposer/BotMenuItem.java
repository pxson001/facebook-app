package com.facebook.messaging.composer.botcomposer;

import com.facebook.messaging.business.common.calltoaction.model.CallToAction.Type;
import com.google.common.base.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: theme_category_id */
public class BotMenuItem {
    public final String f1741a;
    public final String f1742b;
    public final Type f1743c;

    public BotMenuItem(String str, String str2, Type type) {
        this.f1741a = str;
        this.f1742b = str2;
        this.f1743c = type;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f1741a, this.f1742b, this.f1743c});
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BotMenuItem)) {
            return false;
        }
        BotMenuItem botMenuItem = (BotMenuItem) obj;
        if (Objects.equal(this.f1741a, botMenuItem.f1741a) && Objects.equal(this.f1742b, botMenuItem.f1742b) && Objects.equal(this.f1743c, botMenuItem.f1743c)) {
            return true;
        }
        return false;
    }
}
