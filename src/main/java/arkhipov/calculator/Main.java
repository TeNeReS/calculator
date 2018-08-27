package main.java.arkhipov.calculator;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //region Чтение параметров
        if (args.length == 0) {
            System.out.println("Введите путь к файлу с входными данными.");
            return;
        }

        if (args.length > 1) {
            System.out.println("Должен быть один параметр - путь к файлу с входными данными.");
            return;
        }

        String fileName = args[0];

        File file = new File(fileName);
        //endregion

        //region Валидация входного файла
        Source xmlFile = new StreamSource(file);

        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        Schema schema;
        try {
            schema = schemaFactory.newSchema(new File("Calculator.xsd"));
        } catch (SAXException e) {
            System.out.println("Ошибка при чтении схемы.");
            e.printStackTrace();
            return;
        }

        Validator validator = schema.newValidator();

        try {
            validator.validate(xmlFile);
        } catch (SAXException e) {
            System.out.println("Ошибка валидации.");
            e.printStackTrace();
            return;
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла: такого файла или каталога.");
            e.printStackTrace();
            return;
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла.");
            e.printStackTrace();
            return;
        }
        //endregion

        //region Вычисление и формирование выходного файла
        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(SimpleCalculator.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();

            SimpleCalculator rSimpleCalculator = (SimpleCalculator) unmarshaller.unmarshal(file);

            rSimpleCalculator.calculate();

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            String resultFileName = "Result.xml";

            marshaller.marshal(rSimpleCalculator, new File(resultFileName));

            System.out.println("Успех. Результаты вычислений смотрите в файле " +
                    resultFileName +
                    ", находящемся в корневом каталоге калькулятора.");

        } catch (JAXBException e) {
            System.out.println("Ошибка приложения. Попробуйте еще раз.");
            e.printStackTrace();
        }
        //endregion
    }
}
