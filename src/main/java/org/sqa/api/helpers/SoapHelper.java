package org.sqa.api.helpers;

import org.slf4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

import static java.lang.invoke.MethodHandles.lookup;
import static org.apache.logging.log4j.message.ParameterizedMessage.ERROR_PREFIX;
import static org.slf4j.LoggerFactory.getLogger;

public class SoapHelper {


    static final Logger logger = getLogger(lookup().lookupClass());

    public String marshallEnvelopeObject(Object ob){
        StringWriter sw = new StringWriter();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ob.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty("com.sun.xml.bind.xmlDeclaration", Boolean.FALSE);

            jaxbMarshaller.marshal(ob, sw);
            jaxbMarshaller.marshal(ob, System.out);
        } catch (JAXBException e) {
            logger.info(String.format("%s%s", ERROR_PREFIX, e.getMessage()));
        }
        return sw.toString();
    }

    public <T> T unMarshalingEnvelopeObject(String xml, Class<T> chosenClass){

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(chosenClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xml);
            return chosenClass.cast(jaxbUnmarshaller.unmarshal(reader));
        } catch (JAXBException jaxbException){
            logger.info(String.format("%s%s", ERROR_PREFIX, jaxbException.getMessage()));
        }
        return null;
    }
}
