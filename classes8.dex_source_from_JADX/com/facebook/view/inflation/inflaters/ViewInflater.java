package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* compiled from: location_opt_in_place_save_intro_not_now_tapped */
public abstract class ViewInflater {
    protected final ParseUtils f9790a;
    protected final ViewIdentifier f9791b;

    /* compiled from: location_opt_in_place_save_intro_not_now_tapped */
    enum LayoutParam {
        WIDTH("width"),
        HEIGHT("height");
        
        private final String mValue;

        private LayoutParam(String str) {
            this.mValue = str;
        }

        public static LayoutParam from(String str) {
            LayoutParam[] values = values();
            for (LayoutParam layoutParam : values) {
                if (layoutParam.mValue.equals(str)) {
                    return layoutParam;
                }
            }
            return null;
        }
    }

    /* compiled from: location_opt_in_place_save_intro_not_now_tapped */
    enum LinearLayoutParam {
        GRAVITY("gravity"),
        WEIGHT("weight");
        
        private final String mValue;

        private LinearLayoutParam(String str) {
            this.mValue = str;
        }

        public static LinearLayoutParam from(String str) {
            LinearLayoutParam[] values = values();
            for (LinearLayoutParam linearLayoutParam : values) {
                if (linearLayoutParam.mValue.equals(str)) {
                    return linearLayoutParam;
                }
            }
            return null;
        }
    }

    /* compiled from: location_opt_in_place_save_intro_not_now_tapped */
    enum MarginLayoutParam {
        MARGIN_TOP("marginTop"),
        MARGIN_RIGHT("marginRight"),
        MARGIN_BOTTOM("marginBottom"),
        MARGIN_LEFT("marginLeft");
        
        private final String mValue;

        private MarginLayoutParam(String str) {
            this.mValue = str;
        }

        public static MarginLayoutParam from(String str) {
            MarginLayoutParam[] values = values();
            for (MarginLayoutParam marginLayoutParam : values) {
                if (marginLayoutParam.mValue.equals(str)) {
                    return marginLayoutParam;
                }
            }
            return null;
        }
    }

    /* compiled from: location_opt_in_place_save_intro_not_now_tapped */
    enum RelativeLayoutParam {
        BELOW("below"),
        TO_LEFT_OF("toLeftOf"),
        ALIGN_PARENT_RIGHT("alignParentRight"),
        ALIGN_PARENT_TOP("alignParentTop"),
        ALIGN_PARENT_LEFT("alignParentLeft"),
        ALIGN_PARENT_BOTTOM("alignParentBottom"),
        TO_RIGHT_OF("toRightOf"),
        CENTER_VERTICAL("centerVertical"),
        CENTER_HORIZONTAL("centerHorizontal"),
        ABOVE("above"),
        CENTER_IN_PARENT("centerInParent");
        
        private final String mValue;

        private RelativeLayoutParam(String str) {
            this.mValue = str;
        }

        public static RelativeLayoutParam from(String str) {
            for (RelativeLayoutParam relativeLayoutParam : values()) {
                if (relativeLayoutParam.mValue.equals(str)) {
                    return relativeLayoutParam;
                }
            }
            throw new IllegalArgumentException("unknown relative layout param = " + str);
        }
    }

    /* compiled from: location_opt_in_place_save_intro_not_now_tapped */
    enum ViewAttribute {
        PADDING_TOP("paddingTop"),
        PADDING_RIGHT("paddingRight"),
        PADDING_LEFT("paddingLeft"),
        PADDING_BOTTOM("paddingBottom"),
        PADDING("padding"),
        ID("id"),
        FOCUSABLE("focusable"),
        VISIBILITY("visibility"),
        BACKGROUND("background"),
        MIN_WIDTH("minWidth");
        
        private final String mValue;

        private ViewAttribute(String str) {
            this.mValue = str;
        }

        public static ViewAttribute from(String str) {
            ViewAttribute[] values = values();
            for (ViewAttribute viewAttribute : values) {
                if (viewAttribute.mValue.equals(str)) {
                    return viewAttribute;
                }
            }
            return null;
        }
    }

    protected abstract View mo623a(Context context);

    protected abstract void mo624a(View view, String str, String str2, Context context);

