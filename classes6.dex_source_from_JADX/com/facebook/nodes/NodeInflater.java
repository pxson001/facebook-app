package com.facebook.nodes;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup.LayoutParams;
import com.facebook.R;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: thread_tile_view */
public class NodeInflater {
    private static final String f3124a = NodeInflater.class.getSimpleName();
    private static final NodeInflater f3125b = new NodeInflater();
    private static final Class<?>[] f3126f = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    private static final HashMap<String, Constructor<? extends Node>> f3127g = new HashMap();
    private static final HashSet<String> f3128h = new HashSet();
    public Context f3129c;
    public ViewInflater f3130d;
    private final Object[] f3131e = new Object[]{null, null, Integer.valueOf(0), Integer.valueOf(0)};

    public static NodeInflater m4168a(Context context) {
        f3125b.f3129c = context;
        return f3125b;
    }

    private Context m4162a() {
        return this.f3129c;
    }

    public final Node m4172a(int i) {
        return m4163a(i, null, false);
    }

    private Node m4163a(int i, NodeGroup nodeGroup, boolean z) {
        XmlResourceParser layout = m4162a().getResources().getLayout(i);
        try {
            Node a = m4164a(layout, nodeGroup, z);
            return a;
        } finally {
            layout.close();
            this.f3129c = null;
            this.f3130d = null;
            this.f3131e[0] = null;
            this.f3131e[1] = null;
        }
    }

