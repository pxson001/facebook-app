package com.facebook.abtest.qe.protocol.sync.user;

import com.facebook.abtest.qe.protocol.sync.SyncMultiQuickExperimentParams;
import com.facebook.abtest.qe.protocol.sync.SyncQuickExperimentParams;
import com.facebook.abtest.qe.protocol.sync.user.SyncMultiQuickExperimentUserInfoResult.Builder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/* compiled from: thumbnail_scale_factor */
public class SyncMultiQuickExperimentUserInfoResultHelper {
    @Nullable
    public final SyncMultiQuickExperimentUserInfoResult m1368a(JsonNode jsonNode, SyncMultiQuickExperimentParams syncMultiQuickExperimentParams) {
        if (jsonNode == null) {
            return null;
        }
        Builder builder = new Builder();
        ImmutableList immutableList = syncMultiQuickExperimentParams.f1110a;
        for (int i = 0; i < jsonNode.e(); i++) {
            builder.f1115a.add(m1366a(jsonNode.a(i), (SyncQuickExperimentParams) immutableList.get(i)));
        }
        return new SyncMultiQuickExperimentUserInfoResult(builder);
    }

    @Nullable
    private static SyncQuickExperimentUserInfoResult m1366a(JsonNode jsonNode, SyncQuickExperimentParams syncQuickExperimentParams) {
        if (jsonNode == null || syncQuickExperimentParams == null) {
            return null;
        }
        JsonNode b = jsonNode.b("data");
        if (b == null) {
            return null;
        }
        if (b.n()) {
            if (b.C() != 0) {
                return null;
            }
            return new SyncQuickExperimentUserInfoResult(syncQuickExperimentParams.f1108a, "local_default_group", false, false, "", RegularImmutableBiMap.a);
        } else if (b.e() == 0) {
            return null;
        } else {
            String s = b.a(0).b("group").s();
            if (s == null) {
                s = "local_default_group";
            }
            JsonNode b2 = b.a(0).b("params");
            return new SyncQuickExperimentUserInfoResult(syncQuickExperimentParams.f1108a, s, b.a(0).b("in_experiment").u(), b.a(0).b("in_deploy_group").u(), b.a(0).b("hash").s(), m1367a(b2));
        }
    }

    private static ImmutableMap<String, String> m1367a(JsonNode jsonNode) {
        ImmutableMap.Builder builder = new ImmutableMap.Builder();
        Iterator H = jsonNode.H();
        while (H.hasNext()) {
            Entry entry = (Entry) H.next();
            JsonNode b = ((JsonNode) entry.getValue()).b("type");
            if (b != null && (b.C() == 1 || b.C() == 2)) {
                builder.b(entry.getKey(), ((JsonNode) entry.getValue()).b("value").B());
            }
        }
        return builder.b();
    }
}
