package com.facebook.appdiscovery.lite.protocol;

import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLInterfaces.ActorFacePileFragment;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLModels.AppStoryQueryFragmentModel.MessageModel;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: sendError.errorNumber */
public class FetchLiteResultsGraphQLInterfaces {

    /* compiled from: sendError.errorNumber */
    public interface AppStoryQueryFragment {
        @Nonnull
        ImmutableList<? extends Attachments> mo132g();

        @Nonnull
        ImmutableList<? extends ActorFacePileFragment> kV_();

        @Nullable
        MessageModel kW_();
    }
}
