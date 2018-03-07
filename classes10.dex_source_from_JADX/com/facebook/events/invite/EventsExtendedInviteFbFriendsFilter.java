package com.facebook.events.invite;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.util.StringUtil;
import com.facebook.events.invite.EventsExtendedInviteLocalInviteesFetcher.C25041;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.userfilter.UserTokenMatcher;
import com.facebook.widget.filter.AbstractCustomFilter;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: cohostsSlectorSuperState */
public class EventsExtendedInviteFbFriendsFilter extends AbstractCustomFilter {
    private boolean f17545a;
    private final C25041 f17546b;
    private final UserTokenMatcher f17547c;

    @Inject
    public EventsExtendedInviteFbFriendsFilter(FbHandlerThreadFactory fbHandlerThreadFactory, UserTokenMatcher userTokenMatcher, @Assisted C25041 c25041) {
        super(fbHandlerThreadFactory);
        this.f17547c = userTokenMatcher;
        this.f17546b = c25041;
    }

    protected final FilterResults m17921b(CharSequence charSequence) {
        FilterResults filterResults = new FilterResults();
        if (this.f17545a) {
            return filterResults;
        }
        ImmutableList immutableList = this.f17546b.f17619b.f17623d;
        if (StringUtil.c(charSequence)) {
            filterResults.a = immutableList;
            filterResults.b = immutableList.size();
            return filterResults;
        }
        this.f17547c.a(charSequence.toString());
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            SimpleUserToken simpleUserToken = (SimpleUserToken) immutableList.get(i);
            if (this.f17547c.a(simpleUserToken)) {
                builder.c(simpleUserToken);
                i3 = i2 + 1;
                C25041 c25041 = this.f17546b;
                if (i3 >= 3) {
                    break;
                }
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        ImmutableList b = builder.b();
        filterResults.a = b;
        filterResults.b = b.size();
        return filterResults;
    }

    protected final void m17920a(CharSequence charSequence, FilterResults filterResults) {
        if (!this.f17545a && filterResults.a != null) {
            FutureDetour.a(this.f17546b.f17618a, new SearchResponse((ImmutableList) filterResults.a), 1247526766);
        }
    }
}
