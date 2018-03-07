package com.facebook.pages.fb4a.events.eventslist.protocol;

import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.pages.fb4a.events.eventslist.protocol.PageEventsGraphQLModels.PagePastEventsQueryModel;
import com.facebook.pages.fb4a.events.eventslist.protocol.PageEventsGraphQLModels.PageUpcomingEventsQueryModel;
import com.google.common.collect.RegularImmutableSet;
import java.util.Map;

/* compiled from: profile_pic_image_size */
public final class PageEventsGraphQL {

    /* compiled from: profile_pic_image_size */
    public class PageNewlyAddedEventsQueryString extends TypedGraphQlQueryString<Map<String, EventCommonFragmentModel>> {
        public PageNewlyAddedEventsQueryString() {
            super(EventCommonFragmentModel.class, true, "PageNewlyAddedEventsQuery", "6dac006709e2a435a0cc2b1346071106", "nodes", "10154686242156729", RegularImmutableSet.a);
        }

        public final String m4015a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "1";
                case 25209764:
                    return "10";
                case 31742867:
                    return "0";
                case 689802720:
                    return "8";
                case 810737919:
                    return "2";
                case 1262925297:
                    return "3";
                case 1282232523:
                    return "5";
                case 1598177384:
                    return "9";
                case 1639748947:
                    return "6";
                case 1831224761:
                    return "7";
                case 1939875509:
                    return "4";
                default:
                    return str;
            }
        }

        protected final boolean m4016a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 50:
                    if (str.equals("2")) {
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

    /* compiled from: profile_pic_image_size */
    public class PagePastEventsQueryString extends TypedGraphQlQueryString<PagePastEventsQueryModel> {
        public PagePastEventsQueryString() {
            super(PagePastEventsQueryModel.class, false, "PagePastEventsQuery", "98f9a9027adc3b247d26dcb9c5bedcf6", "page", "10154686242166729", RegularImmutableSet.a);
        }

        public final String m4017a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -803548981:
                    return "0";
                case -705314112:
                    return "2";
                case -77796550:
                    return "1";
                case 25209764:
                    return "12";
                case 689802720:
                    return "10";
                case 810737919:
                    return "4";
                case 1262925297:
                    return "5";
                case 1282232523:
                    return "7";
                case 1598177384:
                    return "11";
                case 1639748947:
                    return "8";
                case 1831224761:
                    return "9";
                case 1939875509:
                    return "6";
                default:
                    return str;
            }
        }

        protected final boolean m4018a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 52:
                    if (str.equals("4")) {
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

    /* compiled from: profile_pic_image_size */
    public class PageUpcomingEventsQueryString extends TypedGraphQlQueryString<PageUpcomingEventsQueryModel> {
        public PageUpcomingEventsQueryString() {
            super(PageUpcomingEventsQueryModel.class, false, "PageUpcomingEventsQuery", "e3927e5014a82b29f4829b5e618cab61", "page", "10154686242151729", RegularImmutableSet.a);
        }

        public final String m4019a(String str) {
            switch (str.hashCode()) {
                case -1101600581:
                    return "3";
                case -803548981:
                    return "0";
                case -705314112:
                    return "2";
                case -77796550:
                    return "1";
                case 25209764:
                    return "12";
                case 689802720:
                    return "10";
                case 810737919:
                    return "4";
                case 1262925297:
                    return "5";
                case 1282232523:
                    return "7";
                case 1598177384:
                    return "11";
                case 1639748947:
                    return "8";
                case 1831224761:
                    return "9";
                case 1939875509:
                    return "6";
                default:
                    return str;
            }
        }

        protected final boolean m4020a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 52:
                    if (str.equals("4")) {
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
}
