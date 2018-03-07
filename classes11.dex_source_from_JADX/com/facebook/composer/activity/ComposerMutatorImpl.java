package com.facebook.composer.activity;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.model.ComposerModel;
import com.facebook.inject.Assisted;
import com.facebook.inject.IdBasedProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: invalid font weight  */
public class ComposerMutatorImpl {
    @VisibleForTesting
    final C07691 f6182a = new C07691(this);
    private final TransactionImplProvider f6183b;
    private final DefaultAndroidThreadUtil f6184c;
    public final Set<ComposerEventHandler> f6185d = new HashSet();
    @Nullable
    public TransactionImpl f6186e;
    public ComposerModel f6187f;

    /* compiled from: invalid font weight  */
    public class C07691 {
        public final /* synthetic */ ComposerMutatorImpl f6181a;

        C07691(ComposerMutatorImpl composerMutatorImpl) {
            this.f6181a = composerMutatorImpl;
        }
    }

    public final /* synthetic */ TransactionImpl m7626a(ComposerEventOriginator composerEventOriginator) {
        return m7630b(composerEventOriginator);
    }

    @Inject
    public ComposerMutatorImpl(TransactionImplProvider transactionImplProvider, DefaultAndroidThreadUtil defaultAndroidThreadUtil, @Assisted ComposerModel composerModel) {
        this.f6183b = transactionImplProvider;
        this.f6184c = defaultAndroidThreadUtil;
        this.f6187f = composerModel;
    }

    public final void m7627a(ComposerEvent composerEvent, ComposerEventOriginator composerEventOriginator) {
        for (ComposerEventHandler a : this.f6185d) {
            a.a(composerEvent, composerEventOriginator);
        }
    }

    public final TransactionImpl m7630b(ComposerEventOriginator composerEventOriginator) {
        this.f6184c.a();
        Preconditions.checkNotNull(composerEventOriginator);
        if (this.f6186e != null) {
            throw new IllegalStateException("Tried to start a transaction from originator " + composerEventOriginator.a + " but a transaction started by originator " + this.f6186e.f6222c.a + " is still in progress");
        }
        TransactionImplProvider transactionImplProvider = this.f6183b;
        ComposerModel composerModel = this.f6187f;
        this.f6186e = new TransactionImpl(composerModel, composerEventOriginator, this.f6182a, DefaultAndroidThreadUtil.b(transactionImplProvider), IdBasedProvider.a(transactionImplProvider, 4442));
        return this.f6186e;
    }

    public final void m7629a(ImmutableList<ComposerEventHandler> immutableList) {
        this.f6185d.addAll(immutableList);
    }

    public final void m7628a(ComposerEventHandler composerEventHandler) {
        this.f6185d.add(composerEventHandler);
    }
}
