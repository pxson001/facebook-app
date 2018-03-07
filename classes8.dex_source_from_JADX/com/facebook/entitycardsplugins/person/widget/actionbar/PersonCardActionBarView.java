package com.facebook.entitycardsplugins.person.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.widget.actionbar.PersonActionBar;
import com.facebook.timeline.widget.actionbar.PersonActionBarItems;

/* compiled from: heisman_photo_source */
public class PersonCardActionBarView extends PersonActionBar {
    public PersonCardActionBarPresenter f11307a;
    private final C12211 f11308b = new C12211(this);

    /* compiled from: heisman_photo_source */
    public class C12211 {
        final /* synthetic */ PersonCardActionBarView f11306a;

        C12211(PersonCardActionBarView personCardActionBarView) {
            this.f11306a = personCardActionBarView;
        }

        public final void m13268a(@PersonActionBarItems int i) {
            if (this.f11306a.f11307a != null) {
                this.f11306a.f11307a.m13263a(this.f11306a, i);
            }
        }
    }

    public PersonCardActionBarView(Context context) {
        super(context);
    }

    public PersonCardActionBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PersonCardActionBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setPresenter(PersonCardActionBarPresenter personCardActionBarPresenter) {
        this.f11307a = personCardActionBarPresenter;
        this.b = this.f11308b;
    }

    public void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1368513250);
        super.onDetachedFromWindow();
        if (this.f11307a != null) {
            this.b = null;
            this.f11307a.m13262a(this);
            this.f11307a = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1219804546, a);
    }
}
