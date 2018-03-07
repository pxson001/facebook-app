package com.facebook.orca.contacts.picker;

import android.content.Context;
import android.graphics.Point;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.telephony.FbPhoneNumberUtils;
import com.facebook.widget.tokenizedtypeahead.TokenizedAutoCompleteTextView;
import com.facebook.widget.tokenizedtypeahead.chips.ContactChipPopupMenuController;
import com.facebook.widget.tokenizedtypeahead.chips.ContactChipToken;
import com.facebook.widget.tokenizedtypeahead.chips.ContactChipUserStringUtil;
import com.facebook.widget.tokenizedtypeahead.model.Token;
import com.facebook.widget.tokenizedtypeahead.model.Token.OnTokenClickedListener;
import javax.inject.Inject;

/* compiled from: num_passed_because_of_nonexistent */
public class UserTokenFactory {
    public final ContactChipPopupMenuController f6100a;
    public int f6101b;
    public Integer f6102c;

    /* compiled from: num_passed_because_of_nonexistent */
    public class C09281 {
        public final /* synthetic */ TokenizedAutoCompleteTextView f6094a;
        final /* synthetic */ UserTokenFactory f6095b;

        public C09281(UserTokenFactory userTokenFactory, TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView) {
            this.f6095b = userTokenFactory;
            this.f6094a = tokenizedAutoCompleteTextView;
        }
    }

    /* compiled from: num_passed_because_of_nonexistent */
    public class C09292 implements OnTokenClickedListener {
        public final /* synthetic */ TokenizedAutoCompleteTextView f6096a;
        final /* synthetic */ Context f6097b;
        final /* synthetic */ C09281 f6098c;
        final /* synthetic */ UserTokenFactory f6099d;

        public C09292(UserTokenFactory userTokenFactory, TokenizedAutoCompleteTextView tokenizedAutoCompleteTextView, Context context, C09281 c09281) {
            this.f6099d = userTokenFactory;
            this.f6096a = tokenizedAutoCompleteTextView;
            this.f6097b = context;
            this.f6098c = c09281;
        }

        public final void m5812a(Token token) {
            ContactChipToken contactChipToken = (ContactChipToken) token;
            Point b = this.f6096a.b(contactChipToken);
            if (b != null) {
                b.y -= this.f6096a.getHeight();
                this.f6099d.f6100a.a(this.f6097b, contactChipToken, (this.f6099d.f6101b & 2) != 0, this.f6096a, b.x, b.y, this.f6099d.f6102c, this.f6098c);
            }
        }
    }

    public static UserTokenFactory m5813b(InjectorLike injectorLike) {
        return new UserTokenFactory(new ContactChipPopupMenuController(IdBasedProvider.a(injectorLike, 3608), new ContactChipUserStringUtil(FbPhoneNumberUtils.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike))));
    }

    @Inject
    public UserTokenFactory(ContactChipPopupMenuController contactChipPopupMenuController) {
        this.f6100a = contactChipPopupMenuController;
    }
}
