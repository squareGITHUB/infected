package org.square.plugins.infected.descriptions.diseaseTypes;

public enum diseaseTypes {
    VIRUS(Virus.class),
    BACTERIA(Bacteria.class),
    PARASITE(Parasite.class),
    FUNGUS(Fungus.class),
    COMBUSTION(Combustion.class);

    private final Class<? extends disease> clazz;

    diseaseTypes(Class<? extends disease> clazz)
    {
        this.clazz = clazz;
    }
    public Class<? extends disease> getDisease()
    {
        return clazz;
    }
    public static diseaseTypes findDisease(String s) {
        return valueOf(s.toUpperCase());
    }
}
