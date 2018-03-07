package com.facebook.messaging.contacts.picker;

import com.facebook.contacts.picker.ContactPickerGroupRow.GroupRowSectionType;
import com.facebook.contacts.picker.ContactPickerListFilter.RowCreator;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.user.model.User;
import javax.inject.Inject;

/* compiled from: tap_composer_list_item */
public class DefaultMultiPickerRowCreator {
    public static final Class<?> f2048a = DefaultMultiPickerRowCreator.class;
    public final ContactPickerRowsFactory f2049b;

    /* compiled from: tap_composer_list_item */
    public class C03431 implements RowCreator {
        final /* synthetic */ DefaultMultiPickerRowCreator f2047a;

        public C03431(DefaultMultiPickerRowCreator defaultMultiPickerRowCreator) {
            this.f2047a = defaultMultiPickerRowCreator;
        }

        public final ContactPickerRow m1877a(Object obj) {
            if (!(obj instanceof User) && !(obj instanceof ThreadSummary)) {
                BLog.a(DefaultMultiPickerRowCreator.f2048a, "unexpected rowData of type: %s", new Object[]{obj.getClass()});
                throw new IllegalArgumentException();
            } else if (obj instanceof ThreadSummary) {
                return this.f2047a.f2049b.m1787a((ThreadSummary) obj, GroupRowSectionType.AUTO_COMPLETE);
            } else {
                return this.f2047a.f2049b.m1789a((User) obj, ContactRowSectionType.AUTO_COMPLETE);
            }
        }
    }

    public static DefaultMultiPickerRowCreator m1878b(InjectorLike injectorLike) {
        return new DefaultMultiPickerRowCreator(ContactPickerRowsFactory.m1786b(injectorLike));
    }

    @Inject
    DefaultMultiPickerRowCreator(ContactPickerRowsFactory contactPickerRowsFactory) {
        this.f2049b = contactPickerRowsFactory;
    }

    public final ContactPickerRow m1879a(User user, boolean z, ContactRowSectionType contactRowSectionType) {
        ContactPickerUserRow a;
        if (contactRowSectionType == ContactRowSectionType.OMNIPICKER_SUGGESTIONS) {
            a = this.f2049b.m1789a(user, contactRowSectionType);
        } else {
            a = this.f2049b.m1791a(user, contactRowSectionType, z);
        }
        return a;
    }
}
