package com.facebook.groups.memberpicker.protocol;

import com.facebook.groups.memberpicker.protocol.GroupSuggestedMemberDataModels.FullImageFragmentModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: event_tip_click */
public class GroupSuggestedMemberDataInterfaces {

    /* compiled from: event_tip_click */
    public interface FBTaggableUserFragment {
        @Nullable
        String mo891j();

        @Nullable
        String mo892k();

        @Nonnull
        ImmutableList<String> mo893l();

        @Nullable
        FullImageFragmentModel mo894m();
    }
}
