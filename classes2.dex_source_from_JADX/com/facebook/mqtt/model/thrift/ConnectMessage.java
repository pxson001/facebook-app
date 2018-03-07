package com.facebook.mqtt.model.thrift;

import com.facebook.thrift.TBase;
import com.facebook.thrift.TBaseHelper;
import com.facebook.thrift.protocol.TField;
import com.facebook.thrift.protocol.TList;
import com.facebook.thrift.protocol.TProtocol;
import com.facebook.thrift.protocol.TStruct;
import java.io.Serializable;
import java.util.List;

/* compiled from: fgl_app_background */
public class ConnectMessage implements TBase, Serializable, Cloneable {
    public static boolean f23749a = true;
    private static final TStruct f23750b = new TStruct("ConnectMessage");
    private static final TField f23751c = new TField("clientIdentifier", (byte) 11, (short) 1);
    private static final TField f23752d = new TField("willTopic", (byte) 11, (short) 2);
    private static final TField f23753e = new TField("willMessage", (byte) 11, (short) 3);
    private static final TField f23754f = new TField("clientInfo", (byte) 12, (short) 4);
    private static final TField f23755g = new TField("password", (byte) 11, (short) 5);
    private static final TField f23756h = new TField("getDiffsRequests", (byte) 15, (short) 6);
    private static final TField f23757i = new TField("proxygenInfo", (byte) 15, (short) 7);
    private static final TField f23758j = new TField("combinedPublishes", (byte) 15, (short) 8);
    public final String clientIdentifier;
    public final ClientInfo clientInfo;
    public final List<ConnPublishMessage> combinedPublishes;
    public final List<byte[]> getDiffsRequests;
    public final String password;
    public final List<ProxygenInfo> proxygenInfo;
    public final String willMessage;
    public final String willTopic;

