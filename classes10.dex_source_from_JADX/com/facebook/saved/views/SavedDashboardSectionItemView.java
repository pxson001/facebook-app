package com.facebook.saved.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.inject.FbInjector;
import com.facebook.saved.common.data.SavedDashboardSection;
import com.facebook.saved.common.data.SavedSectionResources;
import com.facebook.saved.common.data.SavedSectionResources.SavedSectionResource;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: instant_shopping_element_click */
public class SavedDashboardSectionItemView extends CustomLinearLayout {
    @Inject
    public SavedSectionResources f9358a;
    private TextView f9359b;
    private TextView f9360c;

    private static <T extends View> void m9516a(Class<T> cls, T t) {
        m9517a((Object) t, t.getContext());
    }

    private static void m9517a(Object obj, Context context) {
        ((SavedDashboardSectionItemView) obj).f9358a = SavedSectionResources.a(FbInjector.get(context));
    }

    public SavedDashboardSectionItemView(Context context) {
        super(context);
        m9514a();
    }

    public SavedDashboardSectionItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9514a();
    }

    public SavedDashboardSectionItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9514a();
    }

    private void m9514a() {
        m9516a(SavedDashboardSectionItemView.class, (View) this);
        setContentView(2130906948);
        this.f9359b = (TextView) a(2131567225);
        this.f9360c = (TextView) a(2131567226);
    }

    public final void m9518a(SavedDashboardSection savedDashboardSection) {
        this.f9359b.setText(savedDashboardSection.b);
        this.f9359b.setCompoundDrawablesWithIntrinsicBounds(((SavedSectionResource) this.f9358a.a(savedDashboardSection.a).or(SavedSectionResources.a)).a, 0, 0, 0);
        this.f9360c.setVisibility(8);
    }

    private void m9515a(SavedSectionResources savedSectionResources) {
        this.f9358a = savedSectionResources;
    }
}
