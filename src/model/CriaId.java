package model;

public final class CriaId {
    private static CriaId instance;
    private static int count = 0;
    public String value;

    private CriaId() {
    }

    public static CriaId getInstance() {
        if (instance == null) {
            instance = new CriaId();
        }
        return instance;
    }

    public int pegaId() {
        count += 1;
        return count;
    }

}
