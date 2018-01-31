package com.practise.util;

import com.tc.tsp.dcm.models.v1.EML;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

/**
 * Converter responsible for parsing incoming requests in EML format and converting to domain models.
 */

public class CustReceiverHttpMessageConverter extends AbstractHttpMessageConverter<EML> {

    /**
     * Defines content type header that the converter applies to.
     *
     */
    public CustReceiverHttpMessageConverter() {
        super(new MediaType("application", "x-eML"));

    }

    /**
     * Determines whether or not the request/response is supported by this converter.
     *
     * @param clazz Type of class for the request/response.
     * @return True or false.
     */
    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.getSimpleName().equalsIgnoreCase(EML.class.getSimpleName());
    }

    /**
     * Performs the conversion of an incoming EML request into a domain model object.
     *
     * @param clazz        Type of the request object.
     * @param inputMessage The incoming HTTP request.
     * @return The request body converted into a {@link EML} object.
     * @throws IOException
     */
    @Override
    protected EML readInternal(Class<? extends EML> clazz, HttpInputMessage inputMessage)
        throws IOException {

        JAXBContext context;
        Unmarshaller unMarshaller;
        EML requestEml = null;

        try {
            context = JAXBContext.newInstance(EML.class);
            unMarshaller = context.createUnmarshaller();
            requestEml = (EML) unMarshaller.unmarshal(inputMessage.getBody());
        } catch (JAXBException ex) {
            return new EML();
        }

        return requestEml;
    }

    /**
     * This method should never be called as this converter is just for formatting incoming requests.
     **/
    @Override
    protected void writeInternal(EML custRequestEml, HttpOutputMessage outputMessage) throws IOException {
        throw new UnsupportedOperationException("Should not be sending DestinationAssistEvent responses.");
    }
}