    public ViewInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        this.f9790a = parseUtils;
        this.f9791b = viewIdentifier;
    }

    public View mo625a(Node node, ViewGroup viewGroup, InflaterFactory inflaterFactory, Context context) {
        View a = mo623a(context);
        Map hashMap = new HashMap();
        NamedNodeMap attributes = node.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node item = attributes.item(i);
            if (item.getNodeType() == (short) 2) {
                ParseUtils parseUtils = this.f9790a;
                if (parseUtils.f9826h.contains(item.getNamespaceURI())) {
                    String substring;
                    String localName = item.getLocalName();
                    if (localName.startsWith("layout_")) {
                        substring = localName.substring(7);
                    } else {
                        substring = null;
                    }
                    String str = substring;
                    String nodeValue = item.getNodeValue();
                    if (str != null) {
                        hashMap.put(str, nodeValue);
                    } else if (!m11499b(a, localName, nodeValue, context)) {
                        mo624a(a, localName, nodeValue, context);
                    }
                }
            }
        }
        a.setLayoutParams(m11494a(hashMap, viewGroup));
        return a;
    }

    private LayoutParams m11494a(Map<String, String> map, ViewGroup viewGroup) {
        if (viewGroup instanceof RelativeLayout) {
            return m11500c(map);
        }
        if (viewGroup instanceof FrameLayout) {
            return m11498b(map);
        }
        if (viewGroup instanceof AbsListView) {
            return m11495a((Map) map);
        }
        if (viewGroup instanceof LinearLayout) {
            return m11501d(map);
        }
        throw new IllegalArgumentException("unsupported parent type for creating layout params, type = " + viewGroup.getClass());
    }

    private boolean m11497a(MarginLayoutParams marginLayoutParams, String str, String str2) {
        MarginLayoutParam from = MarginLayoutParam.from(str);
        if (from == null) {
            return false;
        }
        switch (from) {
            case MARGIN_TOP:
                marginLayoutParams.topMargin = this.f9790a.m11540b(str2);
                return true;
            case MARGIN_RIGHT:
                marginLayoutParams.rightMargin = this.f9790a.m11540b(str2);
                return true;
            case MARGIN_LEFT:
                marginLayoutParams.leftMargin = this.f9790a.m11540b(str2);
                return true;
            case MARGIN_BOTTOM:
                marginLayoutParams.bottomMargin = this.f9790a.m11540b(str2);
                return true;
            default:
                return false;
        }
    }

    private boolean m11496a(LayoutParams layoutParams, String str, String str2) {
        LayoutParam from = LayoutParam.from(str);
        if (from == null) {
            return false;
        }
        switch (from) {
            case WIDTH:
                layoutParams.width = this.f9790a.m11542j(str2);
                return true;
            case HEIGHT:
                layoutParams.height = this.f9790a.m11542j(str2);
                return true;
            default:
                return false;
        }
    }

    private AbsListView.LayoutParams m11495a(Map<String, String> map) {
        LayoutParams layoutParams = new AbsListView.LayoutParams(0, 0);
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (!m11496a(layoutParams, str, (String) entry.getValue())) {
                throw new IllegalStateException("unhandled relative layout param = " + str);
            }
        }
        return layoutParams;
    }

    private MarginLayoutParams m11498b(Map<String, String> map) {
        MarginLayoutParams marginLayoutParams = new MarginLayoutParams(0, 0);
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (!m11496a((LayoutParams) marginLayoutParams, str, str2) && !m11497a(marginLayoutParams, str, str2)) {
                throw new IllegalStateException("unhandled relative layout param = " + str);
            }
        }
        return marginLayoutParams;
    }

    private MarginLayoutParams m11500c(Map<String, String> map) {
        MarginLayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (!(m11496a((LayoutParams) layoutParams, str, str2) || m11497a(layoutParams, str, str2))) {
                switch (RelativeLayoutParam.from(str)) {
                    case ABOVE:
                        layoutParams.addRule(2, this.f9791b.m11549b(ParseUtils.m11533e(str2)));
                        break;
                    case BELOW:
                        layoutParams.addRule(3, this.f9791b.m11549b(ParseUtils.m11533e(str2)));
                        break;
                    case TO_LEFT_OF:
                        layoutParams.addRule(0, this.f9791b.m11549b(ParseUtils.m11533e(str2)));
                        break;
                    case TO_RIGHT_OF:
                        layoutParams.addRule(1, this.f9791b.m11549b(ParseUtils.m11533e(str2)));
                        break;
                    case CENTER_VERTICAL:
                        layoutParams.addRule(15);
                        break;
                    case CENTER_HORIZONTAL:
                        layoutParams.addRule(14);
                        break;
                    case ALIGN_PARENT_RIGHT:
                        if (!Boolean.valueOf(str2).booleanValue()) {
                            break;
                        }
                        layoutParams.addRule(11);
                        break;
                    case ALIGN_PARENT_TOP:
                        if (!Boolean.valueOf(str2).booleanValue()) {
                            break;
                        }
                        layoutParams.addRule(10);
                        break;
                    case ALIGN_PARENT_LEFT:
                        if (!Boolean.valueOf(str2).booleanValue()) {
                            break;
                        }
                        layoutParams.addRule(9);
                        break;
                    case ALIGN_PARENT_BOTTOM:
                        if (!Boolean.valueOf(str2).booleanValue()) {
                            break;
                        }
                        layoutParams.addRule(12);
                        break;
                    case CENTER_IN_PARENT:
                        if (!Boolean.valueOf(str2).booleanValue()) {
                            break;
                        }
                        layoutParams.addRule(13);
                        break;
                    default:
                        throw new IllegalStateException("unhandled relative layout param = " + str);
                }
            }
        }
        return layoutParams;
    }

    private LinearLayout.LayoutParams m11501d(Map<String, String> map) {
        MarginLayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (!(m11496a((LayoutParams) layoutParams, str, str2) || m11497a(layoutParams, str, str2))) {
                switch (LinearLayoutParam.from(str)) {
                    case GRAVITY:
                        layoutParams.gravity = this.f9790a.m11548p(str2);
                        break;
                    case WEIGHT:
                        layoutParams.weight = ParseUtils.m11531c(str2);
                        break;
                    default:
                        throw new IllegalStateException("unhandled linear layout param = " + str);
                }
            }
        }
        return layoutParams;
    }

    private boolean m11499b(View view, String str, String str2, Context context) {
        ViewAttribute from = ViewAttribute.from(str);
        if (from == null) {
            return false;
        }
        switch (from) {
            case PADDING_TOP:
                view.setPadding(view.getPaddingLeft(), this.f9790a.m11540b(str2), view.getPaddingRight(), view.getPaddingBottom());
                return true;
            case PADDING_RIGHT:
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), this.f9790a.m11540b(str2), view.getPaddingBottom());
                return true;
            case PADDING_LEFT:
                view.setPadding(this.f9790a.m11540b(str2), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
                return true;
            case PADDING_BOTTOM:
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), this.f9790a.m11540b(str2));
                return true;
            case PADDING:
                int b = this.f9790a.m11540b(str2);
                view.setPadding(b, b, b, b);
                return true;
            case ID:
                int intValue;
                ViewIdentifier viewIdentifier = this.f9791b;
                String d = ParseUtils.m11532d(str2);
                Integer num = (Integer) viewIdentifier.f9828a.get(d);
                if (num != null) {
                    intValue = num.intValue();
                } else {
                    intValue = viewIdentifier.f9829b;
                    viewIdentifier.f9829b = intValue + 1;
                    viewIdentifier.f9828a.put(d, Integer.valueOf(intValue));
                }
                view.setId(intValue);
                return true;
            case FOCUSABLE:
                view.setFocusable(Boolean.valueOf(str2).booleanValue());
                return true;
            case VISIBILITY:
                view.setVisibility(this.f9790a.m11547o(str2));
                return true;
            case BACKGROUND:
                if (ParseUtils.m11537r(str2)) {
                    Drawable colorDrawable = new ColorDrawable(Color.parseColor(str2));
                    if (VERSION.SDK_INT >= 16) {
                        view.setBackground(colorDrawable);
                    } else {
                        view.setBackgroundDrawable(colorDrawable);
                    }
                } else if (ParseUtils.m11539t(str2)) {
                    view.setBackgroundResource(context.getResources().getIdentifier(this.f9790a.m11541g(str2), "color", context.getPackageName()));
                } else if (ParseUtils.m11538s(str2)) {
                    view.setBackgroundResource(context.getResources().getIdentifier(ParseUtils.m11536i(str2), null, null));
                } else {
                    view.setBackgroundResource(context.getResources().getIdentifier(ParseUtils.m11534f(str2), "drawable", context.getPackageName()));
                }
                return true;
            case MIN_WIDTH:
                view.setMinimumWidth(this.f9790a.m11540b(str2));
                return true;
            default:
                return false;
        }
    }
}
