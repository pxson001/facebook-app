package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messages.ipc.MessagingIntentUris;
import com.facebook.messages.links.MessengerLinks;
import com.facebook.messaging.invites.constants.InviteConstants.InviteEntryPoint;
import com.facebook.messaging.invites.quickinvites.InviteFriendsPeopleTabTopRowsController;
import com.facebook.messaging.invites.quickinvites.InviteFriendsPrefKeys;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: tap_pymm */
public class ContactPickerSectionInviteFriendsUpsellView extends CustomFrameLayout {
    private final ContactPickerSectionUpsellView f1978a;
    public Context f1979b;
    public SecureContextHelper f1980c;
    public InviteFriendsPeopleTabTopRowsController f1981d;
    public AnalyticsLogger f1982e;

    /* compiled from: tap_pymm */
    class C03341 implements OnClickListener {
        final /* synthetic */ ContactPickerSectionInviteFriendsUpsellView f1976a;

        C03341(ContactPickerSectionInviteFriendsUpsellView contactPickerSectionInviteFriendsUpsellView) {
            this.f1976a = contactPickerSectionInviteFriendsUpsellView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2083221568);
            HoneyClientEventFast a2 = this.f1976a.f1982e.a("invite_friends_upsell_start", true);
            if (a2.a()) {
                a2.a("messenger_people_tab_invite_friends_upsell");
                a2.b(InviteEntryPoint.PEOPLE_TAB_INVITE_UPSELL.name());
                a2.b();
            }
            this.f1976a.f1980c.a(new Intent().setAction(MessagingIntentUris.a).setData(Uri.parse(MessengerLinks.D)).putExtra("ShareType.inviteEntryPoint", InviteEntryPoint.PEOPLE_TAB_INVITE_UPSELL), this.f1976a.f1979b);
            Logger.a(2, EntryType.UI_INPUT_END, -1643517441, a);
        }
    }

    /* compiled from: tap_pymm */
    class C03352 implements OnClickListener {
        final /* synthetic */ ContactPickerSectionInviteFriendsUpsellView f1977a;

        C03352(ContactPickerSectionInviteFriendsUpsellView contactPickerSectionInviteFriendsUpsellView) {
            this.f1977a = contactPickerSectionInviteFriendsUpsellView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1918706842);
            HoneyClientEventFast a2 = this.f1977a.f1982e.a("invite_friends_upsell_not_now", true);
            if (a2.a()) {
                a2.a("messenger_people_tab_invite_friends_upsell");
                a2.b();
            }
            InviteFriendsPeopleTabTopRowsController inviteFriendsPeopleTabTopRowsController = this.f1977a.f1981d;
            inviteFriendsPeopleTabTopRowsController.f2991a.edit().a(InviteFriendsPrefKeys.f2994a, inviteFriendsPeopleTabTopRowsController.f2992b.a()).a(InviteFriendsPrefKeys.f2995b, inviteFriendsPeopleTabTopRowsController.f2991a.a(InviteFriendsPrefKeys.f2995b, 0) + 1).commit();
            this.f1977a.setVisibility(8);
            Logger.a(2, EntryType.UI_INPUT_END, -703251703, a);
        }
    }

    public static void m1822a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ContactPickerSectionInviteFriendsUpsellView contactPickerSectionInviteFriendsUpsellView = (ContactPickerSectionInviteFriendsUpsellView) obj;
        Context context2 = (Context) fbInjector.getInstance(Context.class);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        InviteFriendsPeopleTabTopRowsController b = InviteFriendsPeopleTabTopRowsController.m2977b(fbInjector);
        AnalyticsLogger a = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        contactPickerSectionInviteFriendsUpsellView.f1979b = context2;
        contactPickerSectionInviteFriendsUpsellView.f1980c = secureContextHelper;
        contactPickerSectionInviteFriendsUpsellView.f1981d = b;
        contactPickerSectionInviteFriendsUpsellView.f1982e = a;
    }

    public ContactPickerSectionInviteFriendsUpsellView(Context context) {
        this(context, null, 0);
    }

    private ContactPickerSectionInviteFriendsUpsellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = ContactPickerSectionInviteFriendsUpsellView.class;
        m1822a(this, getContext());
        setPadding(0, getResources().getDimensionPixelOffset(2131428543), 0, 0);
        setContentView(2130905667);
        this.f1978a = (ContactPickerSectionUpsellView) findViewById(2131564789);
        this.f1978a.setNegativeButtonContentDescription(getResources().getString(2131240870));
        this.f1978a.setTitle(getResources().getString(2131240868));
        this.f1978a.setText(getResources().getString(2131240869));
        this.f1978a.setPositiveButtonText(getResources().getString(2131240871));
        this.f1978a.setPositiveButtonOnClickListener(new C03341(this));
        this.f1978a.setNegativeButtonOnClickListener(new C03352(this));
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getVisibility() == 8) {
            setMeasuredDimension(0, 0);
        }
    }
}
