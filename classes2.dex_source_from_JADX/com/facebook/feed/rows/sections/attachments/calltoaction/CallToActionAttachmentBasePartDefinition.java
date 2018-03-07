package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.facebook.attachments.angora.AngoraAttachment;
import com.facebook.attachments.angora.AttachmentHasLabel;
import com.facebook.attachments.angora.AttachmentHasRating;
import com.facebook.attachments.angora.AttachmentHasSubcontext;
import com.facebook.attachments.utils.CallToActionUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.directinstall.util.DirectInstallButtonHelper;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.ui.attachments.angora.LegacyAngoraAttachmentUtil;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.instantshopping.fetcher.InstantShoppingDocumentFetcher.PrefetchMonitor;
import com.facebook.instantshopping.links.InstantShoppingLinkHandler;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_closed_download_preview_pack_ids */
public class CallToActionAttachmentBasePartDefinition<E extends AnyEnvironment & HasInvalidate, V extends View & AngoraAttachment & AttachmentHasSubcontext & AttachmentHasRating> extends BaseSinglePartDefinition<Props, State, E, V> {
    private static CallToActionAttachmentBasePartDefinition f24135d;
    private static final Object f24136e = new Object();
    private final InstantShoppingLinkHandler f24137a;
    private final Context f24138b;
    private final ActionButtonPartDefinition<E, V> f24139c;

    private static CallToActionAttachmentBasePartDefinition m32505b(InjectorLike injectorLike) {
        return new CallToActionAttachmentBasePartDefinition(InstantShoppingLinkHandler.m32244b(injectorLike), (Context) injectorLike.getInstance(Context.class), ActionButtonPartDefinition.m32346a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m32502a(subParts, (Props) obj);
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 941261458);
        m32504a((State) obj2, view);
        Logger.a(8, EntryType.MARK_POP, -1951341063, a);
    }

    public static CallToActionAttachmentBasePartDefinition m32503a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            CallToActionAttachmentBasePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24136e) {
                CallToActionAttachmentBasePartDefinition callToActionAttachmentBasePartDefinition;
                if (a2 != null) {
                    callToActionAttachmentBasePartDefinition = (CallToActionAttachmentBasePartDefinition) a2.mo818a(f24136e);
                } else {
                    callToActionAttachmentBasePartDefinition = f24135d;
                }
                if (callToActionAttachmentBasePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32505b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24136e, b3);
                        } else {
                            f24135d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = callToActionAttachmentBasePartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public CallToActionAttachmentBasePartDefinition(InstantShoppingLinkHandler instantShoppingLinkHandler, Context context, ActionButtonPartDefinition actionButtonPartDefinition) {
        this.f24137a = instantShoppingLinkHandler;
        this.f24138b = context;
        this.f24139c = actionButtonPartDefinition;
    }

    private State m32502a(SubParts<E> subParts, Props props) {
        String a;
        Spannable spannable = null;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) props.a.f13444a;
        boolean a2 = AttachmentRatingHelper.a(graphQLStoryAttachment);
        int b = AttachmentRatingHelper.b(graphQLStoryAttachment);
        float c = AttachmentRatingHelper.c(graphQLStoryAttachment);
        boolean z = false;
        if (CallToActionUtil.m32459f(graphQLStoryAttachment)) {
            a = props.c.m32497a(graphQLStoryAttachment);
            z = DirectInstallButtonHelper.m32496b(graphQLStoryAttachment);
        } else {
            a = CallToActionUtil.m32458e(graphQLStoryAttachment) ? ActionLinkHelper.m22936a(graphQLStoryAttachment, -508788748).aB() : null;
        }
        Spannable a3 = props.b.m28835a(graphQLStoryAttachment);
        Spannable b2 = LegacyAngoraAttachmentUtil.m28833b(graphQLStoryAttachment);
        this.f24137a.m32245a(this.f24138b, graphQLStoryAttachment.m23966C());
        if (CallToActionUtil.m32466m(graphQLStoryAttachment)) {
            spannable = SpannableStringBuilder.valueOf(CallToActionUtil.m32454a(this.f24138b.getResources()));
        }
        subParts.mo2756a(this.f24139c, props.a);
        return new State(b, c, a, a3, b2, spannable, z, a2);
    }

    private static void m32504a(State state, V v) {
        ((AttachmentHasLabel) v).setTitle(state.d);
        ((AttachmentHasLabel) v).setContextText(state.e);
        ((AttachmentHasSubcontext) v).setSubcontextText(state.f);
        ((AttachmentHasRating) v).setNumberOfStars(state.a);
        ((AttachmentHasRating) v).setRating(state.b);
        ((AttachmentHasRating) v).setShowRating(state.h);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        InstantShoppingLinkHandler instantShoppingLinkHandler = this.f24137a;
        if (instantShoppingLinkHandler.f23853b != null) {
            PrefetchMonitor prefetchMonitor = instantShoppingLinkHandler.f23853b;
            if (prefetchMonitor.b != null) {
                prefetchMonitor.b.mo2782g();
            }
            if (prefetchMonitor.d != null) {
                prefetchMonitor.a.e.m32267c(prefetchMonitor.d.m());
            }
            instantShoppingLinkHandler.f23853b = null;
        }
    }
}
