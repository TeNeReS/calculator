package main.java.arkhipov.calculator;

import javax.xml.bind.*;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(SimpleCalculator.class);

            File file = new File("sampleTest.xml");

            Unmarshaller unmarshaller = jc.createUnmarshaller();

            SimpleCalculator rSimpleCalculator = (SimpleCalculator) unmarshaller.unmarshal(file);

            rSimpleCalculator.calculate();
            rSimpleCalculator.getExpressions().forEach(e -> System.out.println(e.getResult()));

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(rSimpleCalculator, System.out);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
