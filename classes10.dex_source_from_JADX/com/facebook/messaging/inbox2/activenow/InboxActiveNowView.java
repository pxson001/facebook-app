package com.facebook.messaging.inbox2.activenow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.annotations.ForDefaultPicker;
import com.facebook.messaging.contacts.picker.ContactPickerListItem;
import com.facebook.orca.contacts.picker.DivebarContactPickerViewFactory;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: share_group */
public class InboxActiveNowView extends CustomFrameLayout {
    private static final Class<?> f2617b = InboxActiveNowView.class;
    @Inject
    @ForDefaultPicker
    public DivebarContactPickerViewFactory f2618a;
    private ContactPickerUserRow f2619c;

    private static <T extends View> void m2596a(Class<T> cls, T t) {
        m2597a((Object) t, t.getContext());
    }

    private static void m2597a(Object obj, Context context) {
        ((InboxActiveNowView) obj).f2618a = DivebarContactPickerViewFactory.m5790b(FbInjector.get(context));
    }

    public InboxActiveNowView(Context context) {
        super(context);
        m2595a();
    }

    public InboxActiveNowView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2595a();
    }

    protected InboxActiveNowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2595a();
    }

    private void m2595a() {
        m2596a(InboxActiveNowView.class, (View) this);
        setContentView(2130904854);
    }

    public void setContactPickerUserRow(ContactPickerUserRow contactPickerUserRow) {
        this.f2619c = contactPickerUserRow;
        if (this.f2619c != null) {
            View a;
            View childAt = getChildAt(0);
            if (childAt != null) {
                a = this.f2618a.m5799a(this.f2619c, childAt);
                if (a != childAt) {
                    removeViewAt(0);
                    addView(a, 0);
                }
            } else {
                a = this.f2618a.m5799a(this.f2619c, null);
                addView(a);
            }
            if (a instanceof ContactPickerListItem) {
                ((ContactPickerListItem) a).f1871q.setUseInbox2AlternateBadges(true);
            }
        } else if (getChildCount() > 0) {
            removeViewAt(0);
        }
    }
}
