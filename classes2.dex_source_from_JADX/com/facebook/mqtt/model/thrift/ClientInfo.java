package com.facebook.mqtt.model.thrift;

import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* compiled from: fglNonUiHandler */
public class ClientInfo implements TBase, Serializable, Cloneable {
    private static final TField f23759A = new TField("fbnsDeviceSecret", (byte) 11, (short) 25);
    public static boolean f23760a = true;
    private static final TStruct f23761b = new TStruct("ClientInfo");
    private static final TField f23762c = new TField("userId", (byte) 10, (short) 1);
    private static final TField f23763d = new TField("userAgent", (byte) 11, (short) 2);
    private static final TField f23764e = new TField("clientCapabilities", (byte) 10, (short) 3);
    private static final TField f23765f = new TField("endpointCapabilities", (byte) 10, (short) 4);
    private static final TField f23766g = new TField("publishFormat", (byte) 8, (short) 5);
    private static final TField f23767h = new TField("noAutomaticForeground", (byte) 2, (short) 6);
    private static final TField f23768i = new TField("makeUserAvailableInForeground", (byte) 2, (short) 7);
    private static final TField f23769j = new TField("deviceId", (byte) 11, (short) 8);
    private static final TField f23770k = new TField("isInitiallyForeground", (byte) 2, (short) 9);
    private static final TField f23771l = new TField("networkType", (byte) 8, (short) 10);
    private static final TField f23772m = new TField("networkSubtype", (byte) 8, (short) 11);
    private static final TField f23773n = new TField("clientMqttSessionId", (byte) 10, (short) 12);
    private static final TField f23774o = new TField("clientIpAddress", (byte) 11, (short) 13);
    private static final TField f23775p = new TField("subscribeTopics", (byte) 15, (short) 14);
    private static final TField f23776q = new TField("clientType", (byte) 11, (short) 15);
    private static final TField f23777r = new TField("appId", (byte) 10, (short) 16);
    private static final TField f23778s = new TField("overrideNectarLogging", (byte) 2, (short) 17);
    private static final TField f23779t = new TField("connectTokenHash", (byte) 11, (short) 18);
    private static final TField f23780u = new TField("regionPreference", (byte) 11, (short) 19);
    private static final TField f23781v = new TField("deviceSecret", (byte) 11, (short) 20);
    private static final TField f23782w = new TField("clientStack", (byte) 3, (short) 21);
    private static final TField f23783x = new TField("fbnsConnectionKey", (byte) 10, (short) 22);
    private static final TField f23784y = new TField("fbnsConnectionSecret", (byte) 11, (short) 23);
    private static final TField f23785z = new TField("fbnsDeviceId", (byte) 11, (short) 24);
    public final Long appId;
    public final Long clientCapabilities;
    public final String clientIpAddress;
    public final Long clientMqttSessionId;
    public final Byte clientStack;
    public final String clientType;
    public final byte[] connectTokenHash;
    public final String deviceId;
    public final String deviceSecret;
    public final Long endpointCapabilities;
    public final Long fbnsConnectionKey;
    public final String fbnsConnectionSecret;
    public final String fbnsDeviceId;
    public final String fbnsDeviceSecret;
    public final Boolean isInitiallyForeground;
    public final Boolean makeUserAvailableInForeground;
    public final Integer networkSubtype;
    public final Integer networkType;
    public final Boolean noAutomaticForeground;
    public final Boolean overrideNectarLogging;
    public final Integer publishFormat;
    public final String regionPreference;
    public final List<Integer> subscribeTopics;
    public final String userAgent;
    public final Long userId;

