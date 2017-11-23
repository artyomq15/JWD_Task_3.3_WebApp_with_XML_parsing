package by.tr.parser.entity;

import java.io.Serializable;

public class Tariff implements Serializable{
    private static final long serialVersionUID = -1403581697355333191L;

    private String name;
    private String operatorName;
    private String payroll;
    private CallPrice callPrice;
    private String smsPrice;
    private String internetTraffic;

    private int favoriteNumber;
    private String tariffing;
    private String connectionFee;

    public static class CallPrice implements Serializable{
        private static final long serialVersionUID = -7652380341401428553L;

        private String inNetwork;
        private String outNetwork;
        private String toLandline;

        public String getInNetwork() {
            return inNetwork;
        }

        public void setInNetwork(String inNetwork) {
            this.inNetwork = inNetwork;
        }

        public String getOutNetwork() {
            return outNetwork;
        }

        public void setOutNetwork(String outNetwork) {
            this.outNetwork = outNetwork;
        }

        public String getToLandline() {
            return toLandline;
        }

        public void setToLandline(String toLandline) {
            this.toLandline = toLandline;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (!(object instanceof CallPrice)) return false;

            CallPrice callPrice = (CallPrice) object;

            if (inNetwork != null ? !inNetwork.equals(callPrice.inNetwork) : callPrice.inNetwork != null) return false;
            if (outNetwork != null ? !outNetwork.equals(callPrice.outNetwork) : callPrice.outNetwork != null)
                return false;
            return toLandline != null ? toLandline.equals(callPrice.toLandline) : callPrice.toLandline == null;

        }

        @Override
        public int hashCode() {
            int result = inNetwork != null ? inNetwork.hashCode() : 0;
            result = 31 * result + (outNetwork != null ? outNetwork.hashCode() : 0);
            result = 31 * result + (toLandline != null ? toLandline.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "CallPrice{" +
                    "inNetwork='" + inNetwork + '\'' +
                    ", outNetwork='" + outNetwork + '\'' +
                    ", toLandline='" + toLandline + '\'' +
                    '}';
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getPayroll() {
        return payroll;
    }

    public void setPayroll(String payroll) {
        this.payroll = payroll;
    }

    public CallPrice getCallPrice() {
        return callPrice;
    }

    public void setCallPrice(CallPrice callPrice) {
        this.callPrice = callPrice;
    }

    public String getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(String smsPrice) {
        this.smsPrice = smsPrice;
    }

    public String getInternetTraffic() {
        return internetTraffic;
    }

    public void setInternetTraffic(String internetTraffic) {
        this.internetTraffic = internetTraffic;
    }

    public int getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(int favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public String getTariffing() {
        return tariffing;
    }

    public void setTariffing(String tariffing) {
        this.tariffing = tariffing;
    }

    public String getConnectionFee() {
        return connectionFee;
    }

    public void setConnectionFee(String connectionFee) {
        this.connectionFee = connectionFee;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Tariff)) return false;

        Tariff tariff = (Tariff) object;

        if (favoriteNumber != tariff.favoriteNumber) return false;
        if (name != null ? !name.equals(tariff.name) : tariff.name != null) return false;
        if (operatorName != null ? !operatorName.equals(tariff.operatorName) : tariff.operatorName != null)
            return false;
        if (payroll != null ? !payroll.equals(tariff.payroll) : tariff.payroll != null) return false;
        if (callPrice != null ? !callPrice.equals(tariff.callPrice) : tariff.callPrice != null) return false;
        if (smsPrice != null ? !smsPrice.equals(tariff.smsPrice) : tariff.smsPrice != null) return false;
        if (internetTraffic != null ? !internetTraffic.equals(tariff.internetTraffic) : tariff.internetTraffic != null)
            return false;
        if (tariffing != null ? !tariffing.equals(tariff.tariffing) : tariff.tariffing != null) return false;
        return connectionFee != null ? connectionFee.equals(tariff.connectionFee) : tariff.connectionFee == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (operatorName != null ? operatorName.hashCode() : 0);
        result = 31 * result + (payroll != null ? payroll.hashCode() : 0);
        result = 31 * result + (callPrice != null ? callPrice.hashCode() : 0);
        result = 31 * result + (smsPrice != null ? smsPrice.hashCode() : 0);
        result = 31 * result + (internetTraffic != null ? internetTraffic.hashCode() : 0);
        result = 31 * result + favoriteNumber;
        result = 31 * result + (tariffing != null ? tariffing.hashCode() : 0);
        result = 31 * result + (connectionFee != null ? connectionFee.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "name='" + name + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", payroll='" + payroll + '\'' +
                ", callPrice=" + callPrice +
                ", smsPrice='" + smsPrice + '\'' +
                ", internetTraffic='" + internetTraffic + '\'' +
                ", favoriteNumber=" + favoriteNumber +
                ", tariffing='" + tariffing + '\'' +
                ", connectionFee='" + connectionFee + '\'' +
                '}';
    }
}
