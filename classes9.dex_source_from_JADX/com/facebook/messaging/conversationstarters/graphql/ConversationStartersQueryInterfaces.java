package com.facebook.messaging.conversationstarters.graphql;

import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryModels.ConversationStartersFieldsModel.ItemDescriptionIconModel;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryModels.ConversationStartersFieldsModel.ItemDescriptionModel;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryModels.ConversationStartersFieldsModel.ItemUserModel;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryModels.ConversationStartersFieldsModel.McsItemTitleModel;
import javax.annotation.Nullable;

/* compiled from: memo_text */
public class ConversationStartersQueryInterfaces {

    /* compiled from: memo_text */
    public interface ConversationStartersFields {

        /* compiled from: memo_text */
        public interface ItemImage {
            @Nullable
            String mo415a();
        }

        @Nullable
        String mo416b();

        @Nullable
        ItemDescriptionModel mo417c();

        @Nullable
        ItemDescriptionIconModel mo418d();

        @Nullable
        ItemUserModel mo419g();

        boolean lJ_();

        @Nullable
        McsItemTitleModel lK_();

        @Nullable
        ItemImage lL_();
    }
}
