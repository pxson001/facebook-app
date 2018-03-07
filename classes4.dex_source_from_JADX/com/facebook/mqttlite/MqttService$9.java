package com.facebook.mqttlite;

import com.facebook.push.mqtt.external.ForegroundStateThriftPayloadBuilder;
import com.facebook.rti.mqtt.common.analytics.MqttAnalyticsLogger;
import com.facebook.rti.mqtt.manager.MqttPushServiceBootstrap;
import com.facebook.rti.mqtt.protocol.MqttException;
import com.facebook.thrift.TException;
import com.google.common.base.Optional;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* compiled from: global_feature */
class MqttService$9 implements Runnable {
    final /* synthetic */ Optional f11030a;
    final /* synthetic */ Optional f11031b;
    final /* synthetic */ List f11032c;
    final /* synthetic */ List f11033d;
    final /* synthetic */ MqttService f11034e;

    MqttService$9(MqttService mqttService, Optional optional, Optional optional2, List list, List list2) {
        this.f11034e = mqttService;
        this.f11030a = optional;
        this.f11031b = optional2;
        this.f11032c = list;
        this.f11033d = list2;
    }

    public void run() {
        int i = 0;
        try {
            int i2;
            byte[] a = ForegroundStateThriftPayloadBuilder.m11481a(this.f11030a, this.f11031b, this.f11032c, this.f11033d);
            MqttAnalyticsLogger mqttAnalyticsLogger = this.f11034e.g;
            String str = "/t_fs";
            boolean booleanValue = ((Boolean) this.f11030a.orNull()).booleanValue();
            int intValue = ((Integer) this.f11031b.orNull()).intValue();
            if (this.f11032c == null) {
                i2 = 0;
            } else {
                i2 = this.f11032c.size();
            }
            if (this.f11033d != null) {
                i = this.f11033d.size();
            }
            mqttAnalyticsLogger.a(str, booleanValue, intValue, i2, i);
            boolean a2 = this.f11034e.c.a(a, MqttService.b(this.f11032c), this.f11033d);
            if (this.f11030a.isPresent() && ((Boolean) this.f11034e.M.get()).booleanValue() && MqttPushServiceBootstrap.E != null) {
                MqttPushServiceBootstrap.E.a(((Boolean) this.f11030a.get()).booleanValue(), a2);
            }
        } catch (InterruptedException e) {
            MqttService.s();
        } catch (TException e2) {
            MqttService.s();
        } catch (MqttException e3) {
            MqttService.s();
        } catch (ExecutionException e4) {
            MqttService.s();
        } catch (TimeoutException e5) {
            MqttService.s();
        }
    }
}
