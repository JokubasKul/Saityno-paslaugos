package lt.viko.eif.jkulbokas.Services;

<<<<<<< HEAD
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lt.viko.eif.jkulbokas.LibraryWrapper;
import lt.viko.eif.jkulbokas.POJO_classes.Library;
=======
>>>>>>> b621a37c92eaac2aa75bd37626c592dce0eaa663
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TransformService {

<<<<<<< HEAD
=======
    public static void main(String[] args) throws Exception {
        TransformService transformService= new TransformService();

        transformService.transformToHTML();
        transformService.transformToPDF();
    }

>>>>>>> b621a37c92eaac2aa75bd37626c592dce0eaa663
    public void transformToHTML() throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer(
                new StreamSource(new File("src/main/java/lt/viko/eif/jkulbokas/xml_files/library-html.xsl"))
        );
        transformer.transform(
<<<<<<< HEAD
                new StreamSource(new File("src/main/java/lt/viko/eif/jkulbokas/Output/library.xml")),
=======
                new StreamSource(new File("src/main/java/lt/viko/eif/jkulbokas/xml_files/library.xml")),
>>>>>>> b621a37c92eaac2aa75bd37626c592dce0eaa663
                new StreamResult(new File("src/main/java/lt/viko/eif/jkulbokas/Output/library.html"))
        );
        System.out.println("HTML file generated..");
    }

    public void transformToPDF() throws Exception {
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

        OutputStream out = new FileOutputStream("src/main/java/lt/viko/eif/jkulbokas/Output/library.pdf");
        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
        TransformerFactory factory = TransformerFactory.newInstance();

        Transformer transformer = factory.newTransformer(
                new StreamSource(new File("src/main/java/lt/viko/eif/jkulbokas/xml_files/library-pdf.xsl"))
        );

        transformer.transform(
<<<<<<< HEAD
                new StreamSource(new File("src/main/java/lt/viko/eif/jkulbokas/Output/library.xml")),
=======
                new StreamSource(new File("src/main/java/lt/viko/eif/jkulbokas/xml_files/library.xml")),
>>>>>>> b621a37c92eaac2aa75bd37626c592dce0eaa663
                new SAXResult(fop.getDefaultHandler())
        );

        out.close();
        System.out.println("PDF file generated..");
    }
<<<<<<< HEAD

    public void transformToXml(LibraryWrapper libraryWrapper) throws Exception{

        JAXBContext context = JAXBContext.newInstance(LibraryWrapper.class);
        Marshaller marshaller=context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        //marshaller.marshal(library, System.out);
        marshaller.marshal(libraryWrapper, new File("src/main/java/lt/viko/eif/jkulbokas/Output/library.xml"));
        System.out.println("Xml file generated..");
    }
=======
>>>>>>> b621a37c92eaac2aa75bd37626c592dce0eaa663
}
