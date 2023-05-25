import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CountryLoader {

    ArrayList<DefinitionOfCountry> countriesMoneyFormat = new ArrayList<>();

    public CountryLoader() throws Exception {
        countriesMoneyFormat = CountryLoader.load("countries.txt");
    }

    public static ArrayList<DefinitionOfCountry> load(String nameOfFile) throws Exception {
        ArrayList<DefinitionOfCountry> result = new ArrayList<DefinitionOfCountry>();
        try (BufferedReader br = new BufferedReader(new FileReader(nameOfFile))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                DefinitionOfCountry dofc = DefinitionOfCountry.fromCsv(line);
                result.add(dofc);
            }
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    public DefinitionOfCountry getCountry(String shortcutOfCountryName) throws Exception {
        for (int i = 0; i < countriesMoneyFormat.size(); i++) {
            if ((countriesMoneyFormat.get(i).getName()).matches(shortcutOfCountryName)) {
                return countriesMoneyFormat.get(i);
            }
        }
        throw new Exception("Country not found!") ;
    }

}
