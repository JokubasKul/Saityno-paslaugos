package lt.viko.eif.jkulbokas;

import jakarta.xml.bind.*;
import lt.viko.eif.jkulbokas.POJO_classes.Library;
import org.springframework.stereotype.Service;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

@Service
public class TransformService {

    //Marshall
    public void transformToXml(Library library) throws Exception{

        JAXBContext context = JAXBContext.newInstance(Library.class);
        Marshaller marshaller=context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(library, System.out);
    }
    //Unmarshall
    public Library transformToPOJO(File xmlFile, File xsdFile) throws Exception{

        JAXBContext context = JAXBContext.newInstance(Library.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(xsdFile);
        unmarshaller.setSchema(schema);

        return(Library) unmarshaller.unmarshal(xmlFile);
    }
}

