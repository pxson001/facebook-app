package com.facebook.auth.module;

import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.util.TriState;
import com.facebook.inject.AbstractProvider;

/* compiled from: surveyContent */
public class TriState_IsMeUserAWorkUserMethodAutoProvider extends AbstractProvider<TriState> {
    public Object get() {
        return LoggedInUserModule.a(LoggedInUserSessionManager.a(this));
    }
}
