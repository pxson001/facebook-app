package com.facebook.privacy.ui;

import com.facebook.privacy.model.CustomPrivacyToken;
import com.facebook.privacy.model.FriendsExceptToken;
import com.facebook.privacy.model.PrivacyToken;
import com.facebook.privacy.model.SpecificFriendsToken;
import com.facebook.privacy.model.TagExpansionToken;
import com.facebook.widget.listview.ExpandableSectionedListSection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Provider;

/* compiled from: fbTraceMeta */
public class PrivacyOptionsSection extends ExpandableSectionedListSection<PrivacyToken> {
    private final List<PrivacyToken> f15195a;
    private final List<PrivacyToken> f15196b;
    private final Provider<Integer> f15197c;
    private PrivacyToken f15198d;

    public PrivacyOptionsSection(List<PrivacyToken> list, List<PrivacyToken> list2, Provider<Integer> provider) {
        super(null);
        this.f15195a = Lists.a(list);
        this.f15196b = Lists.a(list2);
        this.f15197c = provider;
    }

    public final List<PrivacyToken> mo1212e() {
        return this.f15195a;
    }

    protected final List<PrivacyToken> mo1211d() {
        Integer num = (Integer) this.f15197c.get();
        Iterable a = Lists.a();
        if (num != null) {
            for (Object obj : this.f15195a) {
                if (num.equals(obj.mo1196c())) {
                    break;
                }
            }
            Object obj2 = null;
            if (!(obj2 == null || this.f15196b.contains(obj2))) {
                a.add(obj2);
            }
        }
        if (!(this.f15198d == null || this.f15196b.contains(this.f15198d))) {
            a.add(this.f15198d);
        }
        return ImmutableList.builder().b(this.f15196b).b(a).b();
    }

    public final PrivacyToken m22849a(int i) {
        for (PrivacyToken privacyToken : this.f15195a) {
            Integer c = privacyToken.mo1196c();
            if (c != null && i == c.intValue()) {
                return privacyToken;
            }
        }
        return null;
    }

    public final CustomPrivacyToken m22853g() {
        for (PrivacyToken privacyToken : this.f15195a) {
            if (privacyToken instanceof CustomPrivacyToken) {
                return (CustomPrivacyToken) privacyToken;
            }
        }
        return null;
    }

    public final FriendsExceptToken m22854h() {
        for (PrivacyToken privacyToken : this.f15195a) {
            if (privacyToken instanceof FriendsExceptToken) {
                return (FriendsExceptToken) privacyToken;
            }
        }
        return null;
    }

    public final SpecificFriendsToken m22855i() {
        for (PrivacyToken privacyToken : this.f15195a) {
            if (privacyToken instanceof SpecificFriendsToken) {
                return (SpecificFriendsToken) privacyToken;
            }
        }
        return null;
    }

    public final void m22850a(TagExpansionToken tagExpansionToken, int i) {
        if (!this.f15195a.contains(tagExpansionToken)) {
            this.f15195a.add(i, tagExpansionToken);
            if (i == 0) {
                this.f15196b.add(0, tagExpansionToken);
            } else {
                int indexOf = this.f15196b.indexOf(this.f15195a.get(i - 1));
                if (indexOf != -1) {
                    this.f15196b.add(indexOf + 1, tagExpansionToken);
                }
            }
            this.f15198d = tagExpansionToken;
        }
    }

    public final void m22856j() {
        this.f15195a.remove(this.f15198d);
        this.f15196b.remove(this.f15198d);
        this.f15198d = null;
    }
}
