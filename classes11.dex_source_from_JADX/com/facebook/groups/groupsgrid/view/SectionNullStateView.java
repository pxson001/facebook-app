package com.facebook.groups.groupsgrid.view;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: Writing to closed buffer */
public class SectionNullStateView extends CustomFrameLayout {
    @Inject
    public Resources f10372a;

    public static void m10773a(Object obj, Context context) {
        ((SectionNullStateView) obj).f10372a = ResourcesMethodAutoProvider.a(FbInjector.get(context));
    }

    public SectionNullStateView(Context context) {
        super(context);
        Class cls = SectionNullStateView.class;
        m10773a(this, getContext());
        setContentView(2130907022);
    }

    public final void m10774a(int i) {
        ((TextView) findViewById(2131567304)).setText(this.f10372a.getText(i));
    }
}
