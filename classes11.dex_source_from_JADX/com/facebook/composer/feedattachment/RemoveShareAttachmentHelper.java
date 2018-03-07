package com.facebook.composer.feedattachment;

import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesRemovedUrls;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicSetters.SetsRemovedURLs;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.SetsShareParams;
import com.google.common.collect.ImmutableList;

/* compiled from: got_exception */
public class RemoveShareAttachmentHelper {
    private static final ComposerEventOriginator f6488a = ComposerEventOriginator.a(RemoveShareAttachmentHelper.class);

    private RemoveShareAttachmentHelper() {
    }

    public static <DataProvider extends ProvidesRemovedUrls & ProvidesShareParams, Transaction extends ComposerTransaction & SetsRemovedURLs<Transaction> & SetsShareParams<Transaction>> void m7923a(DataProvider dataProvider, ComposerMutator<Transaction> composerMutator) {
        TransactionImpl a = composerMutator.m7626a(f6488a);
        String str = ((ProvidesShareParams) dataProvider).q().linkForShare;
        if (str != null) {
            a.m7686a(ImmutableList.builder().b(dataProvider.f6035s.m7481a().f6745c.getRemovedURLs()).c(str).b());
        }
        ((TransactionImpl) a.m7683a(null)).m7689a();
    }
}
