package com.facebook.feedplugins.pyml.rows.contentbased;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feedplugins.pyml.EgoUnitUtil;
import com.facebook.feedplugins.pyml.rows.contentbased.ui.ContentBasedPageYouMayLikeFallbackContentView;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.SuggestedPageUnitItem;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: notifications_mqtt_sync_interval */
public class PymlFallbackPagePartDefinition extends BaseSinglePartDefinitionWithViewType<PagesYouMayLikeItemViewModelProps, Uri, AnyEnvironment, ContentBasedPageYouMayLikeFallbackContentView> {
    public static final ViewType<ContentBasedPageYouMayLikeFallbackContentView> f6718a = new C03121();
    public static final CallerContext f6719b = CallerContext.a(ContentBasedPageYouMayLikeFallbackContentView.class, "native_newsfeed", "cover_photo");
    private static PymlFallbackPagePartDefinition f6720g;
    private static final Object f6721h = new Object();
    private final ContentBasedPageYouMayLikePartDefinition f6722c;
    private final PymlActorPhotoPartDefinition f6723d;
    private final ClickListenerPartDefinition f6724e;
    public final DefaultFeedUnitRenderer f6725f;

    /* compiled from: notifications_mqtt_sync_interval */
    final class C03121 extends ViewType<ContentBasedPageYouMayLikeFallbackContentView> {
        C03121() {
        }

        public final View m7116a(Context context) {
            return new ContentBasedPageYouMayLikeFallbackContentView(context);
        }
    }

    private static PymlFallbackPagePartDefinition m7110b(InjectorLike injectorLike) {
        return new PymlFallbackPagePartDefinition(ContentBasedPageYouMayLikePartDefinition.a(injectorLike), PymlActorPhotoPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike), DefaultFeedUnitRenderer.a(injectorLike));
    }

    public final Object m7112a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Uri uri;
        PagesYouMayLikeItemViewModelProps pagesYouMayLikeItemViewModelProps = (PagesYouMayLikeItemViewModelProps) obj;
        subParts.a(this.f6723d, pagesYouMayLikeItemViewModelProps.b);
        subParts.a(this.f6722c, pagesYouMayLikeItemViewModelProps);
        subParts.a(2131560754, this.f6724e, new 2(this, pagesYouMayLikeItemViewModelProps));
        SuggestedPageUnitItem suggestedPageUnitItem = pagesYouMayLikeItemViewModelProps.b;
        Uri uri2 = null;
        if (suggestedPageUnitItem.mo548m() == null || suggestedPageUnitItem.mo548m().M() == null || suggestedPageUnitItem.mo548m().M().j() == null || suggestedPageUnitItem.mo548m().M().j().Q() == null) {
            uri = null;
        } else {
            uri = ImageUtil.a(suggestedPageUnitItem.mo548m().M().j().Q());
        }
        if (uri == null) {
            GraphQLImage b = EgoUnitUtil.m6653b(suggestedPageUnitItem);
            if (b != null) {
                uri2 = ImageUtil.a(b);
            }
        } else {
            uri2 = uri;
        }
        return uri2;
    }

    public final /* bridge */ /* synthetic */ void m7113a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1128983707);
        ContentBasedPageYouMayLikeFallbackContentView contentBasedPageYouMayLikeFallbackContentView = (ContentBasedPageYouMayLikeFallbackContentView) view;
        contentBasedPageYouMayLikeFallbackContentView.f6726d.a((Uri) obj2, f6719b);
        Logger.a(8, EntryType.MARK_POP, 2022484950, a);
    }

    @Inject
    public PymlFallbackPagePartDefinition(ContentBasedPageYouMayLikePartDefinition contentBasedPageYouMayLikePartDefinition, PymlActorPhotoPartDefinition pymlActorPhotoPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, DefaultFeedUnitRenderer defaultFeedUnitRenderer) {
        this.f6722c = contentBasedPageYouMayLikePartDefinition;
        this.f6723d = pymlActorPhotoPartDefinition;
        this.f6724e = clickListenerPartDefinition;
        this.f6725f = defaultFeedUnitRenderer;
    }

    public static PymlFallbackPagePartDefinition m7109a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PymlFallbackPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6721h) {
                PymlFallbackPagePartDefinition pymlFallbackPagePartDefinition;
                if (a2 != null) {
                    pymlFallbackPagePartDefinition = (PymlFallbackPagePartDefinition) a2.a(f6721h);
                } else {
                    pymlFallbackPagePartDefinition = f6720g;
                }
                if (pymlFallbackPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7110b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6721h, b3);
                        } else {
                            f6720g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pymlFallbackPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<ContentBasedPageYouMayLikeFallbackContentView> m7111a() {
        return f6718a;
    }
}
