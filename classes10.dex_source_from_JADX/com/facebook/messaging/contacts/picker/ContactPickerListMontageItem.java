package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.widget.CheckBox;
import com.facebook.contacts.picker.ContactPickerMontageRow;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.SimpleVariableTextLayoutView;

/* compiled from: task_key_fetch_fresh_saved_items */
public class ContactPickerListMontageItem extends CustomRelativeLayout {
    public CheckBox f1881a = ((CheckBox) a(2131561316));
    public SimpleVariableTextLayoutView f1882b = ((SimpleVariableTextLayoutView) a(2131564424));
    @ColorInt
    public int f1883c = this.f1882b.getTextColor();
    public ContactPickerMontageRow f1884d;

    public ContactPickerListMontageItem(Context context) {
        super(context, null, 2130772985);
        setContentView(2130905661);
    }

    public ContactPickerMontageRow getContactRow() {
        return this.f1884d;
    }
}
