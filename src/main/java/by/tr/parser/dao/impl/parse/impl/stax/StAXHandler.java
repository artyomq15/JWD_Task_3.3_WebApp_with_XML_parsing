package by.tr.parser.dao.impl.parse.impl.stax;


import by.tr.parser.dao.impl.parse.util.Transformer;
import by.tr.parser.dao.impl.parse.xml_namespace.TariffAttrName;
import by.tr.parser.dao.impl.parse.xml_namespace.TariffTagName;
import by.tr.parser.entity.Tariff;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public final class StAXHandler {
    private StAXHandler() {
    }

    public static List<Tariff> parse(XMLStreamReader reader) throws XMLStreamException {
        List<Tariff> tariffList = new ArrayList<>();
        Tariff tariff = null;
        Tariff.CallPrice callPrice = null;
        String text = null;
        TariffTagName tagName = null;

        while (reader.hasNext()) {
            int type = reader.next();

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    tagName = Transformer.getTagEnum(reader.getLocalName());
                    switch (tagName) {
                        case TARIFF:
                            tariff = new Tariff();
                            tariff.setTariffing(reader.getAttributeValue(null, Transformer.getAttrString(TariffAttrName.TARIFFING)));
                            tariff.setConnectionFee(reader.getAttributeValue(null, Transformer.getAttrString(TariffAttrName.CONNECTION_FEE)));
                            String favoriteNumber = reader.getAttributeValue(null, Transformer.getAttrString(TariffAttrName.FAVORITE_NUMBER));
                            if (favoriteNumber != null) {
                                tariff.setFavoriteNumber(Integer.parseInt(favoriteNumber));
                            }
                            break;
                        case CALL_PRICE:
                            callPrice = new Tariff.CallPrice();
                            break;
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    text = reader.getText().trim();
                    if (text.isEmpty()) {
                        break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    tagName = Transformer.getTagEnum(reader.getLocalName());
                    switch (tagName) {
                        case NAME:
                            tariff.setName(text);
                            break;
                        case OPERATOR_NAME:
                            tariff.setOperatorName(text);
                            break;
                        case PAYROLL:
                            tariff.setPayroll(text);
                            break;
                        case IN_NETWORK:
                            callPrice.setInNetwork(text);
                            break;
                        case OUT_NETWORK:
                            callPrice.setOutNetwork(text);
                            break;
                        case TO_LANDLINE:
                            callPrice.setToLandline(text);
                            break;
                        case CALL_PRICE:
                            tariff.setCallPrice(callPrice);
                            break;
                        case SMS_PRICE:
                            tariff.setSmsPrice(text);
                            break;
                        case INTERNET_TRAFFIC:
                            tariff.setInternetTraffic(text);
                            break;
                        case TARIFF:
                            tariffList.add(tariff);
                            break;
                    }
            }
        }
        return tariffList;
    }
}
