package com.facebook.sync.connection;

import com.facebook.sync.model.thrift.GetIrisDiffs;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: feedback_id=%s */
public class GetIrisDiffsBuilder {
    private static final HashSet<String> f14444a = Sets.a(new String[]{"sync_token", "last_seq_id", "max_deltas_able_to_process", "delta_batch_size", "encoding", "queue_type", "sync_api_version", "sync_device_id", "device_params", "queue_params", "entity_fbid"});
    @Nullable
    private String f14445b;
    @Nullable
    private Long f14446c;
    @Nullable
    private Integer f14447d;
    @Nullable
    private Integer f14448e;
    @Nullable
    private String f14449f;
    @Nullable
    private String f14450g;
    @Nullable
    private Integer f14451h;
    @Nullable
    private String f14452i;
    @Nullable
    private String f14453j;
    @Nullable
    private String f14454k;
    @Nullable
    private Long f14455l;

    public static boolean m18346a(ObjectNode objectNode) {
        Iterator j = objectNode.j();
        while (j.hasNext()) {
            if (!f14444a.contains(j.next())) {
                return false;
            }
        }
        return true;
    }

    public final GetIrisDiffsBuilder m18348b(ObjectNode objectNode) {
        Long l = null;
        Preconditions.checkArgument(m18346a(objectNode));
        this.f14445b = objectNode.b("sync_token") == null ? null : objectNode.b("sync_token").B();
        this.f14446c = objectNode.b("last_seq_id") == null ? null : Long.valueOf(objectNode.b("last_seq_id").D());
        this.f14447d = objectNode.b("max_deltas_able_to_process") == null ? null : Integer.valueOf(objectNode.b("max_deltas_able_to_process").C());
        this.f14448e = objectNode.b("delta_batch_size") == null ? null : Integer.valueOf(objectNode.b("delta_batch_size").C());
        this.f14449f = objectNode.b("encoding") == null ? null : objectNode.b("encoding").B();
        this.f14450g = objectNode.b("queue_type") == null ? null : objectNode.b("queue_type").B();
        this.f14451h = objectNode.b("sync_api_version") == null ? null : Integer.valueOf(objectNode.b("sync_api_version").C());
        this.f14452i = objectNode.b("sync_device_id") == null ? null : objectNode.b("sync_device_id").B();
        this.f14453j = objectNode.b("device_params") == null ? null : objectNode.b("device_params").toString();
        this.f14454k = objectNode.b("queue_params") == null ? null : objectNode.b("queue_params").toString();
        if (objectNode.b("entity_fbid") != null) {
            l = Long.valueOf(objectNode.b("entity_fbid").D());
        }
        this.f14455l = l;
        return this;
    }

    public final GetIrisDiffs m18347a() {
        Preconditions.checkNotNull(this.f14445b);
        Preconditions.checkNotNull(this.f14446c);
        Preconditions.checkNotNull(this.f14447d);
        return new GetIrisDiffs(this.f14445b, this.f14446c, this.f14447d, this.f14448e, this.f14449f, this.f14450g, this.f14451h, this.f14452i, this.f14453j, this.f14454k, this.f14455l);
    }
}
