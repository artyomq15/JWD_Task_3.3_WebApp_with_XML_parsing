package by.tr.parser.dao.impl.parse.impl.sax;

import by.tr.parser.dao.impl.parse.util.Transformer;
import by.tr.parser.dao.impl.parse.xml_namespace.TariffTagName;
import by.tr.parser.entity.Tariff;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static by.tr.parser.dao.impl.parse.xml_namespace.TariffAttrName.*;
import static by.tr.parser.dao.impl.parse.xml_namespace.TariffTagName.*;

public class SAXHandler extends DefaultHandler{
    private List<Tariff> tariffList = new ArrayList<>();
    private Tariff tariff;
    private StringBuilder text;
    private Tariff.CallPrice callPrice;

    public List<Tariff> getTariffList(){
        return tariffList;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();

        if (Transformer.getTagEnum(localName).equals(TARIFF)){
            tariff = new Tariff();
            tariff.setTariffing(attributes.getValue(Transformer.getAttrString(TARIFFING)));
            tariff.setConnectionFee(attributes.getValue(Transformer.getAttrString(CONNECTION_FEE)));

            String favoriteNumber = attributes.getValue(Transformer.getAttrString(FAVORITE_NUMBER));
            if (favoriteNumber != null){
                tariff.setFavoriteNumber(Integer.parseInt(favoriteNumber));
            }

        } else if (Transformer.getTagEnum(localName).equals(CALL_PRICE)){
            callPrice = new Tariff.CallPrice();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        TariffTagName tagName = Transformer.getTagEnum(localName);
        switch (tagName){
            case NAME:
                tariff.setName(text.toString());
                break;
            case OPERATOR_NAME:
                tariff.setOperatorName(text.toString());
                break;
            case PAYROLL:
                tariff.setPayroll(text.toString());
                break;
            case IN_NETWORK:
                callPrice.setInNetwork(text.toString());
                break;
            case OUT_NETWORK:
                callPrice.setOutNetwork(text.toString());
                break;
            case TO_LANDLINE:
                callPrice.setToLandline(text.toString());
                break;
            case CALL_PRICE:
                tariff.setCallPrice(callPrice);
                break;
            case SMS_PRICE:
                tariff.setSmsPrice(text.toString());
                break;
            case INTERNET_TRAFFIC:
                tariff.setInternetTraffic(text.toString());
                break;
            case TARIFF:
                tariffList.add(tariff);
                tariff = null;
                break;
        }
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        super.error(e);
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        super.warning(e);
    }
}
