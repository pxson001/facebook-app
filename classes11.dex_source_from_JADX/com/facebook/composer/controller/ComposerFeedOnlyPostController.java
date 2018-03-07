package com.facebook.composer.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerMutatorImpl;
import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.ui.feedonly.ComposerFeedOnlyPostToggleView;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsFeedOnlyPost;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicSetters.SetsIsFeedOnlyPost;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: inflation failed for item id =  */
public class ComposerFeedOnlyPostController<DataProvider extends ProvidesIsFeedOnlyPost & ProvidesConfiguration, Transaction extends ComposerTransaction & SetsIsFeedOnlyPost<Transaction>> implements ComposerEventHandler {
    public static final ComposerEventOriginator f6255a = ComposerEventOriginator.a(ComposerFeedOnlyPostController.class);
    private final ComposerFeedOnlyPostToggleView f6256b;
    private final WeakReference<DataProvider> f6257c;
    public final WeakReference<ComposerMutator<Transaction>> f6258d;

    /* compiled from: inflation failed for item id =  */
    class C07801 implements OnCheckedChangeListener {
        final /* synthetic */ ComposerFeedOnlyPostController f6254a;

        C07801(ComposerFeedOnlyPostController composerFeedOnlyPostController) {
            this.f6254a = composerFeedOnlyPostController;
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ((TransactionImpl) ((ComposerMutatorImpl) this.f6254a.f6258d.get()).m7626a(ComposerFeedOnlyPostController.f6255a).m7688a(z)).m7689a();
        }
    }

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public ComposerFeedOnlyPostController(Context context, QeAccessor qeAccessor, @Assisted ViewStub viewStub, @Assisted ComposerMutator<Transaction> composerMutator, @Assisted DataProvider dataProvider) {
        this.f6258d = new WeakReference(composerMutator);
        this.f6257c = new WeakReference(Preconditions.checkNotNull(dataProvider));
        if (qeAccessor.a(ExperimentsForComposerAbTestModule.F, false)) {
            ComposerConfiguration o = ((ProvidesConfiguration) dataProvider).o();
            Object obj = null;
            if (!o.isEdit() && o.getAllowFeedOnlyPost()) {
                obj = 1;
            }
            if (obj != null) {
                String a = qeAccessor.a(ExperimentsForComposerAbTestModule.E, 2131234788, context.getResources());
                String a2 = qeAccessor.a(ExperimentsForComposerAbTestModule.H, 2131234789, context.getResources());
                String a3 = qeAccessor.a(ExperimentsForComposerAbTestModule.G, 2131234790, context.getResources());
                this.f6256b = (ComposerFeedOnlyPostToggleView) viewStub.inflate();
                this.f6256b.setTitleText(a);
                this.f6256b.m8292a(a2, a3);
                this.f6256b.setOnCheckedChangeListener(new C07801(this));
                return;
            }
        }
        this.f6256b = null;
    }

    public final void m7718a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (this.f6256b != null) {
            ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6257c.get());
            if (composerEvent == ComposerEvent.ON_FIRST_DRAW) {
                if (composerDataProviderImpl.m7404E()) {
                    this.f6256b.setToggleChecked(true);
                }
            } else if (composerEvent == ComposerEvent.ON_DATASET_CHANGE) {
                this.f6256b.setToggleChecked(composerDataProviderImpl.m7404E());
            }
        }
    }
}
