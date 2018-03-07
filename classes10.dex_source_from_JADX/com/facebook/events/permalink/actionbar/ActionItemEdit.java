package com.facebook.events.permalink.actionbar;

import android.content.Context;
import android.content.Intent;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.activity.EventEditActivity;
import com.facebook.events.common.ActionMechanism;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.create.EventEditNikumanActivity;
import com.facebook.events.model.Event;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: camera_button */
public class ActionItemEdit {
    private Event f17946a;
    private EventAnalyticsParams f17947b;
    private Context f17948c;
    public Product f17949d;
    private SecureContextHelper f17950e;

    public static ActionItemEdit m18347b(InjectorLike injectorLike) {
        return new ActionItemEdit((Context) injectorLike.getInstance(Context.class), ProductMethodAutoProvider.b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public ActionItemEdit(Context context, Product product, SecureContextHelper secureContextHelper) {
        this.f17948c = context;
        this.f17949d = product;
        this.f17950e = secureContextHelper;
    }

    public final void m18350a(Event event, EventAnalyticsParams eventAnalyticsParams) {
        this.f17946a = event;
        this.f17947b = eventAnalyticsParams;
    }

    public final void m18348a(ActionMechanism actionMechanism) {
        m18346a(actionMechanism, null, false);
    }

    public static ActionItemEdit m18345a(InjectorLike injectorLike) {
        return m18347b(injectorLike);
    }

    public final void m18351b(ActionMechanism actionMechanism) {
        m18346a(actionMechanism, null, true);
    }

    public final void m18349a(ActionMechanism actionMechanism, @Nullable String str) {
        m18346a(actionMechanism, str, false);
    }

    private void m18346a(ActionMechanism actionMechanism, @Nullable String str, boolean z) {
        if (this.f17946a != null && this.f17947b != null) {
            Object obj;
            Intent a;
            if (this.f17949d != Product.PAA) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                a = EventEditNikumanActivity.m16586a(this.f17948c, this.f17946a, str, this.f17947b.d, actionMechanism);
            } else {
                a = EventEditActivity.m16369a(this.f17948c, this.f17946a, this.f17947b.b);
            }
            if (z) {
                a.setFlags(268435456);
            }
            this.f17950e.a(a, this.f17948c);
        }
    }
}
