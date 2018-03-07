package com.facebook.prefetch.feed;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: TDispatcher; */
public class NewsFeedPrefetchConditionCheck {
    public final AppStateManager f10819a;
    public final LoggedInUserSessionManager f10820b;

    /* compiled from: TDispatcher; */
    public enum ConditionCheckResult {
        SUCCESS("success"),
        NOT_LOGGED_IN("not_logged_in"),
        APP_NOT_IN_BACKGROUND("app_not_in_background");
        
        private final String mName;

        private ConditionCheckResult(String str) {
            this.mName = str;
        }

        public final String toString() {
            return this.mName;
        }
    }

    public static NewsFeedPrefetchConditionCheck m11297a(InjectorLike injectorLike) {
        return new NewsFeedPrefetchConditionCheck(AppStateManager.a(injectorLike), LoggedInUserSessionManager.a(injectorLike));
    }

    @Inject
    public NewsFeedPrefetchConditionCheck(AppStateManager appStateManager, LoggedInUserSessionManager loggedInUserSessionManager) {
        this.f10819a = appStateManager;
        this.f10820b = loggedInUserSessionManager;
    }
}
