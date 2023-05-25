public class DefinitionOfCountry {
    private int Id;
    private String name;
    private String moneySymbol;
    private int position;
    private int Decimals;
    private int dphInProcents;

    public DefinitionOfCountry(int id, String name, String moneySymbol, int position, int decimals, int dphInProcents) throws Exception {
        Id = id;
        this.name = name;
        this.moneySymbol = moneySymbol;
        this.position = position;
        Decimals = decimals;
        this.dphInProcents = dphInProcents;
    }

    public String getName() {
        return name;
    }

    public String getMoneySymbol() {
        return moneySymbol;
    }

    public int getPosition() {
        return position;
    }

    public int getDecimals() {
        return Decimals;
    }

    public int getDphInProcents() {
        return dphInProcents;
    }

    public static DefinitionOfCountry zCsv(String csv) throws Exception {
        try {
            csv = csv.trim();
            String[] radek = csv.split(";");
            DefinitionOfCountry countryDefinition = new DefinitionOfCountry(Integer.parseInt(radek[0]), radek[1], (radek[2]), Integer.parseInt(radek[3]), Integer.parseInt(radek[4]),Integer.parseInt(radek[5]));
            return countryDefinition;
        } catch (Exception e) {
            throw new Exception();
        }
    }

}
