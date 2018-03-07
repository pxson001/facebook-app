package com.facebook.feedplugins.pymi.views;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.friends.ui.SmartButtonLite;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import javax.inject.Inject;

/* compiled from: checkup_type */
public class ContactYouMayInviteView extends PagerItemWrapperLayout implements RecyclableView {
    @Inject
    public AllCapsTransformationMethod f8808a;
    public boolean f8809b;
    public Resources f8810c = getResources();
    public SmartButtonLite f8811d = ((SmartButtonLite) c(2131560723));

    public static void m9567a(Object obj, Context context) {
        ((ContactYouMayInviteView) obj).f8808a = AllCapsTransformationMethod.b(FbInjector.get(context));
    }

    public ContactYouMayInviteView(Context context) {
        super(context);
        Class cls = ContactYouMayInviteView.class;
        m9567a(this, getContext());
        setContentView(2130903771);
    }

    public final void m9569b() {
        this.f8811d.setText(m9566a(2131239081));
        this.f8811d.setStyle(2130772395);
        this.f8811d.setImageDrawable(this.f8810c.getDrawable(2130840448));
        this.f8811d.setEnabled(true);
    }

    public final void m9570e() {
        this.f8811d.setText(m9566a(2131230753));
        this.f8811d.setStyle(2130772383);
        this.f8811d.setImageDrawable(null);
    }

    public final void m9571f() {
        this.f8811d.setText(m9566a(2131239082));
        this.f8811d.setStyle(2130772383);
        this.f8811d.setImageDrawable(null);
        this.f8811d.setEnabled(false);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 441407457);
        super.onAttachedToWindow();
        this.f8809b = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 674940975, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -62435556);
        super.onDetachedFromWindow();
        this.f8809b = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1603063421, a);
    }

    public final boolean m9568a() {
        return this.f8809b;
    }

    private CharSequence m9566a(int i) {
        return this.f8808a.getTransformation(this.f8810c.getString(i), null);
    }
}
