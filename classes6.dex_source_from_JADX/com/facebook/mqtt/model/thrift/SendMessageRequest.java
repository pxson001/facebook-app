package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TMap;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TProtocolException;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: timeline_prompt */
public class SendMessageRequest implements TBase, Serializable, Cloneable {
    public static boolean f2946a = true;
    private static final TStruct f2947b = new TStruct("SendMessageRequest");
    private static final TField f2948c = new TField("to", (byte) 11, (short) 1);
    private static final TField f2949d = new TField("body", (byte) 11, (short) 2);
    private static final TField f2950e = new TField("offlineThreadingId", (byte) 10, (short) 3);
    private static final TField f2951f = new TField("coordinates", (byte) 12, (short) 4);
    private static final TField f2952g = new TField("clientTags", (byte) 13, (short) 5);
    private static final TField f2953h = new TField("objectAttachment", (byte) 11, (short) 6);
    private static final TField f2954i = new TField("copyMessageId", (byte) 11, (short) 7);
    private static final TField f2955j = new TField("copyAttachmentId", (byte) 11, (short) 8);
    private static final TField f2956k = new TField("mediaAttachmentIds", (byte) 15, (short) 9);
    private static final TField f2957l = new TField("fbTraceMeta", (byte) 11, (short) 10);
    private static final TField f2958m = new TField("imageType", (byte) 8, (short) 11);
    private static final TField f2959n = new TField("senderFbid", (byte) 10, (short) 12);
    private static final TField f2960o = new TField("broadcastRecipients", (byte) 13, (short) 13);
    private static final TField f2961p = new TField("attributionAppId", (byte) 10, (short) 14);
    private static final TField f2962q = new TField("iosBundleId", (byte) 11, (short) 15);
    private static final TField f2963r = new TField("androidKeyHash", (byte) 11, (short) 16);
    private static final TField f2964s = new TField("locationAttachment", (byte) 12, (short) 17);
    private static final TField f2965t = new TField("ttl", (byte) 8, (short) 18);
    private static final TField f2966u = new TField("refCode", (byte) 8, (short) 19);
    public final String androidKeyHash;
    public final Long attributionAppId;
    public final String body;
    public final Map<String, String> broadcastRecipients;
    public final Map<String, String> clientTags;
    public final Coordinates coordinates;
    public final String copyAttachmentId;
    public final String copyMessageId;
    public final String fbTraceMeta;
    public final Integer imageType;
    public final String iosBundleId;
    public final LocationAttachment locationAttachment;
    public final List<String> mediaAttachmentIds;
    public final String objectAttachment;
    public final Long offlineThreadingId;
    public final Integer refCode;
    public final Long senderFbid;
    public final String to;
    public final Integer ttl;

