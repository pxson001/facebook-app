package com.facebook.messaging.sms.migration;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.contacts.picker.BaseContactPickerListAdapter;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.PickableContactPickerRow;
import com.facebook.inject.Assisted;
import com.facebook.messaging.sms.migration.util.SMSContactsMigrationTextUtil;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: qrcode_code_rendered */
public class SMSContactPickerAdapter extends BaseContactPickerListAdapter {
    private final SMSContactsMigrationTextUtil f4140a;
    public final SMSContactPickerConfig f4141b;
    public TextView f4142c;
    public ImmutableList<ContactPickerRow> f4143d = RegularImmutableList.a;
    public int f4144e;
    private int f4145f;
    public int f4146g;

    @Inject
    public SMSContactPickerAdapter(SMSContactsMigrationTextUtil sMSContactsMigrationTextUtil, @Assisted SMSContactPickerConfig sMSContactPickerConfig) {
        this.f4140a = sMSContactsMigrationTextUtil;
        this.f4141b = sMSContactPickerConfig;
    }

    public final void m3798a(ImmutableList<ContactPickerRow> immutableList) {
        this.f4143d = immutableList;
        this.f4144e = 0;
        this.f4145f = 0;
        this.f4146g = 0;
        int size = this.f4143d.size();
        for (int i = 0; i < size; i++) {
            int i2;
            int i3;
            ContactPickerRow contactPickerRow = (ContactPickerRow) this.f4143d.get(i);
            int i4 = this.f4144e;
            if (((PickableContactPickerRow) contactPickerRow).d()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.f4144e = i2 + i4;
            i4 = this.f4145f;
            if (contactPickerRow instanceof SMSLocalContactRow) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.f4145f = i2 + i4;
            i2 = this.f4146g;
            if (contactPickerRow instanceof SMSMatchedContactRow) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.f4146g = i3 + i2;
        }
    }

    public int getCount() {
        return this.f4143d.size() + 1;
    }

    public Object getItem(int i) {
        if (i <= 0) {
            return null;
        }
        return this.f4143d.get(i - 1);
    }

    public boolean isEnabled(int i) {
        if (i <= 0) {
            return false;
        }
        PickableContactPickerRow pickableContactPickerRow = (PickableContactPickerRow) getItem(i);
        return (pickableContactPickerRow instanceof SMSMatchedContactRow) || ((SMSLocalContactRow) pickableContactPickerRow).f4186f;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (i > 0) {
            return m3795a(i, view, viewGroup);
        }
        if (this.f4142c == null) {
            this.f4142c = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907521, viewGroup, false);
            this.f4142c.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.f4142c.setText(this.f4141b.m3802a(this.f4146g));
        return this.f4142c;
    }

    private View m3795a(int i, View view, ViewGroup viewGroup) {
        PickableContactPickerRow pickableContactPickerRow = (PickableContactPickerRow) getItem(i);
        SMSContactItem sMSContactItem = view instanceof SMSContactItem ? (SMSContactItem) view : null;
        if (sMSContactItem == null) {
            sMSContactItem = (SMSContactItem) LayoutInflater.from(viewGroup.getContext()).inflate(2130907519, viewGroup, false);
        }
        if (pickableContactPickerRow instanceof SMSMatchedContactRow) {
            sMSContactItem.setContactRow((SMSMatchedContactRow) pickableContactPickerRow);
        } else {
            sMSContactItem.setContactRow((SMSLocalContactRow) pickableContactPickerRow);
        }
        return sMSContactItem;
    }

    public final void m3797a(ContactPickerRow contactPickerRow, int i) {
        if (isEnabled(i)) {
            m3796a(contactPickerRow);
            AdapterDetour.a(this, -946341625);
        }
    }

    private synchronized void m3796a(ContactPickerRow contactPickerRow) {
        boolean z = true;
        synchronized (this) {
            int i;
            PickableContactPickerRow pickableContactPickerRow = (PickableContactPickerRow) contactPickerRow;
            boolean d = pickableContactPickerRow.d();
            int i2 = this.f4144e;
            if (d) {
                i = -1;
            } else {
                i = 1;
            }
            this.f4144e = i + i2;
            if (d) {
                z = false;
            }
            pickableContactPickerRow.a(z);
        }
    }
}
