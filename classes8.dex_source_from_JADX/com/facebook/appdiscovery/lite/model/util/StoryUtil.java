package com.facebook.appdiscovery.lite.model.util;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLInterfaces.ActorFacePileFragment;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLInterfaces.AppStoryQueryFragment;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLModels.AppStoryQueryFragmentModel.AttachmentsModel;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLModels.AppStoryQueryFragmentModel.AttachmentsModel.ActionLinksModel;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_expanding */
public class StoryUtil {
    public final AppStoryQueryFragment f10591a;
    private AttachmentsModel f10592b;
    private ActionLinksModel f10593c;
    public ActorFacePileFragment f10594d;

    @Inject
    public StoryUtil(@Assisted AppStoryQueryFragment appStoryQueryFragment) {
        this.f10591a = appStoryQueryFragment;
    }

    @Nullable
    private AttachmentsModel m12496d() {
        if (this.f10592b == null) {
            this.f10592b = (AttachmentsModel) m12495a(this.f10591a.g());
        }
        return this.f10592b;
    }

    @Nullable
    private ActionLinksModel m12497f() {
        AttachmentsModel d = m12496d();
        if (this.f10593c == null && d != null) {
            this.f10593c = (ActionLinksModel) m12495a(d.a());
        }
        return this.f10593c;
    }

    @Nullable
    public final String m12498a() {
        ActionLinksModel f = m12497f();
        if (f != null) {
            return f.a();
        }
        return null;
    }

    @Nullable
    public final String m12499b() {
        AttachmentsModel d = m12496d();
        if (d == null || d.b() == null || d.b().a() == null || StringUtil.a(d.b().a().b())) {
            return null;
        }
        return d.b().a().b();
    }

    public static <T> T m12495a(ImmutableList<T> immutableList) {
        if (immutableList == null || immutableList.isEmpty()) {
            return null;
        }
        return immutableList.get(0);
    }
}
