package com.facebook.api.graphql.commentservice;

import com.facebook.api.graphql.commentservice.CommentsServiceModels.CommentCreateMutationFragmentModel;
import com.facebook.api.graphql.commentservice.CommentsServiceModels.FriendsTypingSubscriptionModel;
import com.facebook.graphql.query.TypedGraphQLSubscriptionString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: app_landing */
public final class CommentsService {

    /* compiled from: app_landing */
    public class CommentCreateSubscriptionString extends TypedGraphQLSubscriptionString<CommentCreateMutationFragmentModel> {
        public CommentCreateSubscriptionString() {
            super(CommentCreateMutationFragmentModel.class, false, "CommentCreateSubscription", "b10d9bd021be3b388270971fd5c4673c", "comment_create_subscribe", "0", "10154690955066729", RegularImmutableSet.a);
        }

        public final String m15682a(String str) {
            switch (str.hashCode()) {
                case -1966188374:
                    return "33";
                case -1849402738:
                    return "4";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "29";
                case -1745741354:
                    return "12";
                case -1718813234:
                    return "49";
                case -1663499699:
                    return "24";
                case -1547457328:
                    return "19";
                case -1460262781:
                    return "52";
                case -1397293948:
                    return "35";
                case -1362584798:
                    return "51";
                case -1284099636:
                    return "39";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1012194872:
                    return "18";
                case -971327749:
                    return "44";
                case -969292942:
                    return "43";
                case -945993139:
                    return "40";
                case -817257615:
                    return "30";
                case -790388762:
                    return "34";
                case -680727674:
                    return "41";
                case -631654088:
                    return "7";
                case -561505403:
                    return "15";
                case -538773735:
                    return "28";
                case -461877888:
                    return "25";
                case -317710003:
                    return "27";
                case -113788560:
                    return "38";
                case -92787706:
                    return "9";
                case -16226492:
                    return "36";
                case 25209764:
                    return "3";
                case 41001321:
                    return "50";
                case 100358090:
                    return "0";
                case 169846802:
                    return "10";
                case 293932680:
                    return "46";
                case 557908192:
                    return "26";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 651215103:
                    return "16";
                case 656444234:
                    return "48";
                case 689802720:
                    return "20";
                case 774983793:
                    return "37";
                case 797640206:
                    return "32";
                case 810737919:
                    return "42";
                case 1091074225:
                    return "45";
                case 1108260124:
                    return "23";
                case 1139691781:
                    return "53";
                case 1420616515:
                    return "47";
                case 1585010628:
                    return "17";
                case 1598177384:
                    return "2";
                case 1673542407:
                    return "8";
                case 1827871700:
                    return "22";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "31";
                case 2059544769:
                    return "21";
                default:
                    return str;
            }
        }
    }

    /* compiled from: app_landing */
    public class FriendsTypingSubscriptionString extends TypedGraphQLSubscriptionString<FriendsTypingSubscriptionModel> {
        public FriendsTypingSubscriptionString() {
            super(FriendsTypingSubscriptionModel.class, false, "FriendsTypingSubscription", "9fc35af3593f11ac8b6b4683529823dd", "feedback_typing_subscribe", "0", "10154661195391729", RegularImmutableSet.a);
        }

        public final String m15683a(String str) {
            switch (str.hashCode()) {
                case 100358090:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: app_landing */
    public class PublicContentCommentCreateSubscriptionString extends TypedGraphQLSubscriptionString<CommentCreateMutationFragmentModel> {
        public PublicContentCommentCreateSubscriptionString() {
            super(CommentCreateMutationFragmentModel.class, false, "PublicContentCommentCreateSubscription", "b9310d780c61e914ec01df61ad950fa9", "public_content_comment_create_subscribe", "0", "10154690955031729", RegularImmutableSet.a);
        }

        public final String m15684a(String str) {
            switch (str.hashCode()) {
                case -1966188374:
                    return "33";
                case -1849402738:
                    return "4";
                case -1780769805:
                    return "13";
                case -1778558196:
                    return "29";
                case -1745741354:
                    return "12";
                case -1718813234:
                    return "49";
                case -1663499699:
                    return "24";
                case -1547457328:
                    return "19";
                case -1460262781:
                    return "52";
                case -1397293948:
                    return "35";
                case -1362584798:
                    return "51";
                case -1284099636:
                    return "39";
                case -1150725321:
                    return "11";
                case -1101600581:
                    return "1";
                case -1012194872:
                    return "18";
                case -971327749:
                    return "44";
                case -969292942:
                    return "43";
                case -945993139:
                    return "40";
                case -817257615:
                    return "30";
                case -790388762:
                    return "34";
                case -680727674:
                    return "41";
                case -631654088:
                    return "7";
                case -561505403:
                    return "15";
                case -538773735:
                    return "28";
                case -461877888:
                    return "25";
                case -317710003:
                    return "27";
                case -113788560:
                    return "38";
                case -92787706:
                    return "9";
                case -16226492:
                    return "36";
                case 25209764:
                    return "3";
                case 41001321:
                    return "50";
                case 100358090:
                    return "0";
                case 169846802:
                    return "10";
                case 293932680:
                    return "46";
                case 557908192:
                    return "26";
                case 580042479:
                    return "14";
                case 609122022:
                    return "6";
                case 651215103:
                    return "16";
                case 656444234:
                    return "48";
                case 689802720:
                    return "20";
                case 774983793:
                    return "37";
                case 797640206:
                    return "32";
                case 810737919:
                    return "42";
                case 1091074225:
                    return "45";
                case 1108260124:
                    return "23";
                case 1139691781:
                    return "53";
                case 1420616515:
                    return "47";
                case 1585010628:
                    return "17";
                case 1598177384:
                    return "2";
                case 1673542407:
                    return "8";
                case 1827871700:
                    return "22";
                case 1939875509:
                    return "5";
                case 1963391292:
                    return "31";
                case 2059544769:
                    return "21";
                default:
                    return str;
            }
        }
    }
}
