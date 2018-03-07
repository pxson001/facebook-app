package com.facebook.feedplugins.attachments.linkshare.offlinesave;

import android.content.Context;
import android.view.View;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.xconfig.core.XConfigReader;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetchSessionlessGKInfo */
public class OfflineAttachmentSaveFooterPartDefinition<E extends HasInvalidate & HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, OfflineAttachmentSaveFooterPersistentState, E, OfflineAttachmentSaveFooterView> {
    private static OfflineAttachmentSaveFooterPartDefinition f24273e;
    private static final Object f24274f = new Object();
    private final ClickListenerPartDefinition f24275a;
    public final SaveButtonUtils f24276b;
    public final XConfigReader f24277c;
    public final FbSharedPreferences f24278d;

    private static OfflineAttachmentSaveFooterPartDefinition m32613b(InjectorLike injectorLike) {
        return new OfflineAttachmentSaveFooterPartDefinition(ClickListenerPartDefinition.m19353a(injectorLike), SaveButtonUtils.m18452a(injectorLike), XConfigReader.m2681a(injectorLike), FbSharedPreferencesImpl.m1826a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        FeedProps e = AttachmentProps.m28715e(feedProps);
        CacheableEntity cacheableEntity = (GraphQLStory) e.f13444a;
        OfflineAttachmentSaveFooterPersistentState offlineAttachmentSaveFooterPersistentState = (OfflineAttachmentSaveFooterPersistentState) ((HasPersistentState) hasInvalidate).mo2425a(new OfflineAttachmentSaveFooterKey(feedProps), cacheableEntity);
        if (cacheableEntity.as() != null) {
            boolean z;
            if (cacheableEntity.as().m24778m() == GraphQLSavedState.SAVED) {
                z = true;
            } else {
                z = false;
            }
            offlineAttachmentSaveFooterPersistentState.f24282b = z;
        }
        subParts.mo2756a(this.f24275a, new 1(this, offlineAttachmentSaveFooterPersistentState, e, hasInvalidate, cacheableEntity));
        return offlineAttachmentSaveFooterPersistentState;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -382116819);
        OfflineAttachmentSaveFooterPersistentState offlineAttachmentSaveFooterPersistentState = (OfflineAttachmentSaveFooterPersistentState) obj2;
        OfflineAttachmentSaveFooterView offlineAttachmentSaveFooterView = (OfflineAttachmentSaveFooterView) view;
        offlineAttachmentSaveFooterView.a();
        boolean z = offlineAttachmentSaveFooterPersistentState.f24282b;
        if (offlineAttachmentSaveFooterView.c != null) {
            offlineAttachmentSaveFooterView.d.setText(z ? 2131235700 : 2131235699);
        }
        Logger.a(8, EntryType.MARK_POP, -1995978133, a);
    }

    @Inject
    public OfflineAttachmentSaveFooterPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, SaveButtonUtils saveButtonUtils, XConfigReader xConfigReader, FbSharedPreferences fbSharedPreferences) {
        this.f24275a = clickListenerPartDefinition;
        this.f24276b = saveButtonUtils;
        this.f24277c = xConfigReader;
        this.f24278d = fbSharedPreferences;
    }

    public static OfflineAttachmentSaveFooterPartDefinition m32612a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineAttachmentSaveFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24274f) {
                OfflineAttachmentSaveFooterPartDefinition offlineAttachmentSaveFooterPartDefinition;
                if (a2 != null) {
                    offlineAttachmentSaveFooterPartDefinition = (OfflineAttachmentSaveFooterPartDefinition) a2.mo818a(f24274f);
                } else {
                    offlineAttachmentSaveFooterPartDefinition = f24273e;
                }
                if (offlineAttachmentSaveFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32613b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24274f, b3);
                        } else {
                            f24273e = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineAttachmentSaveFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType<OfflineAttachmentSaveFooterView> mo2547a() {
        return OfflineAttachmentSaveFooterView.a;
    }

    public final boolean m32617a(Object obj) {
        return true;
    }
}
