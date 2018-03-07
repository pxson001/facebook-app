package com.facebook.platform.composer.composer;

import android.view.View;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.platform.composer.composer.PlatformComposerFragment.C05221;
import com.facebook.platform.composer.model.PlatformComposerModel;
import com.facebook.qe.api.QeAccessor;
import com.facebook.redspace.abtest.ExperimentsForRedSpaceExperimentsModule;
import com.facebook.widget.LazyView;
import com.facebook.widget.LazyView.OnInflateRunner;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: rich_document_fragment */
public class PlatformComposerRedSpaceController {
    private final QeAccessor f4129a;
    public final LazyView<CompoundButton> f4130b;

    @Inject
    public PlatformComposerRedSpaceController(QeAccessor qeAccessor, @Assisted ViewStub viewStub, @Assisted final C05221 c05221) {
        this.f4130b = new LazyView(viewStub, new OnInflateRunner<CompoundButton>(this) {
            final /* synthetic */ PlatformComposerRedSpaceController f4128b;

            /* compiled from: rich_document_fragment */
            class C05351 implements OnCheckedChangeListener {
                final /* synthetic */ C05361 f4126a;

                C05351(C05361 c05361) {
                    this.f4126a = c05361;
                }

                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ((C05221) Preconditions.checkNotNull(c05221)).m4004a(z ? RedSpaceValue.POST_TO_NEWSFEED : RedSpaceValue.POST_TO_REDSPACE);
                }
            }

            public final void m4095a(View view) {
                CompoundButton compoundButton = (CompoundButton) view;
                compoundButton.setOnCheckedChangeListener(new C05351(this));
                compoundButton.setText(2131238404);
            }
        });
        this.f4129a = qeAccessor;
    }

    public final boolean m4096a(PlatformComposerModel platformComposerModel) {
        TargetType targetType = platformComposerModel.f4190e.targetType;
        if ((targetType == TargetType.UNDIRECTED || targetType == TargetType.USER) && !platformComposerModel.f4187b.isEdit() && !platformComposerModel.f4188c.m4152d() && this.f4129a.a(ExperimentsForRedSpaceExperimentsModule.h, false) && this.f4129a.a(ExperimentsForRedSpaceExperimentsModule.b, false)) {
            return true;
        }
        return false;
    }
}
