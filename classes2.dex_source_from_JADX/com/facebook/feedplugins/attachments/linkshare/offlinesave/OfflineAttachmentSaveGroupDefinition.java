package com.facebook.feedplugins.attachments.linkshare.offlinesave;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.enums.GraphQLStorySaveType;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStorySaveInfo;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchTimeMs */
public class OfflineAttachmentSaveGroupDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStoryAttachment>, Void, HasPersistentState> {
    private static OfflineAttachmentSaveGroupDefinition f24269c;
    private static final Object f24270d = new Object();
    private final OfflineAttachmentSaveFooterPartDefinition f24271a;
    private final GatekeeperStoreImpl f24272b;

    private static OfflineAttachmentSaveGroupDefinition m32609b(InjectorLike injectorLike) {
        return new OfflineAttachmentSaveGroupDefinition(OfflineAttachmentSaveFooterPartDefinition.m32612a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    public final Object mo2535a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        obj = (FeedProps) obj;
        if (((OfflineAttachmentSaveFooterPersistentState) ((HasPersistentState) anyEnvironment).mo2425a(new OfflineAttachmentSaveFooterKey(obj), AttachmentProps.m28714c(obj))).f24281a) {
            baseMultiRowSubParts.m19112a(this.f24271a, obj);
        }
        return null;
    }

    public final boolean mo2536a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (AttachmentProps.m28714c(feedProps) == null) {
            return false;
        }
        GraphQLStorySaveInfo as = AttachmentProps.m28714c(feedProps).as();
        if (as == null) {
            return false;
        }
        boolean z;
        if (as.m24778m() == GraphQLSavedState.NOT_SAVED || as.m24778m() == GraphQLSavedState.SAVED || as.m24778m() == GraphQLSavedState.ARCHIVED) {
            z = true;
        } else {
            z = false;
        }
        if (this.f24272b.m2189a(811, false) && r0 && as.m24777l() == GraphQLStorySaveType.LINK) {
            return true;
        }
        return false;
    }

    @Inject
    public OfflineAttachmentSaveGroupDefinition(OfflineAttachmentSaveFooterPartDefinition offlineAttachmentSaveFooterPartDefinition, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f24271a = offlineAttachmentSaveFooterPartDefinition;
        this.f24272b = gatekeeperStoreImpl;
    }

    public static OfflineAttachmentSaveGroupDefinition m32608a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineAttachmentSaveGroupDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24270d) {
                OfflineAttachmentSaveGroupDefinition offlineAttachmentSaveGroupDefinition;
                if (a2 != null) {
                    offlineAttachmentSaveGroupDefinition = (OfflineAttachmentSaveGroupDefinition) a2.mo818a(f24270d);
                } else {
                    offlineAttachmentSaveGroupDefinition = f24269c;
                }
                if (offlineAttachmentSaveGroupDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32609b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24270d, b3);
                        } else {
                            f24269c = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineAttachmentSaveGroupDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
