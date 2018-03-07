package com.facebook.view.inflation.inflaters;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.view.inflation.utils.ParseUtils;
import com.facebook.view.inflation.utils.ViewIdentifier;

/* compiled from: location_opt_in_location_permission_req_denied */
public class LinearLayoutInflater extends ViewGroupInflater {

    /* compiled from: location_opt_in_location_permission_req_denied */
    enum Attribute {
        BASELINE_ALIGNED("baselineAligned"),
        BASELINE_ALIGNED_CHILD_INDEX("baselineAlignedChildIndex"),
        DIVIDER("divider"),
        GRAVITY("gravity"),
        MEASURE_WITH_LARGEST_CHILD("measureWithLargestChild"),
        ORIENTATION("orientation"),
        WEIGHT_SUM("weightSum");
        
        private final String mValue;

        private Attribute(String str) {
            this.mValue = str;
        }

        public static Attribute from(String str) {
            Attribute[] values = values();
            for (Attribute attribute : values) {
                if (attribute.mValue.equals(str)) {
                    return attribute;
                }
            }
            throw new IllegalArgumentException("unknown linear layout attribute = " + str);
        }
    }

    public LinearLayoutInflater(ParseUtils parseUtils, ViewIdentifier viewIdentifier) {
        super(parseUtils, viewIdentifier);
    }

    protected final View mo623a(Context context) {
        return new LinearLayout(context);
    }

    protected final void mo624a(View view, String str, String str2, Context context) {
        LinearLayout linearLayout = (LinearLayout) view;
        switch (Attribute.from(str)) {
            case BASELINE_ALIGNED:
                linearLayout.setBaselineAligned(Boolean.valueOf(str2).booleanValue());
                return;
            case BASELINE_ALIGNED_CHILD_INDEX:
                linearLayout.setBaselineAlignedChildIndex(Integer.parseInt(str2));
                return;
            case GRAVITY:
                linearLayout.setGravity(this.f9790a.m11548p(str2));
                return;
            case MEASURE_WITH_LARGEST_CHILD:
                if (VERSION.SDK_INT >= 11) {
                    linearLayout.setMeasureWithLargestChildEnabled(Boolean.valueOf(str2).booleanValue());
                    break;
                }
                throw new IllegalArgumentException("measureWithLargestChild linear layout attribute requires Honeycomb or later");
            case ORIENTATION:
                break;
            case WEIGHT_SUM:
                linearLayout.setWeightSum(ParseUtils.m11531c(str2));
                return;
            default:
                throw new IllegalArgumentException("unknown linear layout attribute = " + str);
        }
        if (str2.equals("horizontal")) {
            linearLayout.setOrientation(0);
        } else if (str2.equals("vertical")) {
            linearLayout.setOrientation(1);
        } else {
            throw new IllegalArgumentException("orientation attribute must be either \"horizontal\" or \"vertical\"");
        }
    }
}