    private Node m4164a(XmlResourceParser xmlResourceParser, NodeGroup nodeGroup, boolean z) {
        InflateException inflateException;
        synchronized (this.f3131e) {
            int next;
            Context context = (Context) this.f3131e[0];
            this.f3131e[0] = this.f3129c;
            do {
                try {
                    next = xmlResourceParser.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Throwable e) {
                    inflateException = new InflateException(e.getMessage());
                    inflateException.initCause(e);
                    throw inflateException;
                } catch (Throwable e2) {
                    inflateException = new InflateException(xmlResourceParser.getPositionDescription() + ": " + e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (Throwable th) {
                    this.f3131e[0] = context;
                    this.f3131e[1] = null;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlResourceParser.getPositionDescription() + ": No start tag found!");
            }
            String name = xmlResourceParser.getName();
            if (!"merge".equals(name)) {
                LayoutParams a;
                Node a2 = m4165a((Node) nodeGroup, name, (AttributeSet) xmlResourceParser);
                if (nodeGroup != null) {
                    a = nodeGroup.mo183a(this.f3129c, (AttributeSet) xmlResourceParser);
                } else {
                    a = new LayoutParams(this.f3129c, xmlResourceParser);
                }
                if (!z) {
                    a2.mo205a(a);
                }
                m4169a(xmlResourceParser, a2, xmlResourceParser, true);
                if (nodeGroup != null && z) {
                    nodeGroup.mo191a(a2, a);
                }
                if (nodeGroup == null || !z) {
                    Node node = a2;
                }
            } else if (nodeGroup == null || !z) {
                throw new InflateException("<merge /> can be used only with a valid NodeGroup root and attachToRoot=true");
            } else {
                m4169a(xmlResourceParser, nodeGroup, xmlResourceParser, false);
            }
            this.f3131e[0] = context;
            this.f3131e[1] = null;
        }
        return nodeGroup;
    }

    private final Node m4166a(String str, AttributeSet attributeSet) {
        ViewInflater viewInflater;
        if (this.f3130d == null || this.f3130d.getContext() != this.f3129c) {
            this.f3130d = new ViewInflater(this.f3129c);
            viewInflater = this.f3130d;
        } else {
            viewInflater = this.f3130d;
        }
        return new ViewNode(viewInflater.m4228a(str, this.f3129c, attributeSet));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.nodes.Node m4167a(java.lang.String r7, java.lang.String r8, android.util.AttributeSet r9) {
        /*
        r6 = this;
        r0 = f3127g;
        r0 = r0.get(r7);
        r0 = (java.lang.reflect.Constructor) r0;
        r1 = 0;
        if (r0 != 0) goto L_0x004c;
    L_0x000b:
        r0 = f3128h;	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x00d1 }
        r0 = r0.contains(r7);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x00d1 }
        if (r0 == 0) goto L_0x0018;
    L_0x0013:
        r0 = r6.m4166a(r7, r9);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x00d1 }
    L_0x0017:
        return r0;
    L_0x0018:
        if (r8 == 0) goto L_0x0058;
    L_0x001a:
        r0 = new java.lang.StringBuilder;	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x00d1 }
        r0.<init>();	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x00d1 }
        r0 = r0.append(r8);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x00d1 }
        r0 = r0.append(r7);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x00d1 }
        r0 = r0.toString();	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x00d1 }
    L_0x002b:
        r2 = r6.f3129c;	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x00d1 }
        r2 = r2.getClassLoader();	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x00d1 }
        r1 = r2.loadClass(r0);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x00d1 }
        r2 = com.facebook.nodes.Node.class;
        r2 = r2.isAssignableFrom(r1);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        if (r2 == 0) goto L_0x005a;
    L_0x003d:
        r0 = f3126f;	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        r0 = r1.getConstructor(r0);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        r2 = 1;
        r0.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        r2 = f3127g;	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        r2.put(r7, r0);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
    L_0x004c:
        r2 = r6.f3131e;	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        r3 = 1;
        r2[r3] = r9;	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        r0 = r0.newInstance(r2);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        r0 = (com.facebook.nodes.Node) r0;	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        goto L_0x0017;
    L_0x0058:
        r0 = r7;
        goto L_0x002b;
    L_0x005a:
        r2 = android.view.View.class;
        r2 = r2.isAssignableFrom(r1);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        if (r2 == 0) goto L_0x00a4;
    L_0x0062:
        r0 = r6.m4166a(r7, r9);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        r2 = f3128h;	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        r2.add(r7);	 Catch:{ NoSuchMethodException -> 0x006c, ClassNotFoundException -> 0x00c5, Exception -> 0x0102 }
        goto L_0x0017;
    L_0x006c:
        r0 = move-exception;
        r1 = new android.view.InflateException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r9.getPositionDescription();
        r2 = r2.append(r3);
        r3 = ": Error inflating class ";
        r2 = r2.append(r3);
        if (r8 == 0) goto L_0x0095;
    L_0x0084:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3 = r3.append(r8);
        r3 = r3.append(r7);
        r7 = r3.toString();
    L_0x0095:
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r1.initCause(r0);
        throw r1;
    L_0x00a4:
        r2 = new android.view.InflateException;	 Catch:{  }
        r3 = new java.lang.StringBuilder;	 Catch:{  }
        r3.<init>();	 Catch:{  }
        r4 = r9.getPositionDescription();	 Catch:{  }
        r3 = r3.append(r4);	 Catch:{  }
        r4 = ": Class is not a Node or a View ";
        r3 = r3.append(r4);	 Catch:{  }
        r0 = r3.append(r0);	 Catch:{  }
        r0 = r0.toString();	 Catch:{  }
        r2.<init>(r0);	 Catch:{  }
        throw r2;	 Catch:{  }
    L_0x00c5:
        r0 = move-exception;
        r0 = r6.m4166a(r7, r9);
        r1 = f3128h;
        r1.add(r7);
        goto L_0x0017;
    L_0x00d1:
        r0 = move-exception;
        r5 = r0;
        r0 = r1;
        r1 = r5;
    L_0x00d5:
        r2 = new android.view.InflateException;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r9.getPositionDescription();
        r3 = r3.append(r4);
        r4 = ": Error inflating class ";
        r3 = r3.append(r4);
        if (r0 != 0) goto L_0x00fd;
    L_0x00ec:
        r0 = "<unknown>";
    L_0x00ee:
        r0 = r3.append(r0);
        r0 = r0.toString();
        r2.<init>(r0);
        r2.initCause(r1);
        throw r2;
    L_0x00fd:
        r0 = r0.getName();
        goto L_0x00ee;
    L_0x0102:
        r0 = move-exception;
        r5 = r0;
        r0 = r1;
        r1 = r5;
        goto L_0x00d5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.nodes.NodeInflater.a(java.lang.String, java.lang.String, android.util.AttributeSet):com.facebook.nodes.Node");
    }

    private Node m4171b(String str, AttributeSet attributeSet) {
        return m4167a(str, "com.facebook.nodes.", attributeSet);
    }

    private Node m4165a(Node node, String str, AttributeSet attributeSet) {
        InflateException inflateException;
        if (str.equals("node")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object obj = this.f3131e[0];
            this.f3131e[0] = this.f3129c;
            try {
                Node b;
                if (-1 == str.indexOf(46)) {
                    b = m4171b(str, attributeSet);
                } else {
                    b = m4167a(str, null, attributeSet);
                }
                return b;
            } finally {
                this.f3131e[0] = obj;
            }
        } catch (InflateException e) {
            throw e;
        } catch (Throwable e2) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Throwable e22) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e22);
            throw inflateException;
        }
    }

    private void m4169a(XmlResourceParser xmlResourceParser, Node node, AttributeSet attributeSet, boolean z) {
        int depth = xmlResourceParser.getDepth();
        while (true) {
            int next = xmlResourceParser.next();
            if ((next != 3 || xmlResourceParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = xmlResourceParser.getName();
                    if ("include".equals(name)) {
                        if (xmlResourceParser.getDepth() == 0) {
                            throw new InflateException("<include /> cannot be the root element");
                        }
                        m4170a((XmlPullParser) xmlResourceParser, node, attributeSet);
                    } else if ("merge".equals(name)) {
                        throw new InflateException("<merge /> must be the root element");
                    } else {
                        Node a = m4165a(node, name, attributeSet);
                        NodeGroup nodeGroup = (NodeGroup) node;
                        LayoutParams a2 = nodeGroup.mo183a(this.f3129c, attributeSet);
                        m4169a(xmlResourceParser, a, attributeSet, true);
                        nodeGroup.mo191a(a, a2);
                    }
                }
            }
        }
        if (!z) {
        }
    }

    private void m4170a(XmlPullParser xmlPullParser, Node node, AttributeSet attributeSet) {
        LayoutParams a;
        if (node instanceof NodeGroup) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue(null, "layout", 0);
            if (attributeResourceValue == 0) {
                String attributeValue = attributeSet.getAttributeValue(null, "layout");
                if (attributeValue == null) {
                    throw new InflateException("You must specifiy a layout in the include tag: <include layout=\"@layout/layoutID\" />");
                }
                throw new InflateException("You must specifiy a valid layout reference. The layout ID " + attributeValue + " is not valid.");
            }
            XmlResourceParser layout = m4162a().getResources().getLayout(attributeResourceValue);
            try {
                int next;
                AttributeSet asAttributeSet = Xml.asAttributeSet(layout);
                do {
                    next = layout.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new InflateException(layout.getPositionDescription() + ": No start tag found!");
                }
                String name = layout.getName();
                if ("merge".equals(name)) {
                    m4169a(layout, node, asAttributeSet, false);
                } else {
                    Node a2 = m4165a(node, name, asAttributeSet);
                    NodeGroup nodeGroup = (NodeGroup) node;
                    try {
                        a = nodeGroup.mo183a(this.f3129c, attributeSet);
                        if (a != null) {
                            a2.mo205a(a);
                        }
                    } catch (RuntimeException e) {
                        a = nodeGroup.mo183a(this.f3129c, asAttributeSet);
                        if (a != null) {
                            a2.mo205a(a);
                        }
                    }
                    m4169a(layout, a2, asAttributeSet, true);
                    TypedArray obtainStyledAttributes = this.f3129c.obtainStyledAttributes(attributeSet, R.styleable.Node, 0, 0);
                    int resourceId = obtainStyledAttributes.getResourceId(0, -1);
                    int i = obtainStyledAttributes.getInt(7, -1);
                    obtainStyledAttributes.recycle();
                    if (resourceId != -1) {
                        a2.m4094d(resourceId);
                    }
                    switch (i) {
                        case 0:
                            a2.m4096e(0);
                            break;
                        case 1:
                            a2.m4096e(4);
                            break;
                        case 2:
                            a2.m4096e(8);
                            break;
                    }
                    nodeGroup.mo190a(a2);
                }
                layout.close();
                attributeResourceValue = xmlPullParser.getDepth();
                int next2;
                do {
                    next2 = xmlPullParser.next();
                    if (next2 == 3 && xmlPullParser.getDepth() <= attributeResourceValue) {
                        return;
                    }
                } while (next2 != 1);
            } catch (Throwable th) {
                layout.close();
            }
        } else {
            throw new InflateException("<include /> can only be used inside of a ViewGroup");
        }
    }
}