    public SendMessageRequest(String str, String str2, Long l, Coordinates coordinates, Map<String, String> map, String str3, String str4, String str5, List<String> list, String str6, Integer num, Long l2, Map<String, String> map2, Long l3, String str7, String str8, LocationAttachment locationAttachment, Integer num2, Integer num3) {
        this.to = str;
        this.body = str2;
        this.offlineThreadingId = l;
        this.coordinates = coordinates;
        this.clientTags = map;
        this.objectAttachment = str3;
        this.copyMessageId = str4;
        this.copyAttachmentId = str5;
        this.mediaAttachmentIds = list;
        this.fbTraceMeta = str6;
        this.imageType = num;
        this.senderFbid = l2;
        this.broadcastRecipients = map2;
        this.attributionAppId = l3;
        this.iosBundleId = str7;
        this.androidKeyHash = str8;
        this.locationAttachment = locationAttachment;
        this.ttl = num2;
        this.refCode = num3;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SendMessageRequest)) {
            return false;
        }
        SendMessageRequest sendMessageRequest = (SendMessageRequest) obj;
        boolean z = false;
        if (sendMessageRequest != null) {
            Object obj2;
            Object obj3 = this.to != null ? 1 : null;
            if (sendMessageRequest.to != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.to.equals(sendMessageRequest.to))) {
                if (this.body != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (sendMessageRequest.body != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.body.equals(sendMessageRequest.body))) {
                    if (this.offlineThreadingId != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (sendMessageRequest.offlineThreadingId != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.offlineThreadingId.equals(sendMessageRequest.offlineThreadingId))) {
                        if (this.coordinates != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (sendMessageRequest.coordinates != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.coordinates.m3975a(sendMessageRequest.coordinates))) {
                            if (this.clientTags != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (sendMessageRequest.clientTags != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.clientTags.equals(sendMessageRequest.clientTags))) {
                                if (this.objectAttachment != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (sendMessageRequest.objectAttachment != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.objectAttachment.equals(sendMessageRequest.objectAttachment))) {
                                    if (this.copyMessageId != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (sendMessageRequest.copyMessageId != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.copyMessageId.equals(sendMessageRequest.copyMessageId))) {
                                        if (this.copyAttachmentId != null) {
                                            obj3 = 1;
                                        } else {
                                            obj3 = null;
                                        }
                                        if (sendMessageRequest.copyAttachmentId != null) {
                                            obj2 = 1;
                                        } else {
                                            obj2 = null;
                                        }
                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.copyAttachmentId.equals(sendMessageRequest.copyAttachmentId))) {
                                            if (this.mediaAttachmentIds != null) {
                                                obj3 = 1;
                                            } else {
                                                obj3 = null;
                                            }
                                            if (sendMessageRequest.mediaAttachmentIds != null) {
                                                obj2 = 1;
                                            } else {
                                                obj2 = null;
                                            }
                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.mediaAttachmentIds.equals(sendMessageRequest.mediaAttachmentIds))) {
                                                if (this.fbTraceMeta != null) {
                                                    obj3 = 1;
                                                } else {
                                                    obj3 = null;
                                                }
                                                if (sendMessageRequest.fbTraceMeta != null) {
                                                    obj2 = 1;
                                                } else {
                                                    obj2 = null;
                                                }
                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.fbTraceMeta.equals(sendMessageRequest.fbTraceMeta))) {
                                                    if (this.imageType != null) {
                                                        obj3 = 1;
                                                    } else {
                                                        obj3 = null;
                                                    }
                                                    if (sendMessageRequest.imageType != null) {
                                                        obj2 = 1;
                                                    } else {
                                                        obj2 = null;
                                                    }
                                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.imageType.equals(sendMessageRequest.imageType))) {
                                                        if (this.senderFbid != null) {
                                                            obj3 = 1;
                                                        } else {
                                                            obj3 = null;
                                                        }
                                                        if (sendMessageRequest.senderFbid != null) {
                                                            obj2 = 1;
                                                        } else {
                                                            obj2 = null;
                                                        }
                                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.senderFbid.equals(sendMessageRequest.senderFbid))) {
                                                            if (this.broadcastRecipients != null) {
                                                                obj3 = 1;
                                                            } else {
                                                                obj3 = null;
                                                            }
                                                            if (sendMessageRequest.broadcastRecipients != null) {
                                                                obj2 = 1;
                                                            } else {
                                                                obj2 = null;
                                                            }
                                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.broadcastRecipients.equals(sendMessageRequest.broadcastRecipients))) {
                                                                if (this.attributionAppId != null) {
                                                                    obj3 = 1;
                                                                } else {
                                                                    obj3 = null;
                                                                }
                                                                if (sendMessageRequest.attributionAppId != null) {
                                                                    obj2 = 1;
                                                                } else {
                                                                    obj2 = null;
                                                                }
                                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.attributionAppId.equals(sendMessageRequest.attributionAppId))) {
                                                                    if (this.iosBundleId != null) {
                                                                        obj3 = 1;
                                                                    } else {
                                                                        obj3 = null;
                                                                    }
                                                                    if (sendMessageRequest.iosBundleId != null) {
                                                                        obj2 = 1;
                                                                    } else {
                                                                        obj2 = null;
                                                                    }
                                                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.iosBundleId.equals(sendMessageRequest.iosBundleId))) {
                                                                        if (this.androidKeyHash != null) {
                                                                            obj3 = 1;
                                                                        } else {
                                                                            obj3 = null;
                                                                        }
                                                                        if (sendMessageRequest.androidKeyHash != null) {
                                                                            obj2 = 1;
                                                                        } else {
                                                                            obj2 = null;
                                                                        }
                                                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.androidKeyHash.equals(sendMessageRequest.androidKeyHash))) {
                                                                            if (this.locationAttachment != null) {
                                                                                obj3 = 1;
                                                                            } else {
                                                                                obj3 = null;
                                                                            }
                                                                            if (sendMessageRequest.locationAttachment != null) {
                                                                                obj2 = 1;
                                                                            } else {
                                                                                obj2 = null;
                                                                            }
                                                                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.locationAttachment.m3983a(sendMessageRequest.locationAttachment))) {
                                                                                if (this.ttl != null) {
                                                                                    obj3 = 1;
                                                                                } else {
                                                                                    obj3 = null;
                                                                                }
                                                                                if (sendMessageRequest.ttl != null) {
                                                                                    obj2 = 1;
                                                                                } else {
                                                                                    obj2 = null;
                                                                                }
                                                                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.ttl.equals(sendMessageRequest.ttl))) {
                                                                                    if (this.refCode != null) {
                                                                                        obj3 = 1;
                                                                                    } else {
                                                                                        obj3 = null;
                                                                                    }
                                                                                    if (sendMessageRequest.refCode != null) {
                                                                                        obj2 = 1;
                                                                                    } else {
                                                                                        obj2 = null;
                                                                                    }
                                                                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.refCode.equals(sendMessageRequest.refCode))) {
                                                                                        z = true;
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void m4002a(TProtocol tProtocol) {
        m4000a();
        tProtocol.a();
        if (!(this.to == null || this.to == null)) {
            tProtocol.a(f2948c);
            tProtocol.a(this.to);
        }
        if (!(this.body == null || this.body == null)) {
            tProtocol.a(f2949d);
            tProtocol.a(this.body);
        }
        if (!(this.offlineThreadingId == null || this.offlineThreadingId == null)) {
            tProtocol.a(f2950e);
            tProtocol.a(this.offlineThreadingId.longValue());
        }
        if (!(this.coordinates == null || this.coordinates == null)) {
            tProtocol.a(f2951f);
            this.coordinates.m3974a(tProtocol);
        }
        if (!(this.clientTags == null || this.clientTags == null)) {
            tProtocol.a(f2952g);
            tProtocol.a(new TMap((byte) 11, (byte) 11, this.clientTags.size()));
            for (Entry entry : this.clientTags.entrySet()) {
                tProtocol.a((String) entry.getKey());
                tProtocol.a((String) entry.getValue());
            }
        }
        if (!(this.objectAttachment == null || this.objectAttachment == null)) {
            tProtocol.a(f2953h);
            tProtocol.a(this.objectAttachment);
        }
        if (!(this.copyMessageId == null || this.copyMessageId == null)) {
            tProtocol.a(f2954i);
            tProtocol.a(this.copyMessageId);
        }
        if (!(this.copyAttachmentId == null || this.copyAttachmentId == null)) {
            tProtocol.a(f2955j);
            tProtocol.a(this.copyAttachmentId);
        }
        if (!(this.mediaAttachmentIds == null || this.mediaAttachmentIds == null)) {
            tProtocol.a(f2956k);
            tProtocol.a(new TList((byte) 11, this.mediaAttachmentIds.size()));
            for (String a : this.mediaAttachmentIds) {
                tProtocol.a(a);
            }
        }
        if (!(this.fbTraceMeta == null || this.fbTraceMeta == null)) {
            tProtocol.a(f2957l);
            tProtocol.a(this.fbTraceMeta);
        }
        if (!(this.imageType == null || this.imageType == null)) {
            tProtocol.a(f2958m);
            tProtocol.a(this.imageType.intValue());
        }
        if (!(this.senderFbid == null || this.senderFbid == null)) {
            tProtocol.a(f2959n);
            tProtocol.a(this.senderFbid.longValue());
        }
        if (!(this.broadcastRecipients == null || this.broadcastRecipients == null)) {
            tProtocol.a(f2960o);
            tProtocol.a(new TMap((byte) 11, (byte) 11, this.broadcastRecipients.size()));
            for (Entry entry2 : this.broadcastRecipients.entrySet()) {
                tProtocol.a((String) entry2.getKey());
                tProtocol.a((String) entry2.getValue());
            }
        }
        if (!(this.attributionAppId == null || this.attributionAppId == null)) {
            tProtocol.a(f2961p);
            tProtocol.a(this.attributionAppId.longValue());
        }
        if (!(this.iosBundleId == null || this.iosBundleId == null)) {
            tProtocol.a(f2962q);
            tProtocol.a(this.iosBundleId);
        }
        if (!(this.androidKeyHash == null || this.androidKeyHash == null)) {
            tProtocol.a(f2963r);
            tProtocol.a(this.androidKeyHash);
        }
        if (!(this.locationAttachment == null || this.locationAttachment == null)) {
            tProtocol.a(f2964s);
            this.locationAttachment.m3982a(tProtocol);
        }
        if (!(this.ttl == null || this.ttl == null)) {
            tProtocol.a(f2965t);
            tProtocol.a(this.ttl.intValue());
        }
        if (!(this.refCode == null || this.refCode == null)) {
            tProtocol.a(f2966u);
            tProtocol.a(this.refCode.intValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m4001a(1, f2946a);
    }

    public final String m4001a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.m7782a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("SendMessageRequest");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.to != null) {
            stringBuilder.append(a);
            stringBuilder.append("to");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.to == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.to, i + 1, z));
            }
            obj2 = null;
        }
        if (this.body != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("body");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.body == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.body, i + 1, z));
            }
            obj2 = null;
        }
        if (this.offlineThreadingId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("offlineThreadingId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.offlineThreadingId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.offlineThreadingId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.coordinates != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("coordinates");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.coordinates == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.coordinates, i + 1, z));
            }
            obj2 = null;
        }
        if (this.clientTags != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("clientTags");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.clientTags == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.clientTags, i + 1, z));
            }
            obj2 = null;
        }
        if (this.objectAttachment != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("objectAttachment");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.objectAttachment == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.objectAttachment, i + 1, z));
            }
            obj2 = null;
        }
        if (this.copyMessageId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("copyMessageId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.copyMessageId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.copyMessageId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.copyAttachmentId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("copyAttachmentId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.copyAttachmentId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.copyAttachmentId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.mediaAttachmentIds != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("mediaAttachmentIds");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.mediaAttachmentIds == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.mediaAttachmentIds, i + 1, z));
            }
            obj2 = null;
        }
        if (this.fbTraceMeta != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("fbTraceMeta");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.fbTraceMeta == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.fbTraceMeta, i + 1, z));
            }
            obj2 = null;
        }
        if (this.imageType != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("imageType");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.imageType == null) {
                stringBuilder.append("null");
            } else {
                String str3 = (String) ImageType.f2893b.get(this.imageType);
                if (str3 != null) {
                    stringBuilder.append(str3);
                    stringBuilder.append(" (");
                }
                stringBuilder.append(this.imageType);
                if (str3 != null) {
                    stringBuilder.append(")");
                }
            }
            obj2 = null;
        }
        if (this.senderFbid != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("senderFbid");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.senderFbid == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.senderFbid, i + 1, z));
            }
            obj2 = null;
        }
        if (this.broadcastRecipients != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("broadcastRecipients");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.broadcastRecipients == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.broadcastRecipients, i + 1, z));
            }
            obj2 = null;
        }
        if (this.attributionAppId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("attributionAppId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.attributionAppId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.attributionAppId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.iosBundleId != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("iosBundleId");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.iosBundleId == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.iosBundleId, i + 1, z));
            }
            obj2 = null;
        }
        if (this.androidKeyHash != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("androidKeyHash");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.androidKeyHash == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.androidKeyHash, i + 1, z));
            }
            obj2 = null;
        }
        if (this.locationAttachment != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("locationAttachment");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.locationAttachment == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.locationAttachment, i + 1, z));
            }
            obj2 = null;
        }
        if (this.ttl != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("ttl");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.ttl == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.ttl, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.refCode != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("refCode");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.refCode == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.m7783a(this.refCode, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.m7784a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private void m4000a() {
        if (this.imageType != null && !ImageType.f2892a.contains(this.imageType)) {
            throw new TProtocolException("The field 'imageType' has been assigned the invalid value " + this.imageType);
        }
    }
}
