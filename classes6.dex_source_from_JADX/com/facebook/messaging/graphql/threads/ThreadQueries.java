package com.facebook.messaging.graphql.threads;

import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.BusinessNameSearchQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.BusinessPageQueryFragmentModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MessageInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MontageThreadListQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MoreMessagesQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MoreThreadsQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.PinnedThreadsQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.SearchThreadNameAndParticipantsQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadListQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: videoStreamingConfig */
public final class ThreadQueries {

    /* compiled from: videoStreamingConfig */
    public class BusinessNameSearchQueryString extends TypedGraphQlQueryString<BusinessNameSearchQueryModel> {
        public BusinessNameSearchQueryString() {
            super(BusinessNameSearchQueryModel.class, false, "BusinessNameSearchQuery", "f5bf3c81880626ab8bf8c17911983df2", "entities_named", "10154686281266729", RegularImmutableSet.a);
        }

        public final String m1838a(String str) {
            switch (str.hashCode()) {
                case -1366603820:
                    return "0";
                case -766535118:
                    return "1";
                case -20088988:
                    return "5";
                case 790172080:
                    return "3";
                case 860481728:
                    return "4";
                case 1764787049:
                    return "2";
                default:
                    return str;
            }
        }
    }

    /* compiled from: videoStreamingConfig */
    public class BusinessPageSearchQueryString extends TypedGraphQlQueryString<BusinessPageQueryFragmentModel> {
        public BusinessPageSearchQueryString() {
            super(BusinessPageQueryFragmentModel.class, false, "BusinessPageSearchQuery", "4822c4c9f0311e18bdd775beba6ac4b1", "node", "10154686281306729", RegularImmutableSet.a);
        }

        public final String m1839a(String str) {
            switch (str.hashCode()) {
                case -20088988:
                    return "4";
                case 790172080:
                    return "2";
                case 860481728:
                    return "3";
                case 1764787049:
                    return "1";
                case 1987278668:
                    return "0";
                default:
                    return str;
            }
        }
    }

    /* compiled from: videoStreamingConfig */
    public class MessagesQueryString extends TypedGraphQlQueryString<Map<String, MessageInfoModel>> {
        public MessagesQueryString() {
            super(MessageInfoModel.class, true, "MessagesQuery", "5363ac2d200b2c6166ac985fadffead1", "messages", "10154686971886729", RegularImmutableSet.a);
        }

        public final String m1840a(String str) {
            switch (str.hashCode()) {
                case -2119611824:
                    return "9";
                case -1966910237:
                    return "3";
                case -1805307230:
                    return "8";
                case -1599375389:
                    return "6";
                case -1540093218:
                    return "1";
                case -1068773435:
                    return "0";
                case 148527022:
                    return "2";
                case 434916138:
                    return "4";
                case 1525975722:
                    return "5";
                case 1712052380:
                    return "7";
                default:
                    return str;
            }
        }
    }

    /* compiled from: videoStreamingConfig */
    public class MontageThreadListQueryString extends TypedGraphQlQueryString<MontageThreadListQueryModel> {
        public MontageThreadListQueryString() {
            super(MontageThreadListQueryModel.class, false, "MontageThreadListQuery", "03c66991e808b31da870b86489a5e8ea", "viewer", "10154688755556729", ImmutableSet.of("actor_id"));
        }

        public final String m1841a(String str) {
            switch (str.hashCode()) {
                case -2119611824:
                    return "12";
                case -1966910237:
                    return "4";
                case -1805307230:
                    return "11";
                case -1599375389:
                    return "9";
                case -1540093218:
                    return "2";
                case -1146095919:
                    return "20";
                case -642060948:
                    return "17";
                case -530039636:
                    return "1";
                case -455305975:
                    return "6";
                case -396016620:
                    return "7";
                case -283077990:
                    return "0";
                case -260181987:
                    return "19";
                case -20088988:
                    return "16";
                case 148527022:
                    return "3";
                case 235810394:
                    return "21";
                case 434916138:
                    return "5";
                case 481931807:
                    return "18";
                case 790172080:
                    return "14";
                case 860481728:
                    return "15";
                case 1525975722:
                    return "8";
                case 1712052380:
                    return "10";
                case 1764787049:
                    return "13";
                default:
                    return str;
            }
        }

