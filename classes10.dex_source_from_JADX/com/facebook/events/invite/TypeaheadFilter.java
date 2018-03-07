package com.facebook.events.invite;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.inject.Assisted;
import com.facebook.messaging.service.methods.SearchUsersMethod;
import com.facebook.messaging.service.model.SearchUserParams;
import com.facebook.messaging.service.model.SearchUserResult;
import com.facebook.user.model.User;
import com.facebook.widget.filter.AbstractCustomFilter;
import com.facebook.widget.filter.CustomFilter.FilterResults;
import com.facebook.widget.tokenizedtypeahead.model.BaseTokenMatcher;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: chatStyle */
public class TypeaheadFilter extends AbstractCustomFilter {
    private static final String f17760a = TypeaheadFilter.class.getSimpleName();
    private static final ImmutableSet<Integer> f17761i = ImmutableSet.of(Integer.valueOf(2));
    private final boolean f17762b;
    private final AbstractSingleMethodRunner f17763c;
    private final SearchUsersMethod f17764d;
    public final String f17765e;
    private final BaseTokenMatcher f17766f;
    private List<EventInviteeToken> f17767g = Collections.emptyList();
    private final TypeaheadFilterListener f17768h;
    public Set<String> f17769j;
    public Set<String> f17770k;

    /* compiled from: chatStyle */
    public interface TypeaheadFilterListener {
        void mo806a(List<EventInviteeToken> list);
    }

    @Inject
    public TypeaheadFilter(FbHandlerThreadFactory fbHandlerThreadFactory, Boolean bool, AbstractSingleMethodRunner abstractSingleMethodRunner, SearchUsersMethod searchUsersMethod, String str, @Assisted BaseTokenMatcher baseTokenMatcher, @Assisted TypeaheadFilterListener typeaheadFilterListener) {
        super(fbHandlerThreadFactory);
        this.f17762b = bool.booleanValue();
        this.f17763c = abstractSingleMethodRunner;
        this.f17764d = searchUsersMethod;
        this.f17766f = baseTokenMatcher;
        this.f17765e = str;
        this.f17768h = typeaheadFilterListener;
    }

    protected final FilterResults m18106b(CharSequence charSequence) {
        FilterResults filterResults = new FilterResults();
        if (this.f17762b) {
            m18104b(charSequence, filterResults);
        } else {
            filterResults.b = this.f17767g.size();
            if (StringUtil.c(charSequence)) {
                filterResults.a = this.f17767g;
                return filterResults;
            }
            this.f17766f.a(charSequence.toString());
            List arrayList = new ArrayList();
            for (EventInviteeToken eventInviteeToken : this.f17767g) {
                if (this.f17766f.a(eventInviteeToken)) {
                    arrayList.add(eventInviteeToken);
                }
            }
            filterResults.a = arrayList;
        }
        return filterResults;
    }

    private void m18104b(CharSequence charSequence, FilterResults filterResults) {
        try {
            SearchUserResult searchUserResult = (SearchUserResult) this.f17763c.a(this.f17764d, new SearchUserParams(charSequence.toString(), f17761i));
            List arrayList = new ArrayList();
            ImmutableList b = searchUserResult.b();
            int size = b.size();
            for (int i = 0; i < size; i++) {
                User user = (User) b.get(i);
                if (!m18103a(user)) {
                    arrayList.add(new EventInviteeToken(user));
                }
            }
            filterResults.a = arrayList;
            filterResults.b = arrayList.size();
        } catch (Exception e) {
        }
    }

    protected final void m18105a(CharSequence charSequence, FilterResults filterResults) {
        if (filterResults.a != null) {
            this.f17768h.mo806a((List) filterResults.a);
        } else {
            this.f17768h.mo806a(this.f17767g);
        }
    }

    private boolean m18103a(User user) {
        if (!user.a.equals(this.f17765e)) {
            Object obj;
            if (this.f17770k == null || !this.f17770k.contains(user.a)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                obj = (this.f17769j == null || !this.f17769j.contains(user.a)) ? null : 1;
                if (obj == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
