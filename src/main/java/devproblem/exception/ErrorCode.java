package devproblem.exception;

public  enum ErrorCode {
    FILE_LOAD_OR_ACCESS_ERRO("WI-00001"),
    NO_COMPOISTION_FOR_WINE_ID("WI-00002"),
    INVALID_COMPOSITION_TYPE("WI-00003");

    public final String label;

    private ErrorCode(String label) {
        this.label = label;
    }
}
