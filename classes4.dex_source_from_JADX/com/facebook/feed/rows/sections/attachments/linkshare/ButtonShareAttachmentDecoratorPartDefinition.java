package com.facebook.feed.rows.sections.attachments.linkshare;

import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AttachmentHasClear;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.attachments.angora.AttachmentHasPlayIcon;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.calltoaction.ActionButtonPartDefinition;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

/* compiled from: originalExceptionMessage */
public class ButtonShareAttachmentDecoratorPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation & HasPrefetcher, V extends View & AngoraAttachment & AttachmentHasPlayIcon & AttachmentHasLargeImage> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f5922a = new AtomicReference();
    private final SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> f5923b;
    private final AngoraActionButtonController f5924c;
    private final ActionButtonPartDefinition<E, V> f5925d;
    private final QeAccessor f5926e;

    public final Object m6384a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f5923b, feedProps);
        subParts.a(this.f5925d, feedProps);
        return null;
    }

    public final boolean m6385a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.a;
        return this.f5924c.b(feedProps);
    }

    @Inject
    public ButtonShareAttachmentDecoratorPartDefinition(@Assisted SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> singlePartDefinition, AngoraActionButtonController angoraActionButtonController, ActionButtonPartDefinition actionButtonPartDefinition, QeAccessor qeAccessor) {
        this.f5923b = singlePartDefinition;
        this.f5924c = angoraActionButtonController;
        this.f5925d = actionButtonPartDefinition;
        this.f5926e = qeAccessor;
    }

    public final ViewType<V> m6383a() {
        if (f5922a.get() == null) {
            f5922a.set(this.f5926e.a(ExperimentsForFIGAttachmentModule.f11886a, false) ? FIGAttachmentView.f4166h : AngoraAttachmentView.f11887a);
        }
        return (ViewType) f5922a.get();
    }

    public final void m6386b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((AttachmentHasClear) view).mo341a();
    }
}
