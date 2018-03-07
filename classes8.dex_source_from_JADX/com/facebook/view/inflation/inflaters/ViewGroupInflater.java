package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: location_opt_in_place_save_banner_xout_tapped */
abstract class ViewGroupInflater extends ViewInflater {
    public ViewGroupInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    public View mo625a(Node node, ViewGroup viewGroup, InflaterFactory inflaterFactory, Context context) {
        ViewGroup viewGroup2 = (ViewGroup) super.mo625a(node, viewGroup, inflaterFactory, context);
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == (short) 1) {
                viewGroup2.addView(inflaterFactory.m11518a(item.getNodeName()).mo625a(item, viewGroup2, inflaterFactory, context));
            }
        }
        return viewGroup2;
    }
}
