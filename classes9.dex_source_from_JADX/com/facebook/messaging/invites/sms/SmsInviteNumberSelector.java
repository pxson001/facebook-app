package com.facebook.messaging.invites.sms;

import com.facebook.user.model.User;
import com.facebook.user.model.UserPhoneNumber;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: mPeerName */
public class SmsInviteNumberSelector {
    @Nullable
    public static UserPhoneNumber m11954a(User user) {
        ImmutableList r = user.r();
        int size = r.size();
        for (int i = 0; i < size; i++) {
            UserPhoneNumber userPhoneNumber = (UserPhoneNumber) r.get(i);
            if (userPhoneNumber.d == 2) {
                return userPhoneNumber;
            }
        }
        return null;
    }
}
