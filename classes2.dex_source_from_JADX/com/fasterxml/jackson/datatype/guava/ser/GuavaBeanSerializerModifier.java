package com.fasterxml.jackson.datatype.guava.ser;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.google.common.base.Optional;
import java.util.List;

/* compiled from: springId  */
public class GuavaBeanSerializerModifier extends BeanSerializerModifier {
    public final List<BeanPropertyWriter> mo1159a(List<BeanPropertyWriter> list) {
        for (int i = 0; i < list.size(); i++) {
            BeanPropertyWriter beanPropertyWriter = (BeanPropertyWriter) list.get(i);
            if (Optional.class.isAssignableFrom(beanPropertyWriter.h())) {
                list.set(i, new GuavaOptionalBeanPropertyWriter(beanPropertyWriter));
            }
        }
        return list;
    }
}
