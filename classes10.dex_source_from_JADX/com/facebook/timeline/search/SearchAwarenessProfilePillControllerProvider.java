package com.facebook.timeline.search;

import android.content.Context;
import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.springs.SpringSystem;
import com.facebook.timeline.search.SearchAwarenessProfilePillController.OnClickViewCallback;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.widget.LazyView;

/* compiled from: extra_selected_theme_id */
public class SearchAwarenessProfilePillControllerProvider extends AbstractAssistedProvider<SearchAwarenessProfilePillController> {
    public final SearchAwarenessProfilePillController m12594a(LazyView<View> lazyView, OnClickViewCallback onClickViewCallback) {
        return new SearchAwarenessProfilePillController(lazyView, onClickViewCallback, SearchAwarenessLogger.b(this), (Context) getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), SpringSystem.b(this), ViewHelperViewAnimatorFactory.a(this));
    }
}
