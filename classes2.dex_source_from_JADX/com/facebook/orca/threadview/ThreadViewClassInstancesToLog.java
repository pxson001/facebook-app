package com.facebook.orca.threadview;

import com.facebook.common.errorreporting.memory.ClassInstancesToLog;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: trust/afro/? */
public class ThreadViewClassInstancesToLog implements ClassInstancesToLog {
    public final Set<Class> mo636a() {
        return Sets.m1315a(MessageItemView.class, ThreadViewMessagesFragment.class, ThreadViewFragment.class, ThreadViewActivity.class);
    }
}
