package com.facebook.feedplugins.creativeediting;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.ContextUtils;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FrameModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.toaster.ToastBuilder;
import com.google.common.collect.ImmutableList;

/* compiled from: SuggestEditsHeaderQuery */
class FrameCallToActionPartDefinition$1 implements OnClickListener {
    final /* synthetic */ GraphQLStoryActionLink f23063a;
    final /* synthetic */ FrameCallToActionPartDefinition f23064b;

    FrameCallToActionPartDefinition$1(FrameCallToActionPartDefinition frameCallToActionPartDefinition, GraphQLStoryActionLink graphQLStoryActionLink) {
        this.f23064b = frameCallToActionPartDefinition;
        this.f23063a = graphQLStoryActionLink;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1031751109);
        final FragmentActivity fragmentActivity = (FragmentActivity) ContextUtils.a(view.getContext(), FragmentActivity.class);
        ProgressDialogFragment.a(2131234494, true, true, true).a(fragmentActivity.kO_(), null);
        this.f23064b.c.a("any", this.f23064b.d.a(), new AbstractDisposableFutureCallback<ImmutableList<FramePack>>(this) {
            final /* synthetic */ FrameCallToActionPartDefinition$1 f23062b;

            protected final void m25517a(Object obj) {
                ImmutableList immutableList = (ImmutableList) obj;
                if (immutableList.isEmpty() || ((FramePackModel) immutableList.get(0)).c().isEmpty()) {
                    m25516b();
                    return;
                }
                String aH;
                int size = immutableList.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    FramePackModel framePackModel = (FramePackModel) immutableList.get(i);
                    if (i2 != 0) {
                        break;
                    }
                    int i3;
                    ImmutableList c = framePackModel.c();
                    int size2 = c.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        if (((FrameModel) c.get(i4)).c().equals(this.f23062b.f23063a.aH())) {
                            i3 = 1;
                            break;
                        }
                    }
                    i3 = i2;
                    i++;
                    i2 = i3;
                }
                if (i2 != 0) {
                    aH = this.f23062b.f23063a.aH();
                } else {
                    aH = ((FrameModel) ((FramePackModel) immutableList.get(0)).c().get(0)).c();
                }
                FrameCallToActionPartDefinition.a(this.f23062b.f23064b, fragmentActivity, aH, immutableList);
            }

            private void m25516b() {
                this.f23062b.f23064b.e.a(new ToastBuilder(2131234495));
            }

            public final void m25518a(Throwable th) {
                m25516b();
            }
        });
        Logger.a(2, EntryType.UI_INPUT_END, 886589581, a);
    }
}
