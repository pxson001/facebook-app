package com.facebook.video.videohome.environment;

import android.view.View;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: started with null intent */
public class VideoHomeCanHandleSectionReloadImpl<E extends HasShownVideosContainer & HasInvalidate> implements CanHandleSectionReload {
    private static final String f2837a = VideoHomeCanHandleSectionReloadImpl.class.getSimpleName();
    @Nullable
    public WeakReference<E> f2838b;

    public static VideoHomeCanHandleSectionReloadImpl m2743a(InjectorLike injectorLike) {
        return new VideoHomeCanHandleSectionReloadImpl();
    }

    public final void m2744a(View view, VideoHomeHScrollLiveVideosComponentPersistentState videoHomeHScrollLiveVideosComponentPersistentState, final ReactionUnitComponentNode reactionUnitComponentNode) {
        if (reactionUnitComponentNode.b != null && reactionUnitComponentNode.b.a() != null) {
            reactionUnitComponentNode.b.a();
            if (reactionUnitComponentNode.b.a() == GraphQLReactionUnitComponentStyle.PAGINATED_H_SCROLL_GENERIC_COMPONENTS_LIST_LIVE_VIDEO) {
                view.post(new Runnable(this) {
                    final /* synthetic */ VideoHomeCanHandleSectionReloadImpl f2836b;

                    public void run() {
                        if (this.f2836b.f2838b != null) {
                            HasShownVideosContainer hasShownVideosContainer = (HasShownVideosContainer) this.f2836b.f2838b.get();
                            if (hasShownVideosContainer != null) {
                                hasShownVideosContainer.g().m2734a();
                                ((HasInvalidate) hasShownVideosContainer).a(new Object[]{reactionUnitComponentNode});
                            }
                        }
                    }
                });
            }
        }
    }

    public final void m2745a(E e) {
        Preconditions.checkNotNull(e);
        this.f2838b = new WeakReference(e);
    }
}
