package com.facebook.multirow.api;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.build.BuildConstants;
import com.google.common.base.Preconditions;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: password_account */
public abstract class ViewType<V extends View> {

    /* compiled from: password_account */
    public class LayoutBasedViewType<V extends View> extends ViewType<V> {
        public final int f23287a;

        public LayoutBasedViewType(int i) {
            this.f23287a = i;
        }

        public final V mo1995a(Context context) {
            int i = this.f23287a;
            if (BuildConstants.i) {
                LayoutParams layoutParams = new LayoutParams(context, ViewType.m15458c(i, context));
                boolean z = layoutParams.height == -2 && layoutParams.width == -1;
                Preconditions.checkState(z, "Feed layouts should use layout_height = WRAP_CONTENT and layout_width = MATCH_PARENT.");
            }
            return LayoutInflater.from(context).inflate(this.f23287a, null);
        }
    }

    public abstract V mo1995a(Context context);

    public static <V extends View> ViewType<V> m15456a(int i) {
        return new LayoutBasedViewType(i);
    }

    public static AttributeSet m15458c(int i, Context context) {
        XmlResourceParser layout = context.getResources().getLayout(i);
        do {
            try {
            } catch (IOException e) {
            } catch (XmlPullParserException e2) {
            }
        } while (m15457a(layout));
        return Xml.asAttributeSet(layout);
        return null;
    }

    private static boolean m15457a(XmlResourceParser xmlResourceParser) {
        int next = xmlResourceParser.next();
        if (next == 2 || next == 1) {
            return false;
        }
        return true;
    }
}
