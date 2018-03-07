package com.facebook.orca.contacts.picker;

import com.facebook.user.model.User;
import com.facebook.user.model.UserSmsIdentifier;
import com.facebook.widget.tokenizedtypeahead.model.UserToken;

/* compiled from: num_skipped_events */
public class PickerUserToken extends UserToken {
    public PickerUserToken(User user) {
        super(user);
    }

    public final int m5805n() {
        UserSmsIdentifier userSmsIdentifier;
        User user = this.e;
        if (user.U instanceof UserSmsIdentifier) {
            userSmsIdentifier = (UserSmsIdentifier) user.U;
        } else {
            userSmsIdentifier = null;
        }
        if (userSmsIdentifier != null) {
            return 2130843690;
        }
        return super.n();
    }
}
