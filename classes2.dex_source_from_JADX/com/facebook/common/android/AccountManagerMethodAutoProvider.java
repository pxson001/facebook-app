package com.facebook.common.android;

import android.accounts.AccountManager;
import android.content.Context;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: snippet */
public class AccountManagerMethodAutoProvider extends AbstractProvider<AccountManager> {
    public static AccountManager m8174b(InjectorLike injectorLike) {
        return AndroidModule.m2422s((Context) injectorLike.getInstance(Context.class));
    }

    public Object get() {
        return AndroidModule.m2422s((Context) getInstance(Context.class));
    }
}
