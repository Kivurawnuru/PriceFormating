public class DefinitionOfCountry {
    private int Id;
    private String name;
    private char moneySymbol;
    private int position;
    private int Decimals;

    public DefinitionOfCountry(int id, String name, char moneySymbol, int position, int decimals) {
        Id = id;
        this.name = name;
        this.moneySymbol = moneySymbol;
        this.position = position;
        Decimals = decimals;
    }

    public int getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public char getMoneySymbol() {
        return moneySymbol;
    }
    public int getPosition() {
        return position;
    }
    public int getDecimals() {
        return Decimals;
    }

    public void setId(int id) {
        Id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMoneySymbol(char moneySymbol) {
        this.moneySymbol = moneySymbol;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public void setDecimals(int decimals) {
        Decimals = decimals;
    }


}
