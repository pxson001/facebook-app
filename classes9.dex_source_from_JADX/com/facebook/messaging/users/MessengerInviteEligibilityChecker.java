package com.facebook.messaging.users;

import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: chat_head_nux_message_top_button */
public class MessengerInviteEligibilityChecker {
    private final MessengerUserCheckHelper f18315a;
    public final boolean f18316b;
    public final Provider<Boolean> f18317c;
    public final Product f18318d;

    public static MessengerInviteEligibilityChecker m18271b(InjectorLike injectorLike) {
        return new MessengerInviteEligibilityChecker(IdBasedProvider.a(injectorLike, 3902), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), MessengerUserCheckHelper.m18273b(injectorLike), ProductMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public MessengerInviteEligibilityChecker(Provider<Boolean> provider, Boolean bool, MessengerUserCheckHelper messengerUserCheckHelper, Product product) {
        this.f18317c = provider;
        this.f18316b = bool.booleanValue();
        this.f18315a = messengerUserCheckHelper;
        this.f18318d = product;
    }

    public static MessengerInviteEligibilityChecker m18270a(InjectorLike injectorLike) {
        return m18271b(injectorLike);
    }

    public final boolean m18272a(@Nullable UserKey userKey) {
        Object obj;
        if (this.f18318d != Product.MESSENGER || ((Boolean) this.f18317c.get()).booleanValue() || this.f18316b) {
            obj = null;
        } else {
            obj = 1;
        }
        if (!(obj == null || userKey == null)) {
            obj = 1;
            User a = this.f18315a.f18321c.a(userKey);
            if (a != null) {
                String str = a.s;
                if (!(str == null || "user".equals(str))) {
                    obj = null;
                }
            }
            if (!(obj == null || this.f18315a.m18276c(userKey) || this.f18315a.m18275a(userKey) || ((User) this.f18315a.f18320b.get()).a.equals(userKey.b()))) {
                return true;
            }
        }
        return false;
    }
}
