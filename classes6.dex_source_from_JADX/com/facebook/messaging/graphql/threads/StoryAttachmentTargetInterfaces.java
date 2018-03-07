package com.facebook.messaging.graphql.threads;

import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.FundraiserToCharityFragmentModel.FundraiserDetailedProgressTextModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.FundraiserToCharityFragmentModel.FundraiserForCharityTextModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.PeerToPeerPaymentRequestFragmentModel.RequesteeModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.PeerToPeerPaymentRequestFragmentModel.RequesterModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.PeerToPeerTransferFragmentModel.ReceiverModel;
import com.facebook.messaging.graphql.threads.StoryAttachmentTargetModels.PeerToPeerTransferFragmentModel.SenderModel;
import javax.annotation.Nullable;

/* compiled from: video_attachment_length */
public class StoryAttachmentTargetInterfaces {

    /* compiled from: video_attachment_length */
    public interface FundraiserToCharityFragment {
        @Nullable
        GraphQLObjectType mo113I();

        @Nullable
        FundraiserDetailedProgressTextModel mo114J();

        @Nullable
        FundraiserForCharityTextModel mo115K();
    }

    /* compiled from: video_attachment_length */
    public interface GroupFragment {
    }

    /* compiled from: video_attachment_length */
    public interface MessageEventFragment {
    }

    /* compiled from: video_attachment_length */
    public interface MessageLocationFragment {
    }

    /* compiled from: video_attachment_length */
    public interface PeerToPeerPaymentRequestFragment {

        /* compiled from: video_attachment_length */
        public interface Amount {
            @Nullable
            String mo116a();

            @Nullable
            String mo117b();
        }

        @Nullable
        Amount mo118L();

        @Nullable
        String mo119M();

        @Nullable
        RequesteeModel mo120N();

        @Nullable
        RequesterModel mo121O();
    }

    /* compiled from: video_attachment_length */
    public interface PeerToPeerTransferFragment {

        /* compiled from: video_attachment_length */
        public interface Amount {
            @Nullable
            String mo122a();

            @Nullable
            String mo123b();
        }

        @Nullable
        Amount mo124P();

        @Nullable
        String mo125Q();

        @Nullable
        ReceiverModel mo126R();

        @Nullable
        SenderModel mo127S();
    }
}
