package com.facebook.view.inflation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.InjectorLike;
import com.facebook.view.inflation.inflaters.InflaterFactory;
import java.io.StringReader;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

/* compiled from: location_opt_in_place_save_snackbar_tapped */
public class DynamicLayoutInflater {
    private final InflaterFactory f9789a;

    /* compiled from: location_opt_in_place_save_snackbar_tapped */
    public class InflationException extends Exception {
        public InflationException(Exception exception) {
            super("Exception was thrown while inflating", exception);
        }
    }

    public static DynamicLayoutInflater m11490b(InjectorLike injectorLike) {
        return new DynamicLayoutInflater(InflaterFactory.m11516a(injectorLike));
    }

    @Inject
    public DynamicLayoutInflater(InflaterFactory inflaterFactory) {
        this.f9789a = inflaterFactory;
    }

    public final View m11492a(String str, ViewGroup viewGroup, Context context) {
        try {
            Node b = m11491b(str);
            return this.f9789a.m11518a(b.getNodeName()).mo625a(b, viewGroup, this.f9789a, context);
        } catch (Exception e) {
            throw new InflationException(e);
        } catch (Exception e2) {
            throw new InflationException(e2);
        } catch (Exception e22) {
            throw new InflationException(e22);
        } catch (Exception e222) {
            throw new InflationException(e222);
        }
    }

    @Nullable
    public final Integer m11493a(String str) {
        return (Integer) this.f9789a.f9802g.f9828a.get(str);
    }

    private static Element m11491b(String str) {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        return newInstance.newDocumentBuilder().parse(new InputSource(new StringReader(str))).getDocumentElement();
    }
}
