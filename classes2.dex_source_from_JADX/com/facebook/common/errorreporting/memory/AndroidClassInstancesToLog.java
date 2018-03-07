package com.facebook.common.errorreporting.memory;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import com.google.common.collect.Sets;
import java.util.Set;

/* compiled from: try_show_survey_on_result_integration_point_id */
public class AndroidClassInstancesToLog implements ClassInstancesToLog {
    public final Set<Class> mo636a() {
        return Sets.m1315a(Context.class, Activity.class, Service.class);
    }
}
