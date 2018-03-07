package com.facebook.caspian.ui.standardheader;

import android.content.Context;
import android.widget.TextView;
import com.facebook.common.locale.Locales;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: crop-bottom */
public class StandardPermalinkHeaderDateView extends CustomLinearLayout {
    @Inject
    public Locales f16577a;
    public TextView f16578b = ((TextView) a(2131567618));
    public TextView f16579c = ((TextView) a(2131567619));

    public static void m20633a(Object obj, Context context) {
        ((StandardPermalinkHeaderDateView) obj).f16577a = Locales.a(FbInjector.get(context));
    }

    public StandardPermalinkHeaderDateView(Context context) {
        super(context);
        Class cls = StandardPermalinkHeaderDateView.class;
        m20633a(this, getContext());
        setContentView(2130907220);
    }
}
