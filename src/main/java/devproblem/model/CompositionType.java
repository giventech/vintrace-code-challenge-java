package devproblem.model;

public enum CompositionType {
    YEAR("YEAR"),
    VARIETY("VARIETY"),
    REGION("REGION"),
    YEAR_VARIETY("YEAR_VARIETY");

    private String compositionType;

    CompositionType(String compositionType) {
        this.compositionType = compositionType;
    }

    public String getCompositionType() {
        return compositionType;
    }
}
