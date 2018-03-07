package com.facebook.feedplugins.graphqlstory.stickers;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feedplugins.graphqlstory.stickers.ui.StickerPostView;
import com.facebook.graphql.model.GraphQLSticker;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: init_feed_fetch_news_feed_before */
public class StickerPartDefinition extends BaseSinglePartDefinition<GraphQLStory, Uri, HasPersistentState, StickerPostView> {
    private static StickerPartDefinition f20072b;
    private static final Object f20073c = new Object();
    public final FbDraweeControllerBuilder f20074a;

    private static StickerPartDefinition m27788b(InjectorLike injectorLike) {
        return new StickerPartDefinition(FbDraweeControllerBuilder.m19410b(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStory graphQLStory = (GraphQLStory) obj;
        GraphQLSticker ar = graphQLStory.ar();
        Uri parse = ar == null ? PropertyHelper.m21306g(graphQLStory) != null ? Uri.parse(PropertyHelper.m21306g(graphQLStory)) : null : ar.m24754k() != null ? ImageUtil.m26990a(ar.m24754k()) : Uri.parse(ar.ad());
        return parse;
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 662084550);
        ((StickerPostView) view).a((Uri) obj2, this.f20074a);
        Logger.a(8, EntryType.MARK_POP, -1653899402, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((StickerPostView) view).a(null, null);
    }

    @Inject
    public StickerPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        this.f20074a = fbDraweeControllerBuilder;
    }

    public static StickerPartDefinition m27787a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StickerPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20073c) {
                StickerPartDefinition stickerPartDefinition;
                if (a2 != null) {
                    stickerPartDefinition = (StickerPartDefinition) a2.mo818a(f20073c);
                } else {
                    stickerPartDefinition = f20072b;
                }
                if (stickerPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27788b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20073c, b3);
                        } else {
                            f20072b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = stickerPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
