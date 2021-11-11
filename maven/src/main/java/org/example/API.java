package org.example;
import kong.unirest.Unirest;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class API {

    private String date = "";
    private String currencyValue = "";

    public API(String data, String value) throws DataNotFoundException {
        if ((data.isBlank()) || (value.isBlank())) {
            throw new DataNotFoundException();
        }
        this.date = data;
        this.currencyValue = value.toUpperCase();
    }

    public String getDate() {
        return date;
    }

    public String getCurrencyValue() {
        return currencyValue;
    }
    public void getRate() throws ParserConfigurationException, IOException, DataNotFoundException, SAXException {
        String url = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date;
        String data = Unirest.get(url).asString().getBody();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(data)));



//        NodeList webList1 = API.getElementsByTagName("Value");
//        Node value = nList1.item(i);
//        setValue(((Node) value).getTextContent());
//        NodeList webList2 = API.getElementsByTagName("Name");
//        Node name = nList2.item(i);
//        setName(name.getTextContent());


//        return "1 " + name.getTextContent() + " = " + value.getTextContent() + " Российских рубля";
        NodeList webList = doc.getElementsByTagName("Valute");
        for (int i = 0; i < webList.getLength(); i++) {
            Element cur = (Element) webList.item(i);
            if (cur.getElementsByTagName("CharCode").item(0).getTextContent().equals(currencyValue)) {
                String name = cur.getElementsByTagName("Name").item(0).getTextContent();
                String value = cur.getElementsByTagName("Value").item(0).getTextContent();
                System.out.println("1 " + name + " = " + value + " Российских рублей");
                return;
            }
        }


        throw new DataNotFoundException();
    }
}
