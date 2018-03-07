package com.facebook.composer.controller;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.capability.ComposerRedSpaceCapability.ProvidesCapability;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.ipc.composer.model.RedSpaceValue.SetsRedSpaceValue;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: hostLifecycleEvent */
public class ComposerRedSpaceController<DataProvider extends ProvidesCapability & ProvidesRedSpaceValue, Transaction extends ComposerTransaction & SetsRedSpaceValue<Transaction>> implements ComposerEventHandler {
    public static final ComposerEventOriginator f6291a = ComposerEventOriginator.a(ComposerRedSpaceController.class);
    private final LazyView<CompoundButton> f6292b;
    private final WeakReference<DataProvider> f6293c;

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public ComposerRedSpaceController(@Assisted ViewStub viewStub, @Assisted final ComposerMutator<Transaction> composerMutator, @Assisted DataProvider dataProvider) {
        this.f6293c = new WeakReference(Preconditions.checkNotNull(dataProvider));
        Preconditions.checkNotNull(composerMutator);
        this.f6292b = new LazyView(viewStub, new OnInflateRunner<CompoundButton>(this) {
            final /* synthetic */ ComposerRedSpaceController f6290b;

            /* compiled from: hostLifecycleEvent */
            class C07841 implements OnCheckedChangeListener {
                final /* synthetic */ C07851 f6288a;

                C07841(C07851 c07851) {
                    this.f6288a = c07851;
                }

                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    RedSpaceValue redSpaceValue;
                    TransactionImpl a = composerMutator.m7626a(ComposerRedSpaceController.f6291a);
                    if (z) {
                        redSpaceValue = RedSpaceValue.POST_TO_NEWSFEED;
                    } else {
                        redSpaceValue = RedSpaceValue.POST_TO_REDSPACE;
                    }
                    a.m7693b(redSpaceValue).m7689a();
                }
            }

            public final void m7727a(View view) {
                CompoundButton compoundButton = (CompoundButton) view;
                compoundButton.setOnCheckedChangeListener(new C07841(this));
                compoundButton.setText(2131234763);
            }
        });
        m7728b();
    }

    private void m7728b() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6293c.get());
        if (m7729c()) {
            boolean z;
            ((CompoundButton) this.f6292b.a()).setVisibility(0);
            CompoundButton compoundButton = (CompoundButton) this.f6292b.a();
            if (((ProvidesRedSpaceValue) composerDataProviderImpl).k() == RedSpaceValue.POST_TO_NEWSFEED) {
                z = true;
            } else {
                z = false;
            }
            compoundButton.setChecked(z);
            return;
        }
        this.f6292b.c();
    }

    public final void m7730a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (composerEvent == ComposerEvent.ON_DATASET_CHANGE || composerEvent == ComposerEvent.ON_FIRST_DRAW) {
            m7728b();
        }
    }

    @VisibleForTesting
    private boolean m7729c() {
        return ((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6293c.get())).ay();
    }
}
