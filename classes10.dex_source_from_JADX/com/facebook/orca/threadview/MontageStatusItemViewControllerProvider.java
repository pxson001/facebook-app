package com.facebook.orca.threadview;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;

/* compiled from: messenger_conversation_starters */
public class MontageStatusItemViewControllerProvider extends AbstractAssistedProvider<MontageStatusItemViewController> {
    public final MontageStatusItemViewController m6953a(MontageStatusItemView montageStatusItemView) {
        return new MontageStatusItemViewController(montageStatusItemView, IdBasedLazy.a(this, 8829), IdBasedSingletonScopeProvider.b(this, 968), IdBasedSingletonScopeProvider.b(this, 610), IdBasedLazy.a(this, 3588), IdBasedLazy.a(this, 3593), MontageThreadHelper.m6956b(this), MontageThreadHelper.m6956b(this), IdBasedProvider.a(this, 3595), IdBasedLazy.a(this, 401), IdBasedProvider.a(this, 7975));
    }
}
