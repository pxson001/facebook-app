package com.facebook.api.graphql.commentservice;

import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateFeedbackFieldsModel;
import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateShimMutationFragmentModel;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.query.ShimmedMutationRequestParams;
import com.facebook.graphql.query.ShimmedMutationRequestParams.ResultQuery;
import com.facebook.graphql.query.ShimmedMutationRequestParams.Variable;
import com.facebook.graphql.query.ShimmedMutationRequestParams.VariableType;
import com.facebook.graphql.query.TypedGraphQLMutationString;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: app_data */
public final class CommentsServiceShimmedMutation {

    /* compiled from: app_data */
    public class AddCommentCommentString extends TypedGraphQlQueryString<GraphQLComment> {
        public AddCommentCommentString() {
            super(GraphQLComment.class, false, "AddCommentComment", "278f224ee6208d50285a57546b10a076", "comment", "10154520798051729", RegularImmutableSet.a);
        }

        public final String m15745a(String str) {
            switch (str.hashCode()) {
                case -1966188374:
                    return "31";
                case -1849402738:
                    return "4";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "27";
                case -1745741354:
                    return "12";
                case -1663499699:
                    return "22";
                case -1547457328:
                    return "17";
                case -1460262781:
                    return "48";
                case -1450031236:
                    return "0";
                case -1397293948:
                    return "33";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1012194872:
                    return "37";
                case -971327749:
                    return "40";
                case -969292942:
                    return "39";
                case -945993139:
                    return "35";
                case -817257615:
                    return "28";
                case -790388762:
                    return "32";
                case -680727674:
                    return "36";
                case -631654088:
                    return "7";
                case -561505403:
                    return "15";
                case -550685124:
                    return "46";
                case -545012818:
                    return "43";
                case -538773735:
                    return "26";
                case -461877888:
                    return "23";
                case -317710003:
                    return "25";
                case -92787706:
                    return "9";
                case -16226492:
                    return "34";
                case 25209764:
                    return "3";
                case 169846802:
                    return "10";
                case 293932680:
                    return "42";
                case 465791237:
                    return "47";
                case 557908192:
                    return "24";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 651215103:
                    return "16";
                case 656444234:
                    return "45";
                case 689802720:
                    return "18";
                case 797640206:
                    return "30";
                case 810737919:
                    return "38";
                case 949660692:
                    return "50";
                case 1091074225:
                    return "41";
                case 1108260124:
                    return "21";
                case 1139691781:
                    return "49";
                case 1420616515:
                    return "44";
                case 1598177384:
                    return "2";
                case 1673542407:
                    return "8";
                case 1827871700:
                    return "20";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "29";
                case 2059544769:
                    return "19";
                default:
                    return str;
            }
        }
    }

    /* compiled from: app_data */
    public class AddCommentFeedbackString extends TypedGraphQlQueryString<CommentCreateFeedbackFieldsModel> {
        public AddCommentFeedbackString() {
            super(CommentCreateFeedbackFieldsModel.class, false, "AddCommentFeedback", "6abf71239348a8764e1fe2994f440c2a", "node", "10154339186971729", RegularImmutableSet.a);
        }

        public final String m15746a(String str) {
            switch (str.hashCode()) {
                case -1112778828:
                    return "0";
                case -1012194872:
                    return "1";
                default:
                    return str;
            }
        }
    }

    /* compiled from: app_data */
    public class AddCommentString extends TypedGraphQLMutationString<CommentCreateShimMutationFragmentModel> {
        public AddCommentString() {
            ImmutableSet of = ImmutableSet.of();
            Variable[] variableArr = new Variable[]{new Variable(VariableType.FIELD, "legacy_api_post_id")};
            String[] strArr = new String[]{"message", "tracking", "idempotence_token", "nectar_module", "feedback_source", "attachment_id", "facepile_mentioned_ids", "breaking_changes_override", "live_video_timestamp", "vod_video_timestamp", "format"};
            Variable[] variableArr2 = new Variable[]{new Variable(VariableType.FIELD, "comment"), new Variable(VariableType.FIELD, "tracking_codes"), new Variable(VariableType.FIELD, "client_mutation_id"), new Variable(VariableType.FIELD, "nectar_module"), new Variable(VariableType.FIELD, "feedback_source"), new Variable(VariableType.FIELD, "attachment_param"), new Variable(VariableType.FIELD, "facepile_mentioned_ids"), new Variable(VariableType.FIELD, "breaking_changes_override"), new Variable(VariableType.FIELD, "live_video_timestamp"), new Variable(VariableType.FIELD, "vod_video_timestamp"), new Variable(VariableType.LITERAL, "literal", "json")};
            r9 = new ResultQuery[2];
            r9[0] = new ResultQuery(new String[]{"call_comment_id"}, new Variable[]{new Variable(VariableType.LITERAL, "literal", "{result=Mutation:$.id}")}, new String[]{"call_comment_id", "profile_image_size", "profile_pic_media_type", "angora_attachment_cover_image_size", "media_type", "image_low_width", "image_low_height", "image_medium_width", "image_medium_height", "image_high_width", "image_high_height", "default_image_scale", "remove_attachment_feedback", "enable_reactions", "fetch_supported_reactions", "enable_real_time_activity_info", "threshold_duration_for_feed_discovery", "include_replies_in_total_count", "is_ask_friends_enabled", "num_visible_top_answers", "load_redundant_fields", "angora_attachment_profile_image_size", "greeting_card_image_size_large", "greeting_card_image_size_medium", "adaptive_image_quality", "size_style", "num_media_question_options", "media_question_photo_size", "reading_attachment_profile_image_width", "reading_attachment_profile_image_height", "image_large_aspect_width", "image_large_aspect_height", "goodwill_small_accent_image", "question_poll_count", "poll_voters_count", "poll_facepile_size", "device_id", "enable_hd", "scrubbing", "encoding_tags", "quality", "in_channel_eligibility_experiment", "video_channel_entry_point", "automatic_photo_captioning_enabled", "enable_private_reply", "enable_comment_replies_most_recent", "max_comment_replies", "enable_attachments_for_reply_previews", "enable_feedback_for_reply_previews", "enable_page_info_for_reply_connection", "enable_ranked_replies"}, CommentsServiceShimmedMutation.m15747a(), "comment");
            r9[1] = new ResultQuery(new String[]{"call_feedback_id"}, new Variable[]{new Variable(VariableType.FIELD, "feedback_id")}, new String[]{"call_feedback_id", "include_replies_in_total_count"}, CommentsServiceShimmedMutation.m15748b(), "feedback");
            super(CommentCreateShimMutationFragmentModel.class, false, "AddComment", "66d2183ccd5ce73d4cb0df274fc03417", "comment_create_shim", "input", null, of, new ShimmedMutationRequestParams("comment_create_shim", "POST", "%s/comments", variableArr, strArr, variableArr2, r9, "input"));
        }
    }

    public static final AddCommentCommentString m15747a() {
        return new AddCommentCommentString();
    }

    public static final AddCommentFeedbackString m15748b() {
        return new AddCommentFeedbackString();
    }
}