    public ConnectMessage(String str, String str2, String str3, ClientInfo clientInfo, String str4, List<byte[]> list, List<ProxygenInfo> list2, List<ConnPublishMessage> list3) {
        this.clientIdentifier = str;
        this.willTopic = str2;
        this.willMessage = str3;
        this.clientInfo = clientInfo;
        this.password = str4;
        this.getDiffsRequests = list;
        this.proxygenInfo = list2;
        this.combinedPublishes = list3;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ConnectMessage)) {
            return false;
        }
        ConnectMessage connectMessage = (ConnectMessage) obj;
        boolean z = false;
        if (connectMessage != null) {
            Object obj2;
            Object obj3 = this.clientIdentifier != null ? 1 : null;
            if (connectMessage.clientIdentifier != null) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.clientIdentifier.equals(connectMessage.clientIdentifier))) {
                if (this.willTopic != null) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (connectMessage.willTopic != null) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.willTopic.equals(connectMessage.willTopic))) {
                    if (this.willMessage != null) {
                        obj3 = 1;
                    } else {
                        obj3 = null;
                    }
                    if (connectMessage.willMessage != null) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.willMessage.equals(connectMessage.willMessage))) {
                        if (this.clientInfo != null) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (connectMessage.clientInfo != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.clientInfo.m32192a(connectMessage.clientInfo))) {
                            if (this.password != null) {
                                obj3 = 1;
                            } else {
                                obj3 = null;
                            }
                            if (connectMessage.password != null) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.password.equals(connectMessage.password))) {
                                if (this.getDiffsRequests != null) {
                                    obj3 = 1;
                                } else {
                                    obj3 = null;
                                }
                                if (connectMessage.getDiffsRequests != null) {
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.getDiffsRequests.equals(connectMessage.getDiffsRequests))) {
                                    if (this.proxygenInfo != null) {
                                        obj3 = 1;
                                    } else {
                                        obj3 = null;
                                    }
                                    if (connectMessage.proxygenInfo != null) {
                                        obj2 = 1;
                                    } else {
                                        obj2 = null;
                                    }
                                    if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.proxygenInfo.equals(connectMessage.proxygenInfo))) {
                                        if (this.combinedPublishes != null) {
                                            obj3 = 1;
                                        } else {
                                            obj3 = null;
                                        }
                                        if (connectMessage.combinedPublishes != null) {
                                            obj2 = 1;
                                        } else {
                                            obj2 = null;
                                        }
                                        if ((obj3 == null && r5 == null) || !(obj3 == null || r5 == null || !this.combinedPublishes.equals(connectMessage.combinedPublishes))) {
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
        return z;
    }

    public int hashCode() {
        return 0;
    }

    public final void mo3464a(TProtocol tProtocol) {
        tProtocol.mo3468a();
        if (this.clientIdentifier != null) {
            tProtocol.mo3472a(f23751c);
            tProtocol.mo3475a(this.clientIdentifier);
        }
        if (!(this.willTopic == null || this.willTopic == null)) {
            tProtocol.mo3472a(f23752d);
            tProtocol.mo3475a(this.willTopic);
        }
        if (!(this.willMessage == null || this.willMessage == null)) {
            tProtocol.mo3472a(f23753e);
            tProtocol.mo3475a(this.willMessage);
        }
        if (this.clientInfo != null) {
            tProtocol.mo3472a(f23754f);
            this.clientInfo.mo3464a(tProtocol);
        }
        if (!(this.password == null || this.password == null)) {
            tProtocol.mo3472a(f23755g);
            tProtocol.mo3475a(this.password);
        }
        if (!(this.getDiffsRequests == null || this.getDiffsRequests == null)) {
            tProtocol.mo3472a(f23756h);
            tProtocol.mo3473a(new TList((byte) 11, this.getDiffsRequests.size()));
            for (byte[] a : this.getDiffsRequests) {
                tProtocol.mo3478a(a);
            }
        }
        if (!(this.proxygenInfo == null || this.proxygenInfo == null)) {
            tProtocol.mo3472a(f23757i);
            tProtocol.mo3473a(new TList((byte) 12, this.proxygenInfo.size()));
            for (ProxygenInfo a2 : this.proxygenInfo) {
                a2.a(tProtocol);
            }
        }
        if (!(this.combinedPublishes == null || this.combinedPublishes == null)) {
            tProtocol.mo3472a(f23758j);
            tProtocol.mo3473a(new TList((byte) 12, this.combinedPublishes.size()));
            for (ConnPublishMessage a3 : this.combinedPublishes) {
                a3.a(tProtocol);
            }
        }
        tProtocol.mo3480c();
        tProtocol.mo3479b();
    }

    public String toString() {
        return mo3463a(1, f23749a);
    }

    public final String mo3463a(int i, boolean z) {
        String a = z ? TBaseHelper.a(i) : "";
        String str = z ? "\n" : "";
        String str2 = z ? " " : "";
        StringBuilder stringBuilder = new StringBuilder("ConnectMessage");
        stringBuilder.append(str2);
        stringBuilder.append("(");
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append("clientIdentifier");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.clientIdentifier == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.clientIdentifier, i + 1, z));
        }
        if (this.willTopic != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("willTopic");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.willTopic == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.willTopic, i + 1, z));
            }
        }
        if (this.willMessage != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("willMessage");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.willMessage == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.willMessage, i + 1, z));
            }
        }
        stringBuilder.append("," + str);
        stringBuilder.append(a);
        stringBuilder.append("clientInfo");
        stringBuilder.append(str2);
        stringBuilder.append(":").append(str2);
        if (this.clientInfo == null) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append(TBaseHelper.a(this.clientInfo, i + 1, z));
        }
        if (this.password != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("password");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.password == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.password, i + 1, z));
            }
        }
        if (this.getDiffsRequests != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("getDiffsRequests");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.getDiffsRequests == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.getDiffsRequests, i + 1, z));
            }
        }
        if (this.proxygenInfo != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("proxygenInfo");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.proxygenInfo == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.proxygenInfo, i + 1, z));
            }
        }
        if (this.combinedPublishes != null) {
            stringBuilder.append("," + str);
            stringBuilder.append(a);
            stringBuilder.append("combinedPublishes");
            stringBuilder.append(str2);
            stringBuilder.append(":").append(str2);
            if (this.combinedPublishes == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(TBaseHelper.a(this.combinedPublishes, i + 1, z));
            }
        }
        stringBuilder.append(str + TBaseHelper.a(a));
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
