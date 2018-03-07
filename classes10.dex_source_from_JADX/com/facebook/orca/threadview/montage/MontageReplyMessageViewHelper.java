package com.facebook.orca.threadview.montage;

import com.facebook.imagepipeline.animated.base.AnimatableDrawable;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.orca.threadview.MessageListAdapter;
import com.facebook.orca.threadview.MessageListAdapter.SimpleListener;
import com.facebook.orca.threadview.MessageListAdapterForRecyclerView;
import com.facebook.orca.threadview.MessageListAdapterForRecyclerViewProvider;
import com.facebook.orca.threadview.RowMessageItemGenerator;
import javax.inject.Inject;

/* compiled from: manual_imp */
public class MontageReplyMessageViewHelper {
    public final Lazy<MessageListAdapter> f8258a;
    public final Lazy<RowMessageItemGenerator> f8259b;
    public final MessageListAdapterForRecyclerViewProvider f8260c;
    public MessageListAdapterForRecyclerView f8261d;

    /* compiled from: manual_imp */
    public class MessageItemListener extends SimpleListener {
        public final void mo285a(RowMessageItem rowMessageItem, AnimatableDrawable animatableDrawable) {
            if (animatableDrawable != null) {
                animatableDrawable.start();
            }
        }
    }

    public static MontageReplyMessageViewHelper m8239b(InjectorLike injectorLike) {
        return new MontageReplyMessageViewHelper(IdBasedLazy.a(injectorLike, 8842), IdBasedLazy.a(injectorLike, 8855), (MessageListAdapterForRecyclerViewProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(MessageListAdapterForRecyclerViewProvider.class));
    }

    @Inject
    public MontageReplyMessageViewHelper(Lazy<MessageListAdapter> lazy, Lazy<RowMessageItemGenerator> lazy2, MessageListAdapterForRecyclerViewProvider messageListAdapterForRecyclerViewProvider) {
        this.f8258a = lazy;
        this.f8259b = lazy2;
        this.f8260c = messageListAdapterForRecyclerViewProvider;
    }
}
