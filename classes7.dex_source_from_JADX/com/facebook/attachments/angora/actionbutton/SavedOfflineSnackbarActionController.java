package com.facebook.attachments.angora.actionbutton;

import android.content.Context;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.api.feed.service.GraphPostService;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.Assisted;
import com.facebook.offlinemode.ui.OfflineSnackbarActionController;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.common.protocol.UpdateSavedStateParams.Builder;
import com.facebook.saved.common.protocol.UpdateSavedStateParams.SavedAction;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: user_crop */
public class SavedOfflineSnackbarActionController implements OfflineSnackbarActionController {
    private final SaveAnalyticsLogger f879a;
    private final GraphPostService f880b;
    @Nullable
    private final String f881c;
    @Nullable
    private final String f882d;
    @Nullable
    private final String f883e;
    @Nullable
    private final ImmutableList<String> f884f;
    @Nullable
    private final String f885g;

    @Inject
    public SavedOfflineSnackbarActionController(@Nullable @Assisted String str, @Nullable @Assisted String str2, @Nullable @Assisted String str3, @Nullable @Assisted ImmutableList<String> immutableList, @Nullable @Assisted String str4, SaveAnalyticsLogger saveAnalyticsLogger, GraphPostService graphPostService) {
        boolean z = (str == null && str2 == null && str3 == null) ? false : true;
        Preconditions.checkArgument(z, "storyId, objectId and url can't all be null");
        this.f882d = str2;
        this.f884f = immutableList;
        this.f885g = str4;
        this.f879a = saveAnalyticsLogger;
        this.f881c = str;
        this.f883e = str3;
        this.f880b = graphPostService;
    }

    public final int mo43a() {
        return 2131232732;
    }

    public final void mo44a(Context context) {
        GraphPostService graphPostService = this.f880b;
        Builder builder = new Builder(SavedAction.SAVE, CurationSurface.NATIVE_STORY, CurationMechanism.OFFLINE_TOAST, this.f884f);
        builder.a = Optional.fromNullable(this.f881c);
        builder = builder;
        builder.c = Optional.fromNullable(this.f882d);
        builder = builder;
        builder.b = Optional.fromNullable(this.f883e);
        builder = builder;
        builder.d = Optional.fromNullable(this.f885g);
        graphPostService.a(builder.a(), CallerContext.a(getClass()));
        this.f879a.a("native_newsfeed", this.f882d, this.f881c, this.f883e, null, CurationSurface.NATIVE_STORY, CurationMechanism.OFFLINE_TOAST);
    }

    public final void mo46c() {
        this.f879a.a("native_newsfeed", this.f882d, this.f881c, null, CurationSurface.NATIVE_STORY, CurationMechanism.OFFLINE_TOAST, true);
    }

    public final int mo45b() {
        return 2130839719;
    }
}
