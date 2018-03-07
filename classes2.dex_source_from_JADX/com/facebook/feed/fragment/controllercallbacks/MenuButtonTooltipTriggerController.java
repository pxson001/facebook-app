package com.facebook.feed.fragment.controllercallbacks;

import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.fragment.NewsFeedFragment;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.tooltip.MenuButtonTooltipTriggerManager;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.ScrollingViewProxy;
import javax.inject.Inject;

/* compiled from: platform/?href=%s&bootstrap_uri=%s */
public class MenuButtonTooltipTriggerController extends BaseController implements AdapterCreatedCallback {
    private final MenuButtonTooltipTriggerManager f9743a;

    public static MenuButtonTooltipTriggerController m14750a(InjectorLike injectorLike) {
        return new MenuButtonTooltipTriggerController(MenuButtonTooltipTriggerManager.m14752a(injectorLike));
    }

    @Inject
    public MenuButtonTooltipTriggerController(MenuButtonTooltipTriggerManager menuButtonTooltipTriggerManager) {
        this.f9743a = menuButtonTooltipTriggerManager;
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f9743a.m14756a(NewsFeedFragment.class, feedEnvironment);
    }

    public final void kF_() {
        this.f9743a.m14755a(NewsFeedFragment.class);
    }
}
