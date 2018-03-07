package com.facebook.groups.composer.groupspollcomposer;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbJsonField;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.google.common.base.Throwables;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

/* compiled from: view_fundraiser_supporters */
public class GroupsPollDataModelDeserializer extends FbJsonDeserializer {
    private static Map<String, FbJsonField> f473a;

    static {
        GlobalAutoGenDeserializerCache.a(GroupsPollDataModel.class, new GroupsPollDataModelDeserializer());
        m467e();
    }

    public GroupsPollDataModelDeserializer() {
        a(GroupsPollDataModel.class);
    }

    private static synchronized Map<String, FbJsonField> m467e() {
        Map<String, FbJsonField> map;
        synchronized (GroupsPollDataModelDeserializer.class) {
            if (f473a == null) {
                try {
                    Builder builder = new Builder();
                    builder.b("poll_optins", FbJsonField.jsonField(GroupsPollDataModel.class.getDeclaredField("pollOptions"), String.class));
                    builder.b("can_add_poll_option", FbJsonField.jsonField(GroupsPollDataModel.class.getDeclaredField("canViewerAddPollOption")));
                    builder.b("can_choose_multiple_options", FbJsonField.jsonField(GroupsPollDataModel.class.getDeclaredField("canViewerChooseMultipleOptions")));
                    f473a = builder.b();
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            map = f473a;
        }
        return map;
    }

    public final FbJsonField m468a(String str) {
        FbJsonField fbJsonField = (FbJsonField) m467e().get(str);
        return fbJsonField != null ? fbJsonField : super.a(str);
    }

    public static Set<String> getJsonFields() {
        return Sets.b(m467e().keySet());
    }
}
