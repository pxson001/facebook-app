package com.facebook.richdocument.view.widget;

import com.facebook.richdocument.model.block.Annotation;
import com.facebook.richdocument.model.block.Annotation.AnnotationSlot;
import com.facebook.richdocument.model.block.Annotation.AnnotationType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* compiled from: open_page_navigation_tap */
public class AnnotationViews implements Iterable<AnnotationView> {
    public final TreeSet<AnnotationView> f7086a = new TreeSet(AnnotationViewComparator.f7085a);

    /* compiled from: open_page_navigation_tap */
    public class AnnotationViewComparator implements Comparator<AnnotationView> {
        public static final AnnotationViewComparator f7085a = new AnnotationViewComparator();

        public int compare(Object obj, Object obj2) {
            AnnotationView annotationView = (AnnotationView) obj2;
            Annotation annotation = ((AnnotationView) obj).getAnnotation();
            Annotation annotation2 = annotationView.getAnnotation();
            Enum enumR = annotation.f5608a;
            Enum enumR2 = annotation2.f5608a;
            if (enumR == enumR2) {
                return annotation.f5612e.compareTo(annotation2.f5612e);
            }
            return enumR.compareTo(enumR2);
        }
    }

    public final List<AnnotationView> m7393a(AnnotationSlot... annotationSlotArr) {
        List arrayList = new ArrayList();
        Iterator it = this.f7086a.iterator();
        while (it.hasNext()) {
            AnnotationView annotationView = (AnnotationView) it.next();
            for (AnnotationSlot annotationSlot : annotationSlotArr) {
                if (annotationView.getAnnotation().f5612e == annotationSlot) {
                    arrayList.add(annotationView);
                    break;
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final AnnotationView m7392a(AnnotationType annotationType) {
        Iterator it = this.f7086a.iterator();
        while (it.hasNext()) {
            AnnotationView annotationView = (AnnotationView) it.next();
            if (annotationView.getAnnotation().f5608a.equals(annotationType)) {
                return annotationView;
            }
        }
        return null;
    }

    public Iterator<AnnotationView> iterator() {
        return this.f7086a.iterator();
    }
}
