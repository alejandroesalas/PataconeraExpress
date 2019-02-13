/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.cecar.pataconeraexpress.Utils;

import com.fasterxml.jackson.jaxrs.base.JsonMappingExceptionMapper;
import com.fasterxml.jackson.jaxrs.base.JsonParseExceptionMapper;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author usuario
 */
@Provider
public class JacksonFeature implements Feature{
//        private final static String JSON_FEATURE = MarshallingFeature.class.getSimpleName();

    @Override
    public boolean configure(FeatureContext fc) {
          fc.register( JsonParseExceptionMapper.class );
            fc.register( JsonMappingExceptionMapper.class );
            fc.register( CustomJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class );
//            fc.register(JacksonJaxbJsonProvider.class);
            //fc.property(PropertiesHelper.getPropertyNameForRuntime(InternalProperties.JSON_FEATURE, config.getRuntimeType()), JSON_FEATURE);
        return true;
    }
    
}
