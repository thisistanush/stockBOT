import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("libs/SPY.csv"));
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Entry> data = new ArrayList<>();

        String line;


        while((line = reader.readLine()) != null){
            String[] parts = line.replace("\"", "").split(",");

            if (parts.length < 7) continue; // guard for bad lines

            String date = parts[0];
            double price = Double.parseDouble(parts[1]);
            double open = Double.parseDouble(parts[2]);
            double high = Double.parseDouble(parts[3]);
            double low = Double.parseDouble(parts[4]);

            // remove 'M' from volume and parse as millions
            String volumeStr = parts[5].replace("M", "");
            double volume = Double.parseDouble(volumeStr) * 1_000_000;

            // remove '%' from percent change
            String percentStr = parts[6].replace("%", "");
            double percentChange = Double.parseDouble(percentStr);

            data.add(new Entry(date, price, open, high, low, volume, percentChange));
        }
        reader.close();

        for (Entry e : data) {
            System.out.println(e);
        }
    }
}
