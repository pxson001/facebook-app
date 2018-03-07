package com.facebook.messaging.contacts.picker;

import android.content.Context;
import com.facebook.contacts.picker.ContactPickerTincanRow;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.messaging.ui.name.ThreadNameView;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.tiles.ThreadTileView;

/* compiled from: task_event_tickets_purchase */
public class ContactPickerListTincanView extends CustomRelativeLayout {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessengerThreadNameViewDataFactory> f1889a = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MessengerThreadTileViewDataFactory> f1890b = UltralightRuntime.b;
    public ContactPickerTincanRow f1891c;
    public ThreadTileView f1892d;
    public ThreadNameView f1893e;

    public static void m1770a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ContactPickerListTincanView contactPickerListTincanView = (ContactPickerListTincanView) obj;
        com.facebook.inject.Lazy a = IdBasedLazy.a(fbInjector, 8584);
        com.facebook.inject.Lazy a2 = IdBasedLazy.a(fbInjector, 8293);
        contactPickerListTincanView.f1889a = a;
        contactPickerListTincanView.f1890b = a2;
    }

    public ContactPickerListTincanView(Context context) {
        super(context, null, 2130772985);
        Class cls = ContactPickerListTincanView.class;
        m1770a(this, getContext());
        setContentView(2130905659);
        this.f1892d = (ThreadTileView) a(2131564768);
        this.f1893e = (ThreadNameView) a(2131564769);
    }

    public ContactPickerTincanRow getContactRow() {
        return this.f1891c;
    }
}
