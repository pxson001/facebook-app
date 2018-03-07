package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.List;

/* compiled from: gk_off */
public class ForegroundState implements TBase, Serializable, Cloneable {
    public static boolean f11038a = false;
    private static final TStruct f11039b = new TStruct("ForegroundState");
    private static final TField f11040c = new TField("inForegroundApp", (byte) 2, (short) 1);
    private static final TField f11041d = new TField("inForegroundDevice", (byte) 2, (short) 2);
    private static final TField f11042e = new TField("keepAliveTimeout", (byte) 8, (short) 3);
    private static final TField f11043f = new TField("subscribeTopics", (byte) 15, (short) 4);
    private static final TField f11044g = new TField("subscribeGenericTopics", (byte) 15, (short) 5);
    private static final TField f11045h = new TField("unsubscribeTopics", (byte) 15, (short) 6);
    private static final TField f11046i = new TField("unsubscribeGenericTopics", (byte) 15, (short) 7);
    public final Boolean inForegroundApp;
    public final Boolean inForegroundDevice;
    public final Integer keepAliveTimeout;
    public final List<SubscribeGenericTopic> subscribeGenericTopics;
    public final List<Integer> subscribeTopics;
    public final List<String> unsubscribeGenericTopics;
    public final List<Integer> unsubscribeTopics;

    public ForegroundState(Boolean bool, Boolean bool2, Integer num, List<Integer> list, List<SubscribeGenericTopic> list2, List<Integer> list3, List<String> list4) {
        this.inForegroundApp = bool;
        this.inForegroundDevice = bool2;
        this.keepAliveTimeout = num;
        this.subscribeTopics = list;
        this.subscribeGenericTopics = list2;
        this.unsubscribeTopics = list3;
        this.unsubscribeGenericTopics = list4;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ForegroundState)) {
            return false;
        }
        ForegroundState foregroundState = (ForegroundState) obj;
        boolean z = false;
        if (foregroundState != null) {
            Object obj2;
            Object obj3 = this.inForegroundApp != null ? 1 : null;
            if (foregroundState.inForegroundApp != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.inForegroundApp.equals(foregroundState.inForegroundApp))) {
                if (this.inForegroundDevice != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (foregroundState.inForegroundDevice != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.inForegroundDevice.equals(foregroundState.inForegroundDevice))) {
                    if (this.keepAliveTimeout != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (foregroundState.keepAliveTimeout != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.keepAliveTimeout.equals(foregroundState.keepAliveTimeout))) {
                        if (this.subscribeTopics != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (foregroundState.subscribeTopics != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.subscribeTopics.equals(foregroundState.subscribeTopics))) {
                            if (this.subscribeGenericTopics != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (foregroundState.subscribeGenericTopics != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.subscribeGenericTopics.equals(foregroundState.subscribeGenericTopics))) {
                                if (this.unsubscribeTopics != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (foregroundState.unsubscribeTopics != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.unsubscribeTopics.equals(foregroundState.unsubscribeTopics))) {
                                    if (this.unsubscribeGenericTopics != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (foregroundState.unsubscribeGenericTopics != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.unsubscribeGenericTopics.equals(foregroundState.unsubscribeGenericTopics))) {
                                        z = true;
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

    public final void m11483a(TProtocol tProtocol) {
        tProtocol.a();
        if (!(this.inForegroundApp == null || this.inForegroundApp == null)) {
            tProtocol.a(f11040c);
            tProtocol.a(this.inForegroundApp.booleanValue());
        }
        if (!(this.inForegroundDevice == null || this.inForegroundDevice == null)) {
            tProtocol.a(f11041d);
            tProtocol.a(this.inForegroundDevice.booleanValue());
        }
        if (!(this.keepAliveTimeout == null || this.keepAliveTimeout == null)) {
            tProtocol.a(f11042e);
            tProtocol.a(this.keepAliveTimeout.intValue());
        }
        if (!(this.subscribeTopics == null || this.subscribeTopics == null)) {
            tProtocol.a(f11043f);
            tProtocol.a(new TList((byte) 8, this.subscribeTopics.size()));
            for (Integer intValue : this.subscribeTopics) {
                tProtocol.a(intValue.intValue());
            }
        }
        if (!(this.subscribeGenericTopics == null || this.subscribeGenericTopics == null)) {
            tProtocol.a(f11044g);
            tProtocol.a(new TList((byte) 12, this.subscribeGenericTopics.size()));
            for (SubscribeGenericTopic a : this.subscribeGenericTopics) {
                a.a(tProtocol);
            }
        }
        if (!(this.unsubscribeTopics == null || this.unsubscribeTopics == null)) {
            tProtocol.a(f11045h);
            tProtocol.a(new TList((byte) 8, this.unsubscribeTopics.size()));
            for (Integer intValue2 : this.unsubscribeTopics) {
                tProtocol.a(intValue2.intValue());
            }
        }
        if (!(this.unsubscribeGenericTopics == null || this.unsubscribeGenericTopics == null)) {
            tProtocol.a(f11046i);
            tProtocol.a(new TList((byte) 11, this.unsubscribeGenericTopics.size()));
            for (String a2 : this.unsubscribeGenericTopics) {
                tProtocol.a(a2);
            }
        }
        tProtocol.c();
        tProtocol.b();
    }

    public String toString() {
        return m11482a(1, f11038a);
    }

    public final String m11482a(int i, boolean z) {
        Object obj = null;
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("ForegroundState");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        Object obj2 = 1;
        if (this.inForegroundApp != null) {
            stringBuilder.append(a);
            stringBuilder.append("inForegroundApp");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.inForegroundApp == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.inForegroundApp, i + 1, z));
            }
            obj2 = null;
        }
        if (this.inForegroundDevice != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("inForegroundDevice");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.inForegroundDevice == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.inForegroundDevice, i + 1, z));
            }
            obj2 = null;
        }
        if (this.keepAliveTimeout != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("keepAliveTimeout");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.keepAliveTimeout == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.keepAliveTimeout, i + 1, z));
            }
            obj2 = null;
        }
        if (this.subscribeTopics != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("subscribeTopics");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.subscribeTopics == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.subscribeTopics, i + 1, z));
            }
            obj2 = null;
        }
        if (this.subscribeGenericTopics != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("subscribeGenericTopics");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.subscribeGenericTopics == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.subscribeGenericTopics, i + 1, z));
            }
            obj2 = null;
        }
        if (this.unsubscribeTopics != null) {
            if (obj2 == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("unsubscribeTopics");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.unsubscribeTopics == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.unsubscribeTopics, i + 1, z));
            }
        } else {
            obj = obj2;
        }
        if (this.unsubscribeGenericTopics != null) {
            if (obj == null) {
                stringBuilder.append("," + str);
            }
            stringBuilder.append(a);
            stringBuilder.append("unsubscribeGenericTopics");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.unsubscribeGenericTopics == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.unsubscribeGenericTopics, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
