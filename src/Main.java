import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("libs/SPY.csv"));
        ArrayList<Entry> data = new ArrayList<>();

        // 1) Skip header
        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
            // 2) Skip blank lines
            if (line.trim().isEmpty()) continue;

            // 3) Split out fields
            String[] parts = line.replace("\"", "").split(",");

            // 4) Guard: need at least 7 columns, and none of these critical fields empty
            if (parts.length < 7
                    || parts[1].isEmpty()
                    || parts[2].isEmpty()
                    || parts[3].isEmpty()
                    || parts[4].isEmpty()
                    || parts[5].isEmpty()
                    || parts[6].isEmpty()) {
                continue;
            }

            // 5) Parse
            String date          = parts[0];
            double price         = Double.parseDouble(parts[1]);
            double open          = Double.parseDouble(parts[2]);
            double high          = Double.parseDouble(parts[3]);
            double low           = Double.parseDouble(parts[4]);

            // volume "57.05M" → 57.05 × 1_000_000
            String  volumeStr    = parts[5].replace("M", "");
            double  volume       = Double.parseDouble(volumeStr) * 1_000_000;

            // change "%‑string" → numeric
            String  percentStr   = parts[6].replace("%", "");
            double  percentChange= Double.parseDouble(percentStr);

            data.add(new Entry(date, price, open, high, low, volume, percentChange));
        }
        reader.close();

        // 6) Reverse so index 0 is earliest date
        Collections.reverse(data);

        // 7) Print out to verify
        for (Entry e : data) {
            System.out.println(e);
        }

        
    }
}
