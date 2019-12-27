package com.yaoren.common.framework.util.str_dispose;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.text.SimpleDateFormat;

public class MyJackson {

    public static ObjectMapper getDefaultObjectMapper() {

        ObjectMapper mapper = new ObjectMapper();

        //设置将对象转换成JSON字符串时候:包含的属性不能为空或"";

        //Include.Include.ALWAYS 默认

        //Include.NON_DEFAULT 属性为默认值不序列化

        //Include.NON_EMPTY 属性为空（""）  或者为 NULL 都不序列化

        //Include.NON_NULL 属性为NULL 不序列化
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);

        //  是否强制让非数组模式的json字符串与java集合类型相匹配,，默认false
        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        //设置将MAP转换为JSON时候只转换值不等于NULL的
        mapper.configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, false);

        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-ddHH:mm:ss"));

//     mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);

        //设置有属性不能映射成PO时不报错
        mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);

//     mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);  上一条也可以如此设置；

        return mapper;
    }
}