    public ClientInfo(Long l, String str, Long l2, Long l3, Integer num, Boolean bool, Boolean bool2, String str2, Boolean bool3, Integer num2, Integer num3, Long l4, String str3, List<Integer> list, String str4, Long l5, Boolean bool4, byte[] bArr, String str5, String str6, Byte b, Long l6, String str7, String str8, String str9) {
        this.userId = l;
        this.userAgent = str;
        this.clientCapabilities = l2;
        this.endpointCapabilities = l3;
        this.publishFormat = num;
        this.noAutomaticForeground = bool;
        this.makeUserAvailableInForeground = bool2;
        this.deviceId = str2;
        this.isInitiallyForeground = bool3;
        this.networkType = num2;
        this.networkSubtype = num3;
        this.clientMqttSessionId = l4;
        this.clientIpAddress = str3;
        this.subscribeTopics = list;
        this.clientType = str4;
        this.appId = l5;
        this.overrideNectarLogging = bool4;
        this.connectTokenHash = bArr;
        this.regionPreference = str5;
        this.deviceSecret = str6;
        this.clientStack = b;
        this.fbnsConnectionKey = l6;
        this.fbnsConnectionSecret = str7;
        this.fbnsDeviceId = str8;
        this.fbnsDeviceSecret = str9;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ClientInfo)) {
            return m32192a((ClientInfo) obj);
        }
        return false;
    }

    public final boolean m32192a(ClientInfo clientInfo) {
        if (clientInfo == null) {
            return false;
        }
        boolean z;
        boolean z2 = this.userId != null;
        if (clientInfo.userId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.userId.equals(clientInfo.userId))) {
            return false;
        }
        if (this.userAgent != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.userAgent != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.userAgent.equals(clientInfo.userAgent))) {
            return false;
        }
        if (this.clientCapabilities != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.clientCapabilities != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.clientCapabilities.equals(clientInfo.clientCapabilities))) {
            return false;
        }
        if (this.endpointCapabilities != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.endpointCapabilities != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.endpointCapabilities.equals(clientInfo.endpointCapabilities))) {
            return false;
        }
        if (this.publishFormat != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.publishFormat != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.publishFormat.equals(clientInfo.publishFormat))) {
            return false;
        }
        if (this.noAutomaticForeground != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.noAutomaticForeground != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.noAutomaticForeground.equals(clientInfo.noAutomaticForeground))) {
            return false;
        }
        if (this.makeUserAvailableInForeground != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.makeUserAvailableInForeground != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.makeUserAvailableInForeground.equals(clientInfo.makeUserAvailableInForeground))) {
            return false;
        }
        if (this.deviceId != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.deviceId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.deviceId.equals(clientInfo.deviceId))) {
            return false;
        }
        if (this.isInitiallyForeground != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.isInitiallyForeground != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.isInitiallyForeground.equals(clientInfo.isInitiallyForeground))) {
            return false;
        }
        if (this.networkType != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.networkType != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.networkType.equals(clientInfo.networkType))) {
            return false;
        }
        if (this.networkSubtype != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.networkSubtype != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.networkSubtype.equals(clientInfo.networkSubtype))) {
            return false;
        }
        if (this.clientMqttSessionId != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.clientMqttSessionId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.clientMqttSessionId.equals(clientInfo.clientMqttSessionId))) {
            return false;
        }
        if (this.clientIpAddress != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.clientIpAddress != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.clientIpAddress.equals(clientInfo.clientIpAddress))) {
            return false;
        }
        if (this.subscribeTopics != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.subscribeTopics != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.subscribeTopics.equals(clientInfo.subscribeTopics))) {
            return false;
        }
        if (this.clientType != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.clientType != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.clientType.equals(clientInfo.clientType))) {
            return false;
        }
        if (this.appId != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.appId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.appId.equals(clientInfo.appId))) {
            return false;
        }
        if (this.overrideNectarLogging != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.overrideNectarLogging != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.overrideNectarLogging.equals(clientInfo.overrideNectarLogging))) {
            return false;
        }
        if (this.connectTokenHash != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.connectTokenHash != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !Arrays.equals(this.connectTokenHash, clientInfo.connectTokenHash))) {
            return false;
        }
        if (this.regionPreference != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.regionPreference != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.regionPreference.equals(clientInfo.regionPreference))) {
            return false;
        }
        if (this.deviceSecret != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.deviceSecret != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.deviceSecret.equals(clientInfo.deviceSecret))) {
            return false;
        }
        if (this.clientStack != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.clientStack != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.clientStack.equals(clientInfo.clientStack))) {
            return false;
        }
        if (this.fbnsConnectionKey != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.fbnsConnectionKey != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.fbnsConnectionKey.equals(clientInfo.fbnsConnectionKey))) {
            return false;
        }
        if (this.fbnsConnectionSecret != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.fbnsConnectionSecret != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.fbnsConnectionSecret.equals(clientInfo.fbnsConnectionSecret))) {
            return false;
        }
        if (this.fbnsDeviceId != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.fbnsDeviceId != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.fbnsDeviceId.equals(clientInfo.fbnsDeviceId))) {
            return false;
        }
        if (this.fbnsDeviceSecret != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (clientInfo.fbnsDeviceSecret != null) {
            z = true;
        } else {
            z = false;
        }
        if ((z2 || r3) && (!z2 || !r3 || !this.fbnsDeviceSecret.equals(clientInfo.fbnsDeviceSecret))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public final void mo3464a(TProtocol tProtocol) {
        m32189a();
        tProtocol.mo3468a();
        if (this.userId != null) {
            tProtocol.mo3472a(f23762c);
            tProtocol.mo3471a(this.userId.longValue());
        }
        if (!(this.userAgent == null || this.userAgent == null)) {
            tProtocol.mo3472a(f23763d);
            tProtocol.mo3475a(this.userAgent);
        }
        if (!(this.clientCapabilities == null || this.clientCapabilities == null)) {
            tProtocol.mo3472a(f23764e);
            tProtocol.mo3471a(this.clientCapabilities.longValue());
        }
        if (!(this.endpointCapabilities == null || this.endpointCapabilities == null)) {
            tProtocol.mo3472a(f23765f);
            tProtocol.mo3471a(this.endpointCapabilities.longValue());
        }
        if (!(this.publishFormat == null || this.publishFormat == null)) {
            tProtocol.mo3472a(f23766g);
            tProtocol.mo3470a(this.publishFormat.intValue());
        }
        if (!(this.noAutomaticForeground == null || this.noAutomaticForeground == null)) {
            tProtocol.mo3472a(f23767h);
            tProtocol.mo3477a(this.noAutomaticForeground.booleanValue());
        }
        if (!(this.makeUserAvailableInForeground == null || this.makeUserAvailableInForeground == null)) {
            tProtocol.mo3472a(f23768i);
            tProtocol.mo3477a(this.makeUserAvailableInForeground.booleanValue());
        }
        if (!(this.deviceId == null || this.deviceId == null)) {
            tProtocol.mo3472a(f23769j);
            tProtocol.mo3475a(this.deviceId);
        }
        if (!(this.isInitiallyForeground == null || this.isInitiallyForeground == null)) {
            tProtocol.mo3472a(f23770k);
            tProtocol.mo3477a(this.isInitiallyForeground.booleanValue());
        }
        if (!(this.networkType == null || this.networkType == null)) {
            tProtocol.mo3472a(f23771l);
            tProtocol.mo3470a(this.networkType.intValue());
        }
        if (!(this.networkSubtype == null || this.networkSubtype == null)) {
            tProtocol.mo3472a(f23772m);
            tProtocol.mo3470a(this.networkSubtype.intValue());
        }
        if (!(this.clientMqttSessionId == null || this.clientMqttSessionId == null)) {
            tProtocol.mo3472a(f23773n);
            tProtocol.mo3471a(this.clientMqttSessionId.longValue());
        }
        if (!(this.clientIpAddress == null || this.clientIpAddress == null)) {
            tProtocol.mo3472a(f23774o);
            tProtocol.mo3475a(this.clientIpAddress);
        }
        if (!(this.subscribeTopics == null || this.subscribeTopics == null)) {
            tProtocol.mo3472a(f23775p);
            tProtocol.mo3473a(new TList((byte) 8, this.subscribeTopics.size()));
            for (Integer intValue : this.subscribeTopics) {
                tProtocol.mo3470a(intValue.intValue());
            }
        }
        if (!(this.clientType == null || this.clientType == null)) {
            tProtocol.mo3472a(f23776q);
            tProtocol.mo3475a(this.clientType);
        }
        if (!(this.appId == null || this.appId == null)) {
            tProtocol.mo3472a(f23777r);
            tProtocol.mo3471a(this.appId.longValue());
        }
        if (!(this.overrideNectarLogging == null || this.overrideNectarLogging == null)) {
            tProtocol.mo3472a(f23778s);
            tProtocol.mo3477a(this.overrideNectarLogging.booleanValue());
        }
        if (!(this.connectTokenHash == null || this.connectTokenHash == null)) {
            tProtocol.mo3472a(f23779t);
            tProtocol.mo3478a(this.connectTokenHash);
        }
        if (!(this.regionPreference == null || this.regionPreference == null)) {
            tProtocol.mo3472a(f23780u);
            tProtocol.mo3475a(this.regionPreference);
        }
        if (!(this.deviceSecret == null || this.deviceSecret == null)) {
            tProtocol.mo3472a(f23781v);
            tProtocol.mo3475a(this.deviceSecret);
        }
        if (!(this.clientStack == null || this.clientStack == null)) {
            tProtocol.mo3472a(f23782w);
            tProtocol.mo3469a(this.clientStack.byteValue());
        }
        if (!(this.fbnsConnectionKey == null || this.fbnsConnectionKey == null)) {
            tProtocol.mo3472a(f23783x);
            tProtocol.mo3471a(this.fbnsConnectionKey.longValue());
        }
        if (!(this.fbnsConnectionSecret == null || this.fbnsConnectionSecret == null)) {
            tProtocol.mo3472a(f23784y);
            tProtocol.mo3475a(this.fbnsConnectionSecret);
        }
        if (!(this.fbnsDeviceId == null || this.fbnsDeviceId == null)) {
            tProtocol.mo3472a(f23785z);
            tProtocol.mo3475a(this.fbnsDeviceId);
        }
        if (!(this.fbnsDeviceSecret == null || this.fbnsDeviceSecret == null)) {
            tProtocol.mo3472a(f23759A);
            tProtocol.mo3475a(this.fbnsDeviceSecret);
        }
        tProtocol.mo3480c();
        tProtocol.mo3479b();
    }

    public String toString() {
        return mo3463a(1, f23760a);
    }

    public final String mo3463a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("ClientInfo");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("userId");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.userId == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.userId, i + 1, z));
        }
        if (this.userAgent != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("userAgent");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.userAgent == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.userAgent, i + 1, z));
            }
        }
        if (this.clientCapabilities != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("clientCapabilities");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.clientCapabilities == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.clientCapabilities, i + 1, z));
            }
        }
        if (this.endpointCapabilities != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("endpointCapabilities");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.endpointCapabilities == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.endpointCapabilities, i + 1, z));
            }
        }
        if (this.publishFormat != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("publishFormat");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.publishFormat == null) {
                stringBuilder.append("null");
            } else {
                String str3 = (String) PublishFormat.f23791b.get(this.publishFormat);
                if (str3 != null) {
                    stringBuilder.append(str3);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.publishFormat);
                if (str3 != null) {
                    stringBuilder.append(")");
                }
            }
        }
        if (this.noAutomaticForeground != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("noAutomaticForeground");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.noAutomaticForeground == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.noAutomaticForeground, i + 1, z));
            }
        }
        if (this.makeUserAvailableInForeground != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("makeUserAvailableInForeground");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.makeUserAvailableInForeground == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.makeUserAvailableInForeground, i + 1, z));
            }
        }
        if (this.deviceId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("deviceId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.deviceId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.deviceId, i + 1, z));
            }
        }
        if (this.isInitiallyForeground != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("isInitiallyForeground");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.isInitiallyForeground == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.isInitiallyForeground, i + 1, z));
            }
        }
        if (this.networkType != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("networkType");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.networkType == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.networkType, i + 1, z));
            }
        }
        if (this.networkSubtype != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("networkSubtype");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.networkSubtype == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.networkSubtype, i + 1, z));
            }
        }
        if (this.clientMqttSessionId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("clientMqttSessionId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.clientMqttSessionId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.clientMqttSessionId, i + 1, z));
            }
        }
        if (this.clientIpAddress != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("clientIpAddress");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.clientIpAddress == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.clientIpAddress, i + 1, z));
            }
        }
        if (this.subscribeTopics != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("subscribeTopics");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.subscribeTopics == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.subscribeTopics, i + 1, z));
            }
        }
        if (this.clientType != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("clientType");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.clientType == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.clientType, i + 1, z));
            }
        }
        if (this.appId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("appId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.appId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.appId, i + 1, z));
            }
        }
        if (this.overrideNectarLogging != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("overrideNectarLogging");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.overrideNectarLogging == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.overrideNectarLogging, i + 1, z));
            }
        }
        if (this.connectTokenHash != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("connectTokenHash");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.connectTokenHash == null) {
                stringBuilder.append("null");
            } else {
                int min = Math.min(this.connectTokenHash.length, HTTPTransportCallback.BODY_BYTES_RECEIVED);
                for (int i2 = 0; i2 < min; i2++) {
                    if (i2 != 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append(Integer.toHexString(this.connectTokenHash[i2]).length() > 1 ? Integer.toHexString(this.connectTokenHash[i2]).substring(Integer.toHexString(this.connectTokenHash[i2]).length() - 2).toUpperCase() : "0" + Integer.toHexString(this.connectTokenHash[i2]).toUpperCase());
                }
                if (this.connectTokenHash.length > HTTPTransportCallback.BODY_BYTES_RECEIVED) {
                    stringBuilder.append(" ...");
                }
            }
        }
        if (this.regionPreference != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("regionPreference");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.regionPreference == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.regionPreference, i + 1, z));
            }
        }
        if (this.deviceSecret != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("deviceSecret");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.deviceSecret == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.deviceSecret, i + 1, z));
            }
        }
        if (this.clientStack != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("clientStack");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.clientStack == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.clientStack, i + 1, z));
            }
        }
        if (this.fbnsConnectionKey != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("fbnsConnectionKey");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.fbnsConnectionKey == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.fbnsConnectionKey, i + 1, z));
            }
        }
        if (this.fbnsConnectionSecret != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("fbnsConnectionSecret");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.fbnsConnectionSecret == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.fbnsConnectionSecret, i + 1, z));
            }
        }
        if (this.fbnsDeviceId != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("fbnsDeviceId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.fbnsDeviceId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.fbnsDeviceId, i + 1, z));
            }
        }
        if (this.fbnsDeviceSecret != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("fbnsDeviceSecret");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.fbnsDeviceSecret == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.fbnsDeviceSecret, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m32189a() {
        if (this.publishFormat != null && !PublishFormat.f23790a.contains(this.publishFormat)) {
            throw new TProtocolException("The field 'publishFormat' has been assigned the invalid value " + this.publishFormat);
        }
    }
}
