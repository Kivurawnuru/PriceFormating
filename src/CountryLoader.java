import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CountryLoader {

    ArrayList<DefinitionOfCountry> countriesMoneyFormat = new ArrayList<>();

    public ArrayList<DefinitionOfCountry> getCountriesMoneyFormat() {
        return countriesMoneyFormat;
    }

    public CountryLoader() throws Exception {
        countriesMoneyFormat = CountryLoader.load("countries.txt");
    }

    public static ArrayList<DefinitionOfCountry> load(String nameOfFile) throws Exception {
        ArrayList<DefinitionOfCountry> result = new ArrayList<DefinitionOfCountry>();
        try (BufferedReader br = new BufferedReader(new FileReader(nameOfFile))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                DefinitionOfCountry dofc = DefinitionOfCountry.zCsv(line);
                result.add(dofc);
            }
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    public static DefinitionOfCountry getCountry(String shortcutOfCountryName, ArrayList<DefinitionOfCountry> countries) throws Exception {
        for (int i = 0; i < countries.size(); i++) {
            if ((countries.get(i).getName()).matches(shortcutOfCountryName)) {
                return countries.get(i);
            }
        }
        throw new Exception("Country not found!") ;
    }

}
