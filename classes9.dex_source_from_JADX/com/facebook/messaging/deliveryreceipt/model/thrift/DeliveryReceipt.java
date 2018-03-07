package com.facebook.messaging.deliveryreceipt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.List;

/* compiled from: mark-thread- */
public class DeliveryReceipt implements TBase, Serializable, Cloneable {
    public static boolean f10876a = true;
    private static final TStruct f10877b = new TStruct("DeliveryReceipt");
    private static final TField f10878c = new TField("messageSenderFbid", (byte) 10, (short) 1);
    private static final TField f10879d = new TField("watermarkTimestamp", (byte) 10, (short) 2);
    private static final TField f10880e = new TField("threadFbid", (byte) 10, (short) 3);
    private static final TField f10881f = new TField("messageIds", (byte) 15, (short) 4);
    private static final TField f10882g = new TField("messageRecipientFbid", (byte) 10, (short) 5);
    private static final TField f10883h = new TField("isGroupThread", (byte) 2, (short) 6);
    public final Boolean isGroupThread;
    public final List<String> messageIds;
    public final Long messageRecipientFbid;
    public final Long messageSenderFbid;
    public final Long threadFbid;
    public final Long watermarkTimestamp;

    public DeliveryReceipt(Long l, Long l2, Long l3, List<String> list, Long l4, Boolean bool) {
        this.messageSenderFbid = l;
        this.watermarkTimestamp = l2;
        this.threadFbid = l3;
        this.messageIds = list;
        this.messageRecipientFbid = l4;
        this.isGroupThread = bool;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DeliveryReceipt)) {
            return false;
        }
        DeliveryReceipt deliveryReceipt = (DeliveryReceipt) obj;
        boolean z = false;
        if (deliveryReceipt != null) {
            Object obj2;
            Object obj3 = this.messageSenderFbid != null ? 1 : null;
            if (deliveryReceipt.messageSenderFbid != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageSenderFbid.equals(deliveryReceipt.messageSenderFbid))) {
                if (this.watermarkTimestamp != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (deliveryReceipt.watermarkTimestamp != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.watermarkTimestamp.equals(deliveryReceipt.watermarkTimestamp))) {
                    if (this.threadFbid != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (deliveryReceipt.threadFbid != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.threadFbid.equals(deliveryReceipt.threadFbid))) {
                        if (this.messageIds != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (deliveryReceipt.messageIds != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageIds.equals(deliveryReceipt.messageIds))) {
                            if (this.messageRecipientFbid != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (deliveryReceipt.messageRecipientFbid != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.messageRecipientFbid.equals(deliveryReceipt.messageRecipientFbid))) {
                                if (this.isGroupThread != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (deliveryReceipt.isGroupThread != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.isGroupThread.equals(deliveryReceipt.isGroupThread))) {
                                    z = true;
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

    public final void m11303a(TProtocol tProtocol) {
        tProtocol.a();
        if (this.messageSenderFbid != null) {
            tProtocol.a(f10878c);
            tProtocol.a(this.messageSenderFbid.longValue());
        }
        if (this.watermarkTimestamp != null) {
            tProtocol.a(f10879d);
            tProtocol.a(this.watermarkTimestamp.longValue());
        }
        if (!(this.threadFbid == null || this.threadFbid == null)) {
            tProtocol.a(f10880e);
            tProtocol.a(this.threadFbid.longValue());
        }
        if (!(this.messageIds == null || this.messageIds == null)) {
            tProtocol.a(f10881f);
            tProtocol.a(new TList((byte) 11, this.messageIds.size()));
            for (String a : this.messageIds) {
                tProtocol.a(a);
            }
        }
        if (!(this.messageRecipientFbid == null || this.messageRecipientFbid == null)) {
            tProtocol.a(f10882g);
            tProtocol.a(this.messageRecipientFbid.longValue());
        }
        if (!(this.isGroupThread == null || this.isGroupThread == null)) {
            tProtocol.a(f10883h);
            tProtocol.a(this.isGroupThread.booleanValue());
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m11302a(1, f10876a);
    }

    public final String m11302a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("DeliveryReceipt");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("messageSenderFbid");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.messageSenderFbid == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.messageSenderFbid, i + 1, z));
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("watermarkTimestamp");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.watermarkTimestamp == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.watermarkTimestamp, i + 1, z));
        }
        if (this.threadFbid != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("threadFbid");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.threadFbid == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.threadFbid, i + 1, z));
            }
        }
        if (this.messageIds != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("messageIds");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.messageIds == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.messageIds, i + 1, z));
            }
        }
        if (this.messageRecipientFbid != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("messageRecipientFbid");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.messageRecipientFbid == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.messageRecipientFbid, i + 1, z));
            }
        }
        if (this.isGroupThread != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("isGroupThread");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.isGroupThread == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.isGroupThread, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
