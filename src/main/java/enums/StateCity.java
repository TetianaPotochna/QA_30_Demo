package enums;

public enum StateCity {
    NCR("NCR", new String[]{"Delhi","Gurgaon","Noida"}),
    UTTAR_PRADESH("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"}),
    HARYANA("Haryana", new String[]{"Karnal", "Panipat"}),
    RAJASTHAN("Rajasthan", new String[]{"Jaipur","Jaiselmer"});

    private String State;
    private String [] city;

    StateCity(String state, String[] city) {
        State = state;
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public String[] getCity() {
        return city;
    }
}
