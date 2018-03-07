package com.facebook.composer.feedattachment;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass33;
import com.facebook.composer.activity.ComposerMutatorImpl;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.gating.ComposerGatekeepers;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.friendsharing.gif.util.GifUtil;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesRemovedUrls;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicSetters.SetsRemovedURLs;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.SetsShareParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: grid_load */
public class GifComposerAttachment<DataProvider extends ProvidesRemovedUrls & ProvidesShareParams, Transaction extends ComposerTransaction & SetsRemovedURLs<Transaction> & SetsShareParams<Transaction>> implements ComposerFeedAttachment {
    private final GatekeeperStoreImpl f6450a;
    public final WeakReference<Callback> f6451b;
    public final WeakReference<DataProvider> f6452c;
    public final WeakReference<ComposerMutator<Transaction>> f6453d;
    @Nullable
    private GifAttachmentView f6454e;

    /* compiled from: grid_load */
    class C08141 implements OnClickListener {
        final /* synthetic */ GifComposerAttachment f6448a;

        C08141(GifComposerAttachment gifComposerAttachment) {
            this.f6448a = gifComposerAttachment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -786911890);
            RemoveShareAttachmentHelper.m7923a((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6448a.f6452c.get()), (ComposerMutatorImpl) Preconditions.checkNotNull(this.f6448a.f6453d.get()));
            ((AnonymousClass33) Preconditions.checkNotNull(this.f6448a.f6451b.get())).m7464a();
            Logger.a(2, EntryType.UI_INPUT_END, 1190804862, a);
        }
    }

    /* compiled from: grid_load */
    /* synthetic */ class C08152 {
        static final /* synthetic */ int[] f6449a = new int[ComposerEvent.values().length];

        static {
            try {
                f6449a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    @Inject
    public GifComposerAttachment(GatekeeperStore gatekeeperStore, @Assisted DataProvider dataProvider, @Assisted ComposerMutator<Transaction> composerMutator, @Assisted Callback callback) {
        this.f6450a = gatekeeperStore;
        this.f6452c = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6453d = new WeakReference(Preconditions.checkNotNull(composerMutator));
        this.f6451b = new WeakReference(Preconditions.checkNotNull(callback));
    }

    public final void mo188a(ViewGroup viewGroup) {
        this.f6454e = new GifAttachmentView(viewGroup.getContext());
        viewGroup.addView(this.f6454e);
        this.f6454e.setRemoveButtonClickListener(new C08141(this));
        m7874c();
    }

    private void m7874c() {
        String str = ((ProvidesShareParams) ((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6452c.get()))).q().linkForShare;
        GifAttachmentView gifAttachmentView = this.f6454e;
        if (!str.equals(gifAttachmentView.f6447f)) {
            gifAttachmentView.f6447f = str;
            gifAttachmentView.f6445d.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) gifAttachmentView.f6443a.a(GifAttachmentView.f6442b).a(str).b(gifAttachmentView.f6445d.getController())).a(gifAttachmentView.f6446e)).s());
        }
    }

    public final void mo190b() {
        this.f6454e.setRemoveButtonClickListener(null);
        this.f6454e = null;
    }

    public final boolean mo189a() {
        if (!this.f6450a.a(ComposerGatekeepers.b, false)) {
            return false;
        }
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6452c.get());
        if (((ProvidesShareParams) composerDataProviderImpl).q() == null || StringUtil.a(((ProvidesShareParams) composerDataProviderImpl).q().linkForShare)) {
            return false;
        }
        return GifUtil.a(((ProvidesShareParams) composerDataProviderImpl).q());
    }

    public final void m7876a(ComposerEvent composerEvent, ComposerEventOriginator composerEventOriginator) {
        switch (C08152.f6449a[composerEvent.ordinal()]) {
            case 1:
                m7874c();
                return;
            default:
                return;
        }
    }
}
