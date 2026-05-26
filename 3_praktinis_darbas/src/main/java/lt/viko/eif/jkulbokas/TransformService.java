package lt.viko.eif.jkulbokas;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.jkulbokas.POJO_classes.Library;
import org.springframework.stereotype.Service;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * Service that transforms the xml data into POJO data
 * that can be inserted into a database
 */
@Service
public class TransformService {

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