        protected final boolean m1842a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 55:
                    if (str.equals("7")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: videoStreamingConfig */
    public class MoreMessagesQueryString extends TypedGraphQlQueryString<MoreMessagesQueryModel> {
        public MoreMessagesQueryString() {
            super(MoreMessagesQueryModel.class, false, "MoreMessagesQuery", "d174e471f802bbe05ccded2e11f3c116", "message_thread", "10154686971876729", RegularImmutableSet.a);
        }

        public final String m1843a(String str) {
            switch (str.hashCode()) {
                case -2119611824:
                    return "11";
                case -1966910237:
                    return "5";
                case -1805307230:
                    return "10";
                case -1599375389:
                    return "8";
                case -1562235024:
                    return "0";
                case -1540093218:
                    return "3";
                case -1233320040:
                    return "1";
                case -1146095919:
                    return "2";
                case 148527022:
                    return "4";
                case 434916138:
                    return "6";
                case 1525975722:
                    return "7";
                case 1712052380:
                    return "9";
                default:
                    return str;
            }
        }
    }

    /* compiled from: videoStreamingConfig */
    public class MoreThreadsQueryString extends TypedGraphQlQueryString<MoreThreadsQueryModel> {
        public MoreThreadsQueryString() {
            super(MoreThreadsQueryModel.class, false, "MoreThreadsQuery", "3f56c84125c4ff2ed36dd9a4c4524f25", "viewer", "10154688755611729", ImmutableSet.of("actor_id"));
        }

        public final String m1844a(String str) {
            switch (str.hashCode()) {
                case -2119611824:
                    return "13";
                case -1966910237:
                    return "5";
                case -1916788491:
                    return "1";
                case -1805307230:
                    return "12";
                case -1599375389:
                    return "10";
                case -1540093218:
                    return "3";
                case -1146095919:
                    return "21";
                case -827710391:
                    return "0";
                case -642060948:
                    return "18";
                case -455305975:
                    return "7";
                case -396016620:
                    return "8";
                case -283077990:
                    return "2";
                case -260181987:
                    return "20";
                case -20088988:
                    return "17";
                case 148527022:
                    return "4";
                case 235810394:
                    return "22";
                case 434916138:
                    return "6";
                case 481931807:
                    return "19";
                case 790172080:
                    return "15";
                case 860481728:
                    return "16";
                case 1525975722:
                    return "9";
                case 1712052380:
                    return "11";
                case 1764787049:
                    return "14";
                default:
                    return str;
            }
        }

        protected final boolean m1845a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 56:
                    if (str.equals("8")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: videoStreamingConfig */
    public class PinnedThreadsQueryString extends TypedGraphQlQueryString<PinnedThreadsQueryModel> {
        public PinnedThreadsQueryString() {
            super(PinnedThreadsQueryModel.class, false, "PinnedThreadsQuery", "e092afe675568fc8be3eef1f655198ed", "viewer", "10154688755741729", ImmutableSet.of("actor_id"));
        }

        public final String m1846a(String str) {
            switch (str.hashCode()) {
                case -2119611824:
                    return "12";
                case -1966910237:
                    return "4";
                case -1805307230:
                    return "11";
                case -1599375389:
                    return "9";
                case -1540093218:
                    return "2";
                case -1146095919:
                    return "20";
                case -642060948:
                    return "17";
                case -455305975:
                    return "6";
                case -396016620:
                    return "7";
                case -283077990:
                    return "1";
                case -260181987:
                    return "19";
                case -20088988:
                    return "16";
                case 148527022:
                    return "3";
                case 235810394:
                    return "21";
                case 434916138:
                    return "5";
                case 481931807:
                    return "18";
                case 709104354:
                    return "0";
                case 790172080:
                    return "14";
                case 860481728:
                    return "15";
                case 1525975722:
                    return "8";
                case 1712052380:
                    return "10";
                case 1764787049:
                    return "13";
                default:
                    return str;
            }
        }

        protected final boolean m1847a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 55:
                    if (str.equals("7")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: videoStreamingConfig */
    public class SearchThreadNameAndParticipantsQueryString extends TypedGraphQlQueryString<SearchThreadNameAndParticipantsQueryModel> {
        public SearchThreadNameAndParticipantsQueryString() {
            super(SearchThreadNameAndParticipantsQueryModel.class, false, "SearchThreadNameAndParticipantsQuery", "fb18bfbc8615b80d29ba7ac31bd9d887", "viewer", "10154688755601729", ImmutableSet.of("actor_id"));
        }

        public final String m1848a(String str) {
            switch (str.hashCode()) {
                case -2119611824:
                    return "12";
                case -1966910237:
                    return "4";
                case -1805307230:
                    return "11";
                case -1599375389:
                    return "9";
                case -1540093218:
                    return "2";
                case -1146095919:
                    return "20";
                case -642060948:
                    return "17";
                case -455305975:
                    return "6";
                case -396016620:
                    return "7";
                case -260181987:
                    return "19";
                case -249250188:
                    return "1";
                case -20088988:
                    return "16";
                case 148527022:
                    return "3";
                case 235810394:
                    return "21";
                case 434916138:
                    return "5";
                case 461177713:
                    return "0";
                case 481931807:
                    return "18";
                case 790172080:
                    return "14";
                case 860481728:
                    return "15";
                case 1525975722:
                    return "8";
                case 1712052380:
                    return "10";
                case 1764787049:
                    return "13";
                default:
                    return str;
            }
        }

        protected final boolean m1849a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 55:
                    if (str.equals("7")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: videoStreamingConfig */
    public class ThreadListQueryString extends TypedGraphQlQueryString<ThreadListQueryModel> {
        public ThreadListQueryString() {
            super(ThreadListQueryModel.class, false, "ThreadListQuery", "08f10872e9e609c53f7a514e11109952", "viewer", "10154688755671729", ImmutableSet.of("actor_id"));
        }

        public final String m1850a(String str) {
            switch (str.hashCode()) {
                case -2119611824:
                    return "14";
                case -1966910237:
                    return "6";
                case -1805307230:
                    return "13";
                case -1599375389:
                    return "11";
                case -1540093218:
                    return "4";
                case -1483839471:
                    return "1";
                case -1146095919:
                    return "22";
                case -827710391:
                    return "0";
                case -642060948:
                    return "19";
                case -530039636:
                    return "3";
                case -455305975:
                    return "8";
                case -396016620:
                    return "9";
                case -283077990:
                    return "2";
                case -260181987:
                    return "21";
                case -20088988:
                    return "18";
                case 148527022:
                    return "5";
                case 235810394:
                    return "23";
                case 434916138:
                    return "7";
                case 481931807:
                    return "20";
                case 790172080:
                    return "16";
                case 860481728:
                    return "17";
                case 1525975722:
                    return "10";
                case 1712052380:
                    return "12";
                case 1764787049:
                    return "15";
                default:
                    return str;
            }
        }

        protected final boolean m1851a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 57:
                    if (str.equals("9")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: videoStreamingConfig */
    public class ThreadQueryString extends TypedGraphQlQueryString<Map<String, ThreadInfoModel>> {
        public ThreadQueryString() {
            super(ThreadInfoModel.class, true, "ThreadQuery", "7b7796070ecfc5e45196ba364deacfbf", "message_threads", "10154688755711729", ImmutableSet.of("actor_id"));
        }

        public final String m1852a(String str) {
            switch (str.hashCode()) {
                case -2119611824:
                    return "11";
                case -1966910237:
                    return "3";
                case -1805307230:
                    return "10";
                case -1599375389:
                    return "8";
                case -1540093218:
                    return "1";
                case -1184645373:
                    return "0";
                case -1146095919:
                    return "19";
                case -642060948:
                    return "16";
                case -455305975:
                    return "5";
                case -396016620:
                    return "6";
                case -260181987:
                    return "18";
                case -20088988:
                    return "15";
                case 148527022:
                    return "2";
                case 235810394:
                    return "20";
                case 434916138:
                    return "4";
                case 481931807:
                    return "17";
                case 790172080:
                    return "13";
                case 860481728:
                    return "14";
                case 1525975722:
                    return "7";
                case 1712052380:
                    return "9";
                case 1764787049:
                    return "12";
                default:
                    return str;
            }
        }

        protected final boolean m1853a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 54:
                    if (str.equals("6")) {
                        z = false;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    return (obj instanceof Boolean) && !((Boolean) obj).booleanValue();
                default:
                    return false;
            }
        }
    }

    /* compiled from: videoStreamingConfig */
    public class XMAQueryString extends TypedGraphQlQueryString<XMAModel> {
        public XMAQueryString() {
            super(XMAModel.class, false, "XMAQuery", "69a90fdf17694bc8218467f1856c2113", "node", "10154686971856729", RegularImmutableSet.a);
        }

        public final String m1854a(String str) {
            switch (str.hashCode()) {
                case -2119611824:
                    return "3";
                case -1966910237:
                    return "1";
                case -755821010:
                    return "0";
                case 434916138:
                    return "2";
                case 1712052380:
                    return "4";
                default:
                    return str;
            }
        }
    }

    public static final ThreadListQueryString m1855a() {
        return new ThreadListQueryString();
    }

    public static final MoreThreadsQueryString m1856c() {
        return new MoreThreadsQueryString();
    }

    public static final MoreMessagesQueryString m1857f() {
        return new MoreMessagesQueryString();
    }

    public static final MessagesQueryString m1858g() {
        return new MessagesQueryString();
    }

    public static final XMAQueryString m1859h() {
        return new XMAQueryString();
    }

    public static final PinnedThreadsQueryString m1860i() {
        return new PinnedThreadsQueryString();
    }
}
