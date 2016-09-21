//package br.net.biosenselab.piscicultura.config;
//
//import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
//import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.ext.ContextResolver;
//import javax.ws.rs.ext.Provider;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
//
///**
// *
// * @author Francisco Adriano da Silva
// */
//@Provider
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//public class SmartTIJsonProvider implements ContextResolver<ObjectMapper> {
//
////    private final ObjectMapper json;
////
////    public SmartTIJsonProvider() throws Exception {
////        this.json = new ObjectMapper()
////                .findAndRegisterModules()
////                .configure(WRITE_DATES_AS_TIMESTAMPS, false)
////                .configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
////
////        Hibernate4Module hibernateModule = new Hibernate4Module();
////        hibernateModule.configure(Hibernate4Module.Feature.FORCE_LAZY_LOADING, false);
////        this.json.registerModule(hibernateModule);
////    }
////
////    @Override
////    public ObjectMapper getContext(Class<?> objectType) {
////        return json;
////    }
//
//}
