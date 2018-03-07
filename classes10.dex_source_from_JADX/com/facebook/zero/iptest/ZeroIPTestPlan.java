package com.facebook.zero.iptest;

import com.facebook.zero.connectiontest.ConnectionTester;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: events_invite_through_messenger_nux */
public class ZeroIPTestPlan {
    public static ZeroIPTestPlan f13075a = new ZeroIPTestPlan();
    private List<ConnectionTester> f13076b = new ArrayList();

    public final List<ConnectionTester> m13140a() {
        return ImmutableList.copyOf(this.f13076b);
    }

    public final void m13141a(List<ConnectionTester> list) {
        this.f13076b = list;
    }
}
