package com.facebook.push.mqtt.external;

import com.facebook.messaging.sync.model.thrift.MqttThriftHeader;
import com.facebook.mqtt.model.thrift.ForegroundState;
import com.facebook.mqtt.model.thrift.SubscribeGenericTopic;
import com.facebook.mqtt.topic.MqttTopic;
import com.facebook.push.mqtt.ipc.SubscribeTopic;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.google.common.base.Optional;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: gks */
public class ForegroundStateThriftPayloadBuilder {
    private static final Class<?> f11037a = ForegroundStateThriftPayloadBuilder.class;

    public static byte[] m11481a(Optional<Boolean> optional, Optional<Integer> optional2, List<SubscribeTopic> list, List<String> list2) {
        TSerializer tSerializer = new TSerializer(new Factory());
        ForegroundState a = m11480a((Boolean) optional.orNull(), (Integer) optional2.orNull(), (List) list, (List) list2);
        byte[] a2 = tSerializer.a(new MqttThriftHeader(null));
        Object a3 = tSerializer.a(a);
        Object copyOf = Arrays.copyOf(a2, a2.length + a3.length);
        System.arraycopy(a3, 0, copyOf, a2.length, a3.length);
        return copyOf;
    }

    private static ForegroundState m11480a(@Nullable Boolean bool, @Nullable Integer num, List<SubscribeTopic> list, List<String> list2) {
        List list3;
        Boolean bool2;
        List linkedList;
        List list4;
        List list5;
        List list6;
        List list7;
        if (list != null) {
            list3 = null;
            bool2 = null;
            for (SubscribeTopic subscribeTopic : list) {
                Integer a = MqttTopic.a(subscribeTopic.f11058a);
                if (a != null) {
                    if (bool2 == null) {
                        linkedList = new LinkedList();
                    } else {
                        Object obj = bool2;
                    }
                    linkedList.add(a);
                    bool2 = linkedList;
                } else {
                    if (list3 == null) {
                        list3 = new LinkedList();
                    }
                    list3.add(new SubscribeGenericTopic(subscribeTopic.f11058a, Integer.valueOf(subscribeTopic.f11059b)));
                }
            }
            list4 = list3;
            list5 = bool2;
        } else {
            list4 = null;
            list5 = null;
        }
        if (list2 != null) {
            list3 = null;
            bool2 = null;
            for (String str : list2) {
                Integer a2 = MqttTopic.a(str);
                if (a2 != null) {
                    if (bool2 == null) {
                        linkedList = new LinkedList();
                    } else {
                        obj = bool2;
                    }
                    linkedList.add(a2);
                    bool2 = linkedList;
                } else {
                    if (list3 == null) {
                        list3 = new LinkedList();
                    }
                    list3.add(str);
                }
            }
            list6 = list3;
            list7 = bool2;
        } else {
            list6 = null;
            list7 = null;
        }
        return new ForegroundState(bool, null, num, list5, list4, list7, list6);
    }
}
