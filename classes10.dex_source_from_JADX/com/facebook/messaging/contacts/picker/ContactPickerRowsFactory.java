package com.facebook.messaging.contacts.picker;

import com.facebook.contacts.graphql.ChatContextsGraphQLInterfaces.ChatContextForUser;
import com.facebook.contacts.picker.ContactPickerGroupRow;
import com.facebook.contacts.picker.ContactPickerGroupRow.GroupRowSectionType;
import com.facebook.contacts.picker.ContactPickerPaymentEligibleFooterRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.contacts.picker.ContactPickerUserRow.PushableType;
import com.facebook.contacts.picker.ContactPickerUserRow.RowStyle;
import com.facebook.contacts.picker.ContactPickerUserRowBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.presence.LastActiveHelper;
import com.facebook.messaging.presence.LastActiveHelper.TextFormat;
import com.facebook.messaging.presence.LastActiveHelper.Verbosity;
import com.facebook.messaging.ui.name.MessengerThreadNameViewDataFactory;
import com.facebook.messaging.ui.name.ThreadNameViewComputer;
import com.facebook.messaging.ui.name.ThreadNameViewComputer_DefaultThreadNameViewComputerMethodAutoProvider;
import com.facebook.messaging.users.MessengerUserCheckHelper;
import com.facebook.presence.DefaultPresenceManager;
import com.facebook.presence.PresenceState;
import com.facebook.push.mqtt.capability.MqttVoipCapabilityImpl;
import com.facebook.user.model.LastActive;
import com.facebook.user.model.User;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: tap_thread_option */
public class ContactPickerRowsFactory {
    private final DefaultPresenceManager f1911a;
    private final MessengerUserCheckHelper f1912b;
    private final LastActiveHelper f1913c;
    public final MessengerThreadNameViewDataFactory f1914d;
    public final ThreadNameViewComputer f1915e;
    private final MqttVoipCapabilityImpl f1916f;

    public static ContactPickerRowsFactory m1786b(InjectorLike injectorLike) {
        return new ContactPickerRowsFactory(DefaultPresenceManager.a(injectorLike), MessengerUserCheckHelper.b(injectorLike), LastActiveHelper.a(injectorLike), MessengerThreadNameViewDataFactory.a(injectorLike), ThreadNameViewComputer_DefaultThreadNameViewComputerMethodAutoProvider.b(injectorLike), MqttVoipCapabilityImpl.a(injectorLike));
    }

    public static ContactPickerRowsFactory m1785a(InjectorLike injectorLike) {
        return m1786b(injectorLike);
    }

    @Inject
    public ContactPickerRowsFactory(DefaultPresenceManager defaultPresenceManager, MessengerUserCheckHelper messengerUserCheckHelper, LastActiveHelper lastActiveHelper, MessengerThreadNameViewDataFactory messengerThreadNameViewDataFactory, ThreadNameViewComputer threadNameViewComputer, MqttVoipCapabilityImpl mqttVoipCapabilityImpl) {
        this.f1911a = defaultPresenceManager;
        this.f1912b = messengerUserCheckHelper;
        this.f1913c = lastActiveHelper;
        this.f1914d = messengerThreadNameViewDataFactory;
        this.f1915e = threadNameViewComputer;
        this.f1916f = mqttVoipCapabilityImpl;
    }

    public final ContactPickerUserRow m1789a(User user, ContactRowSectionType contactRowSectionType) {
        return m1784a(user, true, contactRowSectionType).a();
    }

    public final ContactPickerUserRow m1790a(User user, ContactRowSectionType contactRowSectionType, @Nullable ChatContextForUser chatContextForUser) {
        ContactPickerUserRowBuilder a = m1784a(user, true, contactRowSectionType);
        a.b = RowStyle.ONE_LINE;
        a = a;
        a.k = chatContextForUser;
        return a.a();
    }

    public final ContactPickerUserRow m1788a(User user) {
        return m1784a(user, false, ContactRowSectionType.SELF_PROFILE).a();
    }

    public final ContactPickerUserRow m1791a(User user, ContactRowSectionType contactRowSectionType, boolean z) {
        ContactPickerUserRowBuilder a = m1784a(user, true, contactRowSectionType);
        a.z = true;
        a = a;
        a.j = z;
        return a.a();
    }

    public final ContactPickerUserRow m1792b(User user, ContactRowSectionType contactRowSectionType, boolean z) {
        ContactPickerUserRowBuilder a = m1784a(user, false, contactRowSectionType);
        a.z = true;
        a = a;
        a.j = z;
        a = a;
        a.b = RowStyle.NEUE_PICKER;
        return a.a();
    }

    private ContactPickerUserRowBuilder m1784a(User user, boolean z, ContactRowSectionType contactRowSectionType) {
        ContactPickerUserRowBuilder contactPickerUserRowBuilder = new ContactPickerUserRowBuilder();
        contactPickerUserRowBuilder.a = user;
        contactPickerUserRowBuilder = contactPickerUserRowBuilder;
        contactPickerUserRowBuilder.b = RowStyle.ONE_LINE;
        contactPickerUserRowBuilder = contactPickerUserRowBuilder;
        contactPickerUserRowBuilder.h = z;
        contactPickerUserRowBuilder = contactPickerUserRowBuilder;
        contactPickerUserRowBuilder.m = contactRowSectionType;
        ContactPickerUserRowBuilder contactPickerUserRowBuilder2 = contactPickerUserRowBuilder;
        if (z) {
            String str;
            PushableType pushableType;
            boolean b = this.f1911a.b(user.T);
            LastActive d = this.f1911a.d(user.T);
            PresenceState c = this.f1911a.c(user.T);
            boolean a = this.f1912b.a(user);
            contactPickerUserRowBuilder2.e = b;
            ContactPickerUserRowBuilder contactPickerUserRowBuilder3 = contactPickerUserRowBuilder2;
            contactPickerUserRowBuilder3.f = this.f1916f.a(c.g());
            contactPickerUserRowBuilder3 = contactPickerUserRowBuilder3;
            contactPickerUserRowBuilder3.g = c.c;
            contactPickerUserRowBuilder3 = contactPickerUserRowBuilder3;
            if (b) {
                str = null;
            } else {
                str = this.f1913c.a(d, c, Verbosity.SHORT, TextFormat.UPPER_CASE);
            }
            contactPickerUserRowBuilder3.i = str;
            ContactPickerUserRowBuilder contactPickerUserRowBuilder4 = contactPickerUserRowBuilder3;
            if (a) {
                pushableType = PushableType.ON_MESSENGER;
            } else {
                pushableType = PushableType.ON_FACEBOOK;
            }
            contactPickerUserRowBuilder4.l = pushableType;
        }
        return contactPickerUserRowBuilder2;
    }

    public final ContactPickerGroupRow m1787a(ThreadSummary threadSummary, GroupRowSectionType groupRowSectionType) {
        ContactPickerGroupRow contactPickerGroupRow = new ContactPickerGroupRow(threadSummary, groupRowSectionType, this.f1915e.a(this.f1914d.a(threadSummary), 3).toString(), null);
        if (null != null) {
            contactPickerGroupRow.k = true;
            contactPickerGroupRow.h = false;
            contactPickerGroupRow.b(true);
            contactPickerGroupRow.a(true);
        }
        return contactPickerGroupRow;
    }

    public static ContactPickerPaymentEligibleFooterRow m1783a(String str) {
        return new ContactPickerPaymentEligibleFooterRow(str);
    }
}
