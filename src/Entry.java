public class Entry {

    String date;
    double price;
    double open;
    double high;
    double low;
    double volume;
    double percentChange;

    public Entry(String date, double price, double open, double high, double low, double volume, double percentChange) {
        this.date = date;
        this.price = price;
        this.open = open;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.percentChange = percentChange;
    }

    public String getMonth() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getVolume() {
        return volume;
    }

    public double getPercentChange() {
        return percentChange;
    }

    public String toString() {
        return String.format("Date: %s | Price: %.2f | Open: %.2f | High: %.2f | Low: %.2f | Volume: %.0f | Change: %.2f%%",
                date, price, open, high, low, volume, percentChange);
    }


}
