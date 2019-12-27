package com.yaoren.common.framework.util;

import org.apache.log4j.Logger;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

import java.io.*;
import java.util.Properties;

/**
 * 
 * @ClassName: PropertiesUtil
 * @Description: 资源文件处理工具类
 * @author harrin
 * @date 2016-8-6
 * 
 */
public class PropertiesUtil
{

    private static final Logger logger = Logger.getLogger(PropertiesUtil.class);

    private static final String DEFAULT_ENCODING = "UTF-8";

    private static PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();

    private static ResourceLoader resourceLoader = new DefaultResourceLoader();

    /**
     * 
     * @Title: loadProperties
     * @Description: 加载资源文件
     * @param @param resourcesPaths
     * @param @return
     * @return Properties
     * @throws
     */
    public static Properties loadProperties(String... resourcesPaths)
    {
        Properties props = new Properties();

        for (String location : resourcesPaths)
        {
            InputStream is = null;

            try
            {
                Resource resource = resourceLoader.getResource(location);
                is = resource.getInputStream();
                propertiesPersister.load(props, new InputStreamReader(is, DEFAULT_ENCODING));
            } catch (IOException e)
            {
                logger.error("Could not load properties from classpath:" + location + ": "
                        + e.getMessage(), e);
            } finally
            {
                if (is != null)
                {
                    try
                    {
                        is.close();
                    } catch (IOException e)
                    {
                        logger.error(e);
                    }
                }
            }
        }

        return props;
    }

    /**
     * 
     * @Title: readValue
     * @Description: 获取值
     * @param @param filePath
     * @param @param key
     * @param @return
     * @return String
     * @throws
     */
    public static String readValue(String filePath, String key)
    {
        Properties props = new Properties();
        try
        {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            props.load(in);
            return props.getProperty(key);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 
     * @Title: writeProperties
     * @Description: 写属性值
     * @param @param filePath
     * @param @param parameterName
     * @param @param parameterValue
     * @return void
     * @throws
     */
    public static void writeProperties(String filePath, String parameterName, String parameterValue)
    {
        Properties props = new Properties();
        try
        {
            InputStream fis = new FileInputStream(filePath);
            props.load(fis);
            OutputStream fos = new FileOutputStream(filePath);
            props.setProperty(parameterName, parameterValue);
            props.store(fos, "Update '" + parameterName + "' value");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}