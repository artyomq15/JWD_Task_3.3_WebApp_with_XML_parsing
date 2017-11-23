package by.tr.parser.dao.impl.parse.impl.dom;

import by.tr.parser.dao.impl.parse.constant.FilePath;
import by.tr.parser.dao.impl.parse.util.Transformer;
import by.tr.parser.dao.impl.parse.xml_namespace.TariffAttrName;
import by.tr.parser.dao.impl.parse.xml_namespace.TariffTagName;
import by.tr.parser.entity.Tariff;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class DOMHandler {
    private static final String emptyElement = "";

    private DOMHandler(){}

    public static List<Tariff> doParsing() throws IOException, SAXException {
        DOMParser parser = new DOMParser();
        parser.parse(new InputSource(DOMHandler.class.getResourceAsStream(FilePath.XML_TARIFF_PATH)));

        Document document = parser.getDocument();
        Element root = document.getDocumentElement();
        NodeList tariffNodes = root.getElementsByTagName(TariffTagName.TARIFF.toString().toLowerCase());

        return getTariffList(tariffNodes);
    }

    private static List<Tariff> getTariffList(NodeList tariffNodes){
        List<Tariff> tariffList = new ArrayList<>();

        Tariff tariff = null;
        int size = tariffNodes.getLength();

        for (int i = 0; i<size;i++){
            tariff = new Tariff();

            Element tariffElement = (Element) tariffNodes.item(i);

            setTariff(tariff, tariffElement);

            tariffList.add(tariff);
        }
        return tariffList;
    }

    private static void setTariff(Tariff tariff, Element tariffElement){
        Tariff.CallPrice callPrice = new Tariff.CallPrice();

        tariff.setTariffing(tariffElement.getAttribute(Transformer.getAttrString(TariffAttrName.TARIFFING)));
        tariff.setConnectionFee(tariffElement.getAttribute(Transformer.getAttrString(TariffAttrName.CONNECTION_FEE)));

        String favoriteNumber = tariffElement.getAttribute(Transformer.getAttrString(TariffAttrName.FAVORITE_NUMBER));
        if (!favoriteNumber.equals(emptyElement)){
            tariff.setFavoriteNumber(Integer.parseInt(favoriteNumber));
        }

        tariff.setName(getSingleChild(tariffElement, TariffTagName.NAME).getTextContent().trim());
        tariff.setOperatorName(getSingleChild(tariffElement, TariffTagName.OPERATOR_NAME).getTextContent().trim());
        tariff.setPayroll(getSingleChild(tariffElement, TariffTagName.PAYROLL).getTextContent().trim());

        Element callPriceElement = getSingleChild(tariffElement, TariffTagName.CALL_PRICE);

        callPrice.setInNetwork(getSingleChild(callPriceElement, TariffTagName.IN_NETWORK).getTextContent().trim());
        callPrice.setOutNetwork(getSingleChild(callPriceElement, TariffTagName.OUT_NETWORK).getTextContent().trim());
        callPrice.setToLandline(getSingleChild(callPriceElement, TariffTagName.TO_LANDLINE).getTextContent().trim());

        tariff.setCallPrice(callPrice);

        tariff.setSmsPrice(getSingleChild(tariffElement, TariffTagName.SMS_PRICE).getTextContent().trim());
        tariff.setInternetTraffic(getSingleChild(tariffElement, TariffTagName.INTERNET_TRAFFIC).getTextContent().trim());
    }

    private static Element getSingleChild(Element element, TariffTagName tagName){
        int firstNodeElement = 0;
        NodeList nodeList = element.getElementsByTagName(Transformer.getTagString(tagName));
        return (Element) nodeList.item(firstNodeElement);
    }
}
