package com.facebook.composer.controller;

import android.view.ViewStub;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.capability.ComposerRedSpaceCapability.ProvidesCapability;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.ipc.composer.model.RedSpaceValue.SetsRedSpaceValue;

/* compiled from: honey_auth_debug */
public class ComposerRedSpaceControllerProvider extends AbstractAssistedProvider<ComposerRedSpaceController> {
    public static <DataProvider extends ProvidesCapability & ProvidesRedSpaceValue, Transaction extends ComposerTransaction & SetsRedSpaceValue<Transaction>> ComposerRedSpaceController<DataProvider, Transaction> m7731a(ViewStub viewStub, ComposerMutator<Transaction> composerMutator, DataProvider dataProvider) {
        return new ComposerRedSpaceController(viewStub, composerMutator, (ComposerDataProviderImpl) dataProvider);
    }
}
