package com.facebook.messaging.inbox2.rtc;

import android.content.Context;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.annotations.ForDefaultPicker;
import com.facebook.orca.contacts.picker.DivebarContactPickerViewFactory;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: selfupdate_click_install */
public class InboxRtcRecommendationView extends CustomFrameLayout {
    @Inject
    @ForDefaultPicker
    public DivebarContactPickerViewFactory f2960a;
    public ContactPickerUserRow f2961b;

    public static void m2947a(Object obj, Context context) {
        ((InboxRtcRecommendationView) obj).f2960a = DivebarContactPickerViewFactory.m5790b(FbInjector.get(context));
    }

    public InboxRtcRecommendationView(Context context) {
        super(context);
        Class cls = InboxRtcRecommendationView.class;
        m2947a(this, getContext());
        setContentView(2130904885);
    }
}
