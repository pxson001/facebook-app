package com.facebook.feed.rows.sections.attachments.linkshare;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AngoraAttachmentView;
import com.facebook.attachments.angora.AttachmentHasPlayIcon;
import com.facebook.attachments.angora.actionbutton.AngoraActionButtonController;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.calltoaction.ActionButtonPartDefinition;
import com.facebook.fig.attachment.FIGAttachmentView;
import com.facebook.fig.attachment.qe.ExperimentsForFIGAttachmentModule;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: org.hibernate.repackage.cglib */
public class VideoShareAttachmentPartDefinition<E extends HasInvalidate & HasPositionInformation & HasPersistentState & HasPrefetcher, V extends View & AngoraAttachment & AttachmentHasPlayIcon> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, Void, E, V> {
    @VisibleForTesting
    static final AtomicReference<ViewType> f5949a = new AtomicReference();
    private static VideoShareAttachmentPartDefinition f5950h;
    private static final Object f5951i = new Object();
    private final BaseShareAttachmentPartDefinition<E, V> f5952b;
    private final AngoraActionButtonController f5953c;
    private final ActionButtonPartDefinition<E, V> f5954d;
    private final SidePhotoPartDefinition<E, V> f5955e;
    private final int f5956f;
    private final QeAccessor f5957g;

    private static VideoShareAttachmentPartDefinition m6410b(InjectorLike injectorLike) {
        return new VideoShareAttachmentPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), SidePhotoPartDefinition.a(injectorLike), BaseShareAttachmentPartDefinition.a(injectorLike), AngoraActionButtonController.a(injectorLike), ActionButtonPartDefinition.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m6412a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f5952b, feedProps);
        if (this.f5953c.b(feedProps)) {
            subParts.a(this.f5954d, feedProps);
        }
        subParts.a(this.f5955e, new SidePhotoPartDefinition$Props((GraphQLStoryAttachment) feedProps.a, this.f5956f));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m6413a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -29758404);
        m6409a((FeedProps) obj, view);
        Logger.a(8, EntryType.MARK_POP, -1744682041, a);
    }

    public static VideoShareAttachmentPartDefinition m6408a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoShareAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f5951i) {
                VideoShareAttachmentPartDefinition videoShareAttachmentPartDefinition;
                if (a2 != null) {
                    videoShareAttachmentPartDefinition = (VideoShareAttachmentPartDefinition) a2.a(f5951i);
                } else {
                    videoShareAttachmentPartDefinition = f5950h;
                }
                if (videoShareAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6410b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f5951i, b3);
                        } else {
                            f5950h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoShareAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoShareAttachmentPartDefinition(Resources resources, SidePhotoPartDefinition sidePhotoPartDefinition, BaseShareAttachmentPartDefinition baseShareAttachmentPartDefinition, AngoraActionButtonController angoraActionButtonController, ActionButtonPartDefinition actionButtonPartDefinition, QeAccessor qeAccessor) {
        this.f5952b = baseShareAttachmentPartDefinition;
        this.f5953c = angoraActionButtonController;
        this.f5954d = actionButtonPartDefinition;
        this.f5955e = sidePhotoPartDefinition;
        this.f5956f = resources.getDimensionPixelSize(2131427517);
        this.f5957g = qeAccessor;
    }

    public final ViewType m6411a() {
        if (f5949a.get() == null) {
            f5949a.set(this.f5957g.a(ExperimentsForFIGAttachmentModule.f11886a, false) ? FIGAttachmentView.f4166h : AngoraAttachmentView.f11887a);
        }
        return (ViewType) f5949a.get();
    }

    public final boolean m6414a(Object obj) {
        return true;
    }

    private static void m6409a(FeedProps<GraphQLStoryAttachment> feedProps, V v) {
        int i;
        if (((GraphQLStoryAttachment) feedProps.a).r() != null) {
            i = 0;
        } else {
            i = 8;
        }
        ((AttachmentHasPlayIcon) v).setSidePhotoPlayIconVisibility(i);
    }
}
