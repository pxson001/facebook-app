package com.facebook.timeline.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import com.facebook.entitycardsplugins.person.widget.actionbar.PersonCardActionBarView.1;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar.InlineActionBarMenuHandler;

/* compiled from: f78ec2d3ab73c0a0b77e945f65f54261 */
public class PersonActionBar extends InlineActionBar {
    private final InlineActionBarMenuHandler f14975a = new C11101(this);
    public 1 f14976b;

    /* compiled from: f78ec2d3ab73c0a0b77e945f65f54261 */
    class C11101 implements InlineActionBarMenuHandler {
        final /* synthetic */ PersonActionBar f14974a;

        C11101(PersonActionBar personActionBar) {
            this.f14974a = personActionBar;
        }

        public final boolean mo1170a(MenuItem menuItem) {
            if (!menuItem.isEnabled()) {
                return true;
            }
            if (this.f14974a.f14976b == null) {
                return false;
            }
            this.f14974a.f14976b.a(menuItem.getItemId());
            return true;
        }
    }

    public PersonActionBar(Context context) {
        super(context);
        m18803a();
    }

    public PersonActionBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18803a();
    }

    public PersonActionBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18803a();
    }

    private void m18803a() {
        setMaxNumOfVisibleButtons(4);
        this.f3593b = this.f14975a;
        m4322a(false, true, 0);
    }
}
