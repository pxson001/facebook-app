package com.facebook.search.results.rows.sections.videos;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.CenterDistanceVideoDisplaySelector;
import com.facebook.feed.autoplay.VideoDisplayedCoordinator;
import com.facebook.feed.autoplay.VideoDisplayedCoordinatorProvider;
import com.facebook.feedplugins.video.RichVideoAttachmentView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: POPULARITY */
public class SearchResultsCenteredVideoAutoplayManager {
    private static SearchResultsCenteredVideoAutoplayManager f25113b;
    private static final Object f25114c = new Object();
    public final VideoDisplayedCoordinator<RichVideoAttachmentView> f25115a;

    private static SearchResultsCenteredVideoAutoplayManager m28412b(InjectorLike injectorLike) {
        return new SearchResultsCenteredVideoAutoplayManager(CenterDistanceVideoDisplaySelector.b(injectorLike), (VideoDisplayedCoordinatorProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(VideoDisplayedCoordinatorProvider.class));
    }

    @Inject
    public SearchResultsCenteredVideoAutoplayManager(CenterDistanceVideoDisplaySelector centerDistanceVideoDisplaySelector, VideoDisplayedCoordinatorProvider videoDisplayedCoordinatorProvider) {
        this.f25115a = videoDisplayedCoordinatorProvider.a(centerDistanceVideoDisplaySelector, true);
    }

    public static SearchResultsCenteredVideoAutoplayManager m28411a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCenteredVideoAutoplayManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25114c) {
                SearchResultsCenteredVideoAutoplayManager searchResultsCenteredVideoAutoplayManager;
                if (a2 != null) {
                    searchResultsCenteredVideoAutoplayManager = (SearchResultsCenteredVideoAutoplayManager) a2.a(f25114c);
                } else {
                    searchResultsCenteredVideoAutoplayManager = f25113b;
                }
                if (searchResultsCenteredVideoAutoplayManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28412b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25114c, b3);
                        } else {
                            f25113b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCenteredVideoAutoplayManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
